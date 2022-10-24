package dambi;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;

public class JsonExampleAriketa {
    public static void main(String[] args) throws FileNotFoundException {
        JsonObject model = Json.createObjectBuilder()
        .add("menu",Json.createObjectBuilder()
            .add("id", "file")
            .add("value", "file")
            .add("popup", Json.createObjectBuilder()
                .add("menuitem", Json.createArrayBuilder()
                .add(Json.createObjectBuilder()
                    .add("value", "new")
                    .add("onclick", "CreateNewDoc()"))
                .add(Json.createObjectBuilder()
                    .add("value", "open")
                    .add("onclick", "OpenDoc"))
                .add(Json.createObjectBuilder()
                    .add("value", "new")
                    .add("onclick", "CreateNewDoc()"))))) 
        .build();
        System.out.println(model);

        try (JsonWriter jsonWriter = Json.createWriter(new FileOutputStream("data/Irteera.json"))) {
            jsonWriter.writeObject(model);
         }

    }
}
