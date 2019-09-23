package com.fei.letcode.simple;

import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 示例:
 给定 nums = [2, 7, 11, 15], target = 9
 因为 nums[0] + nums[1] = 2 + 7 = 9
 所以返回 [0, 1]
 来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/two-sum
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
        */
public class Demo01 {
    public static void main(String[] args) {
      int[]  nums = {3, 7, 11, 15,7,2};
      int target = 9;


//        int[] ints = test01(nums, target);
//        System.out.println(ints[0]+"-"+ints[1]);
        int[] ints = test02(nums, target);
        System.out.println(ints[0]+"-"+ints[1]);
    }

    //暴力破解
    public static int[] test01(int[] nums,int target){
        int[] re = new int[2];
        int flag = 0;
        for (int i = 0; i <nums.length-1 ; i++) {
            for (int j = i+1; j <=nums.length-1; j++) {
                if(nums[i]+nums[j]==target){
                    System.out.println("有这样的值，值为:"+nums[i]+"和"+nums[j]);
                    re[0] = i;
                    re[1] = j;
                    flag=1;
                    break;
                }
            }
            if(flag==1){
                return re;
            }
        }
        return re;
    }
    //letcode方法
    //把值存入hashmap中，查找时间复杂度是O(1)到O(N),一般为O(1)

    public static int[] test02(int[] nums,int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <nums.length ; i++) {
            int result = target - nums[i];
            if(map.containsKey(result)&&map.get(result)!=i){
                return new int[]{map.get(result),i};
            }
            map.put(nums[i],i);
        }
        throw new RuntimeException("没有这样的值！");

    }
}
