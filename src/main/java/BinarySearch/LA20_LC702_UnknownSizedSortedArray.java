interface Dictionary{
    public Integer get(int index);
}

public class UnknownSizedSortedArray {
    public int searchDictionary(Dictionary dict, int target) {
        if (dict == null || dict.get(0) == null || dict.get(0) != target || dict.get(1) == null || dict.get(1) != target) {
            return -1;
        }
        int index = 1;
        while (dict.get(index * 10) != null && dict.get(index * 10) < target) {
            index *= 10;
        }
        return binarySearch(dict, target, index, index * 10);
    }

    private int binarySearch(Dictionary dict, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (dict.get(mid) == target) {
                return mid;
            }
            if (dict.get(mid) == null || dict.get(mid) > target) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return -1;
    }
}