# Bindings for javax.accessibility

These bindings are created to simplify interaction with java classes from clojure.
For each java class was created a separate namespace.
Each method/field has its own function/field binding.
Their names are changed for a more native look in the clojure code. Each function has docstring - information about the parameters, return value and possible exceptions.

## Note

All namespaces starting with **java.** are renamed to **jdk.** (java compiler limitation). 

**java.io.File** renamed to **jdk.io.File** for example. 




## Clojars

```
[clojure-interop/javax.accessibility "0.1.0-SNAPSHOT"]
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

- interface **javax.accessibility.Accessible**
- interface **javax.accessibility.AccessibleAction**
- class **javax.accessibility.AccessibleAttributeSequence**
- class **javax.accessibility.AccessibleBundle**
- interface **javax.accessibility.AccessibleComponent**
- class **javax.accessibility.AccessibleContext**
- interface **javax.accessibility.AccessibleEditableText**
- interface **javax.accessibility.AccessibleExtendedComponent**
- interface **javax.accessibility.AccessibleExtendedTable**
- interface **javax.accessibility.AccessibleExtendedText**
- class **javax.accessibility.AccessibleHyperlink**
- interface **javax.accessibility.AccessibleHypertext**
- interface **javax.accessibility.AccessibleIcon**
- interface **javax.accessibility.AccessibleKeyBinding**
- class **javax.accessibility.AccessibleRelation**
- class **javax.accessibility.AccessibleRelationSet**
- class **javax.accessibility.AccessibleResourceBundle**
- class **javax.accessibility.AccessibleRole**
- interface **javax.accessibility.AccessibleSelection**
- class **javax.accessibility.AccessibleState**
- class **javax.accessibility.AccessibleStateSet**
- interface **javax.accessibility.AccessibleStreamable**
- interface **javax.accessibility.AccessibleTable**
- interface **javax.accessibility.AccessibleTableModelChange**
- interface **javax.accessibility.AccessibleText**
- class **javax.accessibility.AccessibleTextSequence**
- interface **javax.accessibility.AccessibleValue**

## Contributors

[Eugene Potapenko](https://github.com/potapenko/)

## License

Distributed under the Eclipse Public License, the same as Clojure.
