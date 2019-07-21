# Bindings for java.util.function

These bindings are created to simplify interaction with java classes from clojure.
For each java class was created a separate namespace.
Each method/field has its own function/field binding.
Their names are changed for a more native look in the clojure code. Each function has docstring - information about the parameters, return value and possible exceptions.

## Note

All namespaces starting with **java.** are renamed to **jdk.** (java compiler limitation). 

**java.io.File** renamed to **jdk.io.File** for example. 




## Clojars

```
[clojure-interop/java.util.function "1.0.5"]
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

- interface **java.util.function.BiConsumer**
- interface **java.util.function.BiFunction**
- interface **java.util.function.BiPredicate**
- interface **java.util.function.BinaryOperator**
- interface **java.util.function.BooleanSupplier**
- interface **java.util.function.Consumer**
- interface **java.util.function.DoubleBinaryOperator**
- interface **java.util.function.DoubleConsumer**
- interface **java.util.function.DoubleFunction**
- interface **java.util.function.DoublePredicate**
- interface **java.util.function.DoubleSupplier**
- interface **java.util.function.DoubleToIntFunction**
- interface **java.util.function.DoubleToLongFunction**
- interface **java.util.function.DoubleUnaryOperator**
- interface **java.util.function.Function**
- interface **java.util.function.IntBinaryOperator**
- interface **java.util.function.IntConsumer**
- interface **java.util.function.IntFunction**
- interface **java.util.function.IntPredicate**
- interface **java.util.function.IntSupplier**
- interface **java.util.function.IntToDoubleFunction**
- interface **java.util.function.IntToLongFunction**
- interface **java.util.function.IntUnaryOperator**
- interface **java.util.function.LongBinaryOperator**
- interface **java.util.function.LongConsumer**
- interface **java.util.function.LongFunction**
- interface **java.util.function.LongPredicate**
- interface **java.util.function.LongSupplier**
- interface **java.util.function.LongToDoubleFunction**
- interface **java.util.function.LongToIntFunction**
- interface **java.util.function.LongUnaryOperator**
- interface **java.util.function.ObjDoubleConsumer**
- interface **java.util.function.ObjIntConsumer**
- interface **java.util.function.ObjLongConsumer**
- interface **java.util.function.Predicate**
- interface **java.util.function.Supplier**
- interface **java.util.function.ToDoubleBiFunction**
- interface **java.util.function.ToDoubleFunction**
- interface **java.util.function.ToIntBiFunction**
- interface **java.util.function.ToIntFunction**
- interface **java.util.function.ToLongBiFunction**
- interface **java.util.function.ToLongFunction**
- interface **java.util.function.UnaryOperator**

## Contributors

[Eugene Potapenko](https://github.com/potapenko/)

## License

Distributed under the Eclipse Public License, the same as Clojure.
