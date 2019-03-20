package htp.basumatarau.task03.dao.util;

import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBInit {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        createDB();
    }
    private static void createDB() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/?useSSL=false", "root",
                "password")) {
            new ScriptRunner(connection).runScript(new FileReader("dbGenScriptTask03.sql"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
