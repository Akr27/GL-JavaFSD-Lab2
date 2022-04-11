package com.gl.javafsd.traveller.currencyspent;
import java.util.Scanner;

public class TravellerCurrencySpentUI {
    private int[] denominations;
    private Scanner input;
    public TravellerCurrencySpentUI(){
        input = new Scanner(System.in);

    }

    public void init(){
        gatherInputAndProcess();
    }

    private void gatherInputAndProcess(){
        System.out.println("Enter size of the currency denominations: ");
        int denominationsArraySize= input.nextInt();
        denominations=new int[denominationsArraySize];

        System.out.println("Enter currency denomination values: ");
        for (int i=0;i<denominationsArraySize;i++){
            denominations[i]= input.nextInt();
            input.nextLine();
        }

        System.out.println("Enter the payment amount: ");
        int payAmount = input.nextInt();

        CurrencyDenominationsDeterminator determinator=new CurrencyDenominationsDeterminator(denominations,payAmount);
        determinator.determine();
    }
}
