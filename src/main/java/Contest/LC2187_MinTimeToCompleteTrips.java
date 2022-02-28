package Contest;

import java.util.Arrays;

public class LC2187_MinTimeToCompleteTrips {
    public long minimumTime(int[] time, int totalTrips) {
        Arrays.sort(time);
        long left = 1;
        long right = time[0] * totalTrips;
        while (left < right) {
            long mid = left + (right - left) / 2;
            // if (sum(time, mid) == totalTrips) {
            //     return mid;
            // }
            if (sum(time, mid) < totalTrips) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        return left;
    }

    private long sum(int[] time, long mid) {
        long sum = 0;
        for (int t : time) {
            sum += mid / t;
        }
        return sum;
    }
    public static void main(String[] args) {
        LC2187_MinTimeToCompleteTrips test = new LC2187_MinTimeToCompleteTrips();
        int[] arr = {10};
        test.minimumTime(arr, 100);

    }
}
