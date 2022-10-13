1. 在Java语言中，所有的变量在使用前必须声明；

2. `java -d . *`

3. `java`的修饰符

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

      - synchronized 、 volatile