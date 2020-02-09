// Sheehan Phan 500890672
import java.util.*;
public class Vehicle{
    private String mfr;
    private String color; //instance variables as declared by the assignment 
    private int power;
    private int numWheels; 
    public static enum Power{ELECTRIC_MOTOR, GAS_ENGINE;} //used enums instead of final constants to make it more simple
    private int VIN;
    public Vehicle(String mfr, String color, Power power, int numWheels){ //constructor to initalize all instance variables
        this.mfr = mfr;
        this.color = color;
        this.numWheels = numWheels; //assigning all instance variable to parameter variables
        if (power ==Power.ELECTRIC_MOTOR){
         this.power = 0; //if statement because i decided to use enums, so im going to have to assign power to its appropriate value depending on car motor,engine type.
        }
        else{this.power = 1;}
        Random rand00m = new Random();
        this.VIN = rand00m.nextInt(400) +100;
    }
    /**
     * Below are all the getters and setter methods for the instance variables which are private. 
     */
    public int get_VIN(){
        return this.VIN;
    }
    public String get_mfr(){
        return this.mfr; 
    }
    public void set_mfr(String mfr){
        this.mfr = mfr; 
    }
    public String get_color(){
         return this.color; 
    }
    public void set_color(String color){
        this.color = color; 
    }
    public int get_power(){
        return this.power; 
    }
    public void set_power(int power){
        this.power = power; 
    }
    public int get_numWheels(){
        return this.numWheels;
    }
    public void set_numWheels(int numWheels){
        this.numWheels = numWheels; 
    }
    /**
     * @param object
     * @return true if both cars have same manufacturer, power, and numWheels. 
     */
    public boolean equals(Object otherV){
        Vehicle other = (Vehicle) otherV; 
        if(this.mfr.equals(other.get_mfr()) && (this.power == other.get_power()) && (this.numWheels == other.get_numWheels())){
            return true; 
        }
        else{return false;} 
    }
    public String display(){
        return "VIN: " + this.VIN + " "+this.mfr +" "+ this.color; //returns manufacturer and color of car + the new vin
    }
}