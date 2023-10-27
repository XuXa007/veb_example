package org.example.Enums;


public enum Category {
    CAR(123),
    BUS(1),
    TRUCK(2),
    MOTORCYCLE(3);

    private int title;

    Category(int title) {
        this.title = title;
    }

    public int getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Category{" +
                "title='" + title + '\'' +
                '}';
    }
}
