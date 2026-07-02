public class FinancialForecast {


    public static double predictFutureValue(double presentValue,
                                            double growthRate,
                                            int years) {


        if (years == 0) {
            return presentValue;
        }

        return predictFutureValue(
                presentValue,
                growthRate,
                years - 1
        ) * (1 + growthRate);
    }

    public static void main(String[] args) {

        double presentValue = 10000;
        double growthRate = 0.08; 
        int years = 5;

        double futureValue =
                predictFutureValue(
                        presentValue,
                        growthRate,
                        years);

        System.out.printf(
                "Predicted Future Value after %d years: %.2f%n",
                years,
                futureValue);
    }
}