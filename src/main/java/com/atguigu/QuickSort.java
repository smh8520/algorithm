package com.atguigu;


import javax.lang.model.element.VariableElement;

/**
 * @author smh
 * @create 2021-08-17 16:18
 */
public class QuickSort {
    public static void quickSort(int[] arr,int start,int end){
        if(start<end){
            int index = getIndex(arr, start, end);
            quickSort(arr,start,index);
            quickSort(arr,index+1,end);
        }
    }

    public static int getIndex(int[] arr,int start,int end){
        //基准数
        int x = arr[start];
        //定义指针
        int i=start;
        int j=end;
        while (i<j){
            //从右往左,将小的移到左边
            while (i<j && x<=arr[j]){
                j--;
            }
            //挖坑
            if(i<j){
                arr[i++]=arr[j];
            }
            //从左往右,将大的移到右边
            while (i<j && x>arr[i]){
                i++;
            }
            //挖坑
            if(i<j){
                arr[j--]=arr[i];
            }
        }
        arr[i]=x;
        return i;
    }


    public static void main(String[] args) {
        int[] arr = {5, 45, 86, 36, 54, 85, 72, 35,35,35, 96, 47, 125};
        quickSort(arr,0,arr.length-1);
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
}
