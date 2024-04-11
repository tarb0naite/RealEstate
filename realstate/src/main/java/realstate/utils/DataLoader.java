package realstate.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import realstate.ui.Property;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class DataLoader {

    public static List<Property> loadProperties(String jsonFilePath) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(new File(jsonFilePath), new TypeReference<List<Property>>(){});
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}