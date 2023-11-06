package lotto;
import camp.nextstep.edu.missionutils.Console;
import lotto.model.Draw;
import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InputSystem {
    private final String ENTER_PRICE = "구입금액을 입력해 주세요.";
    private final String ENTER_LOTTO = "당첨 번호를 입력해 주세요.";
    private final String ENTER_BONUS = "보너스 번호를 입력해 주세요.";
    private static final String IS_ONLY_NUMBER = "[0-9]+"; // 숫자로만 되어있으면 true 반환
    private static final String ERROR_MESSAGE = "[ERROR]";


    public int purchase() {
        return isPriceValid(enter(ENTER_PRICE));
    }
    private String enter(String announcement) {
        System.out.println(announcement);
        return Console.readLine();
    }
    private int isPriceValid(String price) {
        if (isInteger(price) && isKUnit(price))
            return Integer.parseInt(price) / 1000;
        throw new IllegalStateException();
    }
    private boolean isInteger(String number) {
        return number.matches(IS_ONLY_NUMBER);
    }
    private boolean isKUnit(String price) {
        if (Integer.parseInt(price) % 1000 == 0)
            return true;
        return false;
    }

    public void getNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (String a : enter(ENTER_LOTTO).split(",")) {
            numbers.add(isNumberValid(a));
        }
        Lotto l = new Lotto(numbers);
    }


    private int isNumberValid(String number) {
        if (isInteger(number) && isRangeValid(number))
            return Integer.parseInt(number);
        throw new IllegalStateException();
    }

    private boolean isRangeValid(String number) {
        int parsed = Integer.parseInt(number);
        if (parsed >= 1 && parsed < 46)
            return true;
        throw new IllegalStateException();
    }
}
