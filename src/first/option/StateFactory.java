package first.option;

import first.option.global.StateDefault;
import first.option.global.StateEnum;
import first.option.standard.StateActive;
import first.option.standard.StateSuspended;
import first.option.standard.StateUnconfirmed;
import first.option.wl.StateActiveWL;
import first.option.wl.StateLocked;

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
                StateDefault stateActive = new StateActiveWL();
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
