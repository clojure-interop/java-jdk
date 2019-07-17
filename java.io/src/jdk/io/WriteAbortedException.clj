(ns jdk.io.WriteAbortedException
  "Signals that one of the ObjectStreamExceptions was thrown during a
  write operation.  Thrown during a read operation when one of the
  ObjectStreamExceptions was thrown during a write operation.  The
  exception that terminated the write can be found in the detail
  field. The stream is reset to it's initial state and all references
  to objects already deserialized are discarded.

  As of release 1.4, this exception has been retrofitted to conform to
  the general purpose exception-chaining mechanism.  The `exception causing
  the abort` that is provided at construction time and
  accessed via the public detail field is now known as the
  cause, and may be accessed via the Throwable.getCause()
  method, as well as the aforementioned `legacy field.`"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.io WriteAbortedException]))

(defn ->write-aborted-exception
  "Constructor.

  Constructs a WriteAbortedException with a string describing
   the exception and the exception causing the abort.

  s - String describing the exception. - `java.lang.String`
  ex - Exception causing the abort. - `java.lang.Exception`"
  ([^java.lang.String s ^java.lang.Exception ex]
    (new WriteAbortedException s ex)))

(defn -detail
  "Instance Field.

  Exception that was caught while writing the ObjectStream.

   This field predates the general-purpose exception chaining facility.
   The Throwable.getCause() method is now the preferred means of
   obtaining this information.

  type: java.lang.Exception"
  [this]
  (-> this .-detail))

(defn get-message
  "Produce the message and include the message from the nested
   exception, if there is one.

  returns: the detail message string of this Throwable instance
            (which may be null). - `java.lang.String`"
  ([^java.io.WriteAbortedException this]
    (-> this (.getMessage))))

(defn get-cause
  "Returns the exception that terminated the operation (the cause).

  returns: the exception that terminated the operation (the cause),
            which may be null. - `java.lang.Throwable`"
  ([^java.io.WriteAbortedException this]
    (-> this (.getCause))))

