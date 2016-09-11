/**
 * Bishal Sapkota (sapkotabishal10)
 * AppProperties
 * Edits: All the required comments are added and made the code presentable
 */

package datamanagement;

/**
 * @author jtulip
 */
// contains public signatures and fields for polymorphism
public interface IStudentLister {

	public void clearStudents();

	public void addStudent(IStudent student);
}
