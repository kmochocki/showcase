package com.krzychu.rockwell;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class AssemblyLineTest {

  @ParameterizedTest
  @ValueSource(ints = { 0, 1, 2, 1099, 1100, 1101 })
  void shouldPassWhenPlcQuantityIsEqualToEmployeeQuantity(final int plcAndEmployeeQuantity) {
    final AssemblyLine assemblyLine = new AssemblyLine(plcAndEmployeeQuantity, plcAndEmployeeQuantity);

    assertThat(assemblyLine.start()).isEqualTo(computeCorrectOutput(plcAndEmployeeQuantity, plcAndEmployeeQuantity));
  }

  @ParameterizedTest
  @MethodSource("firstIntLowerThanSecondIntProvider")
  void shouldPassWhenPlcQuantityIsLowerThanEmployeeQuantity(final int plcQuantity, final int employeeQuantity) {
    final AssemblyLine assemblyLine = new AssemblyLine(plcQuantity, employeeQuantity);

    assertThat(assemblyLine.start()).isEqualTo(computeCorrectOutput(plcQuantity, employeeQuantity));
  }

  @ParameterizedTest
  @MethodSource("firstIntLowerThanSecondIntProvider")
  void shouldPassWhenPlcQuantityIsGreaterThanEmployeeQuantity(final int employeeQuantity, final int plcQuantity) {
    final AssemblyLine assemblyLine = new AssemblyLine(plcQuantity, employeeQuantity);

    assertThat(assemblyLine.start()).isEqualTo(computeCorrectOutput(plcQuantity, employeeQuantity));
  }

  static Stream<Arguments> firstIntLowerThanSecondIntProvider() {
    return Stream.of(
        arguments(0, 1),
        arguments(1, 2),
        arguments(1, 1100),
        arguments(1099, 1100),
        arguments(1100, 1101)
    );
  }

  private List<Plc> computeCorrectOutput(final int plcQuantity, final int employeeQuantity) {
    final List<Plc> plcs = Stream.generate(Plc::new)
        .limit(plcQuantity)
        .collect(Collectors.toList());

    performInitialisationProcedure(plcs, employeeQuantity);

    return plcs;
  }

  private void performInitialisationProcedure(final List<Plc> plcs, final int employeeQuantity) {
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