/**
 * Iris Currie
 * Section: K
 * Fall 2023
 * This program encrypts the digits of a phone number.
 */
import java.util.Scanner;  // importing Scanner class

public class NumberEncrypter {
    public static void main(String[] args) {
        // Defining a Scanner object
        Scanner in = new Scanner(System.in);
        
        // Prompting the user with a message
        System.out.print("Enter a 10 digit phone number (e.g. 5131234567): ");
        
        // Saving the given number inside a constant variable
        final long PHONE_NUM = in.nextLong();
        
        // Seperating out the components 
        int stationNumber = (int) (PHONE_NUM % 10000);
        int officeCode = (int) ((PHONE_NUM / 10000) % 1000);
        int areaCode = (int) (PHONE_NUM / 10000000);
        
        // Print out the entered number in a standard format
        System.out.printf("(%d) %d - %d\n", areaCode, officeCode, 
            stationNumber);
        
        // Seperate the station number and encrypt it
        int stationNumberOne = stationNumber / 100;
        int stationNumberTwo = stationNumber % 100;
        stationNumberOne = stationNumberOne + 33;
        stationNumberTwo = stationNumberTwo + 33;
        char encryptSN1 = (char) stationNumberOne;
        char encryptSN2 = (char) stationNumberTwo;
        
        System.out.printf("(%d) %d - %s%s\n", areaCode, officeCode, 
            encryptSN2, encryptSN1);
        
        // Combine the area code and office code and encrypt it
        int encryptAcOc = (areaCode * 1000) + officeCode;
        encryptAcOc = Integer.MAX_VALUE - encryptAcOc;
        System.out.println(encryptAcOc);
        
        // Combine everything
        System.out.printf("%s%d%s", encryptSN2, encryptAcOc, encryptSN1);

    }
}
