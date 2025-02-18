package com.ecommerce.dto.response;

import com.ecommerce.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserResponse {

    private Integer id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private String city;
    private Integer age;

}
