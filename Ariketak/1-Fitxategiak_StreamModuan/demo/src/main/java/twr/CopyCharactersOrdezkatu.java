/** Programa honek proiektuaren erroan dagoen Xanadu fitxategia karakterez karaktere irakurtzen du, 
    * karaktere bakoitza characteroutputOrdezkatu.txt fitxategian idatziz baina a karaktere guztiak o karaktereaz ordezkaturik.
*/

package twr;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyCharactersOrdezkatu {
    public static void main(String[] args) throws IOException {

        FileReader inputStream = null;
        FileWriter outputStream = null;

        try {
            inputStream = new FileReader("./xanadu.txt");
            outputStream = new FileWriter("characteroutputOrdezkatu.txt");

            int c;
            while ((c = inputStream.read()) != -1) {
                if(c == 97 || c == 65){
                    outputStream.write('o');
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
