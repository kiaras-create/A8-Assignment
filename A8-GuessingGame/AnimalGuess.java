import java.util.Scanner;

/**
 * This class has some helper methods for getting user input in the AnimalGuess game.
 * It reads input (including yes/no) and keeps the game from breaking if the user enters something other than yes/no.

 */
public class AnimalGuess{

    //Reads user input
    public static Scanner scanner = new Scanner(System.in);

    /**
     * Read a line of input with handling the error
     * 
     * @param question the question to display to the user
     * @return user input
     */
    public static String readLine(String question){
        System.out.print(question); //Prints the question for the user
        String input = ""; //empty string placeholder
        while(true){
            try{
                input = scanner.nextLine();

                //Checks for empty input
                if (input.isEmpty()){
                    throw new IllegalArgumentException("Input cannot be empty");
                }
                break;
            } catch (IllegalArgumentException e){
                System.out.println("Please try again");
                System.out.println(question); //Prints the question again
            }
        }
        return input;
    }

    

/**
 * Asks the user a yes/no question and handles invalid input by asking for input again and again until entered a valid input
 * it accepts 'yes', 'y', 'no', or 'n'
 * Responds gracefully to invalid inputs
 * 
 * @param question the yes/no question to ask the user
 * @return true if the user answers 'yes' or 'y' and false if 'no' or 'n'
 */
public static boolean getYesOrNo(String question){

    //Loop for until valid input (yes/y, no/n) received
    while(true){

         //Prints the question for the user plus two answer options (yes/no)
        System.out.println(question + "(yes/no):");

        String input = scanner.nextLine();

        //convert the input to lowercase letter
        input = input.toLowerCase();

        //Check if the input is yes
        if (input.equals("yes") || input.equals("y")){
            return true;

        //Check if the input is no
        } else if (input.equals("no") || input.equals("n")){
            return false;
        } else{

            //Prints a message if invalid answer entered
            System.out.println("Please answer with yes or no");
        }
    }
}
    //For testing purposes
    public static void main(String[] args){

        boolean answer = getYesOrNo("Is your animal a Crocodile?");
        if (answer){
            System.out.println("Ok, nice.");
        } else{
            System.out.println("Hm, I see.");
        }
    }
}