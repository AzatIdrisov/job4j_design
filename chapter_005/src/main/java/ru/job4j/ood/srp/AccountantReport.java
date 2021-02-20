package ru.job4j.ood.srp;

import java.util.function.Predicate;

public class AccountantReport implements Report {

    private Store store;

    private int course;

    public AccountantReport(Store store, int course) {
        this.store = store;
        this.course = course;
    }

    public int getCourse() {
        return course;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder result = new StringBuilder();
        result.append("Name; Hired; Fired; Salary;");
        result.append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            result.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary() / getCourse()).append(";");
        }
        return result.toString();
    }
}
