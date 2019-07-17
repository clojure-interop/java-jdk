(ns javax.xml.bind.Binder
  "Enable synchronization between XML infoset nodes and JAXB objects
  representing same XML document.


  An instance of this class maintains the association between XML nodes of
  an infoset preserving view and a JAXB representation of an XML document.
  Navigation between the two views is provided by the methods
  getXMLNode(Object) and getJAXBNode(Object).


  Modifications can be made to either the infoset preserving view or the
  JAXB representation of the document while the other view remains
  unmodified. The binder is able to synchronize the changes made in the
  modified view back into the other view using the appropriate
  Binder update methods, updateXML(Object, Object) or
  updateJAXB(Object).


  A typical usage scenario is the following:

    load XML document into an XML infoset representation
    unmarshal(Object) XML infoset view to JAXB view.
        (Note to conserve resources, it is possible to only unmarshal a
        subtree of the XML infoset view to the JAXB view.)
    application access/updates JAXB view of XML document.
    updateXML(Object) synchronizes modifications to JAXB view
        back into the XML infoset view. Update operation preserves as
        much of original XML infoset as possible (i.e. comments, PI, ...)



  A Binder instance is created using the factory method
  JAXBContext.createBinder() or JAXBContext.createBinder(Class).


  The template parameter, XmlNode, is the
  root interface/class for the XML infoset preserving representation.
  A Binder implementation is required to minimally support
  an XmlNode value of org.w3c.dom.Node.class.
  A Binder implementation can support alternative XML infoset
  preserving representations."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.bind Binder]))

(defn ->binder
  "Constructor."
  ([]
    (new Binder )))

(defn update-xml
  "Changes in JAXB object tree are updated in its associated XML parse tree.


   This operation can be thought of as an `in-place` marshalling.
   The difference is that instead of creating a whole new XML tree,
   this operation updates an existing tree while trying to preserve
   the XML as much as possible.


   For example, unknown elements/attributes in XML that were not bound
   to JAXB will be left untouched (whereas a marshalling operation
   would create a new tree that doesn't contain any of those.)


   As a side-effect, this operation updates the association between
   XML nodes and JAXB objects.

  jaxb-object - root of potentially modified JAXB object tree - `java.lang.Object`
  xml-node - root of update target XML parse tree - `Binder.XmlNode`

  returns: Returns the updated XML node. Typically, this is the same
        node you passed in as xmlNode, but it maybe
        a different object, for example when the tag name of the object
        has changed. - `Binder.XmlNode`

  throws: javax.xml.bind.JAXBException - If any unexpected problem occurs updating corresponding XML content."
  ([^javax.xml.bind.Binder this ^java.lang.Object jaxb-object ^Binder.XmlNode xml-node]
    (-> this (.updateXML jaxb-object xml-node)))
  ([^javax.xml.bind.Binder this ^java.lang.Object jaxb-object]
    (-> this (.updateXML jaxb-object))))

(defn marshal
  "Marshal a JAXB object tree to a new XML document.


   This method is similar to Marshaller.marshal(Object, Node)
   with the addition of maintaining the association between JAXB objects
   and the produced XML nodes,
   enabling future update operations such as
   updateXML(Object, Object) or updateJAXB(Object).


   When getSchema() is non-null, the marshalled
   xml content is validated during this operation.

  jaxb-object - The content tree to be marshalled. - `java.lang.Object`
  xml-node - The parameter must be a Node that accepts children. - `Binder.XmlNode`

  throws: javax.xml.bind.JAXBException - If any unexpected problem occurs during the marshalling."
  ([^javax.xml.bind.Binder this ^java.lang.Object jaxb-object ^Binder.XmlNode xml-node]
    (-> this (.marshal jaxb-object xml-node))))

(defn set-event-handler
  "Allow an application to register a ValidationEventHandler.

   The ValidationEventHandler will be called by the JAXB Provider
   if any validation errors are encountered during calls to any of the
   Binder unmarshal, marshal and update methods.


   Calling this method with a null parameter will cause the Binder
   to revert back to the default default event handler.

  handler - the validation event handler - `javax.xml.bind.ValidationEventHandler`

  throws: javax.xml.bind.JAXBException - if an error was encountered while setting the event handler"
  ([^javax.xml.bind.Binder this ^javax.xml.bind.ValidationEventHandler handler]
    (-> this (.setEventHandler handler))))

(defn get-event-handler
  "Return the current event handler or the default event handler if one
   hasn't been set.

  returns: the current ValidationEventHandler or the default event handler
           if it hasn't been set - `javax.xml.bind.ValidationEventHandler`

  throws: javax.xml.bind.JAXBException - if an error was encountered while getting the current event handler"
  ([^javax.xml.bind.Binder this]
    (-> this (.getEventHandler))))

(defn update-jaxb
  "Takes an XML node and updates its associated JAXB object and its descendants.


   This operation can be thought of as an `in-place` unmarshalling.
   The difference is that instead of creating a whole new JAXB tree,
   this operation updates an existing tree, reusing as much JAXB objects
   as possible.


   As a side-effect, this operation updates the association between
   XML nodes and JAXB objects.

  xml-node - `Binder.XmlNode`

  returns: Returns the updated JAXB object. Typically, this is the same
        object that was returned from earlier
        marshal(Object,Object) or
        updateJAXB(Object) method invocation,
        but it maybe
        a different object, for example when the name of the XML
        element has changed. - `java.lang.Object`

  throws: javax.xml.bind.JAXBException - If any unexpected problem occurs updating corresponding JAXB mapped content."
  ([^javax.xml.bind.Binder this ^Binder.XmlNode xml-node]
    (-> this (.updateJAXB xml-node))))

(defn get-xml-node
  "Gets the XML element associated with the given JAXB object.


   Once a JAXB object tree is associated with an XML fragment,
   this method enables navigation between the two trees.


   An association between an XML element and a JAXB object is
   established by the bind methods and the update methods.
   Note that this association is partial; not all XML elements
   have associated JAXB objects, and not all JAXB objects have
   associated XML elements.

  jaxb-object - An instance that is reachable from a prior call to a bind or update method that returned a JAXB object tree. - `java.lang.Object`

  returns: null if the specified JAXB object is not known to this
        Binder, or if it is not associated with an
        XML element. - `Binder.XmlNode`

  throws: java.lang.IllegalArgumentException - If the jaxbObject parameter is null"
  ([^javax.xml.bind.Binder this ^java.lang.Object jaxb-object]
    (-> this (.getXMLNode jaxb-object))))

(defn set-schema
  "Specifies whether marshal, unmarshal and update methods
   performs validation on their XML content.

  schema - set to null to disable validation. - `javax.xml.validation.Schema`"
  ([^javax.xml.bind.Binder this ^javax.xml.validation.Schema schema]
    (-> this (.setSchema schema))))

(defn get-property
  "Get the particular property in the underlying implementation of
   Binder.  This method can only
   be used to get one of
   the standard JAXB defined unmarshal/marshal properties
   or a provider specific property for binder, unmarshal or marshal.
   Attempting to get an undefined property will result in
   a PropertyException being thrown.  See
   Supported Unmarshal Properties
   and
   Supported Marshal Properties.

  name - the name of the property to retrieve - `java.lang.String`

  returns: the value of the requested property - `java.lang.Object`

  throws: javax.xml.bind.PropertyException - when there is an error retrieving the given property or value property name"
  ([^javax.xml.bind.Binder this ^java.lang.String name]
    (-> this (.getProperty name))))

(defn get-jaxb-node
  "Gets the JAXB object associated with the given XML element.


   Once a JAXB object tree is associated with an XML fragment,
   this method enables navigation between the two trees.


   An association between an XML element and a JAXB object is
   established by the unmarshal, marshal and update methods.
   Note that this association is partial; not all XML elements
   have associated JAXB objects, and not all JAXB objects have
   associated XML elements.

  xml-node - `Binder.XmlNode`

  returns: null if the specified XML node is not known to this
        Binder, or if it is not associated with a
        JAXB object. - `java.lang.Object`

  throws: java.lang.IllegalArgumentException - If the node parameter is null"
  ([^javax.xml.bind.Binder this ^Binder.XmlNode xml-node]
    (-> this (.getJAXBNode xml-node))))

(defn get-schema
  "Gets the last Schema object (including null) set by the
   setSchema(Schema) method.

  returns: the Schema object for validation or null if not present - `javax.xml.validation.Schema`"
  ([^javax.xml.bind.Binder this]
    (-> this (.getSchema))))

(defn set-property
  "Set the particular property in the underlying implementation of
   Binder.  This method can only be used to set one of
   the standard JAXB defined unmarshal/marshal properties
   or a provider specific property for binder, unmarshal or marshal.
   Attempting to set an undefined property will result in
   a PropertyException being thrown.  See
   Supported Unmarshal Properties
   and
   Supported Marshal Properties.

  name - the name of the property to be set. This value can either be specified using one of the constant fields or a user supplied string. - `java.lang.String`
  value - the value of the property to be set - `java.lang.Object`

  throws: javax.xml.bind.PropertyException - when there is an error processing the given property or value"
  ([^javax.xml.bind.Binder this ^java.lang.String name ^java.lang.Object value]
    (-> this (.setProperty name value))))

(defn unmarshal
  "Unmarshal XML root element by provided declaredType
   to a JAXB object tree.


   Implements Unmarshal by Declared Type


   This method is similar to Unmarshaller.unmarshal(Node, Class)
   with the addition of maintaining the association between XML nodes
   and the produced JAXB objects, enabling future update operations,
   updateXML(Object, Object) or updateJAXB(Object).


   When getSchema() is non-null, xmlNode
   and its descendants is validated during this operation.

  xml-node - the document/element to unmarshal XML data from. - `Binder.XmlNode`
  declared-type - appropriate JAXB mapped class to hold node's XML data. - `java.lang.Class<T>`

  returns: JAXB Element representation
   of node - `<T> javax.xml.bind.JAXBElement<T>`

  throws: javax.xml.bind.JAXBException - If any unexpected errors occur while unmarshalling"
  ([^javax.xml.bind.Binder this ^Binder.XmlNode xml-node ^java.lang.Class declared-type]
    (-> this (.unmarshal xml-node declared-type)))
  ([^javax.xml.bind.Binder this ^Binder.XmlNode xml-node]
    (-> this (.unmarshal xml-node))))

