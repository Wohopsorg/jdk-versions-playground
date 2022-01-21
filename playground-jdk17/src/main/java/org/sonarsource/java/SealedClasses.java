package org.sonarsource.java;

/**
 * JEP-409 (final) sealed classes
 */
public interface SealedClasses {

  public sealed interface Shape permits Rectangle, Triangle {
    default int volume() {
      return 0;
    }
  }

  public static non-sealed class Rectangle implements Shape {
    protected int base;
    protected int height;

    Rectangle(int base, int height) {
      this.base = base;
      this.height = height;
    }

    @Override
    public String toString() {
      return String.format("rect(%dx%d)", base, height);
    }

    @Override
    public int volume() {
      return base * height;
    }
  }

  public static final class Square extends Rectangle {
    Square(int side) {
      super(side, side);
    }
  }

  public static record Triangle(int a, int b, int c) implements Shape {
  }
}
