/* A program to print a fraction in decimal format, for a number of decimal places, taken as input. 
   Output will be in string format, deal with it.*/

public class DecimalPlaces {
    static String print(int num, int den, int n) { // num is numerator, den is denominator, n is number of decimal places
        int r, q;
        String s = "";
        boolean firstTime = true;
        if (den == 0)
            return "Error";
        for (int i = 0; i <= n; i++) {
            q = num / den;
            if (!firstTime) {
                s = s.concat(Integer.toString(q));
                r = (num % den) * 10;
                num = r;
            } else {
                s = s.concat(q + ".");
                firstTime = false;
                r = (num % den) * 10;
                num = r;
            }
        }
        return s;
    }
}