package com.dsa.patterns.dailyquestion;

public class AngleBetweenHandsOfAClock {

    public static void main(String[] args) {
        AngleBetweenHandsOfAClock angleBetweenHandsOfAClock = new AngleBetweenHandsOfAClock();
        System.out.println(angleBetweenHandsOfAClock.angleClock(12, 30));
    }

    public double angleClock(int hour, int minutes) {
        double hourAngle = (hour % 12) * 30 + minutes * 0.5;
        double minutesAngle = minutes * 6;

        double diff = Math.abs(hourAngle - minutesAngle);

        return Math.min(diff, 360 - diff);
    }
}
