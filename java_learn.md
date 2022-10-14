1. 在Java语言中，所有的变量在使用前必须声明；

2. `javac -d . *.java`

3. **类型判断**： `instanceof`

4. `java`的修饰符

   1. 访问修饰符

      - default
      - private
      - public
      - protected

   2. 非访问修饰符

      - static

      - final

        - **final 变量：**

          final 表示"最后的、最终的"含义，变量一旦赋值后，不能被重新赋值。被 final 修饰的实例变量必须显式指定初始值。

          final 修饰符通常和 static 修饰符一起使用来创建类常量。

        - **final 方法**

          父类中的 final 方法可以被子类继承，但是不能被子类重写。

          声明 final 方法的主要目的是防止该方法的内容被修改。

        - **final 类**

          final 类不能被继承，没有类能够继承 final 类的任何特性。

      - abstract

        - 抽象类、抽象方法
      
      - synchronized 、 volatile

5. String 创建的字符串存储在公共池中，而 new 创建的字符串对象在堆上：

   1. ```java
      String s1 = "Runoob";              // String 直接创建
      String s2 = "Runoob";              // String 直接创建
      String s3 = s1;                    // 相同引用
      String s4 = new String("Runoob");   // String 对象创建
      String s5 = new String("Runoob");   // String 对象创建
      ```

   2. **注意:**String 类是不可改变的，所以你一旦创建了 String 对象，那它的值就无法改变了。

      如果需要对字符串做很多修改，那么应该选择使用 [StringBuffer & StringBuilder 类](https://www.runoob.com/java/java-stringbuffer.html)。

6. `java`数组

   1. ```java
      class TestIt
      {
          public static void main ( String[] args )
          {
              int[] myArray = {1, 2, 3, 4, 5};
              ChangeIt.doIt( myArray );
              for(int j=0; j<myArray.length; j++)
                  System.out.print( myArray[j] + " " );
          }
      }
      class ChangeIt
      {
          static void doIt( int[] z ) 
          {
              z = null ;
          }
      }
      
      // 输出 1 2 3 4 5
      /*
      原因: 引用传递也是一种值传递，并不会修改原来的引用的值，即 myArray 引用的值没有变化，还是和原来一样；但是由于引用传递传递的是引用数据在堆中的地址，因此可以通过引用传递修改引用数据类型在堆中的值，但是引用传递并不能修改原来的引用的值。
      */
      ```

   2. ```java
      class LowHighSwap
      {
          static void doIt( int[] z )
          {
              int temp = z[z.length-1];
              z[z.length-1] = z[0];
              z[0] = temp;
          }
      }
      
      class TestIt
      {
          public static void main( String[] args )
          {
              int[] myArray = {1, 2, 3, 4, 5};
              LowHighSwap.doIt(myArray);
              for (int i = 0; i < myArray.length; i++)
              {
                  System.out.print(myArray[i] + " ");
              }
          }
      }
      // 输出: 5 2 3 4 1
      // 原因: 数组作为参数是引用传递 ，在 doIt 方法中可以修改数组的值 。
      ```

7. **继承**

   1. 继承可以使用 `extends 和 implements` 这两个关键字来实现继承，而且所有的类都是继承于 `java.lang.Object`，当一个类没有继承的两个关键字，则默认继承 `Object`（这个类在 `java.lang` 包中，所以不需要 `import`）祖先类。

   2. 关键字

      - `extends`关键字

        - 在 Java 中，类的继承是单一继承，也就是说，一个子类只能拥有一个父类，所以 extends 只能继承一个类。

      - `implements`关键字

        - 使用 implements 关键字可以变相的使java具有多继承的特性，使用范围为类继承接口的情况，可以同时继承多个接口（接口跟接口之间采用逗号分隔）。

      - `super`与`this`关键字

        - ```java
          class Animal {
            void eat() {
              System.out.println("animal : eat");
            }
          }
           
          class Dog extends Animal {
            void eat() {
              System.out.println("dog : eat");
            }
            void eatTest() {
              this.eat();   // this 调用自己的方法
              super.eat();  // super 调用父类方法
            }
          }
           
          public class Test {
            public static void main(String[] args) {
              Animal a = new Animal();
              a.eat();
              Dog d = new Dog();
              d.eatTest();
            }
          }
          /*
          输出结果：
          animal : eat
          dog : eat
          animal : eat
          */
          ```

      - `final`关键字

        - final 可以用来修饰变量（包括类属性、对象属性、局部变量和形参）、方法（包括类方法和对象方法）和类。

          final 含义为 "最终的"。

          使用 final 关键字声明类，就是把类定义为最终类，不能被继承，或者用于修饰方法，该方法不能被子类重写：

          ```java
          // 声明类
          final class 类名 {/*实体*/}
          // 声明方法
          修饰符(public/private/default/protected) final 返回值类型 方法名(){/*方法体*/}
          ```

8. `Override/Overload`**重新和重载**

   1. 方法的重写(Overriding)和重载(Overloading)是java多态性的不同表现，重写是父类与子类之间多态性的一种表现，重载可以理解成多态的具体表现形式。

      - (1)方法重载是一个类中定义了多个方法名相同,而他们的参数的数量不同或数量相同而类型和次序不同,则称为方法的重载(Overloading)。
      - (2)方法重写是在子类存在方法与父类的方法的名字相同,而且参数的个数与类型一样,返回值也一样的方法,就称为重写(Overriding)。
      - (3)方法重载是一个类的多态性表现,而方法重写是子类与父类的一种多态性表现。

   2. @Override是Java5的元数据，自动加上去的一个标志，告诉你说下面这个方法是从父类/接口 继承过来的，需要你重写一次，这样就可以方便你阅读，也不怕会忘记

      - @Override是伪代码,表示重写(当然不写也可以),不过写上有如下好处: 
        1>可以当注释用,方便阅读 

        2>编译器可以给你验证@Override下面的方法名是否是你父类中所有的,如果没有则报错

      - 使用该标记是为了增强程序在编译时候的检查，如果该方法并不是一个覆盖父类的方法，在编译时编译器就会报告错误

   3. **多态**

      1. 当使用多态方式调用方法时，首先检查父类中是否有该方法，如果没有，则编译错误；如果有，再去调用子类的同名方法。

      2. 多态的好处：可以使程序有良好的扩展，并可以对所有类的对象进行通用处理。

      3. ```java
         public class Test {
             public static void main(String[] args) {
               show(new Cat());  // 以 Cat 对象调用 show 方法
               show(new Dog());  // 以 Dog 对象调用 show 方法
                         
               Animal a = new Cat();  // 向上转型  
               a.eat();               // 调用的是 Cat 的 eat
               Cat c = (Cat)a;        // 向下转型  
               c.work();        // 调用的是 Cat 的 work
           }  
                     
             public static void show(Animal a)  {
               a.eat();  
                 // 类型判断
                 if (a instanceof Cat)  {  // 猫做的事情 
                     Cat c = (Cat)a;  
                     c.work();  
                 } else if (a instanceof Dog) { // 狗做的事情 
                     Dog c = (Dog)a;  
                     c.work();  
                 }  
             }  
         }
          
         abstract class Animal {  
             abstract void eat();  
         }  
           
         class Cat extends Animal {  
             public void eat() {  
                 System.out.println("吃鱼");  
             }  
             public void work() {  
                 System.out.println("抓老鼠");  
             }  
         }  
           
         class Dog extends Animal {  
             public void eat() {  
                 System.out.println("吃骨头");  
             }  
             public void work() {  
                 System.out.println("看家");  
             }  
         }
         ```

         



