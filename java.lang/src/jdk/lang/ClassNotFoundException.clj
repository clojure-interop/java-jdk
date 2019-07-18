(ns jdk.lang.ClassNotFoundException
  "Thrown when an application tries to load in a class through its
  string name using:

  The forName method in class Class.
  The findSystemClass method in class
      ClassLoader .
  The loadClass method in class ClassLoader.


  but no definition for the class with the specified name could be found.

  As of release 1.4, this exception has been retrofitted to conform to
  the general purpose exception-chaining mechanism.  The `optional exception
  that was raised while loading the class` that may be provided at
  construction time and accessed via the getException() method is
  now known as the cause, and may be accessed via the Throwable.getCause() method, as well as the aforementioned `legacy method.`"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang ClassNotFoundException]))

(defn ->class-not-found-exception
  "Constructor.

  Constructs a ClassNotFoundException with the
   specified detail message and optional exception that was
   raised while loading the class.

  s - the detail message - `java.lang.String`
  ex - the exception that was raised while loading the class - `java.lang.Throwable`"
  (^ClassNotFoundException [^java.lang.String s ^java.lang.Throwable ex]
    (new ClassNotFoundException s ex))
  (^ClassNotFoundException [^java.lang.String s]
    (new ClassNotFoundException s))
  (^ClassNotFoundException []
    (new ClassNotFoundException )))

(defn get-exception
  "Returns the exception that was raised if an error occurred while
   attempting to load the class. Otherwise, returns null.

   This method predates the general-purpose exception chaining facility.
   The Throwable.getCause() method is now the preferred means of
   obtaining this information.

  returns: the Exception that was raised while loading a class - `java.lang.Throwable`"
  (^java.lang.Throwable [^ClassNotFoundException this]
    (-> this (.getException))))

(defn get-cause
  "Returns the cause of this exception (the exception that was raised
   if an error occurred while attempting to load the class; otherwise
   null).

  returns: the cause of this exception. - `java.lang.Throwable`"
  (^java.lang.Throwable [^ClassNotFoundException this]
    (-> this (.getCause))))

