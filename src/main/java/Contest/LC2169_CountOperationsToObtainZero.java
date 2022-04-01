package Contest;

public class LC2169_CountOperationsToObtainZero {

    public int countOperations(int num1, int num2) {
        int count=0;
        while(num1!=0&&num2!=0)
        {
            ++count;
            if(num1>num2)
            {
                num1-=num2;
            }
            else
            {
                num2-=num1;
            }
        }
        return count;
    }

    public int countOperations2(int num1, int num2) {
        if (num1 == 0 || num2 == 0) {
            return 0;
        }
        if (num1 == num2) {
            return 1;
        }

        if (num1 < num2) {
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }
        int count = 0;
        while (num1 % num2 != 0) {
            count += num1 / num2;
            num1 = num1 % num2;
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }
        count += num1 / num2;
        return count;
    }
}
