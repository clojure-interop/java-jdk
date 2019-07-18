(ns javax.print.MultiDocPrintJob
  "Obtained from a MultiDocPrintService, a MultiDocPrintJob can print a
  specified collection of documents as a single print job with a set of
  job attributes."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print MultiDocPrintJob]))

(defn print
  "Print a MultiDoc with the specified job attributes.
   This method should only be called once for a given print job.
   Calling it again will not result in a new job being spooled to
   the printer. The service implementation will define policy
   for service interruption and recovery. Application clients which
   want to monitor the success or failure should register a
   PrintJobListener.

  multi-doc - The documents to be printed. ALL must be a flavor supported by the PrintJob & PrintService. - `javax.print.MultiDoc`
  attributes - The job attributes to be applied to this print job. If this parameter is null then the default attributes are used. - `javax.print.attribute.PrintRequestAttributeSet`

  throws: javax.print.PrintException - The exception additionally may implement an interfaces which more precisely describes the cause of the exception FlavorException. If the document has a flavor not supported by this print job. AttributeException. If one or more of the attributes are not valid for this print job."
  ([^MultiDocPrintJob this ^javax.print.MultiDoc multi-doc ^javax.print.attribute.PrintRequestAttributeSet attributes]
    (-> this (.print multi-doc attributes))))

