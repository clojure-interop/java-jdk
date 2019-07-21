(ns jdk.awt.print.PrinterJob
  "The PrinterJob class is the principal class that controls
  printing. An application calls methods in this class to set up a job,
  optionally to invoke a print dialog with the user, and then to print
  the pages of the job."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.print PrinterJob]))

(defn ->printer-job
  "Constructor.

  A PrinterJob object should be created using the
   static getPrinterJob method."
  (^PrinterJob []
    (new PrinterJob )))

(defn *get-printer-job
  "Creates and returns a PrinterJob which is initially
   associated with the default printer.
   If no printers are available on the system, a PrinterJob will still
   be returned from this method, but getPrintService()
   will return null, and calling
   print with this PrinterJob might
   generate an exception.  Applications that need to determine if
   there are suitable printers before creating a PrinterJob
   should ensure that the array returned from
   lookupPrintServices is not empty.

  returns: a new PrinterJob. - `java.awt.print.PrinterJob`

  throws: java.lang.SecurityException - if a security manager exists and its SecurityManager.checkPrintJobAccess() method disallows this thread from creating a print job request"
  (^java.awt.print.PrinterJob []
    (PrinterJob/getPrinterJob )))

(defn *lookup-print-services
  "A convenience method which looks up 2D print services.
   Services returned from this method may be installed on
   PrinterJobs which support print services.
   Calling this method is equivalent to calling
   PrintServiceLookup.lookupPrintServices()
   and specifying a Pageable DocFlavor.

  returns: a possibly empty array of 2D print services. - `javax.print.PrintService[]`"
  ([]
    (PrinterJob/lookupPrintServices )))

(defn *lookup-stream-print-services
  "A convenience method which locates factories for stream print
   services which can image 2D graphics.
   Sample usage :


   FileOutputStream outstream;
   StreamPrintService psPrinter;
   String psMimeType = \"application/postscript\";
   PrinterJob pj = PrinterJob.getPrinterJob();

   StreamPrintServiceFactory[] factories =
       PrinterJob.lookupStreamPrintServices(psMimeType);
   if (factories.length > 0) {
       try {
           outstream = new File(\"out.ps\");
           psPrinter =  factories[0].getPrintService(outstream);
           // psPrinter can now be set as the service on a PrinterJob
           pj.setPrintService(psPrinter)
       } catch (Exception e) {
           e.printStackTrace();
       }
   }
   Services returned from this method may be installed on
   PrinterJob instances which support print services.
   Calling this method is equivalent to calling
   StreamPrintServiceFactory.lookupStreamPrintServiceFactories()
    and specifying a Pageable DocFlavor.

  mime-type - the required output format, or null to mean any format. - `java.lang.String`

  returns: a possibly empty array of 2D stream print service factories. - `javax.print.StreamPrintServiceFactory[]`"
  ([^java.lang.String mime-type]
    (PrinterJob/lookupStreamPrintServices mime-type)))

(defn set-copies
  "Sets the number of copies to be printed.

  copies - the number of copies to be printed - `int`"
  ([^PrinterJob this ^Integer copies]
    (-> this (.setCopies copies))))

(defn page-dialog
  "Displays a dialog that allows modification of a
   PageFormat instance.
   The page argument is used to initialize controls
   in the page setup dialog.
   If the user cancels the dialog then this method returns the
   original page object unmodified.
   If the user okays the dialog then this method returns a new
   PageFormat object with the indicated changes.
   In either case, the original page object is
   not modified.

  page - the default PageFormat presented to the user for modification - `java.awt.print.PageFormat`

  returns: the original page object if the dialog
              is cancelled; a new PageFormat object
              containing the format indicated by the user if the
              dialog is acknowledged. - `java.awt.print.PageFormat`

  throws: java.awt.HeadlessException - if GraphicsEnvironment.isHeadless() returns true."
  (^java.awt.print.PageFormat [^PrinterJob this ^java.awt.print.PageFormat page]
    (-> this (.pageDialog page))))

(defn cancel
  "Cancels a print job that is in progress.  If
   print has been called but has not
   returned then this method signals
   that the job should be cancelled at the next
   chance. If there is no print job in progress then
   this call does nothing."
  ([^PrinterJob this]
    (-> this (.cancel))))

(defn cancelled?
  "Returns true if a print job is
   in progress, but is going to be cancelled
   at the next opportunity; otherwise returns
   false.

  returns: true if the job in progress
   is going to be cancelled; false otherwise. - `boolean`"
  (^Boolean [^PrinterJob this]
    (-> this (.isCancelled))))

(defn get-print-service
  "Returns the service (printer) for this printer job.
   Implementations of this class which do not support print services
   may return null.  null will also be returned if no printers are
   available.

  returns: the service for this printer job. - `javax.print.PrintService`"
  (^javax.print.PrintService [^PrinterJob this]
    (-> this (.getPrintService))))

(defn get-user-name
  "Gets the name of the printing user.

  returns: the name of the printing user - `java.lang.String`"
  (^java.lang.String [^PrinterJob this]
    (-> this (.getUserName))))

(defn set-job-name
  "Sets the name of the document to be printed.
   The document name can not be null.

  job-name - the name of the document to be printed - `java.lang.String`"
  ([^PrinterJob this ^java.lang.String job-name]
    (-> this (.setJobName job-name))))

(defn print-dialog
  "A convenience method which displays a cross-platform print dialog
   for all services which are capable of printing 2D graphics using the
   Pageable interface. The selected printer when the
   dialog is initially displayed will reflect the print service currently
   attached to this print job.
   If the user changes the print service, the PrinterJob will be
   updated to reflect this, unless the user cancels the dialog.
   As well as allowing the user to select the destination printer,
   the user can also select values of various print request attributes.

   The attributes parameter on input will reflect the applications
   required initial selections in the user dialog. Attributes not
   specified display using the default for the service. On return it
   will reflect the user's choices. Selections may be updated by
   the implementation to be consistent with the supported values
   for the currently selected print service.

   As the user scrolls to a new print service selection, the values
   copied are based on the settings for the previous service, together
   with any user changes. The values are not based on the original
   settings supplied by the client.

   With the exception of selected printer, the PrinterJob state is
   not updated to reflect the user's changes.
   For the selections to affect a printer job, the attributes must
   be specified in the call to the
   print(PrintRequestAttributeSet) method. If using
   the Pageable interface, clients which intend to use media selected
   by the user must create a PageFormat derived from the user's
   selections.
   If the user cancels the dialog, the attributes will not reflect
   any changes made by the user.

  attributes - on input is application supplied attributes, on output the contents are updated to reflect user choices. This parameter may not be null. - `javax.print.attribute.PrintRequestAttributeSet`

  returns: true if the user does not cancel the dialog;
   false otherwise. - `boolean`

  throws: java.awt.HeadlessException - if GraphicsEnvironment.isHeadless() returns true."
  (^Boolean [^PrinterJob this ^javax.print.attribute.PrintRequestAttributeSet attributes]
    (-> this (.printDialog attributes)))
  (^Boolean [^PrinterJob this]
    (-> this (.printDialog))))

(defn get-copies
  "Gets the number of copies to be printed.

  returns: the number of copies to be printed. - `int`"
  (^Integer [^PrinterJob this]
    (-> this (.getCopies))))

(defn validate-page
  "Returns the clone of page with its settings
   adjusted to be compatible with the current printer of this
   PrinterJob.  For example, the returned
   PageFormat could have its imageable area
   adjusted to fit within the physical area of the paper that
   is used by the current printer.

  page - the PageFormat that is cloned and whose settings are changed to be compatible with the current printer - `java.awt.print.PageFormat`

  returns: a PageFormat that is cloned from
            page and whose settings are changed
            to conform with this PrinterJob. - `java.awt.print.PageFormat`"
  (^java.awt.print.PageFormat [^PrinterJob this ^java.awt.print.PageFormat page]
    (-> this (.validatePage page))))

(defn default-page
  "Clones the PageFormat argument and alters the
   clone to describe a default page size and orientation.

  page - the PageFormat to be cloned and altered - `java.awt.print.PageFormat`

  returns: clone of page, altered to describe a default
                        PageFormat. - `java.awt.print.PageFormat`"
  (^java.awt.print.PageFormat [^PrinterJob this ^java.awt.print.PageFormat page]
    (-> this (.defaultPage page)))
  (^java.awt.print.PageFormat [^PrinterJob this]
    (-> this (.defaultPage))))

(defn set-print-service
  "Associate this PrinterJob with a new PrintService.
   This method is overridden by subclasses which support
   specifying a Print Service.

   Throws PrinterException if the specified service
   cannot support the Pageable and
   Printable interfaces necessary to support 2D printing.

  service - a print service that supports 2D printing - `javax.print.PrintService`

  throws: java.awt.print.PrinterException - if the specified service does not support 2D printing, or this PrinterJob class does not support setting a 2D print service, or the specified service is otherwise not a valid print service."
  ([^PrinterJob this ^javax.print.PrintService service]
    (-> this (.setPrintService service))))

(defn get-job-name
  "Gets the name of the document to be printed.

  returns: the name of the document to be printed. - `java.lang.String`"
  (^java.lang.String [^PrinterJob this]
    (-> this (.getJobName))))

(defn get-page-format
  "Calculates a PageFormat with values consistent with those
   supported by the current PrintService for this job
   (ie the value returned by getPrintService()) and media,
   printable area and orientation contained in attributes.

   Calling this method does not update the job.
   It is useful for clients that have a set of attributes obtained from
   printDialog(PrintRequestAttributeSet attributes)
   and need a PageFormat to print a Pageable object.

  attributes - a set of printing attributes, for example obtained from calling printDialog. If attributes is null a default PageFormat is returned. - `javax.print.attribute.PrintRequestAttributeSet`

  returns: a PageFormat whose settings conform with
   those of the current service and the specified attributes. - `java.awt.print.PageFormat`"
  (^java.awt.print.PageFormat [^PrinterJob this ^javax.print.attribute.PrintRequestAttributeSet attributes]
    (-> this (.getPageFormat attributes))))

(defn print
  "Prints a set of pages using the settings in the attribute
   set. The default implementation ignores the attribute set.

   Note that some attributes may be set directly on the PrinterJob
   by equivalent method calls, (for example), copies:
   setcopies(int), job name: setJobName(String)
   and specifying media size and orientation though the
   PageFormat object.

   If a supported attribute-value is specified in this attribute set,
   it will take precedence over the API settings for this print()
   operation only.
   The following behaviour is specified for PageFormat:
   If a client uses the Printable interface, then the
   attributes parameter to this method is examined
   for attributes which specify media (by size), orientation, and
   imageable area, and those are used to construct a new PageFormat
   which is passed to the Printable object's print() method.
   See Printable for an explanation of the required
   behaviour of a Printable to ensure optimal printing via PrinterJob.
   For clients of the Pageable interface, the PageFormat will always
   be as supplied by that interface, on a per page basis.

   These behaviours allow an application to directly pass the
   user settings returned from
   printDialog(PrintRequestAttributeSet attributes to
   this print() method.

  attributes - a set of attributes for the job - `javax.print.attribute.PrintRequestAttributeSet`

  throws: java.awt.print.PrinterException - an error in the print system caused the job to be aborted."
  ([^PrinterJob this ^javax.print.attribute.PrintRequestAttributeSet attributes]
    (-> this (.print attributes)))
  ([^PrinterJob this]
    (-> this (.print))))

(defn set-pageable
  "Queries document for the number of pages and
   the PageFormat and Printable for each
   page held in the Pageable instance,
   document.

  document - the pages to be printed. It can not be null. - `java.awt.print.Pageable`

  throws: java.lang.NullPointerException - the Pageable passed in was null."
  ([^PrinterJob this ^java.awt.print.Pageable document]
    (-> this (.setPageable document))))

(defn set-printable
  "Calls painter to render the pages in the specified
   format.  The pages in the document to be printed by
   this PrinterJob are rendered by the
   Printable object, painter. The
   PageFormat of each page is format.

  painter - the Printable called to render each page of the document - `java.awt.print.Printable`
  format - the size and orientation of each page to be printed - `java.awt.print.PageFormat`"
  ([^PrinterJob this ^java.awt.print.Printable painter ^java.awt.print.PageFormat format]
    (-> this (.setPrintable painter format)))
  ([^PrinterJob this ^java.awt.print.Printable painter]
    (-> this (.setPrintable painter))))

