package org.sonarsource.java;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.sonarsource.java.PatternMatchingForSwitch.switchArrayDefaultNullPattern;
import static org.sonarsource.java.PatternMatchingForSwitch.switchArrayNullPattern;
import static org.sonarsource.java.PatternMatchingForSwitch.switchDefaultCase;
import static org.sonarsource.java.PatternMatchingForSwitch.switchSealedClassMinimum;
import static org.sonarsource.java.PatternMatchingForSwitch.switchSealedClassNullDefaultSubClasses;

class PatternMatchingForSwitchTest {

  @Test
  void testSwitchDefaultCase() {
    Object p = new Object();
    assertThat(switchDefaultCase(p)).isSameAs(p);
    assertThatThrownBy(() -> switchDefaultCase(null)).isInstanceOf(NullPointerException.class);
  }

  @Test
  void testSwitchArrayNullPattern() {
    assertThat(switchArrayNullPattern(null)).isEqualTo(42);
    assertThat(switchArrayNullPattern(new Object())).isEqualTo(-1);
    assertThat(switchArrayNullPattern(new Object[7])).isEqualTo(7);
  }

  @Test
  void testSwitchArrayDefaultNullPattern() {
    assertThat(switchArrayDefaultNullPattern(null))
      .isEqualTo(switchArrayDefaultNullPattern(new Object()))
      .isEqualTo(42);
    assertThat(switchArrayDefaultNullPattern(new Object[7])).isEqualTo(7);
  }

  @Test
  void testSwitchSealedClassMinimum() {
    assertThatThrownBy(() -> switchSealedClassMinimum(null)).isInstanceOf(NullPointerException.class);
    assertThat(switchSealedClassMinimum(new SealedClasses.Triangle(2, 3, 4))).isEqualTo("Triangle[a=2, b=3, c=4]");
    assertThat(switchSealedClassMinimum(new SealedClasses.Rectangle(7, 42))).isEqualTo("Rectangle rect(7x42)");
  }

  @Test
  void testSwitchSealedClassNullDefaultSubClasses() {
    assertThat(switchSealedClassNullDefaultSubClasses(null)).isEqualTo("null case");
    assertThat(switchSealedClassNullDefaultSubClasses(new SealedClasses.Triangle(2, 3, 4))).isEqualTo("Triangle (2,3,4)");
    assertThat(switchSealedClassNullDefaultSubClasses(new SealedClasses.Rectangle(3, 6))).isEqualTo("Rectangle (3,6)");
    assertThat(switchSealedClassNullDefaultSubClasses(new SealedClasses.Rectangle(39, 42))).isEqualTo("Big rectangle of volume 1638!");
    assertThat(switchSealedClassNullDefaultSubClasses(new SealedClasses.Square(4))).isEqualTo("Square rect(4x4)!");
  }

}
