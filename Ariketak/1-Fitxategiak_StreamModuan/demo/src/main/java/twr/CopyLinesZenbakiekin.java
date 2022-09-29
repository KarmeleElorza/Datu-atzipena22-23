/** Programa honek proiektuaren erroan dagoen Xanadu fitxategia lineaz linea irakurtzen du, 
    * linea bakoitza CopyLinesoutput.txt fitxategian idatziz aurretik linea zenbakia jarririk.
*/

package twr;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;

public class CopyLinesZenbakiekin {
    public static void main(String[] args) throws IOException 
    {

        BufferedReader inputStream = null;
        PrintWriter outputStream = null;

        try {
            inputStream = new BufferedReader(new FileReader("xanadu.txt"));
            outputStream = new PrintWriter(new FileWriter("copuLinesZenbakiekinoutput.txt"));

            String l;
            int c = 0;
            while ((l = inputStream.readLine()) != null) {
                c++;
                outputStream.println(c + " " + l);
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
