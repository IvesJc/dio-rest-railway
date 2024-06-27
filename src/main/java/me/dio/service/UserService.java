package me.dio.service;

import me.dio.domain.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();

    User findById(Long id);

    User create(User user);

    User update(User user, Long id);

    void delete(Long id);
}
