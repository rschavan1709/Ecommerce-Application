package com.ecommerce.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserRequest {
    private String firstName;
    private String lastName;
    private String gender;
    private String city;
    private Integer age;

}
