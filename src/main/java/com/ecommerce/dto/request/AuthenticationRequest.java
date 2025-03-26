package com.ecommerce.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.ecommerce.constants.UserConstant.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest {
    @NotEmpty(message = USER_EMAIL_EMPTY)
    @Email(message = USER_EMAIL_INVALID)
    private String email;
    @NotEmpty(message = USER_PASSWORD_EMPTY)
    private String password;

}
