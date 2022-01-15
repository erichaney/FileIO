import java.util.Scanner;
import java.io.File;
import java.io.PrintStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

class Exercises
{

    static double sumDoubles() throws FileNotFoundException
    {
        // Important: Make your own text file filled with decimal numbers
        // named "numbers.txt" and save it to the project folder, or else
        // the following code will not work.
        File f = new File("numbers.txt");
        Scanner s = new Scanner(f);

        double sum = 0;
        while(s.hasNextDouble())
        {
            double data = s.nextDouble();
            sum = sum + data;
        }

        s.close();
        return sum;
    }

    static int countWords(String searchTerm) throws FileNotFoundException
    {
        // Important: Download an ebook from project gutenberg as plain text
        // named "bookname.txt" and save it to the project folder, or else
        // the following code will not work.
        File f = new File("frankenstein.txt");
        Scanner s = new Scanner(f);

        int count = 0;
        while (s.hasNext())
        {
            String word = s.next();

            if (word.contains(searchTerm))
            {
                count++;
            }
        }

        s.close();
        return count;
    }

    static void changePassword() throws FileNotFoundException
    {
        // Important: create a text file filled with user information
        // named "userinfo.txt" and save it to the project folder, or else
        // the following code will not work.
        //
        // Example of userinfo.txt:
        //
        // Username: alanturing
        // Password: abc123
        // Birthday: 6/23/1912

        File f = new File("userinfo.txt");
        Scanner s = new Scanner(f);
        ArrayList<String> userdata = new ArrayList<String>();

        // Step 1: read the contents of the file into the arraylist word by word

        while (s.hasNext())
        {
            String word = s.next();
            userdata.add(word);
        }

        s.close();

        // Step 2: create a new scanner to read the user's keyboard input
        Scanner k = new Scanner(System.in);
        System.out.println("Please enter your username and password.");
        String enteredUsername = k.next();
        String enteredPassword = k.next();

        String fileUsername = userdata.get(1);
        String filePassword = userdata.get(3);
        
        // Loop to force the user to enter valid credentials
        while (!fileUsername.equals(enteredUsername) || 
        !filePassword.equals(enteredPassword))
        {
            System.out.println("Invalid username or password.");
            System.out.println("Please reenter your username and password.");
            enteredUsername = k.next();
            enteredPassword = k.next();
        }

        // Step 3: Prompt the user to change their password. Update the arraylist.
        System.out.println("Please enter a new password.");
        String newPassword = k.next();
        
        userdata.set(3, newPassword);
        k.close();
        
        System.out.println("Saving new password...");
        
        // Step 4: Write the contents of the arraylist back to the file with a printstream.
        PrintStream ps = new PrintStream(f);
        
        for (int i = 0; i < userdata.size(); i += 2)
        {
            // We need to print two words on each line of the file:
            ps.println(userdata.get(i) + " " + userdata.get(i+1));
        }
        
        System.out.println("New password saved.");
    }

    static void guessTheNumber()
    {
        Scanner s = new Scanner(System.in);
        
        int randNum = (int) (Math.random() * 100) + 1;
        
        System.out.println("I am thinking of a number between 1 and 100. Make a guess.");
        int guess = s.nextInt();
        int counter = 1;
        while (guess != randNum)
        {
            if (guess < randNum)
            {
                System.out.println("Incorrect. Guess higher.");
            }
            else
            {
                System.out.println("Incorrect. Guess lower.");
            }
            
            // Let the user guess again.
            guess = s.nextInt();
            counter++;
        }
        
        System.out.println("Correct! You got it right in " + counter + " tries.");
        
        s.close();
    }
    
    static void capitalizeVowels(String fileName) throws FileNotFoundException
    {
        File inputFile = new File(fileName);
        Scanner s = new Scanner(inputFile);
        
        File outputFile = new File("capitalvowels.txt");
        PrintStream ps = new PrintStream(outputFile);
        
        while (s.hasNextLine())
        {
            String line = s.nextLine();
            
            // Loop over the line of text one character at a time with charAt()
            for (int i = 0; i < line.length(); i++)
            {
                char letter = line.charAt(i);
                
                if (letter == 'a')
                {
                    ps.print('A');
                }
                else if (letter == 'e')
                {
                    ps.print('E');
                }
                else if (letter == 'i')
                {
                    ps.print('I');
                }
                else if (letter == 'o')
                {
                    ps.print('O');
                }
                else if (letter == 'u')
                {
                    ps.print('U');
                }
                else
                {
                    ps.print(letter);
                }
            }
            ps.println();
        }
        
        s.close();
    }
    
    static void reverseText(String fileName) throws FileNotFoundException
    {
        File f = new File(fileName);
        Scanner s = new Scanner(f);
        ArrayList<String> fileData = new ArrayList<String>();
        
        File rev = new File("reversed.txt");
        PrintStream ps = new PrintStream(rev);
        
        // Step 1: read all lines into an ArrayList
        while (s.hasNextLine())
        {
            fileData.add(s.nextLine());
        }
        
        // Step 2: Run through the ArrayList backwards, printing each line backwards.
        for (int i = fileData.size() - 1; i >= 0; i--)
        {
            String line = fileData.get(i);
            
            for (int j = line.length() - 1; j >= 0; j--)
            {
                char letter = line.charAt(j);
                
                ps.print(letter);
            }
            ps.println();
        }
        s.close();
    }
}
