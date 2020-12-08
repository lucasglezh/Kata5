package kata5.view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kata5.model.Mail;
import java.sql.*;

public class MailListReaderBD{

    public static List<String> read() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        List<String> list = new ArrayList<>();
        
        //creamos la conexión con la BD y un statement
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:data/us500.db");
            Statement statement = connection.createStatement()){
            ResultSet set = statement.executeQuery("SELECT email FROM people");
            while (set.next()) {
                Mail email = new Mail(set.getString("email"));
                if (isMail(email.getMail())){
                    list.add(email.getDomain());
                }
            }
        }
        return list;
    }

    private static boolean isMail(String line) {
        return line.matches("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$");
    }

}
