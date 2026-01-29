package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.*;

import java.io.File;
import java.util.Set;

public class JsonValidator {

    public static boolean valida(File json, File schema) throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        JsonNode jsonNode = mapper.readTree(json);
        JsonNode schemaNode = mapper.readTree(schema);

        JsonSchemaFactory factory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V7);

        JsonSchema jsonSchema = factory.getSchema(schemaNode);

        Set<ValidationMessage> errors = jsonSchema.validate(jsonNode);

        if (!errors.isEmpty()) {
            System.out.println("Errori di validazione:");
            errors.forEach(e -> System.out.println(e.getMessage()));
            return false;
        }

        return true;
    }
}
