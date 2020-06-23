package com.krzychu.showcase;

import static java.lang.Math.min;

public class FirstAssemblyLine extends AssemblyLine {

  protected void performInitialisation(final Plc plc, final int plcNumber, final int employeeQuantity) {
    final int maxEmployeeNumberTogglingPlc = min(plcNumber / 2, employeeQuantity);
    for (int employeeNumber = 1; employeeNumber <= maxEmployeeNumberTogglingPlc; employeeNumber++) {
      if (plcNumber % employeeNumber == 0) {
        plc.toggleState();
      }
    }

    if (plcNumber <= employeeQuantity) {
      plc.toggleState();
    }
  }

}
