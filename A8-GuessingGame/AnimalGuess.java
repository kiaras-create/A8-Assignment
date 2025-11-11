import java.util.Scanner;
public class AnimalGuess{
    public static Scanner scanner = new Scanner(System.in);

    

}

public static boolean getYesOrNo(String prompt){
    while(true){
        System.out.println(prompt + "(yes/no):");
        String input = in.nextline().trim().toLowerCase();

        if (input.equals("yes") || input.equals("y")){
            return true;
        } else if (input.equals("no") || input.equals("n")){
            return false;
        } else{
            System.out.println("Please answer with yes or no");
        }
    }
}