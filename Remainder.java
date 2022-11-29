package sem_project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import javax.swing.*;
public class Remainder  {
    JFrame f = new JFrame("Today's Remainder");
    JLabel label = new JLabel();
    public Remainder(String filename) throws Exception
    {
        f.setSize(400, 200);
        f.setLayout(null);
        f.setVisible(true);

        FileReader r = new FileReader("E:\\Dhwani\\Programming_Languages\\Java\\Java_Project\\src\\sem_project\\Tasks\\" + filename);
        BufferedReader br = new BufferedReader(r);
        String str;
        label.setBounds(20,30,100,30);
        
        while((str = br.readLine()) != null)
        {
           label.setText(str);
        }
        
        f.add(label);   
        br.close();
    }
      
    public static void main(String[] args) throws Exception
    {
        File directoryPath = new File("E:\\Dhwani\\Programming_Languages\\Java\\Java_Project\\src\\sem_project\\Tasks\\");

        //List of all files and directories
        String contents[] = directoryPath.list();
        

        //fetching the list of files from the directory
        for(int i=0; i<contents.length; i++) {

            File file = new File("E:\\Dhwani\\Programming_Languages\\Java\\Java_Project\\src\\sem_project\\Tasks\\" +contents[i]);
            Scanner out = new Scanner(file);
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date date = new Date();
            String Today = formatter.format(date);
            String check = out.nextLine();
            String filename = contents[i];
            //checking if system date equals file date
            if(Today.equals(check))
            {
                new Remainder(filename);
            }
            out.close();                                                                                                                                                  
        }
       
    }

}
