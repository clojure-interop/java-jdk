(ns jdk.beans.DefaultPersistenceDelegate
  "The DefaultPersistenceDelegate is a concrete implementation of
  the abstract PersistenceDelegate class and
  is the delegate used by default for classes about
  which no information is available. The DefaultPersistenceDelegate
  provides, version resilient, public API-based persistence for
  classes that follow the JavaBeans™ conventions without any class specific
  configuration.

  The key assumptions are that the class has a nullary constructor
  and that its state is accurately represented by matching pairs
  of `setter` and `getter` methods in the order they are returned
  by the Introspector.
  In addition to providing code-free persistence for JavaBeans,
  the DefaultPersistenceDelegate provides a convenient means
  to effect persistent storage for classes that have a constructor
  that, while not nullary, simply requires some property values
  as arguments."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.beans DefaultPersistenceDelegate]))

(defn ->default-persistence-delegate
  "Constructor.

  Creates a default persistence delegate for a class with a
   constructor whose arguments are the values of the property
   names as specified by constructorPropertyNames.
   The constructor arguments are created by
   evaluating the property names in the order they are supplied.
   To use this class to specify a single preferred constructor for use
   in the serialization of a particular type, we state the
   names of the properties that make up the constructor's
   arguments. For example, the Font class which
   does not define a nullary constructor can be handled
   with the following persistence delegate:



       new DefaultPersistenceDelegate(new String[]{`name`, `style`, `size`});

  constructor-property-names - The property names for the arguments of this constructor. - `java.lang.String[]`"
  ([^java.lang.String[] constructor-property-names]
    (new DefaultPersistenceDelegate constructor-property-names))
  ([]
    (new DefaultPersistenceDelegate )))

