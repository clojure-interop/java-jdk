(ns javax.naming.RefAddr
  "This class represents the address of a communications end-point.
  It consists of a type that describes the communication mechanism
  and an address contents determined by an RefAddr subclass.

  For example, an address type could be `BSD Printer Address`,
  which specifies that it is an address to be used with the BSD printing
  protocol. Its contents could be the machine name identifying the
  location of the printer server that understands this protocol.

  A RefAddr is contained within a Reference.

  RefAddr is an abstract class. Concrete implementations of it
  determine its synchronization properties."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming RefAddr]))

(defn get-type
  "Retrieves the address type of this address.

  returns: The non-null address type of this address. - `java.lang.String`"
  ([^javax.naming.RefAddr this]
    (-> this (.getType))))

(defn get-content
  "Retrieves the contents of this address.

  returns: The possibly null address contents. - `java.lang.Object`"
  ([^javax.naming.RefAddr this]
    (-> this (.getContent))))

(defn equals
  "Determines whether obj is equal to this RefAddr.

   obj is equal to this RefAddr all of these conditions are true

   non-null
   instance of RefAddr
   obj has the same address type as this RefAddr (using String.compareTo())
   both obj and this RefAddr's contents are null or they are equal
           (using the equals() test).

  obj - possibly null obj to check. - `java.lang.Object`

  returns: true if obj is equal to this refaddr; false otherwise. - `boolean`"
  ([^javax.naming.RefAddr this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn hash-code
  "Computes the hash code of this address using its address type and contents.
   The hash code is the sum of the hash code of the address type and
   the hash code of the address contents.

  returns: The hash code of this address as an int. - `int`"
  ([^javax.naming.RefAddr this]
    (-> this (.hashCode))))

(defn to-string
  "Generates the string representation of this address.
   The string consists of the address's type and contents with labels.
   This representation is intended for display only and not to be parsed.

  returns: The non-null string representation of this address. - `java.lang.String`"
  ([^javax.naming.RefAddr this]
    (-> this (.toString))))

