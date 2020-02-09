// Sheehan Phan 500890672
class ElectricCar extends Car{
    private int rechargeTime;
    private String batteryType; //sets up all required instance variables 
    public ElectricCar(String mfr, String color,Model model,Power power,/*int numWheels,*/double safetyRating, int maxRange, boolean AWD, double price, String batteryType,int rechargeTime){
        super(mfr, color,model,power,/*numWheels,*/safetyRating,maxRange,AWD,price); //used incorporate the variables from vehicle class. 
        this.rechargeTime = rechargeTime; //assigns the instance variables to the ones in the parameter incase for adjustment 
        this.batteryType = batteryType;
    }
     /**
     * Below are all the getters and setter methods for the instance variables which are private. 
     */
    public int get_rechargeTime(){
        return this.rechargeTime; 
    }
    public void set_rechargeTime(int rechargeTime){
        this.rechargeTime = rechargeTime; 
    }
    public String get_batteryType(){
        return this.batteryType;  
    }
    
    public void set_batteryType(String batteryType){
        this.batteryType = batteryType; 
    }
    /**
     * calls display from car which calls from vehicle then adds battery type and recharge time to end of it
     */
    public String display(){
        return super.display() +" EL, BAT: "+ batteryType +" RCH: "+rechargeTime; 
    }

}

