package Question3;

public class Question3 {
	public static void main(String[] args) {
		Claim newClaim = new Claim();
		newClaim.intField = 1;
		processClaim(newClaim);
		System.out.println(newClaim.intField);
	}

	private static void processClaim(Claim aClaim) {
		aClaim.intField = 2;
	}
}
