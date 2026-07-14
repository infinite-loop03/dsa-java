package com.dsa.patterns.revisit.second.heaps;

public class TaskScheduler {

    public static void main(String[] args) {
        TaskScheduler taskScheduler = new TaskScheduler();
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        System.out.println(taskScheduler.leastInterval(tasks, 2));
    }

    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        int maxFreq = 0;

        for (char task : tasks) {
            freq[task - 'A']++;
            maxFreq = Math.max(maxFreq, freq[task - 'A']);
        }

        int maxFreqCount = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] == maxFreq) maxFreqCount++;
        }

        int minTime = maxFreq + (maxFreq - 1) * n + maxFreqCount - 1;

        return Math.max(minTime, tasks.length);
    }
}
