import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;

class Examples
{
    static void greeting()
    {
        System.out.println("Enter your name.");
        Scanner s = new Scanner(System.in);
        
        String username = s.nextLine();
        
        System.out.println("Hello " + username);
        
        s.close();
    }
    
    static void getUserInfo() throws FileNotFoundException
    {
        File f = new File("userinfo.txt");
        Scanner s = new Scanner(f);
        
        while (s.hasNextLine())
        {
            String line = s.nextLine();
            
            System.out.println(line);
        }
        
        s.close();
    }
    
    
    
    
}
