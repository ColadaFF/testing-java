package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.stream.Stream;

public class QuestionTitle {


    // Debe iniciar con "¿" y cerrar con "?"
    // tamaño no debe ser superior a 240 caraccteres
    // debe tener texto entre los signos de pregunta


    @TestFactory
    @DisplayName("Todos fallan")
    Stream<DynamicTest> all_should_fail() {
        return Stream.empty();
    }


    @TestFactory
    @DisplayName("Todos pasan")
    Stream<DynamicTest> all_should_pass() {
        return Stream.empty();
    }

}
