(ns javax.net.ssl.SNIServerName
  "Instances of this class represent a server name in a Server Name
  Indication (SNI) extension.

  The SNI extension is a feature that extends the SSL/TLS protocols to
  indicate what server name the client is attempting to connect to during
  handshaking.  See section 3, `Server Name Indication`, of TLS Extensions (RFC 6066).

  SNIServerName objects are immutable.  Subclasses should not provide
  methods that can change the state of an instance once it has been created."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.net.ssl SNIServerName]))

(defn get-type
  "Returns the name type of this server name.

  returns: the name type of this server name - `int`"
  (^Integer [^javax.net.ssl.SNIServerName this]
    (-> this (.getType))))

(defn get-encoded
  "Returns a copy of the encoded server name value of this server name.

  returns: a copy of the encoded server name value of this server name - `byte[]`"
  ([^javax.net.ssl.SNIServerName this]
    (-> this (.getEncoded))))

(defn equals
  "Indicates whether some other object is `equal to` this server name.

  other - the reference object with which to compare. - `java.lang.Object`

  returns: true if, and only if, other is of the same class
           of this object, and has the same name type and
           encoded value as this server name. - `boolean`"
  (^Boolean [^javax.net.ssl.SNIServerName this ^java.lang.Object other]
    (-> this (.equals other))))

(defn hash-code
  "Returns a hash code value for this server name.

   The hash code value is generated using the name type and encoded
   value of this server name.

  returns: a hash code value for this server name. - `int`"
  (^Integer [^javax.net.ssl.SNIServerName this]
    (-> this (.hashCode))))

(defn to-string
  "Returns a string representation of this server name, including the server
   name type and the encoded server name value in this
   SNIServerName object.

   The exact details of the representation are unspecified and subject
   to change, but the following may be regarded as typical:


       `type= <name type>, value= <name value>`

   In this class, the format of `<name type>` is
   `[LITERAL] (INTEGER)`, where the optional `LITERAL` is the literal
   name, and INTEGER is the integer value of the name type.  The format
   of `<name value>` is `XX:...:XX`, where `XX` is the
   hexadecimal digit representation of a byte value. For example, a
   returned value of an pseudo server name may look like:


       `type=(31), value=77:77:77:2E:65:78:61:6D:70:6C:65:2E:63:6E`
   or


       `type=host_name (0), value=77:77:77:2E:65:78:61:6D:70:6C:65:2E:63:6E`


   Please NOTE that the exact details of the representation are unspecified
   and subject to change, and subclasses may override the method with
   their own formats.

  returns: a string representation of this server name - `java.lang.String`"
  (^java.lang.String [^javax.net.ssl.SNIServerName this]
    (-> this (.toString))))

