package Other.shame;

import java.util.Scanner;

/**
 * in:
 * 4 6 1
 *
 * 1 2 2
 * 2 3 2
 * 2 4 1
 * 1 3 5
 * 3 4 3
 * 1 4 4
 * out:
 * 0
 * 2
 * 4
 * 3
 * @author: wuhui
 * @time: 2019/9/26 19:49
 * @desc:
 */
public class ShortPath {
    static int[][] map;
    static int[] record;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        map=new int[num][num];
        record=new int[num];
        int edges = scanner.nextInt();
        int startPoint = scanner.nextInt();

        for (int i = 0; i <edges ; i++) {
                int row=scanner.nextInt()-1;
                int col=scanner.nextInt()-1;
                map[row][col]=scanner.nextInt();
            
        }

        for (int i = 0; i <num ; i++) {
            for (int j = 0; j <num ; j++) {
                if (map[i][j]==0){
                    map[i][j]=-1;
                }
                if (i==j){
                    map[i][j]=0;
                }
            }
        }
        for (int i = 1; i < num; i++) {

            shortPath(i);
            

        }
        for (int i = 0; i < record.length; i++) {
            System.out.println(record[i]);
        }
    }

    public static int shortPath(int i) {
        if (i==0){
            return 0;
        }
        int tmpMin=Integer.MAX_VALUE;
        int tmp=0;
        for (int j = 0; j < record.length; j++) {
            if (map[j][i]!=-1&&map[j][i]!=0){
                if (record[j]!=0){
                    tmp=record[j]+map[j][i];
                }
                else {
                    tmp=shortPath(j)+map[j][i];
                }

                tmpMin=tmpMin>tmp?tmp:tmpMin;
            }
        }
        record[i]=tmpMin;
        return tmpMin;

    }
}
