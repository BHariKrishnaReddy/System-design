# Design Patterns

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

## Facade Pattern

This design pattern simplifies interactions between client classes and complex subsystems.

Facade Design Pattern

* The facade pattern provides a single, simplified interface for client classes, making complex systems easier to use.
It acts as a wrapper class that encapsulates the subsystem, hiding its complexity from the client.

Implementation Steps

* Design an interface that will be implemented by different classes, which remain hidden from the client.
* Implement the interface with classes that represent different functionalities, such as checking, saving, and investment accounts.
* Create a facade class that wraps these implementations, providing a simplified interface for client classes to interact with the subsystem.
* Client classes use the facade to access functionalities without needing to manage the complexities of the subsystem directly.


## Adapter Pattern

`Addresses compatibility issues between different software systems.`

Adapter Design Pattern

* The adapter design pattern allows communication between incompatible software interfaces, similar to how physical adapters connect different types of connectors.
* It consists of three main components: the client class (which wants to use an external system), the adaptee (the external system), and the adapter class (which translates requests between the client and adaptee).

Implementation Steps

* Step 1: Design the target interface that the adapter will implement for the client.
* Step 2: Implement the target interface in the adapter class, which converts the client's object into the required format (e.g., JSON).
* Step 3: The client sends requests to the adapter using the target interface, allowing the adapter to handle the communication with the adaptee without the client needing to know its specifics.

Benefits of Using an Adapter

* The adapter pattern allows existing systems to integrate with new third-party libraries or external systems without requiring significant changes to the existing codebase.
* It helps maintain system stability by preventing direct modifications to interfaces that may affect other parts of the system.

## Composite Pattern

`This is used to create tree-like structures of objects while treating individual types uniformly.`

Composite Design Pattern

* It allows for the composition of nested structures of objects and uniform handling of these objects through a common interface.
* The pattern consists of a component interface, composite classes, and leaf classes, enabling polymorphism.

Structure and Implementation

* The component interface serves as a supertype for all classes, ensuring they can be treated uniformly.
* Composite classes can contain other composite or leaf objects, allowing for recursive composition, visualized as a tree structure.

Example Application

* Using buildings as an example, the component interface can represent buildings, floors, and rooms, with the housing class as the composite and rooms as leaf classes.
* The implementation in Java involves defining the interface, creating the composite class with methods for managing components, and implementing the leaf class without component management methods.
* In summary, the Composite Design Pattern simplifies the management of complex structures by enforcing a common type across components, facilitating easier manipulation and understanding of the code.

## Proxy Pattern

`This is used in software systems to create a simplified representation of a real object.`

Proxy Design Pattern

* A proxy object acts as a lightweight version of the original object, allowing for delegation of requests to the real object.
* It is beneficial in scenarios where the real object is resource-intensive to instantiate or contains sensitive information.

Common Scenarios for Proxy Usage

* Virtual Proxy: Used for resource-intensive objects, such as high-definition images, to manage system resources effectively.
* Protection Proxy: Controls access to the real object, ensuring users can only access functions permitted by their roles.
* Remote Proxy: Represents a real object that exists remotely, allowing local interaction with a remote system.

Implementation Steps

* Design the subject interface that both the proxy and real subject classes will implement.
* Implement the real subject class, which handles the core functionality.
* Implement the proxy class, which manages requests and checks conditions before delegating to the real subject.
* The proxy design pattern enhances system security, resource management, and separation of concerns in software applications.

## Decorator Pattern

`This allows for dynamic behavior modification of objects at runtime through aggregation.`

Decorator Design Pattern

* The decorator pattern enables the addition of behaviors to objects without altering their structure, using a "has a" relationship to create a stack of objects.
* Each object in the stack can augment the behavior of the object below it, allowing for flexible combinations of functionalities.

Implementation Steps

* Define a component interface that all classes will implement, ensuring a common type.
* Create a concrete component class that implements the interface and serves as the base object.
* Develop an abstract decorator class that aggregates other components, allowing for stacking.
* Implement concrete decorators that inherit from the abstract class, each adding specific behaviors.

Example Application

* The pattern can be applied to web pages, where a basic page can be enhanced with various behaviors (like authorization) without creating multiple subclasses for every combination of features. This reduces complexity and improves maintainability.

# Behavioural Design Patterns

## Template Method Patterns

* Behavioral patterns define how objects interact and communicate to fulfill a specific purpose, similar to how employees in a company have defined roles.
* These patterns help in organizing and structuring code to ensure effective collaboration among objects.

Template Method Pattern

* The template method pattern outlines a general algorithm's steps while allowing subclasses to implement specific details.

Implementation in Java

* The PastaDish superclass is abstract, containing a final template method called makeRecipe, which cannot be overridden by subclasses.
* Subclasses like SpaghettiMeatballs and PenneAlfredo implement their specific methods, ensuring consistency and reducing code redundancy.

## Chain of Responsibility Pattern

* The pattern consists of a chain of objects that handle requests, similar to how a patient is referred through various specialists.
* Each handler attempts to process the request; if it cannot, it passes the request to the next handler in the chain.

Example and Application

* An example is provided where tools are tested one by one to find the right one for a task, mirroring how handlers work in the pattern.
* The pattern is useful in scenarios like email filtering, where multiple filters check if a message meets certain criteria.

Design Considerations

* A potential issue arises if a handler fails to pass the request to the next handler, which can be mitigated by using the Template Pattern to ensure consistent handling.
* The Chain of Responsibility helps decouple the sender from the receiver, allowing for flexible request handling without the sender needing to know which handler will process the request.

## State Pattern

* The state pattern allows objects to choose behaviors based on their current state, changing behavior when the state changes.
* It is particularly useful when an object's behavior needs to change at runtime depending on its state.

Implementation in Code

* The implementation involves creating state objects and a vending machine class that tracks the current state.
* The state pattern simplifies code by delegating behavior to state objects, reducing the need for complex conditionals.