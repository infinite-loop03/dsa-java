package com.dsa.patterns.intervals;

import java.util.*;

public class MeetingRoomsII {

    public static void main(String[] args) {
        MeetingRoomsII meetingRoomsII = new MeetingRoomsII();
        Interval first = new Interval(4, 9);
        Interval second = new Interval(5, 10);
        Interval third = new Interval(15, 20);

        List<Interval> intervals = new ArrayList<>();
        intervals.add(first);
        intervals.add(second);
        intervals.add(third);
        System.out.println(meetingRoomsII.minMeetingRooms(intervals));
    }

    private int minMeetingRooms(List<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(interval -> interval.start));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (Interval interval : intervals) {
            if (!pq.isEmpty() && pq.peek() <=  interval.start) {
                pq.poll();
            }
            pq.offer(interval.end);
        }
        return pq.size();
    }

    static class Interval {
        public int start, end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
