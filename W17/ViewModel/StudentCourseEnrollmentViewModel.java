/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.ViewModel;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import src.DB.DataFetcher;
import src.Model.StudentCourseEnrollment;

/**
 *
 * @author ComLab202_18
 */
public class StudentCourseEnrollmentViewModel {
    private DataFetcher dataFetcher;

    public StudentCourseEnrollmentViewModel() {
        this.dataFetcher = new DataFetcher();  // Assuming DataFetcher will manage the DB connection and query execution
    }

    // Method to fetch student, enrollment, and course data
    public DefaultTableModel getTableModel() {
        List<StudentCourseEnrollment> enrollments = dataFetcher.fetchStudentCourseEnrollments();  // Fetch data from DB
        
        // Define the column names
        String[] columnNames = {"First Name", "Last Name", "Email", "Course Name", "Enrollment Date"};
        
        // Prepare data for the table (convert List<StudentCourseEnrollment> to Object[][])
        Object[][] data = new Object[enrollments.size()][5];
        for (int i = 0; i < enrollments.size(); i++) {
            StudentCourseEnrollment enrollment = enrollments.get(i);
            data[i][0] = enrollment.getFirstName();
            data[i][1] = enrollment.getLastName();
            data[i][2] = enrollment.getEmail();
            data[i][3] = enrollment.getCourseName();
            data[i][4] = enrollment.getEnrollmentDate();
        }

        // Return DefaultTableModel with the data
        return new DefaultTableModel(data, columnNames);
    }
}
