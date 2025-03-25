package com.ecommerce.dto.request;

import com.ecommerce.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.*;
import static com.ecommerce.constants.RegExpConstant.*;
import static com.ecommerce.constants.UserConstant.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserRequest {
    @NotEmpty(message = USER_FIRST_NAME_EMPTY)
    @Pattern(regexp = REG_EXP_ALPHA,message = USER_FIRST_NAME_REGEX_ERROR)
    private String firstName;
    @NotEmpty(message = USER_LAST_NAME_EMPTY)
    @Pattern(regexp = REG_EXP_ALPHA,message = USER_LAST_NAME_REGEX_ERROR)
    private String lastName;
    @NotNull(message = USER_GENDER_NULL)
    private Gender gender;
    @Pattern(regexp = REG_EXP_ALPHA_WITH_SPACES,message = USER_CITY_REGEX_ERROR)
    private String city;
    @NotEmpty(message = USER_AGE_EMPTY)
    @Pattern(regexp = REG_EXP_NUMERIC,message = USER_AGE_REGEX_ERROR)
    private String age;
    @NotEmpty(message = USER_EMAIL_EMPTY)
    @Email(message = USER_EMAIL_INVALID)
    private String email;
    @NotEmpty(message = USER_PASSWORD_EMPTY)
    @Pattern(regexp = REG_EXP_PASSWORD,message = USER_PASSWORD_REGEX_ERROR)
    private String password;
}
