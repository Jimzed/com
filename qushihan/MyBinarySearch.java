package com.qushihan;

public class MyBinarySearch {

    public static int BinarySearch(int[] a, int key) {
        return BinarySearch(a, 0, a.length, key);
    }

    private static int BinarySearch(int[] a, int start, int end, int key) {
        int low = start;
        int high = end - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (a[mid] > key) {
                high = mid - 1;
            } else if (a[mid] < key) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
