package com.krzychu.rockwell.benchmark;

import com.krzychu.rockwell.AssemblyLine;
import com.krzychu.rockwell.FirstAssemblyLine;
import com.krzychu.rockwell.SecondAssemblyLine;
import com.krzychu.rockwell.TestAssemblyLine;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

@State(Scope.Benchmark)
public class ExecutionPlan {

    public int plcQuantity = 1100;
    public int employeeQuantity = 1100;
    public TestAssemblyLine testAssemblyLine;
    public FirstAssemblyLine firstAssemblyLine;
    public SecondAssemblyLine secondAssemblyLine;

    @Setup(Level.Invocation)
    public void setUp() {
        testAssemblyLine = new TestAssemblyLine();
        firstAssemblyLine = new FirstAssemblyLine();
        secondAssemblyLine = new SecondAssemblyLine();
    }
}