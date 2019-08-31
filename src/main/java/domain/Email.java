package domain;

import org.apache.commons.lang3.Validate;

public class Email {
    public static Email of(String value) {
        return new Email(value);
    }


    private final String value;

    private Email(String value) {
        String notNullString = Validate.notNull(value);

        String pattern = "^[a-z0-9]+\\.?[a-z0-9]+@\\bias.com.co$";
        Validate.matchesPattern(notNullString.toLowerCase(), pattern, "dirección de correo inválida");

        this.value = notNullString.toLowerCase();
    }


}
