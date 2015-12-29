package home13;

public class TriangleInit {

	public static void main(String[] args) throws Exception {
		
		Point first = new Point(1, 3);
		Point second = new Point(1, 2);
		Point third = new Point(4, 7);

		Triangle triangle = new Triangle(first, second, third);

		System.out.println("Area = " + triangle.calculateArea());
	}
}