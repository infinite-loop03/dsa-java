package com.dsa.patterns.revisit;

public class TaskScheduler {

    public static void main(String[] args) {
        TaskScheduler taskScheduler = new TaskScheduler();
        char[] tasks = {'A','A','A','B','B','B'};
        int n = 2;
        System.out.println(taskScheduler.leastInterval(tasks, n));
    }

    public int leastInterval(char[] tasks, int n) {
        int[] frequencies = new int[26];

        for (char task : tasks) {
            frequencies[task - 'A']++;
        }

        int maxFreq = 0;
        int maxFreqCount = 0;

        for (int freq : frequencies) {
            if (freq > maxFreq) {
                maxFreq = freq;
                maxFreqCount = 1;
            } else if (freq == maxFreq) {
                maxFreqCount++;
            }
        }

        int minimumTime = maxFreq + (maxFreq - 1) * n + (maxFreqCount - 1);

        return Math.max(tasks.length, minimumTime);
    }
}
