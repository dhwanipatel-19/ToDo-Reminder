package sem_project;

import java.io.FileNotFoundException;    
import java.text.ParseException;
import java.util.*;

//Extending class Implementation
public class Main extends Implementation {
    
    //Program execution begins from here
    public static void main (String[] args) throws ParseException, FileNotFoundException
    {
        
        
        //creating object for Scanner class
        Scanner input = new Scanner(System.in);

        //creating object for Implementation class
        Implementation obj = new Implementation();
        char ask = 'y';

        //MENU
        do{
            System.out.println("--------------TO DO REMAINDER/TASKS--------------");
            System.out.println("1.Add new task(s)/remainder(s). ");
            System.out.println("2.Today's task(s)/remainder(s).");
            System.out.println("3.Go to date.");
            System.out.println("4.Delete task/remainder.");
            System.out.println("5.Display all.");
            System.out.println("6.Exit.");
            System.out.println("-------------------------------------------------");
            
            //Asking choice from user
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            System.out.println("-------------------------------------------------");

            switch(choice)
            {
                case 1:
                {
                    obj.get();
                    break;
                }
                case 2:
                {
                    obj.showToday();
                    break;
                }
                case 3:
                {
                    obj.showDate();
                    break;
                }
                case 4:
                {
                    obj.dlt_task();
                    break;
                }
                case 5:
                {
                    obj.displayAll();
                    break;
                }
                case 6: 
                {
                    break;
                }
                default:
                {
                    System.out.println("-------------------------------------------------");
                    System.out.println("WE WILL MAKE AN OPTION LIKE THAT LATER...");
                    System.out.println("-------------------------------------------------");
                }
            }
            System.out.println("-------------------------------------------------");
            System.out.print("Want to spend more time? (y/n): ");  
            ask = input.next().charAt(0);
            System.out.println("-------------------------------------------------");
        }while(ask == 'y');

        input.close();

    }
    
}