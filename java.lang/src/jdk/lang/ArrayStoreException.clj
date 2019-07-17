(ns jdk.lang.ArrayStoreException
  "Thrown to indicate that an attempt has been made to store the
  wrong type of object into an array of objects. For example, the
  following code generates an ArrayStoreException:


      Object x[] = new String[3];
      x[0] = new Integer(0);"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang ArrayStoreException]))

(defn ->array-store-exception
  "Constructor.

  Constructs an ArrayStoreException with the specified
   detail message.

  s - the detail message. - `java.lang.String`"
  ([s]
    (new ArrayStoreException s))
  ([]
    (new ArrayStoreException )))

