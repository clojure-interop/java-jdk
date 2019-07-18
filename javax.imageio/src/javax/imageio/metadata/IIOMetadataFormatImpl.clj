(ns javax.imageio.metadata.IIOMetadataFormatImpl
  "A concrete class providing a reusable implementation of the
  IIOMetadataFormat interface.  In addition, a static
  instance representing the standard, plug-in neutral
  javax_imageio_1.0 format is provided by the
  getStandardFormatInstance method.

   In order to supply localized descriptions of elements and
  attributes, a ResourceBundle with a base name of
  this.getClass().getName()  `Resources` should be
  supplied via the usual mechanism used by
  ResourceBundle.getBundle.  Briefly, the subclasser
  supplies one or more additional classes according to a naming
  convention (by default, the fully-qualified name of the subclass
  extending IIMetadataFormatImpl, plus the string
  `Resources`, plus the country, language, and variant codes
  separated by underscores).  At run time, calls to
  getElementDescription or
  getAttributeDescription will attempt to load such
  classes dynamically according to the supplied locale, and will use
  either the element name, or the element name followed by a '/'
  character followed by the attribute name as a key.  This key will
  be supplied to the ResourceBundle's
  getString method, and the resulting localized
  description of the node or attribute is returned.

   The subclass may supply a different base name for the resource
  bundles using the setResourceBaseName method.

   A subclass may choose its own localization mechanism, if so
  desired, by overriding the supplied implementations of
  getElementDescription and
  getAttributeDescription."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.imageio.metadata IIOMetadataFormatImpl]))

(defn ->iio-metadata-format-impl
  "Constructor.

  Constructs a blank IIOMetadataFormatImpl instance,
   with a given root element name and a child policy of
   CHILD_POLICY_REPEAT.  Additional elements, and
   their attributes and Object reference information
   may be added using the various add methods.

  root-name - the name of the root element. - `java.lang.String`
  min-children - the minimum number of children of the node. - `int`
  max-children - the maximum number of children of the node. - `int`

  throws: java.lang.IllegalArgumentException - if minChildren is negative or larger than maxChildren."
  (^IIOMetadataFormatImpl [^java.lang.String root-name ^Integer min-children ^Integer max-children]
    (new IIOMetadataFormatImpl root-name min-children max-children))
  (^IIOMetadataFormatImpl [^java.lang.String root-name ^Integer child-policy]
    (new IIOMetadataFormatImpl root-name child-policy)))

(def *-standard-metadata-format-name
  "Static Constant.

  A String constant containing the standard format
   name, `javax_imageio_1.0`.

  type: java.lang.String"
  IIOMetadataFormatImpl/standardMetadataFormatName)

(defn *get-standard-format-instance
  "Returns an IIOMetadataFormat object describing the
   standard, plug-in neutral javax.imageio_1.0
   metadata document format described in the comment of the
   javax.imageio.metadata package.

  returns: a predefined IIOMetadataFormat instance. - `javax.imageio.metadata.IIOMetadataFormat`"
  (^javax.imageio.metadata.IIOMetadataFormat []
    (IIOMetadataFormatImpl/getStandardFormatInstance )))

(defn get-child-names
  "Description copied from interface: IIOMetadataFormat

  element-name - the name of the element being queried. - `java.lang.String`

  returns: an array of Strings, or null. - `java.lang.String[]`"
  ([^IIOMetadataFormatImpl this ^java.lang.String element-name]
    (-> this (.getChildNames element-name))))

(defn get-object-max-value
  "Description copied from interface: IIOMetadataFormat

  element-name - the name of the element being queried. - `java.lang.String`

  returns: the smallest legal value for the attribute. - `java.lang.Comparable<?>`"
  (^java.lang.Comparable [^IIOMetadataFormatImpl this ^java.lang.String element-name]
    (-> this (.getObjectMaxValue element-name))))

(defn can-node-appear?
  "Description copied from interface: IIOMetadataFormat

  element-name - the name of the element being queried. - `java.lang.String`
  image-type - an ImageTypeSpecifier indicating the type of the image that will be associated with the metadata. - `javax.imageio.ImageTypeSpecifier`

  returns: true if the node is meaningful for images
   of the given type. - `boolean`"
  (^Boolean [^IIOMetadataFormatImpl this ^java.lang.String element-name ^javax.imageio.ImageTypeSpecifier image-type]
    (-> this (.canNodeAppear element-name image-type))))

(defn get-object-default-value
  "Description copied from interface: IIOMetadataFormat

  element-name - the name of the element being queried. - `java.lang.String`

  returns: an Object. - `java.lang.Object`"
  (^java.lang.Object [^IIOMetadataFormatImpl this ^java.lang.String element-name]
    (-> this (.getObjectDefaultValue element-name))))

(defn get-object-class
  "Description copied from interface: IIOMetadataFormat

  element-name - the name of the element being queried. - `java.lang.String`

  returns: a Class object. - `java.lang.Class<?>`"
  (^java.lang.Class [^IIOMetadataFormatImpl this ^java.lang.String element-name]
    (-> this (.getObjectClass element-name))))

(defn get-object-enumerations
  "Description copied from interface: IIOMetadataFormat

  element-name - the name of the element being queried. - `java.lang.String`

  returns: an array of Objects. - `java.lang.Object[]`"
  ([^IIOMetadataFormatImpl this ^java.lang.String element-name]
    (-> this (.getObjectEnumerations element-name))))

(defn get-attribute-min-value
  "Description copied from interface: IIOMetadataFormat

  element-name - the name of the element being queried. - `java.lang.String`
  attr-name - the name of the attribute being queried. - `java.lang.String`

  returns: a String containing the smallest legal
   value for the attribute. - `java.lang.String`"
  (^java.lang.String [^IIOMetadataFormatImpl this ^java.lang.String element-name ^java.lang.String attr-name]
    (-> this (.getAttributeMinValue element-name attr-name))))

(defn get-child-policy
  "Description copied from interface: IIOMetadataFormat

  element-name - the name of the element being queried. - `java.lang.String`

  returns: one of the CHILD_POLICY_* constants. - `int`"
  (^Integer [^IIOMetadataFormatImpl this ^java.lang.String element-name]
    (-> this (.getChildPolicy element-name))))

(defn get-attribute-max-value
  "Description copied from interface: IIOMetadataFormat

  element-name - the name of the element being queried, as a String. - `java.lang.String`
  attr-name - the name of the attribute being queried. - `java.lang.String`

  returns: a String containing the largest legal
   value for the attribute. - `java.lang.String`"
  (^java.lang.String [^IIOMetadataFormatImpl this ^java.lang.String element-name ^java.lang.String attr-name]
    (-> this (.getAttributeMaxValue element-name attr-name))))

(defn get-attribute-description
  "Returns a String containing a description of the
   named attribute, or null.  The description will be
   localized for the supplied Locale if possible.

    The default implementation will first locate a
   ResourceBundle using the current resource base
   name set by setResourceBaseName and the supplied
   Locale, using the fallback mechanism described in
   the comments for ResourceBundle.getBundle.  If a
   ResourceBundle is found, the element name followed
   by a `/` character followed by the attribute name
   (elementName  `/`  attrName) will be used as a
   key to its getString method, and the result
   returned.  If no ResourceBundle is found, or no
   such key is present, null will be returned.

    If locale is null, the current
   default Locale returned by Locale.getLocale
   will be used.

  element-name - the name of the element. - `java.lang.String`
  attr-name - the name of the attribute. - `java.lang.String`
  locale - the Locale for which localization will be attempted, or null. - `java.util.Locale`

  returns: the attribute description. - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if attrName is null or is not a legal attribute name for this element."
  (^java.lang.String [^IIOMetadataFormatImpl this ^java.lang.String element-name ^java.lang.String attr-name ^java.util.Locale locale]
    (-> this (.getAttributeDescription element-name attr-name locale))))

(defn get-element-min-children
  "Description copied from interface: IIOMetadataFormat

  element-name - the name of the element being queried. - `java.lang.String`

  returns: an int. - `int`"
  (^Integer [^IIOMetadataFormatImpl this ^java.lang.String element-name]
    (-> this (.getElementMinChildren element-name))))

(defn get-element-max-children
  "Description copied from interface: IIOMetadataFormat

  element-name - the name of the element being queried. - `java.lang.String`

  returns: an int. - `int`"
  (^Integer [^IIOMetadataFormatImpl this ^java.lang.String element-name]
    (-> this (.getElementMaxChildren element-name))))

(defn get-root-name
  "Description copied from interface: IIOMetadataFormat

  returns: a String. - `java.lang.String`"
  (^java.lang.String [^IIOMetadataFormatImpl this]
    (-> this (.getRootName))))

(defn get-object-array-min-length
  "Description copied from interface: IIOMetadataFormat

  element-name - the name of the element being queried. - `java.lang.String`

  returns: the smallest valid array length for the
   Object reference. - `int`"
  (^Integer [^IIOMetadataFormatImpl this ^java.lang.String element-name]
    (-> this (.getObjectArrayMinLength element-name))))

(defn get-object-value-type
  "Description copied from interface: IIOMetadataFormat

  element-name - the name of the element being queried. - `java.lang.String`

  returns: one of the VALUE_* constants. - `int`"
  (^Integer [^IIOMetadataFormatImpl this ^java.lang.String element-name]
    (-> this (.getObjectValueType element-name))))

(defn attribute-required?
  "Description copied from interface: IIOMetadataFormat

  element-name - the name of the element being queried. - `java.lang.String`
  attr-name - the name of the attribute being queried. - `java.lang.String`

  returns: true if the attribute must be present. - `boolean`"
  (^Boolean [^IIOMetadataFormatImpl this ^java.lang.String element-name ^java.lang.String attr-name]
    (-> this (.isAttributeRequired element-name attr-name))))

(defn get-attribute-list-min-length
  "Description copied from interface: IIOMetadataFormat

  element-name - the name of the element being queried. - `java.lang.String`
  attr-name - the name of the attribute being queried. - `java.lang.String`

  returns: the smallest legal number of list items for the
   attribute. - `int`"
  (^Integer [^IIOMetadataFormatImpl this ^java.lang.String element-name ^java.lang.String attr-name]
    (-> this (.getAttributeListMinLength element-name attr-name))))

(defn get-object-array-max-length
  "Description copied from interface: IIOMetadataFormat

  element-name - the name of the element being queried. - `java.lang.String`

  returns: the largest valid array length for the
   Object reference. - `int`"
  (^Integer [^IIOMetadataFormatImpl this ^java.lang.String element-name]
    (-> this (.getObjectArrayMaxLength element-name))))

(defn get-attribute-enumerations
  "Description copied from interface: IIOMetadataFormat

  element-name - the name of the element being queried. - `java.lang.String`
  attr-name - the name of the attribute being queried. - `java.lang.String`

  returns: an array of Strings. - `java.lang.String[]`"
  ([^IIOMetadataFormatImpl this ^java.lang.String element-name ^java.lang.String attr-name]
    (-> this (.getAttributeEnumerations element-name attr-name))))

(defn get-object-min-value
  "Description copied from interface: IIOMetadataFormat

  element-name - the name of the element being queried. - `java.lang.String`

  returns: the smallest legal value for the attribute. - `java.lang.Comparable<?>`"
  (^java.lang.Comparable [^IIOMetadataFormatImpl this ^java.lang.String element-name]
    (-> this (.getObjectMinValue element-name))))

(defn get-attribute-list-max-length
  "Description copied from interface: IIOMetadataFormat

  element-name - the name of the element being queried. - `java.lang.String`
  attr-name - the name of the attribute being queried. - `java.lang.String`

  returns: the largest legal number of list items for the
   attribute. - `int`"
  (^Integer [^IIOMetadataFormatImpl this ^java.lang.String element-name ^java.lang.String attr-name]
    (-> this (.getAttributeListMaxLength element-name attr-name))))

(defn get-attribute-data-type
  "Description copied from interface: IIOMetadataFormat

  element-name - the name of the element being queried. - `java.lang.String`
  attr-name - the name of the attribute being queried. - `java.lang.String`

  returns: one of the DATATYPE_* constants. - `int`"
  (^Integer [^IIOMetadataFormatImpl this ^java.lang.String element-name ^java.lang.String attr-name]
    (-> this (.getAttributeDataType element-name attr-name))))

(defn get-attribute-default-value
  "Description copied from interface: IIOMetadataFormat

  element-name - the name of the element being queried. - `java.lang.String`
  attr-name - the name of the attribute being queried. - `java.lang.String`

  returns: a String containing the default value, or
   null. - `java.lang.String`"
  (^java.lang.String [^IIOMetadataFormatImpl this ^java.lang.String element-name ^java.lang.String attr-name]
    (-> this (.getAttributeDefaultValue element-name attr-name))))

(defn get-attribute-names
  "Description copied from interface: IIOMetadataFormat

  element-name - the name of the element being queried. - `java.lang.String`

  returns: an array of Strings. - `java.lang.String[]`"
  ([^IIOMetadataFormatImpl this ^java.lang.String element-name]
    (-> this (.getAttributeNames element-name))))

(defn get-element-description
  "Returns a String containing a description of the
   named element, or null.  The description will be
   localized for the supplied Locale if possible.

    The default implementation will first locate a
   ResourceBundle using the current resource base
   name set by setResourceBaseName and the supplied
   Locale, using the fallback mechanism described in
   the comments for ResourceBundle.getBundle.  If a
   ResourceBundle is found, the element name will be
   used as a key to its getString method, and the
   result returned.  If no ResourceBundle is found,
   or no such key is present, null will be returned.

    If locale is null, the current
   default Locale returned by Locale.getLocale
   will be used.

  element-name - the name of the element. - `java.lang.String`
  locale - the Locale for which localization will be attempted. - `java.util.Locale`

  returns: the element description. - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if elementName is null, or is not a legal element name for this format."
  (^java.lang.String [^IIOMetadataFormatImpl this ^java.lang.String element-name ^java.util.Locale locale]
    (-> this (.getElementDescription element-name locale))))

(defn get-attribute-value-type
  "Description copied from interface: IIOMetadataFormat

  element-name - the name of the element being queried. - `java.lang.String`
  attr-name - the name of the attribute being queried. - `java.lang.String`

  returns: one of the VALUE_* constants. - `int`"
  (^Integer [^IIOMetadataFormatImpl this ^java.lang.String element-name ^java.lang.String attr-name]
    (-> this (.getAttributeValueType element-name attr-name))))

