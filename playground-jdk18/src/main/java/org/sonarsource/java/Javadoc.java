package org.sonarsource.java;

/**
 * make sure to use goal "javadoc:javadoc" when building the project to test it
 */
public interface Javadoc {

  /**
   * The following code shows how to use {@code Optional.isPresent}:
   * [at]snippet file="Javadoc2.java" region="example"
   */
  // unable to make it work...
  void referenceToOtherFile();

  /**
   * A simple program.
   * {@snippet :
   * class HelloWorld {
   *     public static void main(String... args) {
   *         System.out.println("Hello World!");  // @replace regex='".*"' replacement="..."
   *     }
   * }
   * }
   */
  void replacementOfText();

  /**
   * A simple program.
   * {@snippet :
   * class HelloWorld {
   *     public static void main(String... args) {
   *         System.out.println("Hello World!");      // @highlight substring="println"
   *     }
   * }
   * }
   */
  void highlightingOnSubstring();

  /**
   * {@snippet :
   *   public static void main(String... args) {
   *       for (var arg : args) {                 // @highlight region regex = "\barg\b"
   *           if (!arg.isBlank()) {
   *               System.out.println(arg);
   *           }
   *       }                                      // @end
   *   }
   *   }
   */
  void highlightingOnRegex();

  /**
   * A simple program.
   * {@snippet :
   * class HelloWorld {
   *     public static void main(String... args) {
   *         System.out.println("Hello World!");  // @link substring="System.out" target="System#out"
   *     }
   * }
   * }
   */
  void linkingText();

}
