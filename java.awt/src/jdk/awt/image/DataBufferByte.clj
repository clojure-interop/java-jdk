(ns jdk.awt.image.DataBufferByte
  "This class extends DataBuffer and stores data internally as bytes.
  Values stored in the byte array(s) of this DataBuffer are treated as
  unsigned values.


  Note that some implementations may function more efficiently
  if they can maintain control over how the data for an image is
  stored.
  For example, optimizations such as caching an image in video
  memory require that the implementation track all modifications
  to that data.
  Other implementations may operate better if they can store the
  data in locations other than a Java array.
  To maintain optimum compatibility with various optimizations
  it is best to avoid constructors and methods which expose the
  underlying storage as a Java array, as noted below in the
  documentation for those methods."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.image DataBufferByte]))

(defn ->data-buffer-byte
  "Constructor.

  Constructs a byte-based DataBuffer with a single bank using the
   specified array, size, and offset.  dataArray must have at least
   offset  size elements.  Only elements offset
   through offset  size - 1
   should be used by accessors of this DataBuffer.

   Note that DataBuffer objects created by this constructor
   may be incompatible with performance
   optimizations used by some implementations (such as caching
   an associated image in video memory).

  data-array - The byte array for the DataBuffer. - `byte[]`
  size - The size of the DataBuffer bank. - `int`
  offset - The offset into the dataArray. dataArray must have at least offset size elements. - `int`"
  (^DataBufferByte [data-array ^Integer size ^Integer offset]
    (new DataBufferByte data-array size offset))
  (^DataBufferByte [^Integer size ^Integer num-banks]
    (new DataBufferByte size num-banks))
  (^DataBufferByte [^Integer size]
    (new DataBufferByte size)))

(defn get-data
  "Returns the data array for the specified bank.

   Note that calling this method may cause this DataBuffer
   object to be incompatible with performance
   optimizations used by some implementations (such as caching
   an associated image in video memory).

  bank - The bank whose data array you want to get. - `int`

  returns: The data array for the specified bank. - `byte[]`"
  ([^DataBufferByte this ^Integer bank]
    (-> this (.getData bank)))
  ([^DataBufferByte this]
    (-> this (.getData))))

(defn get-bank-data
  "Returns the data arrays for all banks.

   Note that calling this method may cause this DataBuffer
   object to be incompatible with performance
   optimizations used by some implementations (such as caching
   an associated image in video memory).

  returns: All of the data arrays. - `byte[][]`"
  ([^DataBufferByte this]
    (-> this (.getBankData))))

(defn get-elem
  "Returns the requested data array element from the specified bank.

  bank - The bank from which you want to get a data array element. - `int`
  i - The data array element you want to get. - `int`

  returns: The requested data array element as an integer. - `int`"
  (^Integer [^DataBufferByte this ^Integer bank ^Integer i]
    (-> this (.getElem bank i)))
  (^Integer [^DataBufferByte this ^Integer i]
    (-> this (.getElem i))))

(defn set-elem
  "Sets the requested data array element in the specified bank
   from the given integer.

  bank - The bank in which you want to set the data array element. - `int`
  i - The data array element you want to set. - `int`
  val - The integer value to which you want to set the specified data array element. - `int`"
  ([^DataBufferByte this ^Integer bank ^Integer i ^Integer val]
    (-> this (.setElem bank i val)))
  ([^DataBufferByte this ^Integer i ^Integer val]
    (-> this (.setElem i val))))

