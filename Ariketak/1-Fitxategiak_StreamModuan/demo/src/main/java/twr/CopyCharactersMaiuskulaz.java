/** Programa honek proiektuaren erroan dagoen Xanadu fitxategia karakterez karaktere irakurtzen du, 
    * karaktere bakoitza characterMaiuskulazoutput.txt fitxategian idatziz baina Maiuskulaz.
*/

package twr;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyCharactersMaiuskulaz {
    public static void main(String[] args) throws IOException {

        FileReader inputStream = null;
        FileWriter outputStream = null;

        try {
            inputStream = new FileReader("./xanadu.txt");
            outputStream = new FileWriter("characterMaiuskulazoutput.txt");

            int c;
            while ((c = inputStream.read()) != -1) {
                if(c > 96 && c < 123){
                    outputStream.write(c-32);
                }
                else{
                    outputStream.write(c);
                }
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