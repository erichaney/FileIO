import java.util.Scanner;
import java.io.PrintStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

class Examples
{
    static void greeting()
    {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter your name.");
        String username = s.nextLine();

        System.out.println("Hello " + username);
        s.close();
    }

    static void getUserInfo() throws FileNotFoundException
    {
        File f = new File("userinfo.txt");
        Scanner s = new Scanner(f);

        while(s.hasNextLine())
        {
            String data = s.nextLine();

            System.out.println(data);
        }

        s.close();
    }

    static void changePassword() throws FileNotFoundException
    {
        File f = new File("userinfo.txt");
        Scanner s = new Scanner(f);
        ArrayList<String> data = new ArrayList<String>();

        while (s.hasNext())
        {
            // store the next word into the arraylist
            data.add(s.next());

        }

        Scanner keyboardScanner = new Scanner(System.in);

        System.out.println("Please enter a new password.");
        String newPassword = keyboardScanner.next();
        data.set(3, newPassword);

        PrintStream ps = new PrintStream(f);

        // Print each line of the arraylist to the file
        for (int i = 0; i < data.size(); i += 2)
        {
            ps.println(data.get(i) + " " + data.get(i+1));
        }

        s.close();
        keyboardScanner.close();
    }

    static void getWords(int wordlength) throws FileNotFoundException
    {
        File f = new File("frankenstein.txt");
        File output = new File("words.txt");

        Scanner s = new Scanner(f);

        while (s.hasNext())
        {
            String word = s.next();

            if (word.length() == wordlength)
            {
                System.out.println(word);
            }
        }

        s.close();
    }
}
