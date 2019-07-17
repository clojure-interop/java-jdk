# Bindings for javax.lang

These bindings are created to simplify interaction with java classes from clojure.
For each java class was created a separate namespace.
Each method/field has its own function/field binding.
Their names are changed for a more native look in the clojure code. Each function has docstring - information about the parameters, return value and possible exceptions.

## Note

All namespaces starting with **java.** are renamed to **jdk.** (java compiler limitation). 

**java.io.File** renamed to **jdk.io.File** for example. 




## Clojars

```
[clojure-interop/javax.lang "1.0.0"]
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

- interface **javax.lang.model.AnnotatedConstruct**
- enum **javax.lang.model.SourceVersion**
- class **javax.lang.model.UnknownEntityException**
- interface **javax.lang.model.element.AnnotationMirror**
- interface **javax.lang.model.element.AnnotationValue**
- interface **javax.lang.model.element.AnnotationValueVisitor**
- interface **javax.lang.model.element.Element**
- enum **javax.lang.model.element.ElementKind**
- interface **javax.lang.model.element.ElementVisitor**
- interface **javax.lang.model.element.ExecutableElement**
- enum **javax.lang.model.element.Modifier**
- interface **javax.lang.model.element.Name**
- enum **javax.lang.model.element.NestingKind**
- interface **javax.lang.model.element.PackageElement**
- interface **javax.lang.model.element.Parameterizable**
- interface **javax.lang.model.element.QualifiedNameable**
- interface **javax.lang.model.element.TypeElement**
- interface **javax.lang.model.element.TypeParameterElement**
- class **javax.lang.model.element.UnknownAnnotationValueException**
- class **javax.lang.model.element.UnknownElementException**
- interface **javax.lang.model.element.VariableElement**
- interface **javax.lang.model.type.ArrayType**
- interface **javax.lang.model.type.DeclaredType**
- interface **javax.lang.model.type.ErrorType**
- interface **javax.lang.model.type.ExecutableType**
- interface **javax.lang.model.type.IntersectionType**
- class **javax.lang.model.type.MirroredTypeException**
- class **javax.lang.model.type.MirroredTypesException**
- interface **javax.lang.model.type.NoType**
- interface **javax.lang.model.type.NullType**
- interface **javax.lang.model.type.PrimitiveType**
- interface **javax.lang.model.type.ReferenceType**
- enum **javax.lang.model.type.TypeKind**
- interface **javax.lang.model.type.TypeMirror**
- interface **javax.lang.model.type.TypeVariable**
- interface **javax.lang.model.type.TypeVisitor**
- interface **javax.lang.model.type.UnionType**
- class **javax.lang.model.type.UnknownTypeException**
- interface **javax.lang.model.type.WildcardType**
- class **javax.lang.model.util.AbstractAnnotationValueVisitor6**
- class **javax.lang.model.util.AbstractAnnotationValueVisitor7**
- class **javax.lang.model.util.AbstractAnnotationValueVisitor8**
- class **javax.lang.model.util.AbstractElementVisitor6**
- class **javax.lang.model.util.AbstractElementVisitor7**
- class **javax.lang.model.util.AbstractElementVisitor8**
- class **javax.lang.model.util.AbstractTypeVisitor6**
- class **javax.lang.model.util.AbstractTypeVisitor7**
- class **javax.lang.model.util.AbstractTypeVisitor8**
- class **javax.lang.model.util.ElementFilter**
- class **javax.lang.model.util.ElementKindVisitor6**
- class **javax.lang.model.util.ElementKindVisitor7**
- class **javax.lang.model.util.ElementKindVisitor8**
- class **javax.lang.model.util.ElementScanner6**
- class **javax.lang.model.util.ElementScanner7**
- class **javax.lang.model.util.ElementScanner8**
- interface **javax.lang.model.util.Elements**
- class **javax.lang.model.util.SimpleAnnotationValueVisitor6**
- class **javax.lang.model.util.SimpleAnnotationValueVisitor7**
- class **javax.lang.model.util.SimpleAnnotationValueVisitor8**
- class **javax.lang.model.util.SimpleElementVisitor6**
- class **javax.lang.model.util.SimpleElementVisitor7**
- class **javax.lang.model.util.SimpleElementVisitor8**
- class **javax.lang.model.util.SimpleTypeVisitor6**
- class **javax.lang.model.util.SimpleTypeVisitor7**
- class **javax.lang.model.util.SimpleTypeVisitor8**
- class **javax.lang.model.util.TypeKindVisitor6**
- class **javax.lang.model.util.TypeKindVisitor7**
- class **javax.lang.model.util.TypeKindVisitor8**
- interface **javax.lang.model.util.Types**

## Contributors

[Eugene Potapenko](https://github.com/potapenko/)

## License

Distributed under the Eclipse Public License, the same as Clojure.
