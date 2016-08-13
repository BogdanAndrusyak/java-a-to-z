package andrusyak.task_02;

import andrusyak.task_01.Point;
import andrusyak.task_01.Triangle;

/**
 * TODO: comment.
 * Created by Bogdan on 8/13/2016.
 */
public class MaxSideForTriangle {
    private Triangle triangle;

    public MaxSideForTriangle(Triangle triangle) {
        this.triangle = triangle;
    }

    public double max() {
        double maxSide = 0;
        double side1 = calculateSide(triangle.first, triangle.second);
        double side2 = calculateSide(triangle.first, triangle.third);
        double side3 = calculateSide(triangle.second, triangle.third);

        if(side1 > side2 && side1 > side3) {
            maxSide = side1;
        } else if(side2 > side3 && side2 > side1) {
            maxSide = side2;
        } else if(side3 > side1 && side3 > side2) {
            maxSide = side3;
        }
        return maxSide;
    }

    public double calculateSide(Point p1, Point p2) {
        return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
    }
}
