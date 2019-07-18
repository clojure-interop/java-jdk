(ns jdk.net.BindException
  "Signals that an error occurred while attempting to bind a
  socket to a local address and port.  Typically, the port is
  in use, or the requested local address could not be assigned."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.net BindException]))

(defn ->bind-exception
  "Constructor.

  Constructs a new BindException with the specified detail
   message as to why the bind error occurred.
   A detail message is a String that gives a specific
   description of this error.

  msg - the detail message - `java.lang.String`"
  (^BindException [^java.lang.String msg]
    (new BindException msg))
  (^BindException []
    (new BindException )))

