/** 
 * @Original authors Dr. Garrett Goodman and Meisam Amjad
 * @new author Iris Currie
 * Section: CSE 174 K
 * Date: 11/6/23
 * Starter code for Project 3.
 */
public class Project3 {

    public static void main(String[] args) {
        System.out.println("***Testing notDescending***");
        System.out.println("false == " + notDescending(1, 2, 3));
        System.out.println("true == " + notDescending(3, 2, 1));
        System.out.println("true == " + notDescending(-2, -3, -4));
        System.out.println("");
   
        System.out.println("***Testing checknums***");
        System.out.println("true == " + checknums(2, 1, 10, true));
        System.out.println("false == " + checknums(0, 1, 10, true));
        System.out.println("true == " + checknums(10, 9, 10, true));
        System.out.println("");
   
        System.out.println("***Testing getSubstring***");
        System.out.println("a == " + getSubstring("abc", 0, 1, true));
        System.out.println("000111222 == " + getSubstring("000111222", 0, 3, false));
        System.out.println("Hell == " + getSubstring("Hello", 0, 4, true));
        System.out.println("");
     
        System.out.println("***Testing switchXO***");
        System.out.println("O == " + switchXO("X"));
        System.out.println(" == " + switchXO(""));
        System.out.println("XO == " + switchXO("OX"));
        System.out.println("");
   
        System.out.println("***Testing nextDiv7***");
        System.out.println("7 == " + nextDiv7(1));
        System.out.println("14 == " + nextDiv7(8));
        System.out.println("14 == " + nextDiv7(9));
        System.out.println("");
   
        System.out.println("***Testing changeOddChars***");
        System.out.println("aB == " + changeOddChars("ab", true));
        System.out.println("aAaAa == " + changeOddChars("aaaaa", true));
        System.out.println("aBcSdE == " + changeOddChars("ABcsde", true));
        System.out.println("");
   
        System.out.println("***Testing whatMissing***");
        System.out.println("b == " + whatMissing("ac"));
        System.out.println(" == " + whatMissing("ab"));
        System.out.println("f == " + whatMissing("abcdeg"));
        System.out.println("");
   
        System.out.println("***Testing getSimilars***");
        System.out.println("ab == " + getSimilars("ab", "ab", "ab"));
        System.out.println("a == " + getSimilars("ab", "ac", "ad"));
        System.out.println("a == " + getSimilars("a", "ab", "abc"));
        System.out.println("");
   
        System.out.println("***Testing addDigits***");
        System.out.println("0 == " + addDigits(""));
        System.out.println("0 == " + addDigits("a0"));
        System.out.println("3 == " + addDigits("1fr2"));
        System.out.println("");
   
        System.out.println("***Testing addDivisibles***");
        System.out.println("12 == " + addDivisibles(12));
        System.out.println("0 == " + addDivisibles(1));
        System.out.println("0 == " + addDivisibles(5));
        System.out.println("");
   
        System.out.println("***Testing fixSentence***");
        System.out.println("Hi == " + fixSentence("hi"));
        System.out.println("Good Morning == " + fixSentence("Good morning"));
        System.out.println("Nice Job! == " + fixSentence("nice job!"));
        System.out.println("");
     
        System.out.println("***Testing switchSigns***");
        System.out.println(" == " + switchSigns(""));
        System.out.println("-1 == " + switchSigns("1"));
        System.out.println("2 -3 == " + switchSigns("-2 3"));
        System.out.println("");
   
        System.out.println("***Testing doubleHi***");
        System.out.println("true == " + doubleHi("HiHi"));
        System.out.println("false == " + doubleHi(""));
        System.out.println("true == " + doubleHi("Hkji3Hi"));
        System.out.println("");
   
        System.out.println("***Testing putTogether***");
        System.out.println(" == " + putTogether(""));
        System.out.println("aacd == " + putTogether("acda"));
        System.out.println("11ww222gddm == " + putTogether("1w2g1dw2md2"));
        System.out.println("");
   
        System.out.println("***Testing getSecMax***");
        System.out.println("1.2 == " + getSecMax("2 1.2"));
        System.out.println("4.1 == " + getSecMax("1.3 4.1 5"));
        System.out.println("0.0 == " + getSecMax(""));
        System.out.println("");
    }
    /* Description: checks if 3 inputted nubmers are in descending order
    *@param1 the first checked number
    *@param2 the second checked number
    *@param3 the third checked number
    *@return true or false if it is descending
    */
    public static boolean notDescending(int a, int b, int c) {
        //check to see if in decending order
        if (a > b && b > c) {
            return true;
        } else {
            return false;
        }
    }

