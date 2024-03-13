package com.ladera.telecom.controller;

import com.ladera.telecom.constants.ApplicationConstants;
import com.ladera.telecom.dto.ErrorResponseDto;
import com.ladera.telecom.dto.ResponseDto;
import com.ladera.telecom.dto.UserDto;
import com.ladera.telecom.model.User;
import com.ladera.telecom.repository.userrepository.UserRepository;
import com.ladera.telecom.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Tag(
        name = "REST APIs for Telecom Call Center",
        description = "CRUD REST APIs for Telecom Call Center to CREATE, UPDATE, FETCH AND DELETE account details"
)
@RestController
@RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
@Slf4j
@Validated
@AllArgsConstructor
public class LoginController {

    private final UserRepository userRepository;
    private final UserService userService;

    @Operation(
            summary = "Register user REST API",
            description = "REST API to Register new User "
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "HTTP Status CREATED"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @PostMapping("/register")
    public ResponseEntity<ResponseDto> registerUser(@Valid @RequestBody UserDto userDto) {
        userService.registerUser(userDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto(ApplicationConstants.STATUS_201, ApplicationConstants.MESSAGE_201));
    }

    @Operation(
            summary = "Get User Details After Login",
            description = "Retrieve user details for the authenticated user after login."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Successful retrieval of user details",
                    content = @Content(
                            schema = @Schema(implementation = UserDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "User not found"
            )
    })
    @RequestMapping("/user")
    public User getUserDetailsAfterLogin(Authentication authentication) {
        return userRepository.findByEmail(authentication.getName()).orElse(null);
    }

}
