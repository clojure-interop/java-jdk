# Bindings for java.io

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
[clojure-interop/java.io "0.1.0-SNAPSHOT"]
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

- class **java.io.BufferedInputStream**
- class **java.io.BufferedOutputStream**
- class **java.io.BufferedReader**
- class **java.io.BufferedWriter**
- class **java.io.ByteArrayInputStream**
- class **java.io.ByteArrayOutputStream**
- class **java.io.CharArrayReader**
- class **java.io.CharArrayWriter**
- class **java.io.CharConversionException**
- interface **java.io.Closeable**
- class **java.io.Console**
- interface **java.io.DataInput**
- class **java.io.DataInputStream**
- interface **java.io.DataOutput**
- class **java.io.DataOutputStream**
- class **java.io.EOFException**
- interface **java.io.Externalizable**
- class **java.io.File**
- class **java.io.FileDescriptor**
- interface **java.io.FileFilter**
- class **java.io.FileInputStream**
- class **java.io.FileNotFoundException**
- class **java.io.FileOutputStream**
- class **java.io.FilePermission**
- class **java.io.FileReader**
- class **java.io.FileWriter**
- interface **java.io.FilenameFilter**
- class **java.io.FilterInputStream**
- class **java.io.FilterOutputStream**
- class **java.io.FilterReader**
- class **java.io.FilterWriter**
- interface **java.io.Flushable**
- class **java.io.IOError**
- class **java.io.IOException**
- class **java.io.InputStream**
- class **java.io.InputStreamReader**
- class **java.io.InterruptedIOException**
- class **java.io.InvalidClassException**
- class **java.io.InvalidObjectException**
- class **java.io.LineNumberInputStream**
- class **java.io.LineNumberReader**
- class **java.io.NotActiveException**
- class **java.io.NotSerializableException**
- interface **java.io.ObjectInput**
- class **java.io.ObjectInputStream$GetField**
- class **java.io.ObjectInputStream**
- interface **java.io.ObjectInputValidation**
- interface **java.io.ObjectOutput**
- class **java.io.ObjectOutputStream$PutField**
- class **java.io.ObjectOutputStream**
- class **java.io.ObjectStreamClass**
- interface **java.io.ObjectStreamConstants**
- class **java.io.ObjectStreamException**
- class **java.io.ObjectStreamField**
- class **java.io.OptionalDataException**
- class **java.io.OutputStream**
- class **java.io.OutputStreamWriter**
- class **java.io.PipedInputStream**
- class **java.io.PipedOutputStream**
- class **java.io.PipedReader**
- class **java.io.PipedWriter**
- class **java.io.PrintStream**
- class **java.io.PrintWriter**
- class **java.io.PushbackInputStream**
- class **java.io.PushbackReader**
- class **java.io.RandomAccessFile**
- class **java.io.Reader**
- class **java.io.SequenceInputStream**
- interface **java.io.Serializable**
- class **java.io.SerializablePermission**
- class **java.io.StreamCorruptedException**
- class **java.io.StreamTokenizer**
- class **java.io.StringBufferInputStream**
- class **java.io.StringReader**
- class **java.io.StringWriter**
- class **java.io.SyncFailedException**
- class **java.io.UTFDataFormatException**
- class **java.io.UncheckedIOException**
- class **java.io.UnsupportedEncodingException**
- class **java.io.WriteAbortedException**
- class **java.io.Writer**

## Contributors

[Eugene Potapenko](https://github.com/potapenko/)

## License

Distributed under the Eclipse Public License, the same as Clojure.
