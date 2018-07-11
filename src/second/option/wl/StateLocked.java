package second.option.wl;


import second.option.StateEnum;
import second.option.standard.StateContext;

import java.util.Optional;

public class StateLocked extends StateWL {
    @Override
    public void suspend(Optional<? extends StateContext> context) {
        if (context.isPresent()) {
            context.get().setState(states.get(StateEnum.SUSPENDED));
        }
    }
}
