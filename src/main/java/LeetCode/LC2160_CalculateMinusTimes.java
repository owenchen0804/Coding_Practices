package LeetCode;

public class LC2160_CalculateMinusTimes {
    public int countOperations(int num1, int num2) {
        int cnt = 0;
        while (Math.min(num1, num2) > 0) {
            if (num1 < num2) {
                int tmp = num1;
                num1 = num2;
                num2 = tmp;
            }
            cnt += num1 / num2;
            num1 %= num2;
        }
        return cnt;
    }

    //  这里是int之间的primitive type数据交换，不能放到helper method里面，因为传的也是copy，本身
    //  没有被改变！！

//    private void swap(int a, int b) {
//        int temp = a;
//        a = b;
//        b = temp;
//    }

    public static void main(String[] args) {
        LC2160_CalculateMinusTimes test = new LC2160_CalculateMinusTimes();
        System.out.println(test.countOperations(2, 3));
    }
}
