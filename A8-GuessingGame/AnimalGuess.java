import java.util.Scanner;

/**
 * Class which runs the animal guess and runs the game
 */
public class AnimalGuess {


   //Reads user input
   public static Scanner scanner = new Scanner(System.in);


   /**
    * handles responses to nonsensical inputs
    *
    * @param input
    * @return nothing
    */
   // private static void handlingResponses(String input) {
   //     // converts input to all lowercase
   //     input.toLowerCase();
   //     // if input doesn't equal yes or no, then ask player to reenter answer
   //     if ((!input.equals("yes")) || (!input.equals("no"))) {
   //         System.out.println("Please reenter your answer.");
   //         // TO-DO: potentially redirect this code to the scanner in whichever method it
   //         // is from/relevant
   //         // call shakila's method that elicits a yes/no answer from user w/same question
   //         // being asked
   //     }
   // }


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
   while(true) {


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
       } else {


           //Prints a message if invalid answer entered
           System.out.println("Please answer with yes or no");
       }
   }}


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
    * extends decision tree when program fails to guess correct animal
    * method occurs after program guesses and answer is no
    *
    * @param node, the leaf node that contains the incorrect answer
    * @return nothing
    */
   private static void extendDecisionTree(String wrongAnimal, DecisionTree node) {
       // asks user what animal they were thinking of
       System.out.println("Oh no, I couldn't guess your animal! It's not a " + wrongAnimal + ".");
       System.out.println("What animal were you thinking of?");
       String correctAnimal = scanner.nextLine();


       // asks user distinguishing question and sets the data of node to question
       String questionPrompt = "Type a yes or no question that distinguishes between the" + " " + correctAnimal + " " + "and the " + wrongAnimal + ":";
       System.out.println(questionPrompt);
       //node.setData(question);
       // user answers and convert answer to all lower case
       String question = scanner.nextLine();
       node.setData(question);


       boolean userYes = getYesOrNo("Is the answer to this question yes for this animal: " + correctAnimal );
       if (userYes){
           node.setLeft(new DecisionTree(correctAnimal));
           node.setRight(new DecisionTree(wrongAnimal));
       } else{
           node.setLeft(new DecisionTree(wrongAnimal));
           node.setRight(new DecisionTree(correctAnimal));
       }
       //     answer.toLowerCase();


   //     // if answer is yes, create left child node with user's animal
   //     if (answer.equals("yes")) {
   //         BinaryTree<String> lChild = new BinaryTree<>(correctAnimal);
   //         node.setLeft(lChild);
   //         // BinaryTree<String> rChild = new BinaryTree<>(wrongAnimal);
   //         // node.setRight(rChild);
   //         // if answer is no, create right child w/user's animal
   //     } else if (answer.equals("no")) {
   //         BinaryTree<String> rChild = new BinaryTree<>(correctAnimal);
   //         node.setLeft(rChild);
   //         // BinaryTree<String> lChild = new BinaryTree<>(wrongAnimal);
   //         // otherwise, call handlingResponses method to handle nonsensical inputs
   //     } else {
   //         readLine(question);
   //     }


   }


   //For testing purposes
   /**
    * 
    * @param args arguments that will be passed in
    * Main method to run the program
    */
   public static void main(String[] args){
       String fileName = args[0];


       DecisionTree root = new DecisionTree((String) null);
       DecisionTree.readTree(fileName, root);


       System.out.println("Think of an animal and the computer will attempt to guess it");


       DecisionTree current = root;


       while (current.getLeft() != null || current.getRight() != null ){
           boolean yes = getYesOrNo(current.getData());
           if (yes){
               current = current.getLeft();
           } else {
               current = current.getRight();
           }
       }
       boolean guess = getYesOrNo("Is the animal" + current.getData() + "?");
       if (guess){
           System.out.println("Computer guess is correct!");
       } else {
           extendDecisionTree(current.getData(), current);
       }
       System.out.println("Done");
   //     boolean answer = getYesOrNo("Is your animal a Crocodile?");
   //     if (answer){
   //         System.out.println("Wow that's cool.");
   //     } else{
   //         System.out.println("Hm, I see.");
   //     }
   }






}

