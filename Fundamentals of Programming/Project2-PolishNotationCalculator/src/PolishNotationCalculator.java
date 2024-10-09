/**
 * Iris Currie
 * Section: K
 * Fall 2023
 * This program calculates math problems based on 
        given input files
 */
 
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
 
public class PolishNotationCalculator {
 
    public static void main(String[] args) throws FileNotFoundException {
        //declare the variables
        Scanner in = new Scanner(System.in);
        System.out.print("Enter input file name: ");
        Scanner sc = new Scanner(new File(in.next()));
        int totals = 0;
        int problems = 0;
        int lineCounter = 0;
        boolean needPrevious;
        boolean divideByZero = false;
        String firstSymbol;
        char symbolChecker;
        
        
        //main loop
        while (sc.hasNextLine()) {
            //reset necessary variables
            lineCounter++;
            needPrevious = false;
            divideByZero = false;
            //get the reader
            String line = sc.nextLine();
            Scanner read = new Scanner(line);
            
            //check to see if the previous total is needed
            firstSymbol = read.next();
            symbolChecker = firstSymbol.charAt(0);
            if (symbolChecker == '<') {
            
                needPrevious = true;
                if (!(firstSymbol.length() == 1)){
                    symbolChecker = firstSymbol.charAt(1);
                }
                
            } else {
                
                totals = 0;
            }
            
            if (!(symbolChecker == '+' || symbolChecker == '-' 
                || symbolChecker == '*' || symbolChecker == '/')) {
                
                System.out.printf("Result of Line %d: No operator %s \n", lineCounter, line);
                continue;
                
            }             
            //make sure no accidental zeroing out
            if (needPrevious == false) {
                totals = read.nextInt();
            }
            
            //loop for doing the math
            while (read.hasNextInt()) {
                //get the next number
                problems = read.nextInt();
                //make the calculation
                if (symbolChecker == '+') {
                    totals += problems;
                } else if (symbolChecker == '-') {
                    totals -= problems;
                } else if (symbolChecker == '*') {
                    totals *= problems;
                } else if (symbolChecker == '/') {
                    //check for divide by zero
                    if (problems == 0) {
                        divideByZero = true;
                        continue;
                    }
                    totals /= problems;
                }
                
            }
            //various outputs
            if (divideByZero == true) {
                System.out.printf("Result of Line %d: Error: / by zero \n", lineCounter);
                totals = 0;
            } else if (read.hasNext()) {
                System.out.printf("Result of Line %d: Non-integer input on this Line \n",
                     lineCounter);
                totals = 0;
            } else {
                System.out.printf("Result of Line %d: %d \n", lineCounter, totals);
            }
            
        } //end of main loop
        
    }
 
}
 