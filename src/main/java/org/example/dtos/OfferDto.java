package org.example.dtos;


import org.example.Enums.Engine;
import org.example.Enums.Transmission;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class OfferDto {
    private UUID id;
    private ModelDto model;
    private UsersDto users;
    private String description;
    private Engine engine;
    private String imageURL;
    private int mileage;
    private BigDecimal price;
    private Transmission transmission;
    private int year;
    private LocalDateTime created;
    private LocalDateTime modified;

    protected OfferDto() {};

    public OfferDto(UUID id, ModelDto model, UsersDto users, String description, Engine engine, String imageURL,
                    int mileage, BigDecimal price, Transmission transmission, int year, LocalDateTime created,
                    LocalDateTime modified) {
        this.id = id;
        this.model = model;
        this.users = users;
        this.description = description;
        this.engine = engine;
        this.imageURL = imageURL;
        this.mileage = mileage;
        this.price = price;
        this.transmission= transmission;
        this.year = year;
        this.created = created;
        this.modified = modified;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ModelDto getModel() {
        return model;
    }

    public void setModel(ModelDto model) {
        this.model = model;
    }

    public UsersDto getUsers() {
        return users;
    }

    public void setUsers(UsersDto users) {
        this.users = users;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    @Override
    public String toString() {
        return "OfferDto{" +
                "id=" + id +
                ", model=" + model +
                ", user=" + users +
                ", description='" + description + '\'' +
                ", engineEnum=" + engine +
                ", imageURL='" + imageURL + '\'' +
                ", mileage=" + mileage +
                ", price=" + price +
                ", transmissionEnum=" + transmission +
                ", year=" + year +
                ", created=" + created +
                ", modified=" + modified +
                '}';
    }
}