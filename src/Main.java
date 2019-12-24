import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static int num;
    public static String[] members;

    public static void main(String[] args) {

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
