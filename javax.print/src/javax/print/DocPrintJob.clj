(ns javax.print.DocPrintJob
  "This interface represents a print job that can print a specified
  document with a set of job attributes.  An object implementing
  this interface is obtained from a print service."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print DocPrintJob]))

(defn get-print-service
  "Determines the PrintService object to which this print job
   object is bound.

  returns: PrintService object. - `javax.print.PrintService`"
  (^javax.print.PrintService [^javax.print.DocPrintJob this]
    (-> this (.getPrintService))))

(defn get-attributes
  "Obtains this Print Job's set of printing attributes.
   The returned attribute set object is unmodifiable.
   The returned attribute set object is a `snapshot` of this Print Job's
   attribute set at the time of the getAttributes() method
   call; that is, the returned attribute set's object's contents will
   not be updated if this Print Job's attribute set's contents change
   in the future. To detect changes in attribute values, call
   getAttributes() again and compare the new attribute
   set to the previous attribute set; alternatively, register a
   listener for print job events.
   The returned value may be an empty set but should not be null.

  returns: the print job attributes - `javax.print.attribute.PrintJobAttributeSet`"
  (^javax.print.attribute.PrintJobAttributeSet [^javax.print.DocPrintJob this]
    (-> this (.getAttributes))))

(defn add-print-job-listener
  "Registers a listener for event occurring during this print job.
   If listener is null, no exception is thrown and no action is
   performed.
   If listener is already registered, it will be registered again.

  listener - The object implementing the listener interface - `javax.print.event.PrintJobListener`"
  ([^javax.print.DocPrintJob this ^javax.print.event.PrintJobListener listener]
    (-> this (.addPrintJobListener listener))))

(defn remove-print-job-listener
  "Removes a listener from this print job.
   This method performs no function, nor does it throw an exception,
   if the listener specified by the argument was not previously added
   to this component. If listener is null, no exception is thrown and
   no action is performed. If a listener was registered more than once
   only one of the registrations will be removed.

  listener - The object implementing the listener interface - `javax.print.event.PrintJobListener`"
  ([^javax.print.DocPrintJob this ^javax.print.event.PrintJobListener listener]
    (-> this (.removePrintJobListener listener))))

(defn add-print-job-attribute-listener
  "Registers a listener for changes in the specified attributes.
   If listener is null, no exception is thrown and no action is
   performed.
   To determine the attribute updates that may be reported by this job,
   a client can call getAttributes() and identify the
   subset that are interesting and likely to be reported to the
   listener. Clients expecting to be updated about changes in a
   specific job attribute should verify it is in that set, but
   updates about an attribute will be made only if it changes and this
   is detected by the job. Also updates may be subject to batching
   by the job. To minimize overhead in print job processing it is
   recommended to listen on only that subset of attributes which
   are likely to change.
   If the specified set is empty no attribute updates will be reported
   to the listener.
   If the attribute set is null, then this means to listen on all
   dynamic attributes that the job supports. This may result in no
   update notifications if a job can not report any attribute updates.

   If listener is already registered, it will be registered again.

  listener - The object implementing the listener interface - `javax.print.event.PrintJobAttributeListener`
  attributes - The attributes to listen on, or null to mean all attributes that can change, as determined by the job. - `javax.print.attribute.PrintJobAttributeSet`"
  ([^javax.print.DocPrintJob this ^javax.print.event.PrintJobAttributeListener listener ^javax.print.attribute.PrintJobAttributeSet attributes]
    (-> this (.addPrintJobAttributeListener listener attributes))))

(defn remove-print-job-attribute-listener
  "Removes an attribute listener from this print job.
   This method performs no function, nor does it throw an exception,
   if the listener specified by the argument was not previously added
   to this component. If the listener is null, no exception is thrown
   and no action is performed.
   If a listener is registered more than once, even for a different
   set of attributes, no guarantee is made which listener is removed.

  listener - The object implementing the listener interface - `javax.print.event.PrintJobAttributeListener`"
  ([^javax.print.DocPrintJob this ^javax.print.event.PrintJobAttributeListener listener]
    (-> this (.removePrintJobAttributeListener listener))))

(defn print
  "Prints a document with the specified job attributes.
   This method should only be called once for a given print job.
   Calling it again will not result in a new job being spooled to
   the printer. The service implementation will define policy
   for service interruption and recovery.
   When the print method returns, printing may not yet have completed as
   printing may happen asynchronously, perhaps in a different thread.
   Application clients which  want to monitor the success or failure
   should register a PrintJobListener.

   Print service implementors should close any print data streams (ie
   Reader or InputStream implementations) that they obtain
   from the client doc. Robust clients may still wish to verify this.
   An exception is always generated if a DocFlavor cannot
   be printed.

  doc - The document to be printed. If must be a flavor supported by this PrintJob. - `javax.print.Doc`
  attributes - The job attributes to be applied to this print job. If this parameter is null then the default attributes are used. - `javax.print.attribute.PrintRequestAttributeSet`

  throws: javax.print.PrintException - The exception additionally may implement an interface that more precisely describes the cause of the exception FlavorException. If the document has a flavor not supported by this print job. AttributeException. If one or more of the attributes are not valid for this print job."
  ([^javax.print.DocPrintJob this ^javax.print.Doc doc ^javax.print.attribute.PrintRequestAttributeSet attributes]
    (-> this (.print doc attributes))))

