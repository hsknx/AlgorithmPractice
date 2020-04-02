package DataStructure.graph.shortestPath.singleSourceShortestPath;

import DataStructure.line.hashTable.hashTableRealize.HashTableNode4Dijkstra;
import Logic.check.MatrixCheck;

/**
 * @author liujun
 * @version 1.0
 * @date 2019-12-25 21:11
 * @author—Email  liujunfirst@outlook.com
 * @description  某源点到途中任意点的最短路径
 * 输入：一个 邻接矩阵 或者 邻接表 所代表的图，
 *      这个图的路径权值必须全部为正，
 *      指定某个起点。
 * 输出：一个散列表，
 *      数组代表这个起点到其他所有点的最短距离，
 *      列表部分表示，起点到当前点的路径。
 * @blogURL
 */
//贪心算法
public class Dijkstra {

    public HashTableNode4Dijkstra[] getShortestPath(int startPoint, int[][] matrix){

        //检查是否为正方形
        if(!MatrixCheck.judgeisSquare(matrix)){
            return null;
        }
        int length = matrix.length;
        HashTableNode4Dijkstra[] hashTableNode4Dijkstras = new HashTableNode4Dijkstra[length];

        //initial
        for (int i = 0; i < length; i++) {
            hashTableNode4Dijkstras[i] = new HashTableNode4Dijkstra(matrix[startPoint][i]);
        }

        hashTableNode4Dijkstras[startPoint].value = 0;
        hashTableNode4Dijkstras[startPoint].visit = true;


        for (int i = 1; i < length; i++) {
            int minvalue = Integer.MAX_VALUE;
            int findpoint = 0;

            //find the min path
            for (int j = 0; j < length; j++) {
                if(!hashTableNode4Dijkstras[j].visit && hashTableNode4Dijkstras[j].value < minvalue){
                    minvalue = hashTableNode4Dijkstras[j].value;
                    findpoint = j;
                }
            }
            //fail to find min path,then break
            if(minvalue == Integer.MAX_VALUE){
                break;
            }
            hashTableNode4Dijkstras[findpoint].visit = true;
            hashTableNode4Dijkstras[findpoint].value = minvalue;

            //update the hashTableNode4Dijkstras
            for (int j = 0; j < length; j++) {
                    if(!hashTableNode4Dijkstras[j].visit && matrix[findpoint][j] != Integer.MAX_VALUE && hashTableNode4Dijkstras[j].value > matrix[findpoint][j] + minvalue){
                    hashTableNode4Dijkstras[j].value = matrix[findpoint][j] + minvalue;
                }
            }
        }

        return hashTableNode4Dijkstras;
    }
}
