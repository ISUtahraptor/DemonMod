
package net.mcreator.demonmod.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.mcreator.demonmod.DemonmodModElements;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@DemonmodModElements.ModElement.Tag
public class DemonfoxEntity extends DemonmodModElements.ModElement {
	public static EntityType entity = null;
	public DemonfoxEntity(DemonmodModElements instance) {
		super(instance, 37);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 1.8f)).build("demonbear")
						.setRegistryName("demonbear");
		elements.entities.add(() -> entity);
		elements.items
				.add(() -> new SpawnEggItem(entity, -6750208, -13261, new Item.Properties().group(ItemGroup.MISC)).setRegistryName("demonbear"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			boolean biomeCriteria = false;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("demonmod:demonbiome")))
				biomeCriteria = true;
			if (!biomeCriteria)
				continue;
			biome.getSpawns(EntityClassification.MONSTER).add(new Biome.SpawnListEntry(entity, 26, 3, 30));
		}
		EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				MonsterEntity::canMonsterSpawn);
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new Modeldemonbear(), 0.5f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("demonmod:textures/demonbear.png");
				}
			};
		});
	}
	public static class CustomEntity extends MonsterEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 5;
			setNoAI(false);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.goalSelector.addGoal(1, new RandomWalkingGoal(this, 1));
			this.goalSelector.addGoal(2, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(3, new SwimGoal(this));
			this.goalSelector.addGoal(4, new LeapAtTargetGoal(this, (float) 0.8));
			this.goalSelector.addGoal(5, new PanicGoal(this, 1.2));
			this.targetSelector.addGoal(6, new HurtByTargetGoal(this));
			this.goalSelector.addGoal(7, new MeleeAttackGoal(this, 1.2, false));
			this.targetSelector.addGoal(8, new HurtByTargetGoal(this));
			this.goalSelector.addGoal(9, new RandomWalkingGoal(this, 0.8));
			this.goalSelector.addGoal(10, new LookRandomlyGoal(this));
			this.targetSelector.addGoal(11, new NearestAttackableTargetGoal(this, PlayerEntity.class, false, false));
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
			super.dropSpecialItems(source, looting, recentlyHitIn);
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
		}

		@Override
		protected float getSoundVolume() {
			return 1.0F;
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3);
		}
	}

	public static class Modeldemonbear extends EntityModel<Entity> {
		private final ModelRenderer body;
		private final ModelRenderer head;
		private final ModelRenderer leg0;
		private final ModelRenderer leg1;
		private final ModelRenderer leg2;
		private final ModelRenderer leg3;
		private final ModelRenderer bone;
		public Modeldemonbear() {
			textureWidth = 128;
			textureHeight = 128;
			body = new ModelRenderer(this);
			body.setRotationPoint(-2.0F, 9.0F, 12.0F);
			setRotationAngle(body, 1.5708F, 0.0F, 0.0F);
			body.setTextureOffset(0, 0).addBox(-5.0F, -13.0F, -7.0F, 14.0F, 14.0F, 11.0F, 0.0F, false);
			body.setTextureOffset(0, 25).addBox(-4.0F, -25.0F, -7.0F, 12.0F, 12.0F, 10.0F, 0.0F, false);
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, 10.0F, -16.0F);
			head.setTextureOffset(0, 47).addBox(-3.5F, -3.0F, -3.0F, 7.0F, 7.0F, 7.0F, 0.0F, false);
			head.setTextureOffset(39, 0).addBox(-2.5F, 1.0F, -6.0F, 5.0F, 3.0F, 3.0F, 0.0F, false);
			head.setTextureOffset(0, 28).addBox(-4.5F, -4.0F, -1.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
			head.setTextureOffset(0, 25).addBox(2.5F, -4.0F, -1.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
			head.setTextureOffset(4, 0).addBox(2.0F, -12.0F, 1.0F, 1.0F, 9.0F, 1.0F, 0.0F, false);
			head.setTextureOffset(0, 0).addBox(-3.0F, -12.0F, 1.0F, 1.0F, 9.0F, 1.0F, 0.0F, false);
			leg0 = new ModelRenderer(this);
			leg0.setRotationPoint(-4.5F, 14.0F, 6.0F);
			leg0.setTextureOffset(42, 17).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 10.0F, 8.0F, 0.0F, false);
			leg1 = new ModelRenderer(this);
			leg1.setRotationPoint(4.5F, 14.0F, 6.0F);
			leg1.setTextureOffset(36, 39).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 10.0F, 8.0F, 0.0F, false);
			leg2 = new ModelRenderer(this);
			leg2.setRotationPoint(-3.5F, 14.0F, -8.0F);
			leg2.setTextureOffset(54, 54).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 10.0F, 6.0F, 0.0F, false);
			leg3 = new ModelRenderer(this);
			leg3.setRotationPoint(3.5F, 14.0F, -8.0F);
			leg3.setTextureOffset(50, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 10.0F, 6.0F, 0.0F, false);
			bone = new ModelRenderer(this);
			bone.setRotationPoint(-5.5F, -7.0F, -7.0F);
			leg3.addChild(bone);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			body.render(matrixStack, buffer, packedLight, packedOverlay);
			head.render(matrixStack, buffer, packedLight, packedOverlay);
			leg0.render(matrixStack, buffer, packedLight, packedOverlay);
			leg1.render(matrixStack, buffer, packedLight, packedOverlay);
			leg2.render(matrixStack, buffer, packedLight, packedOverlay);
			leg3.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.leg0.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.leg1.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.leg2.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.leg3.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		}
	}
}
