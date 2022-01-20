package org.sonarsource.java;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Main17Test {

  @Test
  void testSwitchDefaultCase() throws Exception {
    Object p = new Object();
    assertThat(Main17.switchDefaultCase(p)).isSameAs(p);
    assertThat(Main17.switchDefaultCase(null)).isNull();
  }

}
