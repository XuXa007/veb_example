package org.example.Enums;

public enum RoleEnum {
    User(0),
    Admin(1);

    private int title;

    RoleEnum(int title) {
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
        return "RoleEnum{" +
                "title=" + title +
                '}';
    }
}
