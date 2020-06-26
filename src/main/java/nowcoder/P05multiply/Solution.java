package nowcoder.P05multiply;

/**	构建乘积数组
 * @author: wuhui
 * @time: 2019/8/25 23:02
 * @desc:
 */
public class Solution {
   /* public int[] multiply(int[] A) {
        int[] B=new int[A.length];
        for (int i = 0; i < B.length; i++) {
            B[i]=1;
            for (int j = 0; j < A.length; j++) {
               B[i]=j==i?B[i]:B[i]*A[j];
            }
        }
        return B;

    }*/
    /*public int[] multiply(int[] A) {
        int length = A.length;
        int[] B = new int[length];
        if(length != 0 ){
            B[0] = 1;
            //计算下三角连乘
            for(int i = 1; i < length; i++){
                B[i] = B[i-1] * A[i-1];
            }
            int temp = 1;
            //计算上三角
            for(int j = length-2; j >= 0; j--){
                temp *= A[j+1];
                B[j] *= temp;
            }
        }
        return B;
        //https://www.nowcoder.com/questionTerminal/94a4d381a68b47b7a8bed86f2975db46
    }*/
   public int[] multiply(int[] A) {
       int[] B=new int[A.length];
       for (int i = 0; i < A.length; i++) {
           if (i==0){
               B[i]=1;
               continue;
           }
           B[i]=B[i-1]*A[i-1];
       }
       int[] tmp=new int[A.length];
       for (int i = A.length-1; i >=0; i--) {
           if (i== A.length-1){
               tmp[i]=1;
               continue;
           }
           tmp[i]=tmp[i+1]*A[i+1];
           B[i]=B[i]*tmp[i];
       }
       return B;

   }

    public static void main(String[] args) {
        int[] A={1,2,3};
        int[] B = new Solution().multiply(A);
        for (int i = 0; i < B.length; i++) {
            System.out.println(B[i]);
        }
    }
}
