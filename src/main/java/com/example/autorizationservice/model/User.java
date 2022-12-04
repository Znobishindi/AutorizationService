package com.example.autorizationservice.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;

public class User {
    @NotBlank
    @Size(min = 2, max = 20)
    private final String name;
    @NotBlank
    @Size(min = 2, max = 10)
    private final String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(user, user.name) && Objects.equals(password, user.password);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, password);
    }


    @Override
    public String toString() {
        return "UserAuthorities{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}