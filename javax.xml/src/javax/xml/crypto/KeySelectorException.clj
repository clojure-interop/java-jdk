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
  ([message cause]
    (new KeySelectorException message cause))
  ([message]
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
  ([this]
    (-> this (.getCause))))

(defn print-stack-trace
  "Prints this KeySelectorException, its backtrace and
   the cause's backtrace to the specified print stream.

  s - PrintStream to use for output - `java.io.PrintStream`"
  ([this s]
    (-> this (.printStackTrace s)))
  ([this]
    (-> this (.printStackTrace))))

