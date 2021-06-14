/*
 * @author 1972050 - Agung Wijaya Al Halim
 */

package com.agung.view;

import com.agung.dao.DepartmentDaoImpl;
import com.agung.dao.StudentDaoImpl;
import com.agung.entity.Department;
import com.agung.entity.Student;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainForm {
    private JTextField txtId;
    private JTextField txtFirstName;
    private JTextField txtLastName;
    private JTextArea txtAddress;
    private JComboBox<Department> comboDepartment;
    private JButton btnAddDepartment;
    private JButton updateButton;
    private JButton resetButton;
    private JTable tableStudent;
    private JButton saveButton;
    private JSplitPane rootPanel;
    private JButton deleteButton;
    private JButton updateButtonD;
    private DepartmentDaoImpl departmentDao;
    private StudentDaoImpl studentDao;
    private List<Department> departments;
    private List<Student> students;
    private DefaultComboBoxModel<Department> departmentComboBoxModel;
    private StudentTableModel studentTableModel;
    private Student selectedStudent;
    private Student checkStudent;
    private Department selectedDepartment;

    public MainForm() {
        departmentDao=new DepartmentDaoImpl();
        studentDao=new StudentDaoImpl();
        departments=new ArrayList<>();
        students=new ArrayList<>();
        try {
            departments.addAll(departmentDao.fetchAll());
            students.addAll(studentDao.fetchAll());
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        departmentComboBoxModel=new DefaultComboBoxModel<>(departments.toArray(new Department[0]));
        comboDepartment.setModel(departmentComboBoxModel);
        studentTableModel= new StudentTableModel(students);
        tableStudent.setModel(studentTableModel);
        tableStudent.setAutoCreateRowSorter(true);
        btnAddDepartment.addActionListener(e -> {
            String newDepartment= JOptionPane.showInputDialog(rootPanel,"New Department name");
            if (newDepartment!=null&&!newDepartment.trim().isEmpty()){
                Department department =new Department();
                department.setName(newDepartment);
                try {
                    if (departmentDao.addData(department)==1){
                            departments.clear();
                            departments.addAll(departmentDao.fetchAll());
                            departmentComboBoxModel.removeAllElements();
                            departmentComboBoxModel.addAll(departments);

                    }
                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        saveButton.addActionListener(e -> {
            if (txtId.getText().trim().isEmpty()||txtFirstName.getText().trim().isEmpty()||txtAddress.getText().trim().isEmpty()||comboDepartment.getSelectedItem()==null){
                JOptionPane.showMessageDialog(rootPanel,"Please fill id,first name, address, and department","Error",JOptionPane.ERROR_MESSAGE);
            }
            else{
                int x=studentTableModel.getRowCount();
                boolean y=false;
                for (int i=0;i<x;i++){
                    checkStudent=students.get(i);
                    if (checkStudent.getId().equals(txtId.getText())){
                        y=true;
                    }
                }
                if (!y){
                    Student student =new Student();
                    student.setId(txtId.getText());
                    student.setFirstName(txtFirstName.getText());
                    student.setLastName(txtLastName.getText().trim().isEmpty()?null :txtLastName.getText());
                    student.setAddress(txtAddress.getText());
                    student.setDepartment((Department) comboDepartment.getSelectedItem());
                    try {
                        if (studentDao.addData(student)==1){
                            students.clear();
                            students.addAll(studentDao.fetchAll());
                            studentTableModel.fireTableDataChanged();
                            clearAndReset();
                        }
                    } catch (SQLException | ClassNotFoundException throwables) {
                        throwables.printStackTrace();
                    }
                }
                else{
                    JOptionPane.showMessageDialog(rootPanel,"id sudah terdapat di data base silahkan cek lagi","ID SAMA",JOptionPane.ERROR_MESSAGE);
                }


            }
        });
        resetButton.addActionListener(e -> {
            System.out.println(studentTableModel.getRowCount());
            clearAndReset();
        });
        updateButton.addActionListener(e -> {
            if (txtId.getText().trim().isEmpty()||txtFirstName.getText().trim().isEmpty()||txtAddress.getText().trim().isEmpty()||comboDepartment.getSelectedItem()==null){
                JOptionPane.showMessageDialog(rootPanel,"Please fill id,first name, address, and department","Error",JOptionPane.ERROR_MESSAGE);
            }
            else{
                selectedStudent.setFirstName(txtFirstName.getText());
                selectedStudent.setLastName(txtLastName.getText().trim().isEmpty()?null :txtLastName.getText());
                selectedStudent.setAddress(txtAddress.getText());
                selectedStudent.setDepartment((Department) comboDepartment.getSelectedItem());
                try {
                    if (studentDao.updateData(selectedStudent)==1){
                        students.clear();
                        students.addAll(studentDao.fetchAll());
                        studentTableModel.fireTableDataChanged();
                        clearAndReset();
                    }
                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        tableStudent.getSelectionModel().addListSelectionListener(e ->{
            if(!tableStudent.getSelectionModel().isSelectionEmpty()){
                int selectedIndex=
                        tableStudent.convertRowIndexToModel(tableStudent.getSelectedRow());
                selectedStudent=students.get(selectedIndex);
                if (selectedStudent!=null){
                    txtId.setText(selectedStudent.getId());
                    txtFirstName.setText(selectedStudent.getFirstName());
                    txtLastName.setText(selectedStudent.getLastName()!=null?selectedStudent.getLastName():"");
                    txtAddress.setText(selectedStudent.getAddress());
                    comboDepartment.setSelectedItem(selectedStudent.getDepartment());
                    txtId.setEnabled(false);
                    saveButton.setEnabled(false);
                    updateButton.setEnabled(true);
                }
            }
        });

        deleteButton.addActionListener(e -> {
            try {
                if (studentDao.deleteData(selectedStudent)==1){
                    students.clear();
                    students.addAll(studentDao.fetchAll());
                    studentTableModel.fireTableDataChanged();
                    clearAndReset();
                }
            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
        });
        updateButtonD.addActionListener(e -> {
            String newDepartment= JOptionPane.showInputDialog(rootPanel,"Update Department name");
            int selectedIndex=
                    comboDepartment.getSelectedIndex();
            selectedDepartment=departments.get(selectedIndex);
            if (newDepartment!=null&&!newDepartment.trim().isEmpty()){
                Department department =new Department();
                department.setId(selectedDepartment.getId());
                department.setName(newDepartment);
                try {
                    if (departmentDao.updateData(department)==1){
                        departments.clear();
                        departments.addAll(departmentDao.fetchAll());
                        departmentComboBoxModel.removeAllElements();
                        departmentComboBoxModel.addAll(departments);
                        students.clear();
                        students.addAll(studentDao.fetchAll());
                        studentTableModel.fireTableDataChanged();
                    }
                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("MainForm");
        frame.setContentPane(new MainForm().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(800,600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
    private void clearAndReset(){
        txtId.setText("");
        txtFirstName.setText("");
        txtLastName.setText("");
        txtAddress.setText("");
        tableStudent.clearSelection();
        txtId.setEnabled(true);
        saveButton.setEnabled(true);
        updateButton.setEnabled(false);
        selectedStudent=null;
    }
    private static class StudentTableModel extends AbstractTableModel{
        private List<Student>students;
        private final String[]COLUMNS={"ID","FIRST NAME","LAST NAME","DEPARTMENT"};

        public StudentTableModel(List<Student> students) {
            this.students = students;
        }

        @Override
        public int getRowCount() {
            return students.size();
        }

        @Override
        public int getColumnCount() {
            return COLUMNS.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return switch(columnIndex){
                case 0 ->students.get(rowIndex).getId();
                case 1 ->students.get(rowIndex).getFirstName();
                case 2 ->students.get(rowIndex).getLastName();
                case 3 ->students.get(rowIndex).getDepartment().getName();
                default -> "";
            };
        }

        @Override
        public String getColumnName(int column) {
            return COLUMNS[column];
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            if (getValueAt(0,columnIndex)!=null){
                return getValueAt(0,columnIndex).getClass();
            }
            return Object.class;
        }
    }
}
