(ns javax.print.Doc
  "Interface Doc specifies the interface for an object that supplies one piece
  of print data for a Print Job. `Doc` is a short, easy-to-pronounce term
  that means `a piece of print data.` The client passes to the Print Job an
  object that implements interface Doc, and the Print Job calls methods on
  that object to obtain the print data. The Doc interface lets a Print Job:


  Determine the format, or `doc flavor` (class DocFlavor),
  in which the print data is available. A doc flavor designates the print
  data format (a MIME type) and the representation class of the object
  from which the print data comes.


  Obtain the print data representation object, which is an instance of the
  doc flavor's representation class. The Print Job can then obtain the actual
  print data from the representation object.


  Obtain the printing attributes that specify additional characteristics of
  the doc or that specify processing instructions to be applied to the doc.
  Printing attributes are defined in package javax.print.attribute. The doc returns its printing attributes stored in
  an javax.print.attribute.DocAttributeSet.


  Each method in an implementation of interface Doc is permitted always to
  return the same object each time the method is called.
  This has implications
  for a Print Job or other caller of a doc object whose print data
  representation object `consumes` the print data as the caller obtains the
  print data, such as a print data representation object which is a stream.
  Once the Print Job has called getPrintData() and obtained the stream, any further calls to
  getPrintData() will return the same
  stream object upon which reading may already be in progress, not a new
  stream object that will re-read the print data from the beginning. Specifying
  a doc object to behave this way simplifies the implementation of doc objects,
  and is justified on the grounds that a particular doc is intended to convey
  print data only to one Print Job, not to several different Print Jobs. (To
  convey the same print data to several different Print Jobs, you have to
  create several different doc objects on top of the same print data source.)

  Interface Doc affords considerable implementation flexibility. The print data
  might already be in existence when the doc object is constructed. In this
  case the objects returned by the doc's methods can be supplied to the doc's
  constructor, be stored in the doc ahead of time, and simply be returned when
  called for. Alternatively, the print data might not exist yet when the doc
  object is constructed. In this case the doc object might provide a `lazy`
  implementation that generates the print data representation object (and/or
  the print data) only when the Print Job calls for it (when the Print Job
  calls the getPrintData() method).

  There is no restriction on the number of client threads that may be
  simultaneously accessing the same doc. Therefore, all implementations of
  interface Doc must be designed to be multiple thread safe.

  However there can only be one consumer of the print data obtained from a
  Doc.

  If print data is obtained from the client as a stream, by calling Doc's
  getReaderForText() or getStreamForBytes()
  methods, or because the print data source is already an InputStream or
  Reader, then the print service should always close these streams for the
  client on all job completion conditions. With the following caveat.
  If the print data is itself a stream, the service will always close it.
  If the print data is otherwise something that can be requested as a stream,
  the service will only close the stream if it has obtained the stream before
  terminating. That is, just because a print service might request data as
  a stream does not mean that it will, with the implications that Doc
  implementors which rely on the service to close them should create such
  streams only in response to a request from the service."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print Doc]))

(defn get-doc-flavor
  "Determines the doc flavor in which this doc object will supply its
   piece of print data.

  returns: Doc flavor. - `javax.print.DocFlavor`"
  ([^javax.print.Doc this]
    (-> this (.getDocFlavor))))

(defn get-print-data
  "Obtains the print data representation object that contains this doc
   object's piece of print data in the format corresponding to the
   supported doc flavor.
   The getPrintData() method returns an instance of
   the representation class whose name is given by getDocFlavor().getRepresentationClassName(), and the return value can be cast
   from class Object to that representation class.

  returns: Print data representation object. - `java.lang.Object`

  throws: java.io.IOException - Thrown if the representation class is a stream and there was an I/O error while constructing the stream."
  ([^javax.print.Doc this]
    (-> this (.getPrintData))))

(defn get-attributes
  "Obtains the set of printing attributes for this doc object. If the
   returned attribute set includes an instance of a particular attribute
   X, the printer must use that attribute value for this doc,
   overriding any value of attribute X in the job's attribute set.
   If the returned attribute set does not include an instance
   of a particular attribute X or if null is returned, the printer
   must consult the job's attribute set to obtain the value for
   attribute X, and if not found there, the printer must use an
   implementation-dependent default value. The returned attribute set is
   unmodifiable.

  returns: Unmodifiable set of printing attributes for this doc, or null
            to obtain all attribute values from the job's attribute
            set. - `javax.print.attribute.DocAttributeSet`"
  ([^javax.print.Doc this]
    (-> this (.getAttributes))))

(defn get-reader-for-text
  "Obtains a reader for extracting character print data from this doc.
   The Doc implementation is required to support this method if the
   DocFlavor has one of the following print data representation classes,
   and return null otherwise:

    char[]
    java.lang.String
    java.io.Reader

   The doc's print data representation object is used to construct and
   return a Reader for reading the print data as a stream of characters
   from the print data representation object.
   However, if the print data representation object is itself a Reader,
   then the print data representation object is simply returned.

  returns: Reader for reading the print data characters from this doc.
            If a reader cannot be provided because this doc does not meet
            the criteria stated above, null is returned. - `java.io.Reader`

  throws: java.io.IOException - Thrown if there was an I/O error while creating the reader."
  ([^javax.print.Doc this]
    (-> this (.getReaderForText))))

(defn get-stream-for-bytes
  "Obtains an input stream for extracting byte print data from this
   doc.  The Doc implementation is required to support this method if
   the DocFlavor has one of the following print data representation
   classes, and return null otherwise:

    byte[]
    java.io.InputStream

   This doc's print data representation object is obtained, then an input
   stream for reading the print data from the print data representation
   object as a stream of bytes is created and returned. However, if the
   print data representation object is itself an input stream, then the
   print data representation object is simply returned.

  returns: Input stream for reading the print data bytes from this doc. If
            an input stream cannot be provided because this doc does not
            meet the criteria stated above, null is returned. - `java.io.InputStream`

  throws: java.io.IOException - Thrown if there was an I/O error while creating the input stream."
  ([^javax.print.Doc this]
    (-> this (.getStreamForBytes))))

