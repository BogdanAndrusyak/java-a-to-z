package coordinate;

public class Area {
	public static void main(String[] args) {
		Point p1 = Point(1, 2);
		Point p2 = Point(1, 2);
		Point p3 = Point(1, 2);

		double area = 0;

		double a = side(p1, p2);
		double b = side(p1, p3);
		double c = side(p2, p3);

		if (a + b <= c || a + c <= b || b + c <= a) {
			System.out.println("Triangle doesn't exist");
		} else {
			area = Math.abs(((p2.x - p1.x) * (p3.y - p1.y) - (p3.x - p1.x) * (p2.y - p1.y)) / 2);
			System.out.println("Area = " + area);
		}
	}

	public static double side(Point p1, Point p2) {
		return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y)); 
	}
}