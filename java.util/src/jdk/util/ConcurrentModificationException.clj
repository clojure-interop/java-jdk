(ns jdk.util.ConcurrentModificationException
  "This exception may be thrown by methods that have detected concurrent
  modification of an object when such modification is not permissible.

  For example, it is not generally permissible for one thread to modify a Collection
  while another thread is iterating over it.  In general, the results of the
  iteration are undefined under these circumstances.  Some Iterator
  implementations (including those of all the general purpose collection implementations
  provided by the JRE) may choose to throw this exception if this behavior is
  detected.  Iterators that do this are known as fail-fast iterators,
  as they fail quickly and cleanly, rather that risking arbitrary,
  non-deterministic behavior at an undetermined time in the future.

  Note that this exception does not always indicate that an object has
  been concurrently modified by a different thread.  If a single
  thread issues a sequence of method invocations that violates the
  contract of an object, the object may throw this exception.  For
  example, if a thread modifies a collection directly while it is
  iterating over the collection with a fail-fast iterator, the iterator
  will throw this exception.

  Note that fail-fast behavior cannot be guaranteed as it is, generally
  speaking, impossible to make any hard guarantees in the presence of
  unsynchronized concurrent modification.  Fail-fast operations
  throw ConcurrentModificationException on a best-effort basis.
  Therefore, it would be wrong to write a program that depended on this
  exception for its correctness: ConcurrentModificationException
  should be used only to detect bugs."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util ConcurrentModificationException]))

(defn ->concurrent-modification-exception
  "Constructor.

  Constructs a new exception with the specified detail message and
   cause.

   Note that the detail message associated with cause is
   not automatically incorporated in this exception's detail
   message.

  message - the detail message (which is saved for later retrieval by the Throwable.getMessage() method). - `java.lang.String`
  cause - the cause (which is saved for later retrieval by the Throwable.getCause() method). (A null value is permitted, and indicates that the cause is nonexistent or unknown.) - `java.lang.Throwable`"
  ([^java.lang.String message ^java.lang.Throwable cause]
    (new ConcurrentModificationException message cause))
  ([^java.lang.String message]
    (new ConcurrentModificationException message))
  ([]
    (new ConcurrentModificationException )))

