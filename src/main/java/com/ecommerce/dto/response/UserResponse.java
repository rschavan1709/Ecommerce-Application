package com.ecommerce.dto.response;

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
    private String gender;
    private String city;
    private Integer age;

}
