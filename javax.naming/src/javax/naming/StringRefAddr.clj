(ns javax.naming.StringRefAddr
  "This class represents the string form of the address of
  a communications end-point.
  It consists of a type that describes the communication mechanism
  and a string contents specific to that communication mechanism.
  The format and interpretation of
  the address type and the contents of the address are based on
  the agreement of three parties: the client that uses the address,
  the object/server that can be reached using the address, and the
  administrator or program that creates the address.

   An example of a string reference address is a host name.
  Another example of a string reference address is a URL.

   A string reference address is immutable:
  once created, it cannot be changed.  Multithreaded access to
  a single StringRefAddr need not be synchronized."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming StringRefAddr]))

(defn ->string-ref-addr
  "Constructor.

  Constructs a new instance of StringRefAddr using its address type
   and contents.

  addr-type - A non-null string describing the type of the address. - `java.lang.String`
  addr - The possibly null contents of the address in the form of a string. - `java.lang.String`"
  (^StringRefAddr [^java.lang.String addr-type ^java.lang.String addr]
    (new StringRefAddr addr-type addr)))

(defn get-content
  "Retrieves the contents of this address. The result is a string.

  returns: The possibly null address contents. - `java.lang.Object`"
  (^java.lang.Object [^StringRefAddr this]
    (-> this (.getContent))))

