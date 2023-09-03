package Aston.Lesson_4;


class Employee {
    private String fullName;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Employee(String fullName, String position, String email, String phone, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void displayInfo() {
        System.out.println("Full Name: " + fullName);
        System.out.println("Position: " + position);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
        System.out.println("Salary: " + salary);
        System.out.println("Age: " + age);
        System.out.println("---------------------------");
    }

    public static void main(String[] args) {
        Employee[] employees = new Employee[5];


        employees[0] = new Employee("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30);
        employees[1] = new Employee("Petrov Petr", "Manager", "petrov@mailbox.com", "891234567", 40000, 42);
        employees[2] = new Employee("Sidorov Alex", "Developer", "sidorov@mailbox.com", "890987654", 50000, 38);
        employees[3] = new Employee("Kuznetsov Anton", "Designer", "kuznetsov@mailbox.com", "899876543", 35000, 45);
        employees[4] = new Employee("Smirnov Dmitry", "Analyst", "smirnov@mailbox.com", "898765432", 45000, 37);


        for (Employee employee : employees) {
            if (employee.age > 40) {
                employee.displayInfo();
            }
        }
    }
}

