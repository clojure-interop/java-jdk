# Bindings for javax.script

These bindings are created to simplify interaction with java classes from clojure.
For each java class was created a separate namespace.
Each method/field has its own function/field binding.
Their names are changed for a more native look in the clojure code. Each function has docstring - information about the parameters, return value and possible exceptions.

## Note

All namespaces starting with **java.** are renamed to **jdk.** (java compiler limitation). 

**java.io.File** renamed to **jdk.io.File** for example. 




## Clojars

```
[clojure-interop/javax.script "1.0.4"]
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

- class **javax.script.AbstractScriptEngine**
- interface **javax.script.Bindings**
- interface **javax.script.Compilable**
- class **javax.script.CompiledScript**
- interface **javax.script.Invocable**
- interface **javax.script.ScriptContext**
- interface **javax.script.ScriptEngine**
- interface **javax.script.ScriptEngineFactory**
- class **javax.script.ScriptEngineManager**
- class **javax.script.ScriptException**
- class **javax.script.SimpleBindings**
- class **javax.script.SimpleScriptContext**

## Contributors

[Eugene Potapenko](https://github.com/potapenko/)

## License

Distributed under the Eclipse Public License, the same as Clojure.
