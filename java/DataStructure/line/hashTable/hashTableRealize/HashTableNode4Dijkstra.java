package DataStructure.line.hashTable.hashTableRealize;

/**
 * @author liujun
 * @version 1.0
 * @date£º 2019-12-26 00:12
 * @author¡ªEmail: liujunfirst@outlook.com
 * @description:
 * @blogURL:
 */
public class HashTableNode4Dijkstra extends HashTableNode{
    public boolean visit;

    public HashTableNode4Dijkstra(){
        super();
        this.visit = false;
    }

    public HashTableNode4Dijkstra(int value){
        super(value);
        this.visit = false;
    }
}
