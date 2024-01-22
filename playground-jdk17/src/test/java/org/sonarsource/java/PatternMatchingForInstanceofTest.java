package org.sonarsource.java;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PatternMatchingForInstanceofTest {

  @Test
  void testPatternInstanceof() throws Exception {
    assertThat(PatternMatchingForInstanceof.foo(new Object())).isEmpty();
    assertThat(PatternMatchingForInstanceof.foo(new Records.Point(42, -1))).isEqualTo("Point@<42;-1>");
  }

}
