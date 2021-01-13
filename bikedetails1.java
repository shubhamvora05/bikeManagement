

import java.util.*;
import java.lang.*;
import java.io.*;
 
abstract class Bike {
 
    static int[][] BikesPrice = { { 300, 320, 350, 400 }, { 200, 220, 240, 250 }, { 700, 750, 800, 900 },
            { 400, 420, 450, 480 } };
 
    static int[][] BikesQuantity = { { 3, 3, 3, 3 }, { 3, 3, 3, 3 }, { 3, 3, 3, 3 }, { 3, 3, 3, 3 } };
 
    int[][] BikesPenalty = { { 25, 30, 35, 35 }, { 20, 25, 30, 30 }, { 110, 130, 150, 180 }, { 30, 40, 45, 50 } };
    
    static  String[] Types = { "Regular", "NonGear", "Sports", "Battery" };
    static String[] Colors = { "White", "Black", "Red", "Blue" };
    long time1, time2, DueTime = 60;
    static int ChoosenType = 1, ChoosenColor = 1, ChoosenTime = 1;
    
    //2D Vector "Status" for showing current status 
    static Vector<Vector<Integer>> Status = new Vector<Vector<Integer>>();
 
    Scanner sc = new Scanner(System.in);
 
    void BikeDetails() {
        for (int i = 0; i < 4; i++) {
            System.out.println("\n  ##### " + Types[i] + " Bikes  #####");
            System.out.println("\nColors  " + "Price   " + "Penalty    " + "Quantity");
 
            for (int j = 0; j < 4; j++) {
                // System.out.println(Colors[j] + " " + BikesPrice[i][j] + " " +
                // BikesPenalty[i][j]
                // + " " + BikesQuantity[i][j]);
                System.out.print(Colors[j]);
                if (Colors[j] == "Red")
                    System.out.print("  ");
                if (Colors[j] == "Blue")
                    System.out.print(" ");
 
                System.out.print("    " + BikesPrice[i][j] + "     " + BikesPenalty[i][j] + "        "
                        + BikesQuantity[i][j] + "\n");
            }
        }
    }
 
    void TakeBike() {
    	System.out.println("   -->Enter your Choice for Types of Bike: ");
        System.out.println("     1. Regular");
        System.out.println("     2. NonGear");
        System.out.println("     3. Sports");
        System.out.println("     4. Battery");
 
        ChoosenType = sc.nextInt();
 
        System.out.println("   -->Enter your Choice For colors : ");
        System.out.println("     1. White");
        System.out.println("     2. Black");
        System.out.println("     3. Red");
        System.out.println("     4. Blue");
 
        ChoosenColor = sc.nextInt();
 
        System.out.println("   -->How much time will you choose to get bike ? ");
        System.out.println("     1. On Hourly Basis");
        System.out.println("     2. On Daily Basis");
        System.out.println("     3. On Weekly Basis");
 
        ChoosenTime = sc.nextInt();
 
        if (BikesQuantity[ChoosenType - 1][ChoosenColor - 1] >= 1) {
            BikesQuantity[ChoosenType - 1][ChoosenColor - 1]--;
 
            time1 = System.currentTimeMillis() / 60000;
        } else {
            System.out.println("----Sorry, Bike is not Available----");
        }
    }
 
    void ReturnBike() {
        BikesQuantity[ChoosenType - 1][ChoosenColor - 1]++;
        System.out.println("We Hope You Enjoy!!");
        time2 = System.currentTimeMillis() / 60000;
    }
    
    //prints current status of bike taken
    static void CurrentStatus(int I) {
    	   
    	//adding bikeType index, bikeColor index and that-bike price to "Status" vector
        Status.add(new Vector<Integer> (Arrays.asList(ChoosenType, ChoosenColor, BikesPrice[ChoosenType - 1][ChoosenColor - 1])));
        
        System.out.println("\n  Current Bike Taken: ");
        
        //Printing status
        System.out.println("\n  -->Bike Type : " + Types[Status.get(I-1).get(0) - 1]);
        System.out.println("  -->Bike Color : " + Colors[Status.get(I-1).get(1) - 1]);
        System.out.println("  -->Bike Price : " + Status.get(I-1).get(2));
        
        
    }
 
}
 
class Rent extends Bike {
    long Time = time2 - time1;
 
    int GetHourRent() {
        int Amount = BikesPrice[ChoosenType - 1][ChoosenColor - 1];
        Amount *= 1;
 
        // penalty case:
        if (Time > DueTime) {
            Amount += BikesPenalty[ChoosenType - 1][ChoosenColor - 1];
        }
        return Amount;
    }
 
    int GetDayRent() {
        int Amount = BikesPrice[ChoosenType - 1][ChoosenColor - 1];
 
        Amount *= (0.98 * 24);
 
        // penalty case:
        if (Time > DueTime) {
            Amount += BikesPenalty[ChoosenType - 1][ChoosenColor - 1];
        }
        return Amount;
    }
 
    int GetWeekRent() {
        int Amount = BikesPrice[ChoosenType - 1][ChoosenColor - 1];
 
        Amount *= (0.89 * 24 * 7);
 
        // penalty case:
        if (Time > DueTime) {
            Amount += BikesPenalty[ChoosenType - 1][ChoosenColor - 1];
        }
        return Amount;
    }
}
 

