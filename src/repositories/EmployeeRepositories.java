package repositories;

import data.interfaces.IDB;
import entities.Employee;
import entities.FrontendDeveloper;
import entities.Manager;
import repositories.interfaces.IEmployeeRepositories;


import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class EmployeeRepositories implements IEmployeeRepositories {
    private final IDB db;

    public EmployeeRepositories(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createEmployee(Employee employee) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO employee(empid,name, address, status,level, department, emptypeid) VALUES(?,?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            int empTypeId = 0;

            if(employee instanceof Manager)
            {
                empTypeId = 1;
            }
            else
            {
                empTypeId = 2;
            }
            st.setInt(1, employee.getEmpId());
            st.setString(2, employee.getName());
            st.setString(3, employee.getAddress());
            st.setString(4, employee.getStatus());
            st.setString(5, employee.getLevel());
            st.setString(6, employee.getDepartment());
            st.setInt(7, empTypeId);

             sql = "insert into manager(managerId, salary, emptypeid) VALUES(?,?,?)";

            PreparedStatement st1 = con.prepareStatement(sql);
            st1.setInt(1,employee.getEmpId());
            st1.setInt(2,((Manager)employee).gettingSalary());
            st1.setInt(3,empTypeId);

            st.execute();
            st1.execute();

            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }



    @Override
    public Employee getEmployee(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT  empid,name, address, status,level, department, manager.emptypeid,salary   FROM employee  join manager on manager.managerid = employee.empid WHERE empid=? ";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                if(rs.getInt("emptypeid") == 1) {
                    Manager employee = new Manager(rs.getInt("empId"),
                            rs.getString("name"),
                            rs.getString("address"),
                            rs.getString("status"),
                            rs.getString("level"),
                            rs.getString("department"),rs.getInt("salary")
                    );
                    return employee;

                }


                FrontendDeveloper employee = (FrontendDeveloper) new Employee(rs.getInt("empId"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getString("status"),
                        rs.getString("level"),
                        rs.getString("department")
                        );

                return employee;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;

    }

    @Override
    public Employee getEmployeeByName(String name) {
        return null;
    }

    @Override
    public List<Employee> getAllEmployee() {
        return null;
    }

    @Override
    public void deleteEmployeeById(int id) {

    }
}

