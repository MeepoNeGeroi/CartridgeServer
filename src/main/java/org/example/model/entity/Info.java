package org.example.model.entity;

public class Info {
    private String name;
    private Object count;

    public Info(String name, Object count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getCount() {
        return count;
    }

    public void setCount(Object count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Info{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}
