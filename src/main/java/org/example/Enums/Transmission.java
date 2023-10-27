package org.example.Enums;


public enum Transmission {
    MANUAL(0),
    AUTOMATIC(1);
    private int title;

    Transmission(int title) {
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
        return "Transmission{" +
                "title=" + title +
                '}';
    }
}