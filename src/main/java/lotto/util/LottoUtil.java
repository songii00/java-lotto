package lotto.util;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

public class LottoUtil {

    private static final int MAX_NUM = 45;
    private static final int LOTTO_DIGITS = 6;

    private static final Logger log = getLogger(LottoUtil.class);

    public static List<Integer> lottoNumber() {
        List<Integer> lotto = new ArrayList<>();
        for (int i = 1; i <= MAX_NUM; i++) {
            lotto.add(i);
        }
        return lotto;
    }

    private static List<Integer> lottoRandom() {
        List<Integer> input = lottoNumber();
        Collections.shuffle(input);
        return input;
    }

    private static List<Integer> oneLottoPage() {
        List<Integer> randomNum = lottoRandom();
        List<Integer> lotto = new ArrayList<>();
        for (int i = 0; i < LOTTO_DIGITS; i++) {
            lotto.add(randomNum.get(i));
        }
        Collections.sort(lotto);
        return lotto;
    }

    public static List<Lotto> lottoObject(int page) {
        List<Lotto> lotto = new ArrayList<>();
        for (int i = 0; i < page; i++) {
            lotto.add(new Lotto(oneLottoPage()));
        }
        return lotto;
    }

    public static List<Rank> ranks() {
        List<Rank> ranks = new ArrayList<>();
        for (int i = 3; i <= LOTTO_DIGITS; i++) {
            ranks.add(Rank.valueOf(i));
        }
        return ranks;
    }
}