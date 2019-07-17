(ns javax.sql.rowset.serial.SerialDatalink
  "A serialized mapping in the Java programming language of an SQL
  DATALINK value. A DATALINK value
  references a file outside of the underlying data source that the
  data source manages.

  RowSet implementations can use the method RowSet.getURL
  to retrieve a java.net.URL object, which can be used
  to manipulate the external data.


       java.net.URL url = rowset.getURL(1);

   Thread safety

  A SerialDatalink is not safe for use by multiple concurrent threads.  If a
  SerialDatalink is to be used by more than one thread then access to the
  SerialDatalink should be controlled by appropriate synchronization."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sql.rowset.serial SerialDatalink]))

(defn ->serial-datalink
  "Constructor.

  Constructs a new SerialDatalink object from the given
   java.net.URL object.

  url - the URL to create the SerialDataLink from - `java.net.URL`

  throws: javax.sql.rowset.serial.SerialException - if url parameter is a null"
  ([url]
    (new SerialDatalink url)))

(defn get-datalink
  "Returns a new URL that is a copy of this SerialDatalink
   object.

  returns: a copy of this SerialDatalink object as a
   URL object in the Java programming language. - `java.net.URL`

  throws: javax.sql.rowset.serial.SerialException - if the URL object cannot be de-serialized"
  ([this]
    (-> this (.getDatalink))))

(defn equals
  "Compares this SerialDatalink to the specified object.
   The result is true if and only if the argument is not
   null and is a SerialDatalink object whose URL is
   identical to this object's URL

  obj - The object to compare this SerialDatalink against - `java.lang.Object`

  returns: true if the given object represents a SerialDatalink
            equivalent to this SerialDatalink, false otherwise - `boolean`"
  ([this obj]
    (-> this (.equals obj))))

(defn hash-code
  "Returns a hash code for this SerialDatalink. The hash code for a
   SerialDatalink object is taken as the hash code of
   the URL it stores

  returns: a hash code value for this object. - `int`"
  ([this]
    (-> this (.hashCode))))

(defn clone
  "Returns a clone of this SerialDatalink.

  returns: a clone of this SerialDatalink - `java.lang.Object`"
  ([this]
    (-> this (.clone))))

