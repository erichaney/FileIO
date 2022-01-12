import java.util.Scanner;
import java.io.PrintStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

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

    static void changePassword() throws FileNotFoundException
    {
        File f = new File("userinfo.txt");
        Scanner s = new Scanner(f);
        ArrayList<String> data = new ArrayList<String>();

        // Read the data from the text file into the arraylist
        while (s.hasNext())
        {
            data.add(s.next()); //put the next word in the arraylist
        }

        System.out.println("Please enter a new password.");
        Scanner keyboardScanner = new Scanner(System.in);

        String newPassword = keyboardScanner.next();

        data.set(3, newPassword);

        PrintStream ps = new PrintStream(f);

        // Write each word of the arraylist to the text file

        for (int i = 0; i < data.size(); i += 2)
        {
            ps.println(data.get(i) + " " + data.get(i + 1));
        }

        s.close();
        keyboardScanner.close();
    }

    static void getWords(int wordLength) throws FileNotFoundException
    {
        File f = new File("frankenstein.txt");
        Scanner s = new Scanner(f);

        while(s.hasNext())
        {
            String word = s.next();

            if (word.length() == wordLength)
            {
                System.out.println(word);
            }
        }
        
        s.close();
    }

    
}
