package com.nr.actors;

import com.nr.states.SeriesPrinterState;

public class ZeroPrinter extends MultithreadedStatefulActor<SeriesPrinterState> {

    public ZeroPrinter(SeriesPrinterState state) {
        super(state);
    }

    @Override
    public boolean waitCondition() {
        return !state.isPrintZero();
    }

    @Override
    public boolean terminateCondition() {
        return state.getLastPrinted() >= state.getMaxValue();
    }

    @Override
    public void doAndUpdateState() {
        System.out.println(Thread.currentThread().getName() + ": " + 0);
        state.setPrintZero(false);
    }
}
