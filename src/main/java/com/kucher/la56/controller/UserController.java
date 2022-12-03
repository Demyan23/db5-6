package com.kucher.la56.controller;

import com.kucher.la56.dto.assembler.UserDtoAssembler;
import com.kucher.la56.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.kucher.la56.domain.User;
import com.kucher.la56.dto.UserDto;


import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;
    private final UserDtoAssembler userDtoAssembler;


    @Autowired
    public UserController(UserService userService, UserDtoAssembler userDtoAssembler) {
        this.userService = userService;
        this.userDtoAssembler = userDtoAssembler;
    }

    @GetMapping(value = "/{userid}")
    public ResponseEntity<UserDto> findById(@PathVariable Integer userid) {
        User user = userService.findById(userid);
        UserDto userDto = userDtoAssembler.toModel(user);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<UserDto>> getAllObjects() {
        List<User> users = userService.findAll();
        CollectionModel<UserDto> userDtos = userDtoAssembler.toCollectionModel(users);
        return new ResponseEntity<>(userDtos, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<UserDto> add(@RequestBody User user) {
        User newUser = userService.create(user);
        UserDto userDto = userDtoAssembler.toModel(newUser);
        return new ResponseEntity<>(userDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{userid}")
    public ResponseEntity<?> update(@RequestBody User uUser, @PathVariable Integer userid) {
        userService.update(userid, uUser);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{userid}")
    public ResponseEntity<?> delete(@PathVariable Integer userid) {
        userService.delete(userid);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PostMapping(value = "/dymanic_procedure")
    public ResponseEntity<?> dymanicProcedure() {
        userService.dymanicProcedure();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
