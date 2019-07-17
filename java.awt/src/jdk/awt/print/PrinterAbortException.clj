(ns jdk.awt.print.PrinterAbortException
  "The PrinterAbortException class is a subclass of
  PrinterException and is used to indicate that a user
  or application has terminated the print job while it was in
  the process of printing."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.print PrinterAbortException]))

(defn ->printer-abort-exception
  "Constructor.

  Constructs a new PrinterAbortException with
   the specified detail message.

  msg - the message to be generated when a PrinterAbortException is thrown - `java.lang.String`"
  ([msg]
    (new PrinterAbortException msg))
  ([]
    (new PrinterAbortException )))

