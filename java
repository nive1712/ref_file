1.Public static void main the program compiles and runs correctly because the order of specifiers doesn't matter in Java 

public static void main (String [] args) static public void main (String [] args) 
 
Program compiles.  
If there is any deviation from this expected method signature, such as a typo or a mismatch in the method parameters, the JVM will not be able to locate the main method, However, at runtime, it throws an error "No Such Method Error." 
 
Why is Java platform-independent? 

Java is considered platform-independent due to its design and architecture, which allows Java programs to run on any device or operating system that has a Java Virtual Machine (JVM) 

When you write a Java program, the source code (.java files) is compiled by the Java compiler (java-c) into an intermediate form known as bytecode (.class files). Bytecode is not specific to any particular hardware or operating system. It is a set of instructions that the JVM can understand and execute. 

The Java slogan "Write Once, Run Anywhere" (WORA) is made possible by the JVM. You write and compile your Java program once, and the resulting bytecode can be run on any platform that has a compatible JVM. 

Java is considered an interpreted language because its bytecode is executed by the JVM, which interprets the bytecode into machine code line by line. 
 
This interpretation allows Java to be platform-independent and portable.  
However, modern JVMs also use Just-In-Time (JIT) Compilation to improve performance, making Java a hybrid language that combines both interpretation and compilation. 

 
class can have default, final, abstract, public and outer class cannot be static but inner class can be  

1. What is the Java Virtual Machine (JVM)? 

Answer: The Java Virtual Machine (JVM) is an abstract computing machine  
 
In simple terms, the Java Virtual Machine (JVM) is a part of the Java Runtime Environment (JRE) that enables Java programs to run on any device or operating system without modification. When you write and compile a Java program, it is turned into bytecode, which is a platform independent, The JVM takes this bytecode and converts it into machine code, so that the program can execute. 

The JVM acts as a bridge between the Java program and the underlying hardware, making Java platform independent. 

What is JVM? 

The JVM is a runtime environment that executes Java bytecode. It is part of the Java Runtime Environment (JRE), which also includes core libraries and other components necessary to run Java application 

Loading Code: The JVM loads compiled bytecode from .class files into memory. 
Bytecode Verification: - Before execution, the JVM verifies the bytecode to ensure it is safe and does not violate Java's security constraints. 
Interpretation: The JVM can interpret the bytecode, translating each instruction into machine code on the fly. 
Just-In-Time (JIT) Compilation: To improve performance, the JVM can compile bytecode into native machine code at runtime, storing the results to speed up future executions of the same code. 
Memory Management: The JVM manages memory for Java applications through an automatic garbage collection mechanism. This process reclaims memory used by objects that are no longer reachable from any references in the program, thus preventing memory leaks. 
Thread Management: The JVM provides a robust system for managing multiple threads, enabling concurrent execution of code and efficient use of system resources. 

What are the main features of Java? 

Answer: Java has several key features that make it popular: 

Platform Independence: Java is compiled into bytecode that can be executed on any platform with a JVM. 

Object-Oriented: Java follows the object-oriented programming paradigm, which helps in organizing code and improving reusability. 

Automatic Memory Management: Java has a built-in garbage collector that automatically manages memory allocation and deallocation. 

Multithreading Support: Java provides built-in support for multithreading, allowing concurrent execution of multiple threads for better performance. 


Breakdown of the main Method 
Public: 
Accessibility: The main method is public so that the JVM can access it from outside the class to start the application. 
Static: 
No Object Required: The main method is static so that it can be invoked without creating an instance of the class. This is necessary because the JVM needs to use this method without having any objects. 

Can we override the static methods? 

No, we can't override static methods. 

Can we make constructors static? 

As we know, the static context (method, block, or variable) belongs to the class, not the object. Since Constructors are invoked only when the object is created, there is no sense to make the constructors static. However, if you try to do so, the compiler will show the compiler error. 
Two main restrictions are applied to the static methods. 

The static method cannot use non-static data member or call the non-static method directly. 

this and super cannot be used in static context as they are non-static. 

Void: 

No Return Value: The main method is declared as void because it does not return any value to the JVM. The program execution starts from the main method and finishes when this method ends. 

String[] args: 

Command-Line Arguments: The main method accepts a single argument: an array of String objects. This array can be used to pass command-line arguments to the application. 

Can we overload the main method? 
Yes, you can overload the main method in Java. Overloading the main method means you can define multiple main methods with different parameter lists within the same class. However, the JVM will only call the standard public static void main (String [] args) method as the entry point of the application. It will not directly invoke any other overloaded main methods. 

Static Variables 

Static: Means the variable is shared among all instances of the class. 

Final: Means the variable can only be assigned once and cannot be changed. 

In Java, strings are stored in a special memory area known as the String Pool (or interned string pool) 

String Pool: The String Pool in Java is a special memory region within the Java heap that is used to store string literals. This pool is designed to optimize memory usage and improve performance by reusing instances of immutable strings. 

In Java, the String Pool (also known as String Intern Pool) is a special area in memory where Java stores String literals. It is a part of the Heap memory and is used to optimize memory usage and improve performance when working with String objects. 

Key Points about the String Pool: 

String Literals Storage: 

When you create a string using double quotes (e.g., "Hello"), it is automatically stored in the String pool. 

If the same string literal is used again elsewhere in the program, instead of creating a new object, Java reuses the existing string from the pool. 

String Interning: 

Interning is the process of storing only one copy of each distinct String literal in the pool. 

When you call the intern() method on a string, Java checks if the string is already in the pool. If it is, it returns the reference to the existing string; otherwise, it adds the string to the pool. 

public class StringPoolExample { 

    public static void main(String[] args) { 

        String str1 = "Hello"; 

        String str2 = "Hello";  // This will refer to the same object in the String Pool 

        // Using intern() method 

        String str3 = new String("Hello").intern();  // This will also refer to the same "Hello" in the pool 
        System.out.println(str1 == str2);  // true, both point to the same object in the String Pool 

        System.out.println(str1 == str3);  // true, since str3 is interned and points to the pool 

    } 

} 

Interning Strings: 

You can manually intern a string using the intern() method, which adds the string to the pool if it is not already there and returns the reference from the pool. 

rior to Java 7 (PermGen Space) 

In versions of Java prior to Java 7, the String Pool was stored in the PermGen (Permanent Generation) space, which was a special area in the heap memory 

PermGen had a fixed size limit, and once this space was full, it could lead to an OutOfMemoryError. 

The String Pool used the PermGen space to store string literals. Since the size of PermGen was limited, the number of string literals you could store was also constrained, which could result in performance issues or memory errors if the pool grew too large. 

From Java 7 and onwards (Main Heap) 

Starting with Java 7, the String Pool was moved to the main heap. This change removed the size limit imposed by the PermGen space, allowing the String Pool to grow dynamically as needed, constrained only by the overall available heap memory. 

Explain the difference between JDK, JRE, and JVM. 

Answer: 

JDK (Java Development Kit): Document, package and compile java programs  
JDK is a software development kit that provides tools for developing Java applications. It includes the JRE, compilers (java), and other tools necessary for Java development. 

JRE (Java Runtime Environment): JRE is a part of the JDK and includes the JVM along with the libraries and other files needed to run Java applications. It does not include development tools like compilers. 
A JIT (Just-In-Time) compiler in Java is a part of the Java Virtual Machine (JVM) that improves performance by converting bytecode into native machine code just before it is executed, rather than beforehand. 

Compilation: When you run a Java program, the code is first compiled into bytecode by the Java compiler. This bytecode is platform-independent and can be run on any system that has the JVM. 
Execution: The JVM, using the JIT compiler, then compiles the bytecode into native machine code (specific to your system) at runtime (just before it’s executed).  
Performance Boost: The JIT compiler makes the program run faster by optimizing the code that is used frequently. It identifies hot spots (frequently used parts of the code) and compiles them into more efficient machine code for faster execution in future runs. 

Imagine you have a recipe book (bytecode) that tells you how to cook different dishes (instructions). Instead of reading the recipe every time (interpreting bytecode), you cook the dish once and remember the steps (machine code), so the next time you can cook it faster. 

1.== Operator 
Purpose: Compares references (memory addresses) for objects and values for primitives. 

2. equals () Method 
Purpose: Compares the contents (logical equality) of two objects. It is a method defined in the Object class and can be overridden in custom classes 
Can we overload the main method? 
Java allows you to define multiple main methods with different parameter lists. The JVM (Java Virtual Machine) specifically looks for the public static void main (String [] args) method when starting your program.  
Any other overloaded main methods are not called by the JVM but can be invoked manually from other parts of the code. 

Note: 
Object-oriented languages follow all the concepts of OOPs whereas, the object-based language doesn't follow all the concepts of OOPs like inheritance and polymorphism. 
Object oriented paradigm 
The object-oriented paradigm is a programming model based on the concept of "objects," which can contain data, in the form of fields (often known as attributes or properties)
, and code, in the form of procedures (often known as methods). 

Objects: 

Objects are instances of classes and represent real-world entities. They have state (attributes/fields) and behavior (methods/functions).For example, a "Car" object might have attributes like color, make, and model, and methods like drive () and stop (). 

Classes: 

A class in Java (or any object-oriented programming language) is like a blueprint or template for creating objects. It defines: 

Properties (also called fields or attributes): These describe what the object will have (e.g., name, age, color). 

Methods: These describe what the object can do (e.g., run, speak, calculate). 

 

For example, the "Car" class would define the attributes and methods that all car objects share. 

 

Encapsulation: 

Encapsulation is the principle of bundling the data (attributes) and the methods (functions) that operate on the data into a single unit, or class. 

It restricts direct access to some of an object's components, which is a means of preventing accidental interference and misuse of the data. 

Access to the data is typically provided through methods called getters and setters. 

Inheritance: 

Inheritance allows a new class to inherit the properties and methods of an existing class. 

The existing class is called the "parent" or "superclass," and the new class is called the "child" or "subclass." 

This promotes code reuse and can create a natural hierarchy of classes. 

Polymorphism: 

The word "polymorphism" comes from Greek, meaning "many shapes" — in programming, it means that one method or object can take many forms. 
In Java, polymorphism allows you to perform a single action in different ways. There are two types of polymorphism: 

Compile-time Polymorphism (Method Overloading): This type of polymorphism is resolved during compile time. It occurs when multiple methods have the same name but different parameters (either in the number of parameters or the type of parameters). The compiler determines which method to call based on the method signature at compile time. 

 

Runtime Polymorphism (Method Overriding): inheritance is important  

This type of polymorphism is resolved during runtime. It occurs when a subclass provides a specific implementation of a method that is already defined in its superclass. The method to be called is determined by the object type (not the reference type) at runtime. 

Method resolution happens at runtime using dynamic method dispatch 

Abstraction: 

Abstraction is the concept of hiding the complex implementation details and showing only the necessary features of an object. 

It helps in reducing programming complexity and effort by allowing the programmer to focus on interactions at a higher level. 

DRY (Don't Repeat Yourself): 

Encourages reducing repetition of code by abstracting common functionality into reusable classes or methods 

Note: The super() is called in the class constructor implicitly by the compiler if there is no super or this. 

Can you use this() and super() both in a constructor? 

No, because this() and super() must be the first statement in the class constructor. 

 

 

 

CLONE() 

The clone () method in Java is used to create a shallow copy of an object. It is defined in the Object class, which is the root class of all Java objects. 

Key Points: 

Shallow Copy: A shallow copy is a copy of an object where only the reference to the object’s fields is copied, not the actual object. This means changes to those referenced objects will affect both the original and the cloned object.  
 
For primitive fields, the clone () method creates an independent copy of the value. This means that changes made to the primitive fields in the cloned object will not affect the original object and vice versa. 

Object Class: clone () is a protected method in the Object class, 
public() ,protected()- subclass 

The java.lang.Cloneable interface must be implemented  

If we don't implement Cloneable interface, clone() method generates CloneNotSupportedException. 

Type promotion: Yes, type promotion is often referred to as widening in Java, 

Type promotion occurs when Java automatically converts a value of one data type to another data type, usually from a smaller data type to a larger one, to ensure compatibility during operations 

 

Why is method overloading not possible by changing the return type in java? 

In Java, method overloading is not possible by changing the return type of the program due to avoid ambiguity. Method overloading in Java is not possible by changing only the return type because the compiler uses the method signature to differentiate between overloaded methods, and the return type is not part of the method signature. 

A constructor in object-oriented programming is a special type of method used to initialize objects.  

The constructor can be defined as the special type of method that is used to initialize the state of an object. It is invoked when the class is instantiated, and the memory is allocated for the object.  

Every time, an object is created using the new keyword, the default constructor of the class is called. The name of the constructor must be similar to the class name. The constructor must not have an explicit return type. 
Key Features of Constructors 

Same Name as Class: A constructor has the same name as the class it is defined in. 

No Return Type: Constructors do not have a return type, not even void. 

Automatically Called: A constructor is automatically called when an object is instantiated. 

Initialization: It is used to initialize the state of an object. 

Types of Constructors 

Default Constructor 

Parameterized Constructor 

1. Default Constructor 

A default constructor is a constructor that does not take any arguments. If no constructor is defined in a class, the compiler automatically provides a default constructor. However, if any constructor is defined, the default constructor is not provided automatically. 

Note:  A constructor is invoked automatically when an object is created using the new keyword. 

. Parameterized Constructor 

A parameterized constructor is a constructor that takes arguments, allowing the caller to pass values to the object during instantiation. This is useful for initializing objects with specific values. 

Copy Constructor 

A copy constructor is a constructor that creates a new object as a copy of an existing object. Java does not provide a built-in copy constructor, but you can define one yourself 
The key idea is that when you use a copy constructor to create a new object, the original object is not affected. The new object will have independent values, exact copy of the existing object is created  

No-Argument Constructor: 

Explicitly defined by the programmer. 

Similar to a default constructor but allows custom initialization logic. 

 

Shallow Copy: 

See above  
Deep Copy: 

To avoid this problem, you can implement a deep copy . This ensures that all fields, including objects, are cloned individually so the original and the copy are completely independent. 

Constructor Overloading: 

You can define multiple constructors in a class with the same name but different parameter lists. This is called constructor overloading. 

A constructor cannot be static, abstract, final, or synchronized. 

Constructors can have access modifiers (e.g., public, private, protected and package private ). 

 
Does constructor return any value?  
constructor doesn't return any value not even void  

Ans: Implicit Return: Even though a constructor does not return a value,  

it still implicitly returns the reference of the object that is being created. Or) However, it does return the current instance of the class 

Is constructor inherited? 

No, the constructor is not inherited. 

Can you make a constructor final? 

No, the constructor can't be final. 

Can we overload the constructors? 

Yes, the constructors can be overloaded by changing the number of arguments accepted by the constructor or by changing the data type of the parameters. 

No overriding is possible 

What is the way to copy the values from 1 to another? 

By constructor 

By assigning the values of one object into another 

By clone () method of Object class 
 

JVM consists of a few memory storages as mentioned below: 

Class (Method) Area: stores class-level data of every class such as the runtime constant pool, field, and method data, and the code for methods. 

Heap: Objects are created, or objects are stored. It is used to allocate memory to objects during run time. 

Heap memory is the portion that was not allocated to the java program, but it will be available for use by the java program when it is required, mostly during the runtime of the program. 

Stack: stores data and partial results which will be needed while returning value for method. 

Program Counter Register: stores the address of the Java virtual machine instruction currently being executed. 

Native Method Stack: stores all the native methods used in the application.  

Instance variables (fields) are stored in the heap memory 

When you create a new object using the new keyword, memory for the instance variables is allocated in the heap. 

Static fields (also known as class variables) are associated with the class itself, not with individual instances. They are stored in the method area 

There is only one copy of a static field for the entire class, regardless of how many objects are created from the class. 

So, class variables and Methods (functions) are stored in the method area (part of JVM memory), which is used to store class-level data, including method bytecode and static variables. 

Bootstrap Class loader: This is the parent of all class loaders. It loads the core Java classes from the rt.jar file, such as classes in java. Lang, java.util, etc. 

Parent Delegation Model: Classloaders follow a hierarchical parent-child delegation model. When a classloader is asked to load a class, it first delegates the request to its parent. If the parent cannot find the class, only then does the child classloader attempt to load it. 

What will happen if we don’t declare the main as static?  

If the main method is not declared as static, the Java Virtual Machine (JVM) will not be able to invoke it to start the program. This is because the main method needs to be called without creating an instance of the class. 

JVM Invocation: The JVM looks for the main method signature public static void main(String [] args) to start the execution of a Java program. 

Instance Requirement: If main is not static, it would require an instance of the class to be invoked. 

What are Packages in Java? 

In Java, a package is a namespace that organizes a set of related classes and interfaces. Conceptually, you can think of packages as like folders in a file directory. They help to group related classes together and avoid class name conflicts. 

Why are Packages Used? 

Packages are used in Java for several reasons: 

Namespace Management: They help manage namespaces by grouping related classes and interfaces, preventing naming conflicts. 

Modularity: Packages help to modularize the code, making it easier to manage and maintain. 

Access Control: They allow for more controlled access to classes and interfaces, enabling encapsulation and information hiding. 

Reusability: Packages promote reusability of code (by calling ) by logically grouping related functionality together. 

Advantages: 

Avoiding Name Conflicts: 

Packages allow the same class name to be used in different packages without any conflict 

Code Organization: Packages organize classes and interfaces into directories. This helps in maintaining and understanding large codebases by logically grouping related classes together. 

Access Protection: Packages provide a way to protect classes and their members using access modifiers like public, protected, and default (package-private). This ensures that only the intended classes can access certain members. 

 
Built-in Packages 

These are packages that are provided by the Java API. 

They contain classes and interfaces that are part of the standard Java library. Some common built-in packages include: 

java.lang: Contains fundamental classes like String, Math, System, and Object. This package is automatically imported. 

java.util: Contains utility classes such as ArrayList, HashMap, Date, and Calendar. 

java.io: Contains classes for input and output operations, like File, InputStream, OutputStream, Reader, and Writer. 

java.sql: Contains classes for database access and manipulation, like Connection, Statement, and ResultSet. 

 

 

User-defined Packages 

These are packages created by the user to organize and manage their own classes and interfaces. User-defined packages help in maintaining modular code and avoiding class name conflicts  
 

What is a Reference Type? 

In Java, types are broadly classified into two categories:  
 
primitive types and reference types. 

Primitive Types: These include int, char, Boolean, float, double, byte, short, and long. They store the actual values. 

Reference Types: These include classes, arrays, and interfaces.  
In Java, a reference type refers to types that are references to objects stored in memory (osm) rather than directly containing the values themselves. 

 

 

// Online Java Compiler 

// Use this editor to write, compile and run your Java code online 

  

class Main { 

    public static void main(String[] args) { 

        System.out.println("Try programiz.pro"); 

        String str= "hello"; 

        String str2= str; //holds the reference not the object. 

        System.out.println(str == str2);        

        System.out.println(str.equals(str2)); 

    } 

} 
 

Abstract:  

Java follows the principle of single inheritance for classes. This means that a class can inherit directly from only one superclass, whether it is a regular class or an abstract class. This restriction ensures simplicity, avoids ambiguity, and maintains a clean object-oriented hierarchy. 

Solution: Workaround for Single Inheritance 

If a class needs functionality from multiple classes, composition can be used as an alternative to inheritance. Instead of extending multiple classes, a class can include instances of other classes and delegate tasks to them. 

class Engine { 

    void start() { 

        System.out.println("Engine starting..."); 

    } 

} 

  

class Wheels { 

    void roll() { 

        System.out.println("Wheels rolling..."); 

    } 

} 

  

class Car { 

    private Engine engine = new Engine(); 

    private Wheels wheels = new Wheels(); 

  

    void drive() { 

        engine.start(); 

        wheels.roll(); 

        System.out.println("Car is driving..."); 

    } 

} 

  

public class Main { 

    public static void main(String[] args) { 

        Car car = new Car(); 

        car.drive(); 

    } 

} 

 

Java allows a class to implement multiple interfaces. 

Because of method declaration capability and after java 8 the discovery of default method introduced  

 

Abstract classes and abstract methods can have any access modifier (public, protected, private.) 

Abstract classes cannot be instantiated on their own. They are meant to be extended. 

An abstract class can have zero or more abstract methods. 

PictureInterface allows after java8, static method 

Inheritance Syntax 

Use the extends keyword. 

Use the implements keyword. 

 

Use an Interface when You want to take advantage of multiple inheritance (a class can implement more than one interface). 

Use an Abstract Class when: You want to provide some default behavior while leaving some methods abstract for subclasses to implement. 
interface,  
Interface can be public and default (package-private) crt 
Note: An interface cannot be protected or private because that would restrict access, contradicting the purpose of an interface.  

Interface Methods: All methods in an interface are public by default, all methods in an interface are public by default 

Starting from Java 8, 
 
Default methods: These are methods with a body, introduced to provide backward compatibility and allow implementing classes to have a default behavior. 

static methods: These methods are associated with the interface itself and can be called on the interface, not on instances of the implementing class. 

Interface variables are public, static, and final by default, effectively making them constants. 
 
How many abstract methods can an abstract class have? 

An abstract class can have zero or more abstract methods. There is no upper limit on the number of abstract methods an abstract class can contain. 

No, neither an abstract class nor an interface can be instantiated on their own in Java 

Main: An abstract class cannot be instantiated directly. You need a concrete subclass that implements the abstract methods to create an instance of the class. If a subclass does not implement all abstract methods, it must also be abstract. 

public class Dog extends Animal { 

void sound() { 

System.out.println("Woof"); 

} 

} 

public class Main { 

public static void main(String[] args) { 

// Animal a = new Animal(); // Error: Cannot instantiate the type Animal 

Dog dog = new Dog(); // This works 

dog.sound(); // Output: Woof 

} 

} 
 

Note: An instance variable is a type of variable in object-oriented programming that is associated with an instance of a class. Each object (instance) of a class has its own copy of instance variables, and their values can differ between objects. 

instance variables are declared inside a class but outside any method, constructor, or block. 
An interface also cannot be instantiated directly. A class that implements the interface must provide implementations for the abstract methods in the interface. Only then can you create an instance of the implementing class. 

public class Main { 

public static void main(String[] args) { 

// Animal a = new Animal(); // Error: Cannot instantiate the type Animal 

Dog dog = new Dog(); // This works 

dog.sound(); // Output: Woof 

} 

} 

 

What happens if a subclass does not implement all abstract methods of an abstract class (which is superclass)? 

If a subclass does not implement all the abstract methods inherited from an abstract class and is not declared abstract itself, the compiler will raise a compilation error.  
This error indicates that the class must either be declared abstract or implement the missing methods 

Can an Interface Implement Abstract Methods? 

Yes, an interface can define abstract methods, and classes that implement the interface must provide the implementation for these methods. 

In fact, all methods in an interface are implicitly abstract (before Java 8), meaning they do not have any implementation in the interface itself, and any class that implements the interface is required to provide the implementation for those abstract methods. 

 
Can an abstract class implement an interface? Provide an example. 

Yes, an abstract class can implement an interface. When an abstract class implements an interface, it does not need to provide implementations for all the methods of the interface; it can leave some or all of them as abstract methods for its subclasses to implement. And its concrete subclasses will be responsible for completing any unimplemented methods. 

Can an abstract class have final methods? Why or why not? 

Yes, an abstract class can have final methods. A final method cannot be overridden by subclasses, which can be useful when you want to provide a specific implementation that should not change 

So understad interface defines rules that unrelated class should follow 

 

Note: 
You want to group related classes together (like a family) because they share some common behavior or state. 

You want to provide some ready-to-use methods (partial implementation) while leaving other methods for the subclasses to implement. 

All vehicles have wheels and a method to calculate speed. 

But the way vehicles are started (ignition system) might differ. 

Interface: An interface is used to define a common behavior or contract for classes, even if those classes are unrelated by inheritance. 

The classes that implement the interface agree to follow the rules (i.e., implement the methods defined in the interface). 

These rules are not implemented in the interface itself but are left for the implementing classes to define. 

Scenario: Different types of workers in a company 

A Developer writes code. 

A Manager manages teams. 

A Cleaner cleans the office. 

They are completely unrelated in terms of their work, but they all must clock in and clock out. 

Now, even though Developer, Manager, and Cleaner have nothing else in common, they can all implement this interface and define their own way of clocking in and out 

   
Why interface when you have abstract? 
Interface: An interface is a great way to define a set of behaviors or capabilities that classes must implement, without enforcing how the behavior should be implemented. It focuses on the "what" a class can do. 

Abstract Class: An abstract class is typically used when you want to provide a common base with shared functionality and also leave room for specific implementations. 

Interface: Drivable might define methods like start(), stop(), and accelerate(). Any class that implements Drivable is expected to provide the implementation of these behaviors, whether it's a Car, Boat, or Bike. 

Abstract Class: A Vehicle class can provide common properties like speed and fuel, while also defining abstract methods like drive() that subclasses must implement. 

Interface: From Java 8, interfaces can contain default methods with an implementation. This allows you to add method implementations to interfaces, which makes them more flexible. 

Abstract Class: Abstract classes can have concrete methods (methods with a body) from the beginning, but interfaces now also have this capability with default methods. Pure Abstraction (Interfaces) 

Interface: If you want to represent a pure contract (i.e., a "promise" of what a class can do), you would use an interface. It defines the methods that a class must implement, but it does not provide any implementation details. 

Abstract Class: If you want to provide some default functionality while leaving room for specific behavior, you would use an abstract class. An abstract class can contain both abstract (unimplemented) methods and concrete (implemented) method 

 

Important) How does an abstract class contribute to code reusability? 

An abstract class allows you to define common behavior and properties in one place. Subclasses can inherit this common code, reducing redundancy and improving maintainability. 

What is a factory method, and how can it be related to abstract classes? 

The factory method allows the abstract class to define "what" to create (an instance of Animal), but leaves "how" to create it to its subclasses (Dog and Cat). This approach keeps the code flexible. 
This promotes loose coupling. 

Main Note : 
Abstract Class: 

An abstract class is designed to be a base class that other classes extend. It may have abstract methods (without a body) that must be implemented by subclasses, making it incomplete on its own. 

Since it’s incomplete, you cannot create an instance of an abstract class directly. To use it, you must create a subclass that provides implementations for any abstract methods and then instantiate that subclass. 

Interface 

An interface defines a contract (a set of methods) without implementation (except for default and static methods, if present). 

Since interfaces don’t provide concrete implementations for all their methods, they cannot be instantiated directly. Instead, a class must implement the interface and provide concrete implementations for its methods before you can create an instance of that class. 

An abstract class is a class that cannot be instantiated directly. You can create a reference to an abstract class, but you cannot create an object of the abstract class itself.  
You must create an instance of a subclass that extends the abstract class to instantiate it. 

An interface also cannot be instantiated directly. An interface is a contract that defines methods that must be implemented by a class. 

To use an interface, you need to create a class that implements the interface and provides concrete implementations for its methods. 

Can an interface have methods with implementations? Explain. 

Yes, since Java 8, interfaces can have methods with implementations using default methods. This allows you to add new methods to interfaces without breaking existing implementations. 

Can an interface extend to another interface? Provide an example. 

Yes, an interface can extend another interface 

A class can implement multiple interfaces  

However, it can have constant variables (declared with public static final by default) that are implicitly static and final. 

No, an interface cannot extend a class Interfaces can only extend other interfaces. 

In Java, an interface can extend another interface, but it cannot extend a class (whether abstract or not). 

 

 

 

 

Marker interfaces : 
A marker interface in Java is an interface that does not contain any methods or fields. It is used to mark or tag a class as having some property or behavior without actually defining any functionality.  

The presence of a marker interface in a class serves as a signal to the Java runtime or other programs that the class should be treated in a special way. 

Key Characteristics of Marker Interface: 

No Methods: It does not define any methods. It is simply used to "mark" or "tag" a class. 

Empty Interface: It is an empty interface, i.e., it does not contain any method declarations. 

Used for Identifying Behavior: Classes that implement a marker interface typically exhibit some special behavior or capabilities. 

 

Another well-known marker interface, Cloneable, indicates that a class allows its instances to be cloned (duplicated) using the clone() method. If a class does not implement Cloneable, calling the clone() method will throw a Clone Not Supported Exception. 

Serializable: This is one of the most commonly used marker interfaces in Java. A class that implements Serializable indicates that its instances can be serialized (converted into a byte stream) and deserialized (reconstructed from a byte stream) Using instanceof, we can check whether an object is marked as Serializable or not. 

Constructor chaining : 
Constructor chaining is a technique in Java where one constructor calls another constructor within the same class or a superclass. 
This allows for a more organized and efficient way to initialize objects with different sets of parameters, reducing code duplication and ensuring that constructors can reuse code. 

There are two types of constructor chaining: 

Within the same class: Using the this () keyword. 

Between a subclass and a superclass: Using the super () keyword. 

a) public Employee() { 

this("Unknown", 0, "Unknown"); // Calls the constructor with three arguments 

} 

// Constructor with two arguments 

public Employee(String name, int age) { 

this(name, age, "Unknown"); // Calls the constructor with three arguments 

} 

// Constructor with three arguments 

public Employee(String name, int age, String department) { 

this.name = name; 

this.age = age; 

this.department = department; 

} 

b) public Employee(String name, int employeeId) { 

super(name); // Calls the constructor of the superclass (Person) 

this.employeeId = employeeId; 

} 

Constructor Overloading 

In Java, constructors can be overloaded, but they cannot be overridden  

Definition: Constructor overloading occurs when a class has more than one constructor with different parameter lists (different types or numbers \of parameters). This allows you to create objects of a class in various ways. 

 

Method Overriding 

Definition: Overriding occurs when a subclass provides a specific implementation of a method already defined in its superclass.  
The method in the subclass must have the same name, return type, and parameters. 

Run-Time Polymorphism: It’s resolved at runtime. 

 

Can a subclass have the same method signature as a superclass method without overriding it? 

Method hiding occurs in Java when a subclass defines a method with the same name and signature as a method in the parent class (static methods).  

Unlike method overriding, which is related to instance methods, method hiding happens with static methods. 

A static method in a subclass with the same name and parameters as one in the parent class hides the parent class's static method. 

The method that gets called is determined at compile-time based on the reference type, not the object type. 

Rules for Method Hiding: 

Static Methods Only: Method hiding applies only to static methods.  

Same Signature: The hiding method in the subclass must have the same name and parameter list as the method in the superclass. 

Static Methods in Superclass and Subclass: 

The hiding method must not have a more restrictive access level than the method it hides.  
For example, a public method in the superclass cannot be hidden by a protected method in the subclass. 

Java enforces this rule to avoid unexpected access restrictions when calling methods through a superclass reference. it can’t make that method more private than the one in the superclass. 

If a superclass method is private, it’s not inherited by subclasses at all. 

Eg : When a static method in a superclass is protected, the hiding method in the subclass cannot reduce its access level. This means the hiding method in the subclass must be either: 

protected (same access level) 

public (more permissive access level) 

 

Both the method in the superclass and the method in the subclass must be static. If the superclass method is static and the subclass method is not, or vice versa, a compile-time error will occur. 

 

Instance-of: The instance of operator checks whether an object is an instance of a specific class or subclass. It returns true if the object belongs to that class or any of its subclasses. 

Implementation: 

Interface: Cannot provide any method implementations (until Java 8 where default methods were introduced). 

Abstract Class: Can provide implementations for some methods and leave others abstract. 

 

Fields: 

Interface: Can only have static and final fields (constants). 

Abstract Class: Can have instance variables. 

Constructors: 

Interface: Cannot have constructors. 

Abstract Class: Can have constructors. 

Inheritance: 

Interface: A class can implement multiple interfaces. 

Abstract Class: A class can extend only one abstract class. 

 ) How to achieve data hiding and what is data hiding? 

Data Hiding 

Definition: Data hiding is a principle used to restrict access to the internal state (fields) of an object, typically by making fields private and providing public getter and setter methods to access and modify them. 

Key Points: 

Data hiding is achieved through encapsulation.  

The main advantage of data hiding is security 

 
Encapsulation: Encapsulation=Data hiding + Abstraction 

Definition: Encapsulation is the bundling of data (attributes) and methods (functions) that operate on the data into a single unit or class. It restricts direct access to some of an object's components, which is a means of preventing unintended interference and misuse. 

Purpose: The main purpose of encapsulation is to protect the internal state of an object and only allow modification through well-defined interfaces (methods). This enhances modularity and maintainability. 

Example: In a class, private variables are accessed and modified through public getter and setter methods. 

Advantages: 1) The main advantages of encapsulation are 
: 1) We can achieve security. 2) Enhancement will become very easy 

The main disadvantage of encapsulation is it increases length of the code and slows down execution 

Explanation: In a hospital, a patient's medical records are encapsulated. Sensitive information, such as medical history, is kept private and can only be accessed and modified through authorized channels. 

Loosely Encapsulated Class 

A loosely encapsulated class is a class where the fields are not strictly private and may be accessed directly from outside the class. This reduces the level of data hiding and control over how the data is accessed and modified. 

Characteristics: 

Non-Private Fields: Some or all instance variables may be public or protected. 

Direct Access: Fields can be accessed and modified directly from outside the class. 

Less Control: There is less control over the validation and modification of data, which can lead to inconsistencies. 

Tightly Encapsulated Class 

A tightly encapsulated class is a class where all the fields (member variables) are declared private. This ensures that the data is hidden from outside access and can only be accessed through public methods (getters and setters). This promotes data hiding and encapsulation, which are fundamental principles of object-oriented programming. 

Characteristics: 

Private Fields: All instance variables are private. 

Controlled Access: Access to fields is provided through public getter and setter methods. 

Data Validation: Setters can include validation logic to ensure that the data remains consistent and valid. 

 

 

Abstraction: 

Definition: Abstraction is the concept of hiding the complex implementation details and showing only the essential features of the object. It focuses on what the object does instead of how it does it. 

Purpose: The purpose of abstraction is to reduce complexity and allow efficient design and implementation. It helps in focusing on the relevant aspects of the object and ignoring the unnecessary details. 

Example: Abstract classes and interfaces in Java. 

Advantages: 
1) We can achieve security as we are not highlighting our internal implementation. 

 2) Enhancement will become very easy because without affecting the end user we can be able to make any type of change in our internal system. 

Explanation: When you make an online payment, you interact with a simple interface (e.g., entering card details), but the underlying process (such as authentication, transaction processing, and communication with the bank) is abstracted away. 

Inheritance: 

Definition: Inheritance is a mechanism where one class acquires the properties and behaviors (methods) of another class. The class that inherits is called the subclass or derived class, and the class being inherited from is called the superclass or base class. 

Purpose: Inheritance promotes code reusability and establishes a natural hierarchical relationship between classes. 

 

Inheritance in real life is like a child inheriting traits from their parents. For example: 

A Dog inherits the characteristics of an Animal, such as the ability to breathe and move. 

The Dog class is a subclass of the Animal class, and it can add specific features like barking. 

 

Types: 
Single Inheritance 

In single inheritance, a class (subclass) inherits from one and only one superclass. This type of inheritance is straightforward and helps maintain a clear hierarchy. 

eg : A (super class) B extends a  
Multilevel Inheritance 

In multilevel inheritance, a class is derived from another class, which is also derived from another class, creating a chain of inheritance.  
Eg : a (super class) B extends a and c extends b 

Hierarchical Inheritance 

In hierarchical inheritance, multiple subclasses inherit from a single superclass. 
Eg : a (super class) b and c extends a 
 
Multiple inheritance : 
Java does not support multiple inheritance through classes primarily to avoid the ambiguity and complexity that can arise when a class inherits from multiple classes. This is particularly illustrated through the "diamond problem," which can occur when two classes provide different implementations of the same method, and a third class inherits from both of them. 

Diamond problem: 

For example, if both superclass A and superclass B have a method display(), and class C extends both A and B, it would be unclear which display() method class C should use. 

If multiple classes provide implementations for the same method, it leads to ambiguity. The compiler would need to handle these ambiguities, which would complicate the compilation process and reduce the efficiency of the Java language. 

By restricting inheritance to a single superclass, Java encourages a clearer and more straightforward class design. 

Although Java does not support multiple inheritance through classes, it allows achieving similar functionality through interfaces because Since interfaces can define abstract methods, this allows for multiple types of behavior to be implemented in a single class. 

interface Animal { 

    void eat(); 

} 

  

interface Pet { 

    void play(); 

} 

  

class Dog implements Animal, Pet { 

    @Override 

    public void eat() { 

        System.out.println("Dog eats"); 

    } 

  

    @Override 

    public void play() { 

        System.out.println("Dog plays"); 

    } 

} 

 

Answer: When you have two interfaces, each with a method called display(), and a class C implements both interfaces, Java's multiple inheritance with interfaces can lead to a potential ambiguity issue—especially if both interfaces provide a default implementation for display(). 

To resolve this, Java requires class C to override the display() method and provide its own implementation. In this way, class C eliminates the ambiguity by specifying how display() should behave, rather than relying on either A or B’s default implementation 

(using A.super.display() or B.super.display()) 

 
Polymorphism: 

Polymorphism in Java means "one thing, many forms." It allows you to use a single interface, method, or object in multiple ways depending on the context.  

It provides the ability to call the same method on different objects and have each of them respond in their own way. 

Purpose: Polymorphism enhances flexibility and maintainability in code. 

Polymorphism in real life is like an actor playing different roles in different movies. The actor is the same, but the role they play can change depending on the movie. 

 

There are two main types of polymorphism in Java: method overloading ->  
compile-time polymorphism (also known as static polymorphism) and 

runtime -> method overriding polymorphism (also known as dynamic polymorphism). Also called as Dynamic Dispatch  

Definition: Compile-time polymorphism is achieved through method overloading and operator overloading. The method to be invoked is determined at compile time based on the method signature (method name and parameters). 

The compiler determines which method to call at compile time based on the method signatures. 

This type of polymorphism is also known as static polymorphism or early binding. 

In a calculator application, you might want to perform the addition operation with different types of input (integers, doubles, etc.) 

 

Note:  
Early Binding: Happens when the method is resolved at compile-time (like static methods, method overloading). 

Late Binding: Happens when the method is resolved at runtime, usually with method overriding and dynamic polymorphism. 

 

Runtime Polymorphism (Dynamic Polymorphism) 

Definition: Runtime polymorphism is achieved through method overriding. The method to be invoked is determined at runtime based on the object type rather than the reference type. 

The JVM determines which method to call at runtime based on the actual object type, not the reference type. 

In an animal sound application, you can have different types of animals (e.g., Dog, Cat) that implement a common method makeSound(). The specific implementation of makeSound() will be determined at runtime. 

Definition: Whatever the Parent has by default available to the Child through inheritance, if the Child is not satisfied with Parent class method implementation, then Child is allowed to redefine that Parent class method in Child class in its own way this process is called overriding. •  

The Parent class method which is overridden is called overridden method. •  

The Child class method which is overriding is called overriding method. 

Runtime Polymorphism or Dynamic Polymorphism: When you call a method on an object, Java decides which version of the method to run (the one in the parent class or the one in the child class) while the program is running, not when it's compiled. This is called runtime polymorphism or dynamic polymorphism or Dynamic Method Dispatch 

Late Binding: 

Since the decision of which method to run happens during the program's execution and not at compile-time, this process is also referred to as late binding. 

The Parent class method which is overridden is called overridden method. •  

The Child class method which is overriding is called overriding method.  

 
When you overload a method (i.e., define multiple methods with the same name but different parameters), you can use more restrictive access modifiers for the overloaded methods compared to the original method. 

In method overriding, the access modifier of the overriding method in the Child class must not be more restrictive than the access modifier of the overridden method in the Parent class. This is a rule known as the "weaken/reducing is not allowed" rule. 

Explanation: 

If the parent class method is public, the child class method can be public, protected, or package-private (default), but not private. 

If the parent class method is protected, the child class method can be protected or package-private, but not private. 

If the parent class method is package-private, the child class method must also be package-private or more accessible (e.g., protected or public), but not private. 
If the method in the superclass is private, it cannot be overridden because it is not accessible to subclasses. 

Order of restrictiveness and permissive 
public (Most Permissive) 

The member is accessible from anywhere, inside or outside of the class, package, and even across different packages. 

protected 

The member is accessible within its own package and by subclasses (even if they are in different packages 

Package-Private (Default access modifier, no keyword) 

The member is accessible only within its own package. If no access modifier is specified, it is package-private by default. 

private (Most Restrictive) 

The member is accessible only within the class it is defined in. 

IS-A Relationship (Inheritance) 

The IS-A relationship is a concept of inheritance in object-oriented programming, where one class inherits the properties and behaviors (fields and methods) from another class. It establishes a parent-child relationship between two classes. 

example: Car is a Vehicle (IS-A relationship). Car inherits the drive method from Vehicle but provides its specific implementation 

usage: Use IS-A relationship when there is a clear hierarchical relationship, and you want to reuse code from the parent class. 

It promotes code reusability and polymorphism. 

HAS-A Relationship (Composition/Aggregation) 

The HAS-A relationship, also known as composition or aggregation, is a concept where one class contains a reference to another class. This relationship represents a "whole-part" or "owner-owned" association between objects. 

Composition: A strong form of HAS-A relationship where the contained object cannot exist independently of the container object. The lifecycle of the contained object is controlled by the container object. 

Example: 
The engine is a crucial component that defines the car's functionality. The engine cannot exist independently without the car. When the car is destroyed, the engine is also destroyed. 

 

Aggregation: A weaker form of HAS-A relationship where the contained object can exist independently of the container object. 

Example: The library has a collection of Book objects. The Books can exist independently of the library. 

Note: 
ASSOCIATION: It represents a relationship between two separate classes that is established through their objects. 

One-to-Many: A single instance of a class is associated with multiple instances of another class. 
EG: A single Teacher object is associated with multiple Student objects. 

Many-to-Many: Multiple instances of a class are associated with multiple instances of another class.  
EG:Multiple Teacher objects are associated with multiple Student objects, and vice versa. 

One-to-One Association: A single instance of a class is associated with a single instance of another class. 

Scenario: Each person has one passport, and each passport is assigned to one person. 

Many-to-One Association: Multiple instances of a class are associated with a single instance of another class. 

Scenario: Multiple Employee objects are associated with a single Department object. 

Important:  

In object-oriented programming, the concept of inheritance allows a child class to inherit properties and methods from a parent class. 

Child Inherits Parent’s Properties and Methods: 

Child class has access to all public and protected members (methods and properties) of the parent class. 

Parent class does not have access to methods or properties defined in the child class 

EG : Parent parent = new Parent(); 

        parent.parentMethod(); // Outputs: Parent method 

        // parent.childMethod(); // Compilation error: cannot find symbol 

Calling Methods on References: 

Child Reference: Can call both parent and child methods. 

Parent Reference: Can call only parent methods, not child-specific methods. 

/ Child reference holding Child object 

        Child child = new Child(); 

        child.parentMethod(); // Outputs: Parent method 

        child.childMethod();  // Outputs: Child method 

Reference Holding: 

Parent Reference Holding Child Object: 

This is allowed and is known as polymorphism. 

Using a parent reference, you can only call methods defined in the parent class, even though the object is of the child class. 

Child Reference Holding Parent Object: 

This is not allowed because the parent object does not have the additional methods and properties defined in the child class. 

  

EG:  

  // Parent reference holding Child object (Polymorphism) 

        Parent parentRefChild = new Child(); 

        parentRefChild.parentMethod(); // Outputs: Parent method 

        // parentRefChild.childMethod(); // Compilation error: cannot find symbol 

  

        // Child reference holding Parent object (Not allowed) 

        // Child childRefParent = new Parent(); // Compilation error: incompatible types 

 

Need to know: 
Direct Child Class of Object: 

The Object class in Java is the root of the class hierarchy. Every class in Java directly or indirectly inherits from the Object class. 

Root of the Class Hierarchy: Every class in Java implicitly extends the Object class unless it explicitly extends another class. 

Default Methods: The Object class provides common utility methods, such as toString(), equals(), hashCode(), clone(), and more. 

 

Indirect Child Class of Object: 

If a class extends another class, it is considered an indirect child of Object. In this case, it inherits properties and methods from its parent class, and through that parent class, it also inherits from Object. 

Object class methods: 
1. equals(Object obj) 

By default, the equals method defined in the Object class compares memory addresses, which means it checks whether the two references point to the same object in memory. 

2.hashCode() 

Returns an integer hash code for the object 

h equals(): If two objects are equal (equals() returns true), they must have the same hashCode(). 

The Object class in Java is the parent of all classes, meaning every class in Java inherits from it either directly or indirectly. It provides several important methods that are fundamental to Java's object model. Here's a list of the key methods in the Object class, along with their purpose: 

1. equals(Object obj) 

Compares the current object with another object for equality. 

Can (and often should) be overridden to provide custom equality logic. 

Example: 

java 

Copy code 

@Override 

public boolean equals(Object obj) { 

if (this == obj) return true; 

if (obj == null || getClass() != obj.getClass()) return false; 

MyClass myClass = (MyClass) obj; 

return field == myClass.field; 

} 

2. hashCode() 

Returns an integer hash code for the object. 

Used in hash-based collections like HashMap and HashSet. 

Contract with equals(): If two objects are equal (equals() returns true), they must have the same hashCode(). 

Should be overridden whenever equals() is overridden. 

3. toString() 

Returns a string representation of the object 

4.. getClass() 

Returns the runtime class of the object. 

5.clone() 

Creates and returns a shallow copy of the object.Useful for reflection. 

Requires the class to implement the Cloneable interface; otherwise, it throws a CloneNotSupportedException. 

6.finalize() (Deprecated in Java 9, removed in Java 18) 

Was called by the garbage collector before an object was destroyed. 

7. wait() 

Causes the current thread to wait until another thread notifies it using notify() or notifyAll(). 

8.notify() 

Wakes up a single thread waiting on the object's monitor (if any). 

9.notifyAll() 

Wakes up all threads waiting on the object's monitor. 

 

super 

The super keyword is used in Java to refer to the superclass (parent class) of the current object. It can be used to access superclass methods and constructors. 

this 

This keyword is a reference to the current object. It is often used to avoid naming conflicts between instance variables and parameters, and to pass the current object as a parameter. 

 

Process vs thread 
Process 

Definition: A process is an instance of a program in execution. It is an independent entity to which system resources (CPU time, memory, files, etc.) are allocated. 

Isolation: Processes run in separate memory spaces. Each process has its own address space, which prevents them from interfering with each other’s memory, enhancing security and stability. 

Heavyweight: Creating and managing processes is relatively expensive in terms of system resources. This includes memory allocation, 

Resource Management: Processes have their own resources, including a unique process identifier (PID), memory space, file handles, and more. 

Fault Isolation: A failure in one process does not affect other processes. If a process crashes, it typically does not bring down the entire system or other processes. 

Example: Running a word processor 

Thread 

Definition: A thread (also known as a lightweight process) is the smallest unit of execution within a process. 

Shared Memory: Threads within the same process share the same memory space and resources, which allows for efficient communication and data sharing but requires careful synchronization to avoid conflicts. 

Lightweight: Creating and managing threads is less resource-intensive compared to processes 

Resource Sharing: Threads share the same process resources,   

Fault Propagation: A failure in one thread can potentially affect the entire process. For example, if a thread crashes due to a segmentation fault, it can bring down the entire process. 

Example: A web browser might use multiple threads within a single process: one thread for rendering the user interface, another for downloading files,   

Method overloading example: 
public class MethodOverloadingExample { 

  

    // Method 1: Adding two integers 

    public double add(int a, int b) { 

        return a + b; 

    } 

  

    // Method 2: Adding two doubles 

    public double add(double a, double b) { 

        return a + b; 

    } 

  

    // Method 3: Adding three integers 

    public double add(int a, int b, int c) { 

        return a + b + c; 

    } 

  

    public static void main(String[] args) { 

        MethodOverloadingExample example = new MethodOverloadingExample(); 

  

        // Calling the overloaded methods 

        System.out.println("Sum of two integers: " + example.add(5, 10));          // Calls the first method 

        System.out.println("Sum of two doubles: " + example.add(5.5, 10.5));        // Calls the second method 

        System.out.println("Sum of three integers: " + example.add(5, 10, 15));    // Calls the third method 

    } 

} 

Association 

Association is a relationship between two classes where one class uses or interacts with another class. It is a "has-a" relationship but does not imply ownership. 

Example: A teacher can associate with a student but does not own the student. 

Aggregation 

Aggregation is a special type of association that represents a "whole part" relationship. In aggregation, the part can exist independently of the whole, meaning that the lifecycle of the part is not tied to the whole. 

Example: A university and its departments. 

Composition 

Composition is a strong form of aggregation where the part cannot exist independently of the whole. It implies ownership, meaning if the whole is destroyed, the part is also destroyed. 

Example: A house and its rooms. 
Constructor is not presented in interface and constructor doesnt return value and constructor will not be overridded 
 

What is the default method in an interface? 

Default Implementation: A default method can provide a body (implementation) directly in the interface. This means classes that implement the interface do not need to provide an implementation for the default method unless they want to override it. 

Syntax: A default method is defined using the default keyword followed by the method signature and implementation. 

Default methods can be public (the default) or protected. They cannot be private or static. 

The Object class is the root class of all Java classes. Every class in Java implicitly inherits from Object, providing basic methods like equals(), hashCode(), and toString(). 
 

A String in Java is a sequence of characters. Strings are objects in Java, and they are used to represent text. 

The Java String class equals () method compares the two given strings based on the content of the string. If any character is not matched, it turns out false. If all characters are matched, it returns true. The default implementation of equals() in the Object class checks if the two references point to the same memory location 

 
class HelloWorld { 

    public static void main(String[] args) { 

       String s1="hello"; 

       String s2="hello"; 

       String s3= new String("hello"); 

       System.out.println(s1.equals(s2)); 

       System.out.println(s1.equals(s3)); 

    }  

} // output: true, true 
//hashcode: 99162322 

99162322 

99162322 
The Java documentation states that if two objects are equal according to the equals () method, they must return the same hash code from the hash Code() method. This is referred to as the "general contract for hash Code()." 


If two objects are equal (i.e., obj1.equals(obj2) returns true), then calling obj1.hashCode() must return the same value as calling obj2.hashCode(). This ensures consistent behavior in hash-based collections. 

If you override equals () but do not override hashCode(), you might encounter the following issues: 

The Problem: 

If two objects are considered equal according to the overridden equals() method, they must return the same hashCode(). 

If hashCode() is not overridden, the default implementation (from the Object class) will be used. This default implementation generates a hash code based on the object's memory address. 

As a result, two equal objects (according to equals()) may produce different hash codes, leading to them being placed in different buckets in hash-based collections. 

Why This Is a Problem: 

When you try to search for or retrieve the object, the collection first uses the hashCode() to locate the bucket. 

If two equal objects have different hash codes, they’ll be placed in different buckets, and the collection won’t find the expected object, even though they are logically equal. 


Lookup failures 

Lookup Failure in HashMap 

Key Not Present: 

If the key being looked up is not present in the HashMap, the get method will return null. 

 
When Lookup Fails: unexpectedly fails to find the object 

A lookup failure happens when the collection cannot locate an object because: 

The object's hashCode() has changed after being added to the collection. 

This can happen if hashCode() is based on mutable fields, and those fields are changed after the object is stored. 

Two logically equal objects (as defined by equals()) have different hashCode() values. 

This happens if equals() is overridden but hashCode() is not, or if hashCode() is implemented incorrectly. 

 
The String Pool is a special memory area in Java that stores string literals to optimize memory usage and improve performance. It is part of the Java heap memory. 

Strings are stored in a special memory area called the String Pool.  
When a string literal is created, Java checks the pool to see if an equivalent string exists; if it does, the reference is returned instead of creating a new object. 

The String Pool, also known as the String Intern Pool, is a collection of strings stored in a special area of heap memory. 

When you create a string literal in Java (e.g., String s = "hello";), the Java Virtual Machine (JVM) checks the string pool to see if an identical string already exists. 

If an identical string is found, the reference to the existing string is returned. If not, the new string is added to the pool. 
 

Memory Efficiency: By storing only one copy of each distinct string literal, the string pool reduces memory consumption. 


What is a string literal? 

A string literal is a sequence of characters enclosed in double quotes  
that is used to initialize a string variable directly. 

String: 

Immutable: Once created, their values cannot be changed. 

In Java, strings are immutable, which means that once a String object is created, its value cannot be changed.  

This immutability makes String inherently thread-safe, as multiple threads can safely read and share a String object without the risk of data corruption or inconsistent views. 

Performance: Slower for frequent modifications due to immutability. 

StringBuilder: 

Mutable: Can be modified after creation. 

Not thread-safe: Not synchronized, so it’s faster but not safe for concurrent use. 

Performance: Better for single-threaded scenarios where strings are frequently modified. 

StringBuffer: 

Mutable: Can be modified after creation. 

Thread-safe: Synchronized, making it safe for use in a multithreaded environment. 

Performance: Slower than StringBuilder due to synchronization overhead. 

 
What is the purpose of the trim() method in the String class? 

The trim() method removes leading and trailing whitespace from a string, which is useful for cleaning up input data. 

 
public class StringPoolExample { 

    public static void main(String[] args) { 

        String str1 = "hello"; // String literal, stored in the String Pool 

        String str2 = "hello"; // Same string literal, reuses the reference from the String Pool 

        System.out.println(str1 == str2); // Output: true, because they point to the same reference in the pool 


        String str3 = new String("hello"); // Creates a new String object in the heap, not in the pool 

        System.out.println(str1 == str3); // Output: false, because str3 points to a different reference 

  
        String str4 = str3.intern(); // Interns str3, adding it to the String Pool 

        System.out.println(str1 == str4); // Output: true, because str4 now points to the same reference as str1 

    } 

} 

Note : string pool is not inherently thread safe, However, the  

intern() method itself is thread safe. 

Interning Process: 

When you call the intern() method on a string: 

Java checks the String Pool to see if a string equal to the specified string already exists. 

If it exists, the method returns the reference to the pooled string. 

If it doesn't exist, the method adds the string to the pool and returns its reference. 


In Java, strings are immutable, meaning that once a string object is created, its value cannot be changed. 

String Pool Optimization: Since strings are immutable, they can be shared in the string pool. When a new string is created with the same value as an existing string, Java can reuse the existing string reference, saving memory. 

Reduced Memory Overhead: Immutability allows Java to optimize memory usage by preventing unnecessary copies of string data. When multiple variables reference the same string, only one instance exists in memory. 

Safe from Modification: Immutable objects are inherently thread-safe, meaning that they cannot be modified once created. This eliminates issues related to concurrent access and modification by multiple threads, 

Predictable Behavior: The immutability of strings ensures that once they are created, their values remain constant. This consistency makes strings more reliable and easier to use in different contexts. 

Immutable strings cannot be changed after they are created. This design helps with memory efficiency, thread safety, and reduces the complexity of string management in multi-threaded applications. 

String Creation Mechanisms 

Using String Literals 


Code explanation:  
When a string is created using a literal (e.g., String s1 = "hello";), the JVM performs the following steps: 

  
Checks if the string "hello" already exists in the String Pool. 

If the string exists, it returns the reference to that string. 

If it does not exist, the string is created in the pool, and its reference is returned. 

  
Using new Keyword 

When a string is created with new (e.g., String s3 = new String("hello");), the JVM: 

  
Allocates memory for the new string object on the heap. 

Does not check the String Pool by default. 

As a result, s3 is a new object with the same content as "hello", but its reference is different. 


Using String.intern() 

The String.intern() method explicitly adds the string to the String Pool or retrieves it if it already exists: 

If the string is already in the pool, intern() returns the reference to the pooled string. 

If it is not in the pool, the string is added to the pool, and the reference to it is returned. 

StringBuilder and StringBuffer are both classes in Java used to create mutable strings 

String Buffer is synchronized, meaning it is thread safe. 

Multiple threads can safely operate on a single instance of String Buffer without causing data inconsistencies. 

Performance: Because of its synchronized nature, String Buffer is slower than StringBuilder 

Recommended for multi-threaded scenarios 

String Builder is not synchronized.  
It is faster than StringBuffer because it is not  

Recommended for single-threaded scenarios 

How do you convert a String to an integer in Java? 

You can use Integer.parseInt() or Integer.valueOf() to convert a string to an integer. 


== checks for reference equality (whether both references point to the same object), while equals () checks for value equality (whether the content of the strings is the same) 

 
1. Upcasting 

Upcasting refers to the process of casting a subclass object to a superclass type. This is called "upcasting" because you're casting an object to a higher level in the inheritance hierarchy. 

It is implicitly performed by Java (i.e., no explicit casting is needed). 

No data loss occurs, and you can access only the members that are present in the superclass (or interface). 

Animal animal = new Dog();  

Downcasting Dog dog = (Dog) animal;  

Downcasting refers to the process of casting a superclass object to a subclass type. This is called "downcasting" because you're casting an object to a lower level in the inheritance hierarchy. 

What happens during Downcasting? 

Downcasting requires explicit casting. 

It can cause ClassCastException at runtime if the object is not actually an instance of the subclass being cast to. 
Always use it carefully, and it is recommended to check the object type with instanceof before downcasting to avoid ClassCastException. 


What is the default value of an instance variable? 

Instance variables are initialized to default values: 0 for numeric types, false for boolean, and null for object references. 

Default Values 

byte, short, int, long: 0 

float, double: 0.0 

char: '\u0000' (null character) 

boolean: false 

Reference types: null 


Explain the concept of variable scope in Java. 

Variable scope defines the accessibility of a variable within different parts of the code. Java has block scope, method scope, class scope, and global scope. 

Block Scope 

Definition: Variables declared inside a block (enclosed by curly braces {}) are only accessible within that block. 

Lifetime: The variable exists only during the execution of that block. 

Method Scope 

Definition: Variables declared within a method are only accessible within that method. This includes method parameters and local variables. 

Lifetime: The variable is created when the method is called and destroyed when the method exits. 
Local Variables: Declared inside a method, constructor, or block. They are created when the method is called and destroyed once the method exits.  

They do not have a default value and must be initialized before use 


In Java, local variables do not have a default value. Unlike instance variables or class variables (fields), which are automatically initialized with default values (0 for int, null for objects, false for Boolean, etc.), local variables must be explicitly initialized before use. 

If you try to use a local variable without initializing it, the compiler will throw a compilation error. This is because the Java compiler does not know what value to assign to i Error: variable x might not have been initialized 

Instance Variables (Non-Static Fields): Declared in a class but outside any method, constructor, or block. They are created when an object of the class is instantiated and destroyed when the object is destroyed. They have default values. Each object (instance) of the class has its own copy of instance variables 


Lifetime: The variable exists as long as the object of the class is alive. 


Class Variables (Static Fields): Declared with the static keyword inside a class but outside any method, constructor, or block. They are created when the class is loaded and destroyed when the class is unloaded. They have default values and can be accessed directly using the class name. 

They can be accessed directly using the class name, and they exist as long as the class is loaded in memory. 

Lifetime: The variable persists for the lifetime of the application. 

public static void main(String[] args) { 

Counter c1 = new Counter(); // count becomes 1 

Counter c2 = new Counter(); // count becomes 2 

c1.displayCount(); // Output: Count: 2 

c2.displayCount(); // Output: Count: 2 

} 

All instances of the class share the same variable. If the value of a class variable is changed by one instance, it will affect all other instances. 

In the above example, count is a class variable. Even though we created two instances (c1 and c2), the variable count is shared between them. Both instances reflect the same value for count. 

Each time an instance of the Counter class is created, the constructor is invoked, which increments the count variable. Since count is a class variable (static), it retains its updated value across all instances of the class. 


Static block: Static blocks will be executed at the time of class loading hence if we want to perform any activity at the time of class loading, within a class we can take any no. Of static blocks This happens during the class loading phase of the Java Virtual Machine (JVM). 


Multiple Static Blocks: 

You can have multiple static blocks in a class. They are executed in the order they appear in the source code, from top to bottom. 

1. System.out (Standard Output) 

Purpose: It is used to print normal output (e.g., messages, results) to the console. 

Type: It is an instance of the PrintStream class. 

2. System.err (Standard Error) 

Purpose: It is used for printing error messages or warnings. It is typically used for displaying error logs or diagnostics that need to be distinguished from normal output. 

3.System.in (Standard Input) 

Purpose: It is used to read input from the user, typically from the keyboard. 

Type: It is an instance of the InputStream class. 

Type: It is also an instance of the PrintStream class. 

Note : PrintStream is a subclass of OutputStream that provides convenient methods for writing data to a stream, specifically text-based data. It is part of the java.io package and is commonly used for writing to output streams like the console or a file. PrintStream provides methods to print representations of data in human-readable text form 

It includes various print() and println() methods for writing data to the stream, including: 

print(): Writes the specified data to the stream without a newline. 

println(): Writes the specified data to the stream followed by a newline 

Note: InputStream is an abstract class in Java used to read bytes of data from an input source, such as a file, network connection, or user input. It is part of the java.io package and serves as the superclass for all byte input streams. 

The primary purpose of InputStream is to read raw byte data,InputStream is byte-oriented, which means it reads 8 bits (1 byte) of data at a time, making it suitable for handling binary data. 

InputStream is an abstract class and cannot be instantiated directly. 

Synchronized Block 

Definition: A synchronized block is used to control access to a block of code by multiple threads.  
It ensures that only one thread can execute the block at a time, preventing thread interference and memory consistency errors. 

Instance Block: An instance block is a block of code that runs when an instance of a class is created. It is executed every time an object is instantiated, before the constructor. 

Method Block: This refers to the code inside a method. When a method is called, the block of code inside it is executed. 

Try-Catch Block: A try-catch block is used for exception handling. The code that might throw an exception is placed in the try block, while the catch block handles the exception. 


What are the different primitive data types in Java? 

Answer: Java has eight primitive data types: 

byte: 8-bit signed integer. Range: -128 to 127. 

short: 16-bit signed integer. Range: -32,768 to 32,767. 

int: 32-bit signed integer. Range: -2^31 to 2^31-1. 

long: 64-bit signed integer. Range: -2^63 to 2^63-1. 

float: Single-precision 32-bit floating point. 

double: Double-precision 64-bit floating point. 

char : 16-bit Unicode character. Range: '\u0000' (0) to '\uffff' (65,535). 

Boolean: Represents one bit of information with two possible values: true or false. 

Non-Primitive Data Type: Reference Data types will contain a memory address of the variable’s values because it is not able to directly store the values in the memory. Types of Non-Primitive are mentioned below: 

Strings 

Array 

Class 

Object 

Interface 

Byte: 

The byte data type in Java is used when you need to work with a small range of integer values and are concerned about memory efficiency. It occupies 1 byte (8 bits) of memory, making it more memory-efficient compared to other integer types like int (which takes 4 bytes) or long (which takes 8 bytes). 

If you are working with large collections of data (like arrays) where memory is a concern and the values fall within the range of byte (from -128 to 127), using byte can save memory. 
What is the default value of byte datatype in Java? The default value of the byte datatype in Java is 0. What is the default value of float and double datatype in Java? The default value of the float is 0.0f and of double is 0.0d in Java. 

Signed Integer 

A signed integer can represent both positive and negative values 

Unsigned Integer 

An unsigned integer can only represent non-negative numbers (positive and zero). 


float is a single-precision 32-bit floating-point data type, whereas double is a double-precision 64-bit floating-point data type. double is more precise and can store larger and more precise decimal numbers compared to float. 

 
Answer: Variable shadowing occurs when a variable declared in a certain scope (e.g., a local variable) has the same name as a variable declared in an outer scope (e.g., an instance variable). The local variable shadows the instance variable within its scope. 

public class ShadowingExample { 

    private int value = 5; // Instance variable 

  

    public void printValue() { 

        int value = 10; // Local variable shadows the instance variable 

        System.out.println("Local value: " + value); 

        System.out.println("Instance value: " + this.value); 

    } 

  

    public static void main(String[] args) { 

        ShadowingExample example = new ShadowingExample(); 

        example.printValue(); 

    } 

} Local value: 10 

Instance value: 5 

The inner variable hides or "shadows" the outer variable within its scope, making the outer variable inaccessible unless explicitly referenced (e.g., using this) 


Explain the concept of final variables in Java. 

Answer: A final variable is a constant; once it has been assigned a value, it cannot be changed. It must be initialized when declared or in the constructor. 


Type casting in Java is a way of converting a variable from one data type to another 

Implicit Type Casting (Widening) 

Implicit type casting, also known as widening or automatic type conversion, happens when Java automatically converts a smaller data type to a larger data type. This is done to prevent loss of information. Since the smaller type can fit into the larger type, there is no need for an explicit cast. 

Explicit Type Casting (Narrowing) 

Explicit type casting, also known as narrowing or manual type conversion, happens when you explicitly convert a larger data type to a smaller data type. This is required when there is a possibility of data loss 

perform explicit type casting, you use the cast operator (type). 

double doubleValue = 42.9; 

int intValue = (int) doubleValue; // Explicit casting from double to int 

ClassCastException: When casting objects, you need to be careful. If you try to cast an object to an incompatible type, Java will throw a ClassCastException. 


When Does ClassCastException Occur? 

Incorrect Downcasting: 

When you try to downcast an object to a subclass it is not an instance of. 

Use instanceof Before Casting: 

Always check the type of an object using instanceof before performing a cast 


And , 
Type casting can be categorized into two types: compile-time checking and runtime checking. 

1. Compile-time Checking (Static Casting) 

Definition: Compile-time checking occurs during the compilation phase. The Java compiler verifies whether the cast is valid or not before the code is run 

2. Runtime Checking (Dynamic Casting) 

Definition: Runtime checking occurs when the program is running. The Java Virtual Machine (JVM) checks if the cast is valid during execution. 

Example: When down casting, if the actual object type is not compatible, a ClassCastException will be thrown at runtime. Method: This is often done using the instanceof operator to avoid exceptions. 

 
Cohesion 
Cohesion refers to how closely related and focused the responsibilities of a single module, class, or component are. 
It measures the degree to which elements of a module belong together.  
High cohesion within a module means that its functions are closely related and work together to fulfill a single purpose. 


Note: Synchronization is nothing but putting a lock on an object , 
eg: booking for a particular seat by multiple people, by paying (which is a lock)  
so consistency-maintained  
 
Types of Cohesion: 

Functional Cohesion: All elements of the module work together to perform a single well-defined task. This is the highest level of cohesion. 

Eg: A class that processes user authentication. 

Sequential Cohesion: Elements are related such that the output from one part serves as the input for another. 

Communicational Cohesion: All elements operate on the same data but do not necessarily work together to perform a single task. 

Temporal Cohesion: Elements are related by being executed at the same time, such as initialization tasks. 

Logical Cohesion: Elements are related logically and perform similar functions but are not related to a single task. 

Coincidental Cohesion: Elements are grouped arbitrarily; there is no meaningful relationship. This is the lowest level of cohesion. 

Coupling 

Coupling refers to the degree of direct knowledge that one module has about another. 

Low coupling is desired, as it indicates that changes in one module will have minimal impact on others. 

Content Coupling: One module accesses or modifies the data of another module. This is the highest and most undesirable level of coupling. 

Common Coupling: Multiple modules share the same global data. 

External Coupling: Modules depend on external systems or resources, like files or databases. 

Control Coupling: One module controls the behavior of another by passing it information on what to do (control flags). 

Data Coupling: Modules share data but only through parameters. Each module has its own data structure. 

Message Coupling: The lowest level of coupling, where modules communicate solely through messages (like method calls). 

Note: 

Aim for high cohesion within modules to ensure they have a well-defined purpose. 

Aim for low coupling between modules to minimize dependencies. 

Answer: == compares the reference or memory address (for reference types) or value (for primitive types), while. equals() compares the actual content or value of the objects. 

Note : 
We can declare the return type for the constructor, but it should be void. 

False: Constructors do not have a return type, not even void.  

 
What is a default constructor in Java? 

Answer: A default constructor is a no-argument constructor automatically provided by the compiler if no constructors are explicitly defined in the class. 

In detail about  
Automatic Generation: If a class does not explicitly define any constructor, the Java compiler automatically provides a default constructor. This constructor is a no-argument constructor that initializes the object with default values. 

The default constructor does not take any parameters. 

Access Modifier: The access modifier for the default constructor is the same as the class modifier: 

If the class is public, the default constructor is public. 

If the class has no explicit modifier (default access), the default constructor will also have default access. 

Super Constructor Call: The default constructor contains a single line of code, which is an implicit call to the superclass's no-argument constructor (super ();  

If you define at least one constructor (with or without parameters), the compiler does not generate a default constructor 

Note : “Inheritance concept is not applicable for constructors and hence overriding concept also not applicable to the constructors. But constructors can be overloaded”. However, a child class can call a parent class's constructor. 
 

Type inference  
Type inference in Java is a feature that allows the compiler to automatically determine the type of a variable based on the context in which it is used 


Type inference in Java, introduced with the var keyword, simplifies code by allowing the compiler to determine the type of local variables automatically based on their assigned values. This feature improves code readability and reduces the need for repetitive type declaration 


What are the limitations of arrays? 

Answer: 

Fixed Size: The size of an array cannot be changed once it is created. 

Single Data Type: An array can only hold elements of the same data type. 

No Built-in Bound Checking: no in-build Java does not perform bound checking beyond throwing an Array Index Out of Bounds Exception. 

What is a jagged array in Java? 

Answer: A jagged array is an array of arrays where the sub-arrays can have different lengths. It is also known as a "ragged" array. 

int[][] jaggedArray = new int[3][]; 

jaggedArray[0] = new int[2]; // First row has 2 elements 

jaggedArray[1] = new int[3]; // Second row has 3 elements 

jaggedArray[2] = new int[4]; // Third row has 4 elements 

 
In Java, an array is declared using the syntax type[] arrayName;, where: 

type is the data type of the elements you want to store in the array (e.g., int, String, double). 

arrayName is the name of the array variable 

 
int[] numbers; // Declares an array of integers 

String[] names; // Declares an array of Strings 

Shallow Copy 

Definition: A shallow copy creates a new object that is a copy of the original object, 
but it copies only the references to the objects contained within the original object. Therefore, the original and the copied object share references to the same objects. 

Implication: Changes made to the mutable objects in the original will be reflected in the shallow copy and vice versa. 

 
Deep Copy 

Definition: A deep copy creates a new object and recursively copies all objects contained within the original object. This means that the original and the copied object do not share references; they are entirely independent. 

Implication:  
Changes made to the mutable objects in the original will not affect the deep copy. 

Cloning 

Definition: Cloning in Java refers to creating a copy of an object. This is typically achieved using the clone () method provided by the Object class. 

Implementation: For an object to be cloned, it must implement the Cloneable interface, and the 
clone () method must be overridden to handle deep copying if necessary. 

Garbage Collection (GC) in Java is an automatic process designed to manage memory by reclaiming memory that is no longer in use or reachable by the application.  
The primary purpose of garbage collection is to free up memory resources by identifying and disposing of objects that are no longer needed, thus preventing memory leaks and optimizing the performance of the application. 


Main: When is Garbage Collection Used? 

Garbage collection is used during the lifecycle of a Java application to automatically manage memory. 
The Java Virtual Machine (JVM) invokes the garbage collector periodically, or when memory usage reaches a certain threshold. 

Java developers do not need to explicitly free memory, as the garbage collector handles it automatically.  

Mark and Sweep Algorithm: 

One common garbage collection algorithm is the mark and sweep. During the "mark" phase, the garbage collector identifies which objects are still reachable from the root set (e.g., local variables, active threads). During the "sweep" phase, it reclaims the memory occupied by objects that are not marked as reachable. 

Garbage collection can be triggered automatically by the JVM or manually by calling System.gc() 

The Runtime.getRuntime().gc() method in Java is used to suggest to the Java Virtual Machine (JVM) that it perform garbage collection. It is a more explicit way of requesting garbage collection compared to System.gc() 


Pass by Value 

Pass by value means that a copy of the variable's actual value is passed to the method. Any changes made to the parameter inside the method do not affect the original value. 

Pass by reference  

Pass by reference means that a reference (or address) to the actual variable is passed to the method. Changes made to the parameter inside the method affect the original variable. 

 
Rule for flow: 

1.Before executing any constructor, Java first initializes the instance variables defined in the parent class. This includes executing any instance initialization blocks present in the parent class.  

2.Execution of Parent Class Constructor: 

After initializing the parent class's instance variables and blocks, Java calls the parent class constructor (either the default or the one defined by the programmer). 

3.Once the parent class constructor has completed execution, the control returns to the child class. At this stage, Java initializes the instance variables defined in the child class, followed by executing any instance initialization blocks present in the child class.  

4.Finally, Java calls the child class constructor. This constructor can use both the parent class's members (which have been initialized in the earlier steps) and its own members. 
 
Access Modifiers 

public 

Class Level: If a class is declared public, it can be accessed from any other class in any package. 

Member Level: If a class member (method, variable) is declared public, it can be accessed from any other class in any package. 

private 

Class Level: A top-level class cannot be declared private. 

Member Level: If a class member is declared private, it can only be accessed within the class in which it is declared. It is not visible to any other class. 

protected 

Class Level: A top-level class cannot be declared protected. 

Member Level: If a class member is declared protected, it can be accessed within its own package (like package-private) and by subclasses, even if they are in different packages 

default (package-private) 

Class Level: If no access modifier is specified, the class is accessible only within its own package. 

Member Level: If no access modifier is specified, the member is accessible only within its own package. 

Non – access modifiers: 
static 

Description: Indicates that a member belongs to the class rather than instances of the class 

final 

Description: Indicates that the  
variable's value cannot be changed once assigned (for variables), 
the method cannot be overridden (for methods),  
and the class cannot be inherited (for classes). 

synchronized 

Description: Indicates that a method or block of code can only be accessed by one thread at a time, providing thread safety. 

volatile 

Description: Indicates that a variable's value may be changed by different threads. It ensures that the variable is always read from the main memory and not cached. And other threads all be visible and known of the changes 
 
Transient: 

The transient keyword in Java is used to indicate that a variable should not be serialized. Serialization is the process of converting an object into a byte stream to save it to a file or send it over a network.  

Ex:password (When a variable is declared as transient, it will not be included in the serialized representation of the object. This is useful for fields that contain sensitive information or temporary data that should not be saved.)  
private transient String password; // Will not be serialized 

Excluding fields from serialization can help maintain security, 


What is Nested class: 
In Java, a class can be defined within another class. Such classes are known as nested classes. Nested classes are divided into two categories: 

Static Nested Classes 

Non-Static Nested Classes (also known as Inner Classes). 
 

Static Nested Classes 

A static nested class is a static member of the outer class. It can access static members of the outer class, including private static members. However, it cannot directly access instance variables and methods of the outer class; it must use an object reference to do so. 

Non-Static Nested Classes (Inner Classes) 

Non-static nested classes, also known as inner classes, are associated with an instance of the enclosing (outer) class. They can access the instance members of the outer class, including private members. Inner classes are used to logically group classes that are only used in one place, increase encapsulation, and lead to more readable and maintainable code. 

Member Inner Class 

Local Inner Class 

Anonymous Inner Class 

Member Inner Class 

A member inner class is defined within the body of the outer class. It can access all members (including private) of the outer class. 

A local inner class is defined within a method or a block of code. It can only be instantiated within that method or block. Local inner classes can access local variables of the enclosing scope if they are declared final or effectively final. 

Anonymous Inner Class 

An anonymous inner class is a local inner class without a name and for which only a single object is created.  

Note:  

Calling Method: methodB() 

This is the method that is currently executing and is making a call to another method (methodC()). 

Called Method: methodC() 

This is the method that is being invoked (or called) by methodB(). It will execute once methodB() reaches the line methodC();. 

In final : 
Calling Method: methodB() (the one that invokes another method) 

Called Method: methodC() (the one that gets invoked) 

 
2.Method A calls itself, which is known as recursion. 

class RecursiveExample { 

    // Recursive method to calculate factorial 

    public int factorial(int n) { 

        if (n == 0) { 

            return 1; // Base case 

        } else { 

            return n * factorial(n - 1); // Recursive call 

        } 

    } 

    public static void main(String[] args) { 

        RecursiveExample example = new RecursiveExample(); 

        int result = example.factorial(5); 

        System.out.println("Factorial of 5 is: " + result); 

    } 

} 


A constructor in Java is responsible for initializing an object. If a constructor calls itself (or another constructor in the same class or another class), it can result in an infinite loop of constructor calls. 

public MyClass() { 

// Recursive call to the constructor 

this(); 

} 

How it internally works? 

The JVM maintains a call stack for method invocations, including constructor calls. 

Each time a constructor is called, it is pushed onto the stack. 

In the case of recursive constructor invocation, the same constructor keeps getting pushed onto the stack repeatedly. 

Eventually, the stack exceeds its limit (known as stack overflow), and a StackOverflowError is thrown. 
 

2)In normal constructor chaining (like calling another constructor in the same class or a superclass), there is usually a base case that terminates the recursion. 

Without any base case or stopping condition, the recursion will continue indefinitely. 

 
Method Invocation: When a method is called from another method, the control flow moves to the called method, executes its statements, and then returns to the calling method once the called method completes. 

Advantages of Nested Calls 

Modularity: Breaking down complex tasks into smaller, manageable methods. 

Code Reusability: Methods can be called from multiple places. 

Recursion: When a method calls itself, it is important to ensure that there is a base case that stops the recursion; otherwise, it can lead to a StackOverflowError.  
 

Questions: 

What is a Java package? 

A package is a namespace that organizes a set of related classes and interfaces. It helps avoid naming conflicts and can control access. 

What if the main method is declared as private? 
No Access from the JVM: 

The JVM requires the main method to be public in order to access it and start the execution of the program. 

If you declare it as private, the JVM cannot see or call it, leading to an error when trying to run the program 

Error: Main method not found in class YourClassName, please define the main method as: 

public static void main(String[] args) 

public: 

This is an access modifier. Declaring the main method as public means that it can be accessed from anywhere, particularly by the Java Virtual Machine (JVM) when it starts executing your program.  

The static keyword indicates that this method belongs to the class itself rather than to any specific instance of the class. If the static modifier is removed from the signature of the main method in a Java program, you will encounter a NoSuchMethodError when trying to run the program. 

The void keyword signifies that the main method does not return any value 

main: 

This is the name of the method. The name main is special in Java; the JVM looks specifically for this method as the starting point of the application. 

String [] args: This parameter is an array of String objects. It allows the program to accept command-line arguments. 

What if I do not provide the String array as the argument to the method? A:Program compiles but throws a runtime error "NoSuchMethodError". 

1. java.lang Package 

This is the most fundamental package in Java and is automatically imported into every Java program. It contains classes that are fundamental to the design of the Java programming language. 

Key Classes: 

Object: The root class of all classes in Java. 

String: Represents a sequence of characters. 

System: Contains useful class fields and methods, including System.out for standard output. 

Note: The JVM ensures that a class is loaded only once during runtime, maintaining efficient memory usage and preventing duplicate class definitions. 

Inner classes: 

In Java, inner classes are defined within the body of another class  

1.Non-static Inner Class (Member Inner Class) 

Definition: A non-static inner class is associated with an instance of its enclosing class. 
 
It can access both static and instance variables and methods of the enclosing class 

class OuterClass { 

    private String outerField = "Outer field"; 

    class InnerClass { 

        void display() { 

            System.out.println("Accessing: " + outerField); 

        } 

    } 

} 

public class Main { 

    public static void main(String[] args) { 

        OuterClass outer = new OuterClass(); 

        OuterClass.InnerClass inner = outer.new InnerClass(); 

        inner.display();  // Output: Accessing: Outer field 

    } 

} 

2.Definition: A static nested class is defined with the static keyword and does not have a reference to an instance of the outer class. It can access only the static members of the outer class. 

class OuterClass { 

    static String staticOuterField = "Static outer field"; 
    static class StaticNestedClass { 

        void display() { 

            System.out.println("Accessing: " + staticOuterField); 

        } 

    } 

} 

public class Main { 

    public static void main(String[] args) { 

        OuterClass.StaticNestedClass nested = new OuterClass.StaticNestedClass(); 

        nested.display();  // Output: Accessing: Static outer field 

    } 

} 

3. Method Local Inner Class 

Definition: A method local inner class is defined within a method and can access local variables of the method that are declared as final or effectively final, as well as the instance variables of the outer class. 

class OuterClass { 

    void outerMethod() { 

        final String localVariable = "Local variable"; 

        class MethodLocalInnerClass { 

            void display() { 

                System.out.println("Accessing: " + localVariable); 

            } 

        } 

        MethodLocalInnerClass inner = new MethodLocalInnerClass(); 

        inner.display();  // Output: Accessing: Local variable 

    } 

} 

  

public class Main { 

    public static void main(String[] args) { 

        OuterClass outer = new OuterClass(); 

        outer.outerMethod(); 

    } 

}  

4. Anonymous Inner Class 

Definition: An anonymous inner class is declared without a class name and is used to instantiate classes or interfaces on the fly. It can extend a class or implement an interface. 

 

interface Greeting { 

    void sayHello(); 

} 

public class Main { 

    public static void main(String[] args) { 

        Greeting greeting = new Greeting() { 

            @Override 

            public void sayHello() { 

                System.out.println("Hello from anonymous inner class!"); 

            } 

        }; 

        greeting.sayHello();  // Output: Hello from anonymous inner class! 

    } 

} 

Are the imports checked for validity at compile time? 

Yes, imports in Java are checked for validity at compile time. The Java compiler ensures that the classes or packages specified in the import statements are available and can be resolved. If an import statement refers to a class or package that does not exist or is not accessible, the compiler will generate an error, and the code will not compile. 


Declaration and definition are two concepts in programming that relate to how variables are handled. 

Definition: A variable declaration introduces a variable by specifying its name and data type. It informs the compiler about the variable’s type but does not allocate memory for it 

int number; // Declaration of variable 'number' of type int 

Definition: 

