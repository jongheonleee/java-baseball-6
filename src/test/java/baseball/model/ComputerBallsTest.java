package baseball.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ComputerBallsTest {

    @DisplayName("생성 실패 테스트 - 1~9 범위를 벗어난 값 입력")
    @MethodSource("createComputerBallsExceptionTestDummy")
    @ParameterizedTest
    void createComputerBallsExceptionTest(List<Integer> balls) {
        assertThrows(IllegalArgumentException.class,
                () -> new ComputerBalls(balls));
    }

    @DisplayName("생성 실패 테스트 - 중복된 값 존재")
    @MethodSource("createComputerBallsExceptionTestDummy2")
    @ParameterizedTest
    void createComputerBallsExceptionTest2(List<Integer> balls) {
        assertThrows(IllegalArgumentException.class,
                () -> new ComputerBalls(balls));
    }

    @DisplayName("생성 실패 테스트 - 숫자 3개보다 많거나 적은 개수 입력")
    @MethodSource("createComputerBallsExceptionTestDummy3")
    @ParameterizedTest
    void createComputerBallsExceptionTest3(List<Integer> balls) {
        assertThrows(IllegalArgumentException.class,
                () -> new ComputerBalls(balls));
    }

    @DisplayName("생성 성공 테스트")
    @MethodSource("createComputerBallsSuccessTestDummy")
    @ParameterizedTest
    void createComputerBallsSuccessTest(List<Integer> balls) {
        assertDoesNotThrow(() -> new ComputerBalls(balls));
    }

    @DisplayName("컴퓨터 필드값 조회 기능 테스트")
    @MethodSource("getBallsSuccessTestDummy")
    @ParameterizedTest
    void getBallsTest(List<Integer> balls, Boolean expected) {
        ComputerBalls computerBalls = new ComputerBalls(balls);
        List<Integer> computerBallsBalls = computerBalls.getBalls();
        boolean result = computerBallsBalls.equals(balls);
        assertEquals(expected, result);
    }

    static Stream<Arguments> createComputerBallsExceptionTestDummy() {
        return Stream.of(
                Arguments.arguments(List.of(1, 100, 8)),
                Arguments.arguments(List.of(-1, 1, 8)),
                Arguments.arguments(List.of(0, 2, 8)),
                Arguments.arguments(List.of(33, 9, 3))
        );
    }

    static Stream<Arguments> createComputerBallsExceptionTestDummy2() {
        return Stream.of(
                Arguments.arguments(List.of(1, 1, 8)),
                Arguments.arguments(List.of(1, 8, 8)),
                Arguments.arguments(List.of(2, 2, 8)),
                Arguments.arguments(List.of(3, 9, 3))
        );
    }

    static Stream<Arguments> createComputerBallsExceptionTestDummy3() {
        return Stream.of(
                Arguments.arguments(List.of(1, 2, 8, 7)),
                Arguments.arguments(List.of(3, 1)),
                Arguments.arguments(List.of(9, 2, 8, 3, 4)),
                Arguments.arguments(List.of(7))
        );
    }

    static Stream<Arguments> createComputerBallsSuccessTestDummy() {
        return Stream.of(
                Arguments.arguments(List.of(1, 2, 8)),
                Arguments.arguments(List.of(3, 1, 8)),
                Arguments.arguments(List.of(9, 2, 8)),
                Arguments.arguments(List.of(7, 9, 3))
        );
    }

    static Stream<Arguments> getBallsSuccessTestDummy() {
        return Stream.of(
                Arguments.arguments(List.of(1, 2, 8), true),
                Arguments.arguments(List.of(3, 1, 8), true),
                Arguments.arguments(List.of(9, 2, 8), true),
                Arguments.arguments(List.of(7, 9, 3), true)
        );
    }
}