package org.example;

import java.io.File;

public class Main {
    public static void main(String[] args) throws Exception {
        ClassLoader cl = Main.class.getClassLoader();

        File json = new File(cl.getResource("elencoPersone.json").getFile());
        File schema = new File(cl.getResource("persone.schema.json").getFile());

        if (JsonValidator.valida(json, schema)) {
            Root root = JsonReader.leggi(json);
            DatabaseManager.salva(root);
            System.out.println("Operazione completata");
        }
    }
}