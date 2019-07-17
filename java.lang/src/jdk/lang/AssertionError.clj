(ns jdk.lang.AssertionError
  "Thrown to indicate that an assertion has failed.

  The seven one-argument public constructors provided by this
  class ensure that the assertion error returned by the invocation:


      new AssertionError(expression)
  has as its detail message the string conversion of
  expression (as defined in section 15.18.1.1 of
  The Java™ Language Specification),
  regardless of the type of expression."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang AssertionError]))

(defn ->assertion-error
  "Constructor.

  Constructs a new AssertionError with the specified
   detail message and cause.

   Note that the detail message associated with
   cause is not automatically incorporated in
   this error's detail message.

  message - the detail message, may be null - `java.lang.String`
  cause - the cause, may be null - `java.lang.Throwable`"
  ([^java.lang.String message ^java.lang.Throwable cause]
    (new AssertionError message cause))
  ([^java.lang.Object detail-message]
    (new AssertionError detail-message))
  ([]
    (new AssertionError )))

