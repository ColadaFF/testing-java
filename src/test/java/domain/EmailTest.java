package domain;


import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.DynamicTest.*;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

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
    Stream<DynamicTest> should_be_rejected(){
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
                .map(input -> dynamicTest("Rechazado: " + input, () -> {
                    assertThrows(RuntimeException.class, () -> {
                        Email.of(input);
                    });
                }));
    }

}
