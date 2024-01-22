package org.sonarsource.java;

/**
 * JEP-395 (final) Records
 */
public interface Records {

  static record Point(int x, int y) {
    public String text() {
      return String.format("Point@<%d;%d>", x() , y());
    }
  }

}