class All_User {
 
    static int I = 0, Index = 0;
    
    static String user, pass1, name, phone, email, pass2;
    static String User, pass, Vs1 = null, Vs2 = null;
    static int i;

	// String Hash Map to store user name and password
	static HashMap<String, String> detailsHashMap = new HashMap<String, String>();
	
	//2D vector "V" for storing name and email
	static Vector<Vector<String>> V = new Vector<Vector<String>>();
	
 
    public static void CreateUser() {
    	
        System.out.println("\n----------------------------------");
        System.out.println("--> Enter Your Details Carefully :");
        System.out.println("----------------------------------");
        Scanner sc = new Scanner(System.in);
 
        System.out.println("\nEnter your name : ");
        name = sc.next();
        
        //phone = sc.next();
 
        System.out.println("\nEnter your Email id : ");
        email = sc.next();
 
        System.out.println("\nEnter your Username : ");
        user = sc.next();
 
        System.out.println("\nEnter your Password : ");
        pass1 = sc.next();
 
        System.out.println("\nConfirm Password : ");
        pass2 = sc.next();
 
        System.out.println("\n#########################");
 
        if (pass1.equals(pass2)) {
        	
        	//adding key-> pass1 and value-> user to Hash Map
        	detailsHashMap.put(pass1, user);
        	
        	
        	//adding name -> Ith Row, 0th Column ; email -> Ith Row, 1st Column;
        	V.add(new Vector<String> (Arrays.asList(name, email)));
 
            I++;
 
            System.out.println(" Succesfully Registered!");
            System.out.println("#########################");
        } else {
            System.out.println("Password Doesn't Match");
        }
 
    }
 
    public static boolean CheckUser() {
 
        
        Scanner sc = new Scanner(System.in);
 
        System.out.println("\nEnter your Username : ");
        User = sc.nextLine();
 
        System.out.println("\nEnter your Password : ");
        pass = sc.nextLine();
        
        System.out.println(V.get(0).get(0));
 
        for (i = 0; i <= I; i++) {
			
        
            if (V.get(i).get(0).equals(User) && V.get(i).get(1).equals(pass)) {
                Index = i;
 
                return true;
            }
        }
 
        return false;
    }
 
    public static void Profile() {

    	System.out.println("  PROFILE :-");
        System.out.println("\n  --> User Name : " + detailsHashMap.get(pass1));
        System.out.println("  --> Name :      " + V.get(Index).get(0));
        System.out.println("  --> Email Id :  " + V.get(Index).get(1));
    }
    
    public int GetIndex() {
    	
    	return I;
    }
}
 
class MyClass1 {
    public static void main(String[] args) {
        System.out.println("-------------------------------------");
        System.out.println("####### Welcome to Online BRS #######");
        System.out.println("-------------------------------------");
        Scanner sc = new Scanner(System.in);
 
        while (true) {
            System.out.println("\nSELECT CHOICE :\n ");
            System.out.println(" 1. Register");
            System.out.println(" 2. Log-in");
            System.out.println(" 3. Exit");
 
            int choice, authenticated = 0;
            choice = sc.nextInt();
 
            if (choice == 1) {
                All_User.CreateUser();
                authenticated = 1;
            }
 
            else if (choice == 2) {
                boolean check = All_User.CheckUser();
 
                if (check)
                    authenticated = 1;
                else {
                    System.out.println("Invalid username or password");
                    continue;
                }
            }
 
            else if (choice == 3) {
                break;
            }
 
            if (authenticated == 1) {
                System.out.println("\n\n##__WELCOME__##\n");
                while (true) {
                    int select = 0;
                    System.out.println("\nSelect Choice :\n ");
                    System.out.println("  1. Show Avaiable Bikes");
                    System.out.println("  2. Profile");
                    System.out.println("  3. Take Bike");
                    System.out.println("  4. Return Bike");
                    System.out.println("  5. Current Status");
                    System.out.println("  6. Log-out");
 
                    select = sc.nextInt();
                    Rent TakeAndReturnBike = new Rent();
 
                    if (select == 1) {
                        Rent Details = new Rent();
                        Details.BikeDetails();
                    } 
                    else if (select == 2) {
                        All_User.Profile();
                    } 
                    else if (select == 3) {
                        TakeAndReturnBike.TakeBike();
 
                        System.out.println("  -->Your rent of this bike is " + TakeAndReturnBike.GetHourRent() + "Rs.");
                        System.out.println("  -->if you don't return bike on time then there is "
                                + TakeAndReturnBike.BikesPenalty[TakeAndReturnBike.ChoosenType
                                        - 1][TakeAndReturnBike.ChoosenColor - 1]
                                + "Rs penalty");
                        System.out.println("\n  ------Enjoy your Ride!!------");
                    } 
                    else if (select == 4) {
                        TakeAndReturnBike.ReturnBike();
                    } 
                    else if(select == 5) {
                    	
                    	All_User x = new All_User();
                    	TakeAndReturnBike.CurrentStatus(x.GetIndex());
                    }
                    else if (select == 6) {
                        break;
                    }
                }
            } else {
                System.out.println("\nInvalid Usename or password");
            }
        }
    }
}