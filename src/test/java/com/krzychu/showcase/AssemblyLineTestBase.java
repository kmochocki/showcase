package com.krzychu.showcase;

import static com.krzychu.showcase.TestAssemblyLine.computeCorrectOutput;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

abstract class AssemblyLineTestBase {

  @ParameterizedTest
  @ValueSource(ints = { 0, 1, 2, 1099, 1100, 1101 })
  void shouldPassWhenPlcQuantityIsEqualToEmployeeQuantity(final int plcAndEmployeeQuantity) {
    performAssertion(plcAndEmployeeQuantity, plcAndEmployeeQuantity);
  }

  @ParameterizedTest
  @MethodSource("firstIntLowerThanSecondIntProvider")
  void shouldPassWhenPlcQuantityIsLowerThanEmployeeQuantity(final int plcQuantity, final int employeeQuantity) {
    performAssertion(employeeQuantity, plcQuantity);
  }

  @ParameterizedTest
  @MethodSource("firstIntLowerThanSecondIntProvider")
  void shouldPassWhenPlcQuantityIsGreaterThanEmployeeQuantity(final int employeeQuantity, final int plcQuantity) {
    performAssertion(employeeQuantity, plcQuantity);
  }

  private void performAssertion(final int employeeQuantity, final int plcQuantity) {
    final List<Plc> result = getAssemblyLine().apply(plcQuantity, employeeQuantity);
    final List<Plc> expected = computeCorrectOutput(plcQuantity, employeeQuantity);

    assertThat(result).isEqualTo(expected);
  }

  static Stream<Arguments> firstIntLowerThanSecondIntProvider() {
    return Stream.of(
        arguments(0, 1),
        arguments(1, 2),
        arguments(1, 1100),
        arguments(2, 10),
        arguments(2, 1100),
        arguments(1099, 1100),
        arguments(1100, 1101)
    );
  }

  @Test
  void shouldBe1100RunningPlcs() {
    final long plcInRunMode = getAssemblyLine().apply(1100, 1)
        .stream()
        .map(Plc::getState)
        .filter(Plc.State.RUN::equals)
        .count();

    assertThat(plcInRunMode).isEqualTo(1100);
  }

  @Test
  void shouldBe550RunningPlcs() {

    final long plcInRunMode = getAssemblyLine().apply(1100, 2)
        .stream()
        .map(Plc::getState)
        .filter(Plc.State.RUN::equals)
        .count();

    assertThat(plcInRunMode).isEqualTo(550);
  }

  @Test
  void shouldBe33RunningPlcs() {

    final long plcInRunMode = getAssemblyLine().apply(1100, 1100)
        .stream()
        .map(Plc::getState)
        .filter(Plc.State.RUN::equals)
        .count();

    assertThat(plcInRunMode).isEqualTo(33);
  }

  protected abstract AssemblyLine getAssemblyLine();

}