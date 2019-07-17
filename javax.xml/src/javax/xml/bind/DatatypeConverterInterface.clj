(ns javax.xml.bind.DatatypeConverterInterface
  " The DatatypeConverterInterface is for JAXB provider use only. A
  JAXB provider must supply a class that implements this interface.
  JAXB Providers are required to call the
  DatatypeConverter.setDatatypeConverter api at
  some point before the first marshal or unmarshal operation (perhaps during
  the call to JAXBContext.newInstance).  This step is necessary to configure
  the converter that should be used to perform the print and parse
  functionality.  Calling this api repeatedly will have no effect - the
  DatatypeConverter instance passed into the first invocation is the one that
  will be used from then on.



  This interface defines the parse and print methods. There is one
  parse and print method for each XML schema datatype specified in the
  the default binding Table 5-1 in the JAXB specification.



  The parse and print methods defined here are invoked by the static parse
  and print methods defined in the DatatypeConverter
  class.



  A parse method for a XML schema datatype must be capable of converting any
  lexical representation of the XML schema datatype ( specified by the
   XML Schema Part2: Datatypes
  specification into a value in the value space of the XML schema datatype.
  If an error is encountered during conversion, then an IllegalArgumentException
  or a subclass of IllegalArgumentException must be thrown by the method.




  A print method for a XML schema datatype can output any lexical
  representation that is valid with respect to the XML schema datatype.
  If an error is encountered during conversion, then an IllegalArgumentException,
  or a subclass of IllegalArgumentException must be thrown by the method.


  The prefix xsd: is used to refer to XML schema datatypes
   XML Schema Part2: Datatypes
  specification."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.bind DatatypeConverterInterface]))

(defn parse-base-64-binary
  "Converts the string argument into an array of bytes.

  lexical-xsd-base-64-binary - A string containing lexical representation of xsd:base64Binary. - `java.lang.String`

  returns: An array of bytes represented by the string argument. - `byte[]`

  throws: java.lang.IllegalArgumentException - if string parameter does not conform to lexical value space defined in XML Schema Part 2: Datatypes for xsd:base64Binary"
  ([^. this ^java.lang.String lexical-xsd-base-64-binary]
    (-> this (.parseBase64Binary lexical-xsd-base-64-binary))))

(defn parse-date-time
  "Converts the string argument into a Calendar value.

  lexical-xsd-date-time - A string containing lexical representation of xsd:datetime. - `java.lang.String`

  returns: A Calendar object represented by the string argument. - `java.util.Calendar`

  throws: java.lang.IllegalArgumentException - if string parameter does not conform to lexical value space defined in XML Schema Part 2: Datatypes for xsd:dateTime."
  ([^. this ^java.lang.String lexical-xsd-date-time]
    (-> this (.parseDateTime lexical-xsd-date-time))))

(defn print-unsigned-int
  "Converts a long value into a string.

  val - A long value - `long`

  returns: A string containing a lexical representation of xsd:unsignedInt - `java.lang.String`"
  ([^. this ^Long val]
    (-> this (.printUnsignedInt val))))

(defn print-q-name
  "Converts a QName instance into a string.

  val - A QName value - `javax.xml.namespace.QName`
  nsc - A namespace context for interpreting a prefix within a QName. - `javax.xml.namespace.NamespaceContext`

  returns: A string containing a lexical representation of QName - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if val is null or if nsc is non-null or nsc.getPrefix(nsprefixFromVal) is null."
  ([^. this ^javax.xml.namespace.QName val ^javax.xml.namespace.NamespaceContext nsc]
    (-> this (.printQName val nsc))))

(defn parse-q-name
  "Converts the string argument into a QName value.


   String parameter lexicalXSDQname must conform to lexical value space specifed at
   XML Schema Part 2:Datatypes specification:QNames

  lexical-xsdq-name - A string containing lexical representation of xsd:QName. - `java.lang.String`
  nsc - A namespace context for interpreting a prefix within a QName. - `javax.xml.namespace.NamespaceContext`

  returns: A QName value represented by the string argument. - `javax.xml.namespace.QName`

  throws: java.lang.IllegalArgumentException - if string parameter does not conform to XML Schema Part 2 specification or if namespace prefix of lexicalXSDQname is not bound to a URI in NamespaceContext nsc."
  ([^. this ^java.lang.String lexical-xsdq-name ^javax.xml.namespace.NamespaceContext nsc]
    (-> this (.parseQName lexical-xsdq-name nsc))))

(defn print-time
  "Converts a Calendar value into a string.

  val - A Calendar value - `java.util.Calendar`

  returns: A string containing a lexical representation of xsd:time - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if val is null."
  ([^. this ^java.util.Calendar val]
    (-> this (.printTime val))))

(defn print-short
  "Converts a short value into a string.

  val - A short value - `short`

  returns: A string containing a lexical representation of xsd:short - `java.lang.String`"
  ([^. this ^Short val]
    (-> this (.printShort val))))

(defn print-any-simple-type
  "Converts a string value into a string.

  val - A string value - `java.lang.String`

  returns: A string containing a lexical representation of xsd:AnySimpleType - `java.lang.String`"
  ([^. this ^java.lang.String val]
    (-> this (.printAnySimpleType val))))

(defn parse-string
  "Convert the string argument into a string.

  lexical-xsd-string - A lexical representation of the XML Schema datatype xsd:string - `java.lang.String`

  returns: A string that is the same as the input string. - `java.lang.String`"
  ([^. this ^java.lang.String lexical-xsd-string]
    (-> this (.parseString lexical-xsd-string))))

(defn parse-short
  "Converts the string argument into a short value.

  lexical-xsd-short - A string containing lexical representation of xsd:short. - `java.lang.String`

  returns: A short value represented by the string argument. - `short`

  throws: java.lang.NumberFormatException - lexicalXSDShort is not a valid string representation of a short value."
  ([^. this ^java.lang.String lexical-xsd-short]
    (-> this (.parseShort lexical-xsd-short))))

(defn parse-time
  "Converts the string argument into a Calendar value.

  lexical-xsd-time - A string containing lexical representation of xsd:Time. - `java.lang.String`

  returns: A Calendar value represented by the string argument. - `java.util.Calendar`

  throws: java.lang.IllegalArgumentException - if string parameter does not conform to lexical value space defined in XML Schema Part 2: Datatypes for xsd:Time."
  ([^. this ^java.lang.String lexical-xsd-time]
    (-> this (.parseTime lexical-xsd-time))))

(defn parse-hex-binary
  "Converts the string argument into an array of bytes.

  lexical-xsd-hex-binary - A string containing lexical representation of xsd:hexBinary. - `java.lang.String`

  returns: An array of bytes represented by the string argument. - `byte[]`

  throws: java.lang.IllegalArgumentException - if string parameter does not conform to lexical value space defined in XML Schema Part 2: Datatypes for xsd:hexBinary."
  ([^. this ^java.lang.String lexical-xsd-hex-binary]
    (-> this (.parseHexBinary lexical-xsd-hex-binary))))

(defn print-unsigned-short
  "Converts an int value into a string.

  val - An int value - `int`

  returns: A string containing a lexical representation of xsd:unsignedShort - `java.lang.String`"
  ([^. this ^Integer val]
    (-> this (.printUnsignedShort val))))

(defn parse-float
  "Converts the string argument into a float value.

  lexical-xsd-float - A string containing lexical representation of xsd:float. - `java.lang.String`

  returns: A float value represented by the string argument. - `float`

  throws: java.lang.NumberFormatException - lexicalXSDFloat is not a valid string representation of a float value."
  ([^. this ^java.lang.String lexical-xsd-float]
    (-> this (.parseFloat lexical-xsd-float))))

(defn print-base-64-binary
  "Converts an array of bytes into a string.

  val - an array of bytes - `byte[]`

  returns: A string containing a lexical representation of xsd:base64Binary - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if val is null."
  ([^. this val]
    (-> this (.printBase64Binary val))))

(defn parse-date
  "Converts the string argument into a Calendar value.

  lexical-xsd-date - A string containing lexical representation of xsd:Date. - `java.lang.String`

  returns: A Calendar value represented by the string argument. - `java.util.Calendar`

  throws: java.lang.IllegalArgumentException - if string parameter does not conform to lexical value space defined in XML Schema Part 2: Datatypes for xsd:Date."
  ([^. this ^java.lang.String lexical-xsd-date]
    (-> this (.parseDate lexical-xsd-date))))

(defn parse-integer
  "Convert the string argument into a BigInteger value.

  lexical-xsd-integer - A string containing a lexical representation of xsd:integer. - `java.lang.String`

  returns: A BigInteger value represented by the string argument. - `java.math.BigInteger`

  throws: java.lang.NumberFormatException - lexicalXSDInteger is not a valid string representation of a BigInteger value."
  ([^. this ^java.lang.String lexical-xsd-integer]
    (-> this (.parseInteger lexical-xsd-integer))))

(defn print-string
  "Converts the string argument into a string.

  val - A string value. - `java.lang.String`

  returns: A string containing a lexical representation of xsd:string - `java.lang.String`"
  ([^. this ^java.lang.String val]
    (-> this (.printString val))))

(defn parse-decimal
  "Converts the string argument into a BigDecimal value.

  lexical-xsd-decimal - A string containing lexical representation of xsd:decimal. - `java.lang.String`

  returns: A BigDecimal value represented by the string argument. - `java.math.BigDecimal`

  throws: java.lang.NumberFormatException - lexicalXSDDecimal is not a valid string representation of BigDecimal."
  ([^. this ^java.lang.String lexical-xsd-decimal]
    (-> this (.parseDecimal lexical-xsd-decimal))))

(defn print-decimal
  "Converts a BigDecimal value into a string.

  val - A BigDecimal value - `java.math.BigDecimal`

  returns: A string containing a lexical representation of xsd:decimal - `java.lang.String`

  throws: java.lang.IllegalArgumentException - val is null."
  ([^. this ^java.math.BigDecimal val]
    (-> this (.printDecimal val))))

(defn print-date-time
  "Converts a Calendar value into a string.

  val - A Calendar value - `java.util.Calendar`

  returns: A string containing a lexical representation of xsd:dateTime - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if val is null."
  ([^. this ^java.util.Calendar val]
    (-> this (.printDateTime val))))

(defn print-date
  "Converts a Calendar value into a string.

  val - A Calendar value - `java.util.Calendar`

  returns: A string containing a lexical representation of xsd:date - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if val is null."
  ([^. this ^java.util.Calendar val]
    (-> this (.printDate val))))

(defn print-long
  "Converts a long value into a string.

  val - A long value - `long`

  returns: A string containing a lexical representation of xsd:long - `java.lang.String`"
  ([^. this ^Long val]
    (-> this (.printLong val))))

(defn print-float
  "Converts a float value into a string.

  val - A float value - `float`

  returns: A string containing a lexical representation of xsd:float - `java.lang.String`"
  ([^. this ^Float val]
    (-> this (.printFloat val))))

(defn print-byte
  "Converts a byte value into a string.

  val - A byte value - `byte`

  returns: A string containing a lexical representation of xsd:byte - `java.lang.String`"
  ([^. this ^Byte val]
    (-> this (.printByte val))))

(defn parse-boolean
  "Converts the string argument into a boolean value.

  lexical-xsd-boolean - A string containing lexical representation of xsd:boolean. - `java.lang.String`

  returns: A boolean value represented by the string argument. - `boolean`

  throws: java.lang.IllegalArgumentException - if string parameter does not conform to lexical value space defined in XML Schema Part 2: Datatypes for xsd:boolean."
  ([^. this ^java.lang.String lexical-xsd-boolean]
    (-> this (.parseBoolean lexical-xsd-boolean))))

(defn print-integer
  "Converts a BigInteger value into a string.

  val - A BigInteger value - `java.math.BigInteger`

  returns: A string containing a lexical representation of xsd:integer - `java.lang.String`

  throws: java.lang.IllegalArgumentException - val is null."
  ([^. this ^java.math.BigInteger val]
    (-> this (.printInteger val))))

(defn parse-double
  "Converts the string argument into a double value.

  lexical-xsd-double - A string containing lexical representation of xsd:double. - `java.lang.String`

  returns: A double value represented by the string argument. - `double`

  throws: java.lang.NumberFormatException - lexicalXSDDouble is not a valid string representation of a double value."
  ([^. this ^java.lang.String lexical-xsd-double]
    (-> this (.parseDouble lexical-xsd-double))))

(defn parse-long
  "Converts the string argument into a long value.

  lexical-xsd-long - A string containing lexical representation of xsd:long. - `java.lang.String`

  returns: A long value represented by the string argument. - `long`

  throws: java.lang.NumberFormatException - lexicalXSDLong is not a valid string representation of a long value."
  ([^. this ^java.lang.String lexical-xsd-long]
    (-> this (.parseLong lexical-xsd-long))))

(defn print-int
  "Converts an int value into a string.

  val - An int value - `int`

  returns: A string containing a lexical representation of xsd:int - `java.lang.String`"
  ([^. this ^Integer val]
    (-> this (.printInt val))))

(defn parse-any-simple-type
  "Return a string containing the lexical representation of the
   simple type.

  lexical-xsd-any-simple-type - A string containing lexical representation of the simple type. - `java.lang.String`

  returns: A string containing the lexical representation of the
       simple type. - `java.lang.String`"
  ([^. this ^java.lang.String lexical-xsd-any-simple-type]
    (-> this (.parseAnySimpleType lexical-xsd-any-simple-type))))

(defn print-double
  "Converts a double value into a string.

  val - A double value - `double`

  returns: A string containing a lexical representation of xsd:double - `java.lang.String`"
  ([^. this ^Double val]
    (-> this (.printDouble val))))

(defn parse-unsigned-short
  "Converts the string argument into an int value.

  lexical-xsd-unsigned-short - A string containing lexical representation of xsd:unsignedShort. - `java.lang.String`

  returns: An int value represented by the string argument. - `int`

  throws: java.lang.NumberFormatException - if string parameter can not be parsed into an int value."
  ([^. this ^java.lang.String lexical-xsd-unsigned-short]
    (-> this (.parseUnsignedShort lexical-xsd-unsigned-short))))

(defn parse-byte
  "Converts the string argument into a byte value.

  lexical-xsd-byte - A string containing lexical representation of xsd:byte. - `java.lang.String`

  returns: A byte value represented by the string argument. - `byte`

  throws: java.lang.NumberFormatException - lexicalXSDByte does not contain a parseable byte."
  ([^. this ^java.lang.String lexical-xsd-byte]
    (-> this (.parseByte lexical-xsd-byte))))

(defn print-boolean
  "Converts a boolean value into a string.

  val - A boolean value - `boolean`

  returns: A string containing a lexical representation of xsd:boolean - `java.lang.String`"
  ([^. this ^Boolean val]
    (-> this (.printBoolean val))))

(defn print-hex-binary
  "Converts an array of bytes into a string.

  val - an array of bytes - `byte[]`

  returns: A string containing a lexical representation of xsd:hexBinary - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if val is null."
  ([^. this val]
    (-> this (.printHexBinary val))))

(defn parse-unsigned-int
  "Converts the string argument into a long value.

  lexical-xsd-unsigned-int - A string containing lexical representation of xsd:unsignedInt. - `java.lang.String`

  returns: A long value represented by the string argument. - `long`

  throws: java.lang.NumberFormatException - if string parameter can not be parsed into a long value."
  ([^. this ^java.lang.String lexical-xsd-unsigned-int]
    (-> this (.parseUnsignedInt lexical-xsd-unsigned-int))))

(defn parse-int
  "Convert the string argument into an int value.

  lexical-xsd-int - A string containing a lexical representation of xsd:int. - `java.lang.String`

  returns: An int value represented byte the string argument. - `int`

  throws: java.lang.NumberFormatException - lexicalXSDInt is not a valid string representation of an int value."
  ([^. this ^java.lang.String lexical-xsd-int]
    (-> this (.parseInt lexical-xsd-int))))

