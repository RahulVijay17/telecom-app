package com.ladera.telecom.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

import com.ladera.telecom.dto.UserDto;
import com.ladera.telecom.mapper.UserMapper;
import com.ladera.telecom.model.User;
import com.ladera.telecom.repository.userrepository.UserRepository;
import com.ladera.telecom.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserServiceImplTest {
    @Mock
    private UserRepository userRepository;
    @Mock
    private PasswordEncoder passwordEncoder;
    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        initMocks(this);
    }

    @Test
    void registerUser_Success() {
        // Given
        UserDto userDto = new UserDto();
        userDto.setEmail("test@example.com");
        userDto.setMobileNumber("1234567890");
        userDto.setPwd("password");
        userDto.setName("test");
        userDto.setRole("admin");

        User user = UserMapper.mapToUser(userDto, new User());

        when(userRepository.findByEmail(anyString())).thenReturn(java.util.Optional.empty());
        when(userRepository.existsByMobileNumber(anyString())).thenReturn(false);
        when(passwordEncoder.encode(anyString())).thenReturn(userDto.getPwd());
        when(userRepository.save(any(User.class))).thenReturn(user);

        // When
        UserDto savedUserDto = userService.registerUser(userDto);

        // Then
        assertNotNull(savedUserDto);
        assertEquals("test@example.com", savedUserDto.getEmail());
        assertEquals("1234567890", savedUserDto.getMobileNumber());
    }

}
