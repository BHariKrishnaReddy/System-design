# MVC

Model View Controller

The MVC pattern divids the responsibilitys of a system that offers a user interface into those three parts.

 <img width="1735" height="796" alt="Image" src="https://github.com/user-attachments/assets/6efefe17-de2a-4d83-8e34-0c82ff1b4919" />
 <br>
<img width="1629" height="478" alt="Image" src="https://github.com/user-attachments/assets/0a5c37c7-deb5-4c47-81b5-a7cd82e8d523" />

Separation of Concerns

The MVC pattern emphasizes the separation of concerns, allowing the Model, View, and Controller to operate independently.
This separation makes the code cleaner, easier to maintain, and allows different teams to work on the front end and back end simultaneously.

# Liskov Substitution Principle (LSP)

* If B is a subtype of A, you should be able to use B anywhere you use A—and the program should still behave correctly.
* So a “child class” must not break expectations set by the “parent class” When someone reads your code and sees a type A, they assume certain behavior.If you pass an object of type B (a subclass), it must still honor those assumptions.
* If it changes the meaning, throws new errors in normal situations, or needs extra conditions like “only works if…”, it’s violating LSP.

### Simple example (classic)
Imagine:
* Bird has a method `fly()`
* You create **Penguin extends Bird**
* But penguins can’t fly.
<br>

If your program does:
```
void makeItFly(Bird b) { b.fly(); }
```
Passing a Penguin breaks the program’s expectation. So Penguin should not be a subtype of a “flying bird”.

### Better design:
* Bird (no fly method)
* FlyingBird extends Bird (has fly())
* Penguin extends Bird
* Sparrow extends FlyingBird

Now every FlyingBird truly can fly → substitution is safe

# Open/Closed Principle

Software entities (classes, modules, functions) should be open for extension but closed for modification.
So: when requirements change, you should be able to add new behavior by adding new code, not by editing old working code.

# Dependency Inversion Principle

High-level code (business logic) should not depend on low-level code (details). Both should depend on abstractions (interfaces).

And: abstractions shouldn’t depend on details; details depend on abstractions.

* High-level = “what to do” (rules, workflows, use-cases)
* Low-level = “how it’s done” (DB, HTTP clients, frameworks, SDKs)

DIP says: your “what to do” shouldn’t import/know concrete “how it’s done”.
It should talk to an interface, and the concrete stuff plugs in from outside.

<img width="863" height="325" alt="Image" src="https://github.com/user-attachments/assets/da21779d-139e-4217-8dbe-289790a6625d" />

The Dependency Inversion Principle is a means to:

* Change the referencing of concrete classes from being direct to indirect
* Generalize the behaviors of your concrete classes into abstract classes and interfaces
* Have client classes interact with your sysrem through a generalization rather than directly with concrete resources
* Put emphasis on high level dependency over low level concrete dependency

# Composing Objects Principle

- This principle states that classes should achieve code reuse through aggregation rather than inheritance.

The composite design pattern and decorator design pattern use this design principle. Both of these patterns compose concrete classes in order to build more complex objects at one time.


### Advantages
* Aggregation and delegation offer less coupling thant inheritance
* "Arms length" relationship enter image description here
* Provides your system with more flexibility
* Dynamically change the behaviod of objects at run time

### Disadvantages

- The biggest drawback of composition is that you must provide implementations for all behaviour, without the benefit of inheritance to share code. That means that you might have very similar implementation across classes.

Some good tips and questions to help you decide whether the best solution for your system is composition or inheritance include:

1. You need to examine the needs of your system in order to determine whihc design principle is appropriate
2. Do you have a set of related classes or unrelated classes?
3. What is a common behaviour between them?
4. Do you need specialized classes to handle specific cases or do you need a different implementation of the same behaviour?

# Interface Segregation Principle

- The interface segregation principle states that a class should not be forced to depend on methods it does not use. This means that any classes that implement an interface, should not have "dummy" implementation of any methods defined in the interface. Instead, you should split large interfaces into smaller generalizations.

Bad example:

<img width="1034" height="582" alt="Image" src="https://github.com/user-attachments/assets/95cedf9b-87ac-403b-a1e7-ca7e2d23e89c" />


Good exmaple:

<img width="970" height="585" alt="Image" src="https://github.com/user-attachments/assets/a0bd6ee2-e72b-432a-8ba3-877834f2b76c" />

* Sometimes it isn't always clear how to properly segregate your interface or to predict future changes in requirements that will need interfaces to be split up. Having a system with well-defined interfaces will help you to see these segregation points better.

* You should always strive to be as precise as possible when designing interfaces. Remember that they are descriptions of what parts of your system can do, and the better the description, the easier it will be to create, update and maintain your software. 
