// Sheehan Phan 500890672
import java.util.*;
import java.util.Random;
class AccountingSystem{
    ArrayList<Transaction> trans = new ArrayList<Transaction>();
    private int transactionID;
    public AccountingSystem(){
        trans = new ArrayList<Transaction>(); //reinitializes arraylist
        
    }
    /**
     @param date
     @param car
     @param salesPerson
     @param type
     @param salePRice
     @return display from transaction class. 
     */
    public String add(Calendar date, Car car,String salesPerson,String type,double salePrice){
        Random rand00m = new Random();
        transactionID = rand00m.nextInt(99)+1;
        Transaction temp = new Transaction(date,car,salesPerson,type,salePrice,transactionID);
        trans.add(temp);
        return temp.display(); 
        
    }
    public void printAll(){
        for(int x = 0;x<trans.size();x++){
            System.out.println(trans.get(x).display());
        }
    }
    /**
     * 
     * @param id
     * @return gets the id and returns the transaction element associated with the ID.
     */
   public Transaction getTransaction(int id){
    boolean status = false;
    int holder = 0;
    for(int x=0;x<trans.size();x++){
        if(trans.get(x).get_transactionID() == id){
            holder = x;
            status = true;
        }
    }
    if(status == true){
        return trans.get(holder);
    }
    else{return null;}
   }
   public void monthOutput(int m){
    m--;
    for(int x=0;x<trans.size();x++){
        if(trans.get(x).get_month() == m){
            System.out.println(trans.get(x).display());
        }
    }
}
/**
 * 
 * @return transactionID;
 */
    public int getID(){
       return transactionID;
    }
    /**
     * 
     * @return goes through all transactions and if its buy, the revenue adds the price, else subtracts
     */
    public double totalYearRevenue(){
        double num= 0;
        for(int x=0;x<trans.size();x++){
            if(trans.get(x).get_TransactionType().equals("BUY")){
            num += trans.get(x).get_Price();
        }
        else{
            num = num- trans.get(x).get_Price();
        }
    }
    return num;
}
/**
 * @return totalyearrevenue/ 12months
 */
    public double averageMonth(){
        double rev =  totalYearRevenue()/12;
        //double rounded = (double) Math.round(rev * 100) / 100;
        return rev;
    }
    /**
     * @return every transaction that is buy
     */
    public int carSold(){
        int num= 0;
        for(int x=0;x<trans.size();x++){
            if(trans.get(x).get_TransactionType().equals("BUY")){
            num++;
        }
    }
        return num;
}
/**
 * @return every transaction of type return
 */
public int carReturn(){
    int num= 0;
    for(int x=0;x<trans.size();x++){
        if(trans.get(x).get_TransactionType().equals("RET")){
        num++;
    }
}
    return num;
}
/**
 * @return topmonth by checking each transaction and assigning each month to a number; 
 */
    public String topMonth(){
        ArrayList<Integer> maxSale = new ArrayList<Integer>(12);
        maxSale.add(0);maxSale.add(0);maxSale.add(0);maxSale.add(0);maxSale.add(0);maxSale.add(0);maxSale.add(0);maxSale.add(0);maxSale.add(0);maxSale.add(0);maxSale.add(0);maxSale.add(0);
        int max = 0;
        int month = 0;
        String monthString = "";
        for(int x=0;x<trans.size();x++){
            if(trans.get(x).get_TransactionType().equals("BUY")){ //checks all buys
                if(trans.get(x).get_month() == 0) //if the month is 0, the element of maxsale is incremented, does this for all 12 months
                    maxSale.set(0,maxSale.get(0)+1);
                if(trans.get(x).get_month() == 1)
                    maxSale.set(1,maxSale.get(1)+1);
                if(trans.get(x).get_month() == 2)
                    maxSale.set(2,maxSale.get(2)+1);
                if(trans.get(x).get_month() == 3)
                    maxSale.set(3,maxSale.get(3)+1);
                if(trans.get(x).get_month() == 4)
                    maxSale.set(4,maxSale.get(4)+1); 
                if(trans.get(x).get_month() == 5)
                    maxSale.set(5,maxSale.get(5)+1);
                if(trans.get(x).get_month() == 6)
                    maxSale.set(6,maxSale.get(6)+1);
                if(trans.get(x).get_month() == 7)
                    maxSale.set(7,maxSale.get(7)+1);
                if(trans.get(x).get_month() == 8)
                    maxSale.set(8,maxSale.get(8)+1);
                if(trans.get(x).get_month() == 9)
                    maxSale.set(9,maxSale.get(9)+1);
                if(trans.get(x).get_month() == 10)
                    maxSale.set(10,maxSale.get(10)+1);
                if(trans.get(x).get_month() == 11)
                    maxSale.set(11,maxSale.get(11)+1);
            }
        }
        for(int x=0;x<maxSale.size();x++){
            if(maxSale.get(x) > max){ 
                max = maxSale.get(x); //finds month with most sales. 
                month =x;
            }
        }
        if(month == 0)monthString = "January";
        if(month == 1)monthString = "February";
        if(month == 2)monthString = "March";
        if(month == 3)monthString = "April";
        if(month == 4)monthString = "May";
        if(month == 5)monthString = "June";
        if(month == 6)monthString = "July"; //converts the indexes to months. 
        if(month == 7)monthString = "August";
        if(month == 8)monthString = "September";
        if(month == 9)monthString = "October";
        if(month == 10)monthString = "November";
        if(month == 11)monthString = "December";
        return monthString +" Cars Sold: "+ max;
    }
 }



    
