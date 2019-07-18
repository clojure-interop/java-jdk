(ns jdk.lang.ClassCastException
  "Thrown to indicate that the code has attempted to cast an object
  to a subclass of which it is not an instance. For example, the
  following code generates a ClassCastException:


      Object x = new Integer(0);
      System.out.println((String)x);"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang ClassCastException]))

(defn ->class-cast-exception
  "Constructor.

  Constructs a ClassCastException with the specified
   detail message.

  s - the detail message. - `java.lang.String`"
  (^ClassCastException [^java.lang.String s]
    (new ClassCastException s))
  (^ClassCastException []
    (new ClassCastException )))

