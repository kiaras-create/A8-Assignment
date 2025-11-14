import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class DecisionTree extends BinaryTree<String>{

    public DecisionTree(String data){
        super(data);
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
        java.util.LinkedList<BinaryTree<String>> pathQueue = new java.util.LinkedList<>();
        // boolean[] visited = new boolean[V];
        //Add first node to linked list 
        nodeQueue.addLast(this);
        while (!nodeQueue.isEmpty()){
            BinaryTree<String> currentNode = nodeQueue.removeFirst();
            pathQueue.addLast(currentNode);
            if(currentNode.getLeft() != null){
                nodeQueue.addLast(currentNode.getLeft());
            } 
            if(currentNode.getRight() != null){
                nodeQueue.addLast(currentNode.getRight());
            }
        }
        try {
        PrintWriter out = new PrintWriter(new FileWriter(fileName));

        while(!pathQueue.isEmpty()){
            out.println(pathQueue.removeFirst().toString());
        }
        out.close();
        }
        catch (IOException e) {
            System.out.println("Problem writing the file: " + e.getMessage());


        }
    }
    
    public void readTree(String fileName){

    }

    }

    