package mkv.com.mkv.service;

import mkv.com.mkv.DTO.UserDTO;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);
    UserDTO getAllUsers();
    UserDTO getUserById(long id);
    UserDTO updateUser(UserDTO userDTO, long id);

    void deleteUserById(long id);
}
