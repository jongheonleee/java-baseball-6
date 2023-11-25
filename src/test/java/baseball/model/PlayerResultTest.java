package baseball.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PlayerResultTest {

    @DisplayName("결과 생성 테스트")
    @MethodSource("createResultTestDummy")
    @ParameterizedTest
    void createResultTest(Integer strike, Integer ball, PlayerResult expected) {
        PlayerResult result = PlayerResult.of(strike, ball);
        assertEquals(expected, result);
    }


    static Stream<Arguments> createResultTestDummy() {
        return Stream.of(
                Arguments.arguments(1, 2, PlayerResult.ONE_STRIKE_TWO_BALL),
                Arguments.arguments(0, 2, PlayerResult.TWO_BALL),
                Arguments.arguments(0, 3, PlayerResult.THREE_BALL),
                Arguments.arguments(3, 0, PlayerResult.THREE_STRIKE),
                Arguments.arguments(0, 0, PlayerResult.NOTHING)
        );
    }
}