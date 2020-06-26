package Other.dp;

/**
 * @author: wuhui
 * @time: 2019/9/1 10:25
 * @desc: 二维01背包
 */
public class OneOrZero {
    public static void main(String[] args) {
        String[] strs={"10", "0001", "111001", "1", "0"};
        //String[] strs={"10", "0", "1"};
        OneOrZero oneOrZero=new OneOrZero();
        //System.out.println(oneOrZero.findMaxForm(strs, 5, 3));
        //System.out.println(oneOrZero.findMaxForm(strs, 1, 1));
        System.out.println(oneOrZero.findMaxFormPro(strs, 5, 3));
        //System.out.println(oneOrZero.findMaxFormPro(strs, 1, 1));
    }
    // 三维数组实现
    public int findMaxForm(String[] strs, int m, int n) {
        if (m==0&&n==0){
            return 0;
        }
        if (strs.length==0){
            return 0;
        }
        String[] strings=new String[strs.length+1];
        strings[0]="";
        for (int i = 1; i <= strs.length; i++) {
            strings[i]=strs[i-1];
        }


        int[][][] temp=new int[strings.length][m+1][n+1];

        for (int k = 1; k < strings.length; k++) {
            //String tmpStr=strings[k];
            /*int zeroCount=tmpStr.replaceAll("1","").length();
            int oneCount=strings[k].length()-zeroCount;*/
            int zeroCount=0;
            int oneCount=0;
            for(char c:strings[k].toCharArray()){
                if (c=='0'){
                    zeroCount++;
                }
                if (c=='1'){
                    oneCount++;
                }
            }
            for (int i = 0;i <=m ; i++) {
                for (int j = 0; j <=n ; j++) {
                    if (i-zeroCount>=0&&j-oneCount>=0){
                        temp[k][i][j]=Math.max(temp[k-1][i][j], temp[k-1][i-zeroCount][j-oneCount]+1);

                    }
                    else {
                        temp[k][i][j]=temp[k-1][i][j];
                    }
                }

            }

        }
        return temp[strings.length-1][m][n];
/*
        for (int i = 1; i < strings.length; i++) {
            for (int j = 0;j < mn.length; j++) {
                String tmpStr=strings[i];
                int len=tmpStr.length();
                int oneCount=tmpStr.replaceAll("0", "").length();

                int zeroCount=len-oneCount;
                if (m-oneCount>=0&&n-zeroCount>=0){
                    int yes=temp[i-1][(m-oneCount)*(n-zeroCount)]+1;
                    int no=temp[i-1][m*n];
                    temp[i][j]=yes>no?yes:no;
                }
            }
        }
        for (int i = 0; i < temp.length; i++) {
            System.out.println(Arrays.toString(temp[i]));
        }
        return temp[strings.length-1][mn.length-1];*/
    }

    // 滚动数组优化，降为二维，就是一个二维01背包，
    // 但是把容量限制换为了0，1两个维度限制而已，思路一样，按照01背包稍作改变即可
    public int findMaxFormPro(String[] strs, int m, int n) {
        // 特殊情况考虑直接返回
        if (m == 0 && n == 0) {
            return 0;
        }
        if (strs.length == 0) {
            return 0;
        }
        // 第n个物品在数组的下标为n的形式就用不着了，因为该维度压根没用到

        // 滚动二维数组
        int[][] temp = new int[m + 1][n + 1];
        for (String string:strs) {
            int zeroCount = 0;
            int oneCount = 0;
            // 每个物品的资源消耗
            for (char c : string.toCharArray()) {
                if (c == '0') {
                    zeroCount++;
                }
                if (c == '1') {
                    oneCount++;
                }
            }
            // 注意逆序
            for (int i = m; i >= zeroCount; i--) {
                for (int j = n; j >= oneCount; j--) {
                    // 可以当公式记了
                    temp[i][j] = Math.max(temp[i][j], temp[i - zeroCount][j - oneCount] + 1);
                }
            }

        }
        return temp[m][n];
    }
}
