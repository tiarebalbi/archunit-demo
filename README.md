## Writing Unit Test to ensure the Integrity of your Software

How to write tests to ensure that decisions made on day one are still valid as your software grows.

---

These days, you have so many options on how to start a new project that deciding on how to design the software can be an overwhelming problem. Once decisions are made, you create a set of expectations on how certain things will work and how each piece will interact with the other.

As the software grows, decisions made on day one might need to be adapted, improved, or reviewed, and that's what I want to cover here. So how can you ensure that one change won't affect the other decisions made?

In the book "Fundamentals of Software Architecture." An Engineering Approach, they talk a lot about Fitness Functions.

> A fitness function is a particular type of objective function that is used to summarise, as a single figure of merit, how close a given design solution is to achieving the set aims. Fitness functions are used in genetic programming and genetic algorithms to guide simulations towards optimal design solutions.

https://en.wikipedia.org/wiki/Fitness_function

The fitness function that this post will cover is the `Architecture fitness function`, which they describe as:
> Any mechanism that provides an objective integrity assessment of some architecture characteristic or combination of architecture characteristics.

https://www.oreilly.com/library/view/fundamentals-of-software/9781492043447/

A simple example, using the MVC model, where the Controller Layer will not be accessed by any layer, the Service Layer will only be accessed by the Controllers, and the Persistence Layer will only be accessed by the Services.

To do this, I will use the framework called ArchUnit; ArchUnit is a framework available for Java (compatible with Kotlin) and .NET/C# that allows you to check the architecture of your project by analyzing bytecodes and imports of classes against unit tests that are defining the decisions made for your project.
