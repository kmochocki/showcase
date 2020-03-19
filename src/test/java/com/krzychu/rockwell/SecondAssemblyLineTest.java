package com.krzychu.rockwell;

class SecondAssemblyLineTest extends AssemblyLineTestBase {

  private final AssemblyLine assemblyLine = new SecondAssemblyLine();

  @Override
  protected AssemblyLine getAssemblyLine() {
    return assemblyLine;
  }

}