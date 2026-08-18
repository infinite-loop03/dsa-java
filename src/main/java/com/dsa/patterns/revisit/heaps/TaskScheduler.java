package com.dsa.patterns.revisit.heaps;

public class TaskScheduler {

    public static void main(String[] args) {
        TaskScheduler taskScheduler = new TaskScheduler();
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        System.out.println(taskScheduler.leastInterval(tasks, n));
    }

    public int leastInterval(char[] tasks, int n) {
        int[] freqMap = new int[26];

        int maxFreq = 0;
        int maxFreqCount = 0;

        for (char task : tasks) {
            freqMap[task - 'A']++;
            maxFreq = Math.max(maxFreq, freqMap[task - 'A']);
        }

        for (int freq : freqMap) {
            if (freq == maxFreq) maxFreqCount++;
        }

        int formulaResult = maxFreq + (maxFreq - 1) * n + (maxFreqCount - 1);

        return Math.max(formulaResult, tasks.length);


    }

}
