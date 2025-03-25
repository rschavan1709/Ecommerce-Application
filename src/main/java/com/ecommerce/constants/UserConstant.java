package com.ecommerce.constants;

public final class UserConstant {

    private UserConstant(){

    }

    public static final String USER_CREATED_SUCCESS = "User Created Successfully";
    public static final String USER_NOT_FOUND = "User Not Found";
    public static final String USER_FOUND_SUCCESS = "User Found Successfully";
    public static final String USERS_NOT_FOUND_IN_LIST ="No Users Found in List";
    public static final String USERS_FETCH_SUCCESS = "Users Fetched Successfully ";
    public static final String USER_DELETE_SUCCESS = "User Deleted Successfully ";
    public static final String USER_UPDATE_SUCCESS = "User Updated Successfully ";
    public static final String USER_FIRST_NAME_EMPTY = "First Name cannot be empty";
    public static final String USER_LAST_NAME_EMPTY = "Last Name cannot be empty";
    public static final String USER_FIRST_NAME_REGEX_ERROR = "First Name should be alphabetic";
    public static final String USER_LAST_NAME_REGEX_ERROR = "Last Name should be alphabetic";
    public static final String USER_CITY_REGEX_ERROR = "City should be alphabetic";
    public static final String USER_GENDER_NULL = "Gender is required";
    public static final String USER_AGE_REGEX_ERROR = "Age should be numeric";
    public static final String USER_AGE_EMPTY = "Age cannot be empty";
    public static final String USER_EMAIL_EMPTY = "Email cannot be empty";
    public static final String USER_EMAIL_INVALID = "Email is invalid";
    public static final String USER_PASSWORD_EMPTY = "Password cannot be empty";
    public static final String USER_PASSWORD_REGEX_ERROR = "Password should have at least one digit, " +
            "one uppercase letter,one lowercase letter, one special character and at least 8 characters and " +
            "at most 15 characters";
    public static final String USER_ALREADY_EXISTS_WITH_GIVEN_EMAIL = "User is already exists with given email";
}
