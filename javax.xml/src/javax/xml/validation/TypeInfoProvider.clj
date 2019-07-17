(ns javax.xml.validation.TypeInfoProvider
  "This class provides access to the type information determined
  by ValidatorHandler.


  Some schema languages, such as W3C XML Schema, encourages a validator
  to report the `type` it assigns to each attribute/element.
  Those applications who wish to access this type information can invoke
  methods defined on this `interface` to access such type information.


  Implementation of this `interface` can be obtained through the
  ValidatorHandler.getTypeInfoProvider() method."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.validation TypeInfoProvider]))

(defn get-element-type-info
  "Returns the immutable TypeInfo object for the current
   element.

   The method may only be called by the startElement event
   or the endElement event
   of the ContentHandler that the application sets to
   the ValidatorHandler.

   When W3C XML Schema validation is being performed, in the
   case where an element has a union type, the TypeInfo
   returned by a call to getElementTypeInfo() from the
   startElement
   event will be the union type. The TypeInfo
   returned by a call
   from the endElement event will be the actual member type used
   to validate the element.

  returns: An immutable TypeInfo object that represents the
        type of the current element.
        Note that the caller can keep references to the obtained
        TypeInfo longer than the callback scope.

        Otherwise, this method returns
        null if the validator is unable to
        determine the type of the current element for some reason
        (for example, if the validator is recovering from
        an earlier error.) - `org.w3c.dom.TypeInfo`

  throws: java.lang.IllegalStateException - If this method is called from other ContentHandler methods."
  ([this]
    (-> this (.getElementTypeInfo))))

(defn get-attribute-type-info
  "Returns the immutable TypeInfo object for the specified
   attribute of the current element.


   The method may only be called by the startElement event of
   the ContentHandler that the application sets to the
   ValidatorHandler.

  index - The index of the attribute. The same index for the Attributes object passed to the startElement callback. - `int`

  returns: An immutable TypeInfo object that represents the
        type of the specified attribute.
        Note that the caller can keep references to the obtained
        TypeInfo longer than the callback scope.

        Otherwise, this method returns
        null if the validator is unable to
        determine the type. - `org.w3c.dom.TypeInfo`

  throws: java.lang.IndexOutOfBoundsException - If the index is invalid."
  ([this index]
    (-> this (.getAttributeTypeInfo index))))

(defn id-attribute?
  "Returns true if the specified attribute is determined
   to be ID.


   Exacly how an attribute is `determined to be ID` is up to the
   schema language. In case of W3C XML Schema, this means
   that the actual type of the attribute is the built-in ID type
   or its derived type.


   A DocumentBuilder uses this information
   to properly implement Attr.isId().


   The method may only be called by the startElement event of
   the ContentHandler that the application sets to the
   ValidatorHandler.

  index - The index of the attribute. The same index for the Attributes object passed to the startElement callback. - `int`

  returns: true
        if the type of the specified attribute is ID. - `boolean`

  throws: java.lang.IndexOutOfBoundsException - If the index is invalid."
  ([this index]
    (-> this (.isIdAttribute index))))

(defn specified?
  "Returns false if the attribute was added by the validator.


   This method provides information necessary for
   a DocumentBuilder to determine what
   the DOM tree should return from the Attr.getSpecified() method.


   The method may only be called by the startElement event of
   the ContentHandler that the application sets to the
   ValidatorHandler.


   A general guideline for validators is to return true if
   the attribute was originally present in the pipeline, and
   false if it was added by the validator.

  index - The index of the attribute. The same index for the Attributes object passed to the startElement callback. - `int`

  returns: true if the attribute was present before the validator
        processes input. false if the attribute was added
        by the validator. - `boolean`

  throws: java.lang.IndexOutOfBoundsException - If the index is invalid."
  ([this index]
    (-> this (.isSpecified index))))

