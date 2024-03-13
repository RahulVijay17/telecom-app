package com.ladera.telecom.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(
        name = "Users",
        description = "Schema to hold Users information"
)
@Builder
public class UserDto {

    @NotEmpty(message = "UserName can not be null or empty")
    @Schema(
            description = "Telecom User's Name",
            example = "Rahul"
    )
    private String name;

    @Email
    @NotEmpty(message = "Email can not be null or empty")
    @Schema(
            description = "User's Email",
            example = "rahul@example.com"
    )
    private String email;

    @Pattern(regexp = "(^$|[0-9]{10})", message = "MobileNumber must be 10 digits")
    @NotEmpty(message = "MobileNumber can not be null or empty")
    @Schema(
            description = "Mobile Number of User",
            example = "3454433243"
    )
    private String mobileNumber;

    @NotEmpty(message = "Password can not be null or empty")
    @Schema(
            description = "User's Password",
            example = "password123"
    )
    private String pwd;

    @NotEmpty(message = "Role can not be null or empty")
    @Schema(
            description = "User's Role",
            example = "USER"
    )
    private String role;

}
