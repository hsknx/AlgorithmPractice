package Algorithm.comprehensive.shortestDeliveryPath;

/**
 * @author liujun
 * @version 1.0
 * @date�� 2020-02-11 14:36
 * @author��Email: liujunfirst@outlook.com
 * @description: �ͻ����·���ӿ� ShortestDeliveryPath
 * ��ͼ��ĳ��������Աp����Ҫ��a��b��c��d4����ݵ����Ͱ����� ��������Ա��Ҫѡ��ʲô��·�ߣ�����������·�̵����͡�������ͼ����Ա���������(0,0)��
 *  * ����·��ֻ������ͼ�еķ������ʻ��ÿ��С���������Σ��ұ߳�Ϊ1����p��d�ľ������4��
 *  * �������n�����͵����꣬������������·��ֵ������㿪ʼ���n�������Ͳ��ص���ʼ��ľ��룩��
 * @blogURL:
 */
public interface ShortPath {

    public int shortPath(int[] position_row, int[] position_column);

    default boolean check(int[] position_row, int[] position_column){
        if (position_row == null || position_column == null
                || position_row.length == 0 || position_column.length == 0
                || position_row.length != position_column.length) {
            return false;
        }
        return true;
    }
}
