(ns javax.xml.crypto.URIReferenceException
  "Indicates an exceptional condition thrown while dereferencing a
  URIReference.

  A URIReferenceException can contain a cause: another
  throwable that caused this URIReferenceException to get thrown."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.crypto URIReferenceException]))

(defn ->uri-reference-exception
  "Constructor.

  Constructs a new URIReferenceException with the
   specified detail message, cause and URIReference.
   Note that the detail message associated with
   cause is not automatically incorporated in
   this exception's detail message.

  message - the detail message - `java.lang.String`
  cause - the cause (A null value is permitted, and indicates that the cause is nonexistent or unknown.) - `java.lang.Throwable`
  uri-reference - the URIReference that was being dereferenced when the error was encountered - `javax.xml.crypto.URIReference`

  throws: java.lang.NullPointerException - if uriReference is null"
  ([message cause uri-reference]
    (new URIReferenceException message cause uri-reference))
  ([message cause]
    (new URIReferenceException message cause))
  ([message]
    (new URIReferenceException message))
  ([]
    (new URIReferenceException )))

(defn get-uri-reference
  "Returns the URIReference that was being dereferenced
   when the exception was thrown.

  returns: the URIReference that was being dereferenced
   when the exception was thrown, or null if not specified - `javax.xml.crypto.URIReference`"
  ([this]
    (-> this (.getURIReference))))

(defn get-cause
  "Returns the cause of this URIReferenceException or
   null if the cause is nonexistent or unknown.  (The
   cause is the throwable that caused this
   URIReferenceException to get thrown.)

  returns: the cause of this URIReferenceException or
      null if the cause is nonexistent or unknown. - `java.lang.Throwable`"
  ([this]
    (-> this (.getCause))))

(defn print-stack-trace
  "Prints this URIReferenceException, its backtrace and
   the cause's backtrace to the specified print stream.

  s - PrintStream to use for output - `java.io.PrintStream`"
  ([this s]
    (-> this (.printStackTrace s)))
  ([this]
    (-> this (.printStackTrace))))

