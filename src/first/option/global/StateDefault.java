package first.option.global;

import java.util.HashMap;
import java.util.Map;

public abstract class StateDefault {
    protected Map<StateEnum, StateDefault> states = new HashMap<>();

    public void confirm(StateContext context) {

    }

    public void suspend(StateContext context) {

    }

    public void lock(StateContext context) {

    }

    public void setStates(Map<StateEnum, StateDefault> states) {
        this.states = states;
    }
}
