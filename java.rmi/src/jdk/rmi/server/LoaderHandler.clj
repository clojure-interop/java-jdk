(ns jdk.rmi.server.LoaderHandler
  "Deprecated.
 no replacement"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.rmi.server LoaderHandler]))

(defn load-class
  "Deprecated. no replacement

  codebase - the URL from which to load the class - `java.net.URL`
  name - the name of the class to load - `java.lang.String`

  returns: the Class object representing the loaded class - `java.lang..lang.Class<?>`

  throws: java.net.MalformedURLException - if the codebase paramater contains an invalid URL"
  ([^java.rmi.server.LoaderHandler this ^java.net.URL codebase ^java.lang.String name]
    (-> this (.loadClass codebase name)))
  ([^java.rmi.server.LoaderHandler this ^java.lang.String name]
    (-> this (.loadClass name))))

(defn get-security-context
  "Deprecated. no replacement

  loader - a class loader from which to get the security context - `java.lang.ClassLoader`

  returns: the security context - `java.lang..lang.Object`"
  ([^java.rmi.server.LoaderHandler this ^java.lang.ClassLoader loader]
    (-> this (.getSecurityContext loader))))