Definition: A variable definition allocates memory for the variable and may also initialize it with a value. It combines both the declaration and the initialization of the variable.  

int number = 10; // Definition of variable 'number' with an initial value of 10 

*) In Java, instance variables (also known as member variables) have default values if they are not explicitly initialized. Here’s a breakdown of the default values for various data types in Java: 

Default Values  

Data Type 

Default Value 

boolean 

false 

byte 

0 

short 

0 

int 

0 

long 

0L 

float 

0.0f 

double 

0.0d 

char 

'\u0000' (null character) 

Object References 

null 

1. Local Variables 

Local variables are variables declared within a method, constructor, or block. Unlike instance variables, local variables do not have default values 

No Default Value: Local variables must be initialized before use. If not, the compiler will give a compile-time error. 

int localVar; // Local variable (not initialized) 

// System.out.println(localVar); // This would cause a compile-time error 

localVar = 10; // Must initialize before use 

System.out.println("Local variable: " + localVar); // Output: 10c 

2. Static Variables 

Static variables are declared with the static keyword. They belong to the class rather than to any specific instance of the class. Static variables are initialized when the class is loaded, and they have default values similar to instance variables. 

Top-Level Classes: Can only be public or package-private. 

Inner Classes: Can be public, protected, private, or package-private. 

Instead of using raw types, you can specify a type parameter that can be replaced with a specific type when an instance of the class or method is created. 

But Arrays are always type safe that is we can provide the guarantee for the type of elements present inside array. 
 
For example, if our programming requirement is to hold String type of objects it is recommended to use String array. In the case of string array, we can add only string type of objects by mistake if we are trying to add any other type we will get compile time error. 

But collections are not type safe that is we can’t provide any guarantee for the type of elements present inside collection for this reason the generics have been introduced. 
Since the compiler does not check the types of elements in non-generic collections, any type-related issues are caught only at runtime, making it difficult to debug and leading to the possibility of ClassCastException. 
 
Type Safety: 

Generics in Java is a language feature that allows developers to define classes, interfaces, and methods with a type parameter, enabling them to work with any data type while providing compile-time type safety. 

By using generics, you can create code that is flexible, reusable, and type-safe, minimizing runtime errors related to type mismatches. 
Generics enable compile-time type checking, reducing the risk of Class Cast Exception at runtime. By specifying a type, the compiler can ensure that only compatible types are used 

List<String> stringList = new ArrayList<>() 

List: This is the base type (or the reference type). It is an interface in Java that defines a collection of ordered elements. 

String: This is the parameter type (or type parameter) of the generic List.It specifies the type of elements that can be stored in the list. 

Types:  
Bounded types in Java generics allow you to restrict the types that can be used as type parameters 

1.Upper Bounded Types: You can specify that a type parameter must be a specific type or a subtype of that type. This is done using the extends keyword. 

eg : class Box<T extends Number> { 

ie) In this example, T can only be Number or its subclasses (Integer, Double, etc.). This means you can create a Box<Integer>, Box<Double>, but not Box<String>. 

2.Lower Bounded Types: 

You can specify that a type parameter must be a specific type or a supertype of that type using the super keyword. This is less commonly used compared to upper bounds. 

void addNumbers(List<? super Integer> list)  

ie) In this example, the method addNumbers accepts a list that can hold Integer or any supertype of Integer (like Number or Object). 

3.Multiple Bounds: 

You can also specify multiple upper bounds for a type parameter, separating them with &. 

eg : class MultiBound<T extends Number & Comparable<T>> { 

Here, T must be a subclass of Number and also implement the Comparable interface. 

Usage: 
Compile-Time Checking: With generics, the compiler checks the type of elements being added to the collection. If you try to add an element of a different type, the compiler will raise an error, thus preventing potential runtime issues. Prevent ClassCastException 

Code Reusability: Generics allow you to create a single class or method that can work with different types, reducing code duplication. 

Note: • Generics concept is applicable only at compile time, at runtime there is no such type of concept. 

Classes in Java are used to convert primitive data types into reference types (objects). 

byte → Byte 

short → Short 

int → Integer 

long → Long 

float → Float 

double → Double 

char → Character 

boolean → Boolean  

Wrapper classes in Java are used to convert primitive data types into objects. Each of the eight primitive data types has a corresponding wrapper class in the java.lang package 

Collections and Generics: Collections in Java, such as ArrayList, can only store objects, not primitive types. Wrapper classes allow primitives to be stored in collections. 

Synchronization: Primitive types cannot be synchronized, but wrapper objects can be. 

Using wrapper classes allows the use of null as a default value 
Mian: 
A wrapper class in Java is an object representation of primitive data types. It provides a way to use primitive types (like int, float, etc.) as objects. Each primitive type in Java has a corresponding wrapper class in the java.lang package.Wrapper class objects are immutable 


wrapper classes serve several important purposes: 

1.In Java, collections (such as ArrayList, HashMap, etc.) can only hold objects, not primitive types. Wrapper classes allow you to store primitive data types as objects in these collections. 

List<Integer> numbers = new ArrayList<>();  

numbers.add(10); // Autoboxing from int to Integer 

Wrapper classes can be assigned null 

2.Autoboxing is the automatic conversion of a primitive type into its corresponding wrapper class. 

3.Unboxing is the reverse process, where an object of a wrapper class is converted back into its corresponding primitive type. 

4. Utility Methods in Wrapper Classes 

Utility Functions: Wrapper classes (like Integer, Double, Character, etc.) come with a variety of utility methods that simplify tasks such as parsing, formatting, and conversion. 

Example: The Integer class provides methods like parseInt() and toString(), which can be very useful. 

Generics Require Objects (Not Primitives): 

Java generics work with objects, but primitive types (like int, char, boolean, etc.) cannot be used with generics directly because they are not objects. 

This is where wrapper classes come in. Each primitive type has a corresponding wrapper class (e.g., Integer for int, Double for double), which allows you to use primitive data types as objects. 

Why do we need wrapper classes? 

The wrapper class is an object class that encapsulates the primitive data types, and we need them for the following reasons: 

Wrapper classes are final and immutable 

Provides methods like valueOf(), parseInt(), etc. 

It provides the features of autoboxing and unboxing. 

inner class: Java, an inner class is a class defined within another class. Inner classes can be useful for logically grouping classes that are only used in one place, and they can access the members (including private members) of the outer class 

Sure, I'll organize and provide clear explanations for each type of inner class along with examples and a real-world analogy where applicable. 

  
### 1. Normal (or Regular) Inner Class   
Definition: 

- A named class declared inside another class directly without the `static` modifier. 

- Can access all members of the outer class, including private ones. 

Example: 

class Outer { 

    class Inner { 

        void display() { 

            System.out.println("This is an inner class."); 

        } 
    } 
    public static void main(String[] args) { 

        Outer outer = new Outer(); 

        Outer.Inner inner = outer.new Inner(); 

        inner.display(); // Outputs: This is an inner class. 

    } 

} 

Real-World Example: 
Imagine a banking system where an `Account` class represents a bank account, and an `Transaction` inner class represents transactions on that account. Each `Transaction` is tied to a specific `Account` and has access to the account's details. 

2. Method Local Inner Class 
Definition: 

- A class declared inside a method. 

- Can access final or effectively final variables of the method it is defined in. 

Example: 

class Outer { 
    void myMethod() { 
        final int num = 100; 
        class MethodLocalInner { 

            void print() { 

                System.out.println("This is a method local inner class. Num: " + num); 
            } 

        } 
        MethodLocalInner inner = new MethodLocalInner(); 
        inner.print(); // Outputs: This is a method local inner class. Num: 100 

    } 
    public static void main(String[] args) { 
        Outer outer = new Outer(); 
        outer.myMethod(); 
    } 

} 

3. Anonymous Inner Class 

Anonymous inner classes: • Sometimes we can declare inner class without name such type of inner classes are called anonymous inner classes. • The main objective of anonymous inner classes is “just for instant use”.  

• There are 3 types of anonymous inner classes  

1) Anonymous inner class that extends a class.  

2) Anonymous inner class that implements an interface.  

3) Anonymous inner class that defined inside method argument 

- A class declared and instantiated in a single statement using the `new` keyword. 

1. Anonymous Inner Class that Extends a Class 

This type of anonymous inner class is used to extend an existing class. You create an instance of the anonymous inner class that extends a superclass and override its methods if necessary. 

2.. Anonymous Inner Class that Implements an Interface 

This type of anonymous inner class is used to provide an implementation for an interface. You create an instance of the anonymous inner class that implements the interface and override its methods. 

3.Anonymous Inner Class Defined Inside a Method Argument 

This type of anonymous inner class is used to create an instance of the class within the argument of a method call 
Example: 

public class OuterClass { 

    void createAnonymousClass() { 

        Runnable r = new Runnable() { 

            @Override 

            public void run() { 

                System.out.println("Running in an anonymous inner class"); 

            } 

        }; 
        Thread thread = new Thread(r); 

        thread.start(); // Outputs: Running in an anonymous inner class 

    } 
    public static void main(String[] args) { 

        OuterClass outer = new OuterClass(); 

        outer.createAnonymousClass(); 

    } 

} 

Real-World Example: 

Imagine a graphical user interface (GUI) application where you have a button that, when clicked, performs a specific action. To handle the button click event, you can use an anonymous inner class to implement the event listener interface. 

4. Static Nested Class 

- A class declared inside another class with the `static` keyword. 

- Cannot access non-static members of the outer class. 

- Can be instantiated without an instance of the outer class. 

 class Outer { 
    static class StaticNestedClass { 
        void display() { 
            System.out.println("This is a static nested class."); 
        } 

    } 

    public static void main(String[] args) { 
        Outer.StaticNestedClass nested = new Outer.StaticNestedClass(); 
        nested.display(); // Outputs: This is a static nested class. 
    } 

} 

Why inner is a Has-A relationship? 

These types of inner classes provide flexibility and organization within Java programs, allowing for a more structured and encapsulated code design. Yes, the relationship between an outer class and an inner class in Java is indeed a Has-A relationship, Has-A Relationship: This relationship indicates that an object contains or has a reference to another object. In the context of classes, it means that one class (the outer class) contains an instance of another class (the inner class). 

eg : where a car (the outer class) has an engine (the inner class).  

An instance of the outer class Car is created first: Car car = new Car();. 

An instance of the inner class Engine is then created using the outer class instance: Car.Engine engine = car.new Engine();. 

Access: An instance of the inner class is tied to an instance of the outer class, demonstrating a containment relationship. 

Constructor 

Definition: A constructor is a special method that is called when an object is instantiated. It has the same name as the class and does not have a return type 

Invocation: Constructors are invoked when an object is created using the new keyword. 

Can Be Overloaded: Constructors can be overloaded, meaning you can have multiple constructors with different parameters in the same class. 

Access Modifiers: Constructors can have access modifiers (public, private, etc.), controlling the visibility of the constructor. 

Definition: An instance initializer block is a block of code inside a class that is not a method or constructor. It is enclosed in braces {}. 

Purpose: It is used for initializing instance variables or executing code that should run every time an object is created, before the constructor is executed. 

Invocation: Instance blocks are executed when an object is created, before the constructor of the class is executed. 

Cannot Be Overloaded: Instance blocks cannot be overloaded; there can be only one instance block in the class, but you can have multiple instance blocks. 

No Access Modifiers: Instance blocks cannot have access modifiers; they are always considered to be accessible. 

Why java is not pure object oriented paradigm? 
Pure OOP: In a pure object-oriented language, everything must be an object.Java includes eight primitive data types (e.g., int, char, float, double, boolean, byte, short, long). These primitive types are not objects, and they cannot be subclassed, extended, or manipulated like objects. 

Java's Support for Static Methods/Variables: Java allows methods and variables to be defined as static. Static members belong to the class itself rather than to instances (objects) of the class. This means that static methods and variables can be accessed without creating an instance of the class, which breaks the idea that every operation in an object-oriented language should be tied to an object. 
