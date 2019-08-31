package domain;

import org.apache.commons.lang3.Validate;

public class Email {
    public static Email of(String value) {
        return new Email(value);
    }


    private final String value;

    private Email(String value) {
        String notNullString = Validate.notNull(value);
        Validate.inclusiveBetween(15, 77, value.length(), "el tamaño dirección debe estar entre 15 y 77");
        String pattern = "^[a-z0-9]+\\.?[a-z0-9]+@\\bias.com.co$";
        Validate.matchesPattern(notNullString.toLowerCase(), pattern, "dirección de correo inválida");



        this.value = notNullString.toLowerCase();
    }

    public String getValue() {
        return value;
    }
}
