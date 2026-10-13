package com.dsa.patterns.revision.binarysearch;

public class SquareRoot {

    static void main() {
        SquareRoot squareRoot = new SquareRoot();
        int x = 8;
        System.out.println(squareRoot.mySqrt(x));
    }

    public int mySqrt(int x) {
        int low = 1;
        int high = x;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (mid == x / mid) return mid;

            if (mid > x / mid) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }
}
