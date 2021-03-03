package ru.job4j.ood.isp.menu;

public class Loop {

    private static final String STOP = "exit";

    public void start(Interact interact, Find findChosenPoint, Print menu) {
        String answer = "";
        while (!answer.equals(STOP)) {
            menu.print();
            answer = interact.askUser("Пожалуйста введите пункт меню:");
            Item temp = findChosenPoint.find(answer);
            if (temp != null) {
                interact.informUser(temp.getName());
            }
        }
    }
}
