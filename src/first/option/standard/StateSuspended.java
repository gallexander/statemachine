package first.option.standard;

import first.option.global.StateContext;
import first.option.global.StateDefault;
import first.option.global.StateEnum;

public class StateSuspended extends StateDefault {
    @Override
    public void confirm(StateContext context) {
        context.setState(states.get(StateEnum.ACTIVE));
    }
}
