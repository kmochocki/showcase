package com.krzychu.rockwell;

import java.util.Objects;

public class Plc {

  private State state;

  public Plc() {
  }

  public Plc(final State state) {
    this.state = state;
  }

  public void toggleState() {
    if (this.state == null) {
      this.state = State.RUN;
    } else if (this.state.equals(State.RUN)) {
      this.state = State.PROGRAM;
    } else {
      this.state = State.RUN;
    }
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final Plc plc = (Plc) o;
    return getState() == plc.getState();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getState());
  }

  @Override
  public String toString() {
    return "Plc{" +
        "state=" + state +
        '}';
  }

  public State getState() {
    return state;
  }

  public enum State {
    RUN,
    PROGRAM
  }

}
