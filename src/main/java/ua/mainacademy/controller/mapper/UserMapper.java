package ua.mainacademy.controller.mapper;

import org.mapstruct.Mapper;
import ua.mainacademy.controller.dto.UserDTO;
import ua.mainacademy.model.User;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toDTO(User user);
    List<UserDTO> toDTOList(List<User> users);

}
