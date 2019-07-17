# Bindings for javax.imageio

These bindings are created to simplify interaction with java classes from clojure.
For each java class was created a separate namespace.
Each method/field has its own function/field binding.
Their names are changed for a more native look in the clojure code. Each function has docstring - information about the parameters, return value and possible exceptions.

## Note

All namespaces starting with **java.** are renamed to **jdk.** (java compiler limitation). 

**java.io.File** renamed to **jdk.io.File** for example. 




## Clojars

```
[clojure-interop/javax.imageio "0.1.0-SNAPSHOT"]
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

- class **javax.imageio.IIOException**
- class **javax.imageio.IIOImage**
- class **javax.imageio.IIOParam**
- interface **javax.imageio.IIOParamController**
- class **javax.imageio.ImageIO**
- class **javax.imageio.ImageReadParam**
- class **javax.imageio.ImageReader**
- interface **javax.imageio.ImageTranscoder**
- class **javax.imageio.ImageTypeSpecifier**
- class **javax.imageio.ImageWriteParam**
- class **javax.imageio.ImageWriter**
- interface **javax.imageio.event.IIOReadProgressListener**
- interface **javax.imageio.event.IIOReadUpdateListener**
- interface **javax.imageio.event.IIOReadWarningListener**
- interface **javax.imageio.event.IIOWriteProgressListener**
- interface **javax.imageio.event.IIOWriteWarningListener**
- class **javax.imageio.metadata.IIOInvalidTreeException**
- class **javax.imageio.metadata.IIOMetadata**
- interface **javax.imageio.metadata.IIOMetadataController**
- interface **javax.imageio.metadata.IIOMetadataFormat**
- class **javax.imageio.metadata.IIOMetadataFormatImpl**
- class **javax.imageio.metadata.IIOMetadataNode**
- class **javax.imageio.plugins.bmp.BMPImageWriteParam**
- class **javax.imageio.plugins.jpeg.JPEGHuffmanTable**
- class **javax.imageio.plugins.jpeg.JPEGImageReadParam**
- class **javax.imageio.plugins.jpeg.JPEGImageWriteParam**
- class **javax.imageio.plugins.jpeg.JPEGQTable**
- class **javax.imageio.spi.IIORegistry**
- class **javax.imageio.spi.IIOServiceProvider**
- class **javax.imageio.spi.ImageInputStreamSpi**
- class **javax.imageio.spi.ImageOutputStreamSpi**
- class **javax.imageio.spi.ImageReaderSpi**
- class **javax.imageio.spi.ImageReaderWriterSpi**
- class **javax.imageio.spi.ImageTranscoderSpi**
- class **javax.imageio.spi.ImageWriterSpi**
- interface **javax.imageio.spi.RegisterableService**
- interface **javax.imageio.spi.ServiceRegistry$Filter**
- class **javax.imageio.spi.ServiceRegistry**
- class **javax.imageio.stream.FileCacheImageInputStream**
- class **javax.imageio.stream.FileCacheImageOutputStream**
- class **javax.imageio.stream.FileImageInputStream**
- class **javax.imageio.stream.FileImageOutputStream**
- class **javax.imageio.stream.IIOByteBuffer**
- interface **javax.imageio.stream.ImageInputStream**
- class **javax.imageio.stream.ImageInputStreamImpl**
- interface **javax.imageio.stream.ImageOutputStream**
- class **javax.imageio.stream.ImageOutputStreamImpl**
- class **javax.imageio.stream.MemoryCacheImageInputStream**
- class **javax.imageio.stream.MemoryCacheImageOutputStream**

## Contributors

[Eugene Potapenko](https://github.com/potapenko/)

## License

Distributed under the Eclipse Public License, the same as Clojure.
