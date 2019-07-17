(ns javax.print.event.PrintJobAttributeEvent
  "Class PrintJobAttributeEvent encapsulates an event a PrintService
  reports to let the client know that one or more printing attributes for a
  PrintJob have changed."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.event PrintJobAttributeEvent]))

(defn ->print-job-attribute-event
  "Constructor.

  Constructs a PrintJobAttributeEvent object.

  source - the print job generating this event - `javax.print.DocPrintJob`
  attributes - the attribute changes being reported - `javax.print.attribute.PrintJobAttributeSet`

  throws: java.lang.IllegalArgumentException - if source is null."
  ([source attributes]
    (new PrintJobAttributeEvent source attributes)))

(defn get-print-job
  "Determine the Print Job to which this print job event pertains.

  returns: Print Job object. - `javax.print.DocPrintJob`"
  ([this]
    (-> this (.getPrintJob))))

(defn get-attributes
  "Determine the printing attributes that changed and their new values.

  returns: Attributes containing the new values for the print job
   attributes that changed. The returned set may not be modifiable. - `javax.print.attribute.PrintJobAttributeSet`"
  ([this]
    (-> this (.getAttributes))))

