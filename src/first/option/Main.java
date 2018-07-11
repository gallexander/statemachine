package first.option;

import first.option.global.StateContext;
import first.option.global.StateDefault;
import first.option.global.StateEnum;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        StateContext sc = new StateContext();

        Map<StateEnum,StateDefault> states = StateFactory.createStates(ProductType.WIENER_LINIEN);

        sc.setState(states.get(StateEnum.UNCONFIRMED));
        sc.confirm();
        sc.lock();
    }
}
