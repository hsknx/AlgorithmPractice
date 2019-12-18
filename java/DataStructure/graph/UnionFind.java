package DataStructure.graph;

/**
 * @author liujun
 * @version 1.0
 * @date�� 2019-12-18 21:16
 * @author��Email: liujunfirst@outlook.com
 * @description: Union-Find ���鼯�㷨
 * @blogURL:
 */
public class UnionFind {

    int[] parent;
    int count;

    public UnionFind(int n){
        this.count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    //���� x �� y Ϊһ����ͨ����
    public void union(int x, int y) {
        int x_parent = find(x);
        int y_parent = find(y);
        if (x_parent != y_parent) {
            parent[x_parent] = y_parent;
            this.count--;
        }
    }

    //�ж� p �� q �Ƿ���ͨ
    public boolean connected(int x, int y) {
        int x_parent = find(x);
        int y_parent = find(y);
        return x_parent == y_parent;
    }

    //����ͼ���ж��ٸ���ͨ����
    public int count() {
        return count;
    }

    //���� x �ĸ��ڵ�
    private int find(int x) {
        while (parent[x] != x) {
            x = parent[x];
        }
        return x;
    }
}
