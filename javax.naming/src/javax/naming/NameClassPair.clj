(ns javax.naming.NameClassPair
  "This class represents the object name and class name pair of a binding
  found in a context.

  A context consists of name-to-object bindings.
  The NameClassPair class represents the name and the
  class of the bound object. It consists
  of a name and a string representing the
  package-qualified class name.

  Use subclassing for naming systems that generate contents of
  a name/class pair dynamically.

  A NameClassPair instance is not synchronized against concurrent
  access by multiple threads. Threads that need to access a NameClassPair
  concurrently should synchronize amongst themselves and provide
  the necessary locking."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming NameClassPair]))

(defn ->name-class-pair
  "Constructor.

  Constructs an instance of a NameClassPair given its
   name, class name, and whether it is relative to the listing context.

  name - The non-null name of the object. - `java.lang.String`
  class-name - The possibly null class name of the object bound to name. It is null if the object bound is null. - `java.lang.String`
  is-relative - true if name is a name relative to the target context (which is named by the first parameter of the list() method); false if name is a URL string. - `boolean`"
  ([name class-name is-relative]
    (new NameClassPair name class-name is-relative))
  ([name class-name]
    (new NameClassPair name class-name)))

(defn get-class-name
  "Retrieves the class name of the object bound to the name of this binding.
   If a reference or some other indirect information is bound,
   retrieves the class name of the eventual object that
   will be returned by Binding.getObject().

  returns: The possibly null class name of object bound.
            It is null if the object bound is null. - `java.lang.String`"
  ([this]
    (-> this (.getClassName))))

(defn set-name
  "Sets the name of this binding.

  name - the non-null string to use as the name. - `java.lang.String`"
  ([this name]
    (-> this (.setName name))))

(defn to-string
  "Generates the string representation of this name/class pair.
   The string representation consists of the name and class name separated
   by a colon (':').
   The contents of this string is useful
   for debugging and is not meant to be interpreted programmatically.

  returns: The string representation of this name/class pair. - `java.lang.String`"
  ([this]
    (-> this (.toString))))

(defn set-name-in-namespace
  "Sets the full name of this binding.
   This method must be called to set the full name whenever a
   NameClassPair is created and a full name is
   applicable to this binding.

   Setting the full name to null, or not setting it at all, will
   cause getNameInNamespace() to throw an exception.

  full-name - The full name to use. - `java.lang.String`"
  ([this full-name]
    (-> this (.setNameInNamespace full-name))))

(defn get-name
  "Retrieves the name of this binding.
   If isRelative() is true, this name is relative to the
   target context (which is named by the first parameter of the
   list()).
   If isRelative() is false, this name is a URL string.

  returns: The non-null name of this binding. - `java.lang.String`"
  ([this]
    (-> this (.getName))))

(defn set-class-name
  "Sets the class name of this binding.

  name - the possibly null string to use as the class name. If null, Binding.getClassName() will return the actual class name of the object in the binding. The class name will be null if the object bound is null. - `java.lang.String`"
  ([this name]
    (-> this (.setClassName name))))

(defn set-relative
  "Sets whether the name of this binding is relative to the target
   context (which is named by the first parameter of the list()
   method).

  r - If true, the name of binding is relative to the target context; if false, the name of binding is a URL string. - `boolean`"
  ([this r]
    (-> this (.setRelative r))))

(defn relative?
  "Determines whether the name of this binding is
   relative to the target context (which is named by
   the first parameter of the list() method).

  returns: true if the name of this binding is relative to the
            target context;
            false if the name of this binding is a URL string. - `boolean`"
  ([this]
    (-> this (.isRelative))))

(defn get-name-in-namespace
  "Retrieves the full name of this binding.
   The full name is the absolute name of this binding within
   its own namespace. See Context.getNameInNamespace().


   In naming systems for which the notion of full name does not
   apply to this binding an UnsupportedOperationException
   is thrown.
   This exception is also thrown when a service provider written before
   the introduction of the method is in use.

   The string returned by this method is not a JNDI composite name and
   should not be passed directly to context methods.

  returns: The full name of this binding. - `java.lang.String`

  throws: java.lang.UnsupportedOperationException - if the notion of full name does not apply to this binding in the naming system."
  ([this]
    (-> this (.getNameInNamespace))))

