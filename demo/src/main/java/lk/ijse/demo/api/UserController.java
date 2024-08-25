package lk.ijse.demo.api;

import lk.ijse.demo.dto.CustomDTO;
import lk.ijse.demo.dto.UserDTO;
import lk.ijse.demo.entity.User;
import lk.ijse.demo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDTO> getAllUser(){
        return userService.getAllUser();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/userIdGenerate")
    public @ResponseBody
    CustomDTO userIdGenerate() {
        return userService.userIdGenerate();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public void saveUser(@RequestBody UserDTO dto){
        userService.saveUser(dto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(params = {"userCode"})
    public void deleteUser(@RequestParam String userCode) {
        userService.deleteUser(userCode);
    }

    @PutMapping
    public void updateUser(@RequestBody UserDTO dto) {
        userService.updateUser(dto);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/searchUser", params = {"userCode"})
    public User searchUserCode(String userCode) {
        return userService.searchUserCode(userCode);
        }
}
