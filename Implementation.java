package sem_project;

import java.text.SimpleDateFormat;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.*;
import java.util.Date;


public class Implementation implements Show_remainder, New_remainder {

    //creating object for Scanner class
    Scanner input = new Scanner(System.in);      
    
    //declaring variables
    Date date = null;
    String filename;
    String d;

    //creating object format for date
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    //method to take a note/remainder
    public void get() throws ParseException
    {
        date = null;
        while(date== null){
            //Asking for date input
            
            System.out.print("Enter date (dd/mm/yyyy): ");
            d = input.nextLine();
            System.out.println("-------------------------------------------------");
            try{
                //checking for null value from the user
                date = format.parse(d);
                if(!d.equals(format.format(date))){
                    date = null;
                }
            }catch(ParseException e)
            {
                e.printStackTrace();
            }
            if(date == null)
            {
                System.out.println("-------------------------------------------------");
                System.out.println("LOOKS LIKE YOU'RE LIVING IN FUTURE...");
                System.out.println("-------------------------------------------------");
            }
        }
       /*  if(null!=d &&d.trim().length() > 0)
        {
            date = format.parse(d);
        }*/
        //Asking for the file name
        
        System.out.print("Enter the file name: ");
        filename = input.next();
        System.out.println("-------------------------------------------------");
        //compensating enter(since user pressed enter after entering the filename) so that it does not go as input in the next input
        input.nextLine();

        //taking note from the user
        System.out.print("Take a note: ");
        String work = input.nextLine();
        System.out.println("-------------------------------------------------");
        System.out.println(date);
        System.out.println("-------------------------------------------------");

        //creating the file
        File file = new File("E:\\Dhwani\\Programming_Languages\\Java\\Java_Project\\src\\sem_project\\Tasks\\" + filename);
        {
            //checking if file is created or not
            try {
                boolean value = file.createNewFile();
                if(value)
                {
                    System.out.println("-------------------------------------------------");
                    System.out.println("FILE CREATED");
                    System.out.println("-------------------------------------------------");
                }
                else{
                    System.out.println("-------------------------------------------------");
                    System.out.println("FILE NOT CREATED");
                    System.out.println("-------------------------------------------------");
                }
            }
            //catch exception for FileNotFound and display message
            catch(Exception e)
            {
                System.out.println("-------------------------------------------------");
                e.getStackTrace();
                System.out.println("INVALID FILE NAME");
                System.out.println("-------------------------------------------------");
            }
        }
        //trying to write in the file
        try{
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            FileWriter in = new FileWriter("E:\\Dhwani\\Programming_Languages\\Java\\Java_Project\\src\\sem_project\\Tasks\\" +filename);
            in.write(d);
            in.write("\n");
            in.write("Date and time of creation: " + dateFormat.format(date));
            in.write("\n");
            in.write(work);
            System.out.println("-------------------------------------------------");
            System.out.println("SUCCESSFULLY CREATED NOTE.");
            System.out.println("-------------------------------------------------");
            in.close();
        }
        //message to be displayed in case of exception
        catch(Exception e)
        {
            System.out.println("-------------------------------------------------");
            e.getStackTrace();
            System.out.println("UNABLE TO CREATE NOTE AT THIS MOMENT.");
            System.out.println("-------------------------------------------------");
        }
                
    }

    //method for dispalying today's remainders/tasks
    public void showToday() throws FileNotFoundException
    {
        //storing the path of files in directoryPath 
        File directoryPath = new File("E:\\Dhwani\\Programming_Languages\\Java\\Java_Project\\src\\sem_project\\Tasks\\");

        //List of all files and directories
        String contents[] = directoryPath.list();
        System.out.println("-------------------------------------------------");
        System.out.println("List of files of Today's remainders/tasks:");

        //fetching the list of files from the directory
        for(int i=0; i<contents.length; i++) {

            File file = new File("E:\\Dhwani\\Programming_Languages\\Java\\Java_Project\\src\\sem_project\\Tasks\\" +contents[i]);
            Scanner out = new Scanner(file);
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date date = new Date();
            String Today = formatter.format(date);
            String check = out.nextLine();
            //checking if system date equals file date
            if(Today.equals(check))
            {
                System.out.println(contents[i]);
            }
            
            out.close();
        }
        
        try
        {
            //asking for particular file to show 
            System.out.println("-------------------------------------------------");
            System.out.print("Enter file name to show: ");
            String filename = input.next();
            System.out.println("-------------------------------------------------");
            File file = new File("E:\\Dhwani\\Programming_Languages\\Java\\Java_Project\\src\\sem_project\\Tasks\\" +filename);

            //printing the content of the file
            Scanner out = new Scanner(file);
            System.out.println("-------------------------------------------------");
            System.out.println("TODAY's REMAINDER");
            while (out.hasNextLine())
            {
                System.out.println(out.nextLine());
            }
            out.close();
        }
        catch(Exception e)
        {
            System.out.println("-------------------------------------------------");
            System.out.println("NO SUCH TASK OR REMAINDER FOUND....");
            System.out.println("-------------------------------------------------");
        }
      
    }

