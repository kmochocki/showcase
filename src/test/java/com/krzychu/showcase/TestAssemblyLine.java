package com.krzychu.showcase;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestAssemblyLine {

  private TestAssemblyLine() {
  }

  public static List<Plc> computeCorrectOutput(final Integer plcQuantity, final Integer employeeQuantity) {
    final List<Plc> plcs = Stream.generate(Plc::new)
        .limit(plcQuantity)
        .collect(Collectors.toList());

    performInitialisationProcedure(plcs, employeeQuantity);

    return plcs;
  }

  private static void performInitialisationProcedure(final List<Plc> plcs, final int employeeQuantity) {
    for (int employeeNumber = 1; employeeNumber <= employeeQuantity; employeeNumber++) {
      for (int plcNumber = 1; plcNumber <= plcs.size(); plcNumber++) {
        if (plcNumber % employeeNumber == 0) {
          plcs.get(plcNumber - 1)
              .toggleState();
        }
      }
    }
  }

}
