(ns jdk.net.URLConnection
  "The abstract class URLConnection is the superclass
  of all classes that represent a communications link between the
  application and a URL. Instances of this class can be used both to
  read from and to write to the resource referenced by the URL. In
  general, creating a connection to a URL is a multistep process:


  openConnection()
      connect()
  Manipulate parameters that affect the connection to the remote
          resource.
      Interact with the resource; query header fields and
          contents.

  ---------------------------->
  time


  The connection object is created by invoking the
      openConnection method on a URL.
  The setup parameters and general request properties are manipulated.
  The actual connection to the remote object is made, using the
     connect method.
  The remote object becomes available. The header fields and the contents
      of the remote object can be accessed.


  The setup parameters are modified using the following methods:

    setAllowUserInteraction
    setDoInput
    setDoOutput
    setIfModifiedSince
    setUseCaches


  and the general request properties are modified using the method:

    setRequestProperty


  Default values for the AllowUserInteraction and
  UseCaches parameters can be set using the methods
  setDefaultAllowUserInteraction and
  setDefaultUseCaches.

  Each of the above set methods has a corresponding
  get method to retrieve the value of the parameter or
  general request property. The specific parameters and general
  request properties that are applicable are protocol specific.

  The following methods are used to access the header fields and
  the contents after the connection is made to the remote object:

    getContent
    getHeaderField
    getInputStream
    getOutputStream


  Certain header fields are accessed frequently. The methods:

    getContentEncoding
    getContentLength
    getContentType
    getDate
    getExpiration
    getLastModifed


  provide convenient access to these fields. The
  getContentType method is used by the
  getContent method to determine the type of the remote
  object; subclasses may find it convenient to override the
  getContentType method.

  In the common case, all of the pre-connection parameters and
  general request properties can be ignored: the pre-connection
  parameters and request properties default to sensible values. For
  most clients of this interface, there are only two interesting
  methods: getInputStream and getContent,
  which are mirrored in the URL class by convenience methods.

  More information on the request properties and header fields of
  an http connection can be found at:


  http://www.ietf.org/rfc/rfc2616.txt

  Invoking the close() methods on the InputStream or OutputStream of an
  URLConnection after a request may free network resources associated with this
  instance, unless particular protocol specifications specify different behaviours
  for it."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.net URLConnection]))

(defn *get-default-allow-user-interaction?
  "Returns the default value of the allowUserInteraction
   field.

   Ths default is `sticky`, being a part of the static state of all
   URLConnections.  This flag applies to the next, and all following
   URLConnections that are created.

  returns: the default value of the allowUserInteraction
            field. - `boolean`"
  (^Boolean []
    (URLConnection/getDefaultAllowUserInteraction )))

(defn *set-default-allow-user-interaction
  "Sets the default value of the
   allowUserInteraction field for all future
   URLConnection objects to the specified value.

  defaultallowuserinteraction - the new value. - `boolean`"
  ([^Boolean defaultallowuserinteraction]
    (URLConnection/setDefaultAllowUserInteraction defaultallowuserinteraction)))

(defn *set-default-request-property
  "Deprecated. The instance specific setRequestProperty method
   should be used after an appropriate instance of URLConnection
   is obtained. Invoking this method will have no effect.

  key - the keyword by which the request is known (e.g., `Accept`). - `java.lang.String`
  value - the value associated with the key. - `java.lang.String`"
  ([^java.lang.String key ^java.lang.String value]
    (URLConnection/setDefaultRequestProperty key value)))

(defn *set-file-name-map
  "Sets the FileNameMap.

   If there is a security manager, this method first calls
   the security manager's checkSetFactory method
   to ensure the operation is allowed.
   This could result in a SecurityException.

  map - the FileNameMap to be set - `java.net.FileNameMap`

  throws: java.lang.SecurityException - if a security manager exists and its checkSetFactory method doesn't allow the operation."
  ([^java.net.FileNameMap map]
    (URLConnection/setFileNameMap map)))

(defn *guess-content-type-from-name
  "Tries to determine the content type of an object, based
   on the specified `file` component of a URL.
   This is a convenience method that can be used by
   subclasses that override the getContentType method.

  fname - a filename. - `java.lang.String`

  returns: a guess as to what the content type of the object is,
            based upon its file name. - `java.lang.String`"
  (^java.lang.String [^java.lang.String fname]
    (URLConnection/guessContentTypeFromName fname)))

(defn *get-default-request-property
  "Deprecated. The instance specific getRequestProperty method
   should be used after an appropriate instance of URLConnection
   is obtained.

  key - the keyword by which the request is known (e.g., `Accept`). - `java.lang.String`

  returns: the value of the default request property
   for the specified key. - `java.lang.String`"
  (^java.lang.String [^java.lang.String key]
    (URLConnection/getDefaultRequestProperty key)))

(defn *guess-content-type-from-stream
  "Tries to determine the type of an input stream based on the
   characters at the beginning of the input stream. This method can
   be used by subclasses that override the
   getContentType method.

   Ideally, this routine would not be needed. But many
   http servers return the incorrect content type; in
   addition, there are many nonstandard extensions. Direct inspection
   of the bytes to determine the content type is often more accurate
   than believing the content type claimed by the http server.

  is - an input stream that supports marks. - `java.io.InputStream`

  returns: a guess at the content type, or null if none
               can be determined. - `java.lang.String`

  throws: java.io.IOException - if an I/O error occurs while reading the input stream."
  (^java.lang.String [^java.io.InputStream is]
    (URLConnection/guessContentTypeFromStream is)))

(defn *get-file-name-map
  "Loads filename map (a mimetable) from a data file. It will
   first try to load the user-specific table, defined
   by `content.types.user.table` property. If that fails,
   it tries to load the default built-in table.

  returns: the FileNameMap - `java.net.FileNameMap`"
  (^java.net.FileNameMap []
    (URLConnection/getFileNameMap )))

(defn *set-content-handler-factory
  "Sets the ContentHandlerFactory of an
   application. It can be called at most once by an application.

   The ContentHandlerFactory instance is used to
   construct a content handler from a content type

   If there is a security manager, this method first calls
   the security manager's checkSetFactory method
   to ensure the operation is allowed.
   This could result in a SecurityException.

  fac - the desired factory. - `java.net.ContentHandlerFactory`

  throws: java.lang.Error - if the factory has already been defined."
  ([^java.net.ContentHandlerFactory fac]
    (URLConnection/setContentHandlerFactory fac)))

(defn get-header-field
  "Returns the value of the named header field.

   If called on a connection that sets the same header multiple times
   with possibly different values, only the last value is returned.

  name - the name of a header field. - `java.lang.String`

  returns: the value of the named header field, or null
            if there is no such field in the header. - `java.lang.String`"
  (^java.lang.String [^URLConnection this ^java.lang.String name]
    (-> this (.getHeaderField name))))

(defn set-allow-user-interaction
  "Set the value of the allowUserInteraction field of
   this URLConnection.

  allowuserinteraction - the new value. - `boolean`

  throws: java.lang.IllegalStateException - if already connected"
  ([^URLConnection this ^Boolean allowuserinteraction]
    (-> this (.setAllowUserInteraction allowuserinteraction))))

(defn add-request-property
  "Adds a general request property specified by a
   key-value pair.  This method will not overwrite
   existing values associated with the same key.

  key - the keyword by which the request is known (e.g., `Accept`). - `java.lang.String`
  value - the value associated with it. - `java.lang.String`

  throws: java.lang.IllegalStateException - if already connected"
  ([^URLConnection this ^java.lang.String key ^java.lang.String value]
    (-> this (.addRequestProperty key value))))

(defn get-read-timeout
  "Returns setting for read timeout. 0 return implies that the
   option is disabled (i.e., timeout of infinity).

  returns: an int that indicates the read timeout
           value in milliseconds - `int`"
  (^Integer [^URLConnection this]
    (-> this (.getReadTimeout))))

(defn get-allow-user-interaction?
  "Returns the value of the allowUserInteraction field for
   this object.

  returns: the value of the allowUserInteraction field for
            this object. - `boolean`"
  (^Boolean [^URLConnection this]
    (-> this (.getAllowUserInteraction))))

(defn get-if-modified-since
  "Returns the value of this object's ifModifiedSince field.

  returns: the value of this object's ifModifiedSince field. - `long`"
  (^Long [^URLConnection this]
    (-> this (.getIfModifiedSince))))

(defn get-do-input?
  "Returns the value of this URLConnection's
   doInput flag.

  returns: the value of this URLConnection's
            doInput flag. - `boolean`"
  (^Boolean [^URLConnection this]
    (-> this (.getDoInput))))

(defn get-use-caches?
  "Returns the value of this URLConnection's
   useCaches field.

  returns: the value of this URLConnection's
            useCaches field. - `boolean`"
  (^Boolean [^URLConnection this]
    (-> this (.getUseCaches))))

(defn get-header-field-key
  "Returns the key for the nth header field.
   It returns null if there are fewer than n+1 fields.

  n - an index, where n>=0 - `int`

  returns: the key for the nth header field,
            or null if there are fewer than n+1
            fields. - `java.lang.String`"
  (^java.lang.String [^URLConnection this ^Integer n]
    (-> this (.getHeaderFieldKey n))))

(defn get-header-field-int
  "Returns the value of the named field parsed as a number.

   This form of getHeaderField exists because some
   connection types (e.g., http-ng) have pre-parsed
   headers. Classes for that connection type can override this method
   and short-circuit the parsing.

  name - the name of the header field. - `java.lang.String`
  default - the default value. - `int`

  returns: the value of the named field, parsed as an integer. The
            Default value is returned if the field is
            missing or malformed. - `int`"
  (^Integer [^URLConnection this ^java.lang.String name ^Integer default]
    (-> this (.getHeaderFieldInt name default))))

(defn set-if-modified-since
  "Sets the value of the ifModifiedSince field of
   this URLConnection to the specified value.

  ifmodifiedsince - the new value. - `long`

  throws: java.lang.IllegalStateException - if already connected"
  ([^URLConnection this ^Long ifmodifiedsince]
    (-> this (.setIfModifiedSince ifmodifiedsince))))

(defn get-content-encoding
  "Returns the value of the content-encoding header field.

  returns: the content encoding of the resource that the URL references,
            or null if not known. - `java.lang.String`"
  (^java.lang.String [^URLConnection this]
    (-> this (.getContentEncoding))))

(defn to-string
  "Returns a String representation of this URL connection.

  returns: a string representation of this URLConnection. - `java.lang.String`"
  (^java.lang.String [^URLConnection this]
    (-> this (.toString))))

(defn get-header-field-long
  "Returns the value of the named field parsed as a number.

   This form of getHeaderField exists because some
   connection types (e.g., http-ng) have pre-parsed
   headers. Classes for that connection type can override this method
   and short-circuit the parsing.

  name - the name of the header field. - `java.lang.String`
  default - the default value. - `long`

  returns: the value of the named field, parsed as a long. The
            Default value is returned if the field is
            missing or malformed. - `long`"
  (^Long [^URLConnection this ^java.lang.String name ^Long default]
    (-> this (.getHeaderFieldLong name default))))

(defn get-content-type
  "Returns the value of the content-type header field.

  returns: the content type of the resource that the URL references,
            or null if not known. - `java.lang.String`"
  (^java.lang.String [^URLConnection this]
    (-> this (.getContentType))))

(defn get-last-modified
  "Returns the value of the last-modified header field.
   The result is the number of milliseconds since January 1, 1970 GMT.

  returns: the date the resource referenced by this
            URLConnection was last modified, or 0 if not known. - `long`"
  (^Long [^URLConnection this]
    (-> this (.getLastModified))))

(defn get-request-properties
  "Returns an unmodifiable Map of general request
   properties for this connection. The Map keys
   are Strings that represent the request-header
   field names. Each Map value is a unmodifiable List
   of Strings that represents the corresponding
   field values.

  returns: a Map of the general request properties for this connection. - `java.util.Map<java.lang.String,java.util.List<java.lang.String>>`

  throws: java.lang.IllegalStateException - if already connected"
  (^java.util.Map [^URLConnection this]
    (-> this (.getRequestProperties))))

(defn get-header-field-date
  "Returns the value of the named field parsed as date.
   The result is the number of milliseconds since January 1, 1970 GMT
   represented by the named field.

   This form of getHeaderField exists because some
   connection types (e.g., http-ng) have pre-parsed
   headers. Classes for that connection type can override this method
   and short-circuit the parsing.

  name - the name of the header field. - `java.lang.String`
  default - a default value. - `long`

  returns: the value of the field, parsed as a date. The value of the
            Default argument is returned if the field is
            missing or malformed. - `long`"
  (^Long [^URLConnection this ^java.lang.String name ^Long default]
    (-> this (.getHeaderFieldDate name default))))

(defn get-date
  "Returns the value of the date header field.

  returns: the sending date of the resource that the URL references,
            or 0 if not known. The value returned is the
            number of milliseconds since January 1, 1970 GMT. - `long`"
  (^Long [^URLConnection this]
    (-> this (.getDate))))

(defn get-content-length-long
  "Returns the value of the content-length header field as a
   long.

  returns: the content length of the resource that this connection's URL
            references, or -1 if the content length is
            not known. - `long`"
  (^Long [^URLConnection this]
    (-> this (.getContentLengthLong))))

(defn set-use-caches
  "Sets the value of the useCaches field of this
   URLConnection to the specified value.

   Some protocols do caching of documents.  Occasionally, it is important
   to be able to `tunnel through` and ignore the caches (e.g., the
   `reload` button in a browser).  If the UseCaches flag on a connection
   is true, the connection is allowed to use whatever caches it can.
    If false, caches are to be ignored.
    The default value comes from DefaultUseCaches, which defaults to
   true.

  usecaches - a boolean indicating whether or not to allow caching - `boolean`

  throws: java.lang.IllegalStateException - if already connected"
  ([^URLConnection this ^Boolean usecaches]
    (-> this (.setUseCaches usecaches))))

(defn connect
  "Opens a communications link to the resource referenced by this
   URL, if such a connection has not already been established.

   If the connect method is called when the connection
   has already been opened (indicated by the connected
   field having the value true), the call is ignored.

   URLConnection objects go through two phases: first they are
   created, then they are connected.  After being created, and
   before being connected, various options can be specified
   (e.g., doInput and UseCaches).  After connecting, it is an
   error to try to set them.  Operations that depend on being
   connected, like getContentLength, will implicitly perform the
   connection, if necessary.

  throws: java.net.SocketTimeoutException - if the timeout expires before the connection can be established"
  ([^URLConnection this]
    (-> this (.connect))))

(defn get-do-output?
  "Returns the value of this URLConnection's
   doOutput flag.

  returns: the value of this URLConnection's
            doOutput flag. - `boolean`"
  (^Boolean [^URLConnection this]
    (-> this (.getDoOutput))))

(defn set-do-input
  "Sets the value of the doInput field for this
   URLConnection to the specified value.

   A URL connection can be used for input and/or output.  Set the DoInput
   flag to true if you intend to use the URL connection for input,
   false if not.  The default is true.

  doinput - the new value. - `boolean`

  throws: java.lang.IllegalStateException - if already connected"
  ([^URLConnection this ^Boolean doinput]
    (-> this (.setDoInput doinput))))

(defn set-request-property
  "Sets the general request property. If a property with the key already
   exists, overwrite its value with the new value.

    NOTE: HTTP requires all request properties which can
   legally have multiple instances with the same key
   to use a comma-separated list syntax which enables multiple
   properties to be appended into a single property.

  key - the keyword by which the request is known (e.g., `Accept`). - `java.lang.String`
  value - the value associated with it. - `java.lang.String`

  throws: java.lang.IllegalStateException - if already connected"
  ([^URLConnection this ^java.lang.String key ^java.lang.String value]
    (-> this (.setRequestProperty key value))))

(defn get-request-property
  "Returns the value of the named general request property for this
   connection.

  key - the keyword by which the request is known (e.g., `Accept`). - `java.lang.String`

  returns: the value of the named general request property for this
             connection. If key is null, then null is returned. - `java.lang.String`

  throws: java.lang.IllegalStateException - if already connected"
  (^java.lang.String [^URLConnection this ^java.lang.String key]
    (-> this (.getRequestProperty key))))

(defn get-output-stream
  "Returns an output stream that writes to this connection.

  returns: an output stream that writes to this connection. - `java.io.OutputStream`

  throws: java.io.IOException - if an I/O error occurs while creating the output stream."
  (^java.io.OutputStream [^URLConnection this]
    (-> this (.getOutputStream))))

(defn get-default-use-caches?
  "Returns the default value of a URLConnection's
   useCaches flag.

   Ths default is `sticky`, being a part of the static state of all
   URLConnections.  This flag applies to the next, and all following
   URLConnections that are created.

  returns: the default value of a URLConnection's
            useCaches flag. - `boolean`"
  (^Boolean [^URLConnection this]
    (-> this (.getDefaultUseCaches))))

(defn set-read-timeout
  "Sets the read timeout to a specified timeout, in
   milliseconds. A non-zero value specifies the timeout when
   reading from Input stream when a connection is established to a
   resource. If the timeout expires before there is data available
   for read, a java.net.SocketTimeoutException is raised. A
   timeout of zero is interpreted as an infinite timeout.

   Some non-standard implementation of this method ignores the
   specified timeout. To see the read timeout set, please call
   getReadTimeout().

  timeout - an int that specifies the timeout value to be used in milliseconds - `int`

  throws: java.lang.IllegalArgumentException - if the timeout parameter is negative"
  ([^URLConnection this ^Integer timeout]
    (-> this (.setReadTimeout timeout))))

(defn get-header-fields
  "Returns an unmodifiable Map of the header fields.
   The Map keys are Strings that represent the
   response-header field names. Each Map value is an
   unmodifiable List of Strings that represents
   the corresponding field values.

  returns: a Map of header fields - `java.util.Map<java.lang.String,java.util.List<java.lang.String>>`"
  (^java.util.Map [^URLConnection this]
    (-> this (.getHeaderFields))))

(defn get-expiration
  "Returns the value of the expires header field.

  returns: the expiration date of the resource that this URL references,
            or 0 if not known. The value is the number of milliseconds since
            January 1, 1970 GMT. - `long`"
  (^Long [^URLConnection this]
    (-> this (.getExpiration))))

(defn get-connect-timeout
  "Returns setting for connect timeout.

   0 return implies that the option is disabled
   (i.e., timeout of infinity).

  returns: an int that indicates the connect timeout
           value in milliseconds - `int`"
  (^Integer [^URLConnection this]
    (-> this (.getConnectTimeout))))

(defn get-url
  "Returns the value of this URLConnection's URL
   field.

  returns: the value of this URLConnection's URL
            field. - `java.net.URL`"
  (^java.net.URL [^URLConnection this]
    (-> this (.getURL))))

(defn get-input-stream
  "Returns an input stream that reads from this open connection.

   A SocketTimeoutException can be thrown when reading from the
   returned input stream if the read timeout expires before data
   is available for read.

  returns: an input stream that reads from this open connection. - `java.io.InputStream`

  throws: java.io.IOException - if an I/O error occurs while creating the input stream."
  (^java.io.InputStream [^URLConnection this]
    (-> this (.getInputStream))))

(defn get-permission
  "Returns a permission object representing the permission
   necessary to make the connection represented by this
   object. This method returns null if no permission is
   required to make the connection. By default, this method
   returns java.security.AllPermission. Subclasses
   should override this method and return the permission
   that best represents the permission required to make a
   a connection to the URL. For example, a URLConnection
   representing a file: URL would return a
   java.io.FilePermission object.

   The permission returned may dependent upon the state of the
   connection. For example, the permission before connecting may be
   different from that after connecting. For example, an HTTP
   sever, say foo.com, may redirect the connection to a different
   host, say bar.com. Before connecting the permission returned by
   the connection will represent the permission needed to connect
   to foo.com, while the permission returned after connecting will
   be to bar.com.

   Permissions are generally used for two purposes: to protect
   caches of objects obtained through URLConnections, and to check
   the right of a recipient to learn about a particular URL. In
   the first case, the permission should be obtained
   after the object has been obtained. For example, in an
   HTTP connection, this will represent the permission to connect
   to the host from which the data was ultimately fetched. In the
   second case, the permission should be obtained and tested
   before connecting.

  returns: the permission object representing the permission
   necessary to make the connection represented by this
   URLConnection. - `java.security.Permission`

  throws: java.io.IOException - if the computation of the permission requires network or file I/O and an exception occurs while computing it."
  (^java.security.Permission [^URLConnection this]
    (-> this (.getPermission))))

(defn set-connect-timeout
  "Sets a specified timeout value, in milliseconds, to be used
   when opening a communications link to the resource referenced
   by this URLConnection.  If the timeout expires before the
   connection can be established, a
   java.net.SocketTimeoutException is raised. A timeout of zero is
   interpreted as an infinite timeout.

    Some non-standard implementation of this method may ignore
   the specified timeout. To see the connect timeout set, please
   call getConnectTimeout().

  timeout - an int that specifies the connect timeout value in milliseconds - `int`

  throws: java.lang.IllegalArgumentException - if the timeout parameter is negative"
  ([^URLConnection this ^Integer timeout]
    (-> this (.setConnectTimeout timeout))))

(defn get-content-length
  "Returns the value of the content-length header field.

   Note: getContentLengthLong()
   should be preferred over this method, since it returns a long
   instead and is therefore more portable.

  returns: the content length of the resource that this connection's URL
            references, -1 if the content length is not known,
            or if the content length is greater than Integer.MAX_VALUE. - `int`"
  (^Integer [^URLConnection this]
    (-> this (.getContentLength))))

(defn set-do-output
  "Sets the value of the doOutput field for this
   URLConnection to the specified value.

   A URL connection can be used for input and/or output.  Set the DoOutput
   flag to true if you intend to use the URL connection for output,
   false if not.  The default is false.

  dooutput - the new value. - `boolean`

  throws: java.lang.IllegalStateException - if already connected"
  ([^URLConnection this ^Boolean dooutput]
    (-> this (.setDoOutput dooutput))))

(defn get-content
  "Retrieves the contents of this URL connection.

  classes - the Class array indicating the requested types - `java.lang.Class[]`

  returns: the object fetched that is the first match of the type
                 specified in the classes array. null if none of
                 the requested types are supported.
                 The instanceof operator should be used to
                 determine the specific kind of object returned. - `java.lang.Object`

  throws: java.io.IOException - if an I/O error occurs while getting the content."
  (^java.lang.Object [^URLConnection this classes]
    (-> this (.getContent classes)))
  (^java.lang.Object [^URLConnection this]
    (-> this (.getContent))))

(defn set-default-use-caches
  "Sets the default value of the useCaches field to the
   specified value.

  defaultusecaches - the new value. - `boolean`"
  ([^URLConnection this ^Boolean defaultusecaches]
    (-> this (.setDefaultUseCaches defaultusecaches))))

