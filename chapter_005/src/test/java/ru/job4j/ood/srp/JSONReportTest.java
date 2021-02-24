package ru.job4j.ood.srp;

import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class JSONReportTest {

    @Test
    public void whenJSONReportGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new JSONReport(store);
        StringBuilder expect = new StringBuilder();
        expect.append("{\"name\":\"").append(worker.getName()).append("\",")
                .append("\"hired\":{\"year\":").append(worker.getHired().get(now.YEAR)).append(",")
                .append("\"month\":").append(worker.getHired().get(now.MONTH)).append(",")
                .append("\"dayOfMonth\":").append(worker.getHired().get(now.DATE)).append(",")
                .append("\"hourOfDay\":").append(worker.getHired().get(now.HOUR_OF_DAY)).append(",")
                .append("\"minute\":").append(worker.getHired().get(now.MINUTE)).append(",")
                .append("\"second\":").append(worker.getHired().get(now.SECOND)).append("},")
                .append("\"fired\":{\"year\":").append(worker.getFired().get(now.YEAR)).append(",")
                .append("\"month\":").append(worker.getFired().get(now.MONTH)).append(",")
                .append("\"dayOfMonth\":").append(worker.getFired().get(now.DATE)).append(",")
                .append("\"hourOfDay\":").append(worker.getFired().get(now.HOUR_OF_DAY)).append(",")
                .append("\"minute\":").append(worker.getFired().get(now.MINUTE)).append(",")
                .append("\"second\":").append(worker.getFired().get(now.SECOND)).append("},")
                .append("\"salary\":").append(worker.getSalary()).append("}");
        System.out.println(engine.generate(em -> true));
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

}