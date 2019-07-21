# Bindings for java.util.zip

These bindings are created to simplify interaction with java classes from clojure.
For each java class was created a separate namespace.
Each method/field has its own function/field binding.
Their names are changed for a more native look in the clojure code. Each function has docstring - information about the parameters, return value and possible exceptions.

## Note

All namespaces starting with **java.** are renamed to **jdk.** (java compiler limitation). 

**java.io.File** renamed to **jdk.io.File** for example. 




## Clojars

```
[clojure-interop/java.util.zip "1.0.5"]
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

- class **java.util.zip.Adler32**
- class **java.util.zip.CRC32**
- class **java.util.zip.CheckedInputStream**
- class **java.util.zip.CheckedOutputStream**
- interface **java.util.zip.Checksum**
- class **java.util.zip.DataFormatException**
- class **java.util.zip.Deflater**
- class **java.util.zip.DeflaterInputStream**
- class **java.util.zip.DeflaterOutputStream**
- class **java.util.zip.GZIPInputStream**
- class **java.util.zip.GZIPOutputStream**
- class **java.util.zip.Inflater**
- class **java.util.zip.InflaterInputStream**
- class **java.util.zip.InflaterOutputStream**
- class **java.util.zip.ZipEntry**
- class **java.util.zip.ZipError**
- class **java.util.zip.ZipException**
- class **java.util.zip.ZipFile**
- class **java.util.zip.ZipInputStream**
- class **java.util.zip.ZipOutputStream**

## Contributors

[Eugene Potapenko](https://github.com/potapenko/)

## License

Distributed under the Eclipse Public License, the same as Clojure.
