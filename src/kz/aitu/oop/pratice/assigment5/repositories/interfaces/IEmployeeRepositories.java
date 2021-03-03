package kz.aitu.oop.pratice.assigment5.repositories.interfaces;

import entities.Employee;

import java.util.List;

public interface IEmployeeRepositories {
    boolean createEmployee(Employee employee);
    Employee getEmployee(int id);
    Employee getEmployeeByName(String name);
    List<Employee> getAllEmployee();
    void deleteEmployeeById(int id);

}
