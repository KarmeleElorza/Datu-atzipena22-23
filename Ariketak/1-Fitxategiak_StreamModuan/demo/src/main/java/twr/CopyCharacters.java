/** Programa honek proiektuaren erroan dagoen Xanadu fitxategia karakterez karaktere irakurtzen du, 
    * karaktere bakoitza characteroutput.txt fitxategian idatziz.
*/

package twr;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyCharacters {
    public static void main(String[] args) throws IOException {

        FileReader inputStream = null;
        FileWriter outputStream = null;

        try {
            inputStream = new FileReader("./xanadu.txt");
            outputStream = new FileWriter("characteroutput.txt");

            int c;
            while ((c = inputStream.read()) != -1) {
                    outputStream.write(c);
            }
        }
        catch(Exception ex){
            System.out.println("Exception found.");
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}