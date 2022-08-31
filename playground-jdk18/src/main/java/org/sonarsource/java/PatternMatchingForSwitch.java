package org.sonarsource.java;

import org.sonarsource.java.SealedClasses.Rectangle;
import org.sonarsource.java.SealedClasses.Shape;
import org.sonarsource.java.SealedClasses.Square;
import org.sonarsource.java.SealedClasses.Triangle;

/**
 * JEP-406 (1st preview) Pattern Matching for switch
 */
public interface PatternMatchingForSwitch {

  static Object switchDefaultCase(Object o) {
    return switch (o) {
      case default -> o;
    };
  }

  static int switchArrayNullPattern(Object o) {
    return switch (o) {
      case Object[] arr -> arr.length;
      // default case voluntarily not in last position
      default -> -1;
      case null -> 42;
    };
  }

  static int switchArrayDefaultNullPattern(Object o) {
    return switch (o) {
      case Object[] arr -> arr.length;
      case default, null -> 42;
    };
  }

  static String switchSealedClassMinimum(Shape shape) {
    return switch (shape) {
      case Triangle t -> t.toString();
      case Rectangle r -> "Rectangle " + r;
    };
  }

  static String switchSealedClassNullDefaultSubClasses(Shape shape) {
    return switch (shape) {
      case null -> "null case";
      case Triangle t -> String.format("Triangle (%d,%d,%d)", t.a(), t.b(), t.c());
      case Rectangle r && r.volume() > 42 -> String.format("Big rectangle of volume %d!", r.volume());
      case Square s -> String.format("Square %s!", s);
      case Rectangle r -> String.format("Rectangle (%d,%d)", r.base, r.height);
      default -> "unreachable default case...";
    };
  }
}
