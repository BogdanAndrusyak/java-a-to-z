package andrusyak;

/**
 * TODO: comment.
 */
public class EngineerCalculator extends Calculator {

    public void sin(double degrees) {
        this.result = Math.sin(Math.toRadians(degrees));
    }

    public void cos(double degrees) {
        this.result = Math.cos(Math.toRadians(degrees));
    }
}
