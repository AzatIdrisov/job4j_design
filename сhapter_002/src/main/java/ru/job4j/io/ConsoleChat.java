package ru.job4j.io;

import java.io.*;
import java.util.*;
import java.util.function.Function;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;
    private final Map<String, Function<Integer, Integer>> dispatch = new HashMap<>();

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
        this.dispatch.put(OUT, out());
        this.dispatch.put(STOP, pause());
        this.dispatch.put(CONTINUE, proceed());
    }

    public String getPath() {
        return path;
    }

    public String getBotAnswers() {
        return botAnswers;
    }

    public void run() {
        int working = 0;
        int pause = 0;
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
            while (working >= 0) {
                String message = scanner.nextLine();
                out.println(message);
                pause = dispatch.getOrDefault(message, stub()).apply(pause);
                working = dispatch.getOrDefault(message, stub()).apply(working);
                if (pause == 0) {
                    String answer = answers.get(rand.nextInt(answers.size()));
                    System.out.println(answer);
                    out.println(answer);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Function<Integer, Integer> pause() {
        return (flag) -> {
            return 1;
        };
    }

    public Function<Integer,  Integer> proceed() {
        return (flag) -> {
            return 0;
        };
    }

    public Function<Integer, Integer> out() {
        return (flag) -> {
            return -1;
        };
    }

    public Function<Integer, Integer> stub() {
        return (flag) -> {
            return flag;
        };
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("chat.log", "answers.txt");
        cc.run();
    }
}