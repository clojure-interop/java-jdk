# Bindings for javax.tools

These bindings are created to simplify interaction with java classes from clojure.
For each java class was created a separate namespace.
Each method/field has its own function/field binding.
Their names are changed for a more native look in the clojure code. Each function has docstring - information about the parameters, return value and possible exceptions.

## Note

All namespaces starting with **java.** are renamed to **jdk.** (java compiler limitation). 

**java.io.File** renamed to **jdk.io.File** for example. 




## Clojars

```
[clojure-interop/javax.tools "1.0.4"]
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

- enum **javax.tools.Diagnostic$Kind**
- interface **javax.tools.Diagnostic**
- class **javax.tools.DiagnosticCollector**
- interface **javax.tools.DiagnosticListener**
- interface **javax.tools.DocumentationTool$DocumentationTask**
- enum **javax.tools.DocumentationTool$Location**
- interface **javax.tools.DocumentationTool**
- interface **javax.tools.FileObject**
- class **javax.tools.ForwardingFileObject**
- class **javax.tools.ForwardingJavaFileManager**
- class **javax.tools.ForwardingJavaFileObject**
- interface **javax.tools.JavaCompiler$CompilationTask**
- interface **javax.tools.JavaCompiler**
- interface **javax.tools.JavaFileManager$Location**
- interface **javax.tools.JavaFileManager**
- enum **javax.tools.JavaFileObject$Kind**
- interface **javax.tools.JavaFileObject**
- interface **javax.tools.OptionChecker**
- class **javax.tools.SimpleJavaFileObject**
- interface **javax.tools.StandardJavaFileManager**
- enum **javax.tools.StandardLocation**
- interface **javax.tools.Tool**
- class **javax.tools.ToolProvider**

## Contributors

[Eugene Potapenko](https://github.com/potapenko/)

## License

Distributed under the Eclipse Public License, the same as Clojure.
