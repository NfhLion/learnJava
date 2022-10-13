package test02;

class BaseClass {
  private int vi = 10;
  protected String vs = "BaseClass";
  public char vc = 't';
  static final int vsf = 100;

  protected void printValue() {
    System.out.println("int value: " + vi);
    System.out.println("String value: " + vs);
    System.out.println("char value: " + vc);
  }

  public final void baseTest() {
    System.out.println("test baseTest()");
  }
};

class SubClass extends BaseClass{

};

public class TypeValue {

  public static void main(String[] args) {
    BaseClass tv = new BaseClass();
    tv.printValue();
    System.out.println(BaseClass.vsf);
  }
}
