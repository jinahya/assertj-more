# assertj-extended

Provides more assertions on top of [AssertJ](https://github.com/assertj/assertj-core).


```java
LocalDate actual = LocalDate.now();
assertThat(actual)
        .isNotNull()
        .isBefore(actual.plusYears(1L));
assertMore(actual)
        .isNotNull()
        .isBefore(actual.plusYears(1L))
        .supports(ChronoUnit.YEARS);
```


# java.time.temporal
