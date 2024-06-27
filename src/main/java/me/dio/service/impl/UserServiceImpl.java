package me.dio.service.impl;

import me.dio.domain.model.User;
import me.dio.repository.UserRepository;
import me.dio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).
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
        Optional<User> newUser = userRepository.findById(id);

        if (newUser.isPresent()) {
            userRepository.save(user);
        }
        throw new NoSuchElementException("User not found");
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
