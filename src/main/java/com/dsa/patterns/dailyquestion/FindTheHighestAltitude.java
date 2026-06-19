package com.dsa.patterns.dailyquestion;

public class FindTheHighestAltitude {

    public static void main(String[] args) {
        FindTheHighestAltitude findTheHighestAltitude = new FindTheHighestAltitude();
        int[] gain = {44, 32, -9, 52, 23, -50, 50, 33, -84, 47, -14, 84, 36, -62, 37, 81, -36, -85, -39, 67, -63, 64, -47, 95, 91, -40, 65, 67, 92, -28, 97, 100, 81};
        System.out.println(findTheHighestAltitude.largestAltitude(gain));
    }

    public int largestAltitude(int[] gain) {
        int largestAltitude = 0;
        int sum = 0;

        for (int j : gain) {
            sum = sum + j;
            largestAltitude = Math.max(largestAltitude, sum);
        }
        return largestAltitude;
    }
}
