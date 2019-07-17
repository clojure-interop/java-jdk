(ns jdk.awt.datatransfer.DataFlavor
  "A DataFlavor provides meta information about data. DataFlavor
  is typically used to access data on the clipboard, or during
  a drag and drop operation.

  An instance of DataFlavor encapsulates a content type as
  defined in RFC 2045
  and RFC 2046.
  A content type is typically referred to as a MIME type.

  A content type consists of a media type (referred
  to as the primary type), a subtype, and optional parameters. See
  RFC 2045
  for details on the syntax of a MIME type.

  The JRE data transfer implementation interprets the parameter `class`
  of a MIME type as a representation class.
  The representation class reflects the class of the object being
  transferred. In other words, the representation class is the type of
  object returned by Transferable.getTransferData(java.awt.datatransfer.DataFlavor).
  For example, the MIME type of imageFlavor is
  `image/x-java-image;class=java.awt.Image`,
  the primary type is image, the subtype is
  x-java-image, and the representation class is
  java.awt.Image. When getTransferData is invoked
  with a DataFlavor of imageFlavor, an instance of
  java.awt.Image is returned.
  It's important to note that DataFlavor does no error checking
  against the representation class. It is up to consumers of
  DataFlavor, such as Transferable, to honor the representation
  class.

  Note, if you do not specify a representation class when
  creating a DataFlavor, the default
  representation class is used. See appropriate documentation for
  DataFlavor's constructors.

  Also, DataFlavor instances with the `text` primary
  MIME type may have a `charset` parameter. Refer to
  RFC 2046 and
  selectBestTextFlavor(java.awt.datatransfer.DataFlavor[]) for details on `text` MIME types
  and the `charset` parameter.

  Equality of DataFlavors is determined by the primary type,
  subtype, and representation class. Refer to equals(DataFlavor) for
  details. When determining equality, any optional parameters are ignored.
  For example, the following produces two DataFlavors that
  are considered identical:


    DataFlavor flavor1 = new DataFlavor(Object.class, `X-test/test; class=<java.lang.Object>; foo=bar`);
    DataFlavor flavor2 = new DataFlavor(Object.class, `X-test/test; class=<java.lang.Object>; x=y`);
    // The following returns true.
    flavor1.equals(flavor2);
  As mentioned, flavor1 and flavor2 are considered identical.
  As such, asking a Transferable for either DataFlavor returns
  the same results.

  For more information on the using data transfer with Swing see
  the
  How to Use Drag and Drop and Data Transfer,
  section in Java Tutorial."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.datatransfer DataFlavor]))

(defn ->data-flavor
  "Constructor.

  Constructs a DataFlavor that represents a
   MimeType.

   The returned DataFlavor will have the following
   characteristics:

   If the mimeType is
   `application/x-java-serialized-object; class=<representation class>`,
   the result is the same as calling
   new DataFlavor(Class:forName(<representation class>).

   Otherwise:


       representationClass = InputStream
       mimeType            = mimeType

  mime-type - the string used to identify the MIME type for this flavor - `java.lang.String`
  human-presentable-name - the human-readable string used to identify this flavor - `java.lang.String`
  class-loader - the class loader to use - `java.lang.ClassLoader`

  throws: java.lang.ClassNotFoundException - if the class is not loaded"
  ([mime-type human-presentable-name class-loader]
    (new DataFlavor mime-type human-presentable-name class-loader))
  ([representation-class human-presentable-name]
    (new DataFlavor representation-class human-presentable-name))
  ([mime-type]
    (new DataFlavor mime-type))
  ([]
    (new DataFlavor )))

(def *-string-flavor
  "Static Constant.

  The DataFlavor representing a Java Unicode String class,
   where:


       representationClass = java.lang.String
       mimeType           = `application/x-java-serialized-object`

  type: java.awt.datatransfer.DataFlavor"
  DataFlavor/stringFlavor)

(def *-image-flavor
  "Static Constant.

  The DataFlavor representing a Java Image class,
   where:


       representationClass = java.awt.Image
       mimeType            = `image/x-java-image`

  type: java.awt.datatransfer.DataFlavor"
  DataFlavor/imageFlavor)

(def *-plain-text-flavor
  "Static Constant.

  Deprecated. as of 1.3. Use DataFlavor.getReaderForText(Transferable)
               instead of Transferable.getTransferData(DataFlavor.plainTextFlavor).

  type: java.lang.    java.awt.datatransfer.DataFlavor"
  DataFlavor/plainTextFlavor)

(def *-java-serialized-object-mime-type
  "Static Constant.

  A MIME Content-Type of application/x-java-serialized-object represents
   a graph of Java object(s) that have been made persistent.

   The representation class associated with this DataFlavor
   identifies the Java type of an object returned as a reference
   from an invocation java.awt.datatransfer.getTransferData.

  type: java.lang.String"
  DataFlavor/javaSerializedObjectMimeType)

(def *-java-file-list-flavor
  "Static Constant.

  To transfer a list of files to/from Java (and the underlying
   platform) a DataFlavor of this type/subtype and
   representation class of java.util.List is used.
   Each element of the list is required/guaranteed to be of type
   java.io.File.

  type: java.awt.datatransfer.DataFlavor"
  DataFlavor/javaFileListFlavor)

(def *-java-jvm-local-object-mime-type
  "Static Constant.

  To transfer a reference to an arbitrary Java object reference that
   has no associated MIME Content-type, across a Transferable
   interface WITHIN THE SAME JVM, a DataFlavor
   with this type/subtype is used, with a representationClass
   equal to the type of the class/interface being passed across the
   Transferable.

   The object reference returned from
   Transferable.getTransferData for a DataFlavor
   with this MIME Content-Type is required to be
   an instance of the representation Class of the DataFlavor.

  type: java.lang.String"
  DataFlavor/javaJVMLocalObjectMimeType)

(def *-java-remote-object-mime-type
  "Static Constant.

  In order to pass a live link to a Remote object via a Drag and Drop
   ACTION_LINK operation a Mime Content Type of
   application/x-java-remote-object should be used,
   where the representation class of the DataFlavor
   represents the type of the Remote interface to be
   transferred.

  type: java.lang.String"
  DataFlavor/javaRemoteObjectMimeType)

(defn *-selection-html-flavor
  "Static Field.

  Represents a piece of an HTML markup. The markup consists of the part
   selected on the source side. Therefore some tags in the markup may be
   unpaired. If the flavor is used to represent the data in
   a Transferable instance, no additional changes will be made.
   This DataFlavor instance represents the same HTML markup as DataFlavor
   instances which content MIME type does not contain document parameter
   and representation class is the String class.


       representationClass = String
       mimeType           = `text/html`

  type: java.awt.datatransfer.DataFlavor"
  []
  DataFlavor/selectionHtmlFlavor)

(defn *-fragment-html-flavor
  "Static Field.

  Represents a piece of an HTML markup. If possible, the markup received
   from a native system is supplemented with pair tags to be
   a well-formed HTML markup. If the flavor is used to represent the data in
   a Transferable instance, no additional changes will be made.


       representationClass = String
       mimeType           = `text/html`

  type: java.awt.datatransfer.DataFlavor"
  []
  DataFlavor/fragmentHtmlFlavor)

(defn *-all-html-flavor
  "Static Field.

  Represents a piece of an HTML markup. If possible, the markup
   received from a native system is supplemented with additional
   tags to make up a well-formed HTML document. If the flavor is used to
   represent the data in a Transferable instance,
   no additional changes will be made.


       representationClass = String
       mimeType           = `text/html`

  type: java.awt.datatransfer.DataFlavor"
  []
  DataFlavor/allHtmlFlavor)

(defn *get-text-plain-unicode-flavor
  "Returns a DataFlavor representing plain text with Unicode
   encoding, where:


       representationClass = java.io.InputStream
       mimeType            = `text/plain;
                              charset=<platform default Unicode encoding>`
   Sun's implementation for Microsoft Windows uses the encoding utf-16le.
   Sun's implementation for Solaris and Linux uses the encoding
   iso-10646-ucs-2.

  returns: a DataFlavor representing plain text
      with Unicode encoding - `java.awt.datatransfer.DataFlavor`"
  ([]
    (DataFlavor/getTextPlainUnicodeFlavor )))

(defn *select-best-text-flavor
  "Selects the best text DataFlavor from an array of
   DataFlavors. Only DataFlavor.stringFlavor, and
   equivalent flavors, and flavors that have a primary MIME type of `text`,
   are considered for selection.

   Flavors are first sorted by their MIME types in the following order:

   `text/sgml`
   `text/xml`
   `text/html`
   `text/rtf`
   `text/enriched`
   `text/richtext`
   `text/uri-list`
   `text/tab-separated-values`
   `text/t140`
   `text/rfc822-headers`
   `text/parityfec`
   `text/directory`
   `text/css`
   `text/calendar`
   `application/x-java-serialized-object`
   `text/plain`
   `text/<other>`

   For example, `text/sgml` will be selected over
   `text/html`, and DataFlavor.stringFlavor will be chosen
   over DataFlavor.plainTextFlavor.

   If two or more flavors share the best MIME type in the array, then that
   MIME type will be checked to see if it supports the charset parameter.

   The following MIME types support, or are treated as though they support,
   the charset parameter:

   `text/sgml`
   `text/xml`
   `text/html`
   `text/enriched`
   `text/richtext`
   `text/uri-list`
   `text/directory`
   `text/css`
   `text/calendar`
   `application/x-java-serialized-object`
   `text/plain`

   The following MIME types do not support, or are treated as though they
   do not support, the charset parameter:

   `text/rtf`
   `text/tab-separated-values`
   `text/t140`
   `text/rfc822-headers`
   `text/parityfec`

   For `text/<other>` MIME types, the first time the JRE needs to
   determine whether the MIME type supports the charset parameter, it will
   check whether the parameter is explicitly listed in an arbitrarily
   chosen DataFlavor which uses that MIME type. If so, the JRE
   will assume from that point on that the MIME type supports the charset
   parameter and will not check again. If the parameter is not explicitly
   listed, the JRE will assume from that point on that the MIME type does
   not support the charset parameter and will not check again. Because
   this check is performed on an arbitrarily chosen
   DataFlavor, developers must ensure that all
   DataFlavors with a `text/<other>` MIME type specify
   the charset parameter if it is supported by that MIME type. Developers
   should never rely on the JRE to substitute the platform's default
   charset for a `text/<other>` DataFlavor. Failure to adhere to this
   restriction will lead to undefined behavior.

   If the best MIME type in the array does not support the charset
   parameter, the flavors which share that MIME type will then be sorted by
   their representation classes in the following order:
   java.io.InputStream, java.nio.ByteBuffer,
   [B, <all others>.

   If two or more flavors share the best representation class, or if no
   flavor has one of the three specified representations, then one of those
   flavors will be chosen non-deterministically.

   If the best MIME type in the array does support the charset parameter,
   the flavors which share that MIME type will then be sorted by their
   representation classes in the following order:
   java.io.Reader, java.lang.String,
   java.nio.CharBuffer, [C, <all others>.

   If two or more flavors share the best representation class, and that
   representation is one of the four explicitly listed, then one of those
   flavors will be chosen non-deterministically. If, however, no flavor has
   one of the four specified representations, the flavors will then be
   sorted by their charsets. Unicode charsets, such as `UTF-16`, `UTF-8`,
   `UTF-16BE`, `UTF-16LE`, and their aliases, are considered best. After
   them, the platform default charset and its aliases are selected.
   `US-ASCII` and its aliases are worst. All other charsets are chosen in
   alphabetical order, but only charsets supported by this implementation
   of the Java platform will be considered.

   If two or more flavors share the best charset, the flavors will then
   again be sorted by their representation classes in the following order:
   java.io.InputStream, java.nio.ByteBuffer,
   [B, <all others>.

   If two or more flavors share the best representation class, or if no
   flavor has one of the three specified representations, then one of those
   flavors will be chosen non-deterministically.

  available-flavors - an array of available DataFlavors - `java.awt.datatransfer.DataFlavor[]`

  returns: the best (highest fidelity) flavor according to the rules
           specified above, or null,
           if availableFlavors is null,
           has zero length, or contains no text flavors - `java.awt.datatransfer.DataFlavor`"
  ([available-flavors]
    (DataFlavor/selectBestTextFlavor available-flavors)))

(defn get-reader-for-text
  "Gets a Reader for a text flavor, decoded, if necessary, for the expected
   charset (encoding). The supported representation classes are
   java.io.Reader, java.lang.String,
   java.nio.CharBuffer, [C,
   java.io.InputStream, java.nio.ByteBuffer,
   and [B.

   Because text flavors which do not support the charset parameter are
   encoded in a non-standard format, this method should not be called for
   such flavors. However, in order to maintain backward-compatibility,
   if this method is called for such a flavor, this method will treat the
   flavor as though it supports the charset parameter and attempt to
   decode it accordingly. See selectBestTextFlavor for a list
   of text flavors which do not support the charset parameter.

  transferable - the Transferable whose data will be requested in this flavor - `java.awt.datatransfer.Transferable`

  returns: a Reader to read the Transferable's
           data - `java.io.Reader`

  throws: java.lang.IllegalArgumentException - if the Transferable has null data"
  ([this transferable]
    (-> this (.getReaderForText transferable))))

(defn get-representation-class
  "Returns the Class which objects supporting this
   DataFlavor will return when this DataFlavor
   is requested.

  returns: the Class which objects supporting this
   DataFlavor will return when this DataFlavor
   is requested - `java.lang.Class<?>`"
  ([this]
    (-> this (.getRepresentationClass))))

(defn set-human-presentable-name
  "Sets the human presentable name for the data format that this
   DataFlavor represents. This name would be localized
   for different countries.

  human-presentable-name - the new human presentable name - `java.lang.String`"
  ([this human-presentable-name]
    (-> this (.setHumanPresentableName human-presentable-name))))

(defn get-mime-type
  "Returns the MIME type string for this DataFlavor.

  returns: the MIME type string for this flavor - `java.lang.String`"
  ([this]
    (-> this (.getMimeType))))

(defn representation-class-reader?
  "Returns whether the representation class for this
   DataFlavor is java.io.Reader or a subclass
   thereof.

  returns: `boolean`"
  ([this]
    (-> this (.isRepresentationClassReader))))

(defn get-sub-type
  "Returns the sub MIME type of this DataFlavor.

  returns: the Sub MIME type of this DataFlavor - `java.lang.String`"
  ([this]
    (-> this (.getSubType))))

(defn flavor-remote-object-type?
  "Returns true if the DataFlavor specified represents
   a remote object.

  returns: true if the DataFlavor specified represents
    a Remote Object - `boolean`"
  ([this]
    (-> this (.isFlavorRemoteObjectType))))

(defn representation-class-serializable?
  "Returns true if the representation class can be serialized.

  returns: true if the representation class can be serialized - `boolean`"
  ([this]
    (-> this (.isRepresentationClassSerializable))))

(defn get-human-presentable-name
  "Returns the human presentable name for the data format that this
   DataFlavor represents.  This name would be localized
   for different countries.

  returns: the human presentable name for the data format that this
      DataFlavor represents - `java.lang.String`"
  ([this]
    (-> this (.getHumanPresentableName))))

(defn to-string
  "String representation of this DataFlavor and its
   parameters. The resulting String contains the name of
   the DataFlavor class, this flavor's MIME type, and its
   representation class. If this flavor has a primary MIME type of `text`,
   supports the charset parameter, and has an encoded representation, the
   flavor's charset is also included. See selectBestTextFlavor
   for a list of text flavors which support the charset parameter.

  returns: string representation of this DataFlavor - `java.lang.String`"
  ([this]
    (-> this (.toString))))

(defn write-external
  "Serializes this DataFlavor.

  os - the stream to write the object to - `java.io.ObjectOutput`

  throws: java.io.IOException - Includes any I/O exceptions that may occur"
  ([this os]
    (-> this (.writeExternal os))))

(defn flavor-text-type?
  "Returns whether this DataFlavor is a valid text flavor for
   this implementation of the Java platform. Only flavors equivalent to
   DataFlavor.stringFlavor and DataFlavors with
   a primary MIME type of `text` can be valid text flavors.

   If this flavor supports the charset parameter, it must be equivalent to
   DataFlavor.stringFlavor, or its representation must be
   java.io.Reader, java.lang.String,
   java.nio.CharBuffer, [C,
   java.io.InputStream, java.nio.ByteBuffer, or
   [B. If the representation is
   java.io.InputStream, java.nio.ByteBuffer, or
   [B, then this flavor's charset parameter must
   be supported by this implementation of the Java platform. If a charset
   is not specified, then the platform default charset, which is always
   supported, is assumed.

   If this flavor does not support the charset parameter, its
   representation must be java.io.InputStream,
   java.nio.ByteBuffer, or [B.

   See selectBestTextFlavor for a list of text flavors which
   support the charset parameter.

  returns: true if this DataFlavor is a valid
           text flavor as described above; false otherwise - `boolean`"
  ([this]
    (-> this (.isFlavorTextType))))

(defn get-parameter
  "Returns the human presentable name for this DataFlavor
   if paramName equals `humanPresentableName`.  Otherwise
   returns the MIME type value associated with paramName.

  param-name - the parameter name requested - `java.lang.String`

  returns: the value of the name parameter, or null
    if there is no associated value - `java.lang.String`"
  ([this param-name]
    (-> this (.getParameter param-name))))

(defn get-default-representation-class-as-string
  "returns: `java.lang.String`"
  ([this]
    (-> this (.getDefaultRepresentationClassAsString))))

(defn get-primary-type
  "Returns the primary MIME type for this DataFlavor.

  returns: the primary MIME type of this DataFlavor - `java.lang.String`"
  ([this]
    (-> this (.getPrimaryType))))

(defn representation-class-char-buffer?
  "Returns whether the representation class for this
   DataFlavor is java.nio.CharBuffer or a
   subclass thereof.

  returns: `boolean`"
  ([this]
    (-> this (.isRepresentationClassCharBuffer))))

(defn flavor-java-file-list-type?
  "Returns true if the DataFlavor specified represents
   a list of file objects.

  returns: true if the DataFlavor specified represents
     a List of File objects - `boolean`"
  ([this]
    (-> this (.isFlavorJavaFileListType))))

(defn match
  "Identical to equals(DataFlavor).

  that - the DataFlavor to compare with this - `java.awt.datatransfer.DataFlavor`

  returns: true if that is equivalent to this
           DataFlavor; false otherwise - `boolean`"
  ([this that]
    (-> this (.match that))))

(defn flavor-serialized-object-type?
  "Returns true if the DataFlavor specified represents
   a serialized object.

  returns: true if the DataFlavor specified represents
     a Serialized Object - `boolean`"
  ([this]
    (-> this (.isFlavorSerializedObjectType))))

(defn get-default-representation-class
  "returns: `java.lang.Class<?>`"
  ([this]
    (-> this (.getDefaultRepresentationClass))))

(defn representation-class-byte-buffer?
  "Returns whether the representation class for this
   DataFlavor is java.nio.ByteBuffer or a
   subclass thereof.

  returns: `boolean`"
  ([this]
    (-> this (.isRepresentationClassByteBuffer))))

(defn clone
  "Returns a clone of this DataFlavor.

  returns: a clone of this DataFlavor - `java.lang.Object`

  throws: java.lang.CloneNotSupportedException - if the object's class does not support the Cloneable interface. Subclasses that override the clone method can also throw this exception to indicate that an instance cannot be cloned."
  ([this]
    (-> this (.clone))))

(defn hash-code
  "Returns hash code for this DataFlavor.
   For two equal DataFlavors, hash codes are equal.
   For the String
   that matches DataFlavor.equals(String), it is not
   guaranteed that DataFlavor's hash code is equal
   to the hash code of the String.

  returns: a hash code for this DataFlavor - `int`"
  ([this]
    (-> this (.hashCode))))

(defn representation-class-input-stream?
  "Does the DataFlavor represent a
   java.io.InputStream?

  returns: `boolean`"
  ([this]
    (-> this (.isRepresentationClassInputStream))))

(defn read-external
  "Restores this DataFlavor from a Serialized state.

  is - the stream to read data from in order to restore the object - `java.io.ObjectInput`

  throws: java.io.IOException - if I/O errors occur"
  ([this is]
    (-> this (.readExternal is))))

(defn mime-type-serialized-object?
  "Does the DataFlavor represent a serialized object?

  returns: `boolean`"
  ([this]
    (-> this (.isMimeTypeSerializedObject))))

(defn mime-type-equal?
  "Returns whether the string representation of the MIME type passed in
   is equivalent to the MIME type of this DataFlavor.
   Parameters are not included in the comparison.

  mime-type - the string representation of the MIME type - `java.lang.String`

  returns: true if the string representation of the MIME type passed in is
           equivalent to the MIME type of this DataFlavor;
           false otherwise - `boolean`

  throws: java.lang.NullPointerException - if mimeType is null"
  ([this mime-type]
    (-> this (.isMimeTypeEqual mime-type))))

(defn representation-class-remote?
  "Returns true if the representation class is Remote.

  returns: true if the representation class is Remote - `boolean`"
  ([this]
    (-> this (.isRepresentationClassRemote))))

(defn equals
  "Indicates whether some other object is `equal to` this one.

   The equals method implements an equivalence relation
   on non-null object references:

   It is reflexive: for any non-null reference value
       x, x.equals(x) should return
       true.
   It is symmetric: for any non-null reference values
       x and y, x.equals(y)
       should return true if and only if
       y.equals(x) returns true.
   It is transitive: for any non-null reference values
       x, y, and z, if
       x.equals(y) returns true and
       y.equals(z) returns true, then
       x.equals(z) should return true.
   It is consistent: for any non-null reference values
       x and y, multiple invocations of
       x.equals(y) consistently return true
       or consistently return false, provided no
       information used in equals comparisons on the
       objects is modified.
   For any non-null reference value x,
       x.equals(null) should return false.


   The equals method for class Object implements
   the most discriminating possible equivalence relation on objects;
   that is, for any non-null reference values x and
   y, this method returns true if and only
   if x and y refer to the same object
   (x == y has the value true).

   Note that it is generally necessary to override the hashCode
   method whenever this method is overridden, so as to maintain the
   general contract for the hashCode method, which states
   that equal objects must have equal hash codes.

   The equals comparison for the DataFlavor class is implemented
   as follows: Two DataFlavors are considered equal if and
   only if their MIME primary type and subtype and representation class are
   equal. Additionally, if the primary type is `text`, the subtype denotes
   a text flavor which supports the charset parameter, and the
   representation class is not java.io.Reader,
   java.lang.String, java.nio.CharBuffer, or
   [C, the charset parameter must also be equal.
   If a charset is not explicitly specified for one or both
   DataFlavors, the platform default encoding is assumed. See
   selectBestTextFlavor for a list of text flavors which
   support the charset parameter.

  o - the Object to compare with this - `java.lang.Object`

  returns: true if that is equivalent to this
           DataFlavor; false otherwise - `boolean`"
  ([this o]
    (-> this (.equals o))))

