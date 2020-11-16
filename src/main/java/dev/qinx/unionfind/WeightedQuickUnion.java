package dev.qinx.unionfind;

public class WeightedQuickUnion extends QuickUnion {

    int[] size;

    public WeightedQuickUnion(int len) {
        super(len);

        // init size array
        size = new int[len];
        for (int i = 0; i < len; i++) {
            size[i] = 1;
        }
    }

    @Override
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);

        if (i != j) {
            if (size[i] < size[j]) {
                id[i] = j;
                size[j] += size[i];
            } else {
                id[j] = i;
                size[i] += size[j];
            }
        }
    }

    @Override
    public int find(int p) {
        while (p != id[p]) {
            id[p] = id[id[p]];  // compress the tree by making every node in the path pointing to its grandparent
            p = id[p];
        }
        return p;
    }
}