    //method for displaying tasks/remainders of any date
    public void showDate() throws FileNotFoundException
    {
        //storing the path of files in directoryPath 
        File directoryPath = new File("E:\\Dhwani\\Programming_Languages\\Java\\Java_Project\\src\\sem_project\\Tasks\\");

        //taking date as input from the user
        System.out.println("-------------------------------------------------");
        System.out.println("Enter the date: ");
        String date = input.next();
        System.out.println("-------------------------------------------------");

        //List of all files and directories
        String contents[] = directoryPath.list();
        System.out.println("List of files of remainders/tasks:");
        List<String> newContent = new ArrayList<String>();
        
        //fetching the list of files from the directory
        for(int i=0; i<contents.length; i++) {

            File file = new File("E:\\Dhwani\\Programming_Languages\\Java\\Java_Project\\src\\sem_project\\Tasks\\" +contents[i]);
            Scanner out = new Scanner(file);
            //SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            //Date date = new Date();
            //String Today = formatter.format(date);
            String check = out.nextLine();
            //checking if input date equals file date
            
            if(date.equals(check))
            {
                newContent.add(contents[i]);
                
            }
              
            out.close();
        }
        for (String element : newContent){
            System.out.println(element);
        }
        if(newContent.size() !=0 ){  
            try
            {
                //asking for particular file to show 
                System.out.println("-------------------------------------------------");
                System.out.print("Enter file name to show: ");
                String filename = input.next();
                File file = new File("E:\\Dhwani\\Programming_Languages\\Java\\Java_Project\\src\\sem_project\\Tasks\\" +filename);

                //printing the content of the file
                Scanner out = new Scanner(file);
                System.out.println("-------------------------------------------------");
                System.out.println("TODAY's REMAINDER");
                while (out.hasNextLine())
                {
                    System.out.println(out.nextLine());
                }
                out.close();
            }
            catch(Exception e)
            {
                System.out.println("-------------------------------------------------");
                System.out.println("NO SUCH FILE FOUND");
                System.out.println("-------------------------------------------------");
            }
        }
        else
        {
            System.out.println("-------------------------------------------------");
            System.out.println("NO TASK/REMINDER ADDED ON THIS DATE...");
            System.out.println("-------------------------------------------------");
        }
        
        
    }

    //method to delete task/remainder
    public void dlt_task() throws FileNotFoundException
    {
        //storing the path of files in directoryPath 
        File directoryPath = new File("E:\\Dhwani\\Programming_Languages\\Java\\Java_Project\\src\\sem_project\\Tasks\\");
        //List of all files and directories
        String contents[] = directoryPath.list();
        System.out.println("-------------------------------------------------");
        System.out.println("List of files of remainders/tasks:");
         //fetching the list of files from the directory
         for(int i=0; i<contents.length; i++) {
            //File file = new File("E:\\Dhwani\\Programming_Languages\\Java\\Java_Project\\src\\sem_project\\Tasks\\" +contents[i]);
            System.out.println(contents[i]);
        }
        System.out.println("-------------------------------------------------");
        System.out.println("Enter the filename: ");
        String filename = input.nextLine();
        try{
            File f = new File("E:\\Dhwani\\Programming_Languages\\Java\\Java_Project\\src\\sem_project\\Tasks\\" +filename);
            if(f.delete())
            {
                System.out.println("-------------------------------------------------");
                System.out.println(filename + " MOVED TO TRASH");
                System.out.println("-------------------------------------------------");
            }
            else{
                System.out.println("-------------------------------------------------");
                System.out.println("IT SEEMS LIKE YOUR NOTE DOESN'T WANT TO GO IN TRASH");
                System.out.println("-------------------------------------------------");
            }
        }
        catch(Exception e)
        {
            System.out.println("-------------------------------------------------");
            System.out.println("FILE NOT FOUND");
            System.out.println("-------------------------------------------------");
        }
    }

    public void displayAll(){
         //storing the path of files in directoryPath 
         File directoryPath = new File("E:\\Dhwani\\Programming_Languages\\Java\\Java_Project\\src\\sem_project\\Tasks\\");
         //List of all files and directories
         String contents[] = directoryPath.list();
         System.out.println("-------------------------------------------------");
         System.out.println("List of files of remainders/tasks:");
          //fetching the list of files from the directory
          for(int i=0; i<contents.length; i++) {
             //File file = new File("E:\\Dhwani\\Programming_Languages\\Java\\Java_Project\\src\\sem_project\\Tasks\\" +contents[i]);
             System.out.println(contents[i]);
         }
         System.out.println("-------------------------------------------------");
    }
}
