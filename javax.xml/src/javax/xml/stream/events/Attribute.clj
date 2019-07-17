(ns javax.xml.stream.events.Attribute
  "An interface that contains information about an attribute.  Attributes are reported
  as a set of events accessible from a StartElement.  Other applications may report
  Attributes as first-order events, for example as the results of an XPath expression."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.stream.events Attribute]))

(defn get-name
  "Returns the QName for this attribute

  returns: `javax.xml.namespace.QName`"
  (^javax.xml.namespace.QName [^javax.xml.stream.events.Attribute this]
    (-> this (.getName))))

(defn get-value
  "Gets the normalized value of this attribute

  returns: `java.lang.String`"
  (^java.lang.String [^javax.xml.stream.events.Attribute this]
    (-> this (.getValue))))

(defn get-dtd-type
  "Gets the type of this attribute, default is
   the String `CDATA`

  returns: the type as a String, default is `CDATA` - `java.lang.String`"
  (^java.lang.String [^javax.xml.stream.events.Attribute this]
    (-> this (.getDTDType))))

(defn specified?
  "A flag indicating whether this attribute was actually
   specified in the start-tag of its element, or was defaulted from the schema.

  returns: returns true if this was specified in the start element - `boolean`"
  (^Boolean [^javax.xml.stream.events.Attribute this]
    (-> this (.isSpecified))))

