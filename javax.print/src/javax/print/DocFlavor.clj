(ns javax.print.DocFlavor
  "Class DocFlavor encapsulates an object that specifies the
  format in which print data is supplied to a DocPrintJob.
  `Doc` is a short, easy-to-pronounce term that means `a piece of print data.`
  The print data format, or `doc flavor`, consists of two things:


  MIME type. This is a Multipurpose Internet Mail Extensions (MIME)
  media type (as defined in RFC
  2045 and RFC 2046)
  that specifies how the print data is to be interpreted.
  The charset of text data should be the IANA MIME-preferred name, or its
  canonical name if no preferred name is specified. Additionally a few
  historical names supported by earlier versions of the Java platform may
  be recognized.
  See
  character encodings for more information on the character encodings
  supported on the Java platform.


  Representation class name. This specifies the fully-qualified name of
  the class of the object from which the actual print data comes, as returned
  by the Class.getName() method.
  (Thus the class name for byte[] is `[B`, for
  char[] it is `[C`.)


  A DocPrintJob obtains its print data by means of interface
  Doc. A Doc object lets the DocPrintJob
  determine the doc flavor the client can supply.  A Doc object
  also lets the DocPrintJob obtain an instance of the doc flavor's
  representation class, from which the DocPrintJob then obtains
  the actual print data.


  Client Formatted Print Data
  There are two broad categories of print data, client formatted print data
  and service formatted print data.

  For client formatted print data, the client determines or knows the
  print data format.
  For example the client may have a JPEG encoded image, a URL for
  HTML code, or a disk file containing plain text in some encoding,
  possibly obtained from an external source, and
  requires a way to describe the data format to the print service.

  The doc flavor's representation class is a conduit for the JPS
  DocPrintJob to obtain a sequence of characters or
  bytes from the client. The
  doc flavor's MIME type is one of the standard media types telling how to
  interpret the sequence of characters or bytes. For a list of standard media
  types, see the Internet Assigned Numbers Authority's (IANA's) Media Types
  Directory. Interface Doc provides two utility operations,
  getReaderForText and
  getStreamForBytes(), to help a
  Doc object's client extract client formatted print data.

  For client formatted print data, the print data representation class is
  typically one of the following (although other representation classes are
  permitted):


  Character array (char[]) -- The print data consists of the
  Unicode characters in the array.


  String  --
  The print data consists of the Unicode characters in the string.


  Character stream (java.io.Reader)
  -- The print data consists of the Unicode characters read from the stream
  up to the end-of-stream.


  Byte array (byte[]) -- The print data consists of the bytes in
  the array. The bytes are encoded in the character set specified by the doc
  flavor's MIME type. If the MIME type does not specify a character set, the
  default character set is US-ASCII.


  Byte stream (java.io.InputStream) --
  The print data consists of the bytes read from the stream up to the
  end-of-stream. The bytes are encoded in the character set specified by the
  doc flavor's MIME type. If the MIME type does not specify a character set,
  the default character set is US-ASCII.


  Uniform Resource Locator (URL)
  -- The print data consists of the bytes read from the URL location.
  The bytes are encoded in the character set specified by the doc flavor's
  MIME type. If the MIME type does not specify a character set, the default
  character set is US-ASCII.

  When the representation class is a URL, the print service itself accesses
  and downloads the document directly from its URL address, without involving
  the client. The service may be some form of network print service which
  is executing in a different environment.
  This means you should not use a URL print data flavor to print a
  document at a restricted URL that the client can see but the printer cannot
  see. This also means you should not use a URL print data flavor to print a
  document stored in a local file that is not available at a URL
  accessible independently of the client.
  For example, a file that is not served up by an HTTP server or FTP server.
  To print such documents, let the client open an input stream on the URL
  or file and use an input stream data flavor.



  Default and Platform Encodings

  For byte print data where the doc flavor's MIME type does not include a
  charset parameter, the Java Print Service instance assumes the
  US-ASCII character set by default. This is in accordance with
  RFC 2046, which says the
  default character set is US-ASCII. Note that US-ASCII is a subset of
  UTF-8, so in the future this may be widened if a future RFC endorses
  UTF-8 as the default in a compatible manner.

  Also note that this is different than the behaviour of the Java runtime
  when interpreting a stream of bytes as text data. That assumes the
  default encoding for the user's locale. Thus, when spooling a file in local
  encoding to a Java Print Service it is important to correctly specify
  the encoding. Developers working in the English locales should
  be particularly conscious of this, as their platform encoding corresponds
  to the default mime charset. By this coincidence that particular
  case may work without specifying the encoding of platform data.

  Every instance of the Java virtual machine has a default character encoding
  determined during virtual-machine startup and typically depends upon the
  locale and charset being used by the underlying operating system.
  In a distributed environment there is no guarantee that two VM share
  the same default encoding. Thus clients which want to stream platform
  encoded text data from the host platform to a Java Print Service instance
  must explicitly declare the charset and not rely on defaults.

  The preferred form is the official IANA primary name for an encoding.
  Applications which stream text data should always specify the charset
  in the mime type, which necessitates obtaining the encoding of the host
  platform for data (eg files) stored in that platform's encoding.
  A CharSet which corresponds to this and is suitable for use in a
  mime-type for a DocFlavor can be obtained
  from DocFlavor.hostEncoding
  This may not always be the primary IANA name but is guaranteed to be
  understood by this VM.
  For common flavors, the pre-defined *HOST DocFlavors may be used.


  See
  character encodings for more information on the character encodings
  supported on the Java platform.


  Recommended DocFlavors

  The Java Print Service API does not define any mandatorily supported
  DocFlavors.
  However, here are some examples of MIME types that a Java Print Service
  instance might support for client formatted print data.
  Nested classes inside class DocFlavor declare predefined static
  constant DocFlavor objects for these example doc flavors; class DocFlavor's
  constructor can be used to create an arbitrary doc flavor.

  Preformatted text



   MIME-TypeDescription


  `text/plain`
  Plain text in the default character set (US-ASCII)


  `text/plain; charset=xxx`
  Plain text in character set xxx


  `text/html`
  HyperText Markup Language in the default character set (US-ASCII)


  `text/html; charset=xxx`
  HyperText Markup Language in character set xxx



  In general, preformatted text print data is provided either in a character
  oriented representation class (character array, String, Reader) or in a
  byte oriented representation class (byte array, InputStream, URL).

   Preformatted page description language (PDL) documents



   MIME-TypeDescription


  `application/pdf`
  Portable Document Format document


  `application/postscript`
  PostScript document


  `application/vnd.hp-PCL`
  Printer Control Language document



  In general, preformatted PDL print data is provided in a byte oriented
  representation class (byte array, InputStream, URL).

   Preformatted images



   MIME-TypeDescription



  `image/gif`
  Graphics Interchange Format image


  `image/jpeg`
  Joint Photographic Experts Group image


  `image/png`
  Portable Network Graphics image



  In general, preformatted image print data is provided in a byte oriented
  representation class (byte array, InputStream, URL).

   Preformatted autosense print data



   MIME-TypeDescription



  `application/octet-stream`
  The print data format is unspecified (just an octet stream)


  The printer decides how to interpret the print data; the way this
  `autosensing` works is implementation dependent. In general, preformatted
  autosense print data is provided in a byte oriented representation class
  (byte array, InputStream, URL).



  Service Formatted Print Data

  For service formatted print data, the Java Print Service instance
  determines the print data format. The doc flavor's representation class
  denotes an interface whose methods the DocPrintJob invokes to
  determine the content to be printed -- such as a renderable image
  interface or a Java printable interface.
  The doc flavor's MIME type is the special value
  `application/x-java-jvm-local-objectref` indicating the client
  will supply a reference to a Java object that implements the interface
  named as the representation class.
  This MIME type is just a placeholder; what's
  important is the print data representation class.

  For service formatted print data, the print data representation class is
  typically one of the following (although other representation classes are
  permitted). Nested classes inside class DocFlavor declare predefined static
  constant DocFlavor objects for these example doc flavors; class DocFlavor's
  constructor can be used to create an arbitrary doc flavor.


  Renderable image object -- The client supplies an object that implements
  interface
  RenderableImage. The
  printer calls methods
  in that interface to obtain the image to be printed.


  Printable object -- The client supplies an object that implements interface
  Printable.
  The printer calls methods in that interface to obtain the pages to be
  printed, one by one.
  For each page, the printer supplies a graphics context, and whatever the
  client draws in that graphics context gets printed.


  Pageable object -- The client supplies an object that implements interface
  Pageable. The printer calls
  methods in that interface to obtain the pages to be printed, one by one.
  For each page, the printer supplies a graphics context, and whatever
  the client draws in that graphics context gets printed.





  Pre-defined Doc Flavors
  A Java Print Service instance is not required to support the
  following print data formats and print data representation classes.  In
  fact, a developer using this class should never assume that a
  particular print service supports the document types corresponding to
  these pre-defined doc flavors.  Always query the print service
  to determine what doc flavors it supports.  However,
  developers who have print services that support these doc flavors are
  encouraged to refer to the predefined singleton instances created here.


  Plain text print data provided through a byte stream. Specifically, the
  following doc flavors are recommended to be supported:
  ·
  (`text/plain`, `java.io.InputStream`)
  ·
  (`text/plain; charset=us-ascii`, `java.io.InputStream`)
  ·
  (`text/plain; charset=utf-8`, `java.io.InputStream`)


  Renderable image objects. Specifically, the following doc flavor is
  recommended to be supported:
  ·
  (`application/x-java-jvm-local-objectref`, `java.awt.image.renderable.RenderableImage`)


  A Java Print Service instance is allowed to support any other doc flavors
  (or none) in addition to the above mandatory ones, at the implementation's
  choice.

  Support for the above doc flavors is desirable so a printing client can rely
  on being able to print on any JPS printer, regardless of which doc flavors
  the printer supports. If the printer doesn't support the client's preferred
  doc flavor, the client can at least print plain text, or the client can
  convert its data to a renderable image and print the image.

  Furthermore, every Java Print Service instance must fulfill these
  requirements for processing plain text print data:


  The character pair carriage return-line feed (CR-LF) means
  `go to column 1 of the next line.`

  A carriage return (CR) character standing by itself means
  `go to column 1 of the next line.`

  A line feed (LF) character standing by itself means
  `go to column 1 of the next line.`



  The client must itself perform all plain text print data formatting not
  addressed by the above requirements.

  Design Rationale

  Class DocFlavor in package javax.print.data is similar to class
  DataFlavor. Class
  DataFlavor
  is not used in the Java Print Service (JPS) API
  for three reasons which are all rooted in allowing the JPS API to be
  shared by other print services APIs which may need to run on Java profiles
  which do not include all of the Java Platform, Standard Edition.


  The JPS API is designed to be used in Java profiles which do not support
  AWT.


  The implementation of class java.awt.datatransfer.DataFlavor
  does not guarantee that equivalent data flavors will have the same
  serialized representation. DocFlavor does, and can be used in services
  which need this.


  The implementation of class java.awt.datatransfer.DataFlavor
  includes a human presentable name as part of the serialized representation.
  This is not appropriate as part of a service matching constraint.


  Class DocFlavor's serialized representation uses the following
  canonical form of a MIME type string. Thus, two doc flavors with MIME types
  that are not identical but that are equivalent (that have the same
  canonical form) may be considered equal.

   The media type, media subtype, and parameters are retained, but all
       comments and whitespace characters are discarded.
   The media type, media subtype, and parameter names are converted to
       lowercase.
   The parameter values retain their original case, except a charset
       parameter value for a text media type is converted to lowercase.
   Quote characters surrounding parameter values are removed.
   Quoting backslash characters inside parameter values are removed.
   The parameters are arranged in ascending order of parameter name.


  Class DocFlavor's serialized representation also contains the
  fully-qualified class name of the representation class
  (a String object), rather than the representation class itself
  (a Class object). This allows a client to examine the doc flavors a
  Java Print Service instance supports without having
  to load the representation classes, which may be problematic for
  limited-resource clients."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print DocFlavor]))

