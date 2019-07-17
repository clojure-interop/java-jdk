(ns javax.xml.bind.DatatypeConverter
  " The javaType binding declaration can be used to customize the binding of
  an XML schema datatype to a Java datatype. Customizations can involve
  writing a parse and print method for parsing and printing lexical
  representations of a XML schema datatype respectively. However, writing
  parse and print methods requires knowledge of the lexical representations (
   XML Schema Part2: Datatypes
  specification ) and hence may be difficult to write.


  This class makes it easier to write parse and print methods. It defines
  static parse and print methods that provide access to a JAXB provider's
  implementation of parse and print methods. These methods are invoked by
  custom parse and print methods. For example, the binding of xsd:dateTime
  to a long can be customized using parse and print methods as follows:



     // Customized parse method
     public long myParseCal( String dateTimeString ) {
         java.util.Calendar cal = DatatypeConverter.parseDateTime(dateTimeString);
         long longval = convert_calendar_to_long(cal); //application specific
         return longval;
     }

     // Customized print method
     public String myPrintCal( Long longval ) {
         java.util.Calendar cal = convert_long_to_calendar(longval) ; //application specific
         String dateTimeString = DatatypeConverter.printDateTime(cal);
         return dateTimeString;
     }


  There is a static parse and print method corresponding to each parse and
  print method respectively in the DatatypeConverterInterface.

  The static methods defined in the class can also be used to specify
  a parse or a print method in a javaType binding declaration.


  JAXB Providers are required to call the
  setDatatypeConverter api at some point before the first marshal or unmarshal
  operation (perhaps during the call to JAXBContext.newInstance).  This step is
  necessary to configure the converter that should be used to perform the
  print and parse functionality.



  A print method for a XML schema datatype can output any lexical
  representation that is valid with respect to the XML schema datatype.
  If an error is encountered during conversion, then an IllegalArgumentException,
  or a subclass of IllegalArgumentException must be thrown by the method."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.bind DatatypeConverter]))

(defn *parse-base-64-binary
  "Converts the string argument into an array of bytes.

  lexical-xsd-base-64-binary - A string containing lexical representation of xsd:base64Binary. - `java.lang.String`

  returns: An array of bytes represented by the string argument. - `byte[]`

  throws: java.lang.IllegalArgumentException - if string parameter does not conform to lexical value space defined in XML Schema Part 2: Datatypes for xsd:base64Binary"
  ([lexical-xsd-base-64-binary]
    (DatatypeConverter/parseBase64Binary lexical-xsd-base-64-binary)))

(defn *parse-date-time
  "Converts the string argument into a Calendar value.

  lexical-xsd-date-time - A string containing lexical representation of xsd:datetime. - `java.lang.String`

  returns: A Calendar object represented by the string argument. - `java.util.Calendar`

  throws: java.lang.IllegalArgumentException - if string parameter does not conform to lexical value space defined in XML Schema Part 2: Datatypes for xsd:dateTime."
  ([lexical-xsd-date-time]
    (DatatypeConverter/parseDateTime lexical-xsd-date-time)))

(defn *print-unsigned-int
  "Converts a long value into a string.

  val - A long value - `long`

  returns: A string containing a lexical representation of xsd:unsignedInt - `java.lang.String`"
  ([val]
    (DatatypeConverter/printUnsignedInt val)))

(defn *print-q-name
  "Converts a QName instance into a string.

  val - A QName value - `javax.xml.namespace.QName`
  nsc - A namespace context for interpreting a prefix within a QName. - `javax.xml.namespace.NamespaceContext`

  returns: A string containing a lexical representation of QName - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if val is null or if nsc is non-null or nsc.getPrefix(nsprefixFromVal) is null."
  ([val nsc]
    (DatatypeConverter/printQName val nsc)))

(defn *parse-q-name
  "Converts the string argument into a byte value.


   String parameter lexicalXSDQname must conform to lexical value space specifed at
   XML Schema Part 2:Datatypes specification:QNames

  lexical-xsdq-name - A string containing lexical representation of xsd:QName. - `java.lang.String`
  nsc - A namespace context for interpreting a prefix within a QName. - `javax.xml.namespace.NamespaceContext`

  returns: A QName value represented by the string argument. - `javax.xml.namespace.QName`

  throws: java.lang.IllegalArgumentException - if string parameter does not conform to XML Schema Part 2 specification or if namespace prefix of lexicalXSDQname is not bound to a URI in NamespaceContext nsc."
  ([lexical-xsdq-name nsc]
    (DatatypeConverter/parseQName lexical-xsdq-name nsc)))

(defn *print-time
  "Converts a Calendar value into a string.

  val - A Calendar value - `java.util.Calendar`

  returns: A string containing a lexical representation of xsd:time - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if val is null."
  ([val]
    (DatatypeConverter/printTime val)))

(defn *print-short
  "Converts a short value into a string.

  val - A short value - `short`

  returns: A string containing a lexical representation of xsd:short - `java.lang.String`"
  ([val]
    (DatatypeConverter/printShort val)))

(defn *print-any-simple-type
  "Converts a string value into a string.

  val - A string value - `java.lang.String`

  returns: A string containing a lexical representation of xsd:AnySimpleType - `java.lang.String`"
  ([val]
    (DatatypeConverter/printAnySimpleType val)))

(defn *parse-string
  "Convert the lexical XSD string argument into a String value.

  lexical-xsd-string - A string containing a lexical representation of xsd:string. - `java.lang.String`

  returns: A String value represented by the string argument. - `java.lang.String`"
  ([lexical-xsd-string]
    (DatatypeConverter/parseString lexical-xsd-string)))

(defn *parse-short
  "Converts the string argument into a short value.

  lexical-xsd-short - A string containing lexical representation of xsd:short. - `java.lang.String`

  returns: A short value represented by the string argument. - `short`

  throws: java.lang.NumberFormatException - lexicalXSDShort is not a valid string representation of a short value."
  ([lexical-xsd-short]
    (DatatypeConverter/parseShort lexical-xsd-short)))

(defn *parse-time
  "Converts the string argument into a Calendar value.

  lexical-xsd-time - A string containing lexical representation of xsd:time. - `java.lang.String`

  returns: A Calendar value represented by the string argument. - `java.util.Calendar`

  throws: java.lang.IllegalArgumentException - if string parameter does not conform to lexical value space defined in XML Schema Part 2: Datatypes for xsd:Time."
  ([lexical-xsd-time]
    (DatatypeConverter/parseTime lexical-xsd-time)))

(defn *parse-hex-binary
  "Converts the string argument into an array of bytes.

  lexical-xsd-hex-binary - A string containing lexical representation of xsd:hexBinary. - `java.lang.String`

  returns: An array of bytes represented by the string argument. - `byte[]`

  throws: java.lang.IllegalArgumentException - if string parameter does not conform to lexical value space defined in XML Schema Part 2: Datatypes for xsd:hexBinary."
  ([lexical-xsd-hex-binary]
    (DatatypeConverter/parseHexBinary lexical-xsd-hex-binary)))

(defn *print-unsigned-short
  "Converts an int value into a string.

  val - An int value - `int`

  returns: A string containing a lexical representation of xsd:unsignedShort - `java.lang.String`"
  ([val]
    (DatatypeConverter/printUnsignedShort val)))

(defn *parse-float
  "Converts the string argument into a float value.

  lexical-xsd-float - A string containing lexical representation of xsd:float. - `java.lang.String`

  returns: A float value represented by the string argument. - `float`

  throws: java.lang.NumberFormatException - lexicalXSDFloat is not a valid string representation of a float value."
  ([lexical-xsd-float]
    (DatatypeConverter/parseFloat lexical-xsd-float)))

(defn *print-base-64-binary
  "Converts an array of bytes into a string.

  val - An array of bytes - `byte[]`

  returns: A string containing a lexical representation of xsd:base64Binary - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if val is null."
  ([val]
    (DatatypeConverter/printBase64Binary val)))

(defn *parse-date
  "Converts the string argument into a Calendar value.

  lexical-xsd-date - A string containing lexical representation of xsd:Date. - `java.lang.String`

  returns: A Calendar value represented by the string argument. - `java.util.Calendar`

  throws: java.lang.IllegalArgumentException - if string parameter does not conform to lexical value space defined in XML Schema Part 2: Datatypes for xsd:Date."
  ([lexical-xsd-date]
    (DatatypeConverter/parseDate lexical-xsd-date)))

(defn *parse-integer
  "Convert the string argument into a BigInteger value.

  lexical-xsd-integer - A string containing a lexical representation of xsd:integer. - `java.lang.String`

  returns: A BigInteger value represented by the string argument. - `java.math.BigInteger`

  throws: java.lang.NumberFormatException - lexicalXSDInteger is not a valid string representation of a BigInteger value."
  ([lexical-xsd-integer]
    (DatatypeConverter/parseInteger lexical-xsd-integer)))

(defn *print-string
  "Converts the string argument into a string.

  val - A string value. - `java.lang.String`

  returns: A string containing a lexical representation of xsd:string. - `java.lang.String`"
  ([val]
    (DatatypeConverter/printString val)))

(defn *parse-decimal
  "Converts the string argument into a BigDecimal value.

  lexical-xsd-decimal - A string containing lexical representation of xsd:decimal. - `java.lang.String`

  returns: A BigDecimal value represented by the string argument. - `java.math.BigDecimal`

  throws: java.lang.NumberFormatException - lexicalXSDDecimal is not a valid string representation of BigDecimal."
  ([lexical-xsd-decimal]
    (DatatypeConverter/parseDecimal lexical-xsd-decimal)))

(defn *print-decimal
  "Converts a BigDecimal value into a string.

  val - A BigDecimal value - `java.math.BigDecimal`

  returns: A string containing a lexical representation of xsd:decimal - `java.lang.String`

  throws: java.lang.IllegalArgumentException - val is null."
  ([val]
    (DatatypeConverter/printDecimal val)))

(defn *print-date-time
  "Converts a Calendar value into a string.

  val - A Calendar value - `java.util.Calendar`

  returns: A string containing a lexical representation of xsd:dateTime - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if val is null."
  ([val]
    (DatatypeConverter/printDateTime val)))

(defn *print-date
  "Converts a Calendar value into a string.

  val - A Calendar value - `java.util.Calendar`

  returns: A string containing a lexical representation of xsd:date - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if val is null."
  ([val]
    (DatatypeConverter/printDate val)))

(defn *set-datatype-converter
  "This method is for JAXB provider use only.

   JAXB Providers are required to call this method at some point before
   allowing any of the JAXB client marshal or unmarshal operations to
   occur.  This is necessary to configure the datatype converter that
   should be used to perform the print and parse conversions.


   Calling this api repeatedly will have no effect - the
   DatatypeConverterInterface instance passed into the first invocation is
   the one that will be used from then on.

  converter - an instance of a class that implements the DatatypeConverterInterface class - this parameter must not be null. - `javax.xml.bind.DatatypeConverterInterface`

  throws: java.lang.IllegalArgumentException - if the parameter is null"
  ([converter]
    (DatatypeConverter/setDatatypeConverter converter)))

(defn *print-long
  "Converts A long value into a string.

  val - A long value - `long`

  returns: A string containing a lexical representation of xsd:long - `java.lang.String`"
  ([val]
    (DatatypeConverter/printLong val)))

(defn *print-float
  "Converts a float value into a string.

  val - A float value - `float`

  returns: A string containing a lexical representation of xsd:float - `java.lang.String`"
  ([val]
    (DatatypeConverter/printFloat val)))

(defn *print-byte
  "Converts a byte value into a string.

  val - A byte value - `byte`

  returns: A string containing a lexical representation of xsd:byte - `java.lang.String`"
  ([val]
    (DatatypeConverter/printByte val)))

(defn *parse-boolean
  "Converts the string argument into a boolean value.

  lexical-xsd-boolean - A string containing lexical representation of xsd:boolean. - `java.lang.String`

  returns: A boolean value represented by the string argument. - `boolean`

  throws: java.lang.IllegalArgumentException - if string parameter does not conform to lexical value space defined in XML Schema Part 2: Datatypes for xsd:boolean."
  ([lexical-xsd-boolean]
    (DatatypeConverter/parseBoolean lexical-xsd-boolean)))

(defn *print-integer
  "Converts a BigInteger value into a string.

  val - A BigInteger value - `java.math.BigInteger`

  returns: A string containing a lexical representation of xsd:integer - `java.lang.String`

  throws: java.lang.IllegalArgumentException - val is null."
  ([val]
    (DatatypeConverter/printInteger val)))

(defn *parse-double
  "Converts the string argument into a double value.

  lexical-xsd-double - A string containing lexical representation of xsd:double. - `java.lang.String`

  returns: A double value represented by the string argument. - `double`

  throws: java.lang.NumberFormatException - lexicalXSDDouble is not a valid string representation of a double value."
  ([lexical-xsd-double]
    (DatatypeConverter/parseDouble lexical-xsd-double)))

(defn *parse-long
  "Converts the string argument into a long value.

  lexical-xsd-long - A string containing lexical representation of xsd:long. - `java.lang.String`

  returns: A long value represented by the string argument. - `long`

  throws: java.lang.NumberFormatException - lexicalXSDLong is not a valid string representation of a long value."
  ([lexical-xsd-long]
    (DatatypeConverter/parseLong lexical-xsd-long)))

(defn *print-int
  "Converts an int value into a string.

  val - An int value - `int`

  returns: A string containing a lexical representation of xsd:int - `java.lang.String`"
  ([val]
    (DatatypeConverter/printInt val)))

(defn *parse-any-simple-type
  "Return a string containing the lexical representation of the
   simple type.

  lexical-xsd-any-simple-type - A string containing lexical representation of the simple type. - `java.lang.String`

  returns: A string containing the lexical representation of the
       simple type. - `java.lang.String`"
  ([lexical-xsd-any-simple-type]
    (DatatypeConverter/parseAnySimpleType lexical-xsd-any-simple-type)))

(defn *print-double
  "Converts a double value into a string.

  val - A double value - `double`

  returns: A string containing a lexical representation of xsd:double - `java.lang.String`"
  ([val]
    (DatatypeConverter/printDouble val)))

(defn *parse-unsigned-short
  "Converts the string argument into an int value.

  lexical-xsd-unsigned-short - A string containing lexical representation of xsd:unsignedShort. - `java.lang.String`

  returns: An int value represented by the string argument. - `int`

  throws: java.lang.NumberFormatException - if string parameter can not be parsed into an int value."
  ([lexical-xsd-unsigned-short]
    (DatatypeConverter/parseUnsignedShort lexical-xsd-unsigned-short)))

(defn *parse-byte
  "Converts the string argument into a byte value.

  lexical-xsd-byte - A string containing lexical representation of xsd:byte. - `java.lang.String`

  returns: A byte value represented by the string argument. - `byte`

  throws: java.lang.IllegalArgumentException - if string parameter does not conform to lexical value space defined in XML Schema Part 2: Datatypes for xsd:byte."
  ([lexical-xsd-byte]
    (DatatypeConverter/parseByte lexical-xsd-byte)))

(defn *print-boolean
  "Converts a boolean value into a string.

  val - A boolean value - `boolean`

  returns: A string containing a lexical representation of xsd:boolean - `java.lang.String`"
  ([val]
    (DatatypeConverter/printBoolean val)))

(defn *print-hex-binary
  "Converts an array of bytes into a string.

  val - An array of bytes - `byte[]`

  returns: A string containing a lexical representation of xsd:hexBinary - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if val is null."
  ([val]
    (DatatypeConverter/printHexBinary val)))

(defn *parse-unsigned-int
  "Converts the string argument into a long value.

  lexical-xsd-unsigned-int - A string containing lexical representation of xsd:unsignedInt. - `java.lang.String`

  returns: A long value represented by the string argument. - `long`

  throws: java.lang.NumberFormatException - if string parameter can not be parsed into a long value."
  ([lexical-xsd-unsigned-int]
    (DatatypeConverter/parseUnsignedInt lexical-xsd-unsigned-int)))

(defn *parse-int
  "Convert the string argument into an int value.

  lexical-xsd-int - A string containing a lexical representation of xsd:int. - `java.lang.String`

  returns: A int value represented by the string argument. - `int`

  throws: java.lang.NumberFormatException - lexicalXSDInt is not a valid string representation of an int value."
  ([lexical-xsd-int]
    (DatatypeConverter/parseInt lexical-xsd-int)))

