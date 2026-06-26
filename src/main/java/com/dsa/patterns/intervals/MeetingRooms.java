package com.dsa.patterns.intervals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MeetingRooms {

    public static void main(String[] args) {
        MeetingRooms meetingRooms = new MeetingRooms();
        Interval first = new Interval(5, 8);
        Interval second = new Interval(9, 15);
        Interval third = new Interval(15, 20);

        List<Interval> intervals = new ArrayList<>();
        intervals.add(first);
        intervals.add(second);
        intervals.add(third);
        System.out.println(meetingRooms.canAttendMeetings(intervals));
    }

    private boolean canAttendMeetings(List<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(a -> a.end));

        int lastEnd = Integer.MIN_VALUE;

        for (Interval interval : intervals) {
            if (interval.start >= lastEnd) {
                lastEnd = interval.end;
            } else {
                return false;
            }
        }
        return true;
    }

    static class Interval {
        public int start, end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
