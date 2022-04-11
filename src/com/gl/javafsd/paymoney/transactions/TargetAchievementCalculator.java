package com.gl.javafsd.paymoney.transactions;

public class TargetAchievementCalculator {
    private int[] transactions;
    private int dailyTarget;
    private boolean dailyTargetAchieved;
    private int transacCounter;

    public TargetAchievementCalculator(
            int[] transactions,int dailyTarget
    ){
        this.transactions=transactions;
        this.dailyTarget=dailyTarget;
        this.dailyTargetAchieved=false;
        this.transacCounter=0;
    }

    public void calculate(){
        int tempCounter=0;
        for(int i=0;i<transactions.length;i++){
            int targetValue = transactions[i];
            tempCounter=tempCounter+targetValue;

            transacCounter ++;
            if(tempCounter>=dailyTarget){
                dailyTargetAchieved=true;
                break;
            }
        }
    }

    public void printOutcome(){
        if(dailyTargetAchieved){
            System.out.println("Daily target for "+dailyTarget+" achieved after "+transacCounter+" transactions.");}
        else{
                System.out.println("Daily target for "+dailyTarget+" is yet to be achieved.");
            }
        }

    public static void main(String[] args){
        test(new int[] {75,54,23,34,14});
        test(new int[] {20,12,31},21);
        test(new int[] {20,12,31},19);
        test(new int[] {100},101);
    }

    public static void test(int[] transactions,int dailyTarget){
        System.out.println("*******************************************");
        TargetAchievementCalculator calculator=new TargetAchievementCalculator(transactions,dailyTarget);
        calculator.calculate();
        calculator.printOutcome();
    }
}
