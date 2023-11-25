package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneratorImp implements Generator {

    @Override
    public Integer pickNumber(Integer startNumber, Integer endNumbers) {
        return Randoms.pickNumberInRange(startNumber, endNumbers);
    }
}
