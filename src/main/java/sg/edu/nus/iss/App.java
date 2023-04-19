package sg.edu.nus.iss;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        //check if file exists
        Path readme = Paths.get("readme.md");
        
        // Does not work:
        // Path p = Path.createFile(readme);
        // File f = p.toFile();

        // Cast path to file:
        File f = readme.toFile();

        //create file or folder:
        if(f.exists()) {
            System.out.println("File already exists");
        } else {
            Files.createFile(readme);
            System.out.println("File created at: " + f.toString());
        }

        // Alternative way to create directories/files
        // Files.createDirectories(readme);

        if (f.canRead()) System.out.println("Can read");
        if (f.canWrite()) System.out.println("Can Write");
        if (f.canExecute()) System.out.println("Can execute");

        //FileInputStream to create file and display file content
        byte[] array = new byte[1024];

        InputStream input = new FileInputStream(f);
        
        System.out.println("Available bytes: " + input.available());

        input.read(array);
        String data = new String(array);
        System.out.println("Data read from input: " + input.read());

        input.close();

    }
}
