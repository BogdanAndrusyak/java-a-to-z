package home12_2;

class MenuOutException extends RuntimeException {
    public MenuOutException() {
        super("Out of menu range.");
    }
}
