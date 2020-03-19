package com.krzychu.rockwell;

import static java.lang.Math.min;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AssemblyLine {

  private final int plcQuantity;
  private final int employeeQuantity;

  public AssemblyLine(final int plcQuantity, final int employeeQuantity) {
    this.plcQuantity = plcQuantity;
    this.employeeQuantity = employeeQuantity;
  }

  public List<Plc> start() {
    return IntStream.rangeClosed(1, plcQuantity)
        .mapToObj(this::createPlc)
        .collect(Collectors.toList());
  }

  private Plc createPlc(final int plcNumber) {
    final Plc plc = new Plc();
    performInitialisation(plc, plcNumber);
    return plc;
  }

  private void performInitialisation(final Plc plc, final int plcNumber) {
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
