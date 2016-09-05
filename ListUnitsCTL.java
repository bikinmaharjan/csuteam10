/**
 * @author Bishal Sapkota (sapkotabishal10)
 * ListUnitsCTL
 * Edits: All the required comments are added and made the code presentable
 */

package datamanagement;

public class ListUnitsCTL {
    private UnitManager um;

    public ListUnitsCTL() {
        um = UnitManager.UM();
    }
    public void listUnits( IUnitLister lister ) {
    	lister.clearUnits();UnitMap units = um.getUnits();
        for (String s : units.keySet() )
            lister.addUnit(units.get(s));
    }

}
