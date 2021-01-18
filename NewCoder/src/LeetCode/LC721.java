package LeetCode;

import java.util.*;

/**
 * @description:
 * @author: Desmand
 * @time: 2021/1/18 5:18 下午
 */

public class LC721 {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> email2Name = new HashMap<>();
        Map<String, Integer> email2Index = new HashMap<>();
        int emailIndex = 1;
        for (List<String> account : accounts) {
            String name = account.get(0);
            int size = account.size();
            for (int i = 1; i < size; i++) {
                if (!email2Index.containsKey(account.get(i))) {
                    email2Index.put(account.get(i), emailIndex++);
                    email2Name.put(account.get(i), name);
                }
            }
        }
        UF uf = new UF(emailIndex);
        //并查集初始化
        for (List<String> account : accounts) {
            int firstIndex = email2Index.get(account.get(1));
            int size = account.size();
            for (int i = 2; i < size; i++) {
                int nextIndex = email2Index.get(account.get(i));
                uf.union(firstIndex, nextIndex);
            }
        }
        //开始查找，存在相同邮箱的不同用户
        Map<Integer, List<String>> indexToEmails = new HashMap<Integer, List<String>>();
        for (String email : email2Index.keySet()) {
            int index = uf.find(email2Index.get(email));
            List<String> account = indexToEmails.getOrDefault(index, new ArrayList<String>());
            account.add(email);
            indexToEmails.put(index, account);
        }
        List<List<String>> merged = new ArrayList<List<String>>();
        for (List<String> emails : indexToEmails.values()) {
            Collections.sort(emails);
            String name = email2Name.get(emails.get(0));
            List<String> account = new ArrayList<String>();
            account.add(name);
            account.addAll(emails);
            merged.add(account);
        }
        return merged;
    }

    class UF {
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

        public int find(int x) {
            while (parent[x] != x) {
                //路径压缩
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public void union(int p, int q) {
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

        public int count() {
            return count;
        }

        public boolean connected(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            return rootP == rootQ;
        }
    }

}
