package org.example.Enums;


public enum Engine {
    GASOLINE(0),
    DIESEL(1),
    ELECTRIC(2),
    HYBRID(3);

    private int title;

    Engine(int title) {
        this.title = title;
    }

    public int getTitle() {
        return title;
    }

    public void setTitle(int title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "title=" + title +
                '}';
    }
}
