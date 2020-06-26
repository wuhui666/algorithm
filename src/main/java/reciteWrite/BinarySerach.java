package reciteWrite;

/**
 * @author: wuhui
 * @time: 2019/10/4 21:05
 * @desc:
 */
public class BinarySerach {
    public int search(int[] nums, int target) {
        int start=0;
        int end=nums.length-1;
        int mid=0;
        // 循环直到start>end
        while (start<=end){
            // 中间值下标
            mid=(start+end)>>1;

            if (nums[mid]==target){
                return mid;
            }
            // 在右边，更新start
            if (nums[mid]<target){
                start=mid+1;
            }
            // 在左边，更新end
            if (nums[mid]>target){
                end=mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums={1,1};

        System.out.println(new BinarySerach().search(nums,3));
    }
}
