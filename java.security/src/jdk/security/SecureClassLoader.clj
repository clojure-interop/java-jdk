(ns jdk.security.SecureClassLoader
  "This class extends ClassLoader with additional support for defining
  classes with an associated code source and permissions which are
  retrieved by the system policy by default."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security SecureClassLoader]))

