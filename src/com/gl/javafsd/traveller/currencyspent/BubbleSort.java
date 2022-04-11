package com.gl.javafsd.traveller.currencyspent;
import com.gl.datastructures.common.DataStructureUtils;


public class BubbleSort {
    private int[] data;
    public BubbleSort(int[] data){
        this.data=data;
    }

    public void sort(){
        sortAsc();
    }

    public void sortAsc(){
        int length = data.length;;
        for(int i=0;i<(length-1);i++){
            for(int j=0;j<(length-i-1);j++){
                if(data[j]>data[j+1]){
                    int temp=data[j];
                    data[j]=data[j+1];
                    data[j+1]=temp;
                }
            }
        }
    }

    public void sortDesc(){
        int length = data.length;
        for(int i=0;i<(length-1);i++){
            for(j=0;j<(length-i-1);j++){
                if(data[j]<data[j+1]){
                    int temp =data[j];
                    data[j]=data[j+1];
                    data[j+1]=temp;
                }
            }
        }
    }

    public static void main(String[] args]){
        testDescSorting(new int[] {5,1,10});
        testDescSorting(new int[] {60,5,12,78,25});
        testDescSorting(new int[] {12,5,123,18});
    }

    private static void testAscSorting(int[] data){
        BubbleSort sort = new BubbleSort(data);
        System.out.println("Before Sorting....");
        DataStructureUtils.print(data);

        System.out.println("After Sorting....");
        sort.sort();
        DataStructureUtils.print(data);
    }

    private static void testDescSorting(int[] data){
        BubbleSort sort= new BubbleSort(data);
        System.out.println("Before Sorting....");
        DataStructureUtils.print(data);

        System.out.println("After Sorting....");
        sort.sort();
        DataStructureUtils.print(data);
    }
}
