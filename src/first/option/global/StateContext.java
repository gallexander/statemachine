package first.option.global;

public class StateContext {
    private StateDefault state;

    public void setState(StateDefault state) {
        this.state = state;
    }

    public void confirm() {
        state.confirm(this);
    }

    public void suspend() {
        state.suspend(this);
    }

    public void lock() {
        state.lock(this);
    }
}
