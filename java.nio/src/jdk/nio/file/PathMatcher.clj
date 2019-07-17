(ns jdk.nio.file.PathMatcher
  "An interface that is implemented by objects that perform match operations on
  paths."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.file PathMatcher]))

(defn matches
  "Tells if given path matches this matcher's pattern.

  path - the path to match - `java.nio.file.Path`

  returns: true if, and only if, the path matches this
            matcher's pattern - `boolean`"
  ([^. this ^java.nio.file.Path path]
    (-> this (.matches path))))

