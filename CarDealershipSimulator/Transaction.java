// Sheehan Phan 500890672
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
class Transaction{
    private Calendar date;
    private Car car;
    private String salesPerson;
    private String type;
    private double salePrice;
    private int transactionID;
    public Transaction(Calendar date, Car car,String salesPerson,String type,double salePrice, int transactionID){
        this.date = date;
        this.car = car;
        this.salesPerson = salesPerson;
        this.type = type;
        this.salePrice= salePrice;
        //car.set_price(salePrice);
        this.transactionID = transactionID;
    }
    public String display(){
       SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMM dd, yyyy");
       return "ID: "+transactionID + " "+sdf.format(date.getTime())+" "+ type + " SalesPerson: "+salesPerson+" Car: " + car.display();
    }
     /**
     * Below are all the getters and setter methods for the instance variables which are private. 
     */
    public int get_transactionID(){
        return this.transactionID;
    }
    public int get_month(){
        return date.get(Calendar.MONTH);
    }
    public double get_Price(){
        return salePrice;
    }
    public String get_TransactionType(){
        return type;
    }



}
    
