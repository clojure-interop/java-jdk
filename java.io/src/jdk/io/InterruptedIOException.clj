(ns jdk.io.InterruptedIOException
  "Signals that an I/O operation has been interrupted. An
  InterruptedIOException is thrown to indicate that an
  input or output transfer has been terminated because the thread
  performing it was interrupted. The field bytesTransferred
  indicates how many bytes were successfully transferred before
  the interruption occurred."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.io InterruptedIOException]))

(defn ->interrupted-io-exception
  "Constructor.

  Constructs an InterruptedIOException with the
   specified detail message. The string s can be
   retrieved later by the
   Throwable.getMessage()
   method of class java.lang.Throwable.

  s - the detail message. - `java.lang.String`"
  ([s]
    (new InterruptedIOException s))
  ([]
    (new InterruptedIOException )))

(defn -bytes-transferred
  "Instance Field.

  Reports how many bytes had been transferred as part of the I/O
   operation before it was interrupted.

  type: int"
  [this]
  (-> this .-bytesTransferred))

