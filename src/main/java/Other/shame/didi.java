package Other.shame;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author: wuhui
 * @time: 2019/9/19 20:05
 * @desc:
 * didi:
 * 第一行包含一个正整数n，m,表示数组的大小和所选区间的最小长度。
 * (1<=n<100000)第二行包含n个整数，中间用空格隔开0<=|ai|<=1000。
 *
 *        最近很多城市都搞起了垃圾分类，已知有一个小区有n堆垃圾需要丢弃，这些垃圾都打包了，我们并不知道这是什么垃圾，要知道有些垃圾如果丢在一起是会影响环境的。这个小区一共只有两辆垃圾车，出于合理负载的考量，要求两辆车必须装载相同数量的垃圾。我们希望在不影响环境的情况下，每次让垃圾车载走最多的垃圾。
 *
 *        我们为垃圾袋标了号，分别是1-n，有m个约束，每个约束表示为“a b”，意思是第a堆垃圾与第b堆垃圾不能装在一辆垃圾车上。（每堆垃圾最多有两个约束条件）
 *
 *         请问两辆垃圾车一次最多可以带走多少堆垃圾呢？
 */
public class didi {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int totolMax=0;
        int num = scanner.nextInt();
        int limit = scanner.nextInt();
        Map<Integer,Integer> limitMap=new HashMap<>();
        int[] chooseArray=new int[num+1];
        while (limit>0){
            limitMap.put(scanner.nextInt(),scanner.nextInt());
            --limit;
        }
        int freeCount=0;
        int car=1;
        for (int i = 1; i <= num; i++) {
            ++freeCount;
            chooseArray[i]= car;
            car=car==1?++car:--car;
        }
        System.out.println(freeCount);
    }

}
