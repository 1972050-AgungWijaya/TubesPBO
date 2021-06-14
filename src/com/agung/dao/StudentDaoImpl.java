/*
 * @author 1972050 - Agung Wijaya Al Halim
 */

package com.agung.dao;

import com.agung.entity.Department;
import com.agung.entity.Student;
import com.agung.util.DaoService;
import com.agung.util.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements DaoService<Student> {

    @Override
    public List<Student> fetchAll() throws SQLException, ClassNotFoundException {
        List<Student> students=new ArrayList<>();
        String query="SELECT student.id,first_name,last_name,address,department_id,name FROM student INNER Join department ON student.department_id=department.id;";
        try (Connection connection = MySQLConnection.createConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                try (ResultSet rs = ps.executeQuery()) {
                    while(rs.next()){
                        Department department=new Department();
                        department.setId(rs.getInt("department_id"));
                        department.setName(rs.getString("name"));
                        Student student=new Student();
                        student.setId(rs.getString("id"));
                        student.setFirstName(rs.getString("first_name"));
                        student.setLastName(rs.getString("last_name"));
                        student.setAddress(rs.getString("address"));
                        student.setDepartment(department);
                        students.add(student);
                    }
                }
            }
        }
        return students;
    }

    @Override
    public int addData(Student student) throws SQLException, ClassNotFoundException {
        int result=0;
        String query="INSERT INTO student(id,first_name,last_name,address,department_id) VALUES(?,?,?,?,?)";
        try (Connection connection = MySQLConnection.createConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setString(1,student.getId());
                ps.setString(2,student.getFirstName());
                ps.setString(3,student.getLastName());
                ps.setString(4,student.getAddress());
                ps.setInt(5,student.getDepartment().getId());
                if (ps.executeUpdate()!=0){
                    connection.commit();
                    result=1;
                }else {
                    connection.rollback();
                }
            }
        }
        return result;
    }

    @Override
    public int updateData(Student student) throws SQLException, ClassNotFoundException {
        int result=0;
        String query="UPDATE student SET first_name=?,last_name=?,address=?,department_id=? WHERE id=?";
        try (Connection connection = MySQLConnection.createConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setString(1,student.getFirstName());
                ps.setString(2,student.getLastName());
                ps.setString(3,student.getAddress());
                ps.setInt(4,student.getDepartment().getId());
                ps.setString(5,student.getId());
                if (ps.executeUpdate()!=0){
                    connection.commit();
                    result=1;
                }else{
                    connection.rollback();
                }
            }
        }
        return result;
    }

    @Override
    public int deleteData(Student student) throws SQLException, ClassNotFoundException {
        int result=0;
        String query="DELETE FROM student WHERE id=?";
        try (Connection connection = MySQLConnection.createConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setString(1,student.getId());
                if (ps.executeUpdate()!=0){
                    connection.commit();
                    result=1;
                }else{
                    connection.rollback();
                }
            }
        }
        return result;
    }
}
