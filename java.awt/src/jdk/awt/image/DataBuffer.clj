(ns jdk.awt.image.DataBuffer
  "This class exists to wrap one or more data arrays.  Each data array in
  the DataBuffer is referred to as a bank.  Accessor methods for getting
  and setting elements of the DataBuffer's banks exist with and without
  a bank specifier.  The methods without a bank specifier use the default 0th
  bank.  The DataBuffer can optionally take an offset per bank, so that
  data in an existing array can be used even if the interesting data
  doesn't start at array location zero.  Getting or setting the 0th
  element of a bank, uses the (0+offset)th element of the array.  The
  size field specifies how much of the data array is available for
  use.  Size  offset for a given bank should never be greater
  than the length of the associated data array.  The data type of
  a data buffer indicates the type of the data array(s) and may also
  indicate additional semantics, e.g. storing unsigned 8-bit data
  in elements of a byte array.  The data type may be TYPE_UNDEFINED
  or one of the types defined below.  Other types may be added in
  the future.  Generally, an object of class DataBuffer will be cast down
  to one of its data type specific subclasses to access data type specific
  methods for improved performance.  Currently, the Java 2D(tm) API
  image classes use TYPE_BYTE, TYPE_USHORT, TYPE_INT, TYPE_SHORT,
  TYPE_FLOAT, and TYPE_DOUBLE DataBuffers to store image data."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.image DataBuffer]))

(def *-type-byte
  "Static Constant.

  Tag for unsigned byte data.

  type: java.lang.annotation.    int"
  DataBuffer/TYPE_BYTE)

(def *-type-ushort
  "Static Constant.

  Tag for unsigned short data.

  type: java.lang.annotation.    int"
  DataBuffer/TYPE_USHORT)

(def *-type-short
  "Static Constant.

  Tag for signed short data.  Placeholder for future use.

  type: java.lang.annotation.    int"
  DataBuffer/TYPE_SHORT)

(def *-type-int
  "Static Constant.

  Tag for int data.

  type: java.lang.annotation.    int"
  DataBuffer/TYPE_INT)

(def *-type-float
  "Static Constant.

  Tag for float data.  Placeholder for future use.

  type: java.lang.annotation.    int"
  DataBuffer/TYPE_FLOAT)

(def *-type-double
  "Static Constant.

  Tag for double data.  Placeholder for future use.

  type: java.lang.annotation.    int"
  DataBuffer/TYPE_DOUBLE)

(def *-type-undefined
  "Static Constant.

  Tag for undefined data.

  type: java.lang.annotation.    int"
  DataBuffer/TYPE_UNDEFINED)

(defn *get-data-type-size
  "Returns the size (in bits) of the data type, given a datatype tag.

  type - the value of one of the defined datatype tags - `int`

  returns: the size of the data type - `int`

  throws: java.lang.IllegalArgumentException - if type is less than zero or greater than TYPE_DOUBLE"
  ([^Integer type]
    (DataBuffer/getDataTypeSize type)))

(defn get-elem-double
  "Returns the requested data array element from the specified bank as
   a double.  The implementation in this class is to cast getElem(bank, i)
   to a double.  Subclasses may override this method if another
   implementation is needed.

  bank - the specified bank - `int`
  i - the specified index - `int`

  returns: a double value representing the element from the specified
   bank at the specified index in the data array. - `double`"
  ([^java.awt.image.DataBuffer this ^Integer bank ^Integer i]
    (-> this (.getElemDouble bank i)))
  ([^java.awt.image.DataBuffer this ^Integer i]
    (-> this (.getElemDouble i))))

(defn get-elem
  "Returns the requested data array element from the specified bank
   as an integer.

  bank - the specified bank - `int`
  i - the index of the requested data array element - `int`

  returns: the data array element at the specified index from the
           specified bank at the specified index. - `int`"
  ([^java.awt.image.DataBuffer this ^Integer bank ^Integer i]
    (-> this (.getElem bank i)))
  ([^java.awt.image.DataBuffer this ^Integer i]
    (-> this (.getElem i))))

(defn get-data-type
  "Returns the data type of this DataBuffer.

  returns: the data type of this DataBuffer. - `int`"
  ([^java.awt.image.DataBuffer this]
    (-> this (.getDataType))))

(defn get-num-banks
  "Returns the number of banks in this DataBuffer.

  returns: the number of banks. - `int`"
  ([^java.awt.image.DataBuffer this]
    (-> this (.getNumBanks))))

(defn set-elem-float
  "Sets the requested data array element in the specified bank
   from the given float.  The implementation in this class is to cast
   val to an int and call setElem(int, int).  Subclasses can
   override this method if another implementation is needed.

  bank - the specified bank - `int`
  i - the specified index - `int`
  val - the value to set the element in the specified bank at the specified index in the data array - `float`"
  ([^java.awt.image.DataBuffer this ^Integer bank ^Integer i ^Float val]
    (-> this (.setElemFloat bank i val)))
  ([^java.awt.image.DataBuffer this ^Integer i ^Float val]
    (-> this (.setElemFloat i val))))

(defn get-elem-float
  "Returns the requested data array element from the specified bank
   as a float.  The implementation in this class is to cast
   getElem(int, int)
   to a float.  Subclasses can override this method if another
   implementation is needed.

  bank - the specified bank - `int`
  i - the index of the requested data array element - `int`

  returns: a float value representing the data array element from the
   specified bank at the specified index. - `float`"
  ([^java.awt.image.DataBuffer this ^Integer bank ^Integer i]
    (-> this (.getElemFloat bank i)))
  ([^java.awt.image.DataBuffer this ^Integer i]
    (-> this (.getElemFloat i))))

(defn get-offset
  "Returns the offset of the default bank in array elements.

  returns: the offset of the default bank. - `int`"
  ([^java.awt.image.DataBuffer this]
    (-> this (.getOffset))))

(defn get-offsets
  "Returns the offsets (in array elements) of all the banks.

  returns: the offsets of all banks. - `int[]`"
  ([^java.awt.image.DataBuffer this]
    (-> this (.getOffsets))))

(defn set-elem-double
  "Sets the requested data array element in the specified bank
   from the given double.  The implementation in this class is to cast
   val to an int and call setElem(int, int).  Subclasses can
   override this method if another implementation is needed.

  bank - the specified bank - `int`
  i - the specified index - `int`
  val - the value to set the element in the specified bank at the specified index of the data array - `double`"
  ([^java.awt.image.DataBuffer this ^Integer bank ^Integer i ^Double val]
    (-> this (.setElemDouble bank i val)))
  ([^java.awt.image.DataBuffer this ^Integer i ^Double val]
    (-> this (.setElemDouble i val))))

(defn get-size
  "Returns the size (in array elements) of all banks.

  returns: the size of all banks. - `int`"
  ([^java.awt.image.DataBuffer this]
    (-> this (.getSize))))

(defn set-elem
  "Sets the requested data array element in the specified bank
   from the given integer.

  bank - the specified bank - `int`
  i - the specified index into the data array - `int`
  val - the data to set the element in the specified bank at the specified index in the data array - `int`"
  ([^java.awt.image.DataBuffer this ^Integer bank ^Integer i ^Integer val]
    (-> this (.setElem bank i val)))
  ([^java.awt.image.DataBuffer this ^Integer i ^Integer val]
    (-> this (.setElem i val))))

