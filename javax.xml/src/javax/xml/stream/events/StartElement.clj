(ns javax.xml.stream.events.StartElement
  "The StartElement interface provides access to information about
  start elements.  A StartElement is reported for each Start Tag
  in the document."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.stream.events StartElement]))

(defn get-name
  "Get the name of this event

  returns: the qualified name of this event - `javax.xml.namespace.QName`"
  (^javax.xml.namespace.QName [^javax.xml.stream.events.StartElement this]
    (-> this (.getName))))

(defn get-attributes
  "Returns an Iterator of non-namespace declared attributes declared on
   this START_ELEMENT,
   returns an empty iterator if there are no attributes.  The
   iterator must contain only implementations of the javax.xml.stream.Attribute
   interface.   Attributes are fundamentally unordered and may not be reported
   in any order.

  returns: a readonly Iterator over Attribute interfaces, or an
   empty iterator - `java.util.Iterator`"
  (^java.util.Iterator [^javax.xml.stream.events.StartElement this]
    (-> this (.getAttributes))))

(defn get-namespaces
  "Returns an Iterator of namespaces declared on this element.
   This Iterator does not contain previously declared namespaces
   unless they appear on the current START_ELEMENT.
   Therefore this list may contain redeclared namespaces and duplicate namespace
   declarations. Use the getNamespaceContext() method to get the
   current context of namespace declarations.

   The iterator must contain only implementations of the
   javax.xml.stream.Namespace interface.

   A Namespace isA Attribute.  One
   can iterate over a list of namespaces as a list of attributes.
   However this method returns only the list of namespaces
   declared on this START_ELEMENT and does not
   include the attributes declared on this START_ELEMENT.

   Returns an empty iterator if there are no namespaces.

  returns: a readonly Iterator over Namespace interfaces, or an
   empty iterator - `java.util.Iterator`"
  (^java.util.Iterator [^javax.xml.stream.events.StartElement this]
    (-> this (.getNamespaces))))

(defn get-attribute-by-name
  "Returns the attribute referred to by this name

  name - the qname of the desired name - `javax.xml.namespace.QName`

  returns: the attribute corresponding to the name value or null - `javax.xml.stream.events.Attribute`"
  (^javax.xml.stream.events.Attribute [^javax.xml.stream.events.StartElement this ^javax.xml.namespace.QName name]
    (-> this (.getAttributeByName name))))

(defn get-namespace-context
  "Gets a read-only namespace context. If no context is
   available this method will return an empty namespace context.
   The NamespaceContext contains information about all namespaces
   in scope for this StartElement.

  returns: the current namespace context - `javax.xml.namespace.NamespaceContext`"
  (^javax.xml.namespace.NamespaceContext [^javax.xml.stream.events.StartElement this]
    (-> this (.getNamespaceContext))))

(defn get-namespace-uri
  "Gets the value that the prefix is bound to in the
   context of this element.  Returns null if
   the prefix is not bound in this context

  prefix - the prefix to lookup - `java.lang.String`

  returns: the uri bound to the prefix or null - `java.lang.String`"
  (^java.lang.String [^javax.xml.stream.events.StartElement this ^java.lang.String prefix]
    (-> this (.getNamespaceURI prefix))))

