# assertj-more

Provides more assertions on top of [AssertJ](https://github.com/assertj/assertj-core).

```java
LocalDate actual = LocalDate.now();
// assertj-core
assertThat(actual)
        .isNotNull()
        .isBefore(actual.plusYears(1L));
// assertj-more
assertMore(actual)
        .isNotNull()
        .isBefore(actual.plusYears(1L))
        .supports(ChronoUnit.YEARS);
```
