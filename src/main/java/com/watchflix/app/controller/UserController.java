package com.watchflix.app.controller;

import com.watchflix.app.domain.dto.response.UserDto;
import com.watchflix.app.domain.entity.User;
import com.watchflix.app.domain.entity.UserMovie;
import com.watchflix.app.mapper.UserMapper;
import com.watchflix.app.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping(path = "/api/v1/users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    public UserController (UserService userService, UserMapper userMapper){
        this.userService = userService;
        this.userMapper = userMapper;

    }

    @GetMapping(path = "/search")
    public ResponseEntity<List<UserDto>> searchUser(@RequestParam String q){

        List<User> user = userService.searchUser(q);
        return new ResponseEntity<>(user.stream().map(userMapper::toDto).toList(), HttpStatus.OK);
    }

    @GetMapping(path = "/{username}")
    public ResponseEntity<UserDto> getUserByUserName(@PathVariable String username)
    {
        User user = userService.getUserByUsername(username);
        UserDto userDto = userMapper.toDto(user);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }
}
