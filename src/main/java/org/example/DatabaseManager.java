package org.example;

import java.sql.*;

public class DatabaseManager {

    private static final String URL =
            "jdbc:mysql://localhost:3306/elenco?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "";

    public static void salva(Root root) throws Exception {

        Connection conn = DriverManager.getConnection(URL, USER, PASS);

        for (Persona p : root.persone.persona) {

            PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO persona VALUES (NULL,?,?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, p.nome);
            ps.setString(2, p.cognome);
            ps.setInt(3, p.eta);
            ps.setString(4, p.indirizzo.via);
            ps.setString(5, p.indirizzo.citta);
            ps.setInt(6, p.indirizzo.cap);

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int idPersona = rs.getInt(1);

            for (Telefono t : p.telefoni) {
                PreparedStatement pst = conn.prepareStatement(
                        "INSERT INTO telefono VALUES (NULL,?,?,?)");
                pst.setInt(1, idPersona);
                pst.setString(2, t.type);
                pst.setString(3, t.number);
                pst.executeUpdate();
            }
        }
        conn.close();
    }
}
