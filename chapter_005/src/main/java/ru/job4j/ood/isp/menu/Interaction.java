package ru.job4j.ood.isp.menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Interaction implements Interact {

    private BufferedReader reader;

    public Interaction() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void informUser(String inform) {
        System.out.println(inform);
    }

    public String askUser(String question) {
        try {
            System.out.println(question);
            return reader.readLine();
        } catch (IOException ioe) {
            ioe.getMessage();
        }
        return "0";
    }
}
