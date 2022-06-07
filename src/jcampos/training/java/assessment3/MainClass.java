package jcampos.training.java.assessment3;

import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;
import jcampos.training.java.assessment2.Employee;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MainClass {

    public static void main(String[] args) {

        // Question 1: Write a java code to find duplicate elements in the above list using java 8 streams.
        System.out.println("Duplicate elements:");
        List<Integer> numberList = Arrays.asList(5, 13, 4, 21, 13, 27, 2, 59, 59, 34);
        List<Integer> finalNumberList = numberList;
        Set<Integer> repetedNumbersList = numberList.stream()
                .filter(n -> Collections.frequency(finalNumberList, n) > 1)
                .collect(Collectors.toSet());
        repetedNumbersList.forEach(n -> System.out.println("\t" + n));

        // Question 2: Write a java code to remove duplicate elements from the List Using Java 8 without using set.
        System.out.println("\nUnique elements:");
        numberList = Arrays.asList(4, 5, 7, 8, 99, 100, 101, 33, 32, 4, 4);
        List<Integer> uniqueNumbersList = numberList.stream().distinct().collect(Collectors.toList());
        uniqueNumbersList.forEach(n -> System.out.println("\t" + n));

        // Question 3: Find the max element from the given list using java 8.
        System.out.println("\nMaximum element:");
        numberList = Arrays.asList(3, 90, 350, 5);
        Integer maxNumber = numberList.stream().max(Integer::compare).get();
        System.out.println("\t" + maxNumber);


        // Question 4: Find minimum and maximum elements in an array in Java using streams.
        System.out.println("|Max|\t|Min|");
        numberList = Arrays.asList(6, 8, 3, 5, 1, 9);
        maxNumber = numberList.stream().max(Integer::compare).get();
        Integer minNumber = numberList.stream().min(Integer::compare).get();
        System.out.println("|" + maxNumber + "|\t|" + minNumber + "|");

        // Count the number of employees in each department using java 8 streams
        List<Employee> employeeList = Arrays.asList(
                new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0),
                new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0),
                new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0),
                new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0),
                new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0),
                new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0),
                new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0),
                new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0),
                new Employee(277, "Anuj", 31, "Male", "Product Development", 2012, 35700.0));

        System.out.println("Employees by department:");
        Map<String, Long> departmentCount = employeeList.stream().collect(Collectors.groupingBy(e -> e.getDepartment(), Collectors.counting()));
        departmentCount.entrySet().stream().forEach(d -> System.out.println(d.getKey() + ": " + d.getValue()));
    }
}
