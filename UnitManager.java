/**
 * @author : Pujan Shrestha (Dreameeer)
 * Student ID : 11587794
 * Team 10
 * Professional programming practices
 */

package datamanagement;

import java.util.List;
import org.jdom.*;

// class UnitManager
public class UnitManager {

	private static UnitManager self = null; // create an object, set it to private

	private UnitMap UM;  //create an object variable and declare it private

	//method UnitManager 
	public static UnitManager UM() {
		// if condition to return self
		if (self == null)
			self = new UnitManager();
		return self;
	}
	
	// private method for  UnitManager
	private UnitManager() {
		UM = new UnitMap(); // create an object
	}
	
	// method for IUnit
	public IUnit getUnit(String uc) {
		// assign the object iu with value fron other classes
		IUnit iu = UM.get(uc);
		// return iu after checking the condition
		return iu != null ? iu : createUnit(uc);

	}
	// method fir IUnit
	private IUnit createUnit(String unitCode) {

		IUnit iu;
		// for loop to check units in XML
		for (Element el : (List<Element>) XMLManager.getXML().getDocument()
				.getRootElement().getChild("unitTable").getChildren("unit"))
			// checking the existance of the Unit 
			if (unitCode.equals(el.getAttributeValue("uid"))) {
				StudentUnitRecordList slist;

				slist = null;
				// assigning attributes to iu
				iu = new Unit(el.getAttributeValue("uid"),
						el.getAttributeValue("name"), Float.valueOf(
								el.getAttributeValue("ps")).floatValue(), Float
								.valueOf(el.getAttributeValue("cr"))
								.floatValue(), Float.valueOf(
								el.getAttributeValue("di")).floatValue(), Float
								.valueOf(el.getAttributeValue("hd"))
								.floatValue(), Float.valueOf(
								el.getAttributeValue("ae")).floatValue(),
						Integer.valueOf(el.getAttributeValue("asg1wgt"))
								.intValue(), Integer.valueOf(
								el.getAttributeValue("asg2wgt")).intValue(),
						Integer.valueOf(el.getAttributeValue("examwgt"))
								.intValue(), StudentUnitRecordManager
								.instance().getRecordsByUnit(unitCode));
				UM.put(iu.getUnitCode(), iu);
				// return iu
				return iu;
			}

		throw new RuntimeException("DBMD: createUnit : unit not in file");
	}

	// method for UnitMap
	public UnitMap getUnits() {
		// objects
		UnitMap uM;
		IUnit iu;
		// create an object 
		uM = new UnitMap();
		// for loop to get Unit
		for (Element el : (List<Element>) XMLManager.getXML().getDocument()
				.getRootElement().getChild("unitTable").getChildren("unit")) {
			// assign value to iu for this instance
			iu = new UnitProxy(el.getAttributeValue("uid"),
					el.getAttributeValue("name"));
			uM.put(iu.getUnitCode(), iu);
		} // unit maps are filled with PROXY units
		return uM;   // return uM
	}

}
