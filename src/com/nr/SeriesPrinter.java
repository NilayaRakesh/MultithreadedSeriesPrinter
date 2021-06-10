package com.nr;

import com.nr.states.SeriesPrinterState;
import com.nr.actors.EvenPrinter;
import com.nr.actors.OddPrinter;
import com.nr.actors.ZeroPrinter;


/**
 * PROBLEM: Print the series 1 0 2 0 3 0 4 0 5 ... using 3 threads.
 * The 1st thread should print zeros,
 * the 2nd thread should print the even numbers,
 * and the 3rd thread should print the odd numbers.
 * Program should terminate after reaching a maximum value.
 */
public class SeriesPrinter {

    public static void main(String[] args) {
        SeriesPrinterState state = new SeriesPrinterState(10);
        ZeroPrinter zeroPrinter = new ZeroPrinter(state);
        EvenPrinter evenPrinter = new EvenPrinter(state);
        OddPrinter oddPrinter = new OddPrinter(state);

        new Thread(zeroPrinter, "ZERO-THREAD").start();
        new Thread(evenPrinter, "EVEN-THREAD").start();
        new Thread(oddPrinter, "ODD-THREAD").start();
    }
}
