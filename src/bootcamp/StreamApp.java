package bootcamp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Employee
{
    int id;
    String firstName;
    String lastName;
    int salary;
    int age;
    String department;


    public Employee (int id, String firstName, String lastName, int salary,
            int age, String department)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.age = age;
        this.department = department;
    }


    public int getSalary ()
    {
        return salary;
    }


    public void setSalary (int salary)
    {
        this.salary = salary;
    }


    public int getId ()
    {
        return id;
    }


    public String getFirstName ()
    {
        return firstName;
    }


    public String getLastName ()
    {
        return lastName;
    }


    public int getAge ()
    {
        return age;
    }


    public String getDepartment ()
    {
        return department;
    }
}

public class StreamApp
{
    public static void main (String[] args)
    {
        Employee e1 = new Employee (1, "John", "Smith", 5000000, 35, "SE");
        Employee e2 = new Employee (2, "Rose", "Mary", 3500000, 22, "ADM");
        Employee e3 = new Employee (3, "Brad", "Denver", 7000000, 40, "SE");
        Employee e4 = new Employee (4, "Jean", "Butterfly", 3500000, 25, "ADM");
        Employee e5 = new Employee (5, "Lyna", "Lang", 5000000, 30, "SE");

        List<Employee> empList = new ArrayList<Employee> ();
        empList.add (e1);
        empList.add (e2);
        empList.add (e3);
        empList.add (e4);
        empList.add (e5);

        // create stream of objects
        Stream<Employee> empStream = Stream.of (e1, e2, e3, e4, e5);

        // sum all salary
        int sumAll = empStream.mapToInt (Employee::getSalary).sum ();

        System.out.println (sumAll);

        // sum all salary from SE department
        // empStream already consumed, need to restream
        int sumSE = empList.stream ()
                .filter (emp -> emp.getDepartment ().equals ("SE"))
                .mapToInt (Employee::getSalary).sum ();

        System.out.println (sumSE);

        // output name whose age <= 30
        empList.stream ().filter (emp -> emp.getAge () <= 30)
                .map (Employee::getFirstName).forEach (System.out::println);

        // output name whose age <= 30 sort in alphabetical order
        empList.stream ().filter (emp -> emp.getAge () <= 30)
                .map (Employee::getFirstName)
                .sorted ( (o1, o2) -> o1.compareTo (o2))
                .forEach (System.out::println);

        // sort employee by age
        empList.stream ().sorted ( (o1, o2) -> o1.getAge () - o2.getAge ())
                .forEach (x -> System.out.println (x.getFirstName ()));

        // grouping by department
        Map<String, List<Employee>> empGroup = empList.stream ()
                .collect (Collectors.groupingBy (Employee::getDepartment));

        // partitioning by department
        Map<Boolean, List<Employee>> empSE = empList.stream ()
                .collect (Collectors.partitioningBy (
                        emp -> emp.getDepartment ().equals ("SE")));

        // optional
        Optional<Employee> empOpt = empList.stream ()
                .filter (emp -> emp.getFirstName ().equals ("Diana"))
                .findAny ();
        
        if(empOpt.isPresent ())
            System.out.println (empOpt.get ().getFirstName ());

    }
}
