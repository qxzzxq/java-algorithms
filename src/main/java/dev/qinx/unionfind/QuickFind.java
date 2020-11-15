package dev.qinx.unionfind;

import java.util.HashSet;
import java.util.Set;

/**
 * Initialize O(N), Union O(N), find O(1)
 */
public class QuickFind extends UnionFind {
    public QuickFind(int len) {
        super(len);
    }

    @Override
    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) {
                id[i] = qid;
            }
        }
    }

    @Override
    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    @Override
    public int find(int p) {
        return id[p];
    }

    @Override
    public int count() {
        Set<Integer> targetSet = new HashSet<>();
        for (int i : id) {
            targetSet.add(i);
        }
        return targetSet.size();
    }
}