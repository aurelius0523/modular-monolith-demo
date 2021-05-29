### Considerations
**Why not use Spring Events since both module resides in the same application?**
This 

### Downsides/Limitation

---

##### External dependencies are still declared within a singular `pom.xml` which limits extent of modularity.

Consider using a multi-module maven project instead to address this

---

##### DTOs from different modules are imported directly

This will eventually be an anti-pattern in the event of actual module split into
microservices as importing a DTOs that belongs to a separate microservice will
not work, so it might be worth the effort to consider the separation early on

---