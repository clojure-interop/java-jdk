(ns javax.xml.bind.annotation.adapters.HexBinaryAdapter
  "XmlAdapter for xs:hexBinary.


  This XmlAdapter binds byte[] to the hexBinary representation in XML."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.bind.annotation.adapters HexBinaryAdapter]))

(defn ->hex-binary-adapter
  "Constructor."
  ([]
    (new HexBinaryAdapter )))

(defn unmarshal
  "Description copied from class: XmlAdapter

  s - The value to be converted. Can be null. - `java.lang.String`

  returns: `byte[]`"
  ([^javax.xml.bind.annotation.adapters.HexBinaryAdapter this ^java.lang.String s]
    (-> this (.unmarshal s))))

(defn marshal
  "Description copied from class: XmlAdapter

  bytes - The value to be convereted. Can be null. - `byte[]`

  returns: `java.lang.String`"
  ([^javax.xml.bind.annotation.adapters.HexBinaryAdapter this bytes]
    (-> this (.marshal bytes))))

