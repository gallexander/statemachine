package second.option.standard;

import second.option.StateEnum;

import java.util.Optional;

public class StateUnconfirmed extends StateDefault {
    @Override
    public void confirm(Optional<? extends StateContext> context) {
        if (context.isPresent()) {
            context.get().setState(states.get(StateEnum.ACTIVE));
        }
    }
}
