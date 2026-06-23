package com.dsa.patterns.graphs;

import java.util.*;

public class SequenceReconstruction {

    public static void main(String[] args) {
        SequenceReconstruction sequenceReconstruction = new SequenceReconstruction();
        int[] nums = {1, 2, 3};
        List<List<Integer>> sequences = List.of(List.of(1, 2), List.of(1, 3));
        System.out.println(sequenceReconstruction.sequenceReconstruction(nums, sequences));
    }

    public boolean sequenceReconstruction(int[] nums, List<List<Integer>> sequences) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        int[] indegree = new int[nums.length + 1];

        for (int i = 1; i <= nums.length; i++) {
            graph.put(i, new HashSet<>());
        }

        for (List<Integer> sequence : sequences) {
            for (int i = 0; i < sequence.size() - 1; i++) {
                int u = sequence.get(i);
                int v = sequence.get(i + 1);
                if (graph.get(u).add(v)) {
                    indegree[v]++;
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= nums.length; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }

        if (queue.size() > 1) return false;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int neighbor : graph.get(curr)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
                if (queue.size() > 1) return false;
            }
        }
        return true;
    }
}
