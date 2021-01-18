package UC;

/**
 * @description:
 * @author: Desmand
 * @time: 2021/1/18 4:51 下午
 */

public class UF {
    private int count;
    private int[] parent;
    private int[] size;

    public UF(int n) {
        this.count = n;
        parent = new int[n];
        //对于初始化阶段，所有的连通分量都有个指针指向其父节点，此时的父节点为自己
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    private int find(int x) {
        while (parent[x] != x) {
            //路径压缩
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    private void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        //优化，小树接到大树下
        if (size[p] > size[q]) {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        count--;
    }

    private int count() {
        return count;
    }

    private boolean connected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }
}
