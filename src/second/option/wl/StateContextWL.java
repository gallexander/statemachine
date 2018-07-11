package second.option.wl;

import second.option.standard.StateContext;

import java.util.Optional;

public class StateContextWL extends StateContext {

    public void lock() {
        if (this.state instanceof StateWL) {
            StateWL stateWL = (StateWL) state;
            stateWL.lock(Optional.of(this));
        }
    }
}
