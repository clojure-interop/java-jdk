(ns javax.naming.directory.SearchResult
  "This class represents an item in the NamingEnumeration returned as a
  result of the DirContext.search() methods.

  A SearchResult instance is not synchronized against concurrent
  multithreaded access. Multiple threads trying to access and modify
  a single SearchResult instance should lock the object."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming.directory SearchResult]))

(defn ->search-result
  "Constructor.

  Constructs a search result using the result's name, its class name,
   its bound object, its attributes, and whether the name is relative.

  name - The non-null name of the search item. - `java.lang.String`
  class-name - The possibly null class name of the object bound to name. If null, the class name of obj is returned by getClassName(). If obj is also null, getClassName() will return null. - `java.lang.String`
  obj - The object bound to name. Can be null. - `java.lang.Object`
  attrs - The attributes that were requested to be returned with this search item. Cannot be null. - `javax.naming.directory.Attributes`
  is-relative - true if name is relative to the target context of the search (which is named by the first parameter of the search() method); false if name is a URL string. - `boolean`"
  ([name class-name obj attrs is-relative]
    (new SearchResult name class-name obj attrs is-relative))
  ([name obj attrs is-relative]
    (new SearchResult name obj attrs is-relative))
  ([name obj attrs]
    (new SearchResult name obj attrs)))

(defn get-attributes
  "Retrieves the attributes in this search result.

  returns: The non-null attributes in this search result. Can be empty. - `javax.naming.directory.Attributes`"
  ([this]
    (-> this (.getAttributes))))

(defn set-attributes
  "Sets the attributes of this search result to attrs.

  attrs - The non-null attributes to use. Can be empty. - `javax.naming.directory.Attributes`"
  ([this attrs]
    (-> this (.setAttributes attrs))))

(defn to-string
  "Generates the string representation of this SearchResult.
   The string representation consists of the string representation
   of the binding and the string representation of
   this search result's attributes, separated by ':'.
   The contents of this string is useful
   for debugging and is not meant to be interpreted programmatically.

  returns: The string representation of this SearchResult. Cannot be null. - `java.lang.String`"
  ([this]
    (-> this (.toString))))

