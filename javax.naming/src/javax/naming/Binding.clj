(ns javax.naming.Binding
  "This class represents a name-to-object binding found in a context.

  A context consists of name-to-object bindings.
  The Binding class represents such a binding.  It consists
  of a name and an object. The Context.listBindings()
  method returns an enumeration of Binding.

  Use subclassing for naming systems that generate contents of
  a binding dynamically.

  A Binding instance is not synchronized against concurrent access by multiple
  threads. Threads that need to access a Binding concurrently should
  synchronize amongst themselves and provide the necessary locking."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming Binding]))

(defn ->binding
  "Constructor.

  Constructs an instance of a Binding given its
   name, class name, object, and whether the name is relative.

  name - The non-null string name of the object. - `java.lang.String`
  class-name - The possibly null class name of the object bound to name. If null, the class name of obj is returned by getClassName(). If obj is also null, getClassName() will return null. - `java.lang.String`
  obj - The possibly null object bound to name. - `java.lang.Object`
  is-relative - true if name is a name relative to the target context (which is named by the first parameter of the listBindings() method); false if name is a URL string. - `boolean`"
  ([^java.lang.String name ^java.lang.String class-name ^java.lang.Object obj ^Boolean is-relative]
    (new Binding name class-name obj is-relative))
  ([^java.lang.String name ^java.lang.Object obj ^Boolean is-relative]
    (new Binding name obj is-relative))
  ([^java.lang.String name ^java.lang.Object obj]
    (new Binding name obj)))

(defn get-class-name
  "Retrieves the class name of the object bound to the name of this binding.
   If the class name has been set explicitly, return it.
   Otherwise, if this binding contains a non-null object,
   that object's class name is used. Otherwise, null is returned.

  returns: A possibly null string containing class name of object bound. - `java.lang.String`"
  ([^javax.naming.Binding this]
    (-> this (.getClassName))))

(defn get-object
  "Retrieves the object bound to the name of this binding.

  returns: The object bound; null if this binding does not contain an object. - `java.lang.Object`"
  ([^javax.naming.Binding this]
    (-> this (.getObject))))

(defn set-object
  "Sets the object associated with this binding.

  obj - The possibly null object to use. - `java.lang.Object`"
  ([^javax.naming.Binding this ^java.lang.Object obj]
    (-> this (.setObject obj))))

(defn to-string
  "Generates the string representation of this binding.
   The string representation consists of the string representation
   of the name/class pair and the string representation of
   this binding's object, separated by ':'.
   The contents of this string is useful
   for debugging and is not meant to be interpreted programmatically.

  returns: The non-null string representation of this binding. - `java.lang.String`"
  ([^javax.naming.Binding this]
    (-> this (.toString))))

