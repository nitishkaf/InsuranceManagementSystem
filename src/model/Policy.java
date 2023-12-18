package model;

import java.util.HashSet;
import java.util.Set;

public class Policy {
    private int id;
    private String name;
    private String description;
    private double price;
    private int userId;
    private Set<Integer> appliedUserIds;

    public Policy(int id, String name, String description, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Policy() {
        super();
        this.appliedUserIds = new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void applyPolicy(int userId) {
        this.appliedUserIds.add(userId);
    }
    public boolean isUserApplied(int userId) {
        return this.appliedUserIds.contains(userId);
    }
    public Set<Integer> getAppliedUserIds() {
        return appliedUserIds;
    }
}
