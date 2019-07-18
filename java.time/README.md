# Bindings for java.time

These bindings are created to simplify interaction with java classes from clojure.
For each java class was created a separate namespace.
Each method/field has its own function/field binding.
Their names are changed for a more native look in the clojure code. Each function has docstring - information about the parameters, return value and possible exceptions.

## Note

All namespaces starting with **java.** are renamed to **jdk.** (java compiler limitation). 

**java.io.File** renamed to **jdk.io.File** for example. 




## Clojars

```
[clojure-interop/java.time "1.0.4"]
```

## Class Members Naming Conventions

| Class Member | Java | Clojure |
|:--|:--|:--|
| constructor | new File() | (->file) |
| instance method | getAnyValue() | (get-any-value) |
| instance field | instanceField | -instance-field |
| static method | staticMethod() | (*static-method) |
| static field | ANY_STATIC_FIELD | *-any-static-field |
| boolean field/method | isExists(), canUse() | (exists?), (can-use?) |

## Classes

- class **java.time.Clock**
- class **java.time.DateTimeException**
- enum **java.time.DayOfWeek**
- class **java.time.Duration**
- class **java.time.Instant**
- class **java.time.LocalDate**
- class **java.time.LocalDateTime**
- class **java.time.LocalTime**
- enum **java.time.Month**
- class **java.time.MonthDay**
- class **java.time.OffsetDateTime**
- class **java.time.OffsetTime**
- class **java.time.Period**
- class **java.time.Year**
- class **java.time.YearMonth**
- class **java.time.ZoneId**
- class **java.time.ZoneOffset**
- class **java.time.ZonedDateTime**
- class **java.time.chrono.AbstractChronology**
- interface **java.time.chrono.ChronoLocalDate**
- interface **java.time.chrono.ChronoLocalDateTime**
- interface **java.time.chrono.ChronoPeriod**
- interface **java.time.chrono.ChronoZonedDateTime**
- interface **java.time.chrono.Chronology**
- interface **java.time.chrono.Era**
- class **java.time.chrono.HijrahChronology**
- class **java.time.chrono.HijrahDate**
- enum **java.time.chrono.HijrahEra**
- class **java.time.chrono.IsoChronology**
- enum **java.time.chrono.IsoEra**
- class **java.time.chrono.JapaneseChronology**
- class **java.time.chrono.JapaneseDate**
- class **java.time.chrono.JapaneseEra**
- class **java.time.chrono.MinguoChronology**
- class **java.time.chrono.MinguoDate**
- enum **java.time.chrono.MinguoEra**
- class **java.time.chrono.ThaiBuddhistChronology**
- class **java.time.chrono.ThaiBuddhistDate**
- enum **java.time.chrono.ThaiBuddhistEra**
- class **java.time.format.DateTimeFormatter**
- class **java.time.format.DateTimeFormatterBuilder**
- class **java.time.format.DateTimeParseException**
- class **java.time.format.DecimalStyle**
- enum **java.time.format.FormatStyle**
- enum **java.time.format.ResolverStyle**
- enum **java.time.format.SignStyle**
- enum **java.time.format.TextStyle**
- enum **java.time.temporal.ChronoField**
- enum **java.time.temporal.ChronoUnit**
- class **java.time.temporal.IsoFields**
- class **java.time.temporal.JulianFields**
- interface **java.time.temporal.Temporal**
- interface **java.time.temporal.TemporalAccessor**
- interface **java.time.temporal.TemporalAdjuster**
- class **java.time.temporal.TemporalAdjusters**
- interface **java.time.temporal.TemporalAmount**
- interface **java.time.temporal.TemporalField**
- class **java.time.temporal.TemporalQueries**
- interface **java.time.temporal.TemporalQuery**
- interface **java.time.temporal.TemporalUnit**
- class **java.time.temporal.UnsupportedTemporalTypeException**
- class **java.time.temporal.ValueRange**
- class **java.time.temporal.WeekFields**
- class **java.time.zone.ZoneOffsetTransition**
- enum **java.time.zone.ZoneOffsetTransitionRule$TimeDefinition**
- class **java.time.zone.ZoneOffsetTransitionRule**
- class **java.time.zone.ZoneRules**
- class **java.time.zone.ZoneRulesException**
- class **java.time.zone.ZoneRulesProvider**

## Contributors

[Eugene Potapenko](https://github.com/potapenko/)

## License

Distributed under the Eclipse Public License, the same as Clojure.
