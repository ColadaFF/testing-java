package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.stream.Stream;

public class QuestionOption {


    // Debe tener más de 10 caracteres
    // no debe contener numeros


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
