public class TestsDecisionTree {

    private static void assertEquals(String expected, String actual, String message) {
        if (expected == null ? actual == null : expected.equals(actual)) {
            System.out.println("PASS: " + message);
        } else {
            System.err.println("FAIL: " + message + " -- expected: \"" + expected + "\" but was: \"" + actual + "\"");
        }
    }

    //Sample decision tree with 7 nodes
    
    public static void main(String[] args) {

        //Setting tree
    
        DecisionTree cow = new DecisionTree("Cow");
        DecisionTree pig = new DecisionTree("Pig");
        DecisionTree snake = new DecisionTree("Snake");
        DecisionTree lizard = new DecisionTree("Lizard");

        DecisionTree hooves = new DecisionTree("Does it have hooves?", cow, pig);
        DecisionTree reptile = new DecisionTree("Is it a reptile?", snake, lizard);

        DecisionTree root = new DecisionTree("Is it a mammal?", hooves, reptile ); //root
    

        //testing navigation
        assertEquals("Is it a mammal?", root.getData(), "root data");
        assertEquals("Does it have hooves?", root.getLeft().getData(), "Left root data");
        assertEquals("Is it a reptile?", root.getRight().getData(), "Right root data");
        assertEquals("Pig", root.getLeft().getRight().getData(), "Root.left.right is Pig");
        assertEquals("Snake", root.getRight().getLeft().getData(), "Root.right.left is Snake");
    }
}
