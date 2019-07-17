(ns javax.rmi.CORBA.ValueHandler
  "Defines methods which allow serialization of Java objects
  to and from GIOP streams."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.rmi.CORBA ValueHandler]))

(defn write-value
  "Writes a value to the stream using Java semantics.

  out - the stream to write the value to. - `org.omg.CORBA.portable.OutputStream`
  value - the value to be written to the stream. - `java.io.Serializable`"
  ([this out value]
    (-> this (.writeValue out value))))

(defn read-value
  "Reads a value from the stream using Java semantics.

  in - the stream to read the value from. - `org.omg.CORBA.portable.InputStream`
  offset - the current position in the input stream. - `int`
  clz - the type of the value to be read in. - `java.lang.Class`
  repository-id - the RepositoryId of the value to be read in. - `java.lang.String`
  sender - the sending context runtime codebase. - `org.omg.SendingContext.RunTime`

  returns: the value read from the stream. - `java.io.Serializable`"
  ([this in offset clz repository-id sender]
    (-> this (.readValue in offset clz repository-id sender))))

(defn get-rmi-repository-id
  "Returns the CORBA RepositoryId for the given Java class.

  clz - a Java class. - `java.lang.Class`

  returns: the CORBA RepositoryId for the class. - `java.lang.String`"
  ([this clz]
    (-> this (.getRMIRepositoryID clz))))

(defn custom-marshaled?
  "Indicates whether the given class performs custom or
   default marshaling.

  clz - the class to test for custom marshaling. - `java.lang.Class`

  returns: true if the class performs custom marshaling, false
   if it does not. - `boolean`"
  ([this clz]
    (-> this (.isCustomMarshaled clz))))

(defn get-run-time-code-base
  "Returns the CodeBase for this ValueHandler.  This is used by
   the ORB runtime.  The server sends the service context containing
   the IOR for this CodeBase on the first GIOP reply.  The client
   does the same on the first GIOP request.

  returns: the SendingContext.CodeBase of this ValueHandler. - `org.omg.SendingContext.RunTime`"
  ([this]
    (-> this (.getRunTimeCodeBase))))

(defn write-replace
  "If the value contains a writeReplace method then the result
   is returned.  Otherwise, the value itself is returned.

  value - the value to be marshaled. - `java.io.Serializable`

  returns: the true value to marshal on the wire. - `java.io.Serializable`"
  ([this value]
    (-> this (.writeReplace value))))

