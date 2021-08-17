package com.atguigu;

import java.util.Arrays;

/**
 * @author smh
 * @create 2021-08-17 16:37
 */
public class Merge {

    public static void mergeSort(int[] arr,int ls,int rs){
        if(ls<rs){
            int mid=(ls+rs)/2;
            int[] tmp = new int[arr.length];
            mergeSort(arr,ls,mid);
            mergeSort(arr,mid+1,rs);
            merge(arr,ls,mid,rs,tmp);
        }
    }

    public static void merge(int[] arr,int ls,int mid,int rs,int[]tmp){
        int i=ls;
        int j=mid+1;
        int t=0;
        //将小的值放到临时数组中
        while (i<=mid && j<=rs){
            if(arr[i]<=arr[j]){
                tmp[t]=arr[i];
                t++;
                i++;
            }else{
                tmp[t]=arr[j];
                t++;
                j++;
            }
        }
        //查看有没有剩余值
        while (i<=mid) tmp[t++]=arr[i++];
        while (j<=rs) tmp[t++]=arr[j++];

        //临时数组的值填充给原数组
        t=0;
        int tmpL=ls;
        while (tmpL<=rs){
            arr[tmpL++]=tmp[t++];
        }
    }

    public static void main(String[] args) {
        int[] ints = {1,8,6,9,7,4};
        mergeSort(ints,0,ints.length-1);
        System.out.println(Arrays.toString(ints));
    }

//    public static int[] merge(int[] arr1,int[] arr2){
//        int[] result = new int[arr1.length + arr2.length];
//
//        int x=0;
//        int y=0;
//
//        while (x<arr1.length && y < arr2.length){
//            if(arr1[x]<=arr2[y]){
//                result[x+y]=arr1[x];
//                x++;
//            }else{
//                result[x+y]=arr2[y];
//                y++;
//            }
//        }
//        if(x<arr1.length){
//            for (int i = x; i < arr1.length; i++) {
//                result[i+y]=arr1[i];
//            }
//        }
//        if(y<arr2.length){
//            for (int i = y; i < arr2.length; i++) {
//                result[i+x]=arr2[i];
//            }
//        }
//        return result;
//    }
}
