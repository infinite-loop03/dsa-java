package com.dsa.patterns.weeklycontest.weeklycontest515;

public class NearestAvailableDrone {

    public static void main(String[] args) {
        NearestAvailableDrone nearestAvailableDrone = new NearestAvailableDrone();
        int[][] drones = {
                {2, 9, 3},
                {-25, 0, 15}
        };
        int[] target = {-25, -15};
        System.out.println(nearestAvailableDrone.nearestDrone(drones, target));
    }

    public int nearestDrone(int[][] drones, int[] target) {
        int minDistance = Integer.MAX_VALUE;
        int index = -1;

        for (int i = 0; i < drones.length; i++) {
            int distance = Math.abs(target[0] - drones[i][0]) + Math.abs(target[1] - drones[i][1]);
            if (distance <= drones[i][2]) {
                if (distance < minDistance) {
                    minDistance = distance;
                    index = i;
                }
            }
        }

        return index;
    }
}
