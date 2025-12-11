# System Design

`if you are already familiar with what SD is you can directly go to` [Design-Patterns](https://github.com/BHariKrishnaReddy/System-design/blob/main/Design-Patterns.md)

The discipline of SD helps to tame the complexity and get the work done.SD aims to build systems that are 
* Reliable: handles faults, failures, and errors
* Effective: meet all user needs and business requirements
* Maintainable: are flexible and easy to scale up/down. The ability to add new features also comes under this

---

In day-to-day SD work, include
* Monitoring and Observability
* Incident Response and Troubleshooting
* Capacity management continuously evaluates traffic, storage, and scaling requirements to prevent bottlenecks
* Performance tuning
* System evolution and Refactoring
* Operational automation

Core topics that build/help the design principles ....

## Abstraction

An idea of simplifying a concept in the problem domain to its essentials within some context. It allows you to better understand a concept by breaking it down into a simplified description that ignores unimportant details.

Eg: defining a class with attributes

This idea applies the Rule of Least Astonishment.
That is, the abstraction captures the essential attributes and behavior for a concept with no surprises and no definitions that fall beyond its scope. You don't want to surprise anyone trying to understand your abstraction with irrelevant characteristics

## Encapsulation

It forms a self-contained object by bundling the data and functions it requires to work, exposes an interface whereby other objects can access and use it, and restricts access to certain inside details

Eg: use of access identifiers in a scoped class

Encapsulation achieves what is called the Abstraction Barrier. Since the internal workings are not relevant to the outside world, this achieves an abstraction that effectively reduces complexity for the users of a class

## Decomposition

(it works on its own)

It is taking a whole thing and dividing it up into different parts. Or on the flip side, taking a bunch of separate parts with different functionalities and combining them together to form a whole. It allows you to further break down problems into pieces that are easier to understand and solve
Overall, decomposition is a key principle that helps in organizing and managing complex systems by defining the relationships and responsibilities of their parts.

## Generalization

Helps us reduce the amount of redundancy when solving the problem. Writing the method to reuse or inherit from a class.

Get a high-level understanding of UML diagrams.

