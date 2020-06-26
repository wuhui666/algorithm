package Other.shame;

import java.util.*;

/**
 * @author: wuhui
 * @time: 2019/9/21 15:43
 * @desc:
 */
public class Solution {
    public int search(int[] nums, int target) {
        if (nums.length<=0){
            return -1;
        }
        int minIndex=binarySearchMin(nums, 0, nums.length-1);
        int start=0,end=nums.length-1;
        int mid=0;
        //判断在旋转点哪一边，调整start和end
        if (target==nums[mid]){
            return mid;
        }
        else if (target>nums[mid]){
            //当数组本身就是升序，旋转点在第一个元素，minIndex=0，此时end不用改变
            end=minIndex-1<0?end:minIndex-1;
        }
        else {
            start=minIndex;
        }
        // 二分查找
        while (start<=end){
            mid=(start+end)>>1;
            if (target==nums[mid]){
                return mid;
            }
            else if (target>nums[mid]){
                start=mid+1;
            }
            else {
                end=mid-1;
            }
        }
        return -1;
    }
    // 找到旋转点
    public int binarySearchMin(int[] nums,int start,int end) {

        int mid=(start+end)>>1;
        // 先判断mid+1是不是旋转点
        if (mid+1<nums.length&&nums[mid]>nums[mid+1]){
            return mid+1;
        }
        // 如果范围缩小到只用一个元素
        // 最后一个待判断元素都不是旋转点，说明未旋转，旋转点为默认的0
        if (start==end){
            return 0;
        }
        // 取到等是mid与start重合 如：{1，2}
        // 中间值大于等于第一个元素，说明旋转点在右边
        if (nums[mid]>=nums[start]){
            return  binarySearchMin(nums, mid+1, end);
        }
        // 旋转点在左边
        else {
            return binarySearchMin(nums, start, mid-1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr={4,5,6,7,0,1,2};
        System.out.println(solution.search(arr,0));


    }
}
