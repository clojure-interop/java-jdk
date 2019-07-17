(ns javax.xml.bind.JAXBElement
  "JAXB representation of an Xml Element.

  This class represents information about an Xml Element from both the element
  declaration within a schema and the element instance value within an xml document
  with the following properties

    element's xml tag name
    value represents the element instance's atttribute(s) and content model
    element declaration's declaredType (xs:element @type attribute)
    scope of element declaration
    boolean nil property. (element instance's xsi:nil attribute)


  The declaredType and scope property are the
  JAXB class binding for the xml type definition.


  Scope is either JAXBElement.GlobalScope or the Java class representing the
  complex type definition containing the schema element declaration.


  There is a property constraint that if value is null,
  then nil must be true. The converse is not true to enable
  representing a nil element with attribute(s). If nil is true, it is possible
  that value is non-null so it can hold the value of the attributes
  associated with a nil element."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.bind JAXBElement]))

(defn ->jaxb-element
  "Constructor.

  Construct an xml element instance.

  name - Java binding of xml element tag name - `javax.xml.namespace.QName`
  declared-type - Java binding of xml element declaration's type - `java.lang.Class<JAXBElement.T>`
  scope - Java binding of scope of xml element declaration. Passing null is the same as passing GlobalScope.class - `java.lang.Class`
  value - Java instance representing xml element's value. - `JAXBElement.T`"
  ([^javax.xml.namespace.QName name ^java.lang.Class declared-type ^java.lang.Class scope ^JAXBElement.T value]
    (new JAXBElement name declared-type scope value))
  ([^javax.xml.namespace.QName name ^java.lang.Class declared-type ^JAXBElement.T value]
    (new JAXBElement name declared-type value)))

(defn get-declared-type
  "Returns the Java binding of the xml element declaration's type attribute.

  returns: `java.lang.Class<JAXBElement.T>`"
  (^java.lang.Class [^javax.xml.bind.JAXBElement this]
    (-> this (.getDeclaredType))))

(defn set-nil
  "Set whether this element has nil content.

  value - `boolean`"
  ([^javax.xml.bind.JAXBElement this ^Boolean value]
    (-> this (.setNil value))))

(defn get-value
  "Return the content model and attribute values for this element.

   See isNil() for a description of a property constraint when
   this value is null

  returns: `JAXBElement.T`"
  (^JAXBElement.T [^javax.xml.bind.JAXBElement this]
    (-> this (.getValue))))

(defn get-name
  "Returns the xml element tag name.

  returns: `javax.xml.namespace.QName`"
  (^javax.xml.namespace.QName [^javax.xml.bind.JAXBElement this]
    (-> this (.getName))))

(defn global-scope?
  "Returns true iff this xml element declaration is global.

  returns: `boolean`"
  (^Boolean [^javax.xml.bind.JAXBElement this]
    (-> this (.isGlobalScope))))

(defn nil?
  "Returns true iff this element instance content model
   is nil.

   This property always returns true when getValue() is null.
   Note that the converse is not true, when this property is true,
   getValue() can contain a non-null value for attribute(s). It is
   valid for a nil xml element to have attribute(s).

  returns: `boolean`"
  (^Boolean [^javax.xml.bind.JAXBElement this]
    (-> this (.isNil))))

(defn set-value
  "Set the content model and attributes of this xml element.

   When this property is set to null, isNil() must by true.
      Details of constraint are described at isNil().

  t - `JAXBElement.T`"
  ([^javax.xml.bind.JAXBElement this ^JAXBElement.T t]
    (-> this (.setValue t))))

(defn type-substituted?
  "Returns true iff this xml element instance's value has a different
   type than xml element declaration's declared type.

  returns: `boolean`"
  (^Boolean [^javax.xml.bind.JAXBElement this]
    (-> this (.isTypeSubstituted))))

(defn get-scope
  "Returns scope of xml element declaration.

  returns: GlobalScope.class if this element is of global scope. - `java.lang.Class`"
  (^java.lang.Class [^javax.xml.bind.JAXBElement this]
    (-> this (.getScope))))

