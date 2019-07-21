# Bindings for java.util.spi

These bindings are created to simplify interaction with java classes from clojure.
For each java class was created a separate namespace.
Each method/field has its own function/field binding.
Their names are changed for a more native look in the clojure code. Each function has docstring - information about the parameters, return value and possible exceptions.

## Note

All namespaces starting with **java.** are renamed to **jdk.** (java compiler limitation). 

**java.io.File** renamed to **jdk.io.File** for example. 




## Clojars

```
[clojure-interop/java.util.spi "1.0.5"]
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

- class **java.util.spi.CalendarDataProvider**
- class **java.util.spi.CalendarNameProvider**
- class **java.util.spi.CurrencyNameProvider**
- class **java.util.spi.LocaleNameProvider**
- class **java.util.spi.LocaleServiceProvider**
- interface **java.util.spi.ResourceBundleControlProvider**
- class **java.util.spi.TimeZoneNameProvider**

## Contributors

[Eugene Potapenko](https://github.com/potapenko/)

## License

Distributed under the Eclipse Public License, the same as Clojure.
