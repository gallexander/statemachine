package second.option;

import second.option.standard.StateActive;
import second.option.standard.StateDefault;
import second.option.standard.StateSuspended;
import second.option.standard.StateUnconfirmed;
import second.option.wl.StateActiveWL;
import second.option.wl.StateLocked;

import java.util.HashMap;
import java.util.Map;

public class StateFactory {

    private static final Map<StateEnum, StateDefault> states = new HashMap<>();
    private static final Map<StateEnum, StateDefault> statesWL = new HashMap<>();

    private StateFactory(){
    }

    public static Map<StateEnum, StateDefault> createStates(ProductType productType) {
        if (productType.equals(ProductType.WIENER_LINIEN)) {
            if (statesWL.isEmpty()) {
                StateActive stateActive_sub = new StateActive();
                StateDefault stateActive = new StateActiveWL(stateActive_sub);
                StateDefault stateSuspended = new StateSuspended();
                StateDefault stateUnconfirmed = new StateUnconfirmed();
                StateDefault stateLocked = new StateLocked();
                statesWL.put(StateEnum.ACTIVE, stateActive);
                statesWL.put(StateEnum.SUSPENDED,stateSuspended);
                statesWL.put(StateEnum.UNCONFIRMED, stateUnconfirmed);
                statesWL.put(StateEnum.LOCKED, stateLocked);
                stateActive.setStates(statesWL);
                stateSuspended.setStates(statesWL);
                stateUnconfirmed.setStates(statesWL);
                stateLocked.setStates(states);
            }
            return statesWL;
        } else {
            if (states.isEmpty()) {
                StateDefault stateActive = new StateActive();
                StateDefault stateSuspended = new StateSuspended();
                StateDefault stateUnconfirmed = new StateUnconfirmed();
                states.put(StateEnum.ACTIVE, stateActive);
                states.put(StateEnum.SUSPENDED,stateSuspended);
                states.put(StateEnum.UNCONFIRMED, stateUnconfirmed);
                stateActive.setStates(states);
                stateSuspended.setStates(states);
                stateUnconfirmed.setStates(states);

            }
            return states;
        }
    }
}
