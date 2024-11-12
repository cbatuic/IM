/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.ViewModel;

import src.DB.DataFetcher;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import src.Model.Student;

/**
 *
 * @author ComLab202_18
 */
public class StudentViewModel {
    private DataFetcher dataFetcher;

    public StudentViewModel() {
        this.dataFetcher = new DataFetcher();
    }

    // Method to get the TableModel for student data
    public DefaultTableModel getTableModel() {
        List<Student> students = dataFetcher.fetchStudents();  // Fetch students from database
        
        if (students == null || students.isEmpty()) {
            // Log if no data is fetched
            System.out.println("No student data found.");
        }
        
        String[] columnNames = {"ID", "First Name", "Last Name", "Email"};
        Object[][] data = new Object[students.size()][4];

        // Populate the table data
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            data[i][0] = student.getId();
            data[i][1] = student.getFirstName();
            data[i][2] = student.getLastName();
            data[i][3] = student.getEmail();
        }

        return new DefaultTableModel(data, columnNames);  // Return table model with student data
    }
}