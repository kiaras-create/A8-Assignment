import java.util.Scanner;

public class AnimalGuess {

    /**
     * handles responses to nonsensical inputs
     * 
     * @param input
     * @return nothing
     */
    private static void handlingResponses(String input) {
        // converts input to all lowercase
        input.toLowerCase();
        // if input doesn't equal yes or no, then ask player to reenter answer
        if ((!input.equals("yes")) || (!input.equals("no"))) {
            System.out.println("Please reenter your answer.");
            // TO-DO: potentially redirect this code to the scanner in whichever method it
            // is from/relevant
            // call shakila's method that elicits a yes/no answer from user w/same question
            // being asked
        }
    }

    /**
     * extends decision tree when program fails to guess correct animal
     * method occurs after program guesses and answer is no
     * 
     * @param node, the leaf node that contains the incorrect answer
     * @return nothing
     */
    private static void extendDecisionTree(String wrongAnimal, BinaryTree<String> node) {
        // asks user what animal they were thinking of
        System.out.println("Oh no, I couldn't guess your animal! It's not a " + wrongAnimal + ".");
        System.out.println("What animal were you thinking of?");
        Scanner scanner = new Scanner(System.in);
        String correctAnimal = scanner.nextLine();

        // asks user distinguishing question and sets the data of node to question
        String question = "Is the animal you were thinking of a mammal?";
        System.out.println(question);
        node.setData(question);
        // user answers and convert answer to all lower case
        String answer = scanner.nextLine();
        answer.toLowerCase();

        // if answer is yes, create left child node with user's animal
        if (answer.equals("yes")) {
            BinaryTree<String> lChild = new BinaryTree<>(correctAnimal);
            node.setLeft(lChild);
            // BinaryTree<String> rChild = new BinaryTree<>(wrongAnimal);
            // node.setRight(rChild);
            // if answer is no, create right child w/user's animal
        } else if (answer.equals("no")) {
            BinaryTree<String> rChild = new BinaryTree<>(correctAnimal);
            node.setLeft(rChild);
            // BinaryTree<String> lChild = new BinaryTree<>(wrongAnimal);
            // otherwise, call handlingResponses method to handle nonsensical inputs
        } else {
            handlingResponses(answer);
        }

        scanner.close();

    }

}