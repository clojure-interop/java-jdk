(ns javax.print.event.PrintJobEvent
  "Class PrintJobEvent encapsulates common events a print job
  reports to let a listener know of progress in the processing of the
  DocPrintJob."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.event PrintJobEvent]))

(defn ->print-job-event
  "Constructor.

  Constructs a PrintJobEvent object.

  source - a DocPrintJob object - `javax.print.DocPrintJob`
  reason - an int specifying the reason. - `int`

  throws: java.lang.IllegalArgumentException - if source is null."
  (^PrintJobEvent [^javax.print.DocPrintJob source ^Integer reason]
    (new PrintJobEvent source reason)))

(def *-job-canceled
  "Static Constant.

  The job was canceled by the PrintService.

  type: int"
  PrintJobEvent/JOB_CANCELED)

(def *-job-complete
  "Static Constant.

  The document cis completely printed.

  type: int"
  PrintJobEvent/JOB_COMPLETE)

(def *-job-failed
  "Static Constant.

  The print service reports that the job cannot be completed.
   The application must resubmit the job.

  type: int"
  PrintJobEvent/JOB_FAILED)

(def *-requires-attention
  "Static Constant.

  The print service indicates that a - possibly transient - problem
   may require external intervention before the print service can
   continue.  One example of an event that can
   generate this message is when the printer runs out of paper.

  type: int"
  PrintJobEvent/REQUIRES_ATTENTION)

(def *-no-more-events
  "Static Constant.

  Not all print services may be capable of delivering interesting
   events, or even telling when a job is complete. This message indicates
   the print job has no further information or communication
   with the print service. This message should always be delivered
   if a terminal event (completed/failed/canceled) is not delivered.
   For example, if messages such as JOB_COMPLETE have NOT been received
   before receiving this message, the only inference that should be drawn
   is that the print service does not support delivering such an event.

  type: int"
  PrintJobEvent/NO_MORE_EVENTS)

(def *-data-transfer-complete
  "Static Constant.

  The job is not necessarily printed yet, but the data has been transferred
   successfully from the client to the print service. The client may
   free data resources.

  type: int"
  PrintJobEvent/DATA_TRANSFER_COMPLETE)

(defn get-print-event-type
  "Gets the reason for this event.

  returns: reason int. - `int`"
  (^Integer [^PrintJobEvent this]
    (-> this (.getPrintEventType))))

(defn get-print-job
  "Determines the DocPrintJob to which this print job
   event pertains.

  returns: the DocPrintJob object that represents the
            print job that reports the events encapsulated by this
            PrintJobEvent. - `javax.print.DocPrintJob`"
  (^javax.print.DocPrintJob [^PrintJobEvent this]
    (-> this (.getPrintJob))))

