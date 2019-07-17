(ns jdk.awt.print.PrinterIOException
  "The PrinterIOException class is a subclass of
  PrinterException and is used to indicate that an IO error
  of some sort has occurred while printing.

  As of release 1.4, this exception has been retrofitted to conform to
  the general purpose exception-chaining mechanism.  The
  `IOException that terminated the print job`
  that is provided at construction time and accessed via the
  getIOException() method is now known as the cause,
  and may be accessed via the Throwable.getCause() method,
  as well as the aforementioned `legacy method.`"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.print PrinterIOException]))

(defn ->printer-io-exception
  "Constructor.

  Constructs a new PrinterIOException
   with the string representation of the specified
   IOException.

  exception - the specified IOException - `java.io.IOException`"
  ([^java.io.IOException exception]
    (new PrinterIOException exception)))

(defn get-io-exception
  "Returns the IOException that terminated
   the print job.

   This method predates the general-purpose exception chaining facility.
   The Throwable.getCause() method is now the preferred means of
   obtaining this information.

  returns: the IOException that terminated
   the print job. - `java.io.IOException`"
  ([^java.awt.print.PrinterIOException this]
    (-> this (.getIOException))))

(defn get-cause
  "Returns the the cause of this exception (the IOException
   that terminated the print job).

  returns: the cause of this exception. - `java.lang.Throwable`"
  ([^java.awt.print.PrinterIOException this]
    (-> this (.getCause))))