(defn ->doc-flavor
  "Constructor.

  Constructs a new doc flavor object from the given MIME type and
   representation class name. The given MIME type is converted into
   canonical form and stored internally.

  mime-type - MIME media type string. - `java.lang.String`
  class-name - Fully-qualified representation class name. - `java.lang.String`

  throws: java.lang.NullPointerException - (unchecked exception) Thrown if mimeType is null or className is null."
  ([^java.lang.String mime-type ^java.lang.String class-name]
    (new DocFlavor mime-type class-name)))

(def *-host-encoding
  "Static Constant.

  A String representing the host operating system encoding.
   This will follow the conventions documented in

   RFC 2278: IANA Charset Registration Procedures
   except where historical names are returned for compatibility with
   previous versions of the Java platform.
   The value returned from method is valid only for the VM which
   returns it, for use in a DocFlavor.
   This is the charset for all the `HOST` pre-defined DocFlavors in
   the executing VM.

  type: java.lang.String"
  DocFlavor/hostEncoding)

(defn get-mime-type
  "Returns this doc flavor object's MIME type string based on the
   canonical form. Each parameter value is enclosed in quotes.

  returns: the mime type - `java.lang.String`"
  ([^javax.print.DocFlavor this]
    (-> this (.getMimeType))))

(defn get-media-type
  "Returns this doc flavor object's media type (from the MIME type).

  returns: the media type - `java.lang.String`"
  ([^javax.print.DocFlavor this]
    (-> this (.getMediaType))))

