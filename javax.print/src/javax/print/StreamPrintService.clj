(ns javax.print.StreamPrintService
  "This class extends PrintService and represents a
  print service that prints data in different formats to a
  client-provided output stream.
  This is principally intended for services where
  the output format is a document type suitable for viewing
  or archiving.
  The output format must be declared as a mime type.
  This is equivalent to an output document flavor where the
  representation class is always `java.io.OutputStream`
  An instance of the StreamPrintService class is
  obtained from a StreamPrintServiceFactory instance.

  Note that a StreamPrintService is different from a
  PrintService, which supports a
  Destination
  attribute.  A StreamPrintService always requires an output
  stream, whereas a PrintService optionally accepts a
  Destination. A StreamPrintService
  has no default destination for its formatted output.
  Additionally a StreamPrintService is expected to generate
 output in
  a format useful in other contexts.
  StreamPrintService's are not expected to support the Destination attribute."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print StreamPrintService]))

(defn get-output-stream
  "Gets the output stream.

  returns: the stream to which this service will send formatted print data. - `java.io.OutputStream`"
  ([this]
    (-> this (.getOutputStream))))

(defn get-output-format
  "Returns the document format emitted by this print service.
   Must be in mimetype format, compatible with the mime type
   components of DocFlavors @see DocFlavor.

  returns: mime type identifying the output format. - `java.lang.String`"
  ([this]
    (-> this (.getOutputFormat))))

(defn dispose
  "Disposes this StreamPrintService.
   If a stream service cannot be re-used, it must be disposed
   to indicate this. Typically the client will call this method.
   Services which write data which cannot meaningfully be appended to
   may also dispose the stream. This does not close the stream. It
   just marks it as not for further use by this service."
  ([this]
    (-> this (.dispose))))

(defn disposed?
  "Returns a boolean indicating whether or not
   this StreamPrintService has been disposed.
   If this object has been disposed, will return true.
   Used by services and client applications to recognize streams
   to which no further data should be written.

  returns: if this StreamPrintService has been disposed - `boolean`"
  ([this]
    (-> this (.isDisposed))))

