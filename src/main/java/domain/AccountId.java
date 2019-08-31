package domain;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

public class AccountId {
    public static AccountId of(String id) {
        return new AccountId(id);
    }


    private final String value;

    private AccountId(String value) {
        String validString = Validate.notNull(value);
        Validate.notBlank(validString, "El id no puede estar en blanco");
        Validate.isTrue(!StringUtils.containsWhitespace(validString));
        Validate.isTrue(StringUtils.length(validString) == 11, "El numero de cuenta debe tener 11 caracteres");
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "domain.AccountId{" +
                "value='" + value + '\'' +
                '}';
    }
}
