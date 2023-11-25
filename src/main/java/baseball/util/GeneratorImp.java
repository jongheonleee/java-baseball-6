package baseball.util;

import baseball.util.Generator;
import camp.nextstep.edu.missionutils.Randoms;

public class GeneratorImp implements Generator {

    @Override
    public Integer pickNumber(Integer startNumber, Integer endNumbers) {
        return Randoms.pickNumberInRange(startNumber, endNumbers);
    }
}
