package model;

public class Model_01 {

	private Enum Enum;

	public Model_01(Enum Enum) {
		super();
		this.Enum = Enum;
	}

	public Enum getEnum() {
		return Enum;
	}

	public void setEnum(Enum enum1) {
		Enum = enum1;
	}

	@Override
	public String toString() {
		return "Model_01 [Enum=" + Enum + "]";
	}

	

}
