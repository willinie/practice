package collection;

import java.util.HashSet;
import java.util.Objects;

public class Hashset_ {
    public static void main(String[] args) {
        Employee employee1 = new Employee("aaa", 20);
        Employee employee2 = new Employee("aaa", 20);
        Employee employee3 = new Employee("bbb", 30);

        HashSet hashSet = new HashSet();
        hashSet.add(employee1);
        hashSet.add(employee2);
        hashSet.add(employee3);
        System.out.println(hashSet);
    }
}

class Employee{
    private String name;
    private int age;

    Employee(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object e) {
        if(e.getClass() != Employee.class){ return false; }
        return this.name.equals(((Employee) e).name) && this.age == ((Employee) e).age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}