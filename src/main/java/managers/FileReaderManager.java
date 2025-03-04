package managers;

import org.example.dataProviders.JsonDataReader;

public class FileReaderManager {

    private static FileReaderManager fileReaderManager = new FileReaderManager();
    private static JsonDataReader jsonDataReader;

    public static FileReaderManager getInstance( ) {
        return fileReaderManager;
    }

    public JsonDataReader getJsonReader(){
        return (jsonDataReader == null) ? new JsonDataReader() : jsonDataReader;
    }
}