package org.example;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.File;

public class JsonReader {

    public static Root leggi(File json) throws Exception {
        Gson gson = new Gson();
        return gson.fromJson(new FileReader(json), Root.class);
    }
}
