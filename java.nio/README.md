# Bindings for java.nio

These bindings are created to simplify interaction with java classes from clojure.
For each java class was created a separate namespace.
Each method/field has its own function/field binding.
Their names are changed for a more native look in the clojure code. Each function has docstring - information about the parameters, return value and possible exceptions.

## Note

All namespaces starting with **java.** are renamed to **jdk.** (java compiler limitation). 

**java.io.File** renamed to **jdk.io.File** for example. 




## Clojars

```
[clojure-interop/java.nio "1.0.4"]
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

- class **java.nio.Buffer**
- class **java.nio.BufferOverflowException**
- class **java.nio.BufferUnderflowException**
- class **java.nio.ByteBuffer**
- class **java.nio.ByteOrder**
- class **java.nio.CharBuffer**
- class **java.nio.DoubleBuffer**
- class **java.nio.FloatBuffer**
- class **java.nio.IntBuffer**
- class **java.nio.InvalidMarkException**
- class **java.nio.LongBuffer**
- class **java.nio.MappedByteBuffer**
- class **java.nio.ReadOnlyBufferException**
- class **java.nio.ShortBuffer**
- class **java.nio.channels.AcceptPendingException**
- class **java.nio.channels.AlreadyBoundException**
- class **java.nio.channels.AlreadyConnectedException**
- interface **java.nio.channels.AsynchronousByteChannel**
- interface **java.nio.channels.AsynchronousChannel**
- class **java.nio.channels.AsynchronousChannelGroup**
- class **java.nio.channels.AsynchronousCloseException**
- class **java.nio.channels.AsynchronousFileChannel**
- class **java.nio.channels.AsynchronousServerSocketChannel**
- class **java.nio.channels.AsynchronousSocketChannel**
- interface **java.nio.channels.ByteChannel**
- class **java.nio.channels.CancelledKeyException**
- interface **java.nio.channels.Channel**
- class **java.nio.channels.Channels**
- class **java.nio.channels.ClosedByInterruptException**
- class **java.nio.channels.ClosedChannelException**
- class **java.nio.channels.ClosedSelectorException**
- interface **java.nio.channels.CompletionHandler**
- class **java.nio.channels.ConnectionPendingException**
- class **java.nio.channels.DatagramChannel**
- class **java.nio.channels.FileChannel$MapMode**
- class **java.nio.channels.FileChannel**
- class **java.nio.channels.FileLock**
- class **java.nio.channels.FileLockInterruptionException**
- interface **java.nio.channels.GatheringByteChannel**
- class **java.nio.channels.IllegalBlockingModeException**
- class **java.nio.channels.IllegalChannelGroupException**
- class **java.nio.channels.IllegalSelectorException**
- class **java.nio.channels.InterruptedByTimeoutException**
- interface **java.nio.channels.InterruptibleChannel**
- class **java.nio.channels.MembershipKey**
- interface **java.nio.channels.MulticastChannel**
- interface **java.nio.channels.NetworkChannel**
- class **java.nio.channels.NoConnectionPendingException**
- class **java.nio.channels.NonReadableChannelException**
- class **java.nio.channels.NonWritableChannelException**
- class **java.nio.channels.NotYetBoundException**
- class **java.nio.channels.NotYetConnectedException**
- class **java.nio.channels.OverlappingFileLockException**
- class **java.nio.channels.Pipe$SinkChannel**
- class **java.nio.channels.Pipe$SourceChannel**
- class **java.nio.channels.Pipe**
- class **java.nio.channels.ReadPendingException**
- interface **java.nio.channels.ReadableByteChannel**
- interface **java.nio.channels.ScatteringByteChannel**
- interface **java.nio.channels.SeekableByteChannel**
- class **java.nio.channels.SelectableChannel**
- class **java.nio.channels.SelectionKey**
- class **java.nio.channels.Selector**
- class **java.nio.channels.ServerSocketChannel**
- class **java.nio.channels.ShutdownChannelGroupException**
- class **java.nio.channels.SocketChannel**
- class **java.nio.channels.UnresolvedAddressException**
- class **java.nio.channels.UnsupportedAddressTypeException**
- interface **java.nio.channels.WritableByteChannel**
- class **java.nio.channels.WritePendingException**
- class **java.nio.channels.spi.AbstractInterruptibleChannel**
- class **java.nio.channels.spi.AbstractSelectableChannel**
- class **java.nio.channels.spi.AbstractSelectionKey**
- class **java.nio.channels.spi.AbstractSelector**
- class **java.nio.channels.spi.AsynchronousChannelProvider**
- class **java.nio.channels.spi.SelectorProvider**
- class **java.nio.charset.CharacterCodingException**
- class **java.nio.charset.Charset**
- class **java.nio.charset.CharsetDecoder**
- class **java.nio.charset.CharsetEncoder**
- class **java.nio.charset.CoderMalfunctionError**
- class **java.nio.charset.CoderResult**
- class **java.nio.charset.CodingErrorAction**
- class **java.nio.charset.IllegalCharsetNameException**
- class **java.nio.charset.MalformedInputException**
- class **java.nio.charset.StandardCharsets**
- class **java.nio.charset.UnmappableCharacterException**
- class **java.nio.charset.UnsupportedCharsetException**
- class **java.nio.charset.spi.CharsetProvider**
- class **java.nio.file.AccessDeniedException**
- enum **java.nio.file.AccessMode**
- class **java.nio.file.AtomicMoveNotSupportedException**
- class **java.nio.file.ClosedDirectoryStreamException**
- class **java.nio.file.ClosedFileSystemException**
- class **java.nio.file.ClosedWatchServiceException**
- interface **java.nio.file.CopyOption**
- class **java.nio.file.DirectoryIteratorException**
- class **java.nio.file.DirectoryNotEmptyException**
- interface **java.nio.file.DirectoryStream$Filter**
- interface **java.nio.file.DirectoryStream**
- class **java.nio.file.FileAlreadyExistsException**
- class **java.nio.file.FileStore**
- class **java.nio.file.FileSystem**
- class **java.nio.file.FileSystemAlreadyExistsException**
- class **java.nio.file.FileSystemException**
- class **java.nio.file.FileSystemLoopException**
- class **java.nio.file.FileSystemNotFoundException**
- class **java.nio.file.FileSystems**
- enum **java.nio.file.FileVisitOption**
- enum **java.nio.file.FileVisitResult**
- interface **java.nio.file.FileVisitor**
- class **java.nio.file.Files**
- class **java.nio.file.InvalidPathException**
- enum **java.nio.file.LinkOption**
- class **java.nio.file.LinkPermission**
- class **java.nio.file.NoSuchFileException**
- class **java.nio.file.NotDirectoryException**
- class **java.nio.file.NotLinkException**
- interface **java.nio.file.OpenOption**
- interface **java.nio.file.Path**
- interface **java.nio.file.PathMatcher**
- class **java.nio.file.Paths**
- class **java.nio.file.ProviderMismatchException**
- class **java.nio.file.ProviderNotFoundException**
- class **java.nio.file.ReadOnlyFileSystemException**
- interface **java.nio.file.SecureDirectoryStream**
- class **java.nio.file.SimpleFileVisitor**
- enum **java.nio.file.StandardCopyOption**
- enum **java.nio.file.StandardOpenOption**
- class **java.nio.file.StandardWatchEventKinds**
- interface **java.nio.file.WatchEvent$Kind**
- interface **java.nio.file.WatchEvent$Modifier**
- interface **java.nio.file.WatchEvent**
- interface **java.nio.file.WatchKey**
- interface **java.nio.file.WatchService**
- interface **java.nio.file.Watchable**
- class **java.nio.file.attribute.AclEntry$Builder**
- class **java.nio.file.attribute.AclEntry**
- enum **java.nio.file.attribute.AclEntryFlag**
- enum **java.nio.file.attribute.AclEntryPermission**
- enum **java.nio.file.attribute.AclEntryType**
- interface **java.nio.file.attribute.AclFileAttributeView**
- interface **java.nio.file.attribute.AttributeView**
- interface **java.nio.file.attribute.BasicFileAttributeView**
- interface **java.nio.file.attribute.BasicFileAttributes**
- interface **java.nio.file.attribute.DosFileAttributeView**
- interface **java.nio.file.attribute.DosFileAttributes**
- interface **java.nio.file.attribute.FileAttribute**
- interface **java.nio.file.attribute.FileAttributeView**
- interface **java.nio.file.attribute.FileOwnerAttributeView**
- interface **java.nio.file.attribute.FileStoreAttributeView**
- class **java.nio.file.attribute.FileTime**
- interface **java.nio.file.attribute.GroupPrincipal**
- interface **java.nio.file.attribute.PosixFileAttributeView**
- interface **java.nio.file.attribute.PosixFileAttributes**
- enum **java.nio.file.attribute.PosixFilePermission**
- class **java.nio.file.attribute.PosixFilePermissions**
- interface **java.nio.file.attribute.UserDefinedFileAttributeView**
- interface **java.nio.file.attribute.UserPrincipal**
- class **java.nio.file.attribute.UserPrincipalLookupService**
- class **java.nio.file.attribute.UserPrincipalNotFoundException**
- class **java.nio.file.spi.FileSystemProvider**
- class **java.nio.file.spi.FileTypeDetector**

## Contributors

[Eugene Potapenko](https://github.com/potapenko/)

## License

Distributed under the Eclipse Public License, the same as Clojure.
