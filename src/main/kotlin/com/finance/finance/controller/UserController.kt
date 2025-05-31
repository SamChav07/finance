package com.finance.finance.controller

import com.finance.finance.model.User
import com.finance.finance.service.UserService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/users")
class UserController(userService: UserService) :
    GenericController<User, Long>(userService) {

}