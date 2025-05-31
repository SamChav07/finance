package com.finance.finance.service

import com.finance.finance.model.User
import com.finance.finance.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(userRepository: UserRepository) :
        GenericServiceImpl<User, Long>(userRepository) {}