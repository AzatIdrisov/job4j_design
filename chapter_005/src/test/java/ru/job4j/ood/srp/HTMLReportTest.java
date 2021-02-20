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
        expect.append("<html>\n"
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
        expect.append("<tr>\n"
                + "<th> " + worker.getName() + "</th>\n"
                + "<th> " + worker.getHired() + "</th>\n"
                + "<th> " + worker.getFired() + "</th>\n"
                + "<th> " + worker.getSalary() + "</th>\n"
                + "</tr>\n");
        expect.append("</table>\n"
                + "</body>\n"
                + "</html>");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

}