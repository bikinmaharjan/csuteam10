package datamanagement;

import org.jdom.Document;
import org.jdom.input.SAXBuilder;
import java.io.FileWriter;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import java.io.IOException;
import org.jdom.JDOMException;

public class XMLManager {
private static XMLManager self = null;


        private Document doc;
        public static XMLManager getXML() { if (self == null ) self = new XMLManager(); return self;
}
    private XMLManager() {init();

    
    
    
}

    
    
    
public void init() {
        String s = AppProperties.getInstance().getProperties().getProperty("XMLFILE");
try {
            SAXBuilder b = new SAXBuilder();
    b.setExpandEntities(true);
                        doc = b.build(s);}



                catch (JDOMException e) {
System.err.printf( "%s", "DBMD: XMLManager : init : caught JDOMException\n" );
throw new RuntimeException("DBMD: XMLManager : init : JDOMException");} 
        catch (IOException e) {
            System.err.printf( "%s", "DBMD: XMLManager : init : caught IOException\n" );
            
            
            
throw new RuntimeException("DBMD: XMLManager : init : IOException");
        }  
                }      
    public Document getDocument() {
        return doc;
    }
    
    public void saveDocument() {
        String xmlfile = AppProperties.getInstance().getProperties().getProperty("XMLFILE");
                try (FileWriter fout = new FileWriter(xmlfile)) {
XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
    outputter.output(doc, fout);
                    fout.close();
}
        catch (IOException ioe) {
System.err.printf( "%s\n", "DBMD : XMLManager : saveDocument : Error saving XML to " + xmlfile);
                    throw new RuntimeException("DBMD: XMLManager : saveDocument : error writing to file");
        }}}
