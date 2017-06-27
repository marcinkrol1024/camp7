package sages.bootcamp;

import java.util.ArrayList;
import java.util.List;

public class App {
  public static void main(String[] args) {
    List<Integer> listOfNumbers = new ArrayList<>();
    Foo<Integer> foo = new Foo<>(Integer.class);
    foo.print(10);
  }
}

class Foo<T> {
  private final Class<T> clazz;

  // podajemy clazz, żeby wiedzieć jakiego typu jest T podczas działania programu
  Foo(Class<T> clazz) {
    this.clazz = clazz;
  }

  void print(T bar) {
    System.out.println(bar);
    System.out.println(clazz);
  }

  Class<T> getElementsType() {
    return clazz;
  }
}

class Baz extends Foo<String> {
  Baz() {
    super(String.class);
  }
}