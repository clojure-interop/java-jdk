(ns javax.xml.datatype.DatatypeFactory
  "Factory that creates new javax.xml.datatype Objects that map XML to/from Java Objects.

  A new instance of the DatatypeFactory is created through the newInstance() method
  that uses the following implementation resolution mechanisms to determine an implementation:


       If the system property specified by DATATYPEFACTORY_PROPERTY, `javax.xml.datatype.DatatypeFactory`,
       exists, a class with the name of the property value is instantiated.
       Any Exception thrown during the instantiation process is wrapped as a DatatypeConfigurationException.


       If the file ${JAVA_HOME}/lib/jaxp.properties exists, it is loaded in a Properties Object.
       The Properties Object  is then queried for the property as documented in the prior step
       and processed as documented in the prior step.


      Uses the service-provider loading facilities, defined by the ServiceLoader class, to attempt
      to locate and load an implementation of the service using the default loading mechanism:
      the service-provider loading facility will use the current thread's context class loader
      to attempt to load the service. If the context class
      loader is null, the system class loader will be used.

      In case of service
      configuration error a DatatypeConfigurationException
      will be thrown.


       The final mechanism is to attempt to instantiate the Class specified by
       DATATYPEFACTORY_IMPLEMENTATION_CLASS.
       Any Exception thrown during the instantiation process is wrapped as a DatatypeConfigurationException."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.datatype DatatypeFactory]))

(def *-datatypefactory-property
  "Static Constant.

  Default property name as defined in JSR 206: Java(TM) API for XML Processing (JAXP) 1.3.

   Default value is javax.xml.datatype.DatatypeFactory.

  type: java.lang.String"
  DatatypeFactory/DATATYPEFACTORY_PROPERTY)

(def *-datatypefactory-implementation-class
  "Static Constant.

  Default implementation class name as defined in
   JSR 206: Java(TM) API for XML Processing (JAXP) 1.3.

   Implementers should specify the name of an appropriate class
   to be instantiated if no other implementation resolution mechanism
   succeeds.

   Users should not refer to this field; it is intended only to
   document a factory implementation detail.

  type: java.lang.String"
  DatatypeFactory/DATATYPEFACTORY_IMPLEMENTATION_CLASS)

(defn *new-instance
  "Obtain a new instance of a DatatypeFactory from class name.
   This function is useful when there are multiple providers in the classpath.
   It gives more control to the application as it can specify which provider
   should be loaded.

   Once an application has obtained a reference to a DatatypeFactory
   it can use the factory to configure and obtain datatype instances.


   Tip for Trouble-shooting
   Setting the jaxp.debug system property will cause
   this method to print a lot of debug messages
   to System.err about what it is doing and where it is looking at.

    If you have problems try:


   java -Djaxp.debug=1 YourProgram ....

  factory-class-name - fully qualified factory class name that provides implementation of javax.xml.datatype.DatatypeFactory. - `java.lang.String`
  class-loader - ClassLoader used to load the factory class. If null current Thread's context classLoader is used to load the factory class. - `java.lang.ClassLoader`

  returns: New instance of a DatatypeFactory - `javax.xml.datatype.DatatypeFactory`

  throws: javax.xml.datatype.DatatypeConfigurationException - if factoryClassName is null, or the factory class cannot be loaded, instantiated."
  (^javax.xml.datatype.DatatypeFactory [^java.lang.String factory-class-name ^java.lang.ClassLoader class-loader]
    (DatatypeFactory/newInstance factory-class-name class-loader))
  (^javax.xml.datatype.DatatypeFactory []
    (DatatypeFactory/newInstance )))

(defn new-duration
  "Obtain a new instance of a Duration
   specifying the Duration as isPositive, years, months, days, hours, minutes, seconds.

   The XML Schema specification states that values can be of an arbitrary size.
   Implementations may chose not to or be incapable of supporting arbitrarily large and/or small values.
   An UnsupportedOperationException will be thrown with a message indicating implementation limits
   if implementation capacities are exceeded.

   A null value indicates that field is not set.

  is-positive - Set to false to create a negative duration. When the length of the duration is zero, this parameter will be ignored. - `boolean`
  years - of this Duration - `java.math.BigInteger`
  months - of this Duration - `java.math.BigInteger`
  days - of this Duration - `java.math.BigInteger`
  hours - of this Duration - `java.math.BigInteger`
  minutes - of this Duration - `java.math.BigInteger`
  seconds - of this Duration - `java.math.BigDecimal`

  returns: New Duration created from the specified values. - `javax.xml.datatype.Duration`

  throws: java.lang.IllegalArgumentException - If the values are not a valid representation of a Duration: if all the fields (years, months, ...) are null or if any of the fields is negative."
  (^javax.xml.datatype.Duration [^DatatypeFactory this ^Boolean is-positive ^java.math.BigInteger years ^java.math.BigInteger months ^java.math.BigInteger days ^java.math.BigInteger hours ^java.math.BigInteger minutes ^java.math.BigDecimal seconds]
    (-> this (.newDuration is-positive years months days hours minutes seconds)))
  (^javax.xml.datatype.Duration [^DatatypeFactory this ^java.lang.String lexical-representation]
    (-> this (.newDuration lexical-representation))))

(defn new-duration-day-time
  "Create a Duration of type xdt:dayTimeDuration using the specified
   day, hour, minute and second as defined in

     XQuery 1.0 and XPath 2.0 Data Model, xdt:dayTimeDuration.

   The datatype xdt:dayTimeDuration is a subtype of xs:duration
   whose lexical representation contains only day, hour, minute, and second components.
   This datatype resides in the namespace http://www.w3.org/2003/11/xpath-datatypes.

   The XML Schema specification states that values can be of an arbitrary size.
   Implementations may chose not to or be incapable of supporting arbitrarily large and/or small values.
   An UnsupportedOperationException will be thrown with a message indicating implementation limits
   if implementation capacities are exceeded.

   A null value indicates that field is not set.

  is-positive - Set to false to create a negative duration. When the length of the duration is zero, this parameter will be ignored. - `boolean`
  day - Day of Duration. - `java.math.BigInteger`
  hour - Hour of Duration. - `java.math.BigInteger`
  minute - Minute of Duration. - `java.math.BigInteger`
  second - Second of Duration. - `java.math.BigInteger`

  returns: New Duration created with the specified day, hour, minute
   and second. - `javax.xml.datatype.Duration`

  throws: java.lang.IllegalArgumentException - If the values are not a valid representation of a Duration: if all the fields (day, hour, ...) are null or if any of the fields is negative."
  (^javax.xml.datatype.Duration [^DatatypeFactory this ^Boolean is-positive ^java.math.BigInteger day ^java.math.BigInteger hour ^java.math.BigInteger minute ^java.math.BigInteger second]
    (-> this (.newDurationDayTime is-positive day hour minute second)))
  (^javax.xml.datatype.Duration [^DatatypeFactory this ^java.lang.String lexical-representation]
    (-> this (.newDurationDayTime lexical-representation))))

(defn new-duration-year-month
  "Create a Duration of type xdt:yearMonthDuration using the specified
   year and month as defined in

     XQuery 1.0 and XPath 2.0 Data Model, xdt:yearMonthDuration.

   The XML Schema specification states that values can be of an arbitrary size.
   Implementations may chose not to or be incapable of supporting arbitrarily large and/or small values.
   An UnsupportedOperationException will be thrown with a message indicating implementation limits
   if implementation capacities are exceeded.

   A null value indicates that field is not set.

  is-positive - Set to false to create a negative duration. When the length of the duration is zero, this parameter will be ignored. - `boolean`
  year - Year of Duration. - `java.math.BigInteger`
  month - Month of Duration. - `java.math.BigInteger`

  returns: New Duration created using the specified year and month. - `javax.xml.datatype.Duration`

  throws: java.lang.IllegalArgumentException - If the values are not a valid representation of a Duration: if all of the fields (year, month) are null or if any of the fields is negative."
  (^javax.xml.datatype.Duration [^DatatypeFactory this ^Boolean is-positive ^java.math.BigInteger year ^java.math.BigInteger month]
    (-> this (.newDurationYearMonth is-positive year month)))
  (^javax.xml.datatype.Duration [^DatatypeFactory this ^java.lang.String lexical-representation]
    (-> this (.newDurationYearMonth lexical-representation))))

(defn new-xml-gregorian-calendar
  "Constructor allowing for complete value spaces allowed by
   W3C XML Schema 1.0 recommendation for xsd:dateTime and related
   builtin datatypes. Note that year parameter supports
   arbitrarily large numbers and fractionalSecond has infinite
   precision.

   A null value indicates that field is not set.

  year - of XMLGregorianCalendar to be created. - `java.math.BigInteger`
  month - of XMLGregorianCalendar to be created. - `int`
  day - of XMLGregorianCalendar to be created. - `int`
  hour - of XMLGregorianCalendar to be created. - `int`
  minute - of XMLGregorianCalendar to be created. - `int`
  second - of XMLGregorianCalendar to be created. - `int`
  fractional-second - of XMLGregorianCalendar to be created. - `java.math.BigDecimal`
  timezone - of XMLGregorianCalendar to be created. - `int`

  returns: XMLGregorianCalendar created from specified values. - `javax.xml.datatype.XMLGregorianCalendar`

  throws: java.lang.IllegalArgumentException - If any individual parameter's value is outside the maximum value constraint for the field as determined by the Date/Time Data Mapping table in XMLGregorianCalendar or if the composite values constitute an invalid XMLGregorianCalendar instance as determined by XMLGregorianCalendar.isValid()."
  (^javax.xml.datatype.XMLGregorianCalendar [^DatatypeFactory this ^java.math.BigInteger year ^Integer month ^Integer day ^Integer hour ^Integer minute ^Integer second ^java.math.BigDecimal fractional-second ^Integer timezone]
    (-> this (.newXMLGregorianCalendar year month day hour minute second fractional-second timezone)))
  (^javax.xml.datatype.XMLGregorianCalendar [^DatatypeFactory this ^java.lang.String lexical-representation]
    (-> this (.newXMLGregorianCalendar lexical-representation)))
  (^javax.xml.datatype.XMLGregorianCalendar [^DatatypeFactory this]
    (-> this (.newXMLGregorianCalendar))))

(defn new-xml-gregorian-calendar-date
  "Create a Java representation of XML Schema builtin datatype date or g*.

   For example, an instance of gYear can be created invoking this factory
   with month and day parameters set to
   DatatypeConstants.FIELD_UNDEFINED.

   A DatatypeConstants.FIELD_UNDEFINED value indicates that field is not set.

  year - of XMLGregorianCalendar to be created. - `int`
  month - of XMLGregorianCalendar to be created. - `int`
  day - of XMLGregorianCalendar to be created. - `int`
  timezone - offset in minutes. DatatypeConstants.FIELD_UNDEFINED indicates optional field is not set. - `int`

  returns: XMLGregorianCalendar created from parameter values. - `javax.xml.datatype.XMLGregorianCalendar`

  throws: java.lang.IllegalArgumentException - If any individual parameter's value is outside the maximum value constraint for the field as determined by the Date/Time Data Mapping table in XMLGregorianCalendar or if the composite values constitute an invalid XMLGregorianCalendar instance as determined by XMLGregorianCalendar.isValid()."
  (^javax.xml.datatype.XMLGregorianCalendar [^DatatypeFactory this ^Integer year ^Integer month ^Integer day ^Integer timezone]
    (-> this (.newXMLGregorianCalendarDate year month day timezone))))

(defn new-xml-gregorian-calendar-time
  "Create a Java instance of XML Schema builtin datatype time.

   A null value indicates that field is not set.
   A DatatypeConstants.FIELD_UNDEFINED value indicates that field is not set.

  hours - number of hours - `int`
  minutes - number of minutes - `int`
  seconds - number of seconds - `int`
  fractional-second - value of null indicates that this optional field is not set. - `java.math.BigDecimal`
  timezone - offset in minutes. DatatypeConstants.FIELD_UNDEFINED indicates optional field is not set. - `int`

  returns: XMLGregorianCalendar created from parameter values. - `javax.xml.datatype.XMLGregorianCalendar`

  throws: java.lang.IllegalArgumentException - If any individual parameter's value is outside the maximum value constraint for the field as determined by the Date/Time Data Mapping table in XMLGregorianCalendar or if the composite values constitute an invalid XMLGregorianCalendar instance as determined by XMLGregorianCalendar.isValid()."
  (^javax.xml.datatype.XMLGregorianCalendar [^DatatypeFactory this ^Integer hours ^Integer minutes ^Integer seconds ^java.math.BigDecimal fractional-second ^Integer timezone]
    (-> this (.newXMLGregorianCalendarTime hours minutes seconds fractional-second timezone)))
  (^javax.xml.datatype.XMLGregorianCalendar [^DatatypeFactory this ^Integer hours ^Integer minutes ^Integer seconds ^Integer timezone]
    (-> this (.newXMLGregorianCalendarTime hours minutes seconds timezone))))

