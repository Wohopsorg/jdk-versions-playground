package org.sonarsource.java;

public class Main16 {

  /**
   * JEP-394 (final) Pattern Matching for instanceof 
   */
  static String foo(Object o) {
    if (o instanceof Point p) {
      return p.text();
    }
    return "";
  }

  /**
   * JEP-395 (final) Records
   */
  public static record Point(int x, int y) {
    public String text() {
      return String.format("Point@<%d;%d>", x() , y());
    }
  }

}
