import java.util.ArrayList;
import java.util.Scanner;
public class ListMaker {
    Scanner in = new Scanner(System.in);
    static ArrayList<String> myArrList=new ArrayList<>();
    public static void main(String[] args)
    {menu();}
    static void menu() {
        Scanner in = new Scanner(System.in);
        System.out.println("Options:\n"
                + "A - Add an item to the list\n"
                + "D - Delete an item from the list\n"
                + "P - Print (i.e. display) the list\n"
                + "Q - Quit the program\n"
                + "Type your option here: ");
        boolean YN;
        YN=false;
        do {
            switch (getRegExString().toUpperCase()) {
                case "A":
                    System.out.println("Enter an item: ");
                    String str = in.nextLine();
                    add(str);
                    menu();
                case "D":
                    int index = getRangedInt(in, "Enter the item list number", 1, myArrList.size());
                    delete(index - 1);
                    menu();
                case "P":
                    print();
                    menu();
                case "Q":
                    YN = SafeInput.getYNConfirm(in, "Are you sure you want to quit the program (Y/N)");
            }
        }while (YN == false);
        System.exit(0);
    }
    static void print()
    {int count=1;
        for(int i=0;i<myArrList.size();i++) {
            System.out.println(count+"."+myArrList.get(i));
            count++;}
    }
    static void add(String i)
    {
        myArrList.add(i);
    }
    static String getRegExString()
    {
        Scanner in=new Scanner(System.in);
        String k=in.next();
        if(k=="A"||k=="a"||k=="D"||k=="d"||k=="Q"||k=="q"||k=="P"||k=="p")
        {menu();
        }
        return k;
    }
    static int getRangedInt(Scanner sc, String prompt, int low, int high) {
        int input;
        do {
            System.out.print(prompt + ": ");
            while (!sc.hasNextInt()) {
                System.out.println("Please enter a valid integer.");
                sc.next();
            }
            input = sc.nextInt();
        } while (input < low || input > high);
        return input;
    }
    static void delete(int l)
    {
        myArrList.remove(l);
    }
}