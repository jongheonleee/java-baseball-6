package baseball.model;

import static org.junit.jupiter.api.Assertions.*;

import baseball.util.GeneratorImp;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class GeneratorBallsTest {

    GeneratorImp generator = new GeneratorImp();
    GeneratorBalls generatorBalls = new GeneratorBalls(generator);

    @DisplayName("1~9까지 중복을 허용하지 않고 서로 다른 임의의 수 생성 기능 테스트")
    @RepeatedTest(5)
    void generateBallsTest() {
        List<Integer> balls = generatorBalls.generateUniqueNumbers();
        Set<Integer> ballsSet = balls.stream().collect(Collectors.toSet());
        Boolean result = balls.size() == ballsSet.size();
        assertEquals(true, result);
    }

}