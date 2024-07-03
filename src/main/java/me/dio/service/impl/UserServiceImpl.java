package me.dio.service.impl;

import me.dio.domain.dto.UserDTO;
import me.dio.domain.mapper.UserDTOMapper;
import me.dio.domain.model.User;
import me.dio.repository.UserRepository;
import me.dio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDTOMapper userDTOMapper;

    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll().
                stream().
                map(userDTOMapper).
                toList();
    }

    @Override
    public UserDTO findById(Long id) {
        return userRepository.findById(id).
                map(userDTOMapper).
                orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User user) {
        if (!userRepository.existsByAccountNumber(user.getAccount().getNumber())){
            return userRepository.save(user);
        }
        throw new IllegalArgumentException("This account number already exists");
    }

    @Override
    public User update(User user, Long id) {

        UserDTO newUser = userRepository.findById(id).
                map(userDTOMapper).
                orElseThrow(NoSuchElementException::new);

        if (!Objects.equals(newUser.account().getId(), user.getAccount().getId())){
            throw new RuntimeException();
        }
        user.setName(newUser.name());
        user.setAccount(newUser.account());
        user.setCard(newUser.card());
        user.setFeatures(newUser.features());
        user.setNews(newUser.news());
        return user;
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
