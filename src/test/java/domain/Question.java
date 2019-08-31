package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.stream.Stream;

public class Question {


    // Debe tener un titulo y multiples opciones
    // no debe tener más de 4 opciones
    // no debe tener 0 opciones
    // no se debe poder modificar la lista de opciones


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
