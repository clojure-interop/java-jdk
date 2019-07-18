(ns jdk.util.logging.ErrorManager
  "ErrorManager objects can be attached to Handlers to process
  any error that occurs on a Handler during Logging.

  When processing logging output, if a Handler encounters problems
  then rather than throwing an Exception back to the issuer of
  the logging call (who is unlikely to be interested) the Handler
  should call its associated ErrorManager."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.logging ErrorManager]))

(defn ->error-manager
  "Constructor."
  (^ErrorManager []
    (new ErrorManager )))

(def *-generic-failure
  "Static Constant.

  GENERIC_FAILURE is used for failure that don't fit
   into one of the other categories.

  type: int"
  ErrorManager/GENERIC_FAILURE)

(def *-write-failure
  "Static Constant.

  WRITE_FAILURE is used when a write to an output stream fails.

  type: int"
  ErrorManager/WRITE_FAILURE)

(def *-flush-failure
  "Static Constant.

  FLUSH_FAILURE is used when a flush to an output stream fails.

  type: int"
  ErrorManager/FLUSH_FAILURE)

(def *-close-failure
  "Static Constant.

  CLOSE_FAILURE is used when a close of an output stream fails.

  type: int"
  ErrorManager/CLOSE_FAILURE)

(def *-open-failure
  "Static Constant.

  OPEN_FAILURE is used when an open of an output stream fails.

  type: int"
  ErrorManager/OPEN_FAILURE)

(def *-format-failure
  "Static Constant.

  FORMAT_FAILURE is used when formatting fails for any reason.

  type: int"
  ErrorManager/FORMAT_FAILURE)

(defn error
  "The error method is called when a Handler failure occurs.

   This method may be overridden in subclasses.  The default
   behavior in this base class is that the first call is
   reported to System.err, and subsequent calls are ignored.

  msg - a descriptive string (may be null) - `java.lang.String`
  ex - an exception (may be null) - `java.lang.Exception`
  code - an error code defined in ErrorManager - `int`"
  ([^ErrorManager this ^java.lang.String msg ^java.lang.Exception ex ^Integer code]
    (-> this (.error msg ex code))))

