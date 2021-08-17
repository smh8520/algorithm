package com.atguigu.test;

import java.util.Arrays;

/**
 * @author smh
 * @create 2021-08-17 22:48
 */
public class QuickTest {

    public static void quickSort(int[] arr,int start,int end){
        if(start<end){
            int index = getIndex(arr, start, end);
            //左边递归
            quickSort(arr,start,index);
            //右边递归
            quickSort(arr,index+1,end);
        }
    }

    public static int getIndex(int[] arr,int start,int end){
        //获取基准值
        int x=arr[start];
        //获取指针
        int i = start;
        int j=end;
        while (i<j){
            //从右往左查看大于基准值的数,如果小于等于基准值直接跳过
            while (i<j && arr[j]>=x){
                j--;
            }
            //如果大于基准值,则挖坑并将值放入之前的坑
            if(i<j){
                arr[i++]=arr[j];
            }
            //从左往右查看小于等于基准值的数,如果大于基准值直接跳过
            while (i<j && arr[i]<x){
                i++;
            }
            //如果小于等于基准值,挖坑并将值放入之前的坑
            if(i<j){
                arr[j--]=arr[i];
            }
        }
        arr[i]=x;
        return i;
    }

    public static void main(String[] args) {
        int[] ints = {5, 7, 8, 3, 1, 2, 6, 9, 0, 4};
        quickSort(ints,0,ints.length-1);
        System.out.println(Arrays.toString(ints));
    }
}
