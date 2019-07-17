# Bindings for java.lang.invoke

These bindings are created to simplify interaction with java classes from clojure.
For each java class was created a separate namespace.
Each method/field has its own function/field binding.
Their names are changed for a more native look in the clojure code. Each function has docstring - information about the parameters, return value and possible exceptions.

## Note

All namespaces starting with **java.** are renamed to **jdk.** (java compiler limitation). 

**java.io.File** renamed to **jdk.io.File** for example. 




## Clojars

```
[clojure-interop/java.lang.invoke "1.0.3"]
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

- class **java.lang.invoke.CallSite**
- class **java.lang.invoke.ConstantCallSite**
- class **java.lang.invoke.LambdaConversionException**
- class **java.lang.invoke.LambdaMetafactory**
- class **java.lang.invoke.MethodHandle**
- interface **java.lang.invoke.MethodHandleInfo**
- class **java.lang.invoke.MethodHandleProxies**
- class **java.lang.invoke.MethodHandles$Lookup**
- class **java.lang.invoke.MethodHandles**
- class **java.lang.invoke.MethodType**
- class **java.lang.invoke.MutableCallSite**
- class **java.lang.invoke.SerializedLambda**
- class **java.lang.invoke.SwitchPoint**
- class **java.lang.invoke.VolatileCallSite**
- class **java.lang.invoke.WrongMethodTypeException**

## Contributors

[Eugene Potapenko](https://github.com/potapenko/)

## License

Distributed under the Eclipse Public License, the same as Clojure.
