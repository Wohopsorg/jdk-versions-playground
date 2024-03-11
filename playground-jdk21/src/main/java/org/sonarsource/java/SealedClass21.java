package org.sonarsource.java;

public interface SealedClass21 {

  sealed interface Animal permits Cat, Dog, Phoenix {}
  record Cat() implements Animal { }
  record Dog() implements Animal { }
  record Phoenix() implements Animal { }

  sealed interface Shape permits Box, Circle {}
  record Box() implements Shape { }
  record Circle() implements Shape {}

  static int getLives(Animal animal) {
    return switch (animal) {
      case Cat ignored -> 7;
      case Dog ignored -> 1;
      case Phoenix ignored -> Integer.MAX_VALUE;
    };
  }

  static void doSomething(Animal animal, Shape shape) {

    // 3 types
    switch (animal) {
      case Cat ignored -> { }
      case Dog ignored -> System.out.println();
      case Phoenix ignored -> throw new IllegalStateException();
    }

    // 2 types
    switch (shape) {
      case Box ignored -> { }
      case Circle ignored -> System.out.println();
    }
  }
}
