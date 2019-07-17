(ns jdk.util.jar.Manifest
  "The Manifest class is used to maintain Manifest entry names and their
  associated Attributes. There are main Manifest Attributes as well as
  per-entry Attributes. For information on the Manifest format, please
  see the

  Manifest format specification."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.jar Manifest]))

(defn ->manifest
  "Constructor.

  Constructs a new Manifest from the specified input stream.

  is - the input stream containing manifest data - `java.io.InputStream`

  throws: java.io.IOException - if an I/O error has occurred"
  ([^java.io.InputStream is]
    (new Manifest is))
  ([]
    (new Manifest )))

(defn read
  "Reads the Manifest from the specified InputStream. The entry
   names and attributes read will be merged in with the current
   manifest entries.

  is - the input stream - `java.io.InputStream`

  throws: java.io.IOException - if an I/O error has occurred"
  ([^java.util.jar.Manifest this ^java.io.InputStream is]
    (-> this (.read is))))

(defn get-main-attributes
  "Returns the main Attributes for the Manifest.

  returns: the main Attributes for the Manifest - `java.util.jar.Attributes`"
  ([^java.util.jar.Manifest this]
    (-> this (.getMainAttributes))))

(defn get-entries
  "Returns a Map of the entries contained in this Manifest. Each entry
   is represented by a String name (key) and associated Attributes (value).
   The Map permits the null key, but no entry with a null key is
   created by read(java.io.InputStream), nor is such an entry written by using write(java.io.OutputStream).

  returns: a Map of the entries contained in this Manifest - `java.util.Map<java.lang.String,java.util.jar.Attributes>`"
  ([^java.util.jar.Manifest this]
    (-> this (.getEntries))))

(defn clone
  "Returns a shallow copy of this Manifest.  The shallow copy is
   implemented as follows:


       public Object clone() { return new Manifest(this); }

  returns: a shallow copy of this Manifest - `java.lang.Object`"
  ([^java.util.jar.Manifest this]
    (-> this (.clone))))

(defn hash-code
  "Returns the hash code for this Manifest.

  returns: a hash code value for this object. - `int`"
  ([^java.util.jar.Manifest this]
    (-> this (.hashCode))))

(defn clear
  "Clears the main Attributes as well as the entries in this Manifest."
  ([^java.util.jar.Manifest this]
    (-> this (.clear))))

(defn write
  "Writes the Manifest to the specified OutputStream.
   Attributes.Name.MANIFEST_VERSION must be set in
   MainAttributes prior to invoking this method.

  out - the output stream - `java.io.OutputStream`

  throws: java.io.IOException - if an I/O error has occurred"
  ([^java.util.jar.Manifest this ^java.io.OutputStream out]
    (-> this (.write out))))

(defn equals
  "Returns true if the specified Object is also a Manifest and has
   the same main Attributes and entries.

  o - the object to be compared - `java.lang.Object`

  returns: true if the specified Object is also a Manifest and has
   the same main Attributes and entries - `boolean`"
  ([^java.util.jar.Manifest this ^java.lang.Object o]
    (-> this (.equals o))))

(defn get-attributes
  "Returns the Attributes for the specified entry name.
   This method is defined as:


        return (Attributes)getEntries().get(name)
   Though null is a valid name, when
   getAttributes(null) is invoked on a Manifest
   obtained from a jar file, null will be returned.  While jar
   files themselves do not allow null-named attributes, it is
   possible to invoke getEntries() on a Manifest, and
   on that result, invoke put with a null key and an
   arbitrary value.  Subsequent invocations of
   getAttributes(null) will return the just-put
   value.

   Note that this method does not return the manifest's main attributes;
   see getMainAttributes().

  name - entry name - `java.lang.String`

  returns: the Attributes for the specified entry name - `java.util.jar.Attributes`"
  ([^java.util.jar.Manifest this ^java.lang.String name]
    (-> this (.getAttributes name))))

