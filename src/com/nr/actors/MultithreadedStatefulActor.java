package com.nr.actors;

import com.nr.states.State;

public abstract class MultithreadedStatefulActor<S extends State> implements Runnable {

    protected final S state;

    public MultithreadedStatefulActor(S state) {
        this.state = state;
    }

    public abstract boolean waitCondition();

    public abstract boolean terminateCondition();

    public abstract void doAndUpdateState();

    private void act() throws InterruptedException {
        while (waitCondition() && !terminateCondition()) {
            state.wait();
        }

        if (terminateCondition()) {
            state.setTerminate(true);

        } else {
            doAndUpdateState();

        }

        state.notifyAll();
    }

    @Override
    public void run() {
        synchronized (state) {
            while (!state.isTerminate()) {
                try {
                    act();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
