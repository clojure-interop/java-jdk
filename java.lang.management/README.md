# Bindings for java.lang.management

These bindings are created to simplify interaction with java classes from clojure.
For each java class was created a separate namespace.
Each method/field has its own function/field binding.
Their names are changed for a more native look in the clojure code. Each function has docstring - information about the parameters, return value and possible exceptions.

## Note

All namespaces starting with **java.** are renamed to **jdk.** (java compiler limitation). 

**java.io.File** renamed to **jdk.io.File** for example. 




## Clojars

```
[clojure-interop/java.lang.management "1.0.4"]
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

- interface **java.lang.management.BufferPoolMXBean**
- interface **java.lang.management.ClassLoadingMXBean**
- interface **java.lang.management.CompilationMXBean**
- interface **java.lang.management.GarbageCollectorMXBean**
- class **java.lang.management.LockInfo**
- class **java.lang.management.ManagementFactory**
- class **java.lang.management.ManagementPermission**
- interface **java.lang.management.MemoryMXBean**
- interface **java.lang.management.MemoryManagerMXBean**
- class **java.lang.management.MemoryNotificationInfo**
- interface **java.lang.management.MemoryPoolMXBean**
- enum **java.lang.management.MemoryType**
- class **java.lang.management.MemoryUsage**
- class **java.lang.management.MonitorInfo**
- interface **java.lang.management.OperatingSystemMXBean**
- interface **java.lang.management.PlatformLoggingMXBean**
- interface **java.lang.management.PlatformManagedObject**
- interface **java.lang.management.RuntimeMXBean**
- class **java.lang.management.ThreadInfo**
- interface **java.lang.management.ThreadMXBean**

## Contributors

[Eugene Potapenko](https://github.com/potapenko/)

## License

Distributed under the Eclipse Public License, the same as Clojure.
