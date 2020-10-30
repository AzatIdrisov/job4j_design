package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public String getPath() {
        return path;
    }

    public String getBotAnswers() {
        return botAnswers;
    }

    public void run() {
        boolean working = true;
        boolean pause = false;
        Scanner scanner = new Scanner(System.in);
        List<String> answers = new ArrayList<>();
        try {
            BufferedReader botAnswers = new BufferedReader(new FileReader(getBotAnswers()));
            String read;
            while ((read = botAnswers.readLine()) != null) {
                answers.add(read);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Random rand = new Random();
        System.out.println("Введите сообщение");
        try (PrintWriter out = new PrintWriter(new BufferedOutputStream(
                new FileOutputStream(getPath())))) {
            while (working) {
                String message = scanner.nextLine();
                out.println(message);
                if (message.equals(STOP)) {
                    pause = true;
                }
                if (message.equals(CONTINUE)) {
                    pause = false;
                }
                if (message.equals(OUT)) {
                    working = false;
                }
                if (!message.equals(OUT) && !pause && !message.equals(CONTINUE)) {
                    String answer = answers.get(rand.nextInt(answers.size()));
                    System.out.println(answer);
                    out.println(answer);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("chat.log", "answers.txt");
        cc.run();
    }
}