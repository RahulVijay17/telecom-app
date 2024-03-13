package com.ladera.telecom.service.impl;

import com.ladera.telecom.dto.UserDto;
import com.ladera.telecom.exception.EmailAlreadyExistsException;
import com.ladera.telecom.exception.MobileNumberAlreadyExistsException;
import com.ladera.telecom.mapper.UserMapper;
import com.ladera.telecom.model.User;
import com.ladera.telecom.repository.userrepository.UserRepository;
import com.ladera.telecom.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDto registerUser(UserDto userDto) {
        log.info("Attempting to register user for given email: {}", userDto.getEmail());

        User user = UserMapper.mapToUser(userDto, new User());

        userRepository.findByEmail(userDto.getEmail())
                .ifPresent(existingUser -> {
                    log.warn("Email already exists for user: {}", userDto.getEmail());
                    throw new EmailAlreadyExistsException("User with the given email already exists");
                });

        if (userRepository.existsByMobileNumber(userDto.getMobileNumber())){
            log.warn("Mobile number already exists for user: {}", userDto.getMobileNumber());
            throw new MobileNumberAlreadyExistsException("User with the given mobile number already exists");
        }

        String hashPwd = passwordEncoder.encode(user.getPwd());
        user.setPwd(hashPwd);
        user.setId(generateUniqueStringId());

        User savedUser = userRepository.save(user);

        log.info("User registered successfully: UserDto(name={}, email={}, mobileNumber={}, pwd={}, role={})",
                user.getName(), user.getEmail(), user.getMobileNumber(), hashPwd, user.getRole());

        return UserMapper.mapToUserDto(savedUser, new UserDto());
    }

    private String generateUniqueStringId() {
        return  UUID.randomUUID().toString();
    }

}
