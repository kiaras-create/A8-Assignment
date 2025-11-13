public class AnimalGuess {
    // Your program should also respond gracefully if the user enters something nonsensical, perhaps due to a typo.  Ambiguous answers should not be assumed to be 'yes' or 'no'.

    /**
     * handles responses to nonsensical inputs 
     * @param input
     * @return nothing
     */
    private static void handlingResponses(String input) {
        // converts input to all lowercase
        input.toLowerCase();
        // if input doesn't equal yes or no, then ask player to reenter answer
        if ((!input.equals("yes")) || (!input.equals("no"))) {
            System.out.println("Please reenter your answer.");
            // TO-DO: potentially redirect this code to the scanner in whichever method it is from/relevant
        } 
    }

}