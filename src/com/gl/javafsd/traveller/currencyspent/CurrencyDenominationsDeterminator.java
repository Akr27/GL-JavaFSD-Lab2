package com.gl.javafsd.traveller.currencyspent;
import java.util.Arrays;
import com.gl.datastructures.common.DataStructureUtils;

public class CurrencyDenominationsDeterminator{
    private int[] denominations;
    private int payAmount;

    private int[] resultDenominationArray;
    private int[] resultDenominationCountArray;

    public CurrencyDenominationsDeterminator(
            int[] denominations,int payAmount){
        this.denominations=denominations;
        this.payAmount=payAmount;
        this.resultDenominationArray= new int[this.denominations.length];
        this.resultDenominationCountArray= new int[this.denominations.length];

    }

    public void determine() {
        sort();
        int i = 0;
        int resultIndex = 0;
        int balancedOutPayAmount = payAmount;

        while (i < denominations.length) {
            int denomination = denominations[i];
            int quotient = balancedOutPayAmount / denomination;
            int remainder = balancedOutPayAmount % denomination;

            if (quotient != 0) {
                int temp = denomination * quotient;
                balancedOutPayAmount = balancedOutPayAmount - temp;
                resultDenominationArray[resultIndex] = denomination;
                resultDenominationCountArray[resultIndex] = quotient;
                resultIndex++;

                if (remainder != 0) {
                } else if (remainder == 0) {
                    if (balancedOutPayAmount == 0) {
                        printSuccessMessage(resultIndex);
                        break;
                    }
                }
            }

            else if(quotient==0) {
                if (remainder != 0) {
                    if (!isLastDenomination(i)) {
                    } else {
                        printErrorMessage();
                        break;
                    }
                } else if (remainder == 0) {
                    break;
                }

            }
            i++;
        }

    }

    private void sort(){
        BubbleSort bubbleSort=new BubbleSort(denominations);
        bubbleSort.sortDesc();
    }

    private boolean isLastDenomination(int i){
        if(i== denominations.length-1){
            return true;
        }
        else{
            return false;
        }
    }

    private void printErrorMessage(){
        System.out.println("For the denomination values "+DataStructureUtils.printAndReturn(denominations)+" ,it's not possible to give for the paymont amount "+payAmount);

    }

    private void printSuccessMessage(int resultIndex){
        resultDenominationArray=Arrays.copyOf(resultDenominationArray,resultIndex);
        resultDenominationCountArray=Arrays.copyOf(resultDenominationCountArray,resultIndex);
        System.out.println("For the payment of "+payAmount+" and for denominations "+DataStructureUtils.printAndReturn(denominations)+" ,this payment approach can be used to giva a minimum number of notes.");

        for(int i=0;i<resultDenominationArray.length;i++){
            int denomination = resultDenominationArray[i];
            int denominationCount = resultDenominationCountArray[i];
            System.out.println("Denomination "+denomination+" to be given "+denominationCount+" times.");
        }
    }

    public static void main(String[] args){
        test(new int[]{10,5,1},12);
        test(new int[]{78,60,25,12,5},128);
        test(new int[]{123,18,12,5},158);
        test(new int[]{15},10);
        test(new int[]{25,15},10);

    }

    private static void test(int[] denominations,int payAmount){
        System.out.println("************************************");
        CurrencyDenominationsDeterminator determinator=new CurrencyDenominationsDeterminator(denominations,payAmount);
        determinator.determine();
    }
}





