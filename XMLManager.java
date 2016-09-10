/**
 * @author : Pujan Shrestha (Dreameeer)
 * Student ID: 11587794
 * Team 10
 * Professional programming practices
 */
package datamanagement;

import org.jdom.Document;
import org.jdom.input.SAXBuilder;
import java.io.FileWriter;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import java.io.IOException;
import org.jdom.JDOMException;

/*class XMLManager*/
public class XMLManager {	
    private static XMLManager self = null; // // XMLManager variable 
    private Document doc; // make a document 
	// method for XMLManager to get XML
    public static XMLManager getXML() { 
    	if (self == null ) 
            self = new XMLManager();  // create a new XMLManager object
    	return self;
	}
	// XMLManager method to call init()
	private XMLManager() {
		init();
	}
	// method init	       
	public void init() {
		// String variable s assigned attributes from XML file
	    String s = AppProperties.getInstance().getProperties().getProperty("XMLFILE");
	    // initiate try catch 
		try {
			// SAXBuilder to build Document
			SAXBuilder b = new SAXBuilder();
		    b.setExpandEntities(true);
		    doc = b.build(s);
		}
		// catch JDOMException
		catch (JDOMException e) {
			System.err.printf( "%s", "DBMD: XMLManager : init : caught JDOMException\n" );
			throw new RuntimeException("DBMD: XMLManager : init : JDOMException");
		} 
		// catch Input output exception
		catch (IOException e) {
		    System.err.printf( "%s", "DBMD: XMLManager : init : caught IOException\n" );
		    throw new RuntimeException("DBMD: XMLManager : init : IOException");
		}  
	}      
	
	// return Document
	public Document getDocument() {
	    return doc;
	}
	    
	//  method to save Document
	public void saveDocument() {
		
		String xmlfile = AppProperties.getInstance().getProperties().getProperty("XMLFILE");
	    // try catch statements
		try (FileWriter fout = new FileWriter(xmlfile)) {
			// save the Document 
	    	XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
	    	outputter.output(doc, fout);
	        fout.close();
	    }
		// catch IOException ioe
	    catch (IOException ioe) {
	    	System.err.printf( "%s\n", "DBMD : XMLManager : saveDocument : Error saving XML to " + xmlfile);
	        throw new RuntimeException("DBMD: XMLManager : saveDocument : error writing to file");
	    }
	}

}
