// Sheehan Phan 500890672
import java.util.*;
import java.util.Scanner;
import java.io.FileNotFoundException ;
import java.io.IOException ;
import java.io.File ;
public class CarDealershipSimulator 
{ 
  public static void main(String[] args) throws FileNotFoundException
  {
	  // Create a CarDealership object
		CarDealership Vibes = new CarDealership(); //creates a default cardealership object called vibes because i was vibing. 
		// Then create an (initially empty) array list of type Car
		ArrayList<Car> cars = new ArrayList<Car>();
		try{
		File file = new File("cars.txt");
		Scanner scans = new Scanner(file);
		while(scans.hasNextLine()){
			String individual = scans.nextLine();
			String [] carSpecs = (individual.split("\\s+")); 
			/**
			 * so below is a bunch of code because i had to split the text file into segments based on the parameters for the car objects, i used enums which made
			 * it extremely complicated because instead of taking the given string i have to have 20,0000 if statements to convert it to the approporiate enum type. 
			 */
			if(carSpecs[3].equals("ELECTRIC_MOTOR")){
				if(carSpecs[6].equals("AWD")){
				boolean status = true;
				if(carSpecs[2].equals("SEDAN")){
					cars.add(new ElectricCar(carSpecs[0],carSpecs[1],Car.Model.SEDAN,Vehicle.Power.ELECTRIC_MOTOR,Double.parseDouble(carSpecs[4]),Integer.parseInt(carSpecs[5]),status,Integer.parseInt(carSpecs[7]),"Lithium",Integer.parseInt(carSpecs[8])));
				}
				if(carSpecs[2].equals("SPORTS")){
					cars.add(new ElectricCar(carSpecs[0],carSpecs[1],Car.Model.SPORTS,Vehicle.Power.ELECTRIC_MOTOR,Double.parseDouble(carSpecs[4]),Integer.parseInt(carSpecs[5]),status,Integer.parseInt(carSpecs[7]),"Lithium",Integer.parseInt(carSpecs[8])));
				}
				if(carSpecs[2].equals("MINIVAN")){
					cars.add(new ElectricCar(carSpecs[0],carSpecs[1],Car.Model.MINIVAN,Vehicle.Power.ELECTRIC_MOTOR,Double.parseDouble(carSpecs[4]),Integer.parseInt(carSpecs[5]),status,Integer.parseInt(carSpecs[7]),"Lithium",Integer.parseInt(carSpecs[8])));
				}	
			}
			else{
				boolean status = false;
				if(carSpecs[2].equals("SEDAN")){
					cars.add(new ElectricCar(carSpecs[0],carSpecs[1],Car.Model.SEDAN,Vehicle.Power.ELECTRIC_MOTOR,Double.parseDouble(carSpecs[4]),Integer.parseInt(carSpecs[5]),status,Integer.parseInt(carSpecs[7]),"Lithium",Integer.parseInt(carSpecs[8])));
				}
				if(carSpecs[2].equals("SPORTS")){
					cars.add(new ElectricCar(carSpecs[0],carSpecs[1],Car.Model.SPORTS,Vehicle.Power.ELECTRIC_MOTOR,Double.parseDouble(carSpecs[4]),Integer.parseInt(carSpecs[5]),status,Integer.parseInt(carSpecs[7]),"Lithium",Integer.parseInt(carSpecs[8])));
				}
				if(carSpecs[2].equals("MINIVAN")){
					cars.add(new ElectricCar(carSpecs[0],carSpecs[1],Car.Model.MINIVAN,Vehicle.Power.ELECTRIC_MOTOR,Double.parseDouble(carSpecs[4]),Integer.parseInt(carSpecs[5]),status,Integer.parseInt(carSpecs[7]),"Lithium",Integer.parseInt(carSpecs[8])));
				}	
			}
		}	
			if(carSpecs[6].equals("AWD")){
			boolean status = true;
			if(carSpecs[2].equals("SEDAN")){
				cars.add(new Car(carSpecs[0],carSpecs[1],Car.Model.SEDAN,Vehicle.Power.GAS_ENGINE,Double.parseDouble(carSpecs[4]),Integer.parseInt(carSpecs[5]),status,Integer.parseInt(carSpecs[7])));
			}
			if(carSpecs[2].equals("SPORTS")){
				cars.add(new Car(carSpecs[0],carSpecs[1],Car.Model.SPORTS,Vehicle.Power.GAS_ENGINE,Double.parseDouble(carSpecs[4]),Integer.parseInt(carSpecs[5]),status,Integer.parseInt(carSpecs[7])));
			}
			if(carSpecs[2].equals("MINIVAN")){
				cars.add(new Car(carSpecs[0],carSpecs[1],Car.Model.MINIVAN,Vehicle.Power.GAS_ENGINE,Double.parseDouble(carSpecs[4]),Integer.parseInt(carSpecs[5]),status,Integer.parseInt(carSpecs[7])));
			}	
			}
			else{
				boolean status = false;
				if(carSpecs[2].equals("SEDAN")){
					cars.add(new Car(carSpecs[0],carSpecs[1],Car.Model.SEDAN,Vehicle.Power.GAS_ENGINE,Double.parseDouble(carSpecs[4]),Integer.parseInt(carSpecs[5]),status,Integer.parseInt(carSpecs[7])));
				}
				if(carSpecs[2].equals("SPORTS")){
					cars.add(new Car(carSpecs[0],carSpecs[1],Car.Model.SPORTS,Vehicle.Power.GAS_ENGINE,Double.parseDouble(carSpecs[4]),Integer.parseInt(carSpecs[5]),status,Integer.parseInt(carSpecs[7])));
				}
				if(carSpecs[2].equals("MINIVAN")){
					cars.add(new Car(carSpecs[0],carSpecs[1],Car.Model.MINIVAN,Vehicle.Power.GAS_ENGINE,Double.parseDouble(carSpecs[4]),Integer.parseInt(carSpecs[5]),status,Integer.parseInt(carSpecs[7])));
				}	
			}	
		}
	}
	catch(FileNotFoundException Exception){
		System.out.println("Error."); 
  } 
			// Then create some new car objects of different types
		Car backup = null; //used to hold the car when buying one
		int car =0;
		int returntemp = 0;
	  // Create a scanner object
	  Scanner scan = new Scanner(System.in);
		// while the scanner has another line
		String allowedCommands = "L Q BUY RET ADD SPR SSR SMR FPR FEL FAW FCL SALES";
		String salesTeam = "TEAM";
		String salesTeam1 = "TOPSP";
		String salesTeam2 = "SALES ";
		String salesTeam3 = "STATS";
		String [] arrayString = allowedCommands.split(" ");
		while(scan.hasNextLine()){
			try{
			String input = scan.nextLine().toUpperCase(); //used .toUpperCase() so users can enter lowercase commands
			Scanner commandLine = new Scanner(input); //uses initial input as the scanner 
			String command = commandLine.next();
			int flag =0; //used to see if the command is valid or not
			for (int x = 0; x<arrayString.length;x++){
				if(command.equals(arrayString[x])){ //checks if the input entered is one of the commands, if it is flag is incremented
					flag++;
				}
			}
			if(flag == 0){//so if the flag is 0 that means the input did not match any commands so it returns the print out.
				System.out.println("Invalid command, please try again.");
			}
			if(command.equals("SALES")){
				if(commandLine.hasNext()){
					command = commandLine.next();
					if(command.equals(salesTeam)){
						Vibes.team();
					}
					if(command.equals(salesTeam1)){
						Vibes.topSale();
					}
					if(command.length() <=3){
						int m = Integer.parseInt(command);
						Vibes.monthOutput(m);
					}
					if(command.equals(salesTeam3)){
						System.out.println("Total Sales: $" +Vibes.totalYearRevenue() + " Total Sold: "+ Vibes.carSold()+" Avg Sales: " + (int)Vibes.averageMonth() +" Total Returned: " + Vibes.carReturn()+" Best Month: "+Vibes.topMonth());
					}
				}
				else{
					Vibes.printAll();
				}
				}
			
			if(command.equals("L")){
				Vibes.displayInventory(); //calls displayInventory which displays the arraylist of cars.
			}
			if(command.equals("Q")){
				return; //Quit, returns.
			}
			if(command.equals("BUY")){
				
				if(commandLine.hasNext()){ //account for error where user tries to buy no car
				car = Integer.parseInt(commandLine.next()); //since the input is a string, i had to convert the string to an int by using parseInt
				String dook = Vibes.buyCar(car); //sets the backup car to the returning car when calling buycar method 
				returntemp  = Vibes.returnID();
				System.out.println(dook);
				}
			}
			if(command.equals("RET")){
					try{
					Vibes.returnCar(returntemp); 
					returntemp = 0;
					}
					catch(NullPointerException e){
						System.out.println("Cannot return exact car twice.");
					}
			}
			if(command.equals("ADD")){
				Vibes.addCars(cars); //adds all the car using addCars
			}	
			if(command.equals("SPR")){
				Vibes.sortByPrice(); //sorts the cars by price using compareTo
			}
			if(command.equals("SSR")){
				Vibes.sortBySafetyRating(); //sorts by safety rating using comparator 
			}
			if(command.equals("SMR")){
				Vibes.sortByMaxRange(); //sorts by max range using comparator 
			}
			if(command.equals("FPR")){
				if(commandLine.hasNext()){//used to account for the error where user tries to filter by price without a price
				double minPrice = Double.parseDouble(commandLine.next()); //since the input is a string, i had to convert the string to an double by using parseInt, reads minprice
				double maxPrice = Double.parseDouble(commandLine.next()); //since the input is a string, i had to convert the string to an double by using parseInt, reads maxprice
				Vibes.filterByPrice(minPrice, maxPrice); //calls price filter with parameters minprice and maxprice
				}
			}
			if(command.equals("FEL")){
				Vibes.filterByElectric(); //calls filterbyelectric which sets electricfilter to true
			}
			if(command.equals("FAW")){
				Vibes.filterByAWD(); //calls filterbyAWD method which sets AWDFilter to true
			}
			if(command.equals("FCL")){
				Vibes.filtersClear(); //all filters are now set to false
			}
			}
		catch(Exception e){
			System.out.println("Error: Please input a command.");
		}
	}
	
	 
  }
}

