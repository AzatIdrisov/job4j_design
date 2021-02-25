package ru.job4j.ood.isp;

public interface Login {
    void saveLogin();

    String loadLogin();

    void savePassword();

    String loadPassword(String login);

    void generatecaptcha();
}
