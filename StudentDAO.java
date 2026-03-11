import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

public class StudentDAO {

    // ADD STUDENT
    public void addStudent(String name, String branch, String phone, String email) {

        try {

            Connection conn = DBConnection.getConnection();

            String query = "INSERT INTO students(name, branch, phone, email) VALUES (?, ?, ?, ?)";

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1, name);
            stmt.setString(2, branch);
            stmt.setString(3, phone);
            stmt.setString(4, email);

            stmt.executeUpdate();

            System.out.println("Student Added Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // VIEW STUDENTS
    public void viewStudents() {

        try {

            Connection conn = DBConnection.getConnection();

            String query = "SELECT * FROM students";

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Branch: " + rs.getString("branch"));
                System.out.println("Phone: " + rs.getString("phone"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("----------------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // UPDATE STUDENT
    public void updateStudent(int id, String name, String branch, String phone, String email) {

        try {

            Connection conn = DBConnection.getConnection();

            String query = "UPDATE students SET name=?, branch=?, phone=?, email=? WHERE id=?";

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1, name);
            stmt.setString(2, branch);
            stmt.setString(3, phone);
            stmt.setString(4, email);
            stmt.setInt(5, id);

            int rows = stmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Student Updated Successfully!");
            } else {
                System.out.println("Student not found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // DELETE STUDENT
    public void deleteStudent(int id) {

        try {

            Connection conn = DBConnection.getConnection();

            String query = "DELETE FROM students WHERE id=?";

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, id);

            int rows = stmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Student Deleted Successfully!");
            } else {
                System.out.println("Student not found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}