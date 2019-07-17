(ns jdk.rmi.activation.ActivationException
  "General exception used by the activation interfaces.

  As of release 1.4, this exception has been retrofitted to conform to
  the general purpose exception-chaining mechanism.  The `detail exception`
  that may be provided at construction time and accessed via the public
  detail field is now known as the cause, and may be
  accessed via the Throwable.getCause() method, as well as
  the aforementioned `legacy field.`

  Invoking the method Throwable.initCause(Throwable) on an
  instance of ActivationException always throws IllegalStateException."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.rmi.activation ActivationException]))

(defn ->activation-exception
  "Constructor.

  Constructs an ActivationException with the specified
   detail message and cause.  This constructor sets the detail
   field to the specified Throwable.

  s - the detail message - `java.lang.String`
  cause - the cause - `java.lang.Throwable`"
  ([^java.lang.String s ^java.lang.Throwable cause]
    (new ActivationException s cause))
  ([^java.lang.String s]
    (new ActivationException s))
  ([]
    (new ActivationException )))

(defn -detail
  "Instance Field.

  The cause of the activation exception.

   This field predates the general-purpose exception chaining facility.
   The Throwable.getCause() method is now the preferred means of
   obtaining this information.

  type: java.lang.Throwable"
  [this]
  (-> this .-detail))

(defn get-message
  "Returns the detail message, including the message from the cause, if
   any, of this exception.

  returns: the detail message - `java.lang.String`"
  ([^java.rmi.activation.ActivationException this]
    (-> this (.getMessage))))

(defn get-cause
  "Returns the cause of this exception.  This method returns the value
   of the detail field.

  returns: the cause, which may be null. - `java.lang.Throwable`"
  ([^java.rmi.activation.ActivationException this]
    (-> this (.getCause))))

