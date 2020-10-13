package ru.job4j.io;

import org.junit.Test;

public class AnalizyTest {

    @Test
    public void whenSeveralPeriodsUnavailable() {
        String source = "./data/log_with_several_period_unavailable.log";
        String target = "./data/res_with_several_period_unavailable.log";
        Analizy analizy = new Analizy();
        analizy.unavailable(source, target);
    }

    @Test
    public void whenHasNotErrors() {
        String source = "./data/log_without_errors.log";
        String target = "./data/res_without_errors.log";
        Analizy analizy = new Analizy();
        analizy.unavailable(source, target);
    }

    @Test
    public void whenHasOnePeriodUnavailable() {
        String source = "./data/log_with_one_period_unavailable.log";
        String target = "./data/res_with_one_period_unavailable.log";
        Analizy analizy = new Analizy();
        analizy.unavailable(source, target);
    }
}