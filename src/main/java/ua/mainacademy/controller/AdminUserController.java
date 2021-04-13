package ua.mainacademy.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.mainacademy.controller.dto.UserDTO;
import ua.mainacademy.controller.mapper.UserMapper;
import ua.mainacademy.service.UserService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("admin")
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminUserController {

    private final UserService userService;
    private final UserMapper userMapper = Mappers.getMapper(UserMapper.class);

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
}
