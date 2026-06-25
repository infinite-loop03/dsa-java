package com.dsa.patterns.graphs.dsu;

import java.util.*;

public class AccountsMerge {

    public static void main(String[] args) {
        AccountsMerge accountsMerge = new AccountsMerge();
        List<String> account1 = List.of("John", "johnsmith@mail.com", "john_newyork@mail.com");
        List<String> account2 = List.of("John", "johnsmith@mail.com", "john00@mail.com");
        List<String> account3 = List.of("Mary", "mary@mail.com");
        List<String> account4 = List.of("John", "johnnybravo@mail.com");
        List<List<String>> accounts = List.of(account1, account2, account3, account4);
        System.out.println(accountsMerge.accountsMerge(accounts));
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();

        UnionFind unionFind = new UnionFind(n);

        Map<String, Integer> emailToAccount = new HashMap<>();

        for (int i = 0; i < n; i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                if (!emailToAccount.containsKey(email)) {
                    emailToAccount.put(email, i);
                } else {
                    unionFind.union(i, emailToAccount.get(email));
                }
            }
        }

        Map<Integer, List<String>> merged = new HashMap<>();

        for (Map.Entry<String, Integer> entry : emailToAccount.entrySet()) {

            String email = entry.getKey();
            int account = entry.getValue();

            int root = unionFind.find(account);

            merged.computeIfAbsent(root, k -> new ArrayList<>()).add(email);
        }

        List<List<String>> answer = new ArrayList<>();

        for (Map.Entry<Integer, List<String>> entry : merged.entrySet()) {

            int root = entry.getKey();
            List<String> emails = entry.getValue();

            Collections.sort(emails);

            List<String> account = new ArrayList<>();

            account.add(accounts.get(root).getFirst());
            account.addAll(emails);

            answer.add(account);
        }

        return answer;
    }

    static class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int node) {
            if (parent[node] != node) {
                parent[node] = find(parent[node]);
            }
            return parent[node];
        }

        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) return;

            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }
}
