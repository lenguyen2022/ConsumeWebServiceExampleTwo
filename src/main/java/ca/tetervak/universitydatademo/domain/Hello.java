package ca.tetervak.universitydatademo.domain;

import lombok.Data;


public class Hello {
    private String name;
    public Hello() {
        name = "Hello!!!";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Hello{" +
                "name='" + name + '\'' +
                '}';
    }
}
