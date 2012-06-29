package wsclient;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Kevin
 */
public class CreateXML {
    
    private File file;
    private FileWriter fw;
    private BufferedWriter out;    
    
    public CreateXML(String str) {
        try {
            file = new File("data.xml");
            fw = new FileWriter(file);
            out = new BufferedWriter(fw);
            
            out.write(str);
            out.close();
        } catch(IOException e) {
            System.out.println(e);
        }
    }
}
