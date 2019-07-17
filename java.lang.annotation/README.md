# Bindings for java.lang.annotation

These bindings are created to simplify interaction with java classes from clojure.
For each java class was created a separate namespace.
Each method/field has its own function/field binding.
Their names are changed for a more native look in the clojure code. Each function has docstring - information about the parameters, return value and possible exceptions.

## Note

All namespaces starting with **java.** are renamed to **jdk.** (java compiler limitation). 

**java.io.File** renamed to **jdk.io.File** for example. 

## Clojars

You can find clojars in README of packages.

## Usage

```
(require '[jdk.io.File :as f])

(-> "./resource/MyFile.txt"
  f/->file
  f/exists?)

(-> "./resource/MyAnotherFile.txt"
  f/->file
  f/mkdirs)
```




## Clojars

```
[clojure-interop/java.lang.annotation "0.1.0-SNAPSHOT"]
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

- interface **java.lang.annotation.Annotation**
- class **java.lang.annotation.AnnotationFormatError**
- class **java.lang.annotation.AnnotationTypeMismatchException**
- annotation **java.lang.annotation.Documented**
- enum **java.lang.annotation.ElementType**
- class **java.lang.annotation.IncompleteAnnotationException**
- annotation **java.lang.annotation.Inherited**
- annotation **java.lang.annotation.Native**
- annotation **java.lang.annotation.Repeatable**
- annotation **java.lang.annotation.Retention**
- enum **java.lang.annotation.RetentionPolicy**
- annotation **java.lang.annotation.Target**

## Contributors

[Eugene Potapenko](https://github.com/potapenko/)

## License

Distributed under the Eclipse Public License, the same as Clojure.
