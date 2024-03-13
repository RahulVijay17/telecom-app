package com.ladera.telecom.controller;

import com.ladera.telecom.dto.ResponseDto;
import com.ladera.telecom.dto.UserDto;
import com.ladera.telecom.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class LoginControllerTest {
    @Mock
    private UserService userService;
    @InjectMocks
    private LoginController loginController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRegisterUser_Success() {
        // Given
        UserDto userDto = UserDto.builder()
                .email("rahul@telecom.com")
                .mobileNumber("9677210944")
                .pwd("12345")
                .role("amdin")
                .name("rahul")
                .build();

        // When
        ResponseEntity<ResponseDto> response = loginController.registerUser(userDto);

        // Then
        assertEquals(HttpStatus.CREATED, response.getStatusCode());

        verify(userService).registerUser(userDto);
    }
}