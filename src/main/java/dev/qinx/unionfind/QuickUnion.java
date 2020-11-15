package dev.qinx.unionfind;

import java.util.HashSet;
import java.util.Set;

/**
 * Initialize O(N), Union O(N), find O(N) <= worst case
 */
public class QuickUnion extends UnionFind {
    public QuickUnion(int len) {
        super(len);
    }

    @Override
    public void union(int p, int q) {
        int pParent = find(p);
        int qParent = find(q);

        if (pParent != qParent) {
            id[pParent] = qParent;
        }
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    @Override
    public int count() {
        Set<Integer> targetSet = new HashSet<>();
        for (int i = 0; i < length(); i++) {
            if (i == id[i]) {
                targetSet.add(i);
            }
        }
        return targetSet.size();
    }

}
