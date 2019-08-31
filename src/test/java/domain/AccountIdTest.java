package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountIdTest {

    @Test()
    @DisplayName("Debe fallar cuando la cantidad de caracteres no sea 11")
    void of() {
        // arrange
        String accountNumber = "121312";
        // assert
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {

            // act
            AccountId.of(accountNumber);
        });

        assertTrue(ex
                        .getMessage()
                        .contains("El numero de cuenta debe tener 11 caracteres"),
                "Esperabamos que fallara por validacion de 11, pero no");

    }


    @Test
    @DisplayName("Debe crear un numero de cuenta")
    void createNumberValid() {
        String accountNumber = "12345678901";
        AccountId id = AccountId.of(accountNumber);

        assertNotNull(id);
    }

}