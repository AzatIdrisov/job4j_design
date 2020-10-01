package ru.job4j.collection;

import java.util.ArrayList;
import java.util.List;

public class Analize {

    public Info diff(List<User> previous, List<User> current) {
        Info info = new Info();
        List<User> generalUsers = Analize.getGeneralUsers(previous, current, info);
        Analize.countDeletedUsers(previous, current, info);
        Analize.countChangedUsers(previous, generalUsers, info);
        return info;
    }

    public static boolean contains(User user, List<User> list) {
        boolean rsl = false;
        for (User element : list) {
            if (user.getId() == element.getId()) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }

    public static List<User> getGeneralUsers(List<User> previous, List<User> current, Info info) {
        List<User> generalUsers = new ArrayList<>();
        for (User currentUser : current) {
            if (contains(currentUser, previous)) {
                generalUsers.add(currentUser);
            } else {
                info.setAdded(info.getAdded() + 1);
            }
        }
        return generalUsers;
    }

    public static void countDeletedUsers(List<User> previous, List<User> current, Info info) {
        for (User prevUser : previous) {
            if (!contains(prevUser, current)) {
                info.setDeleted(info.getDeleted() + 1);
            }
        }
    }

    public static void countChangedUsers(List<User> previous, List<User> generalUsers, Info info) {
        for (User general : generalUsers) {
            for (User prev : previous) {
                if (general.getId() == prev.getId() && !general.getName().equals(prev.getName())) {
                    info.setChanged(info.getChanged() + 1);
                }
            }
        }
    }

    public static class User {
        private int id;
        private String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    public static class Info {

        private int added;
        private int changed;

        private int deleted;

        public int getAdded() {
            return added;
        }

        public void setAdded(int added) {
            this.added = added;
        }

        public int getChanged() {
            return changed;
        }

        public void setChanged(int changed) {
            this.changed = changed;
        }

        public int getDeleted() {
            return deleted;
        }

        public void setDeleted(int deleted) {
            this.deleted = deleted;
        }
    }

}