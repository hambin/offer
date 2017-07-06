package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by hanbing on 2017/7/6.
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {

        demo1();

        demo2();

        demo3();

        demo4();

        demo5();
    }

    /**
     * demo1: 通过Java反射机制得到类的包名和类名
     */
    public static void demo1(){
        Person person = new Person();
        System.out.println("完整类名：" + Person.class.getName() + "; 类名：" + Person.class.getSimpleName());
        System.out.println("完整类名：" + person.getClass().getName() + "; 类名：" + person.getClass().getSimpleName());
    }

    /**
     * Demo2: 验证所有的类都是Class类的实例对象
     * @throws ClassNotFoundException
     */
    public static void demo2() throws ClassNotFoundException {
        Class<?> aClass = null;
        Class<?> bClass = null;

        aClass = Class.forName("reflection.Person");
        System.out.println("完整类名：" + aClass.getName() + "; 类名：" + aClass.getSimpleName());

        bClass = Person.class;
        System.out.println("完整类名：" + bClass.getName() + "; 包名：" + bClass.getPackage().getName());
    }

    /**
     * Demo3: 通过Java反射机制，用Class 创建类对象[这也就是反射存在的意义所在]
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static void demo3() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class aClass = Class.forName("reflection.Person");
        Person person = (Person)aClass.newInstance();
        person.setAge(20);
        person.setName("new instance by reflection");
        System.out.println(person.toString());
    }

    /**
     * Demo4: 通过Java反射机制得到一个类的构造函数，并实现创建带参实例对象
     * @throws ClassNotFoundException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws IllegalArgumentException
     */
    public static void demo4() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class aClass = Class.forName("reflection.Person");
        Class bClass = Class.forName("reflection.Person");
        //构造器顺序相关
        Constructor<Person>[] constructors = aClass.getConstructors();
        Person personA = (Person)constructors[1].newInstance(20, "a");
        Person personB = constructors[0].newInstance();

        System.out.println(personA.toString());
        System.out.println(personB.toString());
    }

    /**
     * Demo5: 通过Java反射机制操作成员变量, set 和 get
     *
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws NoSuchFieldException
     * @throws SecurityException
     * @throws InstantiationException
     * @throws ClassNotFoundException
     */
    public static void demo5() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class aClass = Class.forName("reflection.Person");
        Person person = (Person) aClass.newInstance();
        Field personNameField = aClass.getDeclaredField("name");
        personNameField.setAccessible(true);
        personNameField.set(person, "setByReflection");
        System.out.println(person.toString());
    }

    /**
     * Demo6: 通过Java反射机制得到类的一些属性： 继承的接口，父类，函数信息，成员信息，类型等
     * @throws ClassNotFoundException
     */


    /**
     * Demo7: 通过Java反射机制调用类方法
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws SecurityException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InstantiationException
     */


    /**
     * Demo8: 通过Java反射机制得到类加载器信息
     *
     * 在java中有三种类类加载器。[这段资料网上截取]

     1）Bootstrap ClassLoader 此加载器采用c++编写，一般开发中很少见。

     2）Extension ClassLoader 用来进行扩展类的加载，一般对应的是jre\lib\ext目录中的类

     3）AppClassLoader 加载classpath指定的类，是最常用的加载器。同时也是java中默认的加载器。
     *
     * @throws ClassNotFoundException
     */


}
