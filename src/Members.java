import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Members {

    Scanner scanner = new Scanner(System.in);
    public String chatHistory = "";
    public DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

//  createMembers method creates members, give them names and add them to the array
    public void createMembers(int numberOfMembers, String[] members) {
        for (int j = 0; j < numberOfMembers; j++) {
            System.out.println("Please enter name for member " + (j+1));
            String memberName = scanner.nextLine();
            members[j] = memberName;
        }
    }

//  startChat method starts chat for members that have been created and chat goes until all members exit chat
    public void startChat(String[] members){
        while (members.length>1) {
            for (int i = 0; i < members.length; i++) {
                System.out.println(members[i]);
                System.out.println("Press number for action");
                System.out.println("1. Send message");
                System.out.println("2. Exit chat");

                int NumSelect = 0;

                try
                {
                    NumSelect = scanner.nextInt();                }
                catch (InputMismatchException e)
                {
                    System.out.println("Please enter only 1 or 2");
                    i = i-1;
                }

                switch (NumSelect) {
                    case 1:
                        System.out.println("Enter your message");
                        Date date = new Date();
                        String message = dateFormat.format(date) + " : " + members[i] + " : " + scanner.nextLine();
                        chatHistory += message + "\n";
                        break;
                    case 2:
                        System.out.println(members[i] + " have exited chat");
                        System.out.println("");
                        Date date2 = new Date();
                        chatHistory += dateFormat.format(date2) + " : " + members[i] + " have exited chat \n";
                        members = removeTheElement(members, i);
                        i = i-1;
                        break;
                }

                System.out.println();
                System.out.println("Current chat history");
                System.out.println("--------------------");
                System.out.println(chatHistory);
                System.out.println("--------------------");

            }
        }

        System.out.println(chatHistory);

    }

//  removeTheElement method removes member who have exited the chat from members array
    public String[] removeTheElement(String[] arr, int index) {
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
