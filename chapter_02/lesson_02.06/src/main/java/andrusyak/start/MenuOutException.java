package andrusyak.start;

class MenuOutException extends RuntimeException {
	public MenuOutException() {
		super("Out of menu range.");
	}
}