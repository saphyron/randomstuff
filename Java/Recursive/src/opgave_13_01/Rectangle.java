package opgave_13_01;

public class Rectangle {
	
	private int width;
	private int height;
	
	public Rectangle(int x, int y) {
		width = x;
		height = y;
	}
	
//	public int getArea() {
//		if (width <= 0 || height <= 0) {
//			return 0;
//		} else if (width == height && width == 1) {
//			return height * width;
//		} else if (width == 1) {
//			return height;
//		} else if (height == 1) {
//			return width;
//		} else {
//			Rectangle smallRectangle = new Rectangle(width - 1, height);
//			int smallArea = smallRectangle.getArea();
//			return smallArea;
//		}
	
	public int getArea() {
		if (width == 1) {
			return height;
		} else {
			Rectangle r1 = new Rectangle(width - 1, height);
			return height + r1.getArea();
		}
	}

}
