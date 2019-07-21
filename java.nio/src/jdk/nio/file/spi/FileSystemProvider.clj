(ns jdk.nio.file.spi.FileSystemProvider
  "Service-provider class for file systems. The methods defined by the Files class will typically delegate to an instance of this
  class.

   A file system provider is a concrete implementation of this class that
  implements the abstract methods defined by this class. A provider is
  identified by a URI scheme. The default provider
  is identified by the URI scheme \"file\". It creates the FileSystem that
  provides access to the file systems accessible to the Java virtual machine.
  The FileSystems class defines how file system providers are located
  and loaded. The default provider is typically a system-default provider but
  may be overridden if the system property java.nio.file.spi.DefaultFileSystemProvider is set. In that case, the
  provider has a one argument constructor whose formal parameter type is FileSystemProvider. All other providers have a zero argument constructor
  that initializes the provider.

   A provider is a factory for one or more FileSystem instances. Each
  file system is identified by a URI where the URI's scheme matches
  the provider's scheme. The default file system, for example,
  is identified by the URI \"file:///\". A memory-based file system,
  for example, may be identified by a URI such as \"memory:///?name=logfs\".
  The newFileSystem method may be used to create a file
  system, and the getFileSystem method may be used to
  obtain a reference to an existing file system created by the provider. Where
  a provider is the factory for a single file system then it is provider dependent
  if the file system is created when the provider is initialized, or later when
  the newFileSystem method is invoked. In the case of the default
  provider, the FileSystem is created when the provider is initialized.

   All of the methods in this class are safe for use by multiple concurrent
  threads."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.file.spi FileSystemProvider]))

(defn *installed-providers
  "Returns a list of the installed file system providers.

    The first invocation of this method causes the default provider to be
   initialized (if not already initialized) and loads any other installed
   providers as described by the FileSystems class.

  returns: An unmodifiable list of the installed file system providers. The
            list contains at least one element, that is the default file
            system provider - `java.util.List<java.nio.file.spi.FileSystemProvider>`

  throws: java.util.ServiceConfigurationError - When an error occurs while loading a service provider"
  (^java.util.List []
    (FileSystemProvider/installedProviders )))

(defn create-symbolic-link
  "Creates a symbolic link to a target. This method works in exactly the
   manner specified by the Files.createSymbolicLink(java.nio.file.Path, java.nio.file.Path, java.nio.file.attribute.FileAttribute<?>...) method.

    The default implementation of this method throws UnsupportedOperationException.

  link - the path of the symbolic link to create - `java.nio.file.Path`
  target - the target of the symbolic link - `java.nio.file.Path`
  attrs - the array of attributes to set atomically when creating the symbolic link - `java.nio.file.attribute.FileAttribute`

  throws: java.lang.UnsupportedOperationException - if the implementation does not support symbolic links or the array contains an attribute that cannot be set atomically when creating the symbolic link"
  ([^FileSystemProvider this ^java.nio.file.Path link ^java.nio.file.Path target ^java.nio.file.attribute.FileAttribute attrs]
    (-> this (.createSymbolicLink link target attrs))))

(defn copy
  "Copy a file to a target file. This method works in exactly the manner
   specified by the Files.copy(Path,Path,CopyOption[]) method
   except that both the source and target paths must be associated with
   this provider.

  source - the path to the file to copy - `java.nio.file.Path`
  target - the path to the target file - `java.nio.file.Path`
  options - options specifying how the copy should be done - `java.nio.file.CopyOption`

  throws: java.lang.UnsupportedOperationException - if the array contains a copy option that is not supported"
  ([^FileSystemProvider this ^java.nio.file.Path source ^java.nio.file.Path target ^java.nio.file.CopyOption options]
    (-> this (.copy source target options))))

(defn get-file-system
  "Returns an existing FileSystem created by this provider.

    This method returns a reference to a FileSystem that was
   created by invoking the newFileSystem(URI,Map)
   method. File systems created the newFileSystem(Path,Map) method are not returned by this method.
   The file system is identified by its URI. Its exact form
   is highly provider dependent. In the case of the default provider the URI's
   path component is \"/\" and the authority, query and fragment components
   are undefined (Undefined components are represented by null).

    Once a file system created by this provider is closed it is provider-dependent if this
   method returns a reference to the closed file system or throws FileSystemNotFoundException. If the provider allows a new file system to
   be created with the same URI as a file system it previously created then
   this method throws the exception if invoked after the file system is
   closed (and before a new instance is created by the newFileSystem method).

    If a security manager is installed then a provider implementation
   may require to check a permission before returning a reference to an
   existing file system. In the case of the default file system, no permission check is required.

  uri - URI reference - `java.net.URI`

  returns: The file system - `java.nio.file.FileSystem`

  throws: java.lang.IllegalArgumentException - If the pre-conditions for the uri parameter aren't met"
  (^java.nio.file.FileSystem [^FileSystemProvider this ^java.net.URI uri]
    (-> this (.getFileSystem uri))))

(defn delete
  "Deletes a file. This method works in exactly the  manner specified by the
   Files.delete(java.nio.file.Path) method.

  path - the path to the file to delete - `java.nio.file.Path`

  throws: java.nio.file.NoSuchFileException - if the file does not exist (optional specific exception)"
  ([^FileSystemProvider this ^java.nio.file.Path path]
    (-> this (.delete path))))

(defn read-attributes
  "Reads a file's attributes as a bulk operation. This method works in
   exactly the manner specified by the Files.readAttributes(Path,Class,LinkOption[]) method.

  path - the path to the file - `java.nio.file.Path`
  type - the Class of the file attributes required to read - `java.lang.Class`
  options - options indicating how symbolic links are handled - `java.nio.file.LinkOption`

  returns: the file attributes - `<A extends java.nio.file.attribute.BasicFileAttributes> A`

  throws: java.lang.UnsupportedOperationException - if an attributes of the given type are not supported"
  ([^FileSystemProvider this ^java.nio.file.Path path ^java.lang.Class type ^java.nio.file.LinkOption options]
    (-> this (.readAttributes path type options))))

(defn new-file-system
  "Constructs a new FileSystem object identified by a URI. This
   method is invoked by the FileSystems.newFileSystem(URI,Map)
   method to open a new file system identified by a URI.

    The uri parameter is an absolute, hierarchical URI, with a
   scheme equal (without regard to case) to the scheme supported by this
   provider. The exact form of the URI is highly provider dependent. The
   env parameter is a map of provider specific properties to configure
   the file system.

    This method throws FileSystemAlreadyExistsException if the
   file system already exists because it was previously created by an
   invocation of this method. Once a file system is closed it is provider-dependent if the
   provider allows a new file system to be created with the same URI as a
   file system it previously created.

  uri - URI reference - `java.net.URI`
  env - A map of provider specific properties to configure the file system; may be empty - `java.util.Map`

  returns: A new file system - `java.nio.file.FileSystem`

  throws: java.lang.IllegalArgumentException - If the pre-conditions for the uri parameter aren't met, or the env parameter does not contain properties required by the provider, or a property value is invalid"
  (^java.nio.file.FileSystem [^FileSystemProvider this ^java.net.URI uri ^java.util.Map env]
    (-> this (.newFileSystem uri env))))

(defn get-file-attribute-view
  "Returns a file attribute view of a given type. This method works in
   exactly the manner specified by the Files.getFileAttributeView(java.nio.file.Path, java.lang.Class<V>, java.nio.file.LinkOption...)
   method.

  path - the path to the file - `java.nio.file.Path`
  type - the Class object corresponding to the file attribute view - `java.lang.Class`
  options - options indicating how symbolic links are handled - `java.nio.file.LinkOption`

  returns: a file attribute view of the specified type, or null if
            the attribute view type is not available - `<V extends java.nio.file.attribute.FileAttributeView> V`"
  ([^FileSystemProvider this ^java.nio.file.Path path ^java.lang.Class type ^java.nio.file.LinkOption options]
    (-> this (.getFileAttributeView path type options))))

(defn create-link
  "Creates a new link (directory entry) for an existing file. This method
   works in exactly the manner specified by the Files.createLink(java.nio.file.Path, java.nio.file.Path)
   method.

    The default implementation of this method throws UnsupportedOperationException.

  link - the link (directory entry) to create - `java.nio.file.Path`
  existing - a path to an existing file - `java.nio.file.Path`

  throws: java.lang.UnsupportedOperationException - if the implementation does not support adding an existing file to a directory"
  ([^FileSystemProvider this ^java.nio.file.Path link ^java.nio.file.Path existing]
    (-> this (.createLink link existing))))

(defn same-file?
  "Tests if two paths locate the same file. This method works in exactly the
   manner specified by the Files.isSameFile(java.nio.file.Path, java.nio.file.Path) method.

  path - one path to the file - `java.nio.file.Path`
  path-2 - the other path - `java.nio.file.Path`

  returns: true if, and only if, the two paths locate the same file - `boolean`

  throws: java.io.IOException - if an I/O error occurs"
  (^Boolean [^FileSystemProvider this ^java.nio.file.Path path ^java.nio.file.Path path-2]
    (-> this (.isSameFile path path-2))))

(defn get-path
  "Return a Path object by converting the given URI. The
   resulting Path is associated with a FileSystem that
   already exists or is constructed automatically.

    The exact form of the URI is file system provider dependent. In the
   case of the default provider, the URI scheme is \"file\" and the
   given URI has a non-empty path component, and undefined query, and
   fragment components. The resulting Path is associated with the
   default default FileSystem.

    If a security manager is installed then a provider implementation
   may require to check a permission. In the case of the default file system, no permission check is
   required.

  uri - The URI to convert - `java.net.URI`

  returns: The resulting Path - `java.nio.file.Path`

  throws: java.lang.IllegalArgumentException - If the URI scheme does not identify this provider or other preconditions on the uri parameter do not hold"
  (^java.nio.file.Path [^FileSystemProvider this ^java.net.URI uri]
    (-> this (.getPath uri))))

(defn check-access
  "Checks the existence, and optionally the accessibility, of a file.

    This method may be used by the isReadable,
   isWritable and isExecutable methods to check the accessibility of a file.

    This method checks the existence of a file and that this Java virtual
   machine has appropriate privileges that would allow it access the file
   according to all of access modes specified in the modes parameter
   as follows:


    Value Description

      READ
      Checks that the file exists and that the Java virtual machine has
       permission to read the file.


      WRITE
      Checks that the file exists and that the Java virtual machine has
       permission to write to the file,


      EXECUTE
      Checks that the file exists and that the Java virtual machine has
       permission to execute the file. The semantics
       may differ when checking access to a directory. For example, on UNIX
       systems, checking for EXECUTE access checks that the Java
       virtual machine has permission to search the directory in order to
       access file or subdirectories.



    If the modes parameter is of length zero, then the existence
   of the file is checked.

    This method follows symbolic links if the file referenced by this
   object is a symbolic link. Depending on the implementation, this method
   may require to read file permissions, access control lists, or other
   file attributes in order to check the effective access to the file. To
   determine the effective access to a file may require access to several
   attributes and so in some implementations this method may not be atomic
   with respect to other file system operations.

  path - the path to the file to check - `java.nio.file.Path`
  modes - The access modes to check; may have zero elements - `java.nio.file.AccessMode`

  throws: java.lang.UnsupportedOperationException - an implementation is required to support checking for READ, WRITE, and EXECUTE access. This exception is specified to allow for the Access enum to be extended in future releases."
  ([^FileSystemProvider this ^java.nio.file.Path path ^java.nio.file.AccessMode modes]
    (-> this (.checkAccess path modes))))

(defn new-input-stream
  "Opens a file, returning an input stream to read from the file. This
   method works in exactly the manner specified by the Files.newInputStream(java.nio.file.Path, java.nio.file.OpenOption...) method.

    The default implementation of this method opens a channel to the file
   as if by invoking the newByteChannel(java.nio.file.Path, java.util.Set<? extends java.nio.file.OpenOption>, java.nio.file.attribute.FileAttribute<?>...) method and constructs a
   stream that reads bytes from the channel. This method should be overridden
   where appropriate.

  path - the path to the file to open - `java.nio.file.Path`
  options - options specifying how the file is opened - `java.nio.file.OpenOption`

  returns: a new input stream - `java.io.InputStream`

  throws: java.lang.IllegalArgumentException - if an invalid combination of options is specified"
  (^java.io.InputStream [^FileSystemProvider this ^java.nio.file.Path path ^java.nio.file.OpenOption options]
    (-> this (.newInputStream path options))))

(defn new-file-channel
  "Opens or creates a file for reading and/or writing, returning a file
   channel to access the file. This method works in exactly the manner
   specified by the FileChannel.open method. A provider that does not support all the
   features required to construct a file channel throws UnsupportedOperationException. The default provider is required to
   support the creation of file channels. When not overridden, the default
   implementation throws UnsupportedOperationException.

  path - the path of the file to open or create - `java.nio.file.Path`
  options - options specifying how the file is opened - `java.util.Set`
  attrs - an optional list of file attributes to set atomically when creating the file - `java.nio.file.attribute.FileAttribute`

  returns: a new file channel - `java.nio.channels.FileChannel`

  throws: java.lang.IllegalArgumentException - If the set contains an invalid combination of options"
  (^java.nio.channels.FileChannel [^FileSystemProvider this ^java.nio.file.Path path ^java.util.Set options ^java.nio.file.attribute.FileAttribute attrs]
    (-> this (.newFileChannel path options attrs))))

(defn delete-if-exists
  "Deletes a file if it exists. This method works in exactly the manner
   specified by the Files.deleteIfExists(java.nio.file.Path) method.

    The default implementation of this method simply invokes delete(java.nio.file.Path) ignoring the NoSuchFileException when the file does not
   exist. It may be overridden where appropriate.

  path - the path to the file to delete - `java.nio.file.Path`

  returns: true if the file was deleted by this method; false if the file could not be deleted because it did not
            exist - `boolean`

  throws: java.nio.file.DirectoryNotEmptyException - if the file is a directory and could not otherwise be deleted because the directory is not empty (optional specific exception)"
  (^Boolean [^FileSystemProvider this ^java.nio.file.Path path]
    (-> this (.deleteIfExists path))))

(defn get-scheme
  "Returns the URI scheme that identifies this provider.

  returns: The URI scheme - `java.lang.String`"
  (^java.lang.String [^FileSystemProvider this]
    (-> this (.getScheme))))

(defn get-file-store
  "Returns the FileStore representing the file store where a file
   is located. This method works in exactly the manner specified by the
   Files.getFileStore(java.nio.file.Path) method.

  path - the path to the file - `java.nio.file.Path`

  returns: the file store where the file is stored - `java.nio.file.FileStore`

  throws: java.io.IOException - if an I/O error occurs"
  (^java.nio.file.FileStore [^FileSystemProvider this ^java.nio.file.Path path]
    (-> this (.getFileStore path))))

(defn read-symbolic-link
  "Reads the target of a symbolic link. This method works in exactly the
   manner specified by the Files.readSymbolicLink(java.nio.file.Path) method.

    The default implementation of this method throws UnsupportedOperationException.

  link - the path to the symbolic link - `java.nio.file.Path`

  returns: The target of the symbolic link - `java.nio.file.Path`

  throws: java.lang.UnsupportedOperationException - if the implementation does not support symbolic links"
  (^java.nio.file.Path [^FileSystemProvider this ^java.nio.file.Path link]
    (-> this (.readSymbolicLink link))))

(defn hidden?
  "Tells whether or not a file is considered hidden. This method
   works in exactly the manner specified by the Files.isHidden(java.nio.file.Path)
   method.

    This method is invoked by the isHidden method.

  path - the path to the file to test - `java.nio.file.Path`

  returns: true if the file is considered hidden - `boolean`

  throws: java.io.IOException - if an I/O error occurs"
  (^Boolean [^FileSystemProvider this ^java.nio.file.Path path]
    (-> this (.isHidden path))))

(defn set-attribute
  "Sets the value of a file attribute. This method works in exactly the
   manner specified by the Files.setAttribute(java.nio.file.Path, java.lang.String, java.lang.Object, java.nio.file.LinkOption...) method.

  path - the path to the file - `java.nio.file.Path`
  attribute - the attribute to set - `java.lang.String`
  value - the attribute value - `java.lang.Object`
  options - options indicating how symbolic links are handled - `java.nio.file.LinkOption`

  throws: java.lang.UnsupportedOperationException - if the attribute view is not available"
  ([^FileSystemProvider this ^java.nio.file.Path path ^java.lang.String attribute ^java.lang.Object value ^java.nio.file.LinkOption options]
    (-> this (.setAttribute path attribute value options))))

(defn new-byte-channel
  "Opens or creates a file, returning a seekable byte channel to access the
   file. This method works in exactly the manner specified by the Files.newByteChannel(Path,Set,FileAttribute[]) method.

  path - the path to the file to open or create - `java.nio.file.Path`
  options - options specifying how the file is opened - `java.util.Set`
  attrs - an optional list of file attributes to set atomically when creating the file - `java.nio.file.attribute.FileAttribute`

  returns: a new seekable byte channel - `java.nio.channels.SeekableByteChannel`

  throws: java.lang.IllegalArgumentException - if the set contains an invalid combination of options"
  (^java.nio.channels.SeekableByteChannel [^FileSystemProvider this ^java.nio.file.Path path ^java.util.Set options ^java.nio.file.attribute.FileAttribute attrs]
    (-> this (.newByteChannel path options attrs))))

(defn move
  "Move or rename a file to a target file. This method works in exactly the
   manner specified by the Files.move(java.nio.file.Path, java.nio.file.Path, java.nio.file.CopyOption...) method except that both the
   source and target paths must be associated with this provider.

  source - the path to the file to move - `java.nio.file.Path`
  target - the path to the target file - `java.nio.file.Path`
  options - options specifying how the move should be done - `java.nio.file.CopyOption`

  throws: java.lang.UnsupportedOperationException - if the array contains a copy option that is not supported"
  ([^FileSystemProvider this ^java.nio.file.Path source ^java.nio.file.Path target ^java.nio.file.CopyOption options]
    (-> this (.move source target options))))

(defn new-asynchronous-file-channel
  "Opens or creates a file for reading and/or writing, returning an
   asynchronous file channel to access the file. This method works in
   exactly the manner specified by the AsynchronousFileChannel.open method.
   A provider that does not support all the features required to construct
   an asynchronous file channel throws UnsupportedOperationException.
   The default provider is required to support the creation of asynchronous
   file channels. When not overridden, the default implementation of this
   method throws UnsupportedOperationException.

  path - the path of the file to open or create - `java.nio.file.Path`
  options - options specifying how the file is opened - `java.util.Set`
  executor - the thread pool or null to associate the channel with the default thread pool - `java.util.concurrent.ExecutorService`
  attrs - an optional list of file attributes to set atomically when creating the file - `java.nio.file.attribute.FileAttribute`

  returns: a new asynchronous file channel - `java.nio.channels.AsynchronousFileChannel`

  throws: java.lang.IllegalArgumentException - If the set contains an invalid combination of options"
  (^java.nio.channels.AsynchronousFileChannel [^FileSystemProvider this ^java.nio.file.Path path ^java.util.Set options ^java.util.concurrent.ExecutorService executor ^java.nio.file.attribute.FileAttribute attrs]
    (-> this (.newAsynchronousFileChannel path options executor attrs))))

(defn new-directory-stream
  "Opens a directory, returning a DirectoryStream to iterate over
   the entries in the directory. This method works in exactly the manner
   specified by the Files.newDirectoryStream(java.nio.file.Path, java.nio.file.DirectoryStream.Filter)
   method.

  dir - the path to the directory - `java.nio.file.Path`
  filter - the directory stream filter - `java.nio.file.DirectoryStream$Filter`

  returns: a new and open DirectoryStream object - `java.nio.file.DirectoryStream<java.nio.file.Path>`

  throws: java.nio.file.NotDirectoryException - if the file could not otherwise be opened because it is not a directory (optional specific exception)"
  (^java.nio.file.DirectoryStream [^FileSystemProvider this ^java.nio.file.Path dir ^java.nio.file.DirectoryStream$Filter filter]
    (-> this (.newDirectoryStream dir filter))))

(defn create-directory
  "Creates a new directory. This method works in exactly the manner
   specified by the Files.createDirectory(java.nio.file.Path, java.nio.file.attribute.FileAttribute<?>...) method.

  dir - the directory to create - `java.nio.file.Path`
  attrs - an optional list of file attributes to set atomically when creating the directory - `java.nio.file.attribute.FileAttribute`

  throws: java.lang.UnsupportedOperationException - if the array contains an attribute that cannot be set atomically when creating the directory"
  ([^FileSystemProvider this ^java.nio.file.Path dir ^java.nio.file.attribute.FileAttribute attrs]
    (-> this (.createDirectory dir attrs))))

(defn new-output-stream
  "Opens or creates a file, returning an output stream that may be used to
   write bytes to the file. This method works in exactly the manner
   specified by the Files.newOutputStream(java.nio.file.Path, java.nio.file.OpenOption...) method.

    The default implementation of this method opens a channel to the file
   as if by invoking the newByteChannel(java.nio.file.Path, java.util.Set<? extends java.nio.file.OpenOption>, java.nio.file.attribute.FileAttribute<?>...) method and constructs a
   stream that writes bytes to the channel. This method should be overridden
   where appropriate.

  path - the path to the file to open or create - `java.nio.file.Path`
  options - options specifying how the file is opened - `java.nio.file.OpenOption`

  returns: a new output stream - `java.io.OutputStream`

  throws: java.lang.IllegalArgumentException - if options contains an invalid combination of options"
  (^java.io.OutputStream [^FileSystemProvider this ^java.nio.file.Path path ^java.nio.file.OpenOption options]
    (-> this (.newOutputStream path options))))

