package first.option.standard;

import first.option.global.StateContext;
import first.option.global.StateDefault;
import first.option.global.StateEnum;

public class StateActive extends StateDefault {
    @Override
    public void suspend(StateContext context) {
        context.setState(states.get(StateEnum.SUSPENDED));
    }
}
