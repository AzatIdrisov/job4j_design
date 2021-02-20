package ru.job4j.ood.srp;

import java.util.List;
import java.util.function.Predicate;

public class HTMLReport implements Report {

    private Store store;

    public HTMLReport(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder result = new StringBuilder();
        List<Employee> employees = store.findBy(filter);
        result.append("<html>\n"
                + "<head>\n"
                + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n"
                + "<title>HTML Report</title>\n"
                + "</head>\n"
                + "<body>\n"
                + "<table border=\"1\">\n"
                + "<tr>\n"
                + "<th> Name </th>\n"
                + "<th> Hired </th>\n"
                + "<th> Fired </th>\n"
                + "<th> Salary </th>\n"
                + "</tr>\n");
        for (Employee employee : employees) {
            result.append("<tr>\n"
                    + "<th> " + employee.getName() + "</th>\n"
                    + "<th> " + employee.getHired() + "</th>\n"
                    + "<th> " + employee.getFired() + "</th>\n"
                    + "<th> " + employee.getSalary() + "</th>\n"
                    + "</tr>\n");
        }
        result.append("</table>\n"
                + "</body>\n"
                + "</html>");
        return result.toString();
    }
}
