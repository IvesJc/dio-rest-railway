package me.dio.service;

import me.dio.domain.dto.UserDTO;
import me.dio.domain.model.User;

import java.util.List;

public interface UserService {

    List<UserDTO> findAll();

    UserDTO findById(Long id);

    User create(User user);

    User update(User user, Long id);

    void delete(Long id);
}
