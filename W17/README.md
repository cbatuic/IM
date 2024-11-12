# IM Finals Demo
This demo demonstrates how to use Java to perform SQL JOIN operations on a MySQL database and display the resulting data in a JTable for easy visualization and interaction.

![demo](./demo.png)

```sql
SELECT s.first_name, s.last_name, s.email, c.course_name, e.enrollment_date
FROM students s
JOIN enrollments e ON s.id = e.student_id
JOIN courses c ON e.course_id = c.id
ORDER BY s.last_name, c.course_name;
```