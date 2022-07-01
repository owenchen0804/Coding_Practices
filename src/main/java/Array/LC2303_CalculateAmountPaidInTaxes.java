package Array;

public class LC2303_CalculateAmountPaidInTaxes {
    public double calculateTax(int[][] brackets, int income) {
        double result = 0;
        if (income == 0) {
            return result;
        }
        //  i == 0
        if (income <= brackets[0][0]) {
            result += (double) (income * brackets[0][1]) / 100;
            return result;
        }
        result += (double) (brackets[0][0] * brackets[0][1]) / 100;
        //  income -= brakets[0][0];
        for (int i = 1; i < brackets.length; i++) {
            if (income <= brackets[i][0]) {
                result += (double) ((income - brackets[i - 1][0]) * brackets[i][1]) / 100;
                return result;
            }
            //  income比当前的征税点高
            result += (double) ((brackets[i][0] - brackets[i - 1][0]) * brackets[i][1]) / 100;
        }
        return result;
    }
}
