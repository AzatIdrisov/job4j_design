package ru.job4j.ood.isp;

public interface Message {
    void sendMessage();

    void sendNotification();

    void sendSMSNotification();

    void pushNotification();
}
