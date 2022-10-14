package test03;

class Animal {
  public void move() {
    System.out.println("Animal: move");
  }
}

class Dog extends Animal {
  @Override
  public void move() {
    System.out.println("Dog move");
  }
}

public class TestExtends {
  public static void main(String args[]) {
    Animal itemAnimal = new Animal();
    Animal itemDog = new Dog();

    itemAnimal.move();
    itemDog.move();
  }
}