package Stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentMain {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(new Student(1, "Rohit", "Mall", 30, "Male", "Mechanical", 2015, "Mumbai", 122),
                new Student(2, "Pulkit", "Singh", 56, "Male", "Computer", 2018, "Delhi", 67),
                new Student(3, "Ankit", "Patil", 25, "Female", "Mechanical", 2019, "Kerala", 164),
                new Student(4, "Satish Ray", "Malaghan", 30, "Male", "Mechanical", 2014, "Kerala", 26),
                new Student(5, "Roshan", "Mukd", 23, "Male", "Biotech", 2022, "Mumbai", 12),
                new Student(6, "Chetan", "Star", 24, "Male", "Mechanical", 2023, "Karnataka", 90),
                new Student(7, "Arun", "Vittal", 26, "Male", "Electronics", 2014, "Karnataka", 324),
                new Student(8, "Nam", "Dev", 31, "Male", "Computer", 2014, "Karnataka", 433),
                new Student(9, "Sonu", "Shankar", 27, "Female", "Computer", 2018, "Karnataka", 7),
                new Student(10, "Shubham", "Pandey", 26, "Male", "Instrumentation", 2017, "Mumbai", 98));

        System.out.println("List Of All Student:");
        System.out.println( "int id, String firstName, String lastName, int age, String gender, String departmantName,int joinedYear, String city, int rank");
        students.forEach(System.out::println);
        System.out.println("-----------------------------------------------------------------------------------------");
//		1- Find list of students whose first name starts with alphabet A
        System.out.println("1- Find list of students whose first name starts with alphabet A");
        students
                .stream()
                .filter(s -> s.getFirstName().startsWith("A"))
                .toList()
                .forEach(System.out::println);

        System.out.println("-----------------------------------------------------------------------------------------");
//		2- Group The Student By Department Names
        System.out.println("2- Group The Student By Department Names");
        students
                .stream()
                .collect(Collectors.groupingBy(Student::getDepartmantName))
                .forEach((dept,stud)-> System.out.println(dept+"="+stud));

        System.out.println("-----------------------------------------------------------------------------------------");
//		3- Find the total count of student using stream
        System.out.println("3- Find the total count of student using stream");
        System.out.println(students.stream().count());
        System.out.println("-----------------------------------------------------------------------------------------");

//		4- Find the max age of student
        System.out.println("4- Find the max age of student");
        int maxAge = students.stream().mapToInt(Student::getAge).max().orElse(0);
        System.out.println(" : maxAge : " + maxAge);

        System.out.println(students.stream().map(Student::getAge).max(Integer::max).orElse(0));

        Student student = students.stream().max((a, b) -> a.getAge() - b.getAge()).get();
        System.out.println("MaxAge: " + student.getAge());
        // ---OR---//
        System.out.println("MaxAge by mapToInt: " + students.stream().mapToInt(Student::getAge).max().orElse(0));

        System.out.println("-----------------------------------------------------------------------------------------");
//		5- Find all departments names
        System.out.println("5- Find all departments names");
//		sL.stream().distinct().forEach(s -> System.out.println(s.getDepartmantName()));
        System.out.println(students.stream().map(Student::getDepartmantName).distinct().toList());

        System.out.println("-----------------------------------------------------------------------------------------");
//		6- Find the count of student in each department*******
        System.out.println("6- Find the count of student in each department");
        System.out
                .println(students.stream().collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.counting())));

        System.out.println("-----------------------------------------------------------------------------------------");
//		7- Find the list of students whose age is less than 30
        System.out.println("7- Find the list of students whose age is less than 30");
        System.out.println(students.stream().filter(s -> s.getAge() > 30).toList());

        System.out.println("-----------------------------------------------------------------------------------------");
//		8- Find the list of students whose rank is in between 50 and 100
        System.out.println("8- Find the list of students whose rank is in between 50 and 100");
        System.out.println(students.stream().filter(s -> s.getRank() > 50 && s.getRank() < 100).toList());

        System.out.println("-----------------------------------------------------------------------------------------");
//		9- Find the average age of male and female students
        System.out.println("9- Find the average age of male and female students");
        System.out.println(students.stream()
                .collect(Collectors.groupingBy(Student::getGender, Collectors.averagingDouble(Student::getAge))));

        System.out.println("-----------------------------------------------------------------------------------------");

        System.out.println("-----------------------------------------------------------------------------------------");
//		9- Find the average age of male and female students
        Map<String, Double> collect = students
                .stream()
                .collect(Collectors.groupingBy(Student::getGender,
                        Collectors.averagingDouble(Student::getAge)));
        System.out.println(collect);
        System.out.println("-----------------------------------------------------------------------------------------");
//        10**- Find the department who is having maximum number of students
        students
                .stream()
                .collect(Collectors.groupingBy(Student::getDepartmantName,Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(System.out::println);
        System.out.println("-----------------------------------------------------------------------------------------");
//        11**- Find the Students who stays in Karnataka and sort them by their names
//        List<Student> list =
        students
                .stream()
                .filter(s -> s.getCity().equals("Karnataka"))
                .sorted(Comparator.comparing(Student::getFirstName))
                .toList()
                .forEach(System.out::println);
//        System.out.println(list);


        System.out.println("-----------------------------------------------------------------------------------------");
//        12- Find the average rank in all departments
        students
                .stream()
                .collect(Collectors.groupingBy(Student::getDepartmantName,
                        Collectors.averagingDouble(Student::getRank)))
                .forEach((k,v)-> System.out.println(k+"=>"+v));
        System.out.println("-----------------------------------------------------------------------------------------");
//        13- Find the highest rank in each department
        students
                .stream()
                .collect(Collectors.groupingBy(Student::getDepartmantName,
                        Collectors.maxBy(Comparator.comparing(Student::getRank))))
                .forEach((dept,stud)-> System.out.println("Higest Rank of Dept "+dept+" is "+stud.orElse(null).getRank()));

        System.out.println("-----------------------------------------------------------------------------------------");

//        14- Find the list of students and sort them by their rank
        students
                .stream()
                .sorted(Comparator.comparing(Student::getRank)).toList()
                .forEach(System.out::println);

        System.out.println("-----------------------------------------------------------------------------------------");
//        15- Find the student who has second rank
        Student stud = students
                .stream()
                .sorted(Comparator.comparing(Student::getRank).reversed())
                .skip(1)
                .findFirst()
                .orElse(null);
        System.out.println(stud);


    }
}
