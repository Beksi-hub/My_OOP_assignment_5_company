import Controller.EmployeeController;
import data.PostgresDB;
import data.interfaces.IDB;
import entities.Employee;
import entities.Manager;
import repositories.EmployeeRepositories;
import repositories.interfaces.IEmployeeRepositories;

import java.sql.SQLOutput;
import java.util.*;

public class Main {





        public static  void main(String []args )
        {
            Scanner in =new Scanner(System.in);

            System.out.println("Welcome to It company");
            Manager e = new Manager(1, "Aisultan Kuandykov", "Makhambet", "Maried","Senior", "IT",1000000);
            IDB db = new PostgresDB();
            // Repository
            IEmployeeRepositories repo = new EmployeeRepositories(db);
            EmployeeController controller = new EmployeeController(repo);

            System.out.println("1) Create an It employee");
            System.out.println("2) It employee by id");
            System.out.println("3) Manage developers");
          

            int choose = in.nextInt();

            if(choose == 1)
            {
                System.out.println();
                System.out.println("Whom you choose ?");
                System.out.println("Manager : 1 or Developer : 2");
                int empTypeId = in.nextInt();

                int empId = in.nextInt();
                String name = in.next();
                String address = in.next();
                String status = in.next();
                String level = in.next();
                String  department= in.next();
                int salary = in.nextInt();
                controller.createEmployee(empId,name,address,status,level,department,salary,empTypeId);

            }

            if(choose == 2)
            {
                System.out.println("Get Employee by ID : ");
                int id  = in.nextInt();
                Employee m =
                        controller.getEmployee(id);

            }

            if(choose == 3)
            {
                System.out.println("Get Employee by ID : ");
                int id  = in.nextInt();

                Manager  m = (Manager) controller.getEmployee(id);
                m.ManagerInfo();
                m.manage();
                System.out.println("Set duration day");
                int durationDay  = in.nextInt();

                m.setDoingDuration(durationDay);
                System.out.println("Set penalty day");
                int penalty  = in.nextInt();

                m.setPenalty(penalty);

                System.out.println("Set bonus day");
                int bonus  = in.nextInt();

                m.setBonus(bonus);


            }




        }



}