package com.example.autorizationservice.repository;

import com.example.autorizationservice.model.Authorities;
import com.example.autorizationservice.model.User;
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
        listMap.put(new User("Elena","2222"), Arrays.asList(Authorities.DELETE,Authorities.WRITE));
        listMap.put(new User("Pavel","3333"), Arrays.asList(Authorities.READ,Authorities.DELETE));
        listMap.put(new User("Darya","4444"), Arrays.asList(Authorities.DELETE,Authorities.READ));
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
