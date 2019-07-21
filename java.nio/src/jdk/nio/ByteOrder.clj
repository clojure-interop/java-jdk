(ns jdk.nio.ByteOrder
  "A typesafe enumeration for byte orders."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio ByteOrder]))

(def *-big-endian
  "Static Constant.

  Constant denoting big-endian byte order.  In this order, the bytes of a
   multibyte value are ordered from most significant to least significant.

  type: java.nio.ByteOrder"
  ByteOrder/BIG_ENDIAN)

(def *-little-endian
  "Static Constant.

  Constant denoting little-endian byte order.  In this order, the bytes of
   a multibyte value are ordered from least significant to most
   significant.

  type: java.nio.ByteOrder"
  ByteOrder/LITTLE_ENDIAN)

(defn *native-order
  "Retrieves the native byte order of the underlying platform.

    This method is defined so that performance-sensitive Java code can
   allocate direct buffers with the same byte order as the hardware.
   Native code libraries are often more efficient when such buffers are
   used.

  returns: The native byte order of the hardware upon which this Java
            virtual machine is running - `java.nio.ByteOrder`"
  (^java.nio.ByteOrder []
    (ByteOrder/nativeOrder )))

(defn to-string
  "Constructs a string describing this object.

    This method returns the string \"BIG_ENDIAN\" for BIG_ENDIAN and \"LITTLE_ENDIAN\" for LITTLE_ENDIAN.

  returns: The specified string - `java.lang.String`"
  (^java.lang.String [^ByteOrder this]
    (-> this (.toString))))

