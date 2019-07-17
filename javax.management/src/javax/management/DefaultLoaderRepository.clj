(ns javax.management.DefaultLoaderRepository
  "Deprecated.
 Use
  MBeanServer.getClassLoaderRepository()
  instead."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management DefaultLoaderRepository]))

(defn ->default-loader-repository
  "Constructor.

  Deprecated."
  ([]
    (new DefaultLoaderRepository )))

(defn *load-class
  "Deprecated.

  class-name - The name of the class to be loaded. - `java.lang.String`

  returns: the loaded class. - `java.lang.Class<?>`

  throws: java.lang.ClassNotFoundException - The specified class could not be found."
  ([^java.lang.String class-name]
    (DefaultLoaderRepository/loadClass class-name)))

(defn *load-class-without
  "Deprecated.

  loader - The class loader to be excluded. - `java.lang.ClassLoader`
  class-name - The name of the class to be loaded. - `java.lang.String`

  returns: the loaded class. - `java.lang.Class<?>`

  throws: java.lang.ClassNotFoundException - The specified class could not be found."
  ([^java.lang.ClassLoader loader ^java.lang.String class-name]
    (DefaultLoaderRepository/loadClassWithout loader class-name)))

