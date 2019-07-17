(ns javax.lang.model.element.UnknownElementException
  "Indicates that an unknown kind of element was encountered.  This
  can occur if the language evolves and new kinds of elements are
  added to the Element hierarchy.  May be thrown by an
  javax.lang.model.element.element visitor to indicate that the
  visitor was created for a prior version of the language."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.lang.model.element UnknownElementException]))

(defn ->unknown-element-exception
  "Constructor.

  Creates a new UnknownElementException.  The p
   parameter may be used to pass in an additional argument with
   information about the context in which the unknown element was
   encountered; for example, the visit methods of ElementVisitor may pass in their additional parameter.

  e - the unknown element, may be null - `javax.lang.model.element.Element`
  p - an additional parameter, may be null - `java.lang.Object`"
  ([^javax.lang.model.element.Element e ^java.lang.Object p]
    (new UnknownElementException e p)))

(defn get-unknown-element
  "Returns the unknown element.
   The value may be unavailable if this exception has been
   serialized and then read back in.

  returns: the unknown element, or null if unavailable - `javax.lang.model.element.Element`"
  ([^javax.lang.model.element.UnknownElementException this]
    (-> this (.getUnknownElement))))

(defn get-argument
  "Returns the additional argument.

  returns: the additional argument - `java.lang.Object`"
  ([^javax.lang.model.element.UnknownElementException this]
    (-> this (.getArgument))))

