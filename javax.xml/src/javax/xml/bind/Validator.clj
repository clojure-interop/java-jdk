(ns javax.xml.bind.Validator
  "Deprecated.
 since JAXB 2.0"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.bind Validator]))

(defn set-event-handler
  "Deprecated. since JAXB2.0

  handler - the validation event handler - `javax.xml.bind.ValidationEventHandler`

  throws: javax.xml.bind.JAXBException - if an error was encountered while setting the event handler"
  ([^javax.xml.bind.Validator this ^javax.xml.bind.ValidationEventHandler handler]
    (-> this (.setEventHandler handler))))

(defn get-event-handler
  "Deprecated. since JAXB2.0

  returns: the current ValidationEventHandler or the default event handler
           if it hasn't been set - `javax.xml.bind.ValidationEventHandler`

  throws: javax.xml.bind.JAXBException - if an error was encountered while getting the current event handler"
  ([^javax.xml.bind.Validator this]
    (-> this (.getEventHandler))))

(defn validate
  "Deprecated. since JAXB2.0

  subroot-obj - the obj to begin validation at - `java.lang.Object`

  returns: true if the subtree rooted at subrootObj is valid, false
           otherwise - `boolean`

  throws: javax.xml.bind.JAXBException - if any unexpected problem occurs during validation"
  ([^javax.xml.bind.Validator this ^java.lang.Object subroot-obj]
    (-> this (.validate subroot-obj))))

(defn validate-root
  "Deprecated. since JAXB2.0

  root-obj - the root obj to begin validation at - `java.lang.Object`

  returns: true if the tree rooted at rootObj is valid, false
           otherwise - `boolean`

  throws: javax.xml.bind.JAXBException - if any unexpected problem occurs during validation"
  ([^javax.xml.bind.Validator this ^java.lang.Object root-obj]
    (-> this (.validateRoot root-obj))))

(defn set-property
  "Deprecated. since JAXB2.0

  name - the name of the property to be set. This value can either be specified using one of the constant fields or a user supplied string. - `java.lang.String`
  value - the value of the property to be set - `java.lang.Object`

  throws: javax.xml.bind.PropertyException - when there is an error processing the given property or value"
  ([^javax.xml.bind.Validator this ^java.lang.String name ^java.lang.Object value]
    (-> this (.setProperty name value))))

(defn get-property
  "Deprecated. since JAXB2.0

  name - the name of the property to retrieve - `java.lang.String`

  returns: the value of the requested property - `java.lang.Object`

  throws: javax.xml.bind.PropertyException - when there is an error retrieving the given property or value property name"
  ([^javax.xml.bind.Validator this ^java.lang.String name]
    (-> this (.getProperty name))))

