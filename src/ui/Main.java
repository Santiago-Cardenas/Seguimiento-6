package ui;

import model.Sets;

import java.util.Scanner;

public class Main {

    private Scanner sc;
    private Sets sets;
    private boolean exit;


    public Main() {
        sc = new Scanner(System.in);
        sets = new Sets();
        exit=false;
    }

    public static void main(String[] args){
        ui.Main main = new ui.Main();
        while(main.exit==false){
            main.menu();
        }
    }

    public void menu() {
        System.out.println("\n");
        System.out.println("Please select an option\n"+
                "1)Create 2 sets\n"+
                "2)Operations with sets\n"+
                "3)Exit\n");
        int option=sc.nextInt();
        exit=false;
        sc.nextLine();
        switch(option) {

            case 1:
                addElementsMenu();
                break;

            case 2:
                operations_menu();
                break;

            case 3:
                System.out.println("Goodbye\n");
                exit=true;
                break;

        }
    }

    public void operations_menu() {
        System.out.println("Please select an option\n"+
                "1)Union\n"+
                "2)Intersection\n"+
                "3)Arithmetic difference 4\n"+
                "4)Go Back\n");
        int option=sc.nextInt();
        sc.nextLine();
        switch(option) {

            case 1:
                if(sets.union()==null){
                    System.out.println("Please add elements to the sets first!");
                }
                else {
                    System.out.println(sets.union());
                }
                operations_menu();
                break;

            case 2:
                if(sets.intersection()==null){
                    System.out.println("Please add elements to the sets first!");
                }
                else {
                    System.out.println(sets.intersection());
                }
                operations_menu();
                break;

            case 3:
                if(sets.arithmeticDiff()==null){
                    System.out.println("Please add elements to the sets first!");
                }
                else {
                    System.out.println(sets.arithmeticDiff());
                }
                operations_menu();
                break;

            default:
                break;

        }
    }

    public void addElementsMenu(){
        System.out.println("Please select an option\n"+
                "1)Add an element to set 1\n"+
                "2)Add an element to set 2\n"+
                "3)Go Back\n");
        int option=sc.nextInt();
        sc.nextLine();
        switch(option) {

            case 1:
                System.out.println("Please write what number you would like to add into set 1");
                int element= sc.nextInt();
                sets.add2Set(element,true);
                System.out.println("Added!");
                addElementsMenu();
                break;

            case 2:
                System.out.println("Please write what number you would like to add into set 2");
                int element2= sc.nextInt();
                sets.add2Set(element2,false);
                System.out.println("Added!");
                addElementsMenu();
                break;

            default:
                break;

        }
    }
}
