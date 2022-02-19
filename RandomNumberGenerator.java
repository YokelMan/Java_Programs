public class RandomNumberGenerator {
    /**Returns an integer value between the parameters lowerLimit and upperLimit.
     * The scope of the returned random number includes both the arguments given.**/

    // to return an int random number
    static int generate(int lowerLimit, int upperLimit) {
        return (int) ((Math.random() * ((upperLimit - lowerLimit) + 1)) + lowerLimit);
    }
    // to return a double random number
    static double generate(double lowerLimit, double upperLimit) {
        return ((Math.random() * ((upperLimit - lowerLimit) + 1)) + lowerLimit);
    }
}
