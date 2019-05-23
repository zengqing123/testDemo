package com.example.testDemo.test.mian;

import com.example.testDemo.test.io.IOTest;

/**
 * <b>类   名：</b>TestMain<br/>
 * <b>类描述：</b><br/>
 * <b>创建人：</b>luozengqing<br/>
 * <b>创建时间：</b>2019/5/7 15:04<br/>
 * <b>修改人：</b>luozengqing<br/>
 * <b>修改时间：</b>2019/5/7 15:04<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0.0<br />
 */
public class TestMain {
    public static void main(String[] args){

        IOTest test = new IOTest();
        test.saveDataToFile("测试","今飞是");
        int[] rs = new int[10];
        System.out.println("排序前：");
        for (int a = 0;a < rs.length;a++){
            int num = new Double(Math.random() * 100).intValue();
            rs[a] = num;
            System.out.print(num+"  ");
        }
        mergeSort(rs);
    }
    public static void mergeSort(int[] nums) {
        System.out.println();
        System.out.println("排序后");
        //创建与原数组相同长度的数组
        int[] temp = new int[nums.length];
        mergeSort(nums, temp, 0, nums.length-1);
        for (int a = 0;a < nums.length;a++){
            System.out.print(temp[a]+"  ");
        }
    }

    private static void mergeSort(int[] nums, int[] temp, int left, int right) {

        if(left < right) {
            //从中间将数组分成两半
            int mid = (left + right)/2;
            mergeSort(nums, temp, left, mid);
            mergeSort(nums, temp, mid+1, right);
            //将两个数组重新合并
            merge(nums, temp, left, mid+1, right);
        }
    }

    private static void merge(int[] nums, int[] temp,
                              int leftPos, int rightPos, int rightEnd) {

        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;
        //对比左右两个数组并将较小的数先放到辅助数组
        while(leftPos <= leftEnd && rightPos <= rightEnd) {
            if(nums[leftPos] <= nums[rightPos]) {
                temp[tmpPos++] = nums[leftPos++];
            }else {
                temp[tmpPos++] = nums[rightPos++];
            }
        }
        //把左边数组剩下的原数放到辅助数组
        while(leftPos <= leftEnd) {
            temp[tmpPos++] = nums[leftPos++];
        }
        //把右边数组剩下的原数放到辅助数组
        while(rightPos <= rightEnd) {
            temp[tmpPos++] = nums[rightPos++];
        }
        //把辅助数组复制到原数组
        for(int i = 0; i < numElements; i++,rightEnd--) {
            nums[rightEnd] = temp[rightEnd];
        }
    }
}
