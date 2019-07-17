# Bindings for javax.activation

These bindings are created to simplify interaction with java classes from clojure.
For each java class was created a separate namespace.
Each method/field has its own function/field binding.
Their names are changed for a more native look in the clojure code. Each function has docstring - information about the parameters, return value and possible exceptions.

## Note

All namespaces starting with **java.** are renamed to **jdk.** (java compiler limitation). 

**java.io.File** renamed to **jdk.io.File** for example. 




## Clojars

```
[clojure-interop/javax.activation "1.0.1"]
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

- class **javax.activation.ActivationDataFlavor**
- class **javax.activation.CommandInfo**
- class **javax.activation.CommandMap**
- interface **javax.activation.CommandObject**
- interface **javax.activation.DataContentHandler**
- interface **javax.activation.DataContentHandlerFactory**
- class **javax.activation.DataHandler**
- interface **javax.activation.DataSource**
- class **javax.activation.FileDataSource**
- class **javax.activation.FileTypeMap**
- class **javax.activation.MailcapCommandMap**
- class **javax.activation.MimeType**
- class **javax.activation.MimeTypeParameterList**
- class **javax.activation.MimeTypeParseException**
- class **javax.activation.MimetypesFileTypeMap**
- class **javax.activation.URLDataSource**
- class **javax.activation.UnsupportedDataTypeException**

## Contributors

[Eugene Potapenko](https://github.com/potapenko/)

## License

Distributed under the Eclipse Public License, the same as Clojure.
