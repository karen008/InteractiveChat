import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static String chat_history = "";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Select number of chat members: ");
        int num = sc.nextInt();
        for (int i = 1; i <num+1 ; i++) {

            System.out.println("Member "+i);
            System.out.println("Press number for action");
            System.out.println("1. Send message");
            System.out.println("2. Exit chat");

            Scanner sc_select = new Scanner(System.in);

            int num_select = sc_select.nextInt();

            switch (num_select){
                case 1 :
                    Scanner chat_message = new Scanner(System.in);
                    System.out.println("Enter your message");
                    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    Date date = new Date();
                    String message = dateFormat.format(date) + " : " + "Member " + i + " : " + chat_message.nextLine();
                    chat_history += message+ "\n";
                case 2 :
                    System.out.println("You have exited chat");

            }
        }

        System.out.println(chat_history);

    }
}
