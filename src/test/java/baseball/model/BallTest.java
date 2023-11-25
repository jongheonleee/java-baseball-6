package baseball.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BallTest {


    @DisplayName("생성 실패 테스트")
    @MethodSource("createBallExceptionTestDummy")
    @ParameterizedTest
    void createBallExceptionTest(Integer number) {
        assertThrows(IllegalArgumentException.class,
                () -> new Ball(number));
    }

    @DisplayName("생성 성공 테스트")
    @MethodSource("createBallSuccessTestDummy")
    @ParameterizedTest
    void createBallSuccessTest(Integer number) {
        assertDoesNotThrow(() -> new Ball(number));
    }

    @DisplayName("같은 숫자 비교하는 경우")
    @MethodSource("isSameBallTestDummy")
    @ParameterizedTest
    void isSameBallTest(Integer number, Boolean expected) {
        Ball ball = new Ball(number);
        Boolean result = ball.isSameBall(number);
        assertEquals(expected, result);
    }

    @DisplayName("다른 숫자 비교하는 경우")
    @MethodSource("isSameBallTestDummy2")
    @ParameterizedTest
    void isSameBallTest2(Integer number, Integer number2, Boolean expected) {
        Ball ball = new Ball(number);
        Boolean result = ball.isSameBall(number2);
        assertEquals(expected, result);
    }



    static Stream<Arguments> createBallExceptionTestDummy() {
        return Stream.of(
                Arguments.arguments(-1),
                Arguments.arguments(20),
                Arguments.arguments(18),
                Arguments.arguments(0)
        );
    }

    static Stream<Arguments> createBallSuccessTestDummy() {
        return Stream.of(
                Arguments.arguments(1),
                Arguments.arguments(3),
                Arguments.arguments(6),
                Arguments.arguments(9)
        );
    }

    static Stream<Arguments> isSameBallTestDummy() {
        return Stream.of(
                Arguments.arguments(1, true),
                Arguments.arguments(3, true),
                Arguments.arguments(6, true),
                Arguments.arguments(9, true)
        );
    }

    static Stream<Arguments> isSameBallTestDummy2() {
        return Stream.of(
                Arguments.arguments(1, 2, false),
                Arguments.arguments(3, 4, false),
                Arguments.arguments(6, 5, false),
                Arguments.arguments(9, 3, false)
        );
    }
}