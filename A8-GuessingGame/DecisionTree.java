import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class DecisionTree extends BinaryTree<String>{

    
    /**
     * @param data
     */
    public DecisionTree(String data){
        super(data);
    }
    /**
     * @param data
     * @param left
     * @param right
     */
    public DecisionTree(String data, BinaryTree<String> left, BinaryTree<String> right) {
        super(data, left, right);
    }

    /**
     * @param other
     */
    public DecisionTree(DecisionTree other) {
        super(other);
    }

    // overwriting specialized methods
    @Override
     public DecisionTree getLeft() {
        return (DecisionTree) super.getLeft();
    }

    @Override
    public DecisionTree getRight() {
        return (DecisionTree) super.getRight();
    }

    @Override
    public void setLeft(BinaryTree<String> left) {
        super.setLeft(left);
    }

    /**
     * @param left
     */
    public void setLeft(DecisionTree left) {
        super.setRight(left);
    }

    @Override
    public void setRight(BinaryTree<String> right) {
            super.setRight(right);
    }

    /**
     * @param right
     */
    public void setRight(DecisionTree right) {
        super.setRight(right);
    }

    /**
     * 
     * @param path
     * Moves through the tree and follows path
     * @return current 
     */
    public BinaryTree<String> followPath(String path){
        BinaryTree<String> current = this; //Start at root
        for (int i = 0; i<path.length(); i ++){

            if (path.charAt(i) == 'Y'){ //If answer is yes move left
                current = current.getLeft(); //Update current
            } 
             else if(path.charAt(i) == 'N') { //If answer is no move right
                current = current.getRight(); //Update current
              
            }
            
        }   
        return current;    
        }

public void writeTree(String fileName){
       BinaryTree<String> current = this;
       // Create a node queue
       java.util.LinkedList<BinaryTree<String>> nodeQueue = new java.util.LinkedList<>();
       java.util.LinkedList<String> pathQueue = new java.util.LinkedList<>();
       java.util.ArrayList<String> finalLines = new java.util.ArrayList<>();
       // boolean[] visited = new boolean[V];
       //Add first node to linked list
       nodeQueue.addLast(this);
       pathQueue.addLast("");
       while (!nodeQueue.isEmpty()){
           BinaryTree<String> currentNode = nodeQueue.removeFirst();
           String currentPath = pathQueue.removeFirst();
          
           if(currentNode.getLeft() != null){
               nodeQueue.addLast(currentNode.getLeft());
               String leftPath = currentPath + "L";
               pathQueue.add(leftPath);
           }
           if(currentNode.getRight() != null){
               nodeQueue.addLast(currentNode.getRight());
               String rightPath = currentPath + "R";
               pathQueue.add(rightPath);
           }
           String finalPath = currentPath + " " + currentNode.getData();
           finalLines.add(finalPath);
       }




       try {
       PrintWriter out = new PrintWriter(new FileWriter(fileName));


       for (int i = 0; i < finalLines.size(); i++){
           out.println(finalLines.get(i));
       }
          
  
       out.close();
       }
       catch (IOException e) {
           System.out.println("Problem writing the file: " + e.getMessage());




       }
         
          
       }
  
   public void readTree(String fileName){
       try{
           Scanner file = new Scanner(new java.io.File(fileName));
           while (file.hasNextLine()){
               BinaryTree<String> current = this;
               String line = file.nextLine();
               int spaceIndex = line.indexOf(" ");
               int length = line.length();
               String path = line.substring(0, spaceIndex);
               String data = line.substring(spaceIndex + 1, length);


               if(path.isEmpty()){
                   this.setData(data);
                   continue;


               }
               for (int i = 0; i<path.length()-1;i++){
                   char character = path.charAt(i);
                   if(character == 'L'){
                       current = current.getLeft();
                   }
                   if(character == 'R'){
                      current = current.getRight();
                   }


               }


               char lastCharacter = path.charAt(path.length()-1);


               if(lastCharacter == 'L'){
                   if(current.getLeft() == null){
                       current.setLeft(new BinaryTree<>(data));
                   } else {
                 
                   current = current.getLeft();
                   }


               }
               else if (lastCharacter == 'R'){
                   if(current.getRight() == null){
                       current.setRight(new BinaryTree<>(data));
                   } else {
                       current.getRight();
                   }


               }


               }
       file.close();
       }
       catch(Exception e){
           System.out.println("cannot make file");
       }
      




   }


   }




    

    



    