package me.dio.controller;

import jakarta.websocket.server.PathParam;
import me.dio.domain.dto.UserDTO;
import me.dio.domain.model.User;
import me.dio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        List<UserDTO> usersList = userService.findAll();
        return ResponseEntity.ok(usersList);
    }

    // @PathParam = JAX-RS
    // @PathVariable = Spring
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id){
        UserDTO user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user){
        User userCreated = userService.create(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").
                buildAndExpand(userCreated.getId()).
                toUri();

        return ResponseEntity.created(location).body(userCreated);
    }
}
