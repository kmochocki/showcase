package com.krzychu.external;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDebug {

  public static void main(String[] args) {

    int[] listOutputSorted = IntStream.of(-3, 10, -4, 1, 3)
        .sorted()
        .toArray();


    List<Optional<Customer>> customers = Arrays.asList(
        Optional.of(new Customer("John P.", 15)),
        Optional.of(new Customer("Sarah M.", 78)),
        Optional.empty(),
        Optional.of(new Customer("Mary T.", 20)),
        Optional.empty(),
        Optional.of(new Customer("Florian G.", 89)),
        Optional.empty()
    );

    long numberOf65PlusCustomers = customers
        .stream()
        .flatMap(c -> c
            .map(Stream::of)
            .orElseGet(Stream::empty))
        .mapToInt(Customer::getAge)
        .filter(c -> c > 65)
        .count();
  }

}
