package kz.aitu.oop.pratice.assigment5.Controller;

import entities.Employee;
import entities.FrontendDeveloper;
import entities.Manager;
import repositories.interfaces.IEmployeeRepositories;

import java.time.LocalDate;
import java.util.List;

public class EmployeeController {
    private final IEmployeeRepositories repo;

    public EmployeeController(IEmployeeRepositories repo){

        this.repo=repo;

    }

    public Employee createEmployee(int empID,String name,String address, String status, String level, String Department , int salary, int empTypeId){

        Employee employee;
        if(empTypeId == 1)
        {
           employee = new Manager(empID, name, address,  status,  level,  Department,salary );

        }
        else
        {
            employee = new FrontendDeveloper(empID, name, address,  status,  level,  Department,salary );
        }

        boolean created = repo.createEmployee(employee);


        return employee;
    }
    public  Employee getEmployee(int id){
        Employee employee = repo.getEmployee(id);
        Manager m = null;
        if(employee instanceof Manager){
             m = (Manager) employee;

        }

        return employee;
    }
//
//    public  String getMedicineByName(String name){
//        Medicine medicine = repo.getMedicineByName(name);
//
//        return (medicine == null ? "medicine was not found!" : medicine.toString());
//    }
//
//    public String getAllMedicines() {
//        List<Medicine> medicines = repo.getAllMedicines();
//
//        return medicines.toString();
//    }
//
//    public String deleteMedicineById(int id){
//             repo.deleteMedicineById(id);
//
//            return "Medicine was deleted";
//
//        }
}
