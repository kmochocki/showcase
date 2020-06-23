package com.krzychu.showcase;

import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class AssemblyLine implements BiFunction<Integer, Integer, List<Plc>> {

  @Override
  public List<Plc> apply(final Integer plcQuantity, final Integer employeeQuantity) {
    return IntStream.rangeClosed(1, plcQuantity)
        .mapToObj(plcNumber -> createPlc(plcNumber, employeeQuantity))
        .collect(Collectors.toList());
  }

  private Plc createPlc(final int plcNumber, final int employeeQuantity) {
    final Plc plc = new Plc();
    performInitialisation(plc, plcNumber, employeeQuantity);
    return plc;
  }

  protected abstract void performInitialisation(final Plc plc, final int plcNumber, final int employeeQuantity);

}
