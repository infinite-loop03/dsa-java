package com.dsa.patterns.greedy;

import java.util.ArrayList;
import java.util.Arrays;

public class JobSequencing {

    public static void main(String[] args) {
        JobSequencing jobSequencing = new JobSequencing();
        int[] deadline = {2, 2, 2, 2, 2};
        int[] profit = {100, 19, 27, 25, 15};
        System.out.println(jobSequencing.jobSequencing(deadline, profit));
    }

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int n = deadline.length;
        int maxJobs = 0;
        int[][] jobAndProfit = new int[n][2];

        for (int i = 0; i < n; i++) {
            jobAndProfit[i][0] = deadline[i];
            jobAndProfit[i][1] = profit[i];
            maxJobs = Math.max(maxJobs, deadline[i]);
        }

        Arrays.sort(jobAndProfit, (a, b) -> Integer.compare(b[1], a[1]));

        int[] jobs = new int[maxJobs];
        Arrays.fill(jobs, -1);

        int maxProfit = 0;
        int noOfJobs = 0;

        for (int[] job : jobAndProfit) {
            int index = job[0];
            while (index > 0) {
                if (jobs[index - 1] == -1) {
                    jobs[index - 1] = job[1];
                    noOfJobs++;
                    maxProfit += job[1];
                    break;
                }
                index--;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(noOfJobs);
        result.add(maxProfit);

        return result;
    }

}
