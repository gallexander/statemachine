package second.option.wl;

import second.option.StateEnum;
import second.option.standard.StateActive;
import second.option.standard.StateContext;

import java.util.Optional;

public class StateActiveWL extends StateWL {
    private StateActive stateActive;

    public StateActiveWL() {
    }

    public StateActiveWL(StateActive stateActive) {
        this.stateActive = stateActive;
    }

    @Override
    public void lock(Optional<StateContextWL> context) {
        if (context.isPresent()) {
            context.get().setState(states.get(StateEnum.LOCKED));
        }
    }

    @Override
    public void confirm(Optional<? extends StateContext> context) {
        stateActive.confirm(context);
    }

    @Override
    public void suspend(Optional<? extends StateContext> context) {
        stateActive.suspend(context);
        if (context.isPresent()) {
            context.get().setState(states.get(StateEnum.SUSPENDED));
        }
    }

}
