(ns jdk.lang.VirtualMachineError
  "Thrown to indicate that the Java Virtual Machine is broken or has
  run out of resources necessary for it to continue operating."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang VirtualMachineError]))

(defn ->virtual-machine-error
  "Constructor.

  Constructs a VirtualMachineError with the specified
   detail message and cause.  Note that the detail message
   associated with cause is not automatically
   incorporated in this error's detail message.

  message - the detail message (which is saved for later retrieval by the Throwable.getMessage() method). - `java.lang.String`
  cause - the cause (which is saved for later retrieval by the Throwable.getCause() method). (A null value is permitted, and indicates that the cause is nonexistent or unknown.) - `java.lang.Throwable`"
  ([^java.lang.String message ^java.lang.Throwable cause]
    (new VirtualMachineError message cause))
  ([^java.lang.String message]
    (new VirtualMachineError message))
  ([]
    (new VirtualMachineError )))

