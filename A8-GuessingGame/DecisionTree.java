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

    }

    