package mariuszs.hessian.api;

import java.io.Serializable;

public class Foo implements Serializable{

    private int x;
    private String name;
    private Bar bar;

    public Foo() {
    }

    public Foo(int x, String name, Bar bar) {
        this.x = x;
        this.name = name;
        this.bar = bar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public Bar getBar() {
        return bar;
    }

    public void setBar(Bar bar) {
        this.bar = bar;
    }
}
