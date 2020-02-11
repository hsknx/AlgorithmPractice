package Algorithm.recall;

/**
 * @author liujun
 * @version 1.0
 * @date�� 2019-12-06 22:05
 * @author��Email: liujunfirst@outlook.com
 * @description: ��ѵ������⣨��֧�޽磩
 * @blogURL:
 */
//ע�͵��Ĳ��֣������ڼ�¼ ����-���� ��Ӧ��
public class OptimalSchedule {

    //���Ž�
    int bestTime;
    //�������ѵ�ʱ�����С���������
    int[] MachineTaskSchedule;
    int machineNum;
    int[] taskspendTime;
    int taskNum;
    /*//ÿ�����������Ļ����ͺ�
    int[] tasktoMachine_temp;
    int[] tasktoMachine_best;*/

    public int schedule(int[] taskspendTime, int machineNum) {

        //���
        if (taskspendTime == null || taskspendTime.length == 0 || machineNum <= 0) {
            return -1;
        }
        bestTime = Integer.MAX_VALUE;
        taskNum = taskspendTime.length;
        this.machineNum = machineNum;
        this.taskspendTime = taskspendTime;
        this.MachineTaskSchedule = new int[machineNum];
       /* this.tasktoMachine_temp = new int[taskNum];
        this.tasktoMachine_best = new int[taskNum];*/
        long time = System.nanoTime();
        arrange(0);
        System.out.println(System.nanoTime() - time);
        return bestTime;
    }

    public void arrange(int Taskdepth) {
        if (Taskdepth == taskNum) {
            //����
            int temp = 0;
            for (int i = 0; i < machineNum; i++) {
                temp = temp < MachineTaskSchedule[i] ? MachineTaskSchedule[i] : temp;
            }
            //ˢ�� ����-���� ��Ӧ��
            if(bestTime > temp){
                bestTime = temp;
                /*for (int i = 0; i < taskNum; i++) {
                    tasktoMachine_best[i] = tasktoMachine_temp[i];
                }*/
            }
            return;
        }
        for (int i = 0; i < machineNum; i++) {
            //��֦,���û��if����䣬Ч������һ��������
            if(MachineTaskSchedule[i] + taskspendTime[Taskdepth] < bestTime){
                MachineTaskSchedule[i] += taskspendTime[Taskdepth];
                /*tasktoMachine_temp[Taskdepth] = i;*/
                arrange(Taskdepth + 1);
                MachineTaskSchedule[i] -= taskspendTime[Taskdepth];
            }
        }
    }
}
