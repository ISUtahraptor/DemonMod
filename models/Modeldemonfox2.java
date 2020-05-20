
public static class Modeldemonfox2 extends EntityModel {
	private final ModelRenderer body;
	private final ModelRenderer head;
	private final ModelRenderer Teeth;
	private final ModelRenderer Spikes;
	private final ModelRenderer leg0;
	private final ModelRenderer leg1;
	private final ModelRenderer leg2;
	private final ModelRenderer leg3;
	private final ModelRenderer tail;

	public Modeldemonfox2() {
		textureWidth = 64;
		textureHeight = 64;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 16.0F, 0.0F);
		setRotationAngle(body, 1.5708F, 0.0F, 0.0F);
		body.cubeList.add(new ModelBox(body, 0, 0, -3.0F, -3.0F, -3.0F, 6, 11, 6, 0.0F, false));

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 16.0F, -3.0F);
		head.cubeList.add(new ModelBox(head, 0, 17, -4.0F, -2.0F, -6.0F, 8, 6, 6, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 0, 3, -4.0F, -4.0F, -5.0F, 2, 2, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 0, 0, 2.0F, -4.0F, -5.0F, 2, 2, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 18, 0, -2.0F, 2.0F, -9.0F, 4, 2, 3, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 0, 12, -4.0F, -2.0F, -6.0F, 8, 6, 6, 0.0F, false));

		Teeth = new ModelRenderer(this);
		Teeth.setRotationPoint(-1.0F, 5.0F, -9.0F);
		head.addChild(Teeth);
		Teeth.cubeList.add(new ModelBox(Teeth, 19, 32, 2.0F, -2.0F, 0.0F, 1, 3, 1, 0.0F, false));
		Teeth.cubeList.add(new ModelBox(Teeth, 32, 0, -1.0F, -2.0F, 0.0F, 1, 3, 1, 0.0F, false));

		Spikes = new ModelRenderer(this);
		Spikes.setRotationPoint(2.0F, -3.0F, 2.0F);
		head.addChild(Spikes);
		Spikes.cubeList.add(new ModelBox(Spikes, 32, 10, -4.0F, -2.0F, 0.0F, 1, 3, 1, 0.0F, false));
		Spikes.cubeList.add(new ModelBox(Spikes, 30, 17, -4.0F, -3.0F, 2.0F, 1, 4, 1, 0.0F, false));
		Spikes.cubeList.add(new ModelBox(Spikes, 16, 29, -4.0F, -3.0F, 4.0F, 1, 4, 1, 0.0F, false));
		Spikes.cubeList.add(new ModelBox(Spikes, 32, 7, -4.0F, -2.0F, 6.0F, 1, 3, 1, 0.0F, false));
		Spikes.cubeList.add(new ModelBox(Spikes, 31, 4, -1.0F, -2.0F, 6.0F, 1, 3, 1, 0.0F, false));
		Spikes.cubeList.add(new ModelBox(Spikes, 28, 13, -1.0F, -3.0F, 4.0F, 1, 4, 1, 0.0F, false));
		Spikes.cubeList.add(new ModelBox(Spikes, 0, 17, -1.0F, -3.0F, 2.0F, 1, 4, 1, 0.0F, false));
		Spikes.cubeList.add(new ModelBox(Spikes, 30, 21, -1.0F, -2.0F, 0.0F, 1, 3, 1, 0.0F, false));

		leg0 = new ModelRenderer(this);
		leg0.setRotationPoint(-3.0F, 18.0F, 6.0F);
		leg0.cubeList.add(new ModelBox(leg0, 8, 29, -0.005F, 0.0F, -1.0F, 2, 6, 2, 0.0F, false));

		leg1 = new ModelRenderer(this);
		leg1.setRotationPoint(1.0F, 18.0F, 6.0F);
		leg1.cubeList.add(new ModelBox(leg1, 0, 29, 0.005F, 0.0F, -1.0F, 2, 6, 2, 0.0F, false));

		leg2 = new ModelRenderer(this);
		leg2.setRotationPoint(-3.0F, 18.0F, -1.0F);
		leg2.cubeList.add(new ModelBox(leg2, 24, 5, -0.005F, 0.0F, -1.0F, 2, 6, 2, 0.0F, false));

		leg3 = new ModelRenderer(this);
		leg3.setRotationPoint(1.0F, 18.0F, -1.0F);
		leg3.cubeList.add(new ModelBox(leg3, 22, 15, 0.005F, 0.0F, -1.0F, 2, 6, 2, 0.0F, false));

		tail = new ModelRenderer(this);
		tail.setRotationPoint(0.0F, 16.0F, 7.0F);
		setRotationAngle(tail, 1.5708F, 0.0F, 0.0F);
		tail.cubeList.add(new ModelBox(tail, 23, 24, -2.0F, 1.0F, -2.25F, 4, 9, 5, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		body.render(f5);
		head.render(f5);
		leg0.render(f5);
		leg1.render(f5);
		leg2.render(f5);
		leg3.render(f5);
		tail.render(f5);
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