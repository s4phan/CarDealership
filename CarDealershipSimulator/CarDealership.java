// Sheehan Phan 500890672
import java.awt.CardLayout;
import java.util.*;
import java.util.Random;
class CarDealership{
    private boolean AWDFilter = false;
    private boolean electricFilter = false;
    private boolean priceFilter = false;  //create instance variables 
    private double minPrice;
    private double maxPrice;
    private Calendar calendar;
    private Car temp;
    private String ranName;
    private int month;
    ArrayList<Car> cars = new ArrayList<Car>();//array for Car class and ElectricCar class
    SalesTeam salesTeam = new SalesTeam();
    AccountingSystem accountingSystem = new AccountingSystem();
    public CarDealership(){
        cars = new ArrayList<Car>(); //reinitalizes cars array.
    }
    public void addCars(ArrayList<Car> newCars){
        cars.addAll(newCars); //addAll method adds all the entire list of car objects that were created in cardealershipsimulator 
    }
    /**
     * 
     * @param VIN
     * @return the new transaction displayobject. 
     */
    public String buyCar(int VIN)throws Exception{
        int flag =0;
        String transaction = "";
        calendar = new GregorianCalendar(2013,10,28);
        for(int x=0;x<cars.size();x++){
            if(cars.get(x).get_VIN() == VIN){
                flag = 1;
                temp = cars.get(x);
                cars.remove(x);
                ranName = salesTeam.ranSale();
                Random rand00m = new Random();
                month = rand00m.nextInt(12);
                calendar.set(Calendar.MONTH, month);
                int day = rand00m.nextInt(calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
                calendar = new GregorianCalendar(2019,month,day);
                transaction = accountingSystem.add(calendar,temp,ranName,"BUY",temp.get_price());
            }
        }
        if(flag == 0){
            throw new Exception();
        }
        return transaction;
    }  
    /**
     * 
     * @return transactionID
     */
    public int returnID(){
        return accountingSystem.getID();
    }
    /**
     * 
     * @param transaction
     * prints out the same object. 
     */
    public void returnCar(int transaction){
        Transaction temptrans = accountingSystem.getTransaction(transaction);
        Random rand00m = new Random();
        int day = rand00m.nextInt(calendar.getActualMaximum(calendar.DAY_OF_MONTH)-calendar.get(Calendar.DAY_OF_MONTH)) + (calendar.get(Calendar.DAY_OF_MONTH)) ; ;
        calendar.set(Calendar.DAY_OF_MONTH, day);
        if(transaction != 0){
        accountingSystem.add(calendar,temp, ranName ,"RET",temp.get_price());
        cars.add(temp);
        }
        System.out.println(temptrans.display());
    }
    public void printAll(){
        accountingSystem.printAll();;
    }
    /**
     *
     * methods below just call other methods in accounting system
     */
    public String topMonth(){
        return accountingSystem.topMonth();
    }
    public void team(){
        String ahaha = salesTeam.team();
        System.out.println(ahaha);
    }
    public void topSale(){
        String temp = salesTeam.topSale();
        System.out.println(temp);
    }
    public void monthOutput(int m){
        accountingSystem.monthOutput(m);
    }
    public double totalYearRevenue(){
        return accountingSystem.totalYearRevenue();
    }
    public double averageMonth(){
        return accountingSystem.averageMonth();
    }
    public int carSold(){
        return accountingSystem.carSold();
    }
    public int carReturn(){
        return accountingSystem.carReturn();
    }
    public void displayInventory(){
        for(int x=0; x<cars.size();x++){
            boolean status= true; //basically a status checker to see if the specified car should be printed, used for the filters. Also used to AND all the filters
            if(electricFilter == true && status == true){
                if(cars.get(x).get_power()  == 0){} //if statement so when the electricfilter is called, it checks every car object to see if its electric or not, if it is, status is good, if not, false.
                else{status = false;} 
            }
            if(AWDFilter == true && status == true){ //if statement so when the awdfilter flag is set, it checks if the car has AWD or not
                if(cars.get(x).get_AWD()){} //if car has AWD, status stays true, proceeds to next instruction
                else{status=false;}
            }
            if(priceFilter == true&& status == true){ //if statement so when priceFilter is set and status  is true
                if(cars.get(x).get_price() >= minPrice && cars.get(x).get_price() <= maxPrice){} //if the price is in the correct range, do nothing(status stays true)
                else{status=false;} //else return false when it doesnt satisfy the requirements
            }
            if(status == true){ //finally, if all the flags pass, that means status stays true so it can print the car, else, one of the flags set it to false it wont print it, this is used to AND the filters.
                    System.out.println(cars.get(x).display());
                }
        
    }
    
}


public void filterByElectric(){
    this.electricFilter = true;  //when method is called, electric filter is set to true
}
public void filterByAWD(){
    this.AWDFilter = true; //when the method is called, AWD filter is set to true
}
public void filterByPrice(double minPrice, double maxPrice){
    this.priceFilter = true;
    this.minPrice = minPrice; //when method is called, price filter is set to true and the instance variables are reassigned to take the values from parameter values.
    this.maxPrice = maxPrice;
}
public void filtersClear(){
    this.electricFilter = false;
    this.AWDFilter = false; //clears all filters to false. 
    this.priceFilter = false;
}
public void sortByPrice(){
    Collections.sort(cars); //calls compareto method to sort by price
}
public void sortBySafetyRating(){
    //SortSR sortSR = new SortSR(); //creates new object from the sortSR class that uses comparator 
  Collections.sort(cars,new SortSR()); //sorts the car by safetyRating
}
public void sortByMaxRange(){
    //SortMR sortMR = new SortMR(); //creates new object from the sortMR class that uses comparator
    Collections.sort(cars,new SortMR()); //sorts the car by range 
}


class SortSR implements Comparator<Car>{
    public int compare(Car first,Car second){
        if(first.get_safetyRating() < second.get_safetyRating()){
            return 1; //if safetyrating of the first car is less than the second, returns 1;
        }
        if(first.get_safetyRating() > second.get_safetyRating()){
            return -1; //if safetyrating of the first year is larger than the second, return -1
        }
        else{return 0;}


    }
}
class SortMR implements Comparator<Car>{
    public int compare(Car first,Car second){
        if(first.get_maxRange() < second.get_maxRange()){
            return 1; //if range of the first car is less than the second range, returns 1;
        }
        if(first.get_maxRange() > second.get_maxRange()){
            return -1; //if range of the first car is larger than the second range, returns -1;
        }
        else{return 0;}
    }
}

}