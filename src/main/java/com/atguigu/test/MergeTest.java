package com.atguigu.test;

import java.util.Arrays;

/**
 * @author smh
 * @create 2021-08-17 23:01
 */
public class MergeTest {

    public static void mergeSort(int[] arr,int left,int right,int[] temp){
        if(left<right){
            int mid=(left+right)/2;
            //左边递归
            mergeSort(arr,left,mid,temp);
            //右边递归
            mergeSort(arr,mid+1,right,temp);
            //合并
            merge(arr,left,right,mid,temp);
        }
    }


    public static void merge(int[] arr,int left,int right,int mid,int[] temp){
        //定义指针
        int i=left;
        int j=mid+1;
        int t=0;
        //左右两个子数组都不越界
        while (i<=mid && j<=right){
            //判断谁大谁小
            temp[t++]=arr[i]<arr[j]?arr[j++]:arr[i++];
        }
        //如果子数组有剩余的没有匹配上,则直接copy到temp中
        while (i<=mid) temp[t++]=arr[i++];
        while (j<=right) temp[t++]=arr[j++];

        //将临时数组中的数据copy到arr中
        t=0;
        int tempLeft=left;
        while (tempLeft<=right){
            arr[tempLeft++]=temp[t++];
        }
    }

    public static void main(String[] args) {
        int[] ints = {5, 7, 8, 3, 1, 2, 6, 9, 0, 4};
        int[] temp=new int[ints.length];
        mergeSort(ints,0,ints.length-1,temp);
        System.out.println(Arrays.toString(ints));
    }
}
