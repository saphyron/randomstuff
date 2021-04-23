package trekantmodel;

public class Trekant {
	
	private int width;
	
	public Trekant (int aWidth) {
		width = aWidth;
	}
	
	public int getArea() {
		if (width <= 0) {
			return 0;
		} else if (width == 1) {
			return 1;
		} else {
			Trekant lilleTrekant = new Trekant(width - 1);
			int lilleArea = lilleTrekant.getArea();
			return lilleArea + width;
		}
	}

}
