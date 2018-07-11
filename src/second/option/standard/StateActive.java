package second.option.standard;

import java.util.Optional;

public class StateActive extends StateDefault {
    @Override
    public void suspend(Optional<? extends StateContext> context) {
        super.suspend(context);
    }
}
