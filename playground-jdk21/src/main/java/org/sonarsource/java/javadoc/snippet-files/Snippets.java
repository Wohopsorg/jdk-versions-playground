import java.util.Optional;

class Snippets {

  public void doSomething(Optional<Object> o) {
    // @start region = "example"
    if (o.isPresent()) {
      System.out.println("v: " + o.get());
    }
    // @end
  }
}
