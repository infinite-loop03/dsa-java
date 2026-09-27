package com.dsa.patterns.revision.binarysearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeBasedKeyValueStore {

    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();
        timeMap.set("foo", "bar", 5);
        System.out.println(timeMap.get("foo", 1));
    }

    static class TimeMap {

        Map<String, List<Pair>> keyValueStore;

        public TimeMap() {
            keyValueStore = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            keyValueStore.computeIfAbsent(key, _ -> new ArrayList<>())
                    .add(new Pair(timestamp, value));
        }

        public String get(String key, int timestamp) {
            if (!keyValueStore.containsKey(key)) return "";
            List<Pair> values = keyValueStore.get(key);

            int left = 0;
            int right = values.size() - 1;

            while (left < right) {
                int index = left + (right - left + 1) / 2;
                if (values.get(index).timestamp == timestamp) {
                    return values.get(index).value;
                } else if (values.get(index).timestamp < timestamp) {
                    left = index;
                } else {
                    right = index - 1;
                }
            }
            return values.get(left).timestamp > timestamp ? "" : values.get(left).value;
        }
    }

    record Pair(int timestamp, String value) {
    }
}
