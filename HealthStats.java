/*
Raneem Ali
Health Stats
*/


//Import user input scanner
import java.util.Scanner;
import java.util.Random;

//Define class
public class HealthStats{
   public static void main(String [] args){
         Scanner input = new Scanner(System.in);
   
//Define char value
   String name;
   String userChoice;  
   String gender;
   double height;
   double calcBMR;
   int age;
   int weight;
   double actLevel;
   
   
//Print opening statement
   System.out.print("Welcome to Health Stats!\nTo get started, press enter. ");
      input.nextLine();
   System.out.print("\nENTER your First and Last initial: ");
      name = input.next();

//Prints statements to prompt user to input all the required information needed for all the defined variables
   System.out.print("\nENTER your AGE: ");
      age = input.nextInt();
   System.out.print("\nENTER your GENDER (eg. F for Female, M for Male): ");
      gender = input.next();
   System.out.print("\nENTER your HEIGHT (eg. 5'11 = 5.11): ");
      height = input.nextDouble();
   System.out.print("\nENTER your WEIGHT: ");
      weight = input.nextInt();
   System.out.print("\nEnter 1.2 for, Sedentary(0-1 days) \nEnter 1.4 for, Light(1-3 days) \nEnter 1.6 for, Moderate(3-5 days) \nEnter 1.7 for, Very Active(6-7 days) \nEnter 1.9 for, Extremly Active(2x/day)\nENTER your ACTIVITY LEVEL: ");
       actLevel = input.nextDouble();
    
//Prompt Receipt/Summary printing method 
displayMessage(name, gender, age, height, weight, actLevel);

    }

//Calculate BMI Method
public static double calcBMI(double height, int weight){
     double calcBMI = (703 * weight/((height * 12) * (height * 12)));
     return calcBMI;
 }

//Calculate BMR Method
public static double calcBMR(double height, int weight, String gender, int age){
   double calcBMR;
   if (gender == "Male"){
     	     calcBMR = (66 + (6.23 * weight) + (12.7 * height) - (6.8 * age));
           }
      else
	        calcBMR = (655 + (4.35 * weight) + (4.7 * height) - (4.7 *age));
           
   return calcBMR;
}
//Calculate TDEE Method 

public static double calcTDEE (double calcBMR, double actLevel){
     double calcTDEE = actLevel * calcBMR;
     return calcTDEE;
}
    public static void evaluateStats(double bmi) {
        System.out.println("Your BMI is " + evaluateBMI(bmi));
    }

    // Evaluate BMI level
    public static String evaluateBMI(double bmi) {
        if (bmi < 18.5) {
            return "Underweight (below 18.5)";
        } else if (bmi >= 18.5 && bmi < 24.9) {
            return "Normal Weight (between 18.5 - 24.9)";
        } else if (bmi >= 25 && bmi < 29.9) {
            return "Overweight (between 25 - 29.9)";
        } else {
            return "Obese (above 29.9)";
        }
    }

//Display Account profile summary including, Name, Age, Height, Weight, Activity Level, BMI, BMR, TDEE
   public static void displayMessage(String name, String gender, int age, double height, int weight, double actLevel){
      Scanner input = new Scanner(System.in);      
      double calcBMI = calcBMI(height, weight);
      double calcBMR = calcBMR(height, weight, gender, age);
      double calcTDEE = calcTDEE(calcBMR, actLevel);
      System.out.print("-----------------------------------------------------------------------------------");     
      System.out.print("\n|\tName\t|\tAge\t|\tHeight\t|\tWeight\t|\tActLevel\t|\tBMI\t|\t BMR \t|\tTDEE\t|");
      System.out.print("\n-----------------------------------------------------------------------------------");
      System.out.printf("\n|\t%4s\t|\t%3d\t|\t%6.2f\t|\t%6d\t|\t%8.2f\t|\t%3.2f\t|\t%4.2f|\t%4.2f|", name, age, height, weight, actLevel, calcBMI, calcBMR, calcTDEE);   
// Ask user if they want more information or to exit
      System.out.print("\n\nDo you want to receive more information about your Stats? Press ENTER if yes, or enter 'DONE' to exit: ");
         String userChoice = input.nextLine();

      if (userChoice.trim().equalsIgnoreCase("DONE")) {
         System.out.println("\nThank you for using Health Stats. Goodbye!");
      } else {
// Print more information here
      System.out.print("\n-----------------------------------------------------------------------------------------------------------");
      System.out.println("\n\nMore Information about TDEE, BMI, and BMR:");
      System.out.printf("\n- BMI (Body Mass Index) is a measure of body fat based on your weight and height.\nBased on your BMI score, below is an is an assement on your calculated stats in accordance with national clinical guidelines. \n");
      evaluateStats(calcBMI);
      double bulk = calcTDEE + 500;
      double cut = calcTDEE - 500;
      System.out.printf("\n- TDEE (Total Daily Energy Expenditure) is the estimated number of calories you burn in a day based on your activity level. \nIf you are looking for maintainence, %.2f is the ideal daily calorie intake based on your inputs. \nIf you are looking to bulk, %.2f is the ideal daily calorie intake based on your inputs. \nIf you are looking to cut, %.2f is the ideal daily calorie intake based on your inputs. ", calcTDEE, bulk, cut);

      System.out.printf("\n\n- BMR (Basal Metabolic Rate) is the number of calories your body needs to maintain basic functions at rest, NOT including activity level. \nYour BMR score means that your body would require approximately %.2f calories per day to maintain basic physiological functions while at rest.", calcBMR, calcBMR);
      System.out.println("\n\nWhy is it important to keep up with these statistics?\nThe ultimate purpose of these tools are to provide an understanding of ones energy consumption allowing them to manipulate their intake in favor of their goals.\nWhether your looking to maintain, loose, or gain weight, these calculated Health Stats are the crucial first step.");
      System.out.println("\nThank you for using Health Stats. Goodbye!");
 
              }
      


    }
}    