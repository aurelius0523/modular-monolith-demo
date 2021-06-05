## Basic Modular Monolith demo

This repository demonstrates a very basic example of how to organize your
repository in
a [modular monolith](https://www.jrebel.com/blog/what-is-a-modular-monolith)
pattern. The main discerning characteristic of how this pattern differs from a
conventional monolith and microservice can be illustrated in the diagrams below:

![conventional monolith](docs/conventional-monolith.JPG)

*image 1: Conventional monolith includes all business domains into a single war
file*

![microservice](docs/microservices.JPG)
*image 2: In microservice architecture, business domains are developed and
deployed as separate war/applications*

![modular-monolith](docs/modular-monolith.JPG)
*image 3: Modular monolith architecture merges the two. It removes the usual
complexity that comes with microservices (tracing/monitoring/debugging) in
exchange for lower scalability (as application tends to be more memory intensive
and starts up slower). The domain boundaries are still respected in the form of
modules, which doesn't allow direct method invocation*

## Considerations

**Should I use Spring Event or normal HTTP calls when communicating between
modules?**

While it makes more sense from a performance perspective to use `Spring Event`
or some form of direct method invocation, do keep in mind that a modular
monolith could be a _transitory_ pattern. It might be worth considering the
effort required to retrofit from `Spring Event` to http call or any other
non-similar methods of communication

---
**Given that Book Module and Author Module lives in the same application, why
use HTTP call?**

The communication implementation (REST/grpc/queue/spring-events) is not as
important as its abstraction. The idea is that the abstraction can be
retrofitted when a module in this modular monolith is separated into a
standalone application.

## Downsides/Limitation

##### External dependencies are still declared within a singular `pom.xml` which limits extent of modularity.

Consider using a multi-module maven project instead to address this

---

##### DTOs from different modules are directly imported

This will eventually be an anti-pattern in the event of actual module split into
microservices as importing a DTOs that belongs to a separate microservice will
not work, so it might be worth the effort to consider the separation early on

---