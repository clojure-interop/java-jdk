(ns javax.imageio.IIOException
  "An exception class used for signaling run-time failure of reading
  and writing operations.

   In addition to a message string, a reference to another
  Throwable (Error or
  Exception) is maintained.  This reference, if
  non-null, refers to the event that caused this
  exception to occur.  For example, an IOException while
  reading from a File would be stored there."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.imageio IIOException]))

(defn ->iio-exception
  "Constructor.

  Constructs an IIOException with a given message
   String and a Throwable that was its
   underlying cause.

  message - the error message. - `java.lang.String`
  cause - the Throwable (Error or Exception) that caused this exception to occur. - `java.lang.Throwable`"
  ([^java.lang.String message ^java.lang.Throwable cause]
    (new IIOException message cause))
  ([^java.lang.String message]
    (new IIOException message)))

