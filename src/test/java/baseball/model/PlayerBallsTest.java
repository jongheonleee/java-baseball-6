package baseball.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PlayerBallsTest {

    @DisplayName("생성 실패 테스트 - 1~9 범위를 벗어난 값 입력")
    @MethodSource("createPlayerBallsExceptionTestDummy")
    @ParameterizedTest
    void createPlayerBallsExceptionTest(List<Integer> balls) {
        assertThrows(IllegalArgumentException.class,
                () -> new PlayerBalls(balls));
    }

    @DisplayName("생성 실패 테스트 - 중복된 값 존재")
    @MethodSource("createPlayerBallsExceptionTestDummy2")
    @ParameterizedTest
    void createPlayerBallsExceptionTest2(List<Integer> balls) {
        assertThrows(IllegalArgumentException.class,
                () -> new PlayerBalls(balls));
    }

    @DisplayName("생성 실패 테스트 - 숫자 3개보다 많거나 적은 개수 입력")
    @MethodSource("createPlayerBallsExceptionTestDummy3")
    @ParameterizedTest
    void createPlayerBallsExceptionTest3(List<Integer> balls) {
        assertThrows(IllegalArgumentException.class,
                () -> new PlayerBalls(balls));
    }

    @DisplayName("생성 성공 테스트")
    @MethodSource("createPlayerBallsSuccessTestDummy")
    @ParameterizedTest
    void createPlayerBallsSuccessTest(List<Integer> balls) {
        assertDoesNotThrow(() -> new PlayerBalls(balls));
    }

    @DisplayName("스트라이크 개수 카운트 기능 테스트")
    @MethodSource("countStrikeTestDummy")
    @ParameterizedTest
    void countStrikeTest(List<Integer> balls, List<Integer> computerBalls, Integer expected) {
        PlayerBalls playerBalls = new PlayerBalls(balls);
        Integer result = playerBalls.countStrike(computerBalls);
        assertEquals(expected, result);
    }


    @DisplayName("볼 개수 카운트 기능 테스트")
    @MethodSource("countBallTestDummy")
    @ParameterizedTest
    void countBallTest(List<Integer> balls, List<Integer> computerBalls, Integer expected) {
        PlayerBalls playerBalls = new PlayerBalls(balls);
        Integer result = playerBalls.countBall(computerBalls);
        assertEquals(expected, result);
    }


    static Stream<Arguments> createPlayerBallsExceptionTestDummy() {
        return Stream.of(
                Arguments.arguments(List.of(1, 100, 8)),
                Arguments.arguments(List.of(-1, 1, 8)),
                Arguments.arguments(List.of(0, 2, 8)),
                Arguments.arguments(List.of(33, 9, 3))
        );
    }

    static Stream<Arguments> createPlayerBallsExceptionTestDummy2() {
        return Stream.of(
                Arguments.arguments(List.of(1, 1, 8)),
                Arguments.arguments(List.of(1, 8, 8)),
                Arguments.arguments(List.of(2, 2, 8)),
                Arguments.arguments(List.of(3, 9, 3))
        );
    }

    static Stream<Arguments> createPlayerBallsExceptionTestDummy3() {
        return Stream.of(
                Arguments.arguments(List.of(1, 2, 8, 7)),
                Arguments.arguments(List.of(3, 1)),
                Arguments.arguments(List.of(9, 2, 8, 3, 4)),
                Arguments.arguments(List.of(7))
        );
    }

    static Stream<Arguments> createPlayerBallsSuccessTestDummy() {
        return Stream.of(
                Arguments.arguments(List.of(1, 2, 8)),
                Arguments.arguments(List.of(3, 1, 8)),
                Arguments.arguments(List.of(9, 2, 8)),
                Arguments.arguments(List.of(7, 9, 3))
        );
    }

    static Stream<Arguments> countStrikeTestDummy() {
        return Stream.of(
                Arguments.arguments(List.of(1, 2, 8), List.of(1, 2, 8), 3),
                Arguments.arguments(List.of(3, 1, 8), List.of(3, 1, 9), 2),
                Arguments.arguments(List.of(9, 2, 8), List.of(9, 1, 3), 1),
                Arguments.arguments(List.of(7, 9, 3), List.of(1, 2, 8), 0)
        );

    }


    static Stream<Arguments> countBallTestDummy() {
        return Stream.of(
                Arguments.arguments(List.of(1, 2, 8), List.of(2, 1, 8), 2),
                Arguments.arguments(List.of(3, 1, 8), List.of(9, 1, 3), 1),
                Arguments.arguments(List.of(9, 2, 8), List.of(2, 8, 9), 3),
                Arguments.arguments(List.of(7, 9, 3), List.of(1, 2, 8), 0)
        );
    }
}