package second.option;

import second.option.standard.StateDefault;
import second.option.wl.StateContextWL;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        StateContextWL sc = new StateContextWL();

        Map<StateEnum,StateDefault> states = StateFactory.createStates(ProductType.WIENER_LINIEN);

        sc.setState(states.get(StateEnum.UNCONFIRMED));
        sc.confirm();
        sc.lock();
    }
}
