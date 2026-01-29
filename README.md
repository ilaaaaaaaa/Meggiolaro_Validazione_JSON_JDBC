# JSON: Validazione, Deserializzazione e Inserimento in DB con Java

## Consegna

Realizzare un programma Java che:

1. **Validi un file JSON** (`elencoPersone.json`) utilizzando lo **schema JSON** (`persone.schema.json`) tramite la libreria **networknt**.
2. **Deserializzi** il JSON in oggetti Java mediante **Gson**.
3. **Esporti i dati** letti in un database MySQL tramite **JDBC**.

Il database viene creato precedentemente utilizzando **XAMPP**.

---

## Dipendenze (Maven
```xml
<dependencies>
    <!-- Gson per JSON -->
    <dependency>
        <groupId>com.google.code.gson</groupId>
        <artifactId>gson</artifactId>
        <version>2.10.1</version>
    </dependency>

    <!-- NetworkNT JSON Schema Validator -->
    <dependency>
        <groupId>com.networknt</groupId>
        <artifactId>json-schema-validator</artifactId>
        <version>1.0.86</version>
    </dependency>

    <!-- MySQL Connector/J -->
    <dependency>
        <groupId>com.mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
        <version>9.1.0</version>
    </dependency>
</dependencies>
```
---
## Database 
```
CREATE DATABASE elenco;
USE elenco;

CREATE TABLE persona (
id INT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(50),
cognome VARCHAR(50),
eta INT,
via VARCHAR(100),
citta VARCHAR(50),
cap INT
);

CREATE TABLE telefono (
id INT AUTO_INCREMENT PRIMARY KEY,
persona_id INT,
tipo VARCHAR(20),
numero VARCHAR(30),
FOREIGN KEY (persona_id) REFERENCES persona(id)
);
```