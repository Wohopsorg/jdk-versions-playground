package org.sonarsource.java;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class Main17Test {

  @Test
  void testSwitchDefaultCase() throws Exception {
    Object p = new Object();
    assertThat(Main17.switchDefaultCase(p)).isSameAs(p);
    assertThatThrownBy(() -> Main17.switchDefaultCase(null)).isInstanceOf(NullPointerException.class);
  }

}
