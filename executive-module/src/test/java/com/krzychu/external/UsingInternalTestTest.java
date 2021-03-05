package com.krzychu.external;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.krzychu.internal.TestingClass;
import org.junit.jupiter.api.Test;

class UsingInternalTestTest {

  @Test
  void main() {
    new TestingClass().test();
  }

  @Test
  void name() {
    List<String> strings = IntStream.range(0, 10).mapToObj(Integer::toString).collect(Collectors.toList());
//    strings.add(3, "3");
    strings.set(3, "3");
    System.out.println(strings);
  }
}
