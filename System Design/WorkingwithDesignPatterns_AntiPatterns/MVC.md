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