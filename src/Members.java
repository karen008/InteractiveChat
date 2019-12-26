import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Members {

    public String chatHistory = "";

    public void createMembers(int numberOfMembers, String[] members) {
        for (int j = 0; j < numberOfMembers; j++) {
            System.out.println("Please enter name for member " + (j+1));
            Scanner getName = new Scanner(System.in);
            String memberName = getName.nextLine();
            members[j] = memberName;
        }
    }

    public void startChat(String[] members){
        while (members.length>1) {
            for (int i = 0; i < members.length; i++) {
                System.out.println(members[i]);
                System.out.println("Press number for action");
                System.out.println("1. Send message");
                System.out.println("2. Exit chat");

                Scanner sc_select = new Scanner(System.in);
                int num_select = 0;
                try
                {
                    num_select = sc_select.nextInt();                }
                catch (InputMismatchException e)
                {
                    System.out.println("Please enter only 1 or 2");
                }


                switch (num_select) {
                    case 1:
                        Scanner chat_message = new Scanner(System.in);
                        System.out.println("Enter your message");
                        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                        Date date = new Date();
                        String message = dateFormat.format(date) + " : " + members[i] + " : " + chat_message.nextLine();
                        chatHistory += message + "\n";
                        break;
                    case 2:
                        System.out.println(members[i] + " have exited chat");
                        System.out.println("");
                        DateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                        Date date2 = new Date();
                        chatHistory += dateFormat2.format(date2) + " : " + members[i] + " have exited chat \n";
                        members = removeTheElement(members, i);
                        i = i-1;
                        break;
                    default:
                        i = i-1;
                }
            }
        }

        System.out.println(chatHistory);

    }

    public static String[] removeTheElement(String[] arr, int index) {
        if (arr == null || index < 0 || index >= arr.length) {
            return arr;
        }

        String[] anotherArray = new String[arr.length - 1];

        for (int i = 0, k = 0; i < arr.length; i++) {

            if (i == index) {
                continue;
            }

            anotherArray[k++] = arr[i];
        }
        return anotherArray;
    }


}
