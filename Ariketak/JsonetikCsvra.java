
package dambi.mainklaseak;
import java.io.*; 
import java.nio.file.*;

import javax.json.Json;
import javax.json.JsonReader;
import javax.json.JsonStructure;

import org.apache.commons.io.FileUtils; 
import org.json.*; 

import dambi.atzipenekoak.Xmla;  

/**
 *
 * @author KaR21
 */
public class JsonetikCsvra {
 
    /*public static void main(String[] args) throws FileNotFoundException {
        
        JsonReader reader = Json.createReader(new FileReader("mendienfitxategiak/data/Mendiak.json"));
        JsonStructure jsonst = reader.read();
        JSONObject json = new JSONObject(jsonst);
        String xml = XML.toString(json);
        System.out.println(xml);
    } */
    public static void main(String[] args) throws JSONException {
        String jsonArrayString = "{\"fileName\": [{\"first name\": \"Ravi\",\"last name\": \"Chandra\",\"location\": \"Bangalore\"}]}";
        JSONObject output;
        try {
           output = new JSONObject(jsonArrayString);
           JSONArray docs = output.getJSONArray("fileName");
           File file = new File("EmpDetails.csv");
           String csv = CDL.toString(docs);
           FileUtils.writeStringToFile(file, csv);
           System.out.println("Data has been Sucessfully Writeen to "+ file);
           System.out.println(csv);
        }
        catch(Exception e) {
           e.printStackTrace();
        }
     }

}
