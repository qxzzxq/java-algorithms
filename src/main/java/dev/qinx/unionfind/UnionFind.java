package dev.qinx.unionfind;

public abstract class UnionFind {

    protected int[] id;

    public UnionFind(int len) {
        id = new int[len];

        for (int i = 0; i < len; i++) {
            id[i] = i;
        }
    }

    abstract public void union(int p, int q);

    abstract public boolean connected(int p, int q);

    /**
     * Find the group index of the value p
     * @param p value
     * @return group index of p
     */
    abstract public int find(int p);

    /**
     * Return the number of groups
     * @return total number of groups
     */
    abstract public int count();
}
