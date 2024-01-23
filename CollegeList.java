package collegelist;
import java.util.Scanner;

class Person {
    private String name;
    private String contactNum;

    public void setName(String n) {
        this.name = n;
    }

    public String getName() {
        return name;
    }

    public void setContactNum(String c) {
        this.contactNum = c;
    }

    public String getContactNum() {
        return contactNum;
    }
}

class Student extends Person {
    private String program;
    private int yearLevel;

    public void setProgram(String p) {
        this.program = p;
    }

    public String getProgram() {
        return program;
    }

    public void setYearLevel(int y) {
        this.yearLevel = y;
    }

    public int getYearLevel() {
        return yearLevel;
    }
}

class Employee extends Person {
    private double monthlySalary;
    private String department;

    public void setMonthlySalary(double ms) {
        this.monthlySalary = ms;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setDepartment(String d) {
        this.department = d;
    }

    public String getDepartment() {
        return department;
    }
}

class Faculty extends Employee {
    private boolean isRegular;

    public void setRegular(boolean r) {
        this.isRegular = r;
    }

    public boolean isRegular() {
        return isRegular;
    }
}

public class CollegeList {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean continueAdding = true;

        while (continueAdding) {
            System.out.print("Enter E for Employee | S for Student | F for Faculty: ");
            String choice = scan.nextLine().toUpperCase();

            switch (choice) {
                case "E":
                    System.out.print("\nEnter Employee Name: ");
                    String nameE = scan.nextLine();
                    System.out.print("Enter Contact Number: ");
                    String contactNumE = readNumericInput(scan);
                    System.out.print("Enter Monthly Salary: ");
                    double monthlySalaryE = readDoubleInput(scan);
                    scan.nextLine();
                    System.out.print("Enter Department: ");
                    String departmentE = scan.nextLine();

                    Employee e = new Employee();

                    e.setName(nameE);
                    e.setContactNum(contactNumE);
                    e.setMonthlySalary(monthlySalaryE);
                    e.setDepartment(departmentE);

                    System.out.println("\n-------------------------------------------");
                    System.out.println("Employee Name: " + e.getName());
                    System.out.println("Contact Number: " + e.getContactNum());
                    System.out.println("Monthly Salary: " + e.getMonthlySalary());
                    System.out.println("Department: " + e.getDepartment());
                    System.out.println("-------------------------------------------");
                    break;

                case "F":
                    System.out.print("\nEnter Faculty Member Name: ");
                    String nameF = scan.nextLine();
                    System.out.print("Enter Contact Number: ");
                    String contactNumF = readNumericInput(scan);
                    System.out.print("Enter Monthly Salary: ");
                    double facultySalary = readDoubleInput(scan);
                    scan.nextLine();
                    System.out.print("Enter Department: ");
                    String facultyDepartment = scan.nextLine();
                    System.out.print("Is the faculty member regular? (Y for yes/N for no): ");
                    boolean isRegularF = scan.nextLine().equalsIgnoreCase("Y");

                    Faculty f = new Faculty();
                    f.setName(nameF);
                    f.setContactNum(contactNumF);
                    f.setMonthlySalary(facultySalary);
                    f.setDepartment(facultyDepartment);
                    f.setRegular(isRegularF);

                    System.out.println("\n-------------------------------------------");
                    System.out.println("Faculty Member Name: " + f.getName());
                    System.out.println("Contact Number: " + f.getContactNum());
                    System.out.println("Monthly Salary: " + f.getMonthlySalary());
                    System.out.println("Department: " + f.getDepartment());
                    System.out.println("Status: " + (f.isRegular() ? "Regular" : "Not Regular"));
                    System.out.println("-------------------------------------------");
                    break;

                case "S":
                    System.out.print("\nEnter Student Name: ");
                    String nameS = scan.nextLine();
                    System.out.print("Enter Contact Number: ");
                    String contactNumS = readNumericInput(scan);
                    System.out.print("Enter Program: ");
                    String programS = scan.nextLine();
                    System.out.print("Enter Year Level: ");
                    int yearLevelS = readIntInput(scan);
                    scan.nextLine(); // Consume the newline character

                    Student s = new Student();
                    s.setName(nameS);
                    s.setContactNum(contactNumS);
                    s.setProgram(programS);
                    s.setYearLevel(yearLevelS);

                    System.out.println("\n-------------------------------------------");
                    System.out.println("Student Name: " + s.getName());
                    System.out.println("Contact Number: " + s.getContactNum());
                    System.out.println("Program: " + s.getProgram());
                    System.out.println("Year Level: " + s.getYearLevel());
                    System.out.println("-------------------------------------------");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

            System.out.print("\nDo you want to add another person? (Y for yes/N for no): ");
            String addAnother = scan.nextLine().toUpperCase();
            System.out.print("\n");
            if (!addAnother.equals("Y")) {
                continueAdding = false;
            }
        }
    }

    private static double readDoubleInput(Scanner scan) {
        while (!scan.hasNextDouble()) {
            System.out.println("Invalid input, please enter a valid number.");
            System.out.print("Enter a number: ");
            scan.next();
        }
        return scan.nextDouble();
    }

    private static int readIntInput(Scanner scan) {
        while (!scan.hasNextInt()) {
            System.out.println("***Invalid input, please enter a valid number.***");
            System.out.print("Enter number/s: ");
            scan.next();
        }
        return scan.nextInt();
    }

    private static String readNumericInput(Scanner scan) {
        String input = scan.nextLine();
        while (!isNumeric(input)) {
            System.out.println("***Invalid input, please enter a numeric value.***");
            System.out.print("Enter number/s: ");
            input = scan.nextLine();
        }
        return input;
    }

    private static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
