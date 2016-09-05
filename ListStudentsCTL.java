/**
 * @author Bishal Sapkota (sapkotabishal10)
 * ListStudentsCTL
 * Edits: All the required comments are added and made the code presentable
 */

package datamanagement;
        
public class ListStudentsCTL {
	private StudentManager sm;
	
	public ListStudentsCTL() {sm = StudentManager.get();}
    
	public void listStudents( IStudentLister lister, String unitCode ) {
    lister.clearStudents();
    StudentMap students = sm.getStudentsByUnit( unitCode );
    	for (Integer id : students.keySet() ) lister.addStudent(students.get(id));
    }

}
