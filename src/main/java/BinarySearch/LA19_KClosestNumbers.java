package BinarySearch;

public class LA19_KClosestNumbers {
    public int[] kclosest(int[] array, int target, int k) {
        // assume array is not null or empty, k <= array.length
        int closest = findClosest(array, target);
        int[] result = new int[k];
        int left = closest, right = closest + 1;
        for (int i = 0; i < k; i++) {   //  谁小移谁
            if (right >= array.length || left >= 0 && Math.abs(array[left] - target) <= Math.abs(array[right] - target)) {
                result[i] = array[left--];
            }
            else {
                result[i] = array[right++];
            }
        }
        return result;
    }

    private int findClosest(int[] array, int target) {
        int left = 0, right = array.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            }
            if (array[mid] < target) {
                left = mid; // 找最近，这个可能符合，不能+1 rule out the answer
            }
            else {
                right = mid; // 同理如上
            }
        }
        if (Math.abs(array[left] - target) <= Math.abs(array[right] - target)) {
            return left;
        }
        return right;
    }
}