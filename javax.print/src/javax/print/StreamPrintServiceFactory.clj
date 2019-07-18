(ns javax.print.StreamPrintServiceFactory
  "A StreamPrintServiceFactory is the factory for
  StreamPrintService instances,
  which can print to an output stream in a particular
  document format described as a mime type.
  A typical output document format may be Postscript(TM).

  This class is implemented by a service and located by the
  implementation using the

  SPI JAR File specification.

  Applications locate instances of this class by calling the
  lookupStreamPrintServiceFactories(DocFlavor, String) method.

  Applications can use a StreamPrintService obtained from a
  factory in place of a PrintService which represents a
  physical printer device."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print StreamPrintServiceFactory]))

(defn ->stream-print-service-factory
  "Constructor."
  (^StreamPrintServiceFactory []
    (new StreamPrintServiceFactory )))

(defn *lookup-stream-print-service-factories
  "Locates factories for print services that can be used with
   a print job to output a stream of data in the
   format specified by outputMimeType.

   The outputMimeType parameter describes the document type that
   you want to create, whereas the flavor parameter describes the
   format in which the input data will be provided by the application
   to the StreamPrintService.

   Although null is an acceptable value to use in the lookup of stream
   printing services, it's typical to search for a particular
   desired format, such as Postscript(TM).

  flavor - of the input document type - null means match all types. - `javax.print.DocFlavor`
  output-mime-type - representing the required output format, used to identify suitable stream printer factories. A value of null means match all formats. - `java.lang.String`

  returns: - matching factories for stream print service instance,
             empty if no suitable factories could be located. - `javax.print.StreamPrintServiceFactory[]`"
  ([^javax.print.DocFlavor flavor ^java.lang.String output-mime-type]
    (StreamPrintServiceFactory/lookupStreamPrintServiceFactories flavor output-mime-type)))

(defn get-output-format
  "Queries the factory for the document format that is emitted
   by printers obtained from this factory.

  returns: the output format described as a mime type. - `java.lang.String`"
  (^java.lang.String [^StreamPrintServiceFactory this]
    (-> this (.getOutputFormat))))

(defn get-supported-doc-flavors
  "Queries the factory for the document flavors that can be accepted
   by printers obtained from this factory.

  returns: array of supported doc flavors. - `javax.print.DocFlavor[]`"
  ([^StreamPrintServiceFactory this]
    (-> this (.getSupportedDocFlavors))))

(defn get-print-service
  "Returns a StreamPrintService that can print to
   the specified output stream.
   The output stream is created and managed by the application.
   It is the application's responsibility to close the stream and
   to ensure that this Printer is not reused.
   The application should not close this stream until any print job
   created from the printer is complete. Doing so earlier may generate
   a PrinterException and an event indicating that the
   job failed.

   Whereas a PrintService connected to a physical printer
   can be reused,
   a StreamPrintService connected to a stream cannot.
   The underlying StreamPrintService may be disposed by
   the print system with
   the dispose method
   before returning from the
   print
   method of DocPrintJob so that the print system knows
   this printer is no longer usable.
   This is equivalent to a physical printer going offline - permanently.
   Applications may supply a null print stream to create a queryable
   service. It is not valid to create a PrintJob for such a stream.
   Implementations which allocate resources on construction should examine
   the stream and may wish to only allocate resources if the stream is
   non-null.

  out - destination stream for generated output. - `java.io.OutputStream`

  returns: a PrintService which will generate the format specified by the
   DocFlavor supported by this Factory. - `javax.print.StreamPrintService`"
  (^javax.print.StreamPrintService [^StreamPrintServiceFactory this ^java.io.OutputStream out]
    (-> this (.getPrintService out))))

