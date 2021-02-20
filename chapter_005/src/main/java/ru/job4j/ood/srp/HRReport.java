package ru.job4j.ood.srp;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class HRReport implements Report {

    private Store store;

    private Comparator<Employee> compareEmployeeBySalary = (emp1, emp2) ->
            Double.compare(emp1.getSalary(), emp2.getSalary()) * -1;

    public HRReport(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder result = new StringBuilder();
        List<Employee> employees = store.findBy(filter);
        employees.sort(compareEmployeeBySalary);
        result.append("Name; Salary;")
                .append(System.lineSeparator());
        for (Employee employee : employees) {
            result
                    .append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return result.toString();
    }
}