package lk.ijse.demo.service;

import lk.ijse.demo.dto.CustomDTO;
import lk.ijse.demo.dto.UserDTO;
import lk.ijse.demo.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDTO dto);
    void updateUser(UserDTO dto);
    void deleteUser(String employeeCode);
    List<UserDTO> getAllUser();
    CustomDTO employeeIdGenerate();
    User searchUserCode(String employeeCode);
}
