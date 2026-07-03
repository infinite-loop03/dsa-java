package com.dsa.patterns.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class VideoStitching {

    public static void main(String[] args) {
        VideoStitching videoStitching = new VideoStitching();
        int[][] clips = {
                {0, 2},
                {4, 6},
                {8, 10},
                {1, 9},
                {1, 5},
                {5, 9}
        };
        System.out.println(videoStitching.videoStitching(clips, 10));
    }

    public int videoStitching(int[][] clips, int time) {
        Arrays.sort(clips, Comparator.comparingInt(clip -> clip[0]));

        if (clips[0][0] != 0) {
            return -1;
        }

        int count = 0;
        int maxEnd = 0;
        int currEnd = 0;

        for (int[] clip : clips) {
            if (clip[0] > maxEnd) return -1;
            if (clip[0] > currEnd) {
                count++;
                currEnd = maxEnd;
            }
            maxEnd = Math.max(clip[1], maxEnd);
            if (maxEnd >= time) return count + 1;
        }
        return -1;
    }
}
