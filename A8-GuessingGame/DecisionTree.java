import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class DecisionTree extends BinaryTree<String> {


   /**
    * @param data root for the tree
    */
   public DecisionTree(String data) {
       super(data);
   }


   /**
    * @param data root for the tree
    * @param left left nodes for the tree
    * @param right right nodes for the tree
    */
   public DecisionTree(String data, BinaryTree<String> left, BinaryTree<String> right) {
       super(data, left, right);
   }


   /**
    * @param other decision tree object being passed in
    */ 
   public DecisionTree(DecisionTree other) {
       super(other);
   }


   // overwriting specialized methods

   /**
    * Overwritting getLeft so it is usable in the decision tree class
    */
   @Override
   public DecisionTree getLeft() {
       return (DecisionTree) super.getLeft();
   }

   /**
    * Overwritting getRight so it is usable in the decision tree class
    */
   @Override
   public DecisionTree getRight() {
       return (DecisionTree) super.getRight();
   }

   /**
    * Overwritting setLeft so it can be implemented in decision tree
    */
   @Override
   public void setLeft(BinaryTree<String> left) {
       super.setLeft(left);
   }


   /**
    * @param left data which will be added as the left node
    */
   public void setLeft(DecisionTree left) {
       super.setLeft(left);
   }

   /**
    * Overwritting getLeft so it can be implemented in decision tree
    */
   @Override
   public void setRight(BinaryTree<String> right) {
       super.setRight(right);
   }


   /**
    * @param right data which will be added as the right node
    */
   public void setRight(DecisionTree right) {
       super.setRight(right);
   }


   /**
    *
    * @param path path which will be taken to reach correct guess
    * Moves through the tree and follows path
    * @return current node at end of path
    */
   public DecisionTree followPath(String path) {
       DecisionTree current = this; // Start at root
       for (int i = 0; i < path.length(); i++) {


           if (path.charAt(i) == 'Y') { // If answer is yes move left
               current = current.getLeft(); // Update current
           } else if (path.charAt(i) == 'N') { // If answer is no move right
               current = current.getRight(); // Update current


           }


       }
       return current;
   }

/**
 * 
 * @param fileName name of file that is being writen
 * Method will rewrite tree using breadth first search
 * @param inputNode root of tree
 */
   public static void writeTree(String fileName,DecisionTree inputNode) {
       // BinaryTree<String> current = this;
       // Create a node queue
       java.util.LinkedList<BinaryTree<String>> nodeQueue = new java.util.LinkedList<>();
       java.util.LinkedList<String> pathQueue = new java.util.LinkedList<>();
       java.util.ArrayList<String> finalLines = new java.util.ArrayList<>();
       // boolean[] visited = new boolean[V];
       // Add first node to linked list
       nodeQueue.addLast(inputNode);
       pathQueue.addLast("");
       while (!nodeQueue.isEmpty()) {
           BinaryTree<String> currentNode = nodeQueue.removeFirst();
           String currentPath = pathQueue.removeFirst();


           if (currentNode.getLeft() != null) {
               nodeQueue.addLast(currentNode.getLeft());
               String leftPath = currentPath + "Y";
               pathQueue.add(leftPath);
           }
           if (currentNode.getRight() != null) {
               nodeQueue.addLast(currentNode.getRight());
               String rightPath = currentPath + "N";
               pathQueue.add(rightPath);
           }
           String finalPath = currentPath + " " + currentNode.getData();
           finalLines.add(finalPath);
       }


       try {
           PrintWriter out = new PrintWriter(new FileWriter(fileName));


           for (int i = 0; i < finalLines.size(); i++) {
               out.println(finalLines.get(i));
           }


           out.close();
       } catch (IOException e) {
           System.out.println("Problem writing the file: " + e.getMessage());


       }


   }

   /**
    * 
    * @param fileName of file which is being passed in
    * Will read file and data accordingly
    * @param root root of tree
    */
   public static void readTree(String fileName, DecisionTree root) {
       try {
           Scanner file = new Scanner(new java.io.File(fileName));
           while (file.hasNextLine()) {
               String line = file.nextLine();
               int spaceIndex = line.indexOf(" ");
               int length = line.length();
               String path = line.substring(0, spaceIndex);
               String data = line.substring(spaceIndex + 1, length);
               DecisionTree current = root;


               if (path.isEmpty()) {
                   root.setData(data);
                   continue;
               }


               String parentPath = path.substring(0, path.length() - 1);
               char lastCharacter = path.charAt(path.length() - 1);


               for (int i = 0; i < parentPath.length(); i++) {
                   char character = parentPath.charAt(i);
                   if (character == 'Y') {
                       if (current.getLeft() == null) {
                           current.setLeft(new DecisionTree((String) null));


                       }
                       current = current.getLeft();
                   }
                   else if (character == 'N') {
                       if (current.getRight() == null) {
                           current.setRight(new DecisionTree((String) null));
                       }
                       current = current.getRight();


                   }


               }
               DecisionTree newNode = new DecisionTree(data);


               if (lastCharacter == 'Y') {
                   current.setLeft(newNode);
               } else if (lastCharacter == 'N') {
                       current.setRight(newNode);
               }
           }


           file.close();
       } catch (Exception e) {
           System.out.println("cannot make file" + e);


       }


   }


   // Sample decision tree with 7 nodes
   /**
    * Sample decision tree for testing
    * @param args
    */
   public static void main(String[] args) {
       DecisionTree cow = new DecisionTree("Cow");
       DecisionTree pig = new DecisionTree("Pig");
       DecisionTree snake = new DecisionTree("Snake");
       DecisionTree lizard = new DecisionTree("Lizard");


       DecisionTree hooves = new DecisionTree("Does it have hooves?", cow, lizard);
       DecisionTree reptile = new DecisionTree("Is it a reptile?", snake, pig);


       DecisionTree root = new DecisionTree("Is it a mammal?", hooves, reptile);


       // writeTree("Animal.txt", root);
       // readTree("Animal.txt", root);
   }
}



