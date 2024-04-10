package com.Main.StorageManagment;

import com.Main.StorageManagment.Service.UserService;
import com.Main.StorageManagment.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class userContrroller {
    private final UserService userService;

    public userContrroller(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getUser() {
        List<User> users = userService.FindAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);

    }

    @GetMapping("/find/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Long id) {
        User users = userService.findUserById(id);
        return new ResponseEntity<>(users, HttpStatus.OK);

    }
    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User newUser = userService.generateBussinessCode(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User UpdateUser = userService.UpdateUser(user);
        return new ResponseEntity<>(UpdateUser, HttpStatus.CREATED);
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable("id") Long id) {
       userService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
