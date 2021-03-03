package kz.aitu.oop.pratice.assigment5.entities;

public class Employee {
    private int EmpId;
    private String Name;
    private String Address;
    private String status;
    private String level;
    private String department;

  public Employee(){

  }
public  Employee(int EmpId, String Name, String address, String status, String level, String Department){
    setEmpId(EmpId);
    setName(Name);
    setAddress(address);
    setStatus(status);
    setLevel(level);
    setDepartment(Department);
}


public void setDepartment(String department){
    this.department=department;
}
public String getDepartment(){
    return department;
}
public void setEmpId(int id){
    this.EmpId=id;
}
public int getEmpId(){
    return EmpId;
}
public void setName(String name){
    this.Name=name;
}
public String getName(){
    return Name;
}
public void setAddress(String add){
    this.Address=add;
}
public String getAddress(){
    return Address;
}
public void setLevel(String Level){
    this.level=Level;
}
public String getLevel(){
    return level;
}
public void setStatus(String status){
    this.status=status;
}
public String getStatus(){
    return status;
}
public void EmpInfo(){
    System.out.println("Employee "+ getName()+ " with id "+getEmpId());
    System.out.println("Address: "+ getAddress());
    System.out.println("Level: " +getLevel());
    System.out.println("Status: " +getStatus());
}

}