package com.gl.javafsd.paymoney.transactions;
import java.util.Scanner;

public class PayMoneyTransactionsUI {
    private int[] transactions;
    private Scanner input;

    public PayMoneyTransactionsUI(){
        input=new Scanner(System.in);
    }

    public void init(){
        gatherInputsAndProcess();
    }

    private void gatherInputsAndProcess(){
        System.out.println("Enter size of transaction array: ");
        int transacArraySize= input.nextInt();
        transactions = new int[transacArraySize];

        System.out.println("Enter transaction array elements: ");
        for(int i=0;i<transacArraySize;i ++){
            transactions[i]=input.nextInt();
            input.nextLine();
        }

        System.out.println("Enter number of transaction instances to be achieved: ");
        int transacInstSize= input.nextInt();
        input.nextLine();

        for(int i=1;i<=transacInstSize;i++){
            System.out.println();
            System.out.print("Enter transaction target value: ");
            int dailyTarget=input.nextInt();
            input.nextLine();
            System.out.println("Processing transaction with value: "+dailyTarget);

            TargetAchievementCalculator calculator=new TargetAchievementCalculator(transactions,transacInstSize);
            calculator.calculate();
            calculator.printOutcome();
        }
    }
}
