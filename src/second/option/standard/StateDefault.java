package second.option.standard;

import second.option.StateEnum;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public abstract class StateDefault {
    protected Map<StateEnum, StateDefault> states = new HashMap<>();

    public void confirm(Optional<? extends StateContext> context) {

    }

    public void suspend(Optional<? extends StateContext> context) {

    }

    public void setStates(Map<StateEnum, StateDefault> states) {
        this.states = states;
    }
}
