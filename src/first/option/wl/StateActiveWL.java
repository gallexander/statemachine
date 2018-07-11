package first.option.wl;

import first.option.global.StateContext;
import first.option.global.StateEnum;
import first.option.standard.StateActive;

public class StateActiveWL extends StateActive {

    @Override
    public void suspend(StateContext context) {
        super.suspend(context);
        //DO SOMETHING MORE
    }

    @Override
    public void lock(StateContext context) {
        context.setState(states.get(StateEnum.LOCKED));
    }
}
