package com.example.autorizationservice.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {

    private final Map<User, List<Authorities>> listMap = new ConcurrentHashMap<>();
    private final List<Authorities> permissions = new ArrayList<>();

    public UserRepository() {
        //Для теста искуственно добавим пользователя
        listMap.put(new User("Denis","1111"), Arrays.asList(Authorities.READ,Authorities.WRITE));
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        for (Map.Entry<User, List<Authorities>> entry : listMap.entrySet()) {

            if (entry.getKey().getName().equals(user)
                    && entry.getKey().getPassword().equals(password)) {
                return entry.getValue();
            }
        }
        return permissions;
    }
}
