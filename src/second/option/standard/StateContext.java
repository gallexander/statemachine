package second.option.standard;

import java.util.Optional;

public class StateContext {
    protected StateDefault state;

    public void setState(StateDefault state) {
        this.state = state;
    }

    public void confirm() {
        state.confirm(Optional.ofNullable(this));
    }

    public void suspend() {
        state.suspend(Optional.ofNullable(this));
    }
}
