package com.krzychu.rockwell.benchmark;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

public class TestAssemblyLinePerformanceTest {

    private static final int FORKS = 3;
    private static final int WARMUPS = 3;

    @Benchmark
    @Fork(value = FORKS, warmups = WARMUPS)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void testAssemblyLineTest(ExecutionPlan executionPlan, Blackhole blackhole) {
        blackhole.consume(executionPlan.testAssemblyLine.computeCorrectOutput(executionPlan.plcQuantity, executionPlan.employeeQuantity));
    }

    @Benchmark
    @Fork(value = FORKS, warmups = WARMUPS)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void firstAssemblyLineTest(ExecutionPlan executionPlan, Blackhole blackhole) {
        blackhole.consume(executionPlan.firstAssemblyLine.apply(executionPlan.plcQuantity, executionPlan.employeeQuantity));
    }

    @Benchmark
    @Fork(value = FORKS, warmups = WARMUPS)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void secondAssemblyLineTest(ExecutionPlan executionPlan, Blackhole blackhole) {
        blackhole.consume(executionPlan.secondAssemblyLine.apply(executionPlan.plcQuantity, executionPlan.employeeQuantity));
    }
}
