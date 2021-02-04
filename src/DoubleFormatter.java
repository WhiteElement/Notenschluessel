import java.text.DecimalFormat;

public class DoubleFormatter {

    public static double singleDec(double num) {
        DecimalFormat df = new DecimalFormat("###.#");
        return Double.parseDouble(df.format(num));
    }
}
