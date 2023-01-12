package mkv.com.mkv.service;

import mkv.com.mkv.DTO.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO userDTO, long elevatorId);
    List<UserDTO> getAllUsers();
    UserDTO getUserById(long id);
    UserDTO updateUser(UserDTO userDTO, long id);

    void deleteUserById(long id);
}
