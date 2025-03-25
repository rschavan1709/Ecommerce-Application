package com.ecommerce.constants;

public final class RegExpConstant {
    private RegExpConstant(){

    }

    public static final String REG_EXP_ALPHA = "^[a-zA-Z]+$";
    public static final String REG_EXP_ALPHA_WITH_SPACES = "^[a-zA-Z\\s]+$";
    public static final String REG_EXP_NUMERIC = "^[0-9]+$";
    public static final String REG_EXP_PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8, 15}$";
}
