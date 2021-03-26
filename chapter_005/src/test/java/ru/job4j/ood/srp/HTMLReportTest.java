package ru.job4j.ood.srp;

import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class HTMLReportTest {

    @Test
    public void whenHTMLReportGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new HTMLReport(store);
        StringBuilder expect = new StringBuilder();
        expect.append("<html>\n")
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
        expect.append("<tr>\n").append("<th> ").append(worker.getName()).append("</th>\n")
                .append("<th> ").append(worker.getHired()).append("</th>\n")
                .append("<th> ").append(worker.getFired()).append("</th>\n")
                .append("<th> ").append(worker.getSalary()).append("</th>\n")
                .append("</tr>\n");
        expect.append("</table>\n")
                .append("</body>\n")
                .append("</html>");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

}