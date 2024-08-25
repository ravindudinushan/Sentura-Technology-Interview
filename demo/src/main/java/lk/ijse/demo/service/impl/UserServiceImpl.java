package lk.ijse.demo.service.impl;

import lk.ijse.demo.dto.CustomDTO;
import lk.ijse.demo.dto.UserDTO;
import lk.ijse.demo.entity.User;
import lk.ijse.demo.repo.UserRepo;
import lk.ijse.demo.service.UserService;
import lk.ijse.demo.service.exception.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveUser(UserDTO dto) {
        if (repo.existsById(dto.getUid())) {
            throw new RuntimeException("User Already Exist. Please enter another id..!");
        }
        repo.save(mapper.map(dto, User.class));
    }

    @Override
    public void updateUser(UserDTO dto) {
        if (!repo.existsById(dto.getUid())) {
            throw new RuntimeException("User Not Exist. Please enter Valid id..!");
        }
        repo.save(mapper.map(dto, User.class));
    }

    @Override
    public void deleteUser(String userCode) {
        if(!repo.existsById(userCode)){ throw new NotFoundException("Delete Failed; user code: " + userCode + " does not exist");
        }
        repo.deleteById(userCode);
    }

    @Override
    public List<UserDTO> getAllUser() {
        return repo.findAll().stream().map(user -> mapper.map(user, UserDTO.class)).toList();
    }

    @Override
    public CustomDTO userIdGenerate() {
        return new CustomDTO(repo.getLastIndex());
    }

    @Override
    public User searchUserCode(String userCode) {
        if (!repo.existsById(userCode)) {
            throw new RuntimeException("Wrong ID. Please enter Valid id..!");
        }
        return mapper.map(repo.findById(userCode).get(), User.class);
    }
}
