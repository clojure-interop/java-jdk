(ns javax.sql.rowset.serial.SerialException
  "Indicates and an error with the serialization or de-serialization of
  SQL types such as BLOB, CLOB, STRUCT or ARRAY in
  addition to SQL types such as DATALINK and JAVAOBJECT"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sql.rowset.serial SerialException]))

(defn ->serial-exception
  "Constructor.

  Creates a new SerialException with the
   specified message.

  msg - the detail message - `java.lang.String`"
  ([msg]
    (new SerialException msg))
  ([]
    (new SerialException )))

