package com.krzychu.showcase;

import static java.lang.Math.min;

public class SecondAssemblyLine extends AssemblyLine {

  protected void performInitialisation(final Plc plc, final int plcNumber, final int employeeQuantity) {
    final int limit = min((int) Math.sqrt(plcNumber), employeeQuantity);
    for (int j = 1; j <= limit; j++) {
      if (plcNumber % j == 0) {
        if (plcNumber / j == j) {
          plc.toggleState();
        }
        if (plcNumber / j > employeeQuantity) {
          plc.toggleState();
        }
      }
    }
  }

}
