package org.sonarsource.java;

import org.sonarsource.java.Records.Point;

/**
 * JEP-394 (final) Pattern Matching for instanceof
 */
public interface PatternMatchingForInstanceof {

  static String foo(Object o) {
    if (o instanceof Point p) {
      return p.text();
    }
    return "";
  }

}
