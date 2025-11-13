import java.util.Scanner;

/**
 *  
 */
public class AnimalGuess{

    //Reads user input
    public static Scanner scanner = new Scanner(System.in);

    /**
     * 
     * @param question the question to display for user
     * @return user input
     */
    public static String readLine(String question){
        System.out.println(question);
        String input = ""; //empty string placeholder

        return input;
    }

/**
 * Asks the user a yes/no question and handles wrong input by asking for input again and again until entered a valid input
 * it accepts yes, y, no, or n
 * 
 * @param question the yes/no question to ask the user
 * @return true boolean value for yes/y input and false boolean value for no/n input
 */
public static boolean getYesOrNo(String question){

    //Loop for valid input (yes/y, no/n)
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