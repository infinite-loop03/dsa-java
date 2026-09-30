package com.dsa.patterns.revision.day3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeBasedKeyValueStore {

    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();
        timeMap.set("love", "high", 10);
        timeMap.set("love", "low", 20);
        System.out.println(timeMap.get("love", 5));
        System.out.println(timeMap.get("love", 10));
        System.out.println(timeMap.get("love", 15));
        System.out.println(timeMap.get("love", 20));
        System.out.println(timeMap.get("love", 25));
    }

    static class TimeMap {

        Map<String, List<Pair>> store;

        public TimeMap() {
            store = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            store.computeIfAbsent(key, _ -> new ArrayList<>()).add(new Pair(timestamp, value));
        }

        public String get(String key, int timestamp) {
            if (!store.containsKey(key)) return "";
            List<Pair> values = store.get(key);
            int low = 0;
            int high = values.size() - 1;

            while (low < high) {
                int mid = low + (high - low) / 2;
                Pair probablePair = values.get(mid);
                if (probablePair.timestamp == timestamp) return probablePair.value;

                if (probablePair.timestamp < timestamp) {
                    low = mid;
                } else {
                    high = mid - 1;
                }
            }
            return values.get(low).timestamp > timestamp ? "" : values.get(low).value;
        }
    }
    record Pair(int timestamp, String value) {}
}