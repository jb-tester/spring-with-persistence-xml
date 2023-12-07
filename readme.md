https://youtrack.jetbrains.com/issue/IDEA-338778

without the JPA facet, the entity is not recognized if the persistence.xml contains the

```
<exclude-unlisted-classes>true</exclude-unlisted-classes>
```

the `Car` entity is added programmatically (see `com.mytests.spring.MyPersistenceUnitPostProcessor`),
and doesn't appear in the Persistence view. Also, it is not resolved inside a query (see `com.mytests.spring.CarsRepository`)

the `Person` entity (added explicitly to the `persistence.xml` file) is recognized properly without facet.

if the `exclude-unlisted-classes` property is removed, all entities are recognized
