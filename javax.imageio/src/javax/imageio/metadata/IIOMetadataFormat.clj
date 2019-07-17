(ns javax.imageio.metadata.IIOMetadataFormat
  "An object describing the structure of metadata documents returned
  from IIOMetadata.getAsTree and passed to
  IIOMetadata.setFromTree and mergeTree.
  Document structures are described by a set of constraints on the
  type and number of child elements that may belong to a given parent
  element type, the names, types, and values of attributes that may
  belong to an element, and the type and values of
  Object reference that may be stored at a node.

   N.B: classes that implement this interface should contain a
  method declared as public static getInstance() which
  returns an instance of the class.  Commonly, an implementation will
  construct only a single instance and cache it for future
  invocations of getInstance.

   The structures that may be described by this class are a subset
  of those expressible using XML document type definitions (DTDs),
  with the addition of some basic information on the datatypes of
  attributes and the ability to store an Object
  reference within a node.  In the future, XML Schemas could be used
  to represent these structures, and many others.

   The differences between
  IIOMetadataFormat-described structures and DTDs are as
  follows:


   Elements may not contain text or mix text with embedded
  tags.

   The children of an element must conform to one of a few simple
  patterns, described in the documentation for the
  CHILD_* constants;

   The in-memory representation of an elements may contain a
  reference to an Object.  There is no provision for
  representing such objects textually."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.imageio.metadata IIOMetadataFormat]))

(defn get-child-names
  "Returns an array of Strings indicating the names
   of the element which are allowed to be children of the named
   element, in the order in which they should appear.  If the
   element cannot have children, null is returned.

  element-name - the name of the element being queried. - `java.lang.String`

  returns: an array of Strings, or null. - `java.lang.String[]`

  throws: java.lang.IllegalArgumentException - if elementName is null or is not a legal element name for this format."
  ([^javax.imageio.metadata.IIOMetadataFormat this ^java.lang.String element-name]
    (-> this (.getChildNames element-name))))

(defn get-object-max-value
  "Returns the maximum legal value for the Object
   reference within the named element.  Whether this value is
   inclusive or exclusive may be determined by the value of
   getObjectValueType.  This method should only be
   called if getObjectValueType returns one of the
   constants starting with VALUE_RANGE.

  element-name - the name of the element being queried. - `java.lang.String`

  returns: the smallest legal value for the attribute. - `java.lang.Comparable<?>`

  throws: java.lang.IllegalArgumentException - if the Object is not defined as a range."
  (^java.lang.Comparable [^javax.imageio.metadata.IIOMetadataFormat this ^java.lang.String element-name]
    (-> this (.getObjectMaxValue element-name))))

(defn can-node-appear?
  "Returns true if the element (and the subtree below
   it) is allowed to appear in a metadata document for an image of
   the given type, defined by an ImageTypeSpecifier.
   For example, a metadata document format might contain an
   element that describes the primary colors of the image, which
   would not be allowed when writing a grayscale image.

  element-name - the name of the element being queried. - `java.lang.String`
  image-type - an ImageTypeSpecifier indicating the type of the image that will be associated with the metadata. - `javax.imageio.ImageTypeSpecifier`

  returns: true if the node is meaningful for images
   of the given type. - `boolean`"
  (^Boolean [^javax.imageio.metadata.IIOMetadataFormat this ^java.lang.String element-name ^javax.imageio.ImageTypeSpecifier image-type]
    (-> this (.canNodeAppear element-name image-type))))

(defn get-object-default-value
  "Returns an Objects containing the default
   value for the Object reference within
   the named element.

  element-name - the name of the element being queried. - `java.lang.String`

  returns: an Object. - `java.lang.Object`

  throws: java.lang.IllegalArgumentException - if the named element cannot contain an object value (i.e., if getObjectValueType(elementName) == VALUE_NONE)."
  (^java.lang.Object [^javax.imageio.metadata.IIOMetadataFormat this ^java.lang.String element-name]
    (-> this (.getObjectDefaultValue element-name))))

(defn get-object-class
  "Returns the Class type of the Object
   reference stored within the element.  If this element may not
   contain an Object reference, an
   IllegalArgumentException will be thrown.  If the
   class type is an array, this field indicates the underlying
   class type (e.g, for an array of ints, this
   method would return int.class).

    Object references whose legal values are
   defined as a range must implement the Comparable
   interface.

  element-name - the name of the element being queried. - `java.lang.String`

  returns: a Class object. - `java.lang.Class<?>`

  throws: java.lang.IllegalArgumentException - if the named element cannot contain an object value (i.e., if getObjectValueType(elementName) == VALUE_NONE)."
  (^java.lang.Class [^javax.imageio.metadata.IIOMetadataFormat this ^java.lang.String element-name]
    (-> this (.getObjectClass element-name))))

(defn get-object-enumerations
  "Returns an array of Objects containing the legal
   enumerated values for the Object reference within
   the named element.  This method should only be called if
   getObjectValueType returns
   VALUE_ENUMERATION.

    The Object associated with a node that accepts
   enumerated values must be equal to one of the values returned by
   this method, as defined by the == operator (as
   opposed to the Object.equals method).

  element-name - the name of the element being queried. - `java.lang.String`

  returns: an array of Objects. - `java.lang.Object[]`

  throws: java.lang.IllegalArgumentException - if the Object is not defined as an enumeration."
  ([^javax.imageio.metadata.IIOMetadataFormat this ^java.lang.String element-name]
    (-> this (.getObjectEnumerations element-name))))

(defn get-attribute-min-value
  "Returns the minimum legal value for the attribute.  Whether
   this value is inclusive or exclusive may be determined by the
   value of getAttributeValueType.  The value is
   returned as a String; its interpretation is
   dependent on the value of getAttributeDataType.
   This method should only be called if
   getAttributeValueType returns
   VALUE_RANGE_*.

  element-name - the name of the element being queried. - `java.lang.String`
  attr-name - the name of the attribute being queried. - `java.lang.String`

  returns: a String containing the smallest legal
   value for the attribute. - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if the given attribute is not defined as a range."
  (^java.lang.String [^javax.imageio.metadata.IIOMetadataFormat this ^java.lang.String element-name ^java.lang.String attr-name]
    (-> this (.getAttributeMinValue element-name attr-name))))

(defn get-child-policy
  "Returns one of the constants starting with
   CHILD_POLICY_, indicating the legal pattern of
   children for the named element.

  element-name - the name of the element being queried. - `java.lang.String`

  returns: one of the CHILD_POLICY_* constants. - `int`

  throws: java.lang.IllegalArgumentException - if elementName is null or is not a legal element name for this format."
  (^Integer [^javax.imageio.metadata.IIOMetadataFormat this ^java.lang.String element-name]
    (-> this (.getChildPolicy element-name))))

(defn get-attribute-max-value
  "Returns the maximum legal value for the attribute.  Whether
   this value is inclusive or exclusive may be determined by the
   value of getAttributeValueType.  The value is
   returned as a String; its interpretation is
   dependent on the value of getAttributeDataType.
   This method should only be called if
   getAttributeValueType returns
   VALUE_RANGE_*.

  element-name - the name of the element being queried, as a String. - `java.lang.String`
  attr-name - the name of the attribute being queried. - `java.lang.String`

  returns: a String containing the largest legal
   value for the attribute. - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if the given attribute is not defined as a range."
  (^java.lang.String [^javax.imageio.metadata.IIOMetadataFormat this ^java.lang.String element-name ^java.lang.String attr-name]
    (-> this (.getAttributeMaxValue element-name attr-name))))

(defn get-attribute-description
  "Returns a String containing a description of the
   named attribute, or null.  The description will be
   localized for the supplied Locale if possible.

    If locale is null, the current
   default Locale returned by Locale.getLocale
   will be used.

  element-name - the name of the element. - `java.lang.String`
  attr-name - the name of the attribute. - `java.lang.String`
  locale - the Locale for which localization will be attempted. - `java.util.Locale`

  returns: the attribute description. - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if attrName is null or is not a legal attribute name for this element."
  (^java.lang.String [^javax.imageio.metadata.IIOMetadataFormat this ^java.lang.String element-name ^java.lang.String attr-name ^java.util.Locale locale]
    (-> this (.getAttributeDescription element-name attr-name locale))))

(defn get-element-min-children
  "Returns the minimum number of children of the named element
   with child policy CHILD_POLICY_REPEAT.  For
   example, an element representing color primary information
   might be required to have at least 3 children, one for each
   primary.

  element-name - the name of the element being queried. - `java.lang.String`

  returns: an int. - `int`

  throws: java.lang.IllegalArgumentException - if the named element does not have a child policy of CHILD_POLICY_REPEAT."
  (^Integer [^javax.imageio.metadata.IIOMetadataFormat this ^java.lang.String element-name]
    (-> this (.getElementMinChildren element-name))))

(defn get-element-max-children
  "Returns the maximum number of children of the named element
   with child policy CHILD_POLICY_REPEAT.  For
   example, an element representing an entry in an 8-bit color
   palette might be allowed to repeat up to 256 times.  A value of
   Integer.MAX_VALUE may be used to specify that
   there is no upper bound.

  element-name - the name of the element being queried. - `java.lang.String`

  returns: an int. - `int`

  throws: java.lang.IllegalArgumentException - if the named element does not have a child policy of CHILD_POLICY_REPEAT."
  (^Integer [^javax.imageio.metadata.IIOMetadataFormat this ^java.lang.String element-name]
    (-> this (.getElementMaxChildren element-name))))

(defn get-root-name
  "Returns the name of the root element of the format.

  returns: a String. - `java.lang.String`"
  (^java.lang.String [^javax.imageio.metadata.IIOMetadataFormat this]
    (-> this (.getRootName))))

(defn get-object-array-min-length
  "Returns the minimum number of array elements that may be used
   to define the Object reference within the named
   element.  This method should only be called if
   getObjectValueType returns
   VALUE_LIST.

  element-name - the name of the element being queried. - `java.lang.String`

  returns: the smallest valid array length for the
   Object reference. - `int`

  throws: java.lang.IllegalArgumentException - if the Object is not an array."
  (^Integer [^javax.imageio.metadata.IIOMetadataFormat this ^java.lang.String element-name]
    (-> this (.getObjectArrayMinLength element-name))))

(defn get-object-value-type
  "Returns one of the enumerated values starting with
   VALUE_, indicating the type of values
   (enumeration, range, or array) that are allowed for the
   Object reference.  If no object value can be
   stored within the given element, the result of this method will
   be VALUE_NONE.

    Object references whose legal values are
   defined as a range must implement the Comparable
   interface.

  element-name - the name of the element being queried. - `java.lang.String`

  returns: one of the VALUE_* constants. - `int`

  throws: java.lang.IllegalArgumentException - if elementName is null or is not a legal element name for this format."
  (^Integer [^javax.imageio.metadata.IIOMetadataFormat this ^java.lang.String element-name]
    (-> this (.getObjectValueType element-name))))

(defn attribute-required?
  "Returns true if the named attribute must be
   present within the named element.

  element-name - the name of the element being queried. - `java.lang.String`
  attr-name - the name of the attribute being queried. - `java.lang.String`

  returns: true if the attribute must be present. - `boolean`

  throws: java.lang.IllegalArgumentException - if attrName is null or is not a legal attribute name for this element."
  (^Boolean [^javax.imageio.metadata.IIOMetadataFormat this ^java.lang.String element-name ^java.lang.String attr-name]
    (-> this (.isAttributeRequired element-name attr-name))))

(defn get-attribute-list-min-length
  "Returns the minimum number of list items that may be used to
   define this attribute.  The attribute itself is defined as a
   String containing multiple whitespace-separated
   items.  This method should only be called if
   getAttributeValueType returns
   VALUE_LIST.

  element-name - the name of the element being queried. - `java.lang.String`
  attr-name - the name of the attribute being queried. - `java.lang.String`

  returns: the smallest legal number of list items for the
   attribute. - `int`

  throws: java.lang.IllegalArgumentException - if the given attribute is not defined as a list."
  (^Integer [^javax.imageio.metadata.IIOMetadataFormat this ^java.lang.String element-name ^java.lang.String attr-name]
    (-> this (.getAttributeListMinLength element-name attr-name))))

(defn get-object-array-max-length
  "Returns the maximum number of array elements that may be used
   to define the Object reference within the named
   element.  A value of Integer.MAX_VALUE may be used
   to specify that there is no upper bound.  This method should
   only be called if getObjectValueType returns
   VALUE_LIST.

  element-name - the name of the element being queried. - `java.lang.String`

  returns: the largest valid array length for the
   Object reference. - `int`

  throws: java.lang.IllegalArgumentException - if the Object is not an array."
  (^Integer [^javax.imageio.metadata.IIOMetadataFormat this ^java.lang.String element-name]
    (-> this (.getObjectArrayMaxLength element-name))))

(defn get-attribute-enumerations
  "Returns an array of Strings containing the legal
   enumerated values for the given attribute within the named
   element.  This method should only be called if
   getAttributeValueType returns
   VALUE_ENUMERATION.

  element-name - the name of the element being queried. - `java.lang.String`
  attr-name - the name of the attribute being queried. - `java.lang.String`

  returns: an array of Strings. - `java.lang.String[]`

  throws: java.lang.IllegalArgumentException - if the given attribute is not defined as an enumeration."
  ([^javax.imageio.metadata.IIOMetadataFormat this ^java.lang.String element-name ^java.lang.String attr-name]
    (-> this (.getAttributeEnumerations element-name attr-name))))

(defn get-object-min-value
  "Returns the minimum legal value for the Object
   reference within the named element.  Whether this value is
   inclusive or exclusive may be determined by the value of
   getObjectValueType.  This method should only be
   called if getObjectValueType returns one of the
   constants starting with VALUE_RANGE.

  element-name - the name of the element being queried. - `java.lang.String`

  returns: the smallest legal value for the attribute. - `java.lang.Comparable<?>`

  throws: java.lang.IllegalArgumentException - if the Object is not defined as a range."
  (^java.lang.Comparable [^javax.imageio.metadata.IIOMetadataFormat this ^java.lang.String element-name]
    (-> this (.getObjectMinValue element-name))))

(defn get-attribute-list-max-length
  "Returns the maximum number of list items that may be used to
   define this attribute.  A value of
   Integer.MAX_VALUE may be used to specify that
   there is no upper bound.  The attribute itself is defined as a
   String containing multiple whitespace-separated
   items.  This method should only be called if
   getAttributeValueType returns
   VALUE_LIST.

  element-name - the name of the element being queried. - `java.lang.String`
  attr-name - the name of the attribute being queried. - `java.lang.String`

  returns: the largest legal number of list items for the
   attribute. - `int`

  throws: java.lang.IllegalArgumentException - if the given attribute is not defined as a list."
  (^Integer [^javax.imageio.metadata.IIOMetadataFormat this ^java.lang.String element-name ^java.lang.String attr-name]
    (-> this (.getAttributeListMaxLength element-name attr-name))))

(defn get-attribute-data-type
  "Returns one of the constants starting with
   DATATYPE_, indicating the format and
   interpretation of the value of the given attribute within the
   named element.  If getAttributeValueType returns
   VALUE_LIST, then the legal value is a
   whitespace-spearated list of values of the returned datatype.

  element-name - the name of the element being queried. - `java.lang.String`
  attr-name - the name of the attribute being queried. - `java.lang.String`

  returns: one of the DATATYPE_* constants. - `int`

  throws: java.lang.IllegalArgumentException - if attrName is null or is not a legal attribute name for this element."
  (^Integer [^javax.imageio.metadata.IIOMetadataFormat this ^java.lang.String element-name ^java.lang.String attr-name]
    (-> this (.getAttributeDataType element-name attr-name))))

(defn get-attribute-default-value
  "Returns the default value of the named attribute, if it is not
   explicitly present within the named element, as a
   String, or null if no default value
   is available.

  element-name - the name of the element being queried. - `java.lang.String`
  attr-name - the name of the attribute being queried. - `java.lang.String`

  returns: a String containing the default value, or
   null. - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if attrName is null or is not a legal attribute name for this element."
  (^java.lang.String [^javax.imageio.metadata.IIOMetadataFormat this ^java.lang.String element-name ^java.lang.String attr-name]
    (-> this (.getAttributeDefaultValue element-name attr-name))))

(defn get-attribute-names
  "Returns an array of Strings listing the names of
   the attributes that may be associated with the named element.

  element-name - the name of the element being queried. - `java.lang.String`

  returns: an array of Strings. - `java.lang.String[]`

  throws: java.lang.IllegalArgumentException - if elementName is null or is not a legal element name for this format."
  ([^javax.imageio.metadata.IIOMetadataFormat this ^java.lang.String element-name]
    (-> this (.getAttributeNames element-name))))

(defn get-element-description
  "Returns a String containing a description of the
   named element, or null.  The description will be
   localized for the supplied Locale if possible.

    If locale is null, the current
   default Locale returned by Locale.getLocale
   will be used.

  element-name - the name of the element. - `java.lang.String`
  locale - the Locale for which localization will be attempted. - `java.util.Locale`

  returns: the element description. - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if elementName is null, or is not a legal element name for this format."
  (^java.lang.String [^javax.imageio.metadata.IIOMetadataFormat this ^java.lang.String element-name ^java.util.Locale locale]
    (-> this (.getElementDescription element-name locale))))

(defn get-attribute-value-type
  "Returns one of the constants starting with VALUE_,
   indicating whether the values of the given attribute within the
   named element are arbitrary, constrained to lie within a
   specified range, constrained to be one of a set of enumerated
   values, or are a whitespace-separated list of arbitrary values.

  element-name - the name of the element being queried. - `java.lang.String`
  attr-name - the name of the attribute being queried. - `java.lang.String`

  returns: one of the VALUE_* constants. - `int`

  throws: java.lang.IllegalArgumentException - if attrName is null or is not a legal attribute name for this element."
  (^Integer [^javax.imageio.metadata.IIOMetadataFormat this ^java.lang.String element-name ^java.lang.String attr-name]
    (-> this (.getAttributeValueType element-name attr-name))))

