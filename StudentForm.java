import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class StudentForm extends JFrame {

    JTextField nameField, branchField, phoneField, emailField;
    JButton addBtn, viewBtn, updateBtn, deleteBtn, clearBtn;

    JTable table;
    DefaultTableModel model;

    StudentDAO dao = new StudentDAO();

    public StudentForm() {

        setTitle("Student Management System");
        setSize(700,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(4,2,10,10));

        formPanel.add(new JLabel("Name"));
        nameField = new JTextField();
        formPanel.add(nameField);

        formPanel.add(new JLabel("Branch"));
        branchField = new JTextField();
        formPanel.add(branchField);

        formPanel.add(new JLabel("Phone"));
        phoneField = new JTextField();
        formPanel.add(phoneField);

        formPanel.add(new JLabel("Email"));
        emailField = new JTextField();
        formPanel.add(emailField);

        add(formPanel, BorderLayout.NORTH);

        model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"ID","Name","Branch","Phone","Email"});

        table = new JTable(model);
        JScrollPane scroll = new JScrollPane(table);

        add(scroll, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();

        addBtn = new JButton("Add");
        viewBtn = new JButton("View");
        updateBtn = new JButton("Update");
        deleteBtn = new JButton("Delete");
        clearBtn = new JButton("Clear");

        buttonPanel.add(addBtn);
        buttonPanel.add(viewBtn);
        buttonPanel.add(updateBtn);
        buttonPanel.add(deleteBtn);
        buttonPanel.add(clearBtn);

        add(buttonPanel, BorderLayout.SOUTH);

        addBtn.addActionListener(e -> {

            String name = nameField.getText();
            String branch = branchField.getText();
            String phone = phoneField.getText();
            String email = emailField.getText();

            dao.addStudent(name,branch,phone,email);

            JOptionPane.showMessageDialog(this,"Student Added");

            loadStudents();
        });

        viewBtn.addActionListener(e -> loadStudents());

        deleteBtn.addActionListener(e -> {

            int id = Integer.parseInt(
                    JOptionPane.showInputDialog("Enter Student ID")
            );

            dao.deleteStudent(id);

            loadStudents();
        });

        updateBtn.addActionListener(e -> {

            int id = Integer.parseInt(
                    JOptionPane.showInputDialog("Enter Student ID")
            );

            String name = nameField.getText();
            String branch = branchField.getText();
            String phone = phoneField.getText();
            String email = emailField.getText();

            dao.updateStudent(id,name,branch,phone,email);

            loadStudents();
        });

        clearBtn.addActionListener(e -> {

            nameField.setText("");
            branchField.setText("");
            phoneField.setText("");
            emailField.setText("");
        });

        setVisible(true);
    }

    public void loadStudents(){

        model.setRowCount(0);

        try{

            Connection conn = DBConnection.getConnection();

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM students");

            while(rs.next()){

                model.addRow(new Object[]{
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("branch"),
                        rs.getString("phone"),
                        rs.getString("email")
                });
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}