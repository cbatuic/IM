/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.ViewModel;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import src.DB.DataFetcher;
import src.Model.Enrollment;

/**
 *
 * @author ComLab202_18
 */
public class EnrollmentViewModel {
    private DataFetcher dataFetcher;

    public EnrollmentViewModel() {
        this.dataFetcher = new DataFetcher();
    }

    // Method to get the table model for displaying enrollment data
    public DefaultTableModel getTableModel() {
        List<Enrollment> enrollments = dataFetcher.fetchEnrollments();
        String[] columnNames = {"Student ID", "First Name", "Last Name", "Course Name", "Enrollment Date"};
        Object[][] data = new Object[enrollments.size()][5];

        for (int i = 0; i < enrollments.size(); i++) {
            Enrollment enrollment = enrollments.get(i);
            data[i][0] = enrollment.getStudentId();  // Student ID
            data[i][1] = enrollment.getCourseId();  // Course Name
            data[i][2] = enrollment.getEnrollmentDate(); // Enrollment Date
        }

        return new DefaultTableModel(data, columnNames);
    }
}