    /* Description: checks if a number is somewhere in relation to a range given
    *@param1 the checked number
    *@param2 the beginning of the range
    *@param3 the end of the range
    *@param4 how the number should be checked
    *@return true or false if the number is correctly in realtion to the range
    */
    public static boolean checknums(int n, int start, int end, boolean check) {
        //check which way to go about the method
        if (check) {
            //if n is between start and end
            if (n >= start && n <= end) {
                return true;
            } else {
                return false;
            }
        } else {
            //if n is outside start and end
            if (n < start || n > end) {
                return true;
            } else {
                return false;
            }
        }
    }

    /* Description: gets a specific substring from the string
    *@param1 the parent string
    *@param2 the beginning of the substring
    *@param3 the end of the substring
    *@param4 how the substring should be made
    *@return the substring
    */
    public static String getSubstring(String str, int start, int end, boolean check) {
        if (check) {
            return str.substring(start, end);
        } else {
            return str.substring(start);
        }
    }
    /* Description: Switches X's to O's and vice versa in a string
    *@param1 the parent string
    *@return the switched string
    */
    public static String switchXO(String str) {
        String newString = "";
        for (int i = 0; i < str.length(); i++) {
            //get the character at each position
            char letter = str.charAt(i);
            //switch if necessary
            if (letter == 'X') {
                letter = 'O';
            } else if (letter == 'O') {
                letter = 'X';
            }
            
            newString += letter;
        }
        return newString;
    }
    /* Description: finds the next number that is divisible by 7
    *@param1 the starting number
    *@return the next number divisibly by 7
    */
    public static int nextDiv7(int num) {
        boolean found = false;
        do {
            if (num % 7 == 0) {
                found = true;
            } else {
                num++;
            }
        } while (!found);
        return num;
    }
    /* Description: alternates between capital and lowercase leters in a string
    *@param1 the parent string
    *@param2 wether the first nubmer should be uppercase or lowercase
    *@return the final string
    */
    public static String changeOddChars(String str, boolean odd) {
        String newString = "";
        int counter = 1;
        for (int i = 0; i < str.length(); i++) {
            char letter = str.charAt(i);
            //check which way to go about this
            if (odd) {
                //see if we are on an odd or even number
                if (counter % 2 == 1) {
                    letter = Character.toLowerCase(letter);
                } else {
                    letter = Character.toUpperCase(letter);
                }
            } else {
                //see if we are on an odd or even number
                if (counter % 2 == 0) {
                    letter = Character.toLowerCase(letter);
                } else {
                    letter = Character.toUpperCase(letter);
                }
            }
            counter++;
            newString += Character.toString(letter);
        }
        return newString;
    }
    
    /* Description: finds the missing number in a string of numbers
    *@param1 the parent string
    *@return the missing number
    */
    public static String whatMissing(String str) {
        String newString = "";
        for (int i = 0; i < str.length() - 1; i++) {
            //get the character we are checking as well as the one after it
            char letter = str.charAt(i);
            char nextLetter = str.charAt(i + 1);
            //if the next letter in sequence is not what should come next
            if (letter + 1 != nextLetter) {
                newString = Character.toString(letter + 1);
                //exit the loop
                break;
            }
        }
        return newString;
    }
    
    /* Description: finds the similar characters between 3 strings
    *@param1 the first checked string
    *@param2 the second checked string
    *@param3 the third checked tring
    *@return the charcaters shared between strings
    */
    public static String getSimilars(String s1, String s2, String s3) {
        String newString = "";
        //figure out which string is the shortest and use that for the following loop
        int length;
        int l1 = s1.length();
        int l2 = s2.length();
        int l3 = s3.length();
        if (l1 <= l2 && l1 <= l3) {
            length = l1;
        } else if (l2 <= l1 && l2 <= l3) {
            length = l2;
        } else {
            length = l3;
        }
        //check similars
        for (int i = 0; i < length; i++) {
            //get the necessary character from each string
            char letter1 = s1.charAt(i);
            char letter2 = s2.charAt(i);
            char letter3 = s3.charAt(i);
            //if they are all the same letter add it to the string
            if (letter1 == letter2 && letter1 == letter3) {
                newString += Character.toString(letter1);
            }
        }
        return newString;
    }
    
    /* Description: adds all teh digits found in a string together
    *@param1 the parent string
    *@return the added numbers
    */
    public static int addDigits(String str) {
        int sum = 0;
        String sub;
        for (int i = 0; i < str.length(); i++) {
            sub = str.substring(i, i + 1);
            //try to add a number
            try {
                sum += Integer.parseInt(sub); 
            } catch (NumberFormatException e) {
                //if there isnt one just keep going
            }
        }
        return sum;
    }
    
    /* Description: adds together all even divisibles of a number
    *@param1 the checked number
    *@return the sum of divisibles
    */
    public static int addDivisibles(int num) {
        //any number less than 4 automatically will only have 0 returned
        if (num < 4) {
            return 0;
        }
        
        int sum = 0;
        int checking = num - 1;
        do {
            //Even divisibles are all that matter
            if (checking % 2 == 0) {
                //if it is a divisible add it to sum
                if (num % checking == 0) {
                    sum += checking;
                }
            }
            checking--;
        } while (checking > 1);
        return sum;
    }
    
