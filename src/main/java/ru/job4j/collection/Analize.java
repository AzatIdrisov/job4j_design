package ru.job4j.collection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Analize {

    public Info diff(List<User> previous, List<User> current) {
        Info info = new Info();
        Map<Integer, User> currentUsers = new HashMap<Integer, User>();
        for (User user : current) {
            currentUsers.put(user.getId(), user);
        }
        for (User user : previous) {
            User temp;
            temp = currentUsers.remove(user.getId());
            if (temp == null) {
                info.setDeleted(info.getDeleted() + 1);
            } else if (!temp.equals(user)) {
                info.setChanged(info.getChanged() + 1);
            }
        }
        info.setAdded(currentUsers.size());
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

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            User user = (User) o;
            return id == user.id
                    && Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
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