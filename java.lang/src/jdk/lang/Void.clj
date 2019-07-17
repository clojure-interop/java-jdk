(ns jdk.lang.Void
  "The Void class is an uninstantiable placeholder class to hold a
  reference to the Class object representing the Java keyword
  void."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang Void]))

(def *-type
  "Static Constant.

  The Class object representing the pseudo-type corresponding to
   the keyword void.

  type: java.lang.Class<java.lang.Void>"
  Void/TYPE)

