
import java.util.Scanner;

public class BattleGame {

    /**
     * A simple message that is displayed at the beginning of the game to let
     * the player know the dimensions of the battle grid. This string can be
     * used as: System.out.printf(GRID_SIZE_MSG, gridSize);
     */
    private static final String GRID_SIZE_MSG = 
            "Welcome to exceptional Battleship game.%n"
            + "The battle grid size is %d rows and columns.%n"
            + "Guess the row and column of the ship.%n";

    /**
     * Error message to be displayed if the user enters an illegal row or column
     * value. This string can be used as: System.out.printf(GRID_SIZE_MSG,
     * gridSize);
     */
    private static final String ILLEGAL_LOCATION = 
            "The row and column must be in the range 0 to %d%n";

    /**
     * A message to be displayed to the player when the correct row and column
     * were correctly guessed.
     */
    private static final String SUCCESS_MSG = 
            "You guessed the correct location of the battleship!";

    /**
     * A simple prompt that is displayed to the user to enable them to play the
     * game.
     */
    private static final String INPUT_PROMPT = 
            "Enter input [r<num>, c<num>, grid, quit]: ";

    /**
     * A simple message that is displayed to the user to show that the column
     * value guessed is valid. This string is used with System.out.printf.
     */
    private static final String COL_CORRECT_MSG = 
            "The column value of %d is correct%n";

    /**
     * A simple message that is displayed to the user to show that the row value
     * guessed is valid. This string is used with System.out.printf.
     */
    private static final String ROW_CORRECT_MSG = 
            "The row value of %d is correct%n";

    /**
     * The row value previously guessed by the user.
     */
    private static int guessRow = 0;

    /**
     * The column value previous guessed by the user.
     */
    private static int guessCol = 0;

    // You may add additional class variables as you see fit.

    private static String[][] grid;
    // You may add additional helper methods as needed.

    /**
     * This is the top-level method that is called by the BattleGrid to enable
     * the user to play the game of guessing the correct row & column where a
     * battleship has been randomly hidden.
     * 
     * @param bg The battle grid (typically randomly generated) being used to
     *           play the game.
     */
    public static void play(BattleGrid bg) {
        // run a test to determine size of grid
        System.out.printf(GRID_SIZE_MSG, determineSize(bg));
        Scanner in = new Scanner(System.in);
        boolean done = false;
        // fill the grid with dots
        gridHandler(true);

        do {
            System.out.printf(INPUT_PROMPT);
            // get the users input
            String input = in.nextLine();
            if (input.equals("quit")) {
                // end the loop
                done = true;
            } else if (input.equals("grid")) {
                // prints the grid
                gridHandler(false);
            } else {
                // handles the inputs then guesses
                inputProcessor(input);
                done = guesser(bg);
            }

        } while (!done);
        in.close();
    }

    /**
     * This method figures out the size of the grid that the game will be played
     * on, then creates an array filled with it.
     * 
     * @param bg the battle grid being used for the game.
     * @return the size of the grid.
     */
    private static int determineSize(BattleGrid bg) {
        int size = 0;
        while (true) {
            try {
                // guess with increasing columns
                bg.guess(0, size);
            } catch (BattleGrid.IllegalLocationException e) {
                // creates the grid
                grid = new String[size][size];
                // ends the method
                return size;
            } catch (BattleGrid.InvalidLocationException e) {
                System.out.print("");
            } catch (BattleGrid.InvalidColException e) {
                System.out.print("");
            } catch (BattleGrid.InvalidRowException e) {
                System.out.print("");
            } finally {
                // increase size
                size++;
            }
        }
    }

    /**
     * This method takes a guess input and parses out the syntax into the
     * numbers that will then be used for a guess.
     * 
     * @param input the users input.
     */
    private static void inputProcessor(String input) {
        // if the input is only one value
        if (input.length() < 5) {
            // if is row
            if (input.charAt(0) == 'r') {
                guessRow = Integer.parseInt(input.substring(1));
                // if is column
            } else {
                guessCol = Integer.parseInt(input.substring(1));
            }
            return;
        }
        // find where the space is between inputs
        int space = input.indexOf(" ");

        if (input.charAt(0) == 'r') {
            guessRow = Integer.parseInt(input.substring(1, space));
        } else {
            guessCol = Integer.parseInt(input.substring(1, space));
        }

        if (input.charAt(space + 1) == 'r') {
            guessRow = Integer.parseInt(input.substring(space + 2));
        } else {
            guessCol = Integer.parseInt(input.substring(space + 2));
        }

    }

    /**
     * Makes a guess and then handles whatever exception is thrown based on the
     * result.
     * 
     * @param bg the battle grid being used to play the game.
     * @return if the game is over.
     */
    private static boolean guesser(BattleGrid bg) {
        try {

            bg.guess(guessRow, guessCol);
            // if the guess does not return errors then the guess was correct
            System.out.println(SUCCESS_MSG);
            return true;
        } catch (BattleGrid.InvalidLocationException e) {
            System.out.println(e.getMessage());
        } catch (BattleGrid.InvalidRowException e) {
            System.out.printf(COL_CORRECT_MSG, guessCol);
            System.out.println(e.getMessage());
        } catch (BattleGrid.InvalidColException e) {
            System.out.printf(ROW_CORRECT_MSG, guessRow);
            System.out.println(e.getMessage());
        } catch (BattleGrid.IllegalLocationException e) {
            System.out.printf(ILLEGAL_LOCATION, grid.length);
            return false;
        }
        // places an X on the grid wherever there was a guess
        grid[guessRow][guessCol] = "X";

        return false;
    }

    /**
     * This method will either fill up an array, or print it out.
     * 
     * @param switcher determines whether the method will fill the grid, or
     *                 print the grid.
     */
    private static void gridHandler(boolean switcher) {
        if (! switcher) {
            System.out.println(
                    "Battle grid (previous guess marked with X)");
        }
        
        for (int i = 0; i < grid.length; i++) {
            if (switcher) {
                // fills the grid
                for (int j = 0; j < grid[i].length; j++) {
                    grid[i][j] = ".";
                }
            } else {
                // prints out the grid
                for (int j = 0; j < grid[i].length; j++) {
                    System.out.print(grid[i][j]);
                }
                System.out.println();
            }
        }
    }

}
