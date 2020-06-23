package com.krzychu.showcase;

class SecondAssemblyLineTest extends AssemblyLineTestBase {

  private final AssemblyLine assemblyLine = new SecondAssemblyLine();

  @Override
  protected AssemblyLine getAssemblyLine() {
    return assemblyLine;
  }

}