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
        result.append("<html>\n")
                .append("<head>\n")
                .append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n")
                .append("<title>HTML Report</title>\n")
                .append("</head>\n")
                .append("<body>\n")
                .append("<table border=\"1\">\n")
                .append("<tr>\n")
                .append("<th> Name </th>\n")
                .append("<th> Hired </th>\n")
                .append("<th> Fired </th>\n")
                .append("<th> Salary </th>\n")
                .append("</tr>\n");
        for (Employee employee : employees) {
            result.append("<tr>\n").append("<th> ").append(employee.getName()).append("</th>\n")
                    .append("<th> ").append(employee.getHired()).append("</th>\n")
                    .append("<th> ").append(employee.getFired()).append("</th>\n")
                    .append("<th> ").append(employee.getSalary()).append("</th>\n")
                    .append("</tr>\n");
        }
        result.append("</table>\n")
                .append("</body>\n")
                .append("</html>");
        return result.toString();
    }
}
