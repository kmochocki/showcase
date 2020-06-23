package com.krzychu.showcase;

class FirstAssemblyLineTest extends AssemblyLineTestBase {

  private final AssemblyLine assemblyLine = new FirstAssemblyLine();

  @Override
  protected AssemblyLine getAssemblyLine() {
    return assemblyLine;
  }

}