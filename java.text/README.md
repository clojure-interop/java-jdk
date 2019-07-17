# Bindings for java.text

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
[clojure-interop/java.text "0.1.0-SNAPSHOT"]
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

- class **java.text.Annotation**
- class **java.text.AttributedCharacterIterator$Attribute**
- interface **java.text.AttributedCharacterIterator**
- class **java.text.AttributedString**
- class **java.text.Bidi**
- class **java.text.BreakIterator**
- interface **java.text.CharacterIterator**
- class **java.text.ChoiceFormat**
- class **java.text.CollationElementIterator**
- class **java.text.CollationKey**
- class **java.text.Collator**
- class **java.text.DateFormat$Field**
- class **java.text.DateFormat**
- class **java.text.DateFormatSymbols**
- class **java.text.DecimalFormat**
- class **java.text.DecimalFormatSymbols**
- class **java.text.FieldPosition**
- class **java.text.Format$Field**
- class **java.text.Format**
- class **java.text.MessageFormat$Field**
- class **java.text.MessageFormat**
- enum **java.text.Normalizer$Form**
- class **java.text.Normalizer**
- class **java.text.NumberFormat$Field**
- class **java.text.NumberFormat**
- class **java.text.ParseException**
- class **java.text.ParsePosition**
- class **java.text.RuleBasedCollator**
- class **java.text.SimpleDateFormat**
- class **java.text.StringCharacterIterator**
- class **java.text.spi.BreakIteratorProvider**
- class **java.text.spi.CollatorProvider**
- class **java.text.spi.DateFormatProvider**
- class **java.text.spi.DateFormatSymbolsProvider**
- class **java.text.spi.DecimalFormatSymbolsProvider**
- class **java.text.spi.NumberFormatProvider**

## Contributors

[Eugene Potapenko](https://github.com/potapenko/)

## License

Distributed under the Eclipse Public License, the same as Clojure.
