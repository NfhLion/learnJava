package StudentSystem;

import java.util.Scanner;

import StudentSystem.util.*;

public class ManageSystem {

    private StudentManage manage;
    private boolean systemState;
    private Scanner scan;

    public ManageSystem() {
        systemState = Config.SYSTEM_OPEN;
        manage = new StudentManage();
        scan = new Scanner(System.in);
    }

    public static void printMenu() {
        System.out.println("------------------------------------------------");
        System.out.println("---------------- Students system ---------------");
        System.out.println("------------------- 1. insert ------------------");
        System.out.println("------------------- 2. remove ------------------");
        System.out.println("------------------- 3. search ------------------");
        System.out.println("------------------- 4. print  ------------------");
        System.out.println("------------------- 5. break  ------------------");
        System.out.println("------------------------------------------------");
    }

    public void start(StudentManage manage, int key) {
        switch (key) {
            case Config.MENU_ONE:
                System.out.println("Please input Student name:");
                String name = scan.nextLine();
                System.out.println("Please input Student id:");
                String id = scan.nextLine();
                System.out.println("Please input Student age:");
                String age = scan.nextLine();
                System.out.println("Please input Student sex:");
                String sex = scan.nextLine();
                manage.insert(name, id, Integer.parseInt(age), sex);
                break;
            case Config.MENU_TWO:
                System.out.println("remove last value");
                manage.remove();
                break;
            case Config.MENU_THREE:
                System.out.println("Please input Student id:");
                String sid = scan.nextLine();
                Student st = manage.searchFromId(sid);
                if (st != null) {
                    st.formatPrint();
                } else {
                    System.out.println("No search the student!");
                }
                break;
            case Config.MENU_FORE:
                manage.printAllStudentInfo();
                break;
            case Config.MENU_FIVE:
                System.out.println("System Close, off!");
                scan.close();
                systemState = Config.SYSTEM_CLOSE;
                break;
            default :
                manage.printAllStudentInfo();
                System.out.println("System Close, off!");
                scan.close();
                systemState = Config.SYSTEM_CLOSE;
        }
    }

    public void run() {
        int key = 0;
        Scanner scan = new Scanner(System.in);
        while (true) {
            if (!systemState) {
                break;
            }
            System.out.println("Please input key:");
            key = scan.nextInt();
            start(manage, key);
        }
        scan.close();
    }

    public static void main(String args[]) {
        ManageSystem.printMenu();
        ManageSystem system = new ManageSystem();
        system.run();
    }
}
