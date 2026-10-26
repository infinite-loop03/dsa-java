package com.dsa.patterns.binarysearch;

import java.util.Arrays;

public class MagneticForceBetweenTwoBalls {

    static void main() {
        MagneticForceBetweenTwoBalls magneticForceBetweenTwoBalls = new MagneticForceBetweenTwoBalls();
        int[] position = {5, 4, 3, 2, 1, 1000000000};
        int m = 2;
        System.out.println(magneticForceBetweenTwoBalls.maxDistance(position, m));
    }

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int low = 1;
        int high = position[position.length - 1] - position[0];

        while (low < high) {
            int mid = low + (high - low + 1) / 2;

            if (canPosition(mid, position, m)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }

        return low;

    }

    private boolean canPosition(int mid, int[] position, int m) {
        int count = 1;

        int last = position[0];
        for (int i = 1; i < position.length; i++) {
            if (position[i] - last >= mid) {
                count++;
                last = position[i];
                if (count >= m) return true;
            }
        }
        return count >= m;
    }
}
