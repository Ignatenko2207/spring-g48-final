package ua.mainacademy.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.mainacademy.controller.dto.UserDTO;
import ua.mainacademy.controller.mapper.UserMapper;
import ua.mainacademy.model.User;
import ua.mainacademy.service.UserService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    @PutMapping
    public ResponseEntity<UserDTO> create(@RequestBody User user) {
        try {
            return new ResponseEntity<>(userMapper.toDTO(userService.create(user)), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<UserDTO> update(@RequestBody User user) {
        try {
            return new ResponseEntity<>(userMapper.toDTO(userService.update(user)), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findOneById(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(userMapper.toDTO(userService.findOneById(id)), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        return new ResponseEntity<>(userMapper.toDTOList(userService.findAll()), HttpStatus.OK);
    }

    @DeleteMapping("/id")
    public ResponseEntity<Void> deleteById(Integer id) {
        try {
            userService.deleteById(id);
        } catch (Exception e) {
            log.warn("Delete method was processed with exception for user with id {}", id);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
