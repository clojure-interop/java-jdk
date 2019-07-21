# Bindings for java.lang.reflect

These bindings are created to simplify interaction with java classes from clojure.
For each java class was created a separate namespace.
Each method/field has its own function/field binding.
Their names are changed for a more native look in the clojure code. Each function has docstring - information about the parameters, return value and possible exceptions.

## Note

All namespaces starting with **java.** are renamed to **jdk.** (java compiler limitation). 

**java.io.File** renamed to **jdk.io.File** for example. 




## Clojars

```
[clojure-interop/java.lang.reflect "1.0.5"]
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

- class **java.lang.reflect.AccessibleObject**
- interface **java.lang.reflect.AnnotatedArrayType**
- interface **java.lang.reflect.AnnotatedElement**
- interface **java.lang.reflect.AnnotatedParameterizedType**
- interface **java.lang.reflect.AnnotatedType**
- interface **java.lang.reflect.AnnotatedTypeVariable**
- interface **java.lang.reflect.AnnotatedWildcardType**
- class **java.lang.reflect.Array**
- class **java.lang.reflect.Constructor**
- class **java.lang.reflect.Executable**
- class **java.lang.reflect.Field**
- interface **java.lang.reflect.GenericArrayType**
- interface **java.lang.reflect.GenericDeclaration**
- class **java.lang.reflect.GenericSignatureFormatError**
- interface **java.lang.reflect.InvocationHandler**
- class **java.lang.reflect.InvocationTargetException**
- class **java.lang.reflect.MalformedParameterizedTypeException**
- class **java.lang.reflect.MalformedParametersException**
- interface **java.lang.reflect.Member**
- class **java.lang.reflect.Method**
- class **java.lang.reflect.Modifier**
- class **java.lang.reflect.Parameter**
- interface **java.lang.reflect.ParameterizedType**
- class **java.lang.reflect.Proxy**
- class **java.lang.reflect.ReflectPermission**
- interface **java.lang.reflect.Type**
- interface **java.lang.reflect.TypeVariable**
- class **java.lang.reflect.UndeclaredThrowableException**
- interface **java.lang.reflect.WildcardType**

## Contributors

[Eugene Potapenko](https://github.com/potapenko/)

## License

Distributed under the Eclipse Public License, the same as Clojure.
