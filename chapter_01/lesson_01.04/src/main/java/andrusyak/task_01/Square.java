package andrusyak.task_01;

/**
 * TODO: comment.
 * Created by Bogdan on 8/13/2016.
 */
public class Square {
    private int a;
    private int b;
    private int c;

    public Square(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    float calculate(int x) {
        return this.a * x * x + this.b * x + this.c;
    }

    void show(int start, int finish, int step) {
        for (int i = start; i <= finish; i += step) {
            System.out.println(calculate(i));
        }
    }
}
