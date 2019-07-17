(ns javax.xml.soap.SOAPElement
  "An object representing an element of a SOAP message that is allowed but not
  specifically prescribed by a SOAP specification. This interface serves as the
  base interface for those objects that are specifically prescribed by a SOAP
  specification.

  Methods in this interface that are required to return SAAJ specific objects
  may `silently` replace nodes in the tree as required to successfully return
  objects of the correct type. See getChildElements() and
  javax.xml.soap
  for details."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.soap SOAPElement]))

(defn get-namespace-uri
  "Returns the URI of the namespace that has the given prefix.

  prefix - a String giving the prefix of the namespace for which to search - `java.lang.String`

  returns: a String with the uri of the namespace that has
          the given prefix - `java.lang.String`"
  ([^. this ^java.lang.String prefix]
    (-> this (.getNamespaceURI prefix))))

(defn get-element-name
  "Returns the name of this SOAPElement object.

  returns: a Name object with the name of this
           SOAPElement object - `javax.xml.soap.Name`"
  ([^. this]
    (-> this (.getElementName))))

(defn add-text-node
  "Creates a new Text object initialized with the given
   String and adds it to this SOAPElement object.

  text - a String object with the textual content to be added - `java.lang.String`

  returns: the SOAPElement object into which
           the new Text object was inserted - `javax.xml.soap.SOAPElement`

  throws: javax.xml.soap.SOAPException - if there is an error in creating the new Text object or if it is not legal to attach it as a child to this SOAPElement"
  ([^. this ^java.lang.String text]
    (-> this (.addTextNode text))))

(defn remove-contents
  "Detaches all children of this SOAPElement.

   This method is useful for rolling back the construction of partially
   completed SOAPHeaders and SOAPBodys in
   preparation for sending a fault when an error condition is detected. It
   is also useful for recycling portions of a document within a SOAP
   message."
  ([^. this]
    (-> this (.removeContents))))

(defn add-child-element
  "Creates a new SOAPElement object initialized with the
   specified local name, prefix, and URI and adds the new element to this
   SOAPElement object.

  local-name - a String giving the local name for the new element - `java.lang.String`
  prefix - a String giving the namespace prefix for the new element - `java.lang.String`
  uri - a String giving the URI of the namespace to which the new element belongs - `java.lang.String`

  returns: the new SOAPElement object that was created - `javax.xml.soap.SOAPElement`

  throws: javax.xml.soap.SOAPException - if there is an error in creating the SOAPElement object"
  ([^. this ^java.lang.String local-name ^java.lang.String prefix ^java.lang.String uri]
    (-> this (.addChildElement local-name prefix uri)))
  ([^. this ^java.lang.String local-name ^java.lang.String prefix]
    (-> this (.addChildElement local-name prefix)))
  ([^. this ^javax.xml.soap.Name name]
    (-> this (.addChildElement name))))

(defn get-all-attributes-as-q-names
  "Returns an Iterator over all of the attributes
   in this SOAPElement  as QName objects.
   The iterator can be used to get the attribute QName, which can then
   be passed to the method getAttributeValue to retrieve
   the value of each attribute.

  returns: an iterator over the QNames of the attributes - `java.util.Iterator`"
  ([^. this]
    (-> this (.getAllAttributesAsQNames))))

(defn get-namespace-prefixes
  "Returns an Iterator over the namespace prefix
   Strings declared by this element. The prefixes returned by
   this iterator can be passed to the method
   getNamespaceURI to retrieve the URI of each namespace.

  returns: an iterator over the namespace prefixes in this
           SOAPElement object - `java.util.Iterator`"
  ([^. this]
    (-> this (.getNamespacePrefixes))))

(defn set-encoding-style
  "Sets the encoding style for this SOAPElement object
   to one specified.

  encoding-style - a String giving the encoding style - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if there was a problem in the encoding style being set."
  ([^. this ^java.lang.String encoding-style]
    (-> this (.setEncodingStyle encoding-style))))

(defn remove-namespace-declaration
  "Removes the namespace declaration corresponding to the given prefix.

  prefix - a String giving the prefix for which to search - `java.lang.String`

  returns: true if the namespace declaration was
           removed successfully; false if it was not - `boolean`"
  ([^. this ^java.lang.String prefix]
    (-> this (.removeNamespaceDeclaration prefix))))

(defn remove-attribute
  "Removes the attribute with the specified name.

  name - the Name object with the name of the attribute to be removed - `javax.xml.soap.Name`

  returns: true if the attribute was
           removed successfully; false if it was not - `boolean`"
  ([^. this ^javax.xml.soap.Name name]
    (-> this (.removeAttribute name))))

(defn get-encoding-style
  "Returns the encoding style for this SOAPElement object.

  returns: a String giving the encoding style - `java.lang.String`"
  ([^. this]
    (-> this (.getEncodingStyle))))

(defn get-child-elements
  "Returns an Iterator over all the immediate child
   Nodes of this element with the specified name. All of these
   children will be SOAPElement nodes.

   Calling this method may cause child Element,
   SOAPElement and org.w3c.dom.Text nodes to be
   replaced by SOAPElement, SOAPHeaderElement,
   SOAPBodyElement or javax.xml.soap.Text nodes as
   appropriate for the type of this parent node. As a result the calling
   application must treat any existing references to these child nodes that
   have been obtained through DOM APIs as invalid and either discard them or
   refresh them with the values returned by this Iterator. This
   behavior can be avoided by calling the equivalent DOM APIs. See
   javax.xml.soap
   for more details.

  name - `javax.xml.soap.Name`

  returns: `java.util.Iterator`"
  ([^. this ^javax.xml.soap.Name name]
    (-> this (.getChildElements name)))
  ([^. this]
    (-> this (.getChildElements))))

(defn get-attribute-value
  "Returns the value of the attribute with the specified name.

  name - a Name object with the name of the attribute - `javax.xml.soap.Name`

  returns: a String giving the value of the specified
           attribute, Null if there is no such attribute - `java.lang.String`"
  ([^. this ^javax.xml.soap.Name name]
    (-> this (.getAttributeValue name))))

(defn add-namespace-declaration
  "Adds a namespace declaration with the specified prefix and URI to this
   SOAPElement object.

  prefix - a String giving the prefix of the namespace - `java.lang.String`
  uri - a String giving the uri of the namespace - `java.lang.String`

  returns: the SOAPElement object into which this
            namespace declaration was inserted. - `javax.xml.soap.SOAPElement`

  throws: javax.xml.soap.SOAPException - if there is an error in creating the namespace"
  ([^. this ^java.lang.String prefix ^java.lang.String uri]
    (-> this (.addNamespaceDeclaration prefix uri))))

(defn create-q-name
  "Creates a QName whose namespace URI is the one associated
   with the parameter, prefix, in the context of this
   SOAPElement. The remaining elements of the new
   QName are taken directly from the parameters,
   localName and prefix.

  local-name - a String containing the local part of the name. - `java.lang.String`
  prefix - a String containing the prefix for the name. - `java.lang.String`

  returns: a QName with the specified localName
            and prefix, and with a namespace that is associated
            with the prefix in the context of this
            SOAPElement. This namespace will be the same as
            the one that would be returned by
            getNamespaceURI(String) if it were given
            prefix as it's parameter. - `javax.xml.namespace.QName`

  throws: javax.xml.soap.SOAPException - if the QName cannot be created."
  ([^. this ^java.lang.String local-name ^java.lang.String prefix]
    (-> this (.createQName local-name prefix))))

(defn get-all-attributes
  "Returns an Iterator over all of the attribute
   Name objects in this
   SOAPElement object. The iterator can be used to get
   the attribute names, which can then be passed to the method
   getAttributeValue to retrieve the value of each
   attribute.

  returns: an iterator over the names of the attributes - `java.util.Iterator`"
  ([^. this]
    (-> this (.getAllAttributes))))

(defn get-visible-namespace-prefixes
  "Returns an Iterator over the namespace prefix
   Strings visible to this element. The prefixes returned by
   this iterator can be passed to the method
   getNamespaceURI to retrieve the URI of each namespace.

  returns: an iterator over the namespace prefixes are within scope of this
           SOAPElement object - `java.util.Iterator`"
  ([^. this]
    (-> this (.getVisibleNamespacePrefixes))))

(defn get-element-q-name
  "Returns the qname of this SOAPElement object.

  returns: a QName object with the qname of this
           SOAPElement object - `javax.xml.namespace.QName`"
  ([^. this]
    (-> this (.getElementQName))))

(defn add-attribute
  "Adds an attribute with the specified name and value to this
   SOAPElement object.

  name - a Name object with the name of the attribute - `javax.xml.soap.Name`
  value - a String giving the value of the attribute - `java.lang.String`

  returns: the SOAPElement object into which the attribute was
           inserted - `javax.xml.soap.SOAPElement`

  throws: javax.xml.soap.SOAPException - if there is an error in creating the Attribute, or it is invalid to set an attribute with Name name on this SOAPElement."
  ([^. this ^javax.xml.soap.Name name ^java.lang.String value]
    (-> this (.addAttribute name value))))

(defn set-element-q-name
  "Changes the name of this Element to newName if
   possible. SOAP Defined elements such as SOAPEnvelope, SOAPHeader, SOAPBody
   etc. cannot have their names changed using this method. Any attempt to do
   so will result in a  SOAPException being thrown.

   Callers should not rely on the element instance being renamed as is.
   Implementations could end up copying the content of the
   SOAPElement to a renamed instance.

  new-name - the new name for the Element. - `javax.xml.namespace.QName`

  returns: The renamed Node - `javax.xml.soap.SOAPElement`

  throws: javax.xml.soap.SOAPException - if changing the name of this Element is not allowed."
  ([^. this ^javax.xml.namespace.QName new-name]
    (-> this (.setElementQName new-name))))

