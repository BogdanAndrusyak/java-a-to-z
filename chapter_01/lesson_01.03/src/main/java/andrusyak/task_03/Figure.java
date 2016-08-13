package andrusyak.task_03;

import andrusyak.task_01.Point;

/**
 * TODO: comment.
 * Created by Bogdan on 8/12/2016.
 */
public class Figure {
    Point[] points;

    public Figure(Point[] points) {
        this.points = points;
    }

    public double calculateSide(Point p1, Point p2) {
        return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
    }

    public double max() {
        double maxSide = 0;

        for(int i = 0; i < points.length-1; i++) {
            double side = calculateSide(points[i],  points[i+1]);
            if(side > maxSide) {
                maxSide = side;
            }
        }

        double sideLast = calculateSide(points[0],  points[points.length-1]);

        if(sideLast > maxSide)
            maxSide = sideLast;

        return maxSide;
    }
}
