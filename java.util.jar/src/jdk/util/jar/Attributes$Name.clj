(ns jdk.util.jar.Attributes$Name
  "The Attributes.Name class represents an attribute name stored in
  this Map. Valid attribute names are case-insensitive, are restricted
  to the ASCII characters in the set [0-9a-zA-Z_-], and cannot exceed
  70 characters in length. Attribute values can contain any characters
  and will be UTF8-encoded when written to the output stream.  See the
  JAR File Specification
  for more information about valid attribute names and values."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.jar Attributes$Name]))

(defn ->name
  "Constructor.

  Constructs a new attribute name using the given string name.

  name - the attribute string name - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if the attribute name was invalid"
  ([^java.lang.String name]
    (new Attributes$Name name)))

(def *-manifest-version
  "Static Constant.

  Name object for Manifest-Version
   manifest attribute. This attribute indicates the version number
   of the manifest standard to which a JAR file's manifest conforms.

  type: java.util.jar.Attributes.Name"
  Attributes$Name/MANIFEST_VERSION)

(def *-signature-version
  "Static Constant.

  Name object for Signature-Version
   manifest attribute used when signing JAR files.

  type: java.util.jar.Attributes.Name"
  Attributes$Name/SIGNATURE_VERSION)

(def *-content-type
  "Static Constant.

  Name object for Content-Type
   manifest attribute.

  type: java.util.jar.Attributes.Name"
  Attributes$Name/CONTENT_TYPE)

(def *-class-path
  "Static Constant.

  Name object for Class-Path
   manifest attribute. Bundled extensions can use this attribute
   to find other JAR files containing needed classes.

  type: java.util.jar.Attributes.Name"
  Attributes$Name/CLASS_PATH)

(def *-main-class
  "Static Constant.

  Name object for Main-Class manifest
   attribute used for launching applications packaged in JAR files.
   The Main-Class attribute is used in conjunction
   with the -jar command-line option of the
   java application launcher.

  type: java.util.jar.Attributes.Name"
  Attributes$Name/MAIN_CLASS)

(def *-sealed
  "Static Constant.

  Name object for Sealed manifest attribute
   used for sealing.

  type: java.util.jar.Attributes.Name"
  Attributes$Name/SEALED)

(def *-extension-list
  "Static Constant.

  Name object for Extension-List manifest attribute
   used for declaring dependencies on installed extensions.

  type: java.util.jar.Attributes.Name"
  Attributes$Name/EXTENSION_LIST)

(def *-extension-name
  "Static Constant.

  Name object for Extension-Name manifest attribute
   used for declaring dependencies on installed extensions.

  type: java.util.jar.Attributes.Name"
  Attributes$Name/EXTENSION_NAME)

(def *-extension-installation
  "Static Constant.

  Deprecated. Extension mechanism will be removed in a future release.
               Use class path instead.

  type: java.lang.    java.util.jar.Attributes.Name"
  Attributes$Name/EXTENSION_INSTALLATION)

(def *-implementation-title
  "Static Constant.

  Name object for Implementation-Title
   manifest attribute used for package versioning.

  type: java.util.jar.Attributes.Name"
  Attributes$Name/IMPLEMENTATION_TITLE)

(def *-implementation-version
  "Static Constant.

  Name object for Implementation-Version
   manifest attribute used for package versioning.

  type: java.util.jar.Attributes.Name"
  Attributes$Name/IMPLEMENTATION_VERSION)

(def *-implementation-vendor
  "Static Constant.

  Name object for Implementation-Vendor
   manifest attribute used for package versioning.

  type: java.util.jar.Attributes.Name"
  Attributes$Name/IMPLEMENTATION_VENDOR)

(def *-implementation-vendor-id
  "Static Constant.

  Deprecated. Extension mechanism will be removed in a future release.
               Use class path instead.

  type: java.lang.    java.util.jar.Attributes.Name"
  Attributes$Name/IMPLEMENTATION_VENDOR_ID)

(def *-implementation-url
  "Static Constant.

  Deprecated. Extension mechanism will be removed in a future release.
               Use class path instead.

  type: java.lang.    java.util.jar.Attributes.Name"
  Attributes$Name/IMPLEMENTATION_URL)

(def *-specification-title
  "Static Constant.

  Name object for Specification-Title
   manifest attribute used for package versioning.

  type: java.util.jar.Attributes.Name"
  Attributes$Name/SPECIFICATION_TITLE)

(def *-specification-version
  "Static Constant.

  Name object for Specification-Version
   manifest attribute used for package versioning.

  type: java.util.jar.Attributes.Name"
  Attributes$Name/SPECIFICATION_VERSION)

(def *-specification-vendor
  "Static Constant.

  Name object for Specification-Vendor
   manifest attribute used for package versioning.

  type: java.util.jar.Attributes.Name"
  Attributes$Name/SPECIFICATION_VENDOR)

(defn equals
  "Compares this attribute name to another for equality.

  o - the object to compare - `java.lang.Object`

  returns: true if this attribute name is equal to the
           specified attribute object - `boolean`"
  ([^java.util.jar.Attributes$Name this ^java.lang.Object o]
    (-> this (.equals o))))

(defn hash-code
  "Computes the hash value for this attribute name.

  returns: a hash code value for this object. - `int`"
  ([^java.util.jar.Attributes$Name this]
    (-> this (.hashCode))))

(defn to-string
  "Returns the attribute name as a String.

  returns: a string representation of the object. - `java.lang.String`"
  ([^java.util.jar.Attributes$Name this]
    (-> this (.toString))))

