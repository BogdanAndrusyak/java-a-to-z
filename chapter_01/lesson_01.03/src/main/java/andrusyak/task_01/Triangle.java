package andrusyak.task_01;

public class Triangle {

	public Point first;
	public Point second;
	public Point third;

	public Triangle(Point first, Point second, Point third) {
		this.first = first;
		this.second = second;
		this.third = third;
	}

	public double calculateArea() throws Exception {

		double area = 0;

		double side1 = calculateSide(first, second);
		double side2 = calculateSide(first, third);
		double side3 = calculateSide(second, third);

		if (side1 + side2 <= side3 || side1 + side3 <= side2 || side2 + side3 <= side1) {
			System.out.println("Triangle doesn't exist!");
		} else {
			area = Math.abs(((second.x - first.x) * (third.y - first.y) - (third.x - first.x) * (second.y - first.y)) / 2);
		}

		return area;
	} 

	public double calculateSide(Point p1, Point p2) {
		return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y)); 
	}
}