(ns jdk.awt.image.DataBufferInt
  "This class extends DataBuffer and stores data internally
  as integers.


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
  underlying storage as a Java array as noted below in the
  documentation for those methods."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.image DataBufferInt]))

(defn ->data-buffer-int
  "Constructor.

  Constructs an integer-based DataBuffer with a single bank using the
   specified array, size, and offset.  dataArray must have at least
   offset  size elements.  Only elements offset
   through offset  size - 1
   should be used by accessors of this DataBuffer.

   Note that DataBuffer objects created by this constructor
   may be incompatible with performance
   optimizations used by some implementations (such as caching
   an associated image in video memory).

  data-array - The integer array for the DataBuffer. - `int[]`
  size - The size of the DataBuffer bank. - `int`
  offset - The offset into the dataArray. - `int`"
  (^DataBufferInt [data-array ^Integer size ^Integer offset]
    (new DataBufferInt data-array size offset))
  (^DataBufferInt [^Integer size ^Integer num-banks]
    (new DataBufferInt size num-banks))
  (^DataBufferInt [^Integer size]
    (new DataBufferInt size)))

(defn get-data
  "Returns the data array for the specified bank.

   Note that calling this method may cause this DataBuffer
   object to be incompatible with performance
   optimizations used by some implementations (such as caching
   an associated image in video memory).

  bank - The bank whose data array you want to get. - `int`

  returns: The data array for the specified bank. - `int[]`"
  ([^DataBufferInt this ^Integer bank]
    (-> this (.getData bank)))
  ([^DataBufferInt this]
    (-> this (.getData))))

(defn get-bank-data
  "Returns the data arrays for all banks.

   Note that calling this method may cause this DataBuffer
   object to be incompatible with performance
   optimizations used by some implementations (such as caching
   an associated image in video memory).

  returns: All of the data arrays. - `int[][]`"
  ([^DataBufferInt this]
    (-> this (.getBankData))))

(defn get-elem
  "Returns the requested data array element from the specified bank.

  bank - The bank from which you want to get a data array element. - `int`
  i - The data array element you want to get. - `int`

  returns: The requested data array element as an integer. - `int`"
  (^Integer [^DataBufferInt this ^Integer bank ^Integer i]
    (-> this (.getElem bank i)))
  (^Integer [^DataBufferInt this ^Integer i]
    (-> this (.getElem i))))

(defn set-elem
  "Sets the requested data array element in the specified bank
   to the integer value i.

  bank - The bank in which you want to set the data array element. - `int`
  i - The data array element you want to set. - `int`
  val - The integer value to which you want to set the specified data array element. - `int`"
  ([^DataBufferInt this ^Integer bank ^Integer i ^Integer val]
    (-> this (.setElem bank i val)))
  ([^DataBufferInt this ^Integer i ^Integer val]
    (-> this (.setElem i val))))

