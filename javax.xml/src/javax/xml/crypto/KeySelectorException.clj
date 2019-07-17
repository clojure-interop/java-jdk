(ns javax.xml.crypto.KeySelectorException
  "Indicates an exceptional condition thrown by a KeySelector.

  A KeySelectorException can contain a cause: another
  throwable that caused this KeySelectorException to get thrown."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.crypto KeySelectorException]))

(defn ->key-selector-exception
  "Constructor.

  Constructs a new KeySelectorException with the
   specified detail message and cause.
   Note that the detail message associated with
   cause is not automatically incorporated in
   this exception's detail message.

  message - the detail message - `java.lang.String`
  cause - the cause (A null value is permitted, and indicates that the cause is nonexistent or unknown.) - `java.lang.Throwable`"
  ([^java.lang.String message ^java.lang.Throwable cause]
    (new KeySelectorException message cause))
  ([^java.lang.String message]
    (new KeySelectorException message))
  ([]
    (new KeySelectorException )))

(defn get-cause
  "Returns the cause of this KeySelectorException or
   null if the cause is nonexistent or unknown.  (The
   cause is the throwable that caused this
   KeySelectorException to get thrown.)

  returns: the cause of this KeySelectorException or
           null if the cause is nonexistent or unknown. - `java.lang.Throwable`"
  (^java.lang.Throwable [^javax.xml.crypto.KeySelectorException this]
    (-> this (.getCause))))

(defn print-stack-trace
  "Prints this KeySelectorException, its backtrace and
   the cause's backtrace to the specified print stream.

  s - PrintStream to use for output - `java.io.PrintStream`"
  ([^javax.xml.crypto.KeySelectorException this ^java.io.PrintStream s]
    (-> this (.printStackTrace s)))
  ([^javax.xml.crypto.KeySelectorException this]
    (-> this (.printStackTrace))))

