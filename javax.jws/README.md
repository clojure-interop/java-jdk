# Bindings for javax.jws

These bindings are created to simplify interaction with java classes from clojure.
For each java class was created a separate namespace.
Each method/field has its own function/field binding.
Their names are changed for a more native look in the clojure code. Each function has docstring - information about the parameters, return value and possible exceptions.

## Note

All namespaces starting with **java.** are renamed to **jdk.** (java compiler limitation). 

**java.io.File** renamed to **jdk.io.File** for example. 




## Clojars

```
[clojure-interop/javax.jws "1.0.3"]
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

- annotation **javax.jws.HandlerChain**
- annotation **javax.jws.Oneway**
- annotation **javax.jws.WebMethod**
- enum **javax.jws.WebParam$Mode**
- annotation **javax.jws.WebParam**
- annotation **javax.jws.WebResult**
- annotation **javax.jws.WebService**
- annotation **javax.jws.soap.InitParam**
- enum **javax.jws.soap.SOAPBinding$ParameterStyle**
- enum **javax.jws.soap.SOAPBinding$Style**
- enum **javax.jws.soap.SOAPBinding$Use**
- annotation **javax.jws.soap.SOAPBinding**
- annotation **javax.jws.soap.SOAPMessageHandler**
- annotation **javax.jws.soap.SOAPMessageHandlers**

## Contributors

[Eugene Potapenko](https://github.com/potapenko/)

## License

Distributed under the Eclipse Public License, the same as Clojure.
