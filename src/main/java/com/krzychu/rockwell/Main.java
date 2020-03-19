package com.krzychu.rockwell;

import java.util.List;

public class Main {

  public static void main(String[] args) {
    int plcQuantity = 1100;
    int employeeQuantity = 1100;

    final List<Plc> startedLane = new AssemblyLine(plcQuantity, employeeQuantity).start();

    final long plcInRunMode = startedLane.stream()
        .map(Plc::getState)
        .filter(Plc.State.RUN::equals)
        .count();

    System.out.println("PLC in RUN mode: " + plcInRunMode);
  }

}