(defn get-media-subtype
  "Returns this doc flavor object's media subtype (from the MIME type).

  returns: the media sub-type - `java.lang.String`"
  ([^javax.print.DocFlavor this]
    (-> this (.getMediaSubtype))))

(defn get-parameter
  "Returns a String representing a MIME
   parameter.
   Mime types may include parameters which are usually optional.
   The charset for text types is a commonly useful example.
   This convenience method will return the value of the specified
   parameter if one was specified in the mime type for this flavor.

  param-name - the name of the paramater. This name is internally converted to the canonical lower case format before performing the match. - `java.lang.String`

  returns: String representing a mime parameter, or
   null if that parameter is not in the mime type string. - `java.lang.String`

  throws: java.lang.NullPointerException - if paramName is null."
  ([^javax.print.DocFlavor this ^java.lang.String param-name]
    (-> this (.getParameter param-name))))

(defn get-representation-class-name
  "Returns the name of this doc flavor object's representation class.

  returns: the name of the representation class. - `java.lang.String`"
  ([^javax.print.DocFlavor this]
    (-> this (.getRepresentationClassName))))

(defn to-string
  "Converts this DocFlavor to a string.

  returns: MIME type string based on the canonical form. Each parameter
            value is enclosed in quotes.
            A `class=` parameter is appended to the
            MIME type string to indicate the representation class name. - `java.lang.String`"
  ([^javax.print.DocFlavor this]
    (-> this (.toString))))

(defn hash-code
  "Returns a hash code for this doc flavor object.

  returns: a hash code value for this object. - `int`"
  ([^javax.print.DocFlavor this]
    (-> this (.hashCode))))

(defn equals
  "Determines if this doc flavor object is equal to the given object.
   The two are equal if the given object is not null, is an instance
   of DocFlavor, has a MIME type equivalent to this doc
   flavor object's MIME type (that is, the MIME types have the same media
   type, media subtype, and parameters), and has the same representation
   class name as this doc flavor object. Thus, if two doc flavor objects'
   MIME types are the same except for comments, they are considered equal.
   However, two doc flavor objects with MIME types of `text/plain` and
   `text/plain; charset=US-ASCII` are not considered equal, even though
   they represent the same media type (because the default character
   set for plain text is US-ASCII).

  obj - Object to test. - `java.lang.Object`

  returns: True if this doc flavor object equals obj, false
            otherwise. - `boolean`"
  ([^javax.print.DocFlavor this ^java.lang.Object obj]
    (-> this (.equals obj))))

