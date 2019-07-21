(ns jdk.nio.file.Files
  "This class consists exclusively of static methods that operate on files,
  directories, or other types of files.

   In most cases, the methods defined here will delegate to the associated
  file system provider to perform the file operations."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.file Files]))

(defn *create-temp-file
  "Creates a new empty file in the specified directory, using the given
   prefix and suffix strings to generate its name. The resulting
   Path is associated with the same FileSystem as the given
   directory.

    The details as to how the name of the file is constructed is
   implementation dependent and therefore not specified. Where possible
   the prefix and suffix are used to construct candidate
   names in the same manner as the File.createTempFile(String,String,File) method.

    As with the File.createTempFile methods, this method is only
   part of a temporary-file facility. Where used as a work files,
   the resulting file may be opened using the DELETE_ON_CLOSE option so that the
   file is deleted when the appropriate close method is invoked.
   Alternatively, a shutdown-hook, or the
   File.deleteOnExit() mechanism may be used to delete the
   file automatically.

    The attrs parameter is optional file-attributes to set atomically when creating the file. Each attribute
   is identified by its name. If more than one
   attribute of the same name is included in the array then all but the last
   occurrence is ignored. When no file attributes are specified, then the
   resulting file may have more restrictive access permissions to files
   created by the File.createTempFile(String,String,File)
   method.

  dir - the path to directory in which to create the file - `java.nio.file.Path`
  prefix - the prefix string to be used in generating the file's name; may be null - `java.lang.String`
  suffix - the suffix string to be used in generating the file's name; may be null, in which case \".tmp\" is used - `java.lang.String`
  attrs - an optional list of file attributes to set atomically when creating the file - `java.nio.file.attribute.FileAttribute`

  returns: the path to the newly created file that did not exist before
            this method was invoked - `java.nio.file.Path`

  throws: java.lang.IllegalArgumentException - if the prefix or suffix parameters cannot be used to generate a candidate file name"
  (^java.nio.file.Path [^java.nio.file.Path dir ^java.lang.String prefix ^java.lang.String suffix ^java.nio.file.attribute.FileAttribute attrs]
    (Files/createTempFile dir prefix suffix attrs))
  (^java.nio.file.Path [^java.lang.String prefix ^java.lang.String suffix ^java.nio.file.attribute.FileAttribute attrs]
    (Files/createTempFile prefix suffix attrs)))

(defn *not-exists
  "Tests whether the file located by this path does not exist. This method
   is intended for cases where it is required to take action when it can be
   confirmed that a file does not exist.

    The options parameter may be used to indicate how symbolic links
   are handled for the case that the file is a symbolic link. By default,
   symbolic links are followed. If the option NOFOLLOW_LINKS is present then symbolic links are not followed.

    Note that this method is not the complement of the exists method. Where it is not possible to determine if a file exists
   or not then both methods return false. As with the exists
   method, the result of this method is immediately outdated. If this
   method indicates the file does exist then there is no guarantee that a
   subsequence attempt to create the file will succeed. Care should be taken
   when using this method in security sensitive applications.

  path - the path to the file to test - `java.nio.file.Path`
  options - options indicating how symbolic links are handled - `java.nio.file.LinkOption`

  returns: true if the file does not exist; false if the
            file exists or its existence cannot be determined - `boolean`

  throws: java.lang.SecurityException - In the case of the default provider, the SecurityManager.checkRead(String) is invoked to check read access to the file."
  (^Boolean [^java.nio.file.Path path ^java.nio.file.LinkOption options]
    (Files/notExists path options)))

(defn *create-symbolic-link
  "Creates a symbolic link to a target (optional operation).

    The target parameter is the target of the link. It may be an
   absolute or relative path and may not exist. When
   the target is a relative path then file system operations on the resulting
   link are relative to the path of the link.

    The attrs parameter is optional attributes to set atomically when creating the link. Each attribute is
   identified by its name. If more than one attribute
   of the same name is included in the array then all but the last occurrence
   is ignored.

    Where symbolic links are supported, but the underlying FileStore
   does not support symbolic links, then this may fail with an IOException. Additionally, some operating systems may require that the
   Java virtual machine be started with implementation specific privileges to
   create symbolic links, in which case this method may throw IOException.

  link - the path of the symbolic link to create - `java.nio.file.Path`
  target - the target of the symbolic link - `java.nio.file.Path`
  attrs - the array of attributes to set atomically when creating the symbolic link - `java.nio.file.attribute.FileAttribute`

  returns: the path to the symbolic link - `java.nio.file.Path`

  throws: java.lang.UnsupportedOperationException - if the implementation does not support symbolic links or the array contains an attribute that cannot be set atomically when creating the symbolic link"
  (^java.nio.file.Path [^java.nio.file.Path link ^java.nio.file.Path target ^java.nio.file.attribute.FileAttribute attrs]
    (Files/createSymbolicLink link target attrs)))

(defn *list
  "Return a lazily populated Stream, the elements of
   which are the entries in the directory.  The listing is not recursive.

    The elements of the stream are Path objects that are
   obtained as if by resolving the name of the
   directory entry against dir. Some file systems maintain special
   links to the directory itself and the directory's parent directory.
   Entries representing these links are not included.

    The stream is weakly consistent. It is thread safe but does
   not freeze the directory while iterating, so it may (or may not)
   reflect updates to the directory that occur after returning from this
   method.

    The returned stream encapsulates a DirectoryStream.
   If timely disposal of file system resources is required, the
   try-with-resources construct should be used to ensure that the
   stream's close method is invoked after the stream
   operations are completed.

    Operating on a closed stream behaves as if the end of stream
   has been reached. Due to read-ahead, one or more elements may be
   returned after the stream has been closed.

    If an IOException is thrown when accessing the directory
   after this method has returned, it is wrapped in an UncheckedIOException which will be thrown from the method that caused
   the access to take place.

  dir - The path to the directory - `java.nio.file.Path`

  returns: The Stream describing the content of the
            directory - `java.util.stream.Stream<java.nio.file.Path>`

  throws: java.nio.file.NotDirectoryException - if the file could not otherwise be opened because it is not a directory (optional specific exception)"
  (^java.util.stream.Stream [^java.nio.file.Path dir]
    (Files/list dir)))

(defn *readable?
  "Tests whether a file is readable. This method checks that a file exists
   and that this Java virtual machine has appropriate privileges that would
   allow it open the file for reading. Depending on the implementation, this
   method may require to read file permissions, access control lists, or
   other file attributes in order to check the effective access to the file.
   Consequently, this method may not be atomic with respect to other file
   system operations.

    Note that the result of this method is immediately outdated, there is
   no guarantee that a subsequent attempt to open the file for reading will
   succeed (or even that it will access the same file). Care should be taken
   when using this method in security sensitive applications.

  path - the path to the file to check - `java.nio.file.Path`

  returns: true if the file exists and is readable; false
            if the file does not exist, read access would be denied because
            the Java virtual machine has insufficient privileges, or access
            cannot be determined - `boolean`

  throws: java.lang.SecurityException - In the case of the default provider, and a security manager is installed, the checkRead is invoked to check read access to the file."
  (^Boolean [^java.nio.file.Path path]
    (Files/isReadable path)))

(defn *create-file
  "Creates a new and empty file, failing if the file already exists. The
   check for the existence of the file and the creation of the new file if
   it does not exist are a single operation that is atomic with respect to
   all other filesystem activities that might affect the directory.

    The attrs parameter is optional file-attributes to set atomically when creating the file. Each attribute
   is identified by its name. If more than one
   attribute of the same name is included in the array then all but the last
   occurrence is ignored.

  path - the path to the file to create - `java.nio.file.Path`
  attrs - an optional list of file attributes to set atomically when creating the file - `java.nio.file.attribute.FileAttribute`

  returns: the file - `java.nio.file.Path`

  throws: java.lang.UnsupportedOperationException - if the array contains an attribute that cannot be set atomically when creating the file"
  (^java.nio.file.Path [^java.nio.file.Path path ^java.nio.file.attribute.FileAttribute attrs]
    (Files/createFile path attrs)))

(defn *set-posix-file-permissions
  "Sets a file's POSIX permissions.

    The path parameter is associated with a FileSystem
   that supports the PosixFileAttributeView. This attribute view
   provides access to file attributes commonly associated with files on file
   systems used by operating systems that implement the Portable Operating
   System Interface (POSIX) family of standards.

  path - The path to the file - `java.nio.file.Path`
  perms - The new set of permissions - `java.util.Set`

  returns: The path - `java.nio.file.Path`

  throws: java.lang.UnsupportedOperationException - if the associated file system does not support the PosixFileAttributeView"
  (^java.nio.file.Path [^java.nio.file.Path path ^java.util.Set perms]
    (Files/setPosixFilePermissions path perms)))

(defn *copy
  "Copy a file to a target file.

    This method copies a file to the target file with the options parameter specifying how the copy is performed. By default, the
   copy fails if the target file already exists or is a symbolic link,
   except if the source and target are the same file, in
   which case the method completes without copying the file. File attributes
   are not required to be copied to the target file. If symbolic links are
   supported, and the file is a symbolic link, then the final target of the
   link is copied. If the file is a directory then it creates an empty
   directory in the target location (entries in the directory are not
   copied). This method can be used with the walkFileTree method to copy a directory and all entries in the directory,
   or an entire file-tree where required.

    The options parameter may include any of the following:


    Option Description

      REPLACE_EXISTING
      If the target file exists, then the target file is replaced if it
       is not a non-empty directory. If the target file exists and is a
       symbolic link, then the symbolic link itself, not the target of
       the link, is replaced.


      COPY_ATTRIBUTES
      Attempts to copy the file attributes associated with this file to
       the target file. The exact file attributes that are copied is platform
       and file system dependent and therefore unspecified. Minimally, the
       last-modified-time is
       copied to the target file if supported by both the source and target
       file stores. Copying of file timestamps may result in precision
       loss.


      NOFOLLOW_LINKS
      Symbolic links are not followed. If the file is a symbolic link,
       then the symbolic link itself, not the target of the link, is copied.
       It is implementation specific if file attributes can be copied to the
       new link. In other words, the COPY_ATTRIBUTES option may be
       ignored when copying a symbolic link.



    An implementation of this interface may support additional
   implementation specific options.

    Copying a file is not an atomic operation. If an IOException
   is thrown, then it is possible that the target file is incomplete or some
   of its file attributes have not been copied from the source file. When
   the REPLACE_EXISTING option is specified and the target file
   exists, then the target file is replaced. The check for the existence of
   the file and the creation of the new file may not be atomic with respect
   to other file system activities.

    Usage Example:
   Suppose we want to copy a file into a directory, giving it the same file
   name as the source file:


       Path source = ...
       Path newdir = ...
       Files.copy(source, newdir.resolve(source.getFileName());

  source - the path to the file to copy - `java.nio.file.Path`
  target - the path to the target file (may be associated with a different provider to the source path) - `java.nio.file.Path`
  options - options specifying how the copy should be done - `java.nio.file.CopyOption`

  returns: the path to the target file - `java.nio.file.Path`

  throws: java.lang.UnsupportedOperationException - if the array contains a copy option that is not supported"
  (^java.nio.file.Path [^java.nio.file.Path source ^java.nio.file.Path target ^java.nio.file.CopyOption options]
    (Files/copy source target options))
  (^Long [^java.nio.file.Path source ^java.io.OutputStream out]
    (Files/copy source out)))

(defn *find
  "Return a Stream that is lazily populated with Path by searching for files in a file tree rooted at a given starting
   file.

    This method walks the file tree in exactly the manner specified by
   the walk method. For each file encountered, the given
   BiPredicate is invoked with its Path and BasicFileAttributes. The Path object is obtained as if by
   resolving the relative path against start and is only included in the returned Stream if
   the BiPredicate returns true. Compare to calling filter on the Stream
   returned by walk method, this method may be more efficient by
   avoiding redundant retrieval of the BasicFileAttributes.

    The returned stream encapsulates one or more DirectoryStreams.
   If timely disposal of file system resources is required, the
   try-with-resources construct should be used to ensure that the
   stream's close method is invoked after the stream
   operations are completed.  Operating on a closed stream will result in an
   IllegalStateException.

    If an IOException is thrown when accessing the directory
   after returned from this method, it is wrapped in an UncheckedIOException which will be thrown from the method that caused
   the access to take place.

  start - the starting file - `java.nio.file.Path`
  max-depth - the maximum number of directory levels to search - `int`
  matcher - the function used to decide whether a file should be included in the returned stream - `java.util.function.BiPredicate`
  options - options to configure the traversal - `java.nio.file.FileVisitOption`

  returns: the Stream of Path - `java.util.stream.Stream<java.nio.file.Path>`

  throws: java.lang.IllegalArgumentException - if the maxDepth parameter is negative"
  (^java.util.stream.Stream [^java.nio.file.Path start ^Integer max-depth ^java.util.function.BiPredicate matcher ^java.nio.file.FileVisitOption options]
    (Files/find start max-depth matcher options)))

(defn *set-owner
  "Updates the file owner.

    The path parameter is associated with a file system that
   supports FileOwnerAttributeView. This file attribute view provides
   access to a file attribute that is the owner of the file.

    Usage Example:
   Suppose we want to make \"joe\" the owner of a file:


       Path path = ...
       UserPrincipalLookupService lookupService =
           provider(path).getUserPrincipalLookupService();
       UserPrincipal joe = lookupService.lookupPrincipalByName(\"joe\");
       Files.setOwner(path, joe);

  path - The path to the file - `java.nio.file.Path`
  owner - The new file owner - `java.nio.file.attribute.UserPrincipal`

  returns: The path - `java.nio.file.Path`

  throws: java.lang.UnsupportedOperationException - if the associated file system does not support the FileOwnerAttributeView"
  (^java.nio.file.Path [^java.nio.file.Path path ^java.nio.file.attribute.UserPrincipal owner]
    (Files/setOwner path owner)))

(defn *lines
  "Read all lines from a file as a Stream. Unlike readAllLines, this method does not read
   all lines into a List, but instead populates lazily as the stream
   is consumed.

    Bytes from the file are decoded into characters using the specified
   charset and the same line terminators as specified by readAllLines are supported.

    After this method returns, then any subsequent I/O exception that
   occurs while reading from the file or when a malformed or unmappable byte
   sequence is read, is wrapped in an UncheckedIOException that will
   be thrown from the
   Stream method that caused the read to take
   place. In case an IOException is thrown when closing the file,
   it is also wrapped as an UncheckedIOException.

    The returned stream encapsulates a Reader.  If timely
   disposal of file system resources is required, the try-with-resources
   construct should be used to ensure that the stream's
   close method is invoked after the stream operations
   are completed.

  path - the path to the file - `java.nio.file.Path`
  cs - the charset to use for decoding - `java.nio.charset.Charset`

  returns: the lines from the file as a Stream - `java.util.stream.Stream<java.lang.String>`

  throws: java.io.IOException - if an I/O error occurs opening the file"
  (^java.util.stream.Stream [^java.nio.file.Path path ^java.nio.charset.Charset cs]
    (Files/lines path cs))
  (^java.util.stream.Stream [^java.nio.file.Path path]
    (Files/lines path)))

(defn *delete
  "Deletes a file.

    An implementation may require to examine the file to determine if the
   file is a directory. Consequently this method may not be atomic with respect
   to other file system operations.  If the file is a symbolic link then the
   symbolic link itself, not the final target of the link, is deleted.

    If the file is a directory then the directory must be empty. In some
   implementations a directory has entries for special files or links that
   are created when the directory is created. In such implementations a
   directory is considered empty when only the special entries exist.
   This method can be used with the walkFileTree
   method to delete a directory and all entries in the directory, or an
   entire file-tree where required.

    On some operating systems it may not be possible to remove a file when
   it is open and in use by this Java virtual machine or other programs.

  path - the path to the file to delete - `java.nio.file.Path`

  throws: java.nio.file.NoSuchFileException - if the file does not exist (optional specific exception)"
  ([^java.nio.file.Path path]
    (Files/delete path)))

(defn *new-buffered-writer
  "Opens or creates a file for writing, returning a BufferedWriter
   that may be used to write text to the file in an efficient manner.
   The options parameter specifies how the the file is created or
   opened. If no options are present then this method works as if the CREATE, TRUNCATE_EXISTING, and WRITE options are present. In other words, it
   opens the file for writing, creating the file if it doesn't exist, or
   initially truncating an existing regular-file to
   a size of 0 if it exists.

    The Writer methods to write text throw IOException
   if the text cannot be encoded using the specified charset.

  path - the path to the file - `java.nio.file.Path`
  cs - the charset to use for encoding - `java.nio.charset.Charset`
  options - options specifying how the file is opened - `java.nio.file.OpenOption`

  returns: a new buffered writer, with default buffer size, to write text
            to the file - `java.io.BufferedWriter`

  throws: java.io.IOException - if an I/O error occurs opening or creating the file"
  (^java.io.BufferedWriter [^java.nio.file.Path path ^java.nio.charset.Charset cs ^java.nio.file.OpenOption options]
    (Files/newBufferedWriter path cs options))
  (^java.io.BufferedWriter [^java.nio.file.Path path ^java.nio.file.OpenOption options]
    (Files/newBufferedWriter path options)))

(defn *read-attributes
  "Reads a file's attributes as a bulk operation.

    The type parameter is the type of the attributes required
   and this method returns an instance of that type if supported. All
   implementations support a basic set of file attributes and so invoking
   this method with a  type parameter of BasicFileAttributes.class will not throw UnsupportedOperationException.

    The options array may be used to indicate how symbolic links
   are handled for the case that the file is a symbolic link. By default,
   symbolic links are followed and the file attribute of the final target
   of the link is read. If the option NOFOLLOW_LINKS is present then symbolic links are not followed.

    It is implementation specific if all file attributes are read as an
   atomic operation with respect to other file system operations.

    Usage Example:
   Suppose we want to read a file's attributes in bulk:


      Path path = ...
      BasicFileAttributes attrs = Files.readAttributes(path, BasicFileAttributes.class);
   Alternatively, suppose we want to read file's POSIX attributes without
   following symbolic links:


      PosixFileAttributes attrs = Files.readAttributes(path, PosixFileAttributes.class, NOFOLLOW_LINKS);

  path - the path to the file - `java.nio.file.Path`
  type - the Class of the file attributes required to read - `java.lang.Class`
  options - options indicating how symbolic links are handled - `java.nio.file.LinkOption`

  returns: the file attributes - `<A extends java.nio.file.attribute.BasicFileAttributes> A`

  throws: java.lang.UnsupportedOperationException - if an attributes of the given type are not supported"
  ([^java.nio.file.Path path ^java.lang.Class type ^java.nio.file.LinkOption options]
    (Files/readAttributes path type options)))

(defn *new-buffered-reader
  "Opens a file for reading, returning a BufferedReader that may be
   used to read text from the file in an efficient manner. Bytes from the
   file are decoded into characters using the specified charset. Reading
   commences at the beginning of the file.

    The Reader methods that read from the file throw IOException if a malformed or unmappable byte sequence is read.

  path - the path to the file - `java.nio.file.Path`
  cs - the charset to use for decoding - `java.nio.charset.Charset`

  returns: a new buffered reader, with default buffer size, to read text
            from the file - `java.io.BufferedReader`

  throws: java.io.IOException - if an I/O error occurs opening the file"
  (^java.io.BufferedReader [^java.nio.file.Path path ^java.nio.charset.Charset cs]
    (Files/newBufferedReader path cs))
  (^java.io.BufferedReader [^java.nio.file.Path path]
    (Files/newBufferedReader path)))

(defn *create-temp-directory
  "Creates a new directory in the specified directory, using the given
   prefix to generate its name.  The resulting Path is associated
   with the same FileSystem as the given directory.

    The details as to how the name of the directory is constructed is
   implementation dependent and therefore not specified. Where possible
   the prefix is used to construct candidate names.

    As with the createTempFile methods, this method is only
   part of a temporary-file facility. A shutdown-hook, or the File.deleteOnExit() mechanism may be
   used to delete the directory automatically.

    The attrs parameter is optional file-attributes to set atomically when creating the directory. Each
   attribute is identified by its name. If more
   than one attribute of the same name is included in the array then all but
   the last occurrence is ignored.

  dir - the path to directory in which to create the directory - `java.nio.file.Path`
  prefix - the prefix string to be used in generating the directory's name; may be null - `java.lang.String`
  attrs - an optional list of file attributes to set atomically when creating the directory - `java.nio.file.attribute.FileAttribute`

  returns: the path to the newly created directory that did not exist before
            this method was invoked - `java.nio.file.Path`

  throws: java.lang.IllegalArgumentException - if the prefix cannot be used to generate a candidate directory name"
  (^java.nio.file.Path [^java.nio.file.Path dir ^java.lang.String prefix ^java.nio.file.attribute.FileAttribute attrs]
    (Files/createTempDirectory dir prefix attrs))
  (^java.nio.file.Path [^java.lang.String prefix ^java.nio.file.attribute.FileAttribute attrs]
    (Files/createTempDirectory prefix attrs)))

(defn *get-file-attribute-view
  "Returns a file attribute view of a given type.

    A file attribute view provides a read-only or updatable view of a
   set of file attributes. This method is intended to be used where the file
   attribute view defines type-safe methods to read or update the file
   attributes. The type parameter is the type of the attribute view
   required and the method returns an instance of that type if supported.
   The BasicFileAttributeView type supports access to the basic
   attributes of a file. Invoking this method to select a file attribute
   view of that type will always return an instance of that class.

    The options array may be used to indicate how symbolic links
   are handled by the resulting file attribute view for the case that the
   file is a symbolic link. By default, symbolic links are followed. If the
   option NOFOLLOW_LINKS is present then
   symbolic links are not followed. This option is ignored by implementations
   that do not support symbolic links.

    Usage Example:
   Suppose we want read or set a file's ACL, if supported:


       Path path = ...
       AclFileAttributeView view = Files.getFileAttributeView(path, AclFileAttributeView.class);
       if (view != null) {
           List<AclEntry> acl = view.getAcl();
           :
       }

  path - the path to the file - `java.nio.file.Path`
  type - the Class object corresponding to the file attribute view - `java.lang.Class`
  options - options indicating how symbolic links are handled - `java.nio.file.LinkOption`

  returns: a file attribute view of the specified type, or null if
            the attribute view type is not available - `<V extends java.nio.file.attribute.FileAttributeView> V`"
  ([^java.nio.file.Path path ^java.lang.Class type ^java.nio.file.LinkOption options]
    (Files/getFileAttributeView path type options)))

(defn *create-link
  "Creates a new link (directory entry) for an existing file (optional
   operation).

    The link parameter locates the directory entry to create.
   The existing parameter is the path to an existing file. This
   method creates a new directory entry for the file so that it can be
   accessed using link as the path. On some file systems this is
   known as creating a \"hard link\". Whether the file attributes are
   maintained for the file or for each directory entry is file system
   specific and therefore not specified. Typically, a file system requires
   that all links (directory entries) for a file be on the same file system.
   Furthermore, on some platforms, the Java virtual machine may require to
   be started with implementation specific privileges to create hard links
   or to create links to directories.

  link - the link (directory entry) to create - `java.nio.file.Path`
  existing - a path to an existing file - `java.nio.file.Path`

  returns: the path to the link (directory entry) - `java.nio.file.Path`

  throws: java.lang.UnsupportedOperationException - if the implementation does not support adding an existing file to a directory"
  (^java.nio.file.Path [^java.nio.file.Path link ^java.nio.file.Path existing]
    (Files/createLink link existing)))

(defn *same-file?
  "Tests if two paths locate the same file.

    If both Path objects are equal
   then this method returns true without checking if the file exists.
   If the two Path objects are associated with different providers
   then this method returns false. Otherwise, this method checks if
   both Path objects locate the same file, and depending on the
   implementation, may require to open or access both files.

    If the file system and files remain static, then this method implements
   an equivalence relation for non-null Paths.

   It is reflexive: for Path f,
       isSameFile(f,f) should return true.
   It is symmetric: for two Paths f and g,
       isSameFile(f,g) will equal isSameFile(g,f).
   It is transitive: for three Paths
       f, g, and h, if isSameFile(f,g) returns
       true and isSameFile(g,h) returns true, then
       isSameFile(f,h) will return return true.

  path - one path to the file - `java.nio.file.Path`
  path-2 - the other path - `java.nio.file.Path`

  returns: true if, and only if, the two paths locate the same file - `boolean`

  throws: java.io.IOException - if an I/O error occurs"
  (^Boolean [^java.nio.file.Path path ^java.nio.file.Path path-2]
    (Files/isSameFile path path-2)))

(defn *create-directories
  "Creates a directory by creating all nonexistent parent directories first.
   Unlike the createDirectory method, an exception
   is not thrown if the directory could not be created because it already
   exists.

    The attrs parameter is optional file-attributes to set atomically when creating the nonexistent
   directories. Each file attribute is identified by its name. If more than one attribute of the same name is
   included in the array then all but the last occurrence is ignored.

    If this method fails, then it may do so after creating some, but not
   all, of the parent directories.

  dir - the directory to create - `java.nio.file.Path`
  attrs - an optional list of file attributes to set atomically when creating the directory - `java.nio.file.attribute.FileAttribute`

  returns: the directory - `java.nio.file.Path`

  throws: java.lang.UnsupportedOperationException - if the array contains an attribute that cannot be set atomically when creating the directory"
  (^java.nio.file.Path [^java.nio.file.Path dir ^java.nio.file.attribute.FileAttribute attrs]
    (Files/createDirectories dir attrs)))

(defn *get-attribute
  "Reads the value of a file attribute.

    The attribute parameter identifies the attribute to be read
   and takes the form:

   [view-name:]attribute-name

   where square brackets [...] delineate an optional component and the
   character ':' stands for itself.

    view-name is the name of a FileAttributeView that identifies a set of file attributes. If not
   specified then it defaults to \"basic\", the name of the file
   attribute view that identifies the basic set of file attributes common to
   many file systems. attribute-name is the name of the attribute.

    The options array may be used to indicate how symbolic links
   are handled for the case that the file is a symbolic link. By default,
   symbolic links are followed and the file attribute of the final target
   of the link is read. If the option NOFOLLOW_LINKS is present then symbolic links are not followed.

    Usage Example:
   Suppose we require the user ID of the file owner on a system that
   supports a \"unix\" view:


      Path path = ...
      int uid = (Integer)Files.getAttribute(path, \"unix:uid\");

  path - the path to the file - `java.nio.file.Path`
  attribute - the attribute to read - `java.lang.String`
  options - options indicating how symbolic links are handled - `java.nio.file.LinkOption`

  returns: the attribute value - `java.lang.Object`

  throws: java.lang.UnsupportedOperationException - if the attribute view is not available"
  (^java.lang.Object [^java.nio.file.Path path ^java.lang.String attribute ^java.nio.file.LinkOption options]
    (Files/getAttribute path attribute options)))

(defn *symbolic-link?
  "Tests whether a file is a symbolic link.

    Where it is required to distinguish an I/O exception from the case
   that the file is not a symbolic link then the file attributes can be
   read with the readAttributes method and the file type tested with the BasicFileAttributes.isSymbolicLink() method.

  path - The path to the file - `java.nio.file.Path`

  returns: true if the file is a symbolic link; false if
            the file does not exist, is not a symbolic link, or it cannot
            be determined if the file is a symbolic link or not. - `boolean`

  throws: java.lang.SecurityException - In the case of the default provider, and a security manager is installed, its checkRead method denies read access to the file."
  (^Boolean [^java.nio.file.Path path]
    (Files/isSymbolicLink path)))

(defn *regular-file?
  "Tests whether a file is a regular file with opaque content.

    The options array may be used to indicate how symbolic links
   are handled for the case that the file is a symbolic link. By default,
   symbolic links are followed and the file attribute of the final target
   of the link is read. If the option NOFOLLOW_LINKS is present then symbolic links are not followed.

    Where it is required to distinguish an I/O exception from the case
   that the file is not a regular file then the file attributes can be
   read with the readAttributes method and the file type tested with the BasicFileAttributes.isRegularFile() method.

  path - the path to the file - `java.nio.file.Path`
  options - options indicating how symbolic links are handled - `java.nio.file.LinkOption`

  returns: true if the file is a regular file; false if
            the file does not exist, is not a regular file, or it
            cannot be determined if the file is a regular file or not. - `boolean`

  throws: java.lang.SecurityException - In the case of the default provider, and a security manager is installed, its checkRead method denies read access to the file."
  (^Boolean [^java.nio.file.Path path ^java.nio.file.LinkOption options]
    (Files/isRegularFile path options)))

(defn *directory?
  "Tests whether a file is a directory.

    The options array may be used to indicate how symbolic links
   are handled for the case that the file is a symbolic link. By default,
   symbolic links are followed and the file attribute of the final target
   of the link is read. If the option NOFOLLOW_LINKS is present then symbolic links are not followed.

    Where it is required to distinguish an I/O exception from the case
   that the file is not a directory then the file attributes can be
   read with the readAttributes method and the file type tested with the BasicFileAttributes.isDirectory() method.

  path - the path to the file to test - `java.nio.file.Path`
  options - options indicating how symbolic links are handled - `java.nio.file.LinkOption`

  returns: true if the file is a directory; false if
            the file does not exist, is not a directory, or it cannot
            be determined if the file is a directory or not. - `boolean`

  throws: java.lang.SecurityException - In the case of the default provider, and a security manager is installed, its checkRead method denies read access to the file."
  (^Boolean [^java.nio.file.Path path ^java.nio.file.LinkOption options]
    (Files/isDirectory path options)))

(defn *read-all-bytes
  "Reads all the bytes from a file. The method ensures that the file is
   closed when all bytes have been read or an I/O error, or other runtime
   exception, is thrown.

    Note that this method is intended for simple cases where it is
   convenient to read all bytes into a byte array. It is not intended for
   reading in large files.

  path - the path to the file - `java.nio.file.Path`

  returns: a byte array containing the bytes read from the file - `byte[]`

  throws: java.io.IOException - if an I/O error occurs reading from the stream"
  ([^java.nio.file.Path path]
    (Files/readAllBytes path)))

(defn *new-input-stream
  "Opens a file, returning an input stream to read from the file. The stream
   will not be buffered, and is not required to support the mark or reset methods. The
   stream will be safe for access by multiple concurrent threads. Reading
   commences at the beginning of the file. Whether the returned stream is
   asynchronously closeable and/or interruptible is highly
   file system provider specific and therefore not specified.

    The options parameter determines how the file is opened.
   If no options are present then it is equivalent to opening the file with
   the READ option. In addition to the READ option, an implementation may also support additional implementation
   specific options.

  path - the path to the file to open - `java.nio.file.Path`
  options - options specifying how the file is opened - `java.nio.file.OpenOption`

  returns: a new input stream - `java.io.InputStream`

  throws: java.lang.IllegalArgumentException - if an invalid combination of options is specified"
  (^java.io.InputStream [^java.nio.file.Path path ^java.nio.file.OpenOption options]
    (Files/newInputStream path options)))

(defn *delete-if-exists
  "Deletes a file if it exists.

    As with the delete(Path) method, an
   implementation may need to examine the file to determine if the file is a
   directory. Consequently this method may not be atomic with respect to
   other file system operations.  If the file is a symbolic link, then the
   symbolic link itself, not the final target of the link, is deleted.

    If the file is a directory then the directory must be empty. In some
   implementations a directory has entries for special files or links that
   are created when the directory is created. In such implementations a
   directory is considered empty when only the special entries exist.

    On some operating systems it may not be possible to remove a file when
   it is open and in use by this Java virtual machine or other programs.

  path - the path to the file to delete - `java.nio.file.Path`

  returns: true if the file was deleted by this method; false if the file could not be deleted because it did not
            exist - `boolean`

  throws: java.nio.file.DirectoryNotEmptyException - if the file is a directory and could not otherwise be deleted because the directory is not empty (optional specific exception)"
  (^Boolean [^java.nio.file.Path path]
    (Files/deleteIfExists path)))

(defn *get-file-store
  "Returns the FileStore representing the file store where a file
   is located.

    Once a reference to the FileStore is obtained it is
   implementation specific if operations on the returned FileStore,
   or FileStoreAttributeView objects obtained from it, continue
   to depend on the existence of the file. In particular the behavior is not
   defined for the case that the file is deleted or moved to a different
   file store.

  path - the path to the file - `java.nio.file.Path`

  returns: the file store where the file is stored - `java.nio.file.FileStore`

  throws: java.io.IOException - if an I/O error occurs"
  (^java.nio.file.FileStore [^java.nio.file.Path path]
    (Files/getFileStore path)))

(defn *probe-content-type
  "Probes the content type of a file.

    This method uses the installed FileTypeDetector implementations
   to probe the given file to determine its content type. Each file type
   detector's probeContentType is
   invoked, in turn, to probe the file type. If the file is recognized then
   the content type is returned. If the file is not recognized by any of the
   installed file type detectors then a system-default file type detector is
   invoked to guess the content type.

    A given invocation of the Java virtual machine maintains a system-wide
   list of file type detectors. Installed file type detectors are loaded
   using the service-provider loading facility defined by the ServiceLoader
   class. Installed file type detectors are loaded using the system class
   loader. If the system class loader cannot be found then the extension class
   loader is used; If the extension class loader cannot be found then the
   bootstrap class loader is used. File type detectors are typically installed
   by placing them in a JAR file on the application class path or in the
   extension directory, the JAR file contains a provider-configuration file
   named java.nio.file.spi.FileTypeDetector in the resource directory
   META-INF/services, and the file lists one or more fully-qualified
   names of concrete subclass of FileTypeDetector  that have a zero
   argument constructor. If the process of locating or instantiating the
   installed file type detectors fails then an unspecified error is thrown.
   The ordering that installed providers are located is implementation
   specific.

    The return value of this method is the string form of the value of a
   Multipurpose Internet Mail Extension (MIME) content type as
   defined by RFC 2045:
   Multipurpose Internet Mail Extensions (MIME) Part One: Format of Internet
   Message Bodies. The string is guaranteed to be parsable according
   to the grammar in the RFC.

  path - the path to the file to probe - `java.nio.file.Path`

  returns: The content type of the file, or null if the content
            type cannot be determined - `java.lang.String`

  throws: java.io.IOException - if an I/O error occurs"
  (^java.lang.String [^java.nio.file.Path path]
    (Files/probeContentType path)))

(defn *get-owner
  "Returns the owner of a file.

    The path parameter is associated with a file system that
   supports FileOwnerAttributeView. This file attribute view provides
   access to a file attribute that is the owner of the file.

  path - The path to the file - `java.nio.file.Path`
  options - options indicating how symbolic links are handled - `java.nio.file.LinkOption`

  returns: A user principal representing the owner of the file - `java.nio.file.attribute.UserPrincipal`

  throws: java.lang.UnsupportedOperationException - if the associated file system does not support the FileOwnerAttributeView"
  (^java.nio.file.attribute.UserPrincipal [^java.nio.file.Path path ^java.nio.file.LinkOption options]
    (Files/getOwner path options)))

(defn *walk
  "Return a Stream that is lazily populated with Path by walking the file tree rooted at a given starting file.  The
   file tree is traversed depth-first, the elements in the stream
   are Path objects that are obtained as if by resolving the relative path against start.

    The stream walks the file tree as elements are consumed.
   The Stream returned is guaranteed to have at least one
   element, the starting file itself. For each file visited, the stream
   attempts to read its BasicFileAttributes. If the file is a
   directory and can be opened successfully, entries in the directory, and
   their descendants will follow the directory in the stream as
   they are encountered. When all entries have been visited, then the
   directory is closed. The file tree walk then continues at the next
   sibling of the directory.

    The stream is weakly consistent. It does not freeze the
   file tree while iterating, so it may (or may not) reflect updates to
   the file tree that occur after returned from this method.

    By default, symbolic links are not automatically followed by this
   method. If the options parameter contains the FOLLOW_LINKS option then symbolic links are
   followed. When following links, and the attributes of the target cannot
   be read, then this method attempts to get the BasicFileAttributes
   of the link.

    If the options parameter contains the FOLLOW_LINKS option then the stream keeps
   track of directories visited so that cycles can be detected. A cycle
   arises when there is an entry in a directory that is an ancestor of the
   directory. Cycle detection is done by recording the file-key of directories,
   or if file keys are not available, by invoking the isSameFile method to test if a directory is the same file as an
   ancestor. When a cycle is detected it is treated as an I/O error with
   an instance of FileSystemLoopException.

    The maxDepth parameter is the maximum number of levels of
   directories to visit. A value of 0 means that only the starting
   file is visited, unless denied by the security manager. A value of
   MAX_VALUE may be used to indicate that all
   levels should be visited.

    When a security manager is installed and it denies access to a file
   (or directory), then it is ignored and not included in the stream.

    The returned stream encapsulates one or more DirectoryStreams.
   If timely disposal of file system resources is required, the
   try-with-resources construct should be used to ensure that the
   stream's close method is invoked after the stream
   operations are completed.  Operating on a closed stream will result in an
   IllegalStateException.

    If an IOException is thrown when accessing the directory
   after this method has returned, it is wrapped in an UncheckedIOException which will be thrown from the method that caused
   the access to take place.

  start - the starting file - `java.nio.file.Path`
  max-depth - the maximum number of directory levels to visit - `int`
  options - options to configure the traversal - `java.nio.file.FileVisitOption`

  returns: the Stream of Path - `java.util.stream.Stream<java.nio.file.Path>`

  throws: java.lang.IllegalArgumentException - if the maxDepth parameter is negative"
  (^java.util.stream.Stream [^java.nio.file.Path start ^Integer max-depth ^java.nio.file.FileVisitOption options]
    (Files/walk start max-depth options))
  (^java.util.stream.Stream [^java.nio.file.Path start ^java.nio.file.FileVisitOption options]
    (Files/walk start options)))

(defn *read-symbolic-link
  "Reads the target of a symbolic link (optional operation).

    If the file system supports symbolic
   links then this method is used to read the target of the link, failing
   if the file is not a symbolic link. The target of the link need not exist.
   The returned Path object will be associated with the same file
   system as link.

  link - the path to the symbolic link - `java.nio.file.Path`

  returns: a Path object representing the target of the link - `java.nio.file.Path`

  throws: java.lang.UnsupportedOperationException - if the implementation does not support symbolic links"
  (^java.nio.file.Path [^java.nio.file.Path link]
    (Files/readSymbolicLink link)))

(defn *hidden?
  "Tells whether or not a file is considered hidden. The exact
   definition of hidden is platform or provider dependent. On UNIX for
   example a file is considered to be hidden if its name begins with a
   period character ('.'). On Windows a file is considered hidden if it
   isn't a directory and the DOS hidden
   attribute is set.

    Depending on the implementation this method may require to access
   the file system to determine if the file is considered hidden.

  path - the path to the file to test - `java.nio.file.Path`

  returns: true if the file is considered hidden - `boolean`

  throws: java.io.IOException - if an I/O error occurs"
  (^Boolean [^java.nio.file.Path path]
    (Files/isHidden path)))

(defn *set-attribute
  "Sets the value of a file attribute.

    The attribute parameter identifies the attribute to be set
   and takes the form:

   [view-name:]attribute-name

   where square brackets [...] delineate an optional component and the
   character ':' stands for itself.

    view-name is the name of a FileAttributeView that identifies a set of file attributes. If not
   specified then it defaults to \"basic\", the name of the file
   attribute view that identifies the basic set of file attributes common to
   many file systems. attribute-name is the name of the attribute
   within the set.

    The options array may be used to indicate how symbolic links
   are handled for the case that the file is a symbolic link. By default,
   symbolic links are followed and the file attribute of the final target
   of the link is set. If the option NOFOLLOW_LINKS is present then symbolic links are not followed.

    Usage Example:
   Suppose we want to set the DOS \"hidden\" attribute:


      Path path = ...
      Files.setAttribute(path, \"dos:hidden\", true);

  path - the path to the file - `java.nio.file.Path`
  attribute - the attribute to set - `java.lang.String`
  value - the attribute value - `java.lang.Object`
  options - options indicating how symbolic links are handled - `java.nio.file.LinkOption`

  returns: the path parameter - `java.nio.file.Path`

  throws: java.lang.UnsupportedOperationException - if the attribute view is not available"
  (^java.nio.file.Path [^java.nio.file.Path path ^java.lang.String attribute ^java.lang.Object value ^java.nio.file.LinkOption options]
    (Files/setAttribute path attribute value options)))

(defn *set-last-modified-time
  "Updates a file's last modified time attribute. The file time is converted
   to the epoch and precision supported by the file system. Converting from
   finer to coarser granularities result in precision loss. The behavior of
   this method when attempting to set the last modified time when it is not
   supported by the file system or is outside the range supported by the
   underlying file store is not defined. It may or not fail by throwing an
   IOException.

    Usage Example:
   Suppose we want to set the last modified time to the current time:


      Path path = ...
      FileTime now = FileTime.fromMillis(System.currentTimeMillis());
      Files.setLastModifiedTime(path, now);

  path - the path to the file - `java.nio.file.Path`
  time - the new last modified time - `java.nio.file.attribute.FileTime`

  returns: the path - `java.nio.file.Path`

  throws: java.io.IOException - if an I/O error occurs"
  (^java.nio.file.Path [^java.nio.file.Path path ^java.nio.file.attribute.FileTime time]
    (Files/setLastModifiedTime path time)))

(defn *get-posix-file-permissions
  "Returns a file's POSIX file permissions.

    The path parameter is associated with a FileSystem
   that supports the PosixFileAttributeView. This attribute view
   provides access to file attributes commonly associated with files on file
   systems used by operating systems that implement the Portable Operating
   System Interface (POSIX) family of standards.

    The options array may be used to indicate how symbolic links
   are handled for the case that the file is a symbolic link. By default,
   symbolic links are followed and the file attribute of the final target
   of the link is read. If the option NOFOLLOW_LINKS is present then symbolic links are not followed.

  path - the path to the file - `java.nio.file.Path`
  options - options indicating how symbolic links are handled - `java.nio.file.LinkOption`

  returns: the file permissions - `java.util.Set<java.nio.file.attribute.PosixFilePermission>`

  throws: java.lang.UnsupportedOperationException - if the associated file system does not support the PosixFileAttributeView"
  (^java.util.Set [^java.nio.file.Path path ^java.nio.file.LinkOption options]
    (Files/getPosixFilePermissions path options)))

(defn *new-byte-channel
  "Opens or creates a file, returning a seekable byte channel to access the
   file.

    The options parameter determines how the file is opened.
   The READ and WRITE options determine if the file should be
   opened for reading and/or writing. If neither option (or the APPEND option) is present then the file is
   opened for reading. By default reading or writing commence at the
   beginning of the file.

    In the addition to READ and WRITE, the following
   options may be present:


    Option Description

      APPEND
      If this option is present then the file is opened for writing and
       each invocation of the channel's write method first advances
       the position to the end of the file and then writes the requested
       data. Whether the advancement of the position and the writing of the
       data are done in a single atomic operation is system-dependent and
       therefore unspecified. This option may not be used in conjunction
       with the READ or TRUNCATE_EXISTING options.


      TRUNCATE_EXISTING
      If this option is present then the existing file is truncated to
     a size of 0 bytes. This option is ignored when the file is opened only
     for reading.


      CREATE_NEW
      If this option is present then a new file is created, failing if
     the file already exists or is a symbolic link. When creating a file the
     check for the existence of the file and the creation of the file if it
     does not exist is atomic with respect to other file system operations.
     This option is ignored when the file is opened only for reading.


      CREATE
      If this option is present then an existing file is opened if it
     exists, otherwise a new file is created. This option is ignored if the
     CREATE_NEW option is also present or the file is opened only
     for reading.


      DELETE_ON_CLOSE
      When this option is present then the implementation makes a
     best effort attempt to delete the file when closed by the
     close method. If the close
     method is not invoked then a best effort attempt is made to
     delete the file when the Java virtual machine terminates.


     SPARSE
      When creating a new file this option is a hint that the
     new file will be sparse. This option is ignored when not creating
     a new file.


      SYNC
      Requires that every update to the file's content or metadata be
     written synchronously to the underlying storage device. (see  Synchronized I/O file
     integrity).


      DSYNC
      Requires that every update to the file's content be written
     synchronously to the underlying storage device. (see  Synchronized I/O file
     integrity).



    An implementation may also support additional implementation specific
   options.

    The attrs parameter is optional file-attributes to set atomically when a new file is created.

    In the case of the default provider, the returned seekable byte channel
   is a FileChannel.

    Usage Examples:


       Path path = ...

       // open file for reading
       ReadableByteChannel rbc = Files.newByteChannel(path, EnumSet.of(READ)));

       // open file for writing to the end of an existing file, creating
       // the file if it doesn't already exist
       WritableByteChannel wbc = Files.newByteChannel(path, EnumSet.of(CREATE,APPEND));

       // create file with initial permissions, opening it for both reading and writing
        FileAttribute<Set<PosixFilePermission>> perms = ...
       SeekableByteChannel sbc = Files.newByteChannel(path, EnumSet.of(CREATE_NEW,READ,WRITE), perms);

  path - the path to the file to open or create - `java.nio.file.Path`
  options - options specifying how the file is opened - `java.util.Set`
  attrs - an optional list of file attributes to set atomically when creating the file - `java.nio.file.attribute.FileAttribute`

  returns: a new seekable byte channel - `java.nio.channels.SeekableByteChannel`

  throws: java.lang.IllegalArgumentException - if the set contains an invalid combination of options"
  (^java.nio.channels.SeekableByteChannel [^java.nio.file.Path path ^java.util.Set options ^java.nio.file.attribute.FileAttribute attrs]
    (Files/newByteChannel path options attrs))
  (^java.nio.channels.SeekableByteChannel [^java.nio.file.Path path ^java.nio.file.OpenOption options]
    (Files/newByteChannel path options)))

(defn *get-last-modified-time
  "Returns a file's last modified time.

    The options array may be used to indicate how symbolic links
   are handled for the case that the file is a symbolic link. By default,
   symbolic links are followed and the file attribute of the final target
   of the link is read. If the option NOFOLLOW_LINKS is present then symbolic links are not followed.

  path - the path to the file - `java.nio.file.Path`
  options - options indicating how symbolic links are handled - `java.nio.file.LinkOption`

  returns: a FileTime representing the time the file was last
            modified, or an implementation specific default when a time
            stamp to indicate the time of last modification is not supported
            by the file system - `java.nio.file.attribute.FileTime`

  throws: java.io.IOException - if an I/O error occurs"
  (^java.nio.file.attribute.FileTime [^java.nio.file.Path path ^java.nio.file.LinkOption options]
    (Files/getLastModifiedTime path options)))

(defn *move
  "Move or rename a file to a target file.

    By default, this method attempts to move the file to the target
   file, failing if the target file exists except if the source and
   target are the same file, in which case this method
   has no effect. If the file is a symbolic link then the symbolic link
   itself, not the target of the link, is moved. This method may be
   invoked to move an empty directory. In some implementations a directory
   has entries for special files or links that are created when the
   directory is created. In such implementations a directory is considered
   empty when only the special entries exist. When invoked to move a
   directory that is not empty then the directory is moved if it does not
   require moving the entries in the directory.  For example, renaming a
   directory on the same FileStore will usually not require moving
   the entries in the directory. When moving a directory requires that its
   entries be moved then this method fails (by throwing an IOException). To move a file tree may involve copying rather
   than moving directories and this can be done using the copy method in conjunction with the Files.walkFileTree utility method.

    The options parameter may include any of the following:


    Option Description

      REPLACE_EXISTING
      If the target file exists, then the target file is replaced if it
       is not a non-empty directory. If the target file exists and is a
       symbolic link, then the symbolic link itself, not the target of
       the link, is replaced.


      ATOMIC_MOVE
      The move is performed as an atomic file system operation and all
       other options are ignored. If the target file exists then it is
       implementation specific if the existing file is replaced or this method
       fails by throwing an IOException. If the move cannot be
       performed as an atomic file system operation then AtomicMoveNotSupportedException is thrown. This can arise, for
       example, when the target location is on a different FileStore
       and would require that the file be copied, or target location is
       associated with a different provider to this object.


    An implementation of this interface may support additional
   implementation specific options.

    Moving a file will copy the last-modified-time to the target
   file if supported by both source and target file stores. Copying of file
   timestamps may result in precision loss. An implementation may also
   attempt to copy other file attributes but is not required to fail if the
   file attributes cannot be copied. When the move is performed as
   a non-atomic operation, and an IOException is thrown, then the
   state of the files is not defined. The original file and the target file
   may both exist, the target file may be incomplete or some of its file
   attributes may not been copied from the original file.

    Usage Examples:
   Suppose we want to rename a file to \"newname\", keeping the file in the
   same directory:


       Path source = ...
       Files.move(source, source.resolveSibling(\"newname\"));
   Alternatively, suppose we want to move a file to new directory, keeping
   the same file name, and replacing any existing file of that name in the
   directory:


       Path source = ...
       Path newdir = ...
       Files.move(source, newdir.resolve(source.getFileName()), REPLACE_EXISTING);

  source - the path to the file to move - `java.nio.file.Path`
  target - the path to the target file (may be associated with a different provider to the source path) - `java.nio.file.Path`
  options - options specifying how the move should be done - `java.nio.file.CopyOption`

  returns: the path to the target file - `java.nio.file.Path`

  throws: java.lang.UnsupportedOperationException - if the array contains a copy option that is not supported"
  (^java.nio.file.Path [^java.nio.file.Path source ^java.nio.file.Path target ^java.nio.file.CopyOption options]
    (Files/move source target options)))

(defn *walk-file-tree
  "Walks a file tree.

    This method walks a file tree rooted at a given starting file. The
   file tree traversal is depth-first with the given FileVisitor invoked for each file encountered. File tree traversal
   completes when all accessible files in the tree have been visited, or a
   visit method returns a result of TERMINATE. Where a visit method terminates due an IOException,
   an uncaught error, or runtime exception, then the traversal is terminated
   and the error or exception is propagated to the caller of this method.

    For each file encountered this method attempts to read its BasicFileAttributes. If the file is not a
   directory then the visitFile method is
   invoked with the file attributes. If the file attributes cannot be read,
   due to an I/O exception, then the visitFileFailed method is invoked with the I/O exception.

    Where the file is a directory, and the directory could not be opened,
   then the visitFileFailed method is invoked with the I/O exception,
   after which, the file tree walk continues, by default, at the next
   sibling of the directory.

    Where the directory is opened successfully, then the entries in the
   directory, and their descendants are visited. When all entries
   have been visited, or an I/O error occurs during iteration of the
   directory, then the directory is closed and the visitor's postVisitDirectory method is invoked.
   The file tree walk then continues, by default, at the next sibling
   of the directory.

    By default, symbolic links are not automatically followed by this
   method. If the options parameter contains the FOLLOW_LINKS option then symbolic links are
   followed. When following links, and the attributes of the target cannot
   be read, then this method attempts to get the BasicFileAttributes
   of the link. If they can be read then the visitFile method is
   invoked with the attributes of the link (otherwise the visitFileFailed
   method is invoked as specified above).

    If the options parameter contains the FOLLOW_LINKS option then this method keeps
   track of directories visited so that cycles can be detected. A cycle
   arises when there is an entry in a directory that is an ancestor of the
   directory. Cycle detection is done by recording the file-key of directories,
   or if file keys are not available, by invoking the isSameFile method to test if a directory is the same file as an
   ancestor. When a cycle is detected it is treated as an I/O error, and the
   visitFileFailed method is invoked with
   an instance of FileSystemLoopException.

    The maxDepth parameter is the maximum number of levels of
   directories to visit. A value of 0 means that only the starting
   file is visited, unless denied by the security manager. A value of
   MAX_VALUE may be used to indicate that all
   levels should be visited. The visitFile method is invoked for all
   files, including directories, encountered at maxDepth, unless the
   basic file attributes cannot be read, in which case the visitFileFailed method is invoked.

    If a visitor returns a result of null then NullPointerException is thrown.

    When a security manager is installed and it denies access to a file
   (or directory), then it is ignored and the visitor is not invoked for
   that file (or directory).

  start - the starting file - `java.nio.file.Path`
  options - options to configure the traversal - `java.util.Set`
  max-depth - the maximum number of directory levels to visit - `int`
  visitor - the file visitor to invoke for each file - `java.nio.file.FileVisitor`

  returns: the starting file - `java.nio.file.Path`

  throws: java.lang.IllegalArgumentException - if the maxDepth parameter is negative"
  (^java.nio.file.Path [^java.nio.file.Path start ^java.util.Set options ^Integer max-depth ^java.nio.file.FileVisitor visitor]
    (Files/walkFileTree start options max-depth visitor))
  (^java.nio.file.Path [^java.nio.file.Path start ^java.nio.file.FileVisitor visitor]
    (Files/walkFileTree start visitor)))

(defn *exists?
  "Tests whether a file exists.

    The options parameter may be used to indicate how symbolic links
   are handled for the case that the file is a symbolic link. By default,
   symbolic links are followed. If the option NOFOLLOW_LINKS is present then symbolic links are not followed.

    Note that the result of this method is immediately outdated. If this
   method indicates the file exists then there is no guarantee that a
   subsequence access will succeed. Care should be taken when using this
   method in security sensitive applications.

  path - the path to the file to test - `java.nio.file.Path`
  options - options indicating how symbolic links are handled . - `java.nio.file.LinkOption`

  returns: true if the file exists; false if the file does
            not exist or its existence cannot be determined. - `boolean`

  throws: java.lang.SecurityException - In the case of the default provider, the SecurityManager.checkRead(String) is invoked to check read access to the file."
  (^Boolean [^java.nio.file.Path path ^java.nio.file.LinkOption options]
    (Files/exists path options)))

(defn *size
  "Returns the size of a file (in bytes). The size may differ from the
   actual size on the file system due to compression, support for sparse
   files, or other reasons. The size of files that are not regular files is implementation specific and
   therefore unspecified.

  path - the path to the file - `java.nio.file.Path`

  returns: the file size, in bytes - `long`

  throws: java.io.IOException - if an I/O error occurs"
  (^Long [^java.nio.file.Path path]
    (Files/size path)))

(defn *executable?
  "Tests whether a file is executable. This method checks that a file exists
   and that this Java virtual machine has appropriate privileges to execute the file. The semantics may differ when checking
   access to a directory. For example, on UNIX systems, checking for
   execute access checks that the Java virtual machine has permission to
   search the directory in order to access file or subdirectories.

    Depending on the implementation, this method may require to read file
   permissions, access control lists, or other file attributes in order to
   check the effective access to the file. Consequently, this method may not
   be atomic with respect to other file system operations.

    Note that the result of this method is immediately outdated, there is
   no guarantee that a subsequent attempt to execute the file will succeed
   (or even that it will access the same file). Care should be taken when
   using this method in security sensitive applications.

  path - the path to the file to check - `java.nio.file.Path`

  returns: true if the file exists and is executable; false
            if the file does not exist, execute access would be denied because
            the Java virtual machine has insufficient privileges, or access
            cannot be determined - `boolean`

  throws: java.lang.SecurityException - In the case of the default provider, and a security manager is installed, the checkExec is invoked to check execute access to the file."
  (^Boolean [^java.nio.file.Path path]
    (Files/isExecutable path)))

(defn *writable?
  "Tests whether a file is writable. This method checks that a file exists
   and that this Java virtual machine has appropriate privileges that would
   allow it open the file for writing. Depending on the implementation, this
   method may require to read file permissions, access control lists, or
   other file attributes in order to check the effective access to the file.
   Consequently, this method may not be atomic with respect to other file
   system operations.

    Note that result of this method is immediately outdated, there is no
   guarantee that a subsequent attempt to open the file for writing will
   succeed (or even that it will access the same file). Care should be taken
   when using this method in security sensitive applications.

  path - the path to the file to check - `java.nio.file.Path`

  returns: true if the file exists and is writable; false
            if the file does not exist, write access would be denied because
            the Java virtual machine has insufficient privileges, or access
            cannot be determined - `boolean`

  throws: java.lang.SecurityException - In the case of the default provider, and a security manager is installed, the checkWrite is invoked to check write access to the file."
  (^Boolean [^java.nio.file.Path path]
    (Files/isWritable path)))

(defn *new-directory-stream
  "Opens a directory, returning a DirectoryStream to iterate over
   the entries in the directory. The elements returned by the directory
   stream's iterator are of type Path, each one representing an entry in the directory. The Path
   objects are obtained as if by resolving the
   name of the directory entry against dir. The entries returned by
   the iterator are filtered by matching the String representation
   of their file names against the given globbing pattern.

    For example, suppose we want to iterate over the files ending with
   \".java\" in a directory:


       Path dir = ...
       try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, \"*.java\")) {
           :
       }

    The globbing pattern is specified by the getPathMatcher method.

    When not using the try-with-resources construct, then directory
   stream's close method should be invoked after iteration is
   completed so as to free any resources held for the open directory.

    When an implementation supports operations on entries in the
   directory that execute in a race-free manner then the returned directory
   stream is a SecureDirectoryStream.

  dir - the path to the directory - `java.nio.file.Path`
  glob - the glob pattern - `java.lang.String`

  returns: a new and open DirectoryStream object - `java.nio.file.DirectoryStream<java.nio.file.Path>`

  throws: java.util.regex.PatternSyntaxException - if the pattern is invalid"
  (^java.nio.file.DirectoryStream [^java.nio.file.Path dir ^java.lang.String glob]
    (Files/newDirectoryStream dir glob))
  (^java.nio.file.DirectoryStream [^java.nio.file.Path dir]
    (Files/newDirectoryStream dir)))

(defn *write
  "Write lines of text to a file. Each line is a char sequence and is
   written to the file in sequence with each line terminated by the
   platform's line separator, as defined by the system property line.separator. Characters are encoded into bytes using the specified
   charset.

    The options parameter specifies how the the file is created
   or opened. If no options are present then this method works as if the
   CREATE, TRUNCATE_EXISTING, and WRITE options are present. In other words, it
   opens the file for writing, creating the file if it doesn't exist, or
   initially truncating an existing regular-file to
   a size of 0. The method ensures that the file is closed when all
   lines have been written (or an I/O error or other runtime exception is
   thrown). If an I/O error occurs then it may do so after the file has
   created or truncated, or after some bytes have been written to the file.

  path - the path to the file - `java.nio.file.Path`
  lines - an object to iterate over the char sequences - `java.lang.Iterable`
  cs - the charset to use for encoding - `java.nio.charset.Charset`
  options - options specifying how the file is opened - `java.nio.file.OpenOption`

  returns: the path - `java.nio.file.Path`

  throws: java.io.IOException - if an I/O error occurs writing to or creating the file, or the text cannot be encoded using the specified charset"
  (^java.nio.file.Path [^java.nio.file.Path path ^java.lang.Iterable lines ^java.nio.charset.Charset cs ^java.nio.file.OpenOption options]
    (Files/write path lines cs options))
  (^java.nio.file.Path [^java.nio.file.Path path bytes ^java.nio.file.OpenOption options]
    (Files/write path bytes options)))

(defn *create-directory
  "Creates a new directory. The check for the existence of the file and the
   creation of the directory if it does not exist are a single operation
   that is atomic with respect to all other filesystem activities that might
   affect the directory. The createDirectories
   method should be used where it is required to create all nonexistent
   parent directories first.

    The attrs parameter is optional file-attributes to set atomically when creating the directory. Each
   attribute is identified by its name. If more
   than one attribute of the same name is included in the array then all but
   the last occurrence is ignored.

  dir - the directory to create - `java.nio.file.Path`
  attrs - an optional list of file attributes to set atomically when creating the directory - `java.nio.file.attribute.FileAttribute`

  returns: the directory - `java.nio.file.Path`

  throws: java.lang.UnsupportedOperationException - if the array contains an attribute that cannot be set atomically when creating the directory"
  (^java.nio.file.Path [^java.nio.file.Path dir ^java.nio.file.attribute.FileAttribute attrs]
    (Files/createDirectory dir attrs)))

(defn *new-output-stream
  "Opens or creates a file, returning an output stream that may be used to
   write bytes to the file. The resulting stream will not be buffered. The
   stream will be safe for access by multiple concurrent threads. Whether
   the returned stream is asynchronously closeable and/or
   interruptible is highly file system provider specific and
   therefore not specified.

    This method opens or creates a file in exactly the manner specified
   by the newByteChannel
   method with the exception that the READ
   option may not be present in the array of options. If no options are
   present then this method works as if the CREATE, TRUNCATE_EXISTING,
   and WRITE options are present. In other
   words, it opens the file for writing, creating the file if it doesn't
   exist, or initially truncating an existing regular-file to a size of 0 if it exists.

    Usage Examples:


       Path path = ...

       // truncate and overwrite an existing file, or create the file if
       // it doesn't initially exist
       OutputStream out = Files.newOutputStream(path);

       // append to an existing file, fail if the file does not exist
       out = Files.newOutputStream(path, APPEND);

       // append to an existing file, create file if it doesn't initially exist
       out = Files.newOutputStream(path, CREATE, APPEND);

       // always create new file, failing if it already exists
       out = Files.newOutputStream(path, CREATE_NEW);

  path - the path to the file to open or create - `java.nio.file.Path`
  options - options specifying how the file is opened - `java.nio.file.OpenOption`

  returns: a new output stream - `java.io.OutputStream`

  throws: java.lang.IllegalArgumentException - if options contains an invalid combination of options"
  (^java.io.OutputStream [^java.nio.file.Path path ^java.nio.file.OpenOption options]
    (Files/newOutputStream path options)))

(defn *read-all-lines
  "Read all lines from a file. This method ensures that the file is
   closed when all bytes have been read or an I/O error, or other runtime
   exception, is thrown. Bytes from the file are decoded into characters
   using the specified charset.

    This method recognizes the following as line terminators:

      \\u000D followed by \\u000A,
       CARRIAGE RETURN followed by LINE FEED
      \\u000A, LINE FEED
      \\u000D, CARRIAGE RETURN

    Additional Unicode line terminators may be recognized in future
   releases.

    Note that this method is intended for simple cases where it is
   convenient to read all lines in a single operation. It is not intended
   for reading in large files.

  path - the path to the file - `java.nio.file.Path`
  cs - the charset to use for decoding - `java.nio.charset.Charset`

  returns: the lines from the file as a List; whether the List is modifiable or not is implementation dependent and
            therefore not specified - `java.util.List<java.lang.String>`

  throws: java.io.IOException - if an I/O error occurs reading from the file or a malformed or unmappable byte sequence is read"
  (^java.util.List [^java.nio.file.Path path ^java.nio.charset.Charset cs]
    (Files/readAllLines path cs))
  (^java.util.List [^java.nio.file.Path path]
    (Files/readAllLines path)))

