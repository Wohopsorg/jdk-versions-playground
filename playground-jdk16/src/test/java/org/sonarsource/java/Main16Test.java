package org.sonarsource.java;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Main16Test {

  @Test
  void testPatternInstanceof() throws Exception {
    assertThat(Main16.foo(new Object())).isEmpty();
    assertThat(Main16.foo(new Main16.Point(42, -1))).isEqualTo("Point@<42;-1>");
  }

}
