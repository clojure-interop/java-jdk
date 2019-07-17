(ns javax.tools.ForwardingJavaFileManager
  "Forwards calls to a given file manager.  Subclasses of this class
  might override some of these methods and might also provide
  additional fields and methods."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.tools ForwardingJavaFileManager]))

(defn get-java-file-for-input
  "Description copied from interface: JavaFileManager

  location - a location - `javax.tools.JavaFileManager.Location`
  class-name - the name of a class - `java.lang.String`
  kind - the kind of file, must be one of SOURCE or CLASS - `javax.tools.JavaFileObject.Kind`

  returns: a file object, might return null if the
   file does not exist - `javax.tools.JavaFileObject`

  throws: java.lang.IllegalArgumentException - if the location is not known to this file manager and the file manager does not support unknown locations, or if the kind is not valid"
  ([^javax.tools.ForwardingJavaFileManager this ^javax.tools.JavaFileManager.Location location ^java.lang.String class-name ^javax.tools.JavaFileObject.Kind kind]
    (-> this (.getJavaFileForInput location class-name kind))))

(defn list
  "Description copied from interface: JavaFileManager

  location - a location - `javax.tools.JavaFileManager.Location`
  package-name - a package name - `java.lang.String`
  kinds - return objects only of these kinds - `java.util.Set<javax.tools.JavaFileObject.Kind>`
  recurse - if true include `subpackages` - `boolean`

  returns: an Iterable of file objects matching the given criteria - `java.lang.Iterable<javax.tools.JavaFileObject>`

  throws: java.io.IOException - if an I/O error occurred, or if JavaFileManager.close() has been called and this file manager cannot be reopened"
  ([^javax.tools.ForwardingJavaFileManager this ^javax.tools.JavaFileManager.Location location ^java.lang.String package-name ^java.util.Set kinds ^Boolean recurse]
    (-> this (.list location package-name kinds recurse))))

(defn handle-option
  "Description copied from interface: JavaFileManager

  current - current option - `java.lang.String`
  remaining - remaining options - `java.util.Iterator<java.lang.String>`

  returns: true if this option was handled by this file manager,
   false otherwise - `boolean`

  throws: java.lang.IllegalArgumentException - if this option to this file manager is used incorrectly"
  ([^javax.tools.ForwardingJavaFileManager this ^java.lang.String current ^java.util.Iterator remaining]
    (-> this (.handleOption current remaining))))

(defn infer-binary-name
  "Description copied from interface: JavaFileManager

  location - a location - `javax.tools.JavaFileManager.Location`
  file - a file object - `javax.tools.JavaFileObject`

  returns: a binary name or null the file object is not
   found in the given location - `java.lang.String`

  throws: java.lang.IllegalStateException - if JavaFileManager.close() has been called and this file manager cannot be reopened"
  ([^javax.tools.ForwardingJavaFileManager this ^javax.tools.JavaFileManager.Location location ^javax.tools.JavaFileObject file]
    (-> this (.inferBinaryName location file))))

(defn flush
  "Description copied from interface: JavaFileManager

  throws: java.io.IOException - if an I/O error occurred"
  ([^javax.tools.ForwardingJavaFileManager this]
    (-> this (.flush))))

(defn same-file?
  "Description copied from interface: JavaFileManager

  a - a file object - `javax.tools.FileObject`
  b - a file object - `javax.tools.FileObject`

  returns: true if the given file objects represent the same
   underlying object - `boolean`

  throws: java.lang.IllegalArgumentException - if either of the arguments were created with another file manager and this file manager does not support foreign file objects"
  ([^javax.tools.ForwardingJavaFileManager this ^javax.tools.FileObject a ^javax.tools.FileObject b]
    (-> this (.isSameFile a b))))

(defn is-supported-option
  "Description copied from interface: OptionChecker

  option - an option - `java.lang.String`

  returns: the number of arguments the given option takes or -1 if
   the option is not supported - `int`"
  ([^javax.tools.ForwardingJavaFileManager this ^java.lang.String option]
    (-> this (.isSupportedOption option))))

(defn get-class-loader
  "Description copied from interface: JavaFileManager

  location - a location - `javax.tools.JavaFileManager.Location`

  returns: a class loader for the given location; or null
   if loading plug-ins from the given location is disabled or if
   the location is not known - `java.lang.ClassLoader`

  throws: java.lang.SecurityException - if a class loader can not be created in the current security context"
  ([^javax.tools.ForwardingJavaFileManager this ^javax.tools.JavaFileManager.Location location]
    (-> this (.getClassLoader location))))

(defn close
  "Description copied from interface: JavaFileManager

  throws: java.io.IOException - if an I/O error occurred"
  ([^javax.tools.ForwardingJavaFileManager this]
    (-> this (.close))))

(defn has-location?
  "Description copied from interface: JavaFileManager

  location - a location - `javax.tools.JavaFileManager.Location`

  returns: true if the location is known - `boolean`"
  ([^javax.tools.ForwardingJavaFileManager this ^javax.tools.JavaFileManager.Location location]
    (-> this (.hasLocation location))))

(defn get-file-for-input
  "Description copied from interface: JavaFileManager

  location - a location - `javax.tools.JavaFileManager.Location`
  package-name - a package name - `java.lang.String`
  relative-name - a relative name - `java.lang.String`

  returns: a file object, might return null if the file
   does not exist - `javax.tools.FileObject`

  throws: java.lang.IllegalArgumentException - if the location is not known to this file manager and the file manager does not support unknown locations, or if relativeName is not valid"
  ([^javax.tools.ForwardingJavaFileManager this ^javax.tools.JavaFileManager.Location location ^java.lang.String package-name ^java.lang.String relative-name]
    (-> this (.getFileForInput location package-name relative-name))))

(defn get-java-file-for-output
  "Description copied from interface: JavaFileManager

  location - a location - `javax.tools.JavaFileManager.Location`
  class-name - the name of a class - `java.lang.String`
  kind - the kind of file, must be one of SOURCE or CLASS - `javax.tools.JavaFileObject.Kind`
  sibling - a file object to be used as hint for placement; might be null - `javax.tools.FileObject`

  returns: a file object for output - `javax.tools.JavaFileObject`

  throws: java.lang.IllegalArgumentException - if sibling is not known to this file manager, or if the location is not known to this file manager and the file manager does not support unknown locations, or if the kind is not valid"
  ([^javax.tools.ForwardingJavaFileManager this ^javax.tools.JavaFileManager.Location location ^java.lang.String class-name ^javax.tools.JavaFileObject.Kind kind ^javax.tools.FileObject sibling]
    (-> this (.getJavaFileForOutput location class-name kind sibling))))

(defn get-file-for-output
  "Description copied from interface: JavaFileManager

  location - a location - `javax.tools.JavaFileManager.Location`
  package-name - a package name - `java.lang.String`
  relative-name - a relative name - `java.lang.String`
  sibling - a file object to be used as hint for placement; might be null - `javax.tools.FileObject`

  returns: a file object - `javax.tools.FileObject`

  throws: java.lang.IllegalArgumentException - if sibling is not known to this file manager, or if the location is not known to this file manager and the file manager does not support unknown locations, or if relativeName is not valid"
  ([^javax.tools.ForwardingJavaFileManager this ^javax.tools.JavaFileManager.Location location ^java.lang.String package-name ^java.lang.String relative-name ^javax.tools.FileObject sibling]
    (-> this (.getFileForOutput location package-name relative-name sibling))))

