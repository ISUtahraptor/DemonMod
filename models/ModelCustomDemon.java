public static class ModelCustomDemon extends EntityModel {
	private final RendererModel Head;
	private final RendererModel LeftEar;
	private final RendererModel RightEar;
	private final RendererModel Body;
	private final RendererModel RightArm;
	private final RendererModel LeftArm;
	private final RendererModel RightLeg;
	private final RendererModel LeftLeg;

	public ModelCustomDemon() {
		textureWidth = 128;
		textureHeight = 64;

		Head = new RendererModel(this);
		Head.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(Head, 0.0524F, 0.0873F, 0.0F);
		Head.cubeList.add(new ModelBox(Head, 0, 0, -5.0F, -8.0F, -4.0F, 10, 8, 8, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 31, 1, -2.0F, -4.0F, -5.0F, 4, 4, 1, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 2, 0, -3.0F, -2.0F, -5.0F, 1, 2, 1, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 2, 4, 2.0F, -2.0F, -5.0F, 1, 2, 1, 0.0F, false));

		LeftEar = new RendererModel(this);
		LeftEar.setRotationPoint(4.5F, -6.0F, 0.0F);
		Head.addChild(LeftEar);
		setRotationAngle(LeftEar, 0.0F, 0.0F, -0.4363F);
		LeftEar.cubeList.add(new ModelBox(LeftEar, 57, 38, 0.0F, 0.0F, -2.0F, 1, 5, 4, 0.0F, false));

		RightEar = new RendererModel(this);
		RightEar.setRotationPoint(-4.5F, -6.0F, 0.0F);
		Head.addChild(RightEar);
		setRotationAngle(RightEar, 0.0F, 0.0F, 0.4363F);
		RightEar.cubeList.add(new ModelBox(RightEar, 57, 22, -1.0F, 0.0F, -2.0F, 1, 5, 4, 0.0F, false));

		Body = new RendererModel(this);
		Body.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.cubeList.add(new ModelBox(Body, 16, 16, -4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F, false));

		RightArm = new RendererModel(this);
		RightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
		setRotationAngle(RightArm, -0.1745F, 0.0F, 0.0F);
		RightArm.cubeList.add(new ModelBox(RightArm, 40, 16, -3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F, false));

		LeftArm = new RendererModel(this);
		LeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
		setRotationAngle(LeftArm, 0.2094F, 0.0F, 0.0F);
		LeftArm.cubeList.add(new ModelBox(LeftArm, 32, 48, -1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F, false));

		RightLeg = new RendererModel(this);
		RightLeg.setRotationPoint(-1.9F, 12.0F, 0.0F);
		setRotationAngle(RightLeg, 0.192F, 0.0F, 0.0349F);
		RightLeg.cubeList.add(new ModelBox(RightLeg, 0, 16, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F, false));

		LeftLeg = new RendererModel(this);
		LeftLeg.setRotationPoint(1.9F, 12.0F, 0.0F);
		setRotationAngle(LeftLeg, -0.1745F, 0.0F, -0.0349F);
		LeftLeg.cubeList.add(new ModelBox(LeftLeg, 16, 48, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		Head.render(f5);
		Body.render(f5);
		RightArm.render(f5);
		LeftArm.render(f5);
		RightLeg.render(f5);
		LeftLeg.render(f5);
	}

	public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
	}
}