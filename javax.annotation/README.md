# Bindings for javax.annotation

These bindings are created to simplify interaction with java classes from clojure.
For each java class was created a separate namespace.
Each method/field has its own function/field binding.
Their names are changed for a more native look in the clojure code. Each function has docstring - information about the parameters, return value and possible exceptions.

## Note

All namespaces starting with **java.** are renamed to **jdk.** (java compiler limitation). 

**java.io.File** renamed to **jdk.io.File** for example. 




## Clojars

```
[clojure-interop/javax.annotation "1.0.1"]
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

- annotation **javax.annotation.Generated**
- annotation **javax.annotation.PostConstruct**
- annotation **javax.annotation.PreDestroy**
- enum **javax.annotation.Resource$AuthenticationType**
- annotation **javax.annotation.Resource**
- annotation **javax.annotation.Resources**
- class **javax.annotation.processing.AbstractProcessor**
- interface **javax.annotation.processing.Completion**
- class **javax.annotation.processing.Completions**
- interface **javax.annotation.processing.Filer**
- class **javax.annotation.processing.FilerException**
- interface **javax.annotation.processing.Messager**
- interface **javax.annotation.processing.ProcessingEnvironment**
- interface **javax.annotation.processing.Processor**
- interface **javax.annotation.processing.RoundEnvironment**
- annotation **javax.annotation.processing.SupportedAnnotationTypes**
- annotation **javax.annotation.processing.SupportedOptions**
- annotation **javax.annotation.processing.SupportedSourceVersion**

## Contributors

[Eugene Potapenko](https://github.com/potapenko/)

## License

Distributed under the Eclipse Public License, the same as Clojure.
