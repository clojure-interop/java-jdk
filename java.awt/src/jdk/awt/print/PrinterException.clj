(ns jdk.awt.print.PrinterException
  "The PrinterException class and its subclasses are used
  to indicate that an exceptional condition has occurred in the print
  system."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.print PrinterException]))

(defn ->printer-exception
  "Constructor.

  Constructs a new PrinterException object
   with the specified detail message.

  msg - the message to generate when a PrinterException is thrown - `java.lang.String`"
  (^PrinterException [^java.lang.String msg]
    (new PrinterException msg))
  (^PrinterException []
    (new PrinterException )))

