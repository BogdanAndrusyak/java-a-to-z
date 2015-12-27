package home14;

public class CubeFunction {
	int a;
	int b;
	int c;

	public CubeFunction(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public float calculate(int x) {
		return a * x * x + b * x + c;
	}
}