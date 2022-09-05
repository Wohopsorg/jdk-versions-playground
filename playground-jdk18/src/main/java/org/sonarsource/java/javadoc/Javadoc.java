package org.sonarsource.java.javadoc;

/**
 * make sure to use goal "javadoc:javadoc" when building the project to test it
 */
public interface Javadoc {

  /**
   * Reference to a file "Other.ile" placed in snippet-files folder.
   * {@snippet file="Other.file" region="otherStuff" }
   */
  // unable to make it work...
  void referenceToRegionInOtherFile();

  /**
   * Reference to a class "Snippets" placed in snippet-files folder.
   * {@snippet class="Snippets" region="example" }
   */
  void referencetoRegionInClass();

  /**
   * Replacement in snippet.
   * {@snippet :
   *   class HelloWorld {
   *     public static void main(String... args) {
   *       System.out.println("Hello World!");  // @replace regex='".*"' replacement="..."
   *     }
   *   }
   * }
   */
  void replacementOfTextWithRegex();

  /**
   * Highlighting based on a substring on a single line.
   * {@snippet :
   *   class HelloWorld {
   *     public static void main(String... args) {
   *       ...
   *     }
   *   } // not aligned with closing bracket of snippet // @highlight regex="//.+"  type=highlighted
   * }
   */
  void wrongIndentation();

  /**
   * Highlighting based on a substring on a single line.
   * {@snippet :
   *   class HelloWorld {
   *     public static void main(String... args) {
   *       ...
   *     }
   *   } // aligned with closing bracket of snippet // @highlight regex="//.+"  type=highlighted
   *   }
   */
  void correctIndentation();

  /**
   * Highlighting based on a substring on a single line.
   * {@snippet :
   *   class HelloWorld {
   *     public static void main(String... args) {
   *       System.out.println("Hello World!");      // @highlight substring="println"
   *     }
   *   }
   * }
   */
  void highlightingOnSubstring();

  /**
   * Highlighting based on a substring in a region.
   * {@snippet :
   *   public static void main(String... args) {
   *     for (var arg : args) {                 // @highlight region substring = "println"
   *       System.out.println("Hello World!");
   *       System.out.println("Hello World!");
   *       System.out.println("Hello World!");
   *     }                                      // @end
   *   }
   * }
   */
  void highlightingOnSubstringWithRegion();

  /**
   * Highlighting based on a regex on a single line.
   * {@snippet :
   *   public static void main(String... args) {
   *     for (var arg : args) {                 // @highlight regex = "\barg\b"
   *       if (!arg.isBlank()) {
   *         System.out.println(arg);
   *       }
   *     }
   *   }
   * }
   */
  void highlightingWithRegex();

  /**
   * Highlighting based on a regex in a region.
   * {@snippet :
   *   public static void main(String... args) {// @highlight region regex = "\barg\b" type=highlighted
   *     for (var arg : args) {
   *       if (!arg.isBlank()) {
   *         System.out.println(arg);
   *       }
   *     }                                      // @end
   *   }
   * }
   */
  void highlightingOnRegexWithRegion();

  /**
   * Link in text with substring.
   * {@snippet :
   *   class HelloWorld {
   *     public static void main(String... args) {
   *       System.out.println("Hello World!");  // @link substring="System.out" target="System#out"
   *     }
   *   }
   * }
   */
  void linkingTextWithSubstring();

  /**
   * Multiple Links in text with regex also with region.
   *
   * {@snippet :
   *   class HelloWorld {
   *     public static void main(String... args) {
   *       System.out.println("Hello World!");  // @link regex='".+"' target="java.lang.String" @link region="sysout" regex="Sy.*out" target="System#out"
   *       System.out.println('c');  // @link regex="'.'" target="java.lang.Character"
   *     } // @end
   *   }
   *   System.out.println("Not highlighted");
   * }
   */
  void linkingTextWithRegex();

  /**
   * Links in text with regex using both quotes and double-quotes.
   *
   * {@snippet :
   *   class HelloWorld {
   *     public static void main(String... args) {
   *       // highlight stop at first quote: raise a warning "spurious markup" and fail... while eclipse can
   *       System.out.println("Oh mama, this is letter 'c'!");  // @link regex='".+?\'' target="java.lang.String"
   *     }
   *   }
   * }
   */
  void linkingTextWithRegexPainful();

}
