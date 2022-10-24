package dambi;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args){
        System.out.println("Sartu direktorioaren helbidea:");
        Scanner in = new Scanner(System.in);
        String direktorioaString = in.next();
        Path path = Paths.get(direktorioaString);
        //System.out.format("%s%n", path.toUri()); //proiektua dagoen karpetaren barruan sortzen du sartutako direktorioStringa.
        String directoryName = path.toAbsolutePath().toString();
        System.out.println(directoryName);
        if(Files.exists(path)){
            System.out.println("Sartutako direktorioa existitzen da jadanik.");
        }
        else{
            System.out.println("Ez da existitzen.");
        }
        Path dir = ...;
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path file: stream) {
                System.out.println(file.getFileName());
            }
        } catch (IOException | DirectoryIteratorException x) {
            // IOException can never be thrown by the iteration.
            // In this snippet, it can only be thrown by newDirectoryStream.
            System.err.println(x);
        }
            in.close();
       
    }
}