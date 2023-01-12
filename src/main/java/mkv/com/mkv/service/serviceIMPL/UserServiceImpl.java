package mkv.com.mkv.service.serviceIMPL;

import mkv.com.mkv.DTO.UserDTO;
import mkv.com.mkv.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public UserDTO createUser(UserDTO userDTO, long elevatorId) {
        return null;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return null;
    }

    @Override
    public UserDTO getUserById(long id) {
        return null;
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, long id) {
        return null;
    }

    @Override
    public void deleteUserById(long id) {

    }
}
