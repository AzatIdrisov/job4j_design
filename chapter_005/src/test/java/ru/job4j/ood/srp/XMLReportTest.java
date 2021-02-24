package ru.job4j.ood.srp;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class XMLReportTest {

    @Test
    public void whenXMLReportGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss.SSS");
        //TimeZone tz = TimeZone.getTimeZone("GMT+5");
        //String timeZone = tz.getDisplayName(true, TimeZone.SHORT, Locale.ENGLISH).substring(3);
        Report engine = new XMLReport(store);
        StringBuilder expect = new StringBuilder();
        expect.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n")
                .append("<employee>\n")
                .append("    <name>").append(worker.getName()).append("</name>\n")
                .append("    <hired>").append(dateFormat.format(worker.getHired().getTime()))
                .append("T").append(timeFormat.format(worker.getHired().getTime()))
                .append("<Z/hired>\n")
                .append("    <fired>").append(dateFormat.format(worker.getFired().getTime()))
                .append("T").append(timeFormat.format(worker.getFired().getTime()))
                .append("<Z/fired>\n")
                .append("    <salary>").append(worker.getSalary()).append("</salary>\n")
                .append("</employee>\n");
        System.out.println(expect);
        System.out.println(engine.generate(em -> true));
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

}