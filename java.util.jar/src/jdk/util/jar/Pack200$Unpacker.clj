(ns jdk.util.jar.Pack200$Unpacker
  "The unpacker engine converts the packed stream to a JAR file.
  An instance of the engine can be obtained
  using Pack200.newUnpacker().

  Every JAR file produced by this engine will include the string
  \"PACK200\" as a zip file comment.
  This allows a deployer to detect if a JAR archive was packed and unpacked.

  Note: Unless otherwise noted, passing a null argument to a
  constructor or method in this class will cause a NullPointerException
  to be thrown.

  This version of the unpacker is compatible with all previous versions."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.jar Pack200$Unpacker]))

(defn properties
  "Get the set of this engine's properties. This set is
   a \"live view\", so that changing its
   contents immediately affects the Packer engine, and
   changes from the engine (such as progress indications)
   are immediately visible in the map.

   The property map may contain pre-defined implementation
   specific and default properties.  Users are encouraged to
   read the information and fully understand the implications,
   before modifying pre-existing properties.

   Implementation specific properties are prefixed with a
   package name associated with the implementor, beginning
   with com. or a similar prefix.
   All property names beginning with pack. and
   unpack. are reserved for use by this API.

   Unknown properties may be ignored or rejected with an
   unspecified error, and invalid entries may cause an
   unspecified error to be thrown.

  returns: A sorted association of option key strings to option values. - `java.util.SortedMap<java.lang.String,java.lang.String>`"
  (^java.util.SortedMap [^Pack200$Unpacker this]
    (-> this (.properties))))

(defn unpack
  "Read a Pack200 archive, and write the encoded JAR to
   a JarOutputStream.
   The entire contents of the input stream will be read.
   It may be more efficient to read the Pack200 archive
   to a file and pass the File object, using the alternate
   method described below.

   Closes its input but not its output.  (The output can accumulate more elements.)

  in - an InputStream. - `java.io.InputStream`
  out - a JarOutputStream. - `java.util.jar.JarOutputStream`

  throws: java.io.IOException - if an error is encountered."
  ([^Pack200$Unpacker this ^java.io.InputStream in ^java.util.jar.JarOutputStream out]
    (-> this (.unpack in out))))

(defn add-property-change-listener
  "Deprecated. The dependency on PropertyChangeListener creates
               a significant impediment to future modularization of the
               Java platform. This method will be removed in a future
               release.
               Applications that need to monitor progress of the
               unpacker can poll the value of the PROGRESS property instead.

  listener - An object to be invoked when a property is changed. - `java.beans.PropertyChangeListener`

  returns: `default void`"
  ([^Pack200$Unpacker this ^java.beans.PropertyChangeListener listener]
    (-> this (.addPropertyChangeListener listener))))

(defn remove-property-change-listener
  "Deprecated. The dependency on PropertyChangeListener creates
               a significant impediment to future modularization of the
               Java platform. This method will be removed in a future
               release.

  listener - The PropertyChange listener to be removed. - `java.beans.PropertyChangeListener`

  returns: `default void`"
  ([^Pack200$Unpacker this ^java.beans.PropertyChangeListener listener]
    (-> this (.removePropertyChangeListener listener))))

