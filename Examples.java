import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

class Examples
{
    static void greeting()
    {
        Scanner s = new Scanner(System.in);
        
        System.out.println("Please enter your name.");
        String username = s.nextLine();
        
        System.out.println("Hello " + username);
        
        s.close();
    }
    
    static void getUserInfo() throws FileNotFoundException
    {
        File f = new File("userinfo.txt");
        Scanner s = new Scanner(f);
        ArrayList<String> userdata = new ArrayList<String>();
        
        while (s.hasNextLine())
        {
            String data = s.nextLine();
            userdata.add(data);
        }
        
        System.out.println(userdata.get(0));
        System.out.println(userdata.get(3));
        
        s.close();
    }
    
    static void countMonster() throws FileNotFoundException
    {
        File f = new File("frankenstein.txt");
        Scanner s = new Scanner(f);
        
        int counter = 0;
        while (s.hasNext())
        {
            String data = s.next();
            
            if (data.equals("monster"))
            {
                counter++;
            }
        }
        
        System.out.println(counter);
        
        s.close();
    }
    
    
    
    
    
}
