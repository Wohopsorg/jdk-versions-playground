package org.sonarsource.java;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SealedClassesTest {

  @Test
  void rectangle() {
    SealedClasses.Rectangle rectangle = new SealedClasses.Rectangle(42, 7);
    assertThat(rectangle).hasToString("rect(42x7)");
  }

}
