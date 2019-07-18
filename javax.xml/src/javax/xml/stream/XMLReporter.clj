(ns javax.xml.stream.XMLReporter
  "This interface is used to report non-fatal errors.
  Only warnings should be echoed through this interface."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.stream XMLReporter]))

(defn report
  "Report the desired message in an application specific format.

   Only warnings and non-fatal errors should be reported through

   this interface.

   Fatal errors should be thrown as XMLStreamException.

  message - the error message - `java.lang.String`
  error-type - an implementation defined error type - `java.lang.String`
  related-information - information related to the error, if available - `java.lang.Object`
  location - the location of the error, if available - `javax.xml.stream.Location`

  throws: javax.xml.stream.XMLStreamException"
  ([^XMLReporter this ^java.lang.String message ^java.lang.String error-type ^java.lang.Object related-information ^javax.xml.stream.Location location]
    (-> this (.report message error-type related-information location))))