    /* Description: capitalizes the first letter of every word in a string
    *@param1 the parent string
    *@return the "fixed" string
    */
    public static String fixSentence(String str) {
        String newString = "";
        //auto capitalize first letter
        char letter = str.charAt(0);
        letter = Character.toUpperCase(letter);
        newString += Character.toString(letter);
        //loop through for rest
        for (int i = 1; i < str.length(); i++) {
            char spaceFinder = str.charAt(i);
            //if the character found is a space
            if (spaceFinder == ' ') {
                //capitalize the next letter and skip over it
                letter = str.charAt(i + 1);
                letter = Character.toUpperCase(letter);
                newString += " " + Character.toString(letter);
                i++;
            } else {
                //otherwise add the letter to the sentence
                newString += Character.toString(spaceFinder);
            }
        }
        
        return newString;
    }
    
    /* Description: switches between positive and negative numbers in a string
    *@param1 the parent string
    *@return the switched string
    */
    public static String switchSigns(String str) {
        int start = 0;
        int end = 0;
        String newString = "";
        //check if the string has any length
        if (str.length() > 0) {
            do {
                //find where a space is
                end = str.indexOf(' ', start);
                //if there is no space then set it to be the length of the string
                if (end == -1) {
                    end = str.length();
                }
                //make a substring out of it
                String sub = str.substring(start, end);
            
                //check if positive or negative and switch
                
                if (sub.charAt(0) == '-') {
                    sub = sub.substring(1);
                } else {
                    sub = "-" + sub;
                }
                
                
                newString += sub + " ";
                //begin from the previous space
                start = end + 1;
            } while (end != str.length());
        }
        return newString;
    }
    
    /* Description: finds if the word Hi is repeated twice in a string
    *@param1 the parent string
    *@return if Hi has been found twice
    */
    public static boolean doubleHi(String str) {
        boolean twoHi = false;
        boolean oneHi = false;
        boolean hFound = false;
        boolean iFound = false;
        
        for (int i = 0; i < str.length(); i++) {
            char letter = str.charAt(i);
            //if h hasnt been found look to see if the letter is H
            if (!hFound) {
                if (letter == 'H') {
                    hFound = true;
                }
                //if it has been found look to see if letter is i
            } else {
                if (letter == 'i') {
                    iFound = true;
                }
            }
            //if this is the first Hi found
            if (hFound && iFound && !oneHi) {
                oneHi = true;
                //reset the letters
                hFound = false;
                iFound = false;
            } else if (hFound && iFound && oneHi) {
                //if this is the second hi found exit the loop
                twoHi = true;
                break;
            }
        }
        
        return twoHi;
    }

    /* Description: takes a string and gorups up all instances of a character
    *@param1 the parent string
    *@return the grouped string
    */
    public static String putTogether(String str) {
        String newString = "";
        char letter = ' ';
        do {
            //reset values
            int counter = 0;
            if (str.length() > 0) {
                //set letter to the first letter left in str
                letter = str.charAt(0);
            }
            int start = 0;
            int end = 0;
            do {
                //find the next instance of a letter
                end = str.indexOf(letter, start);
                //if there is no space then set it to be the length of the string
                if (end == -1) {
                    end = str.length();
                } else {
                    //if we haven't hit the end of the string increase counter
                    counter++;
                }
                start = end + 1;
            } while (end != str.length());
            //print out the letter found for the number of times it was in str
            for (int i = 0; i < counter; i++) {
                newString += Character.toString(letter);
            }
            //replace every instance of the letter with nothingness
            str = str.replaceAll(Character.toString(letter), "");
        } while (str.length() > 0);
        
        return newString;
    }
    
    /* Description: finds the second highest number in a string of doubles
    *@param1 the parent string
    *@return the second highest number
    */
    public static double getSecMax(String str) {
        int end = 0;
        int start = 0;
        double max = 0.0;
        double secMax = 0.0;
        double checker = 0.0;
        if (str.length() > 0) {
            do {
                //step 1: get a number form the string
                //find where a space is
                end = str.indexOf(' ', start);
                //if there is no space then set it to be the length of the string
                if (end == -1) {
                    end = str.length();
                }
                //make a substring out of it
                String sub = str.substring(start, end);
                checker = Double.parseDouble(sub);
                //begin from the previous space
                start = end + 1;
                
                //step 2: check the number
                if (checker > max) {
                    //move the numbers down a position
                    secMax = max;
                    max = checker;
                } else if (checker > secMax) {
                    secMax = checker;
                }
                
            } while (end != str.length());
        }
        return secMax;
    }

}
