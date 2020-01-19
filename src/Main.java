import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static int num; // number of members
    public static String[] members; // members array

    public static void main(String[] args) {

// Creating an object of class Members
        Members member = new Members();

        Scanner sc = new Scanner(System.in);
        System.out.print("Select number of chat members: ");

        try
        {
            num = sc.nextInt();                }
        catch (InputMismatchException e)
        {
            System.out.println("Please enter only numbers");
        }

        members = new String[num];

        member.createMembers(num,members);
        member.startChat(members);

    }

}
