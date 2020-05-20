// Made with Blockbench 3.5.2
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class Modeldemonfox3 extends EntityModel<Entity> {
	private final ModelRenderer body;
	private final ModelRenderer head;
	private final ModelRenderer Teeth;
	private final ModelRenderer Spikes;
	private final ModelRenderer leg0;
	private final ModelRenderer leg1;
	private final ModelRenderer leg2;
	private final ModelRenderer leg3;
	private final ModelRenderer tail;

	public Modeldemonfox3() {
		textureWidth = 64;
		textureHeight = 64;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 16.0F, 0.0F);
		setRotationAngle(body, 1.5708F, 0.0F, 0.0F);
		body.setTextureOffset(0, 0).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 11.0F, 6.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 16.0F, -3.0F);
		head.setTextureOffset(0, 17).addBox(-4.0F, -2.0F, -6.0F, 8.0F, 6.0F, 6.0F, 0.0F, false);
		head.setTextureOffset(20, 29).addBox(-4.0F, -4.0F, -5.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(22, 19).addBox(2.0F, -4.0F, -5.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(22, 14).addBox(-2.0F, 2.0F, -9.0F, 4.0F, 2.0F, 3.0F, 0.0F, false);
		head.setTextureOffset(0, 12).addBox(-4.0F, -2.0F, -6.0F, 8.0F, 6.0F, 6.0F, 0.0F, false);

		Teeth = new ModelRenderer(this);
		Teeth.setRotationPoint(-1.0F, 5.0F, -9.0F);
		head.addChild(Teeth);
		Teeth.setTextureOffset(36, 19).addBox(2.0F, -2.0F, 0.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		Teeth.setTextureOffset(36, 23).addBox(-1.0F, -2.0F, 0.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		Spikes = new ModelRenderer(this);
		Spikes.setRotationPoint(2.0F, -3.0F, 2.0F);
		head.addChild(Spikes);
		setRotationAngle(Spikes, 1.5708F, 0.0F, 0.0F);

		leg0 = new ModelRenderer(this);
		leg0.setRotationPoint(-3.0F, 18.0F, 6.0F);
		leg0.setTextureOffset(8, 29).addBox(-0.005F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		leg1 = new ModelRenderer(this);
		leg1.setRotationPoint(1.0F, 18.0F, 6.0F);
		leg1.setTextureOffset(0, 29).addBox(0.005F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		leg2 = new ModelRenderer(this);
		leg2.setRotationPoint(-3.0F, 18.0F, -1.0F);
		leg2.setTextureOffset(28, 19).addBox(-0.005F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		leg3 = new ModelRenderer(this);
		leg3.setRotationPoint(1.0F, 18.0F, -1.0F);
		leg3.setTextureOffset(26, 27).addBox(0.005F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		tail = new ModelRenderer(this);
		tail.setRotationPoint(0.0F, 16.0F, 7.0F);
		setRotationAngle(tail, 1.5708F, 0.0F, 0.0F);
		tail.setTextureOffset(24, 0).addBox(-2.0F, 1.0F, -1.25F, 4.0F, 9.0F, 3.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		leg0.render(matrixStack, buffer, packedLight, packedOverlay);
		leg1.render(matrixStack, buffer, packedLight, packedOverlay);
		leg2.render(matrixStack, buffer, packedLight, packedOverlay);
		leg3.render(matrixStack, buffer, packedLight, packedOverlay);
		tail.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.leg0.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.leg1.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.leg2.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.leg3.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
	}
}