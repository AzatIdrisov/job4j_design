package ru.job4j.generic;

import java.util.ArrayList;
import java.util.List;

public final class MemStore<T extends Base> implements Store<T> {

    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        int position = findIndexById(id);
        if (position != -1) {
            mem.set(position, model);
        }
        return position != -1;
    }

    @Override
    public boolean delete(String id) {
        int position = findIndexById(id);
        if (position != -1) {
            mem.remove(position);
        }
        return position != -1;
    }

    @Override
    public T findById(String id) {
        T item = null;
        int position = findIndexById(id);
        if (position != -1) {
            item = mem.get(position);
        }
        return item;
    }

    public int findIndexById(String id) {
        int position = -1;
        for (int i = 0; i < mem.size(); i++) {
            if (mem.get(i).getId().equals(id)) {
                position = i;
                break;
            }
        }
        return position;
    }
}