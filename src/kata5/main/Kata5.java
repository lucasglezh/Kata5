/*package kata5.main;

import java.sql.*;
public class Kata5 {

    @SuppressWarnings("empty-statement")
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //instalar driver en java
        Class.forName("org.sqlite.JDBC");
        
        //creamos la conexión con la BD y un statement
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:data/us500.db");
                Statement statement = connection.createStatement()){
            ResultSet set = statement.executeQuery("SELECT * FROM people WHERE city = 'Hamilton'");
            while (set.next()) {
                String email = set.getString("email");
                System.out.println(email);
            }
        }
    }
    
}*/

package kata5.main;

import java.sql.SQLException;
import java.util.List;
import kata5.model.Histogram;
import kata5.model.Mail;
import kata5.view.HistogramDisplay;
import kata5.view.MailHistogramBuilder;
import kata5.view.MailListReader;
import kata5.view.MailListReaderBD;

public class Kata5 {
    
    private static List<String> mailList;
    private static Histogram<String> mailHistogram;
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        execute();
    }
    
    private static void execute() throws ClassNotFoundException, SQLException{
        input();
        process();
        output();
    }

    private static void input() throws ClassNotFoundException, SQLException {
        mailList = MailListReaderBD.read();
    }

    private static void process() {
        mailHistogram = MailHistogramBuilder.build(mailList);
    }

    private static void output() {
        new HistogramDisplay(mailHistogram).execute();
    }
    
}
