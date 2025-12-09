What is a Design pattern?

A design pattern in software development is a general, reusable solution to a commonly occurring problem within a given context in software design. It is not a finished design that can be transformed directly into code, but rather a template or guideline that can be adapted to solve specific design issues.

Key Characteristics:
* Proven Solutions: Design patterns are based on best practices and have been tested in real-world applications.
* Categories: They are typically categorized into three types:
  * Creational Patterns: Deal with object creation mechanisms (e.g., Singleton, Factory).
  * Structural Patterns: Focus on how objects and classes are composed to form larger structures (e.g., Adapter, Composite).
  * Behavioral Patterns: Concerned with the interaction and responsibility between objects (e.g., Observer, Strategy).
Using design patterns helps developers create more maintainable, flexible, and scalable software systems.


## Singleton Pattern

`This is a creational pattern that ensures a class has only one instance and provides a global point of access to it.`

Singleton Design Pattern

* The Singleton pattern restricts a class to a single instance, which is crucial for scenarios like user preferences in applications to avoid conflicts.
* It is implemented by using a private constructor to prevent external instantiation and a public method (often named `getInstance`) to control access to the instance.

Implementation Details

* A private class variable (e.g., `uniqueInstance`) holds the single instance, and the `getInstance` method checks if this variable is null before creating a new instance.
* This method ensures that if an instance already exists, it returns that instance, thus maintaining the Singleton property.
Advantages and Considerations

The Singleton pattern allows for lazy creation, meaning the instance is created only when needed, which can improve efficiency.
However, it may introduce issues in multi-threaded environments where multiple threads might attempt to access the Singleton instance simultaneously.
Overall, the Singleton pattern is useful in scenarios where a single point of control is necessary, such as managing application settings, logging, or coordinating access to shared resources.

For eg.

```
 public class Logger {
 
     private static Logger instance;
 
     private Logger() {}
 
     public static Logger getInstance() {
         if (instance == null) {
             instance = new Logger();
         }
         return instance;
     }
 
     public void log(String message) {
         System.out.println("LOG: " + message);
     }
 }
```

## Factory Method Pattern

`The Factory Method Pattern is a creational design pattern that defines an interface for creating an object, but lets subclasses decide which class to instantiate.`

Factory Method Pattern, which is a way to create objects in programming. Imagine you own a bakery that makes different types of cakes. Instead of baking each cake yourself every time someone orders, you have a special cake-making machine (the factory) that knows how to create different cakes based on the order. This makes your job easier because you can focus on decorating the cakes instead of baking them.

In programming, the Factory Method Pattern works similarly. Instead of writing code to create each type of object (like a cake), you create a method in a class that decides which object to create. This way, if you want to add a new type of cake (or object), you only need to update the factory method, not every part of your code that uses cakes. This keeps your code clean and makes it easier to manage.

The Structure goes like this 

<img width="808" height="447" alt="Image" src="https://github.com/user-attachments/assets/ef5dcca8-19aa-40d4-91f1-15812cb4a12a" />

    | Role            | Purpose                       |
    | --------------- | ----------------------------- |
    | Product         | Interface or abstract class   |
    | ConcreteProduct | Implements the product        |
    | Creator         | Declares the factory method   |
    | ConcreteCreator | Implements the factory method |

* Product - It is the rule book that all real products must follow. We create an interface that only contains method declarations (no logic)

    ```
    public interface Payment {
        void pay(double amount);
    }
    ```

* ConcreteProduct - These are the actual objects that do the real work. Then we create classes that implement the interface

    ```
    public class CreditCardPayment implements Payment {
        @Override
        public void pay(double amount) {
            System.out.println("Paid $" + amount + " using Credit Card");
        }
    }
    ```

    ```
    public class UpiPayment implements Payment {
        @Override
        public void pay(double amount) {
            System.out.println("Paid ₹" + amount + " using UPI");
        }
    }
    ```

* Creator - This is the object creator blueprint, but it does not create real objects itself. We do NOT create objects here.
We only create a rule that says: “Every factory must create a Payment object.”

    ```
    public abstract class PaymentFactory {

        // Factory Method
        public abstract Payment createPayment();

        // Business logic using the factory method
        public void processPayment(double amount) {
            Payment payment = createPayment();
            payment.pay(amount);
        }
    }
    ```


* ConcreteCreator - This is the class that actually builds the object.

    ```
    public class CreditCardFactory extends PaymentFactory {
        @Override
        public Payment createPayment() {
            return new CreditCardPayment();
        }
    }
    ```

    ```
    public class UpiFactory extends PaymentFactory {
        @Override
        public Payment createPayment() {
            return new UpiPayment();
        }
    }
    ```

Client code looks like 

```
public class FactoryMethodDemo {

    public static void main(String[] args) {

        PaymentFactory factory1 = new CreditCardFactory();
        factory1.processPayment(1500.00);

        PaymentFactory factory2 = new UpiFactory();
        factory2.processPayment(500.00);
    }
}
```