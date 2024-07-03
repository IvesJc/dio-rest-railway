package me.dio.domain.mapper;

import me.dio.domain.dto.UserDTO;
import me.dio.domain.model.User;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class UserDTOMapper implements Function<User, UserDTO> {
    @Override
    public UserDTO apply(User user) {
        return new UserDTO(
                user.getName(),
                user.getAccount(),
                user.getCard(),
                user.getFeatures(),
                user.getNews()
        );
    }
}
