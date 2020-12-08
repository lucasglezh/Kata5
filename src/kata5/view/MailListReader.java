package kata5.view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kata5.model.Mail;

public class MailListReader {

    public static List<Mail> read(String fileName) {
        List<Mail> list = new ArrayList<>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));
            while(true){
                String line = reader.readLine();
                if (line == null) break;
                if(isMail(line)){
                    list.add(new Mail(line));
                }
            }
        } catch (FileNotFoundException exception){
            System.out.println("ERROR MailListReader::read (File not found)" + exception.getMessage());
        } catch (IOException exception){
             System.out.println("ERROR MailListReader::read (IO)" + exception.getMessage());
        }
        
        return list;
    }

    private static boolean isMail(String line) {
        return line.matches("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$");
    }

}
