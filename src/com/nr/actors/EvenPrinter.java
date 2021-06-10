package com.nr.actors;

import com.nr.states.SeriesPrinterState;
import com.nr.utils.NumberUtils;

public class EvenPrinter extends MultithreadedStatefulActor<SeriesPrinterState> {

    public EvenPrinter(SeriesPrinterState state) {
        super(state);
    }

    @Override
    public boolean waitCondition() {
        return !NumberUtils.isOdd(state.getLastPrinted()) || state.isPrintZero();
    }

    @Override
    public boolean terminateCondition() {
        return state.getLastPrinted() >= state.getMaxValue();
    }

    @Override
    public void doAndUpdateState() {
        state.incrementLastPrinted();
        System.out.println(Thread.currentThread().getName() + ": " + state.getLastPrinted());
        state.setPrintZero(true);
    }
}
