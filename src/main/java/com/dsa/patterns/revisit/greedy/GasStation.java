package com.dsa.patterns.revisit.greedy;

public class GasStation {

    public static void main(String[] args) {
        GasStation gasStation = new GasStation();
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println(gasStation.canCompleteCircuit(gas, cost));
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        for (int j : gas) totalGas += j;
        for (int c : cost) totalCost += c;

        if (totalCost > totalGas) return -1;


        int totalTank = 0;
        int startingPoint = 0;

        for (int i = 0; i < gas.length; i++) {
            totalTank += gas[i] - cost[i];

            if (totalTank < 0) {
                startingPoint = i + 1;
                totalTank = 0;
            }
        }
        return startingPoint;
    }
}
