package org.sonarsource.java;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PatternMatchingForSwitchTest {

  @Test
  void testSwitchDefaultCase() {
    Object p = new Object();
    assertThat(PatternMatchingForSwitch.switchDefaultCase(p)).isSameAs(p);
    assertThatThrownBy(() -> PatternMatchingForSwitch.switchDefaultCase(null)).isInstanceOf(NullPointerException.class);
  }

}
