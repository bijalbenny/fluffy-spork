
import java.util.Scanner;

class Employee{

String name,address;
int age;
Long phno;
double salary;
void printSalary() {
System.out.println("Salary = "+salary);
}
void display() {
System.out.println("Name : "+name+"\nAge : "+age+"\nPhone Number : "+phno+"\nSalary : "+salary+"\nAdress : "+address);
}
}
class Officer extends Employee{
String Specialization;
Officer(String name,int age,String address,Long phno,double salary,String specialization){
this.name=name;
this.age=age;
this.address=address;
this.phno=phno;
this.salary=salary;
Specialization=specialization;
}


void printSpecialization(){
System.out.println("Specialization : "+Specialization);
}
}
class Manager extends Employee{
String Department;
Manager(String name,int age,String address,Long phno,double salary,String department){
this.name=name;
this.age=age;
this.address=address;
this.phno=phno;
this.salary=salary;
Department=department;
}
void printDepartment() {
System.out.println("Department : "+Department);
}
}
public class Inheritance {
public static void main(String[] args) {
Scanner s = new Scanner(System.in);
String name,address,specialization,department;int age;Long phno;double salary;
System.out.println("\nEnter the Officer Details");
System.out.println("Name :");
name=s.next();


System.out.println("Age : ");
age=s.nextInt();
System.out.println("Address : ");
address=s.next();
System.out.println("Phone Number : ");
phno=s.nextLong();
System.out.println("Salary : ");
salary=s.nextDouble();
System.out.println("Specialization : ");
specialization=s.next();
Officer office =new Officer(name,age,address,phno,salary,specialization);
System.out.println("\nEnter the Manager Details");
System.out.println("Name :");
name=s.next();
System.out.println("Age : ");
age=s.nextInt();
System.out.println("Address : ");
address=s.next();
System.out.println("Phone Number : ");
phno=s.nextLong();
System.out.println("Salary : ");
salary=s.nextDouble();
System.out.println("Department : ");
department=s.next();
Manager manage =new Manager(name,age,address,phno,salary,department);


System.out.println("\nOfficer Details");
office.display();
office.printSpecialization();
System.out.println("\nManager Details");
manage.display();
manage.printDepartment();
s.close();
}
}