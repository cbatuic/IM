/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.DB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import src.Model.Course;
import src.Model.Enrollment;
import src.Model.Student;
import src.Model.StudentCourseEnrollment;

/**
 *
 * @author ComLab202_18
 */
public class DataFetcher {
    // Fetch all students
    public List<Student> fetchStudents() {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM students";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setFirstName(rs.getString("first_name"));
                student.setLastName(rs.getString("last_name"));
                student.setEmail(rs.getString("email"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }

    // Fetch all courses
    public List<Course> fetchCourses() {
        List<Course> courses = new ArrayList<>();
        String query = "SELECT * FROM courses";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Course course = new Course();
                course.setId(rs.getInt("id"));
                course.setCourseName(rs.getString("course_name"));
                course.setCredits(rs.getInt("credits"));
                courses.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return courses;
    }

    // Fetch all enrollments
    public List<Enrollment> fetchEnrollments() {
        List<Enrollment> enrollments = new ArrayList<>();
        String query = "SELECT * FROM enrollment";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Enrollment enrollment = new Enrollment();
                enrollment.setStudentId(rs.getInt("studentId"));
                enrollment.setCourseId(rs.getInt("courseId"));
                enrollment.setEnrollmentDate(rs.getDate("enrollmentDate").toString());
                enrollments.add(enrollment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return enrollments;
    }
    
    // Method to fetch student, course, and enrollment data
    public List<StudentCourseEnrollment> fetchStudentCourseEnrollments() {
        List<StudentCourseEnrollment> enrollments = new ArrayList<>();

        String query = "SELECT s.first_name, s.last_name, s.email, c.course_name, e.enrollment_date " +
                       "FROM students s " +
                       "JOIN enrollments e ON s.id = e.student_id " +
                       "JOIN courses c ON e.course_id = c.id " +
                       "ORDER BY s.last_name, c.course_name";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            // Iterate through the result set and add data to the list
            while (rs.next()) {
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String email = rs.getString("email");
                String courseName = rs.getString("course_name");
                String enrollmentDate = rs.getString("enrollment_date");

                // Create a new StudentCourseEnrollment object and add to list
                StudentCourseEnrollment enrollment = new StudentCourseEnrollment(firstName, lastName, email, courseName, enrollmentDate);
                enrollments.add(enrollment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return enrollments;
    }    
}
