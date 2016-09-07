/**
 * @author Bishal Sapkota (sapkotabishal10)
 * IUnitLister
 * Edits: All the required comments are added and made the code presentable
 */

package datamanagement;

//contains public signatures and fields for polymorphism used in UnitList
public interface IUnitLister {

    public void clearUnits(); //clears unit
    public void addUnit(IUnit unit); //adds new unit

}
