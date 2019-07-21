(ns javax.tools.JavaFileManager
  "File manager for tools operating on Java™ programming language
  source and class files.  In this context, file means an
  abstraction of regular files and other sources of data.

  When constructing new JavaFileObjects, the file manager must
  determine where to create them.  For example, if a file manager
  manages regular files on a file system, it would most likely have a
  current/working directory to use as default location when creating
  or finding files.  A number of hints can be provided to a file
  manager as to where to create files.  Any file manager might choose
  to ignore these hints.

  Some methods in this interface use class names.  Such class
  names must be given in the Java Virtual Machine internal form of
  fully qualified class and interface names.  For convenience '.'
  and '/' are interchangeable.  The internal form is defined in
  chapter four of
  The Java™ Virtual Machine Specification.


    Discussion: this means that the names
    \"java/lang.package-info\", \"java/lang/package-info\",
    \"java.lang.package-info\", are valid and equivalent.  Compare to
    binary name as defined in
    The Java™ Language Specification,
    section 13.1 \"The Form of a Binary\".


  The case of names is significant.  All names should be treated
  as case-sensitive.  For example, some file systems have
  case-insensitive, case-aware file names.  File objects representing
  such files should take care to preserve case by using File.getCanonicalFile() or similar means.  If the system is
  not case-aware, file objects must use other means to preserve case.

  Relative names: some
  methods in this interface use relative names.  A relative name is a
  non-null, non-empty sequence of path segments separated by '/'.
  '.' or '..'  are invalid path segments.  A valid relative name must
  match the \"path-rootless\" rule of RFC 3986,
  section 3.3.  Informally, this should be true:

   URI.create(relativeName).normalize().getPath().equals(relativeName)


   URI.create(relativeName).normalize().getPath().equals(relativeName)

  All methods in this interface might throw a SecurityException.

  An object of this interface is not required to support
  multi-threaded access, that is, be synchronized.  However, it must
  support concurrent access to different file objects created by this
  object.

  Implementation note: a consequence of this requirement
  is that a trivial implementation of output to a java.util.jar.JarOutputStream is not a sufficient implementation.
  That is, rather than creating a JavaFileObject that returns the
  JarOutputStream directly, the contents must be cached until closed
  and then written to the JarOutputStream.

  Unless explicitly allowed, all methods in this interface might
  throw a NullPointerException if given a null argument."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.tools JavaFileManager]))

(defn get-java-file-for-input
  "Gets a javax.tools.file object for input
   representing the specified class of the specified kind in the
   given location.

  location - a location - `javax.tools.JavaFileManager$Location`
  class-name - the name of a class - `java.lang.String`
  kind - the kind of file, must be one of SOURCE or CLASS - `javax.tools.JavaFileObject$Kind`

  returns: a file object, might return null if the
   file does not exist - `javax.tools.JavaFileObject`

  throws: java.lang.IllegalArgumentException - if the location is not known to this file manager and the file manager does not support unknown locations, or if the kind is not valid"
  (^javax.tools.JavaFileObject [^JavaFileManager this ^javax.tools.JavaFileManager$Location location ^java.lang.String class-name ^javax.tools.JavaFileObject$Kind kind]
    (-> this (.getJavaFileForInput location class-name kind))))

(defn list
  "Lists all file objects matching the given criteria in the given
   location.  List file objects in \"subpackages\" if recurse is
   true.

   Note: even if the given location is unknown to this file
   manager, it may not return null.  Also, an unknown
   location may not cause an exception.

  location - a location - `javax.tools.JavaFileManager$Location`
  package-name - a package name - `java.lang.String`
  kinds - return objects only of these kinds - `java.util.Set`
  recurse - if true include \"subpackages\" - `boolean`

  returns: an Iterable of file objects matching the given criteria - `java.lang.Iterable<javax.tools.JavaFileObject>`

  throws: java.io.IOException - if an I/O error occurred, or if close() has been called and this file manager cannot be reopened"
  (^java.lang.Iterable [^JavaFileManager this ^javax.tools.JavaFileManager$Location location ^java.lang.String package-name ^java.util.Set kinds ^Boolean recurse]
    (-> this (.list location package-name kinds recurse))))

(defn handle-option
  "Handles one option.  If current is an option to this
   file manager it will consume any arguments to that option from
   remaining and return true, otherwise return false.

  current - current option - `java.lang.String`
  remaining - remaining options - `java.util.Iterator`

  returns: true if this option was handled by this file manager,
   false otherwise - `boolean`

  throws: java.lang.IllegalArgumentException - if this option to this file manager is used incorrectly"
  (^Boolean [^JavaFileManager this ^java.lang.String current ^java.util.Iterator remaining]
    (-> this (.handleOption current remaining))))

(defn infer-binary-name
  "Infers a binary name of a file object based on a location.  The
   binary name returned might not be a valid binary name according to
   The Java™ Language Specification.

  location - a location - `javax.tools.JavaFileManager$Location`
  file - a file object - `javax.tools.JavaFileObject`

  returns: a binary name or null the file object is not
   found in the given location - `java.lang.String`

  throws: java.lang.IllegalStateException - if close() has been called and this file manager cannot be reopened"
  (^java.lang.String [^JavaFileManager this ^javax.tools.JavaFileManager$Location location ^javax.tools.JavaFileObject file]
    (-> this (.inferBinaryName location file))))

(defn flush
  "Flushes any resources opened for output by this file manager
   directly or indirectly.  Flushing a closed file manager has no
   effect.

  throws: java.io.IOException - if an I/O error occurred"
  ([^JavaFileManager this]
    (-> this (.flush))))

(defn same-file?
  "Compares two file objects and return true if they represent the
   same underlying object.

  a - a file object - `javax.tools.FileObject`
  b - a file object - `javax.tools.FileObject`

  returns: true if the given file objects represent the same
   underlying object - `boolean`

  throws: java.lang.IllegalArgumentException - if either of the arguments were created with another file manager and this file manager does not support foreign file objects"
  (^Boolean [^JavaFileManager this ^javax.tools.FileObject a ^javax.tools.FileObject b]
    (-> this (.isSameFile a b))))

(defn get-class-loader
  "Gets a class loader for loading plug-ins from the given
   location.  For example, to load annotation processors, a
   compiler will request a class loader for the ANNOTATION_PROCESSOR_PATH location.

  location - a location - `javax.tools.JavaFileManager$Location`

  returns: a class loader for the given location; or null
   if loading plug-ins from the given location is disabled or if
   the location is not known - `java.lang.ClassLoader`

  throws: java.lang.SecurityException - if a class loader can not be created in the current security context"
  (^java.lang.ClassLoader [^JavaFileManager this ^javax.tools.JavaFileManager$Location location]
    (-> this (.getClassLoader location))))

(defn close
  "Releases any resources opened by this file manager directly or
   indirectly.  This might render this file manager useless and
   the effect of subsequent calls to methods on this object or any
   objects obtained through this object is undefined unless
   explicitly allowed.  However, closing a file manager which has
   already been closed has no effect.

  throws: java.io.IOException - if an I/O error occurred"
  ([^JavaFileManager this]
    (-> this (.close))))

(defn has-location?
  "Determines if a location is known to this file manager.

  location - a location - `javax.tools.JavaFileManager$Location`

  returns: true if the location is known - `boolean`"
  (^Boolean [^JavaFileManager this ^javax.tools.JavaFileManager$Location location]
    (-> this (.hasLocation location))))

(defn get-file-for-input
  "Gets a javax.tools.file object for input
   representing the specified relative
   name in the specified package in the given location.

   If the returned object represents a source or class file, it must be an instance
   of JavaFileObject.

   Informally, the file object returned by this method is
   located in the concatenation of the location, package name, and
   relative name.  For example, to locate the properties file
   \"resources/compiler.properties\" in the package
   \"com.sun.tools.javac\" in the SOURCE_PATH location, this method
   might be called like so:



  getFileForInput(SOURCE_PATH, \"com.sun.tools.javac\", \"resources/compiler.properties\");

   If the call was executed on Windows, with SOURCE_PATH set to
   \"C:\\Documents and Settings\\UncleBob\\src\\share\\classes\",
   a valid result would be a file object representing the file
   \"C:\\Documents and Settings\\UncleBob\\src\\share\\classes\\com\\sun\\tools\\javac\\resources\\compiler.properties\".

  location - a location - `javax.tools.JavaFileManager$Location`
  package-name - a package name - `java.lang.String`
  relative-name - a relative name - `java.lang.String`

  returns: a file object, might return null if the file
   does not exist - `javax.tools.FileObject`

  throws: java.lang.IllegalArgumentException - if the location is not known to this file manager and the file manager does not support unknown locations, or if relativeName is not valid"
  (^javax.tools.FileObject [^JavaFileManager this ^javax.tools.JavaFileManager$Location location ^java.lang.String package-name ^java.lang.String relative-name]
    (-> this (.getFileForInput location package-name relative-name))))

(defn get-java-file-for-output
  "Gets a javax.tools.file object for output
   representing the specified class of the specified kind in the
   given location.

   Optionally, this file manager might consider the sibling as
   a hint for where to place the output.  The exact semantics of
   this hint is unspecified.  The JDK compiler, javac, for
   example, will place class files in the same directories as
   originating source files unless a class file output directory
   is provided.  To facilitate this behavior, javac might provide
   the originating source file as sibling when calling this
   method.

  location - a location - `javax.tools.JavaFileManager$Location`
  class-name - the name of a class - `java.lang.String`
  kind - the kind of file, must be one of SOURCE or CLASS - `javax.tools.JavaFileObject$Kind`
  sibling - a file object to be used as hint for placement; might be null - `javax.tools.FileObject`

  returns: a file object for output - `javax.tools.JavaFileObject`

  throws: java.lang.IllegalArgumentException - if sibling is not known to this file manager, or if the location is not known to this file manager and the file manager does not support unknown locations, or if the kind is not valid"
  (^javax.tools.JavaFileObject [^JavaFileManager this ^javax.tools.JavaFileManager$Location location ^java.lang.String class-name ^javax.tools.JavaFileObject$Kind kind ^javax.tools.FileObject sibling]
    (-> this (.getJavaFileForOutput location class-name kind sibling))))

(defn get-file-for-output
  "Gets a javax.tools.file object for output
   representing the specified relative
   name in the specified package in the given location.

   Optionally, this file manager might consider the sibling as
   a hint for where to place the output.  The exact semantics of
   this hint is unspecified.  The JDK compiler, javac, for
   example, will place class files in the same directories as
   originating source files unless a class file output directory
   is provided.  To facilitate this behavior, javac might provide
   the originating source file as sibling when calling this
   method.

   If the returned object represents a source or class file, it must be an instance
   of JavaFileObject.

   Informally, the file object returned by this method is
   located in the concatenation of the location, package name, and
   relative name or next to the sibling argument.  See getFileForInput for an example.

  location - a location - `javax.tools.JavaFileManager$Location`
  package-name - a package name - `java.lang.String`
  relative-name - a relative name - `java.lang.String`
  sibling - a file object to be used as hint for placement; might be null - `javax.tools.FileObject`

  returns: a file object - `javax.tools.FileObject`

  throws: java.lang.IllegalArgumentException - if sibling is not known to this file manager, or if the location is not known to this file manager and the file manager does not support unknown locations, or if relativeName is not valid"
  (^javax.tools.FileObject [^JavaFileManager this ^javax.tools.JavaFileManager$Location location ^java.lang.String package-name ^java.lang.String relative-name ^javax.tools.FileObject sibling]
    (-> this (.getFileForOutput location package-name relative-name sibling))))

