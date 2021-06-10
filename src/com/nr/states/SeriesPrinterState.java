package com.nr.states;

public class SeriesPrinterState implements State {

    private boolean terminate = false;

    private boolean printZero = false;
    private int lastPrinted = 0;
    private final int maxValue;

    public SeriesPrinterState(int maxValue) {
        this.maxValue = maxValue;
    }

    @Override
    public boolean isTerminate() {
        return this.terminate;
    }

    @Override
    public void setTerminate(boolean terminate) {
        this.terminate = terminate;
    }

    public boolean isPrintZero() {
        return printZero;
    }

    public void setPrintZero(boolean printZero) {
        this.printZero = printZero;
    }

    public int getLastPrinted() {
        return lastPrinted;
    }

    public void incrementLastPrinted() {
        this.lastPrinted++;
    }

    public int getMaxValue() {
        return maxValue;
    }
}
