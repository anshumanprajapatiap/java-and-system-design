Design Pattern

S - Single Responsibility Principle
O - Open close principle
L - Liskov substitution principle
I  - Interface segregation principle
D - Dependency Inversion principle



Advantage of design pattern:
1. They are reusable in multiple projects.
2. They provide the solutions that help to define the system architecture.
3. They capture the software engineering experiences.
4. They provide transparency to the design of an application.
5. They are well-proved and testified solutions since they have been built upon the knowledge and experience of expert software developers.
6. Design patterns don?t guarantee an absolute solution to a problem. They provide clarity to the system architecture and the possibility of building a better system.


When should we use the design patterns?
We must use the design patterns during the analysis and requirement phase of SDLC(Software Development Life Cycle).
Design patterns ease the analysis and requirement phase of SDLC by providing information based on prior hands-on experiences.

Categorization of design patterns:
Basically, design patterns are categorized into two parts:
1. Core Java (or JSE) Design Patterns.
2. JEE Design Patterns.


Core Java Design Patterns
In core java, there are mainly three types of design patterns, which are further divided into their sub-parts:

1. Creational Design Pattern
   1. Factory Pattern - A Factory Pattern or Factory Method Pattern says that just define an interface or abstract class for creating an object but let the subclasses decide which class to instantiate. In other words, subclasses are responsible to create the instance of the class. 
   2. Abstract Factory Pattern - Abstract Factory Pattern says that just define an interface or abstract class for creating families of related (or dependent) objects but without specifying their concrete sub-classes.That means Abstract Factory lets a class returns a factory of classes. So, this is the reason that Abstract Factory Pattern is one level higher than the Factory Pattern. 
   3. Singleton Pattern - Singleton Pattern says that just"define a class that has only one instance and provides a global point of access to it". 
   4. Prototype Pattern - Prototype Pattern says that cloning of an existing object instead of creating new one and can also be customized as per the requirement. 
   5. Builder Pattern - Builder Pattern says that "construct a complex object from simple objects using step-by-step approach" 
   6. Object Pool Pattern - Object Pool Pattern says that " to reuse the object that are expensive to create".

2. Structural Design Pattern
   1. Adapter Pattern - Bridge btw two interfaces
   2. Bridge Pattern -  decouple object from implementation
   3. Composite Pattern - Object of Object
   4. Decorator Pattern - Decorators Class (Example Pizza and Toppings as Decorator)
   5. Facade Pattern -  Complex objects to simple code for client
   6. Flyweight Pattern - Helps reduce memory (word processor problem)
   7. Proxy Pattern - Restrictions, caching, pre and post process (example access checker proxy)

3. Behavioural Design Pattern
   1. Chain Of Responsibility Pattern -  Chain of objects (Example ATM/ Logger )
   2. Command Pattern -
   3. Interpreter Pattern
   4. Iterator Pattern
   5. Mediator Pattern
   6. Memento Pattern
   7. Observer Pattern - Observable and Observer relationship (Example notify me feature)
   8. State Pattern - States changes (Example Vending machine and ATM)
   9. Strategy Pattern - No duplicate code
   10. Template Pattern
   11. Visitor Pattern

