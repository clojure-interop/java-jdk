(ns javax.print.SimpleDoc
  "This class is an implementation of interface Doc that can
  be used in many common printing requests.
  It can handle all of the presently defined \"pre-defined\" doc flavors
  defined as static variables in the DocFlavor class.

  In particular this class implements certain required semantics of the
  Doc specification as follows:

  constructs a stream for the service if requested and appropriate.
  ensures the same object is returned for each call on a method.
  ensures multiple threads can access the Doc
  performs some validation of that the data matches the doc flavor.

  Clients who want to re-use the doc object in other jobs,
  or need a MultiDoc will not want to use this class.

  If the print data is a stream, or a print job requests data as a
  stream, then SimpleDoc does not monitor if the service
  properly closes the stream after data transfer completion or job
  termination.
  Clients may prefer to use provide their own implementation of doc that
  adds a listener to monitor job completion and to validate that
  resources such as streams are freed (ie closed)."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print SimpleDoc]))

(defn ->simple-doc
  "Constructor.

  Constructs a SimpleDoc with the specified
   print data, doc flavor and doc attribute set.

  print-data - the print data object - `java.lang.Object`
  flavor - the DocFlavor object - `javax.print.DocFlavor`
  attributes - a DocAttributeSet, which can be null - `javax.print.attribute.DocAttributeSet`

  throws: java.lang.IllegalArgumentException - if flavor or printData is null, or the printData does not correspond to the specified doc flavor--for example, the data is not of the type specified as the representation in the DocFlavor."
  (^SimpleDoc [^java.lang.Object print-data ^javax.print.DocFlavor flavor ^javax.print.attribute.DocAttributeSet attributes]
    (new SimpleDoc print-data flavor attributes)))

(defn get-doc-flavor
  "Determines the doc flavor in which this doc object will supply its
   piece of print data.

  returns: Doc flavor. - `javax.print.DocFlavor`"
  (^javax.print.DocFlavor [^SimpleDoc this]
    (-> this (.getDocFlavor))))

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
  (^javax.print.attribute.DocAttributeSet [^SimpleDoc this]
    (-> this (.getAttributes))))

(defn get-print-data
  "Description copied from interface: Doc

  returns: Print data representation object. - `java.lang.Object`

  throws: java.io.IOException - Thrown if the representation class is a stream and there was an I/O error while constructing the stream."
  (^java.lang.Object [^SimpleDoc this]
    (-> this (.getPrintData))))

(defn get-reader-for-text
  "Obtains a reader for extracting character print data from this doc.
   The Doc implementation is required to support this
   method if the DocFlavor has one of the following print
   data representation classes, and return null
   otherwise:

    char[]
    java.lang.String
    java.io.Reader

   The doc's print data representation object is used to construct and
   return a Reader for reading the print data as a stream
   of characters from the print data representation object.
   However, if the print data representation object is itself a
   Reader then the print data representation object is
   simply returned.

  returns: a Reader for reading the print data
            characters from this doc.
            If a reader cannot be provided because this doc does not meet
            the criteria stated above, null is returned. - `java.io.Reader`

  throws: java.io.IOException - if there was an I/O error while creating the reader."
  (^java.io.Reader [^SimpleDoc this]
    (-> this (.getReaderForText))))

(defn get-stream-for-bytes
  "Obtains an input stream for extracting byte print data from
   this doc.
   The Doc implementation is required to support this
   method if the DocFlavor has one of the following print
   data representation classes; otherwise this method
   returns null:

    byte[]
    java.io.InputStream

   The doc's print data representation object is obtained.  Then, an
   input stream for reading the print data
   from the print data representation object as a stream of bytes is
   created and returned.
   However, if the print data representation object is itself an
   input stream then the print data representation object is simply
   returned.

  returns: an InputStream for reading the print data
            bytes from this doc.  If an input stream cannot be
            provided because this doc does not meet
            the criteria stated above, null is returned. - `java.io.InputStream`

  throws: java.io.IOException - if there was an I/O error while creating the input stream."
  (^java.io.InputStream [^SimpleDoc this]
    (-> this (.getStreamForBytes))))

