// Sheehan Phan 500890672
import java.util.*;
class Car extends Vehicle implements Comparable<Car>{ //extends vehicle(acquires all the variables and methods) then implements comparable<Car>
    private String model;
    private int maxRange;
    private double safetyRating; //sets up all required instance variables 
    private boolean AWD;
    private double price;
    public static enum Model{SEDAN, SUV, SPORTS, MINIVAN;} //used enums instead of final constants to make it more simple
    public Car(String mfr, String color, Model model,Power power,/*int numWheels,*/double safetyRating, int maxRange, boolean AWD, double price){
        super(mfr, color,power,4/*numWheels */); //uses inhibit the variables from vehicle class. 
        if (model == Car.Model.SEDAN){
            this.model = "SEDAN";
           }
        else if(model == Car.Model.SUV){
            this.model = "SUV";            //if statement because i decided to use enums, so im going to have to assign model to its appropriate value depending on model.
        }
        else if(model == Car.Model.SPORTS){
            this.model = "SPORTS";
        }
        else{this.model = "MINIVAN";}
        this.maxRange = maxRange;
        this.safetyRating = safetyRating; //assigning all instance variable to parameter variables
        this.AWD = AWD;
        this.price = price;
    }
     /**
     * Below are all the getters and setter methods for the instance variables which are private. 
     */
    public double get_price(){
        return this.price; 
    }
    public void set_price(double price){
        this.price=price; 
    }
    public boolean get_AWD(){
        return this.AWD; 
    }
    public void set_AWD(boolean AWD){
        this.AWD = AWD; 
    }
    public int get_maxRange(){
        return this.maxRange; 
    }
    public void set_maxRange(int maxRange){
        this.maxRange = maxRange; 
    }
    public double get_safetyRating(){
        return this.safetyRating; 
    }
    public void set_safetyRating(double safetyRating){
        this.safetyRating = safetyRating; 
    }
    /**
     * calls the display method then adds model, price, safetyRating and maxrange. 
     */
    public String display(){
        return super.display() +" "+ model +" "+price+"$" + " SF: "+safetyRating+" RNG: " +maxRange; 
    }
    /**
     * @param car object
     * @return if the equal method in vehicle class returns true and ONLY IF it is true, it checks the equality of model and awd. 
     */
    public boolean equals(Object otherv){
        Car other = (Car) otherv; 
        if(super.equals(other)){ 
            if(this.model.equals(other.model) && this.AWD==other.AWD){
                return true;
            }
            else{return false;}
        }
        else
        {return false;}
    }
    /**
     * compareto function for price.
     */
    public int compareTo(Car other){
            if(this.price > other.price){
                return 1; //compareTo is used when sort by price is called, so when collections.sort is called it defaults to this compareTO method 
            }
            if(this.price < other.price){
                return -1;
            }
            else{return 0;}
        
        }
       
        }
    
    


/*
SortMR sortMR = new SortMR
Collections.sort(arraylist,sortMR)

*/
  
