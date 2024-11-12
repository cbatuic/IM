/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.ViewModel;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import src.DB.DataFetcher;
import src.Model.Course;

/**
 *
 * @author ComLab202_18
 */
public class CourseViewModel {
    private DataFetcher dataFetcher;

    public CourseViewModel() {
        this.dataFetcher = new DataFetcher();
    }

    // Method to get the table model for displaying course data
    public DefaultTableModel getTableModel() {
        List<Course> courses = dataFetcher.fetchCourses();
        String[] columnNames = {"ID", "Course Name", "Credits"};
        Object[][] data = new Object[courses.size()][3];

        for (int i = 0; i < courses.size(); i++) {
            Course course = courses.get(i);
            data[i][0] = course.getId();
            data[i][1] = course.getCourseName();
            data[i][2] = course.getCredits();
        }

        return new DefaultTableModel(data, columnNames);
    }
}
