package ru.job4j.collection;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleHashMap<K, V> implements Iterable {

    private Node[] table;
    private int count = 0;
    private int modCount = 0;

    public SimpleHashMap(int size) {
        this.table = new Node[size];
    }

    public boolean insert(K key, V value) {
        if (count == table.length) {
            resize();
        }
        if (key != null) {
            Node<K, V> element = new Node<>(key, value);
            int index = getIndex(key.hashCode());
            if (table[index] == null) {
                table[index] = element;
                count++;
                modCount++;
                return true;
            }
        }
        return false;
    }

    public V get(K key) {
        return (V) table[getIndex(key.hashCode())].getValue();
    }

    public boolean delete(K key) {
        if (key != null) {
            int index = getIndex(key.hashCode());
            if (table[index] != null) {
                table[index] = null;
                count--;
                modCount++;
                return true;
            }
        }
        return false;
    }

    private int getIndex(int hash) {
        return hash % table.length;
    }

    public void resize() {
        table = Arrays.copyOf(table, table.length * 2);
    }

    public int size() {
        return table.length;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            private int cursor = 0;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                boolean result = false;
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                for (int i = cursor; i < table.length; i++) {
                    if (table[i] != null) {
                        result = true;
                        break;
                    }
                }
                return result;
            }

            @Override
            public V next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                while (table[cursor] == null && cursor < table.length) {
                    cursor++;
                }
                return (V) table[cursor++].getValue();
            }
        };
    }

    private class Node<K, V> {
        private K key;
        private V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public int hashCode() {
            return 31 * key.hashCode() * value.hashCode();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o instanceof Node) {
                Node<K, V> node = (Node) o;
                if (this.key == null ? node.key != null : !this.key.equals(node.key)) {
                    return false;
                }
                if (this.value == null ? node.value != null : !this.value.equals(node.value)) {
                    return false;
                }
            }
            return true;
        }

    }

}
