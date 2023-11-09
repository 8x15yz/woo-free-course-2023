package christmas.view;
import camp.nextstep.edu.missionutils.Console;
import christmas.view.Output;

public class Input {
    Output out = new Output();
    public String when() {
        out.when();
        return Console.readLine();
    }

    public String menu() {
        out.menu();
        return Console.readLine();
    }

}
