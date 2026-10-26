package com.dsa.patterns.revision.binarysearch;

public class FirstBadVersion {

    static void main() {
        FirstBadVersion firstBadVersion = new FirstBadVersion();
        int n = 2;
        System.out.println(firstBadVersion.firstBadVersion(n));
    }

    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (isBadVersion(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean isBadVersion(int mid) {
        return false;
    }

}
