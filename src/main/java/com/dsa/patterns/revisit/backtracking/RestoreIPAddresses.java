package com.dsa.patterns.revisit.backtracking;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {

    public static void main(String[] args) {
        RestoreIPAddresses restoreIPAddresses = new RestoreIPAddresses();
        System.out.println(restoreIPAddresses.restoreIpAddresses("0000"));
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int start, List<String> segments, List<String> result) {
        if (start == s.length() && segments.size() == 4) {
            result.add(String.join(".", segments));
            return;
        }

        if (segments.size() == 4 || start == s.length()) return;

        int remainingChars = s.length() - start;
        int remainingSegments = 4 - segments.size();

        if (remainingChars < remainingSegments ||
                remainingChars > remainingSegments * 3) {
            return;
        }

        for (int end = start; end < Math.min(start + 3, s.length()); end++) {
            if (!isValidSegment(s, start, end)) break;

            segments.add(s.substring(start, end + 1));
            backtrack(s, end + 1, segments, result);
            segments.removeLast();
        }
    }

    private boolean isValidSegment(String s, int start, int end) {
        int len = end - start + 1;
        if (len > 3) return false;
        if (len > 1 && s.charAt(start) == '0') return false;
        int value = Integer.parseInt(s.substring(start, end + 1));
        return value <= 255;
    }
}
