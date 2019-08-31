package domain;


import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.DynamicTest.*;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


public class EmailTest {

    @Test
    @DisplayName("No se puede crear un correo con un valor nulo")
    void notNull() {
        Exception ex = assertThrows(NullPointerException.class, () -> {
            Email.of(null);
        });
    }

    @TestFactory
    @DisplayName("Todos deben fallar")
    Stream<DynamicTest> should_be_rejected() {
        return Stream.of(
                null,
                "null",
                "nil",
                "0",
                " ",
                "\n",
                "\t",
                "sergio\n@ias.com.co",
                "   @ias.com.co",
                "---",
                "e j e m p l o @ias. c o m . c o",
                "13456789876543!·$%&/()"
        )
                .map(input -> {

                    String displayName = "Rechazado: " + input;
                    Executable testBody = () -> {
                        assertThrows(RuntimeException.class, () -> {
                            Email.of(input);
                        });
                    };
                    return dynamicTest(displayName, testBody);
                });
    }


    @TestFactory
    @DisplayName("Todos deben pasar")
    Stream<DynamicTest> all_should_pass() {
        return Stream.of(
              "emerson@ias.com.co",
                "gabriel@ias.com.co"
        )
                .map(input -> {

                    String displayName = "Pasa: " + input;
                    Executable testBody = () -> {
                        Email email = Email.of(input);
                        assertNotNull(email);
                        assertEquals(input.toLowerCase(), email.getValue());
                    };
                    return dynamicTest(displayName, testBody);
                });
    }

    @TestFactory
    @DisplayName("Deben fallar por tamaño")
    Stream<DynamicTest> should_fail_by_length() {
        return Stream.of(
                "a@ias.com.co",
                StringUtils.repeat("X", 90).concat("@ias.com.co")

        )
                .map(input -> {

                    String displayName = "Rechazado: " + input;
                    Executable testBody = () -> {
                        assertThrows(RuntimeException.class, () -> {
                            Email.of(input);
                        });
                    };
                    return dynamicTest(displayName, testBody);
                });
    }

}
