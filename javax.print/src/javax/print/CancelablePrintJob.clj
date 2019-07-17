(ns javax.print.CancelablePrintJob
  "This interface is used by a printing application to cancel a
  print job.  This interface extends DocPrintJob.  A
  DocPrintJob implementation returned from a print
  service implements this interface if the print job can be
  cancelled.  Before trying to cancel
  a print job, the client needs to test if the
  DocPrintJob object returned from the print service
  actually implements this interface.  Clients should never assume
  that a DocPrintJob implements this interface.  A
  print service might support cancellation only for certain types
  of print data and representation class names.  This means that
  only some of the DocPrintJob objects returned from
  a service will implement this interface.

  Service implementors are encouraged to implement this optional interface
  and to deliver a javax.print.event.PrintJobEvent.JOB_CANCELLED event
  to any listeners if a job is successfully cancelled with an
  implementation of this interface. Services should also note that an
  implementation of this method may be made from a separate client thread
  than that which made the print request.  Thus the implementation of
  this interface must be made thread safe."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print CancelablePrintJob]))

(defn cancel
  "Stops further processing of a print job.

   If a service supports this method it cannot be concluded that
   job cancellation will always succeed. A job may not be able to be
   cancelled once it has reached and passed some point in its processing.
   A successful cancellation means only that the entire job was not
   printed, some portion may already have printed when cancel returns.

   The service will throw a PrintException if the cancellation did not
   succeed. A job which has not yet been submitted for printing should
   throw this exception.
   Cancelling an already successfully cancelled Print Job is not
   considered an error and will always succeed.

   Cancellation in some services may be a lengthy process, involving
   requests to a server and processing of its print queue. Clients
   may wish to execute cancel in a thread which does not affect
   application execution.

  throws: javax.print.PrintException - if the job could not be successfully cancelled."
  ([^. this]
    (-> this (.cancel))))

