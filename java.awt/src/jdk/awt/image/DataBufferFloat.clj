(ns jdk.awt.image.DataBufferFloat
  "This class extends DataBuffer and stores data internally
  in float form.


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
  (:import [java.awt.image DataBufferFloat]))

(defn ->data-buffer-float
  "Constructor.

  Constructs a float-based DataBuffer
   with the specified data array.  Only the elements between
   offset and offset  size - 1 are
   available for use by this DataBuffer.  The array
   must be large enough to hold offset  size
   elements.

   Note that DataBuffer objects created by this constructor
   may be incompatible with performance
   optimizations used by some implementations (such as caching
   an associated image in video memory).

  data-array - An array of floats to be used as the first and only bank of this DataBuffer. - `float[]`
  size - The number of elements of the array to be used. - `int`
  offset - The offset of the first element of the array that will be used. - `int`"
  ([data-array size offset]
    (new DataBufferFloat data-array size offset))
  ([size num-banks]
    (new DataBufferFloat size num-banks))
  ([size]
    (new DataBufferFloat size)))

(defn get-data
  "Returns the data array for the specified bank.

   Note that calling this method may cause this DataBuffer
   object to be incompatible with performance
   optimizations used by some implementations (such as caching
   an associated image in video memory).

  bank - the data array - `int`

  returns: the data array specified by bank. - `float[]`"
  ([this bank]
    (-> this (.getData bank)))
  ([this]
    (-> this (.getData))))

(defn get-bank-data
  "Returns the data array for all banks.

   Note that calling this method may cause this DataBuffer
   object to be incompatible with performance
   optimizations used by some implementations (such as caching
   an associated image in video memory).

  returns: all data arrays for this data buffer. - `float[][]`"
  ([this]
    (-> this (.getBankData))))

(defn get-elem
  "Returns the requested data array element from the specified
   bank as an int.

  bank - The bank number. - `int`
  i - The desired data array element. - `int`

  returns: The data entry as an int. - `int`"
  ([this bank i]
    (-> this (.getElem bank i)))
  ([this i]
    (-> this (.getElem i))))

(defn set-elem
  "Sets the requested data array element in the specified bank to
   the given int.

  bank - The bank number. - `int`
  i - The desired data array element. - `int`
  val - The value to be set. - `int`"
  ([this bank i val]
    (-> this (.setElem bank i val)))
  ([this i val]
    (-> this (.setElem i val))))

(defn get-elem-float
  "Returns the requested data array element from the specified
   bank as a float.

  bank - The bank number. - `int`
  i - The desired data array element. - `int`

  returns: The data entry as a float. - `float`"
  ([this bank i]
    (-> this (.getElemFloat bank i)))
  ([this i]
    (-> this (.getElemFloat i))))

(defn set-elem-float
  "Sets the requested data array element in the specified bank to
   the given float.

  bank - The bank number. - `int`
  i - The desired data array element. - `int`
  val - The value to be set. - `float`"
  ([this bank i val]
    (-> this (.setElemFloat bank i val)))
  ([this i val]
    (-> this (.setElemFloat i val))))

(defn get-elem-double
  "Returns the requested data array element from the specified
   bank as a double.

  bank - The bank number. - `int`
  i - The desired data array element. - `int`

  returns: The data entry as a double. - `double`"
  ([this bank i]
    (-> this (.getElemDouble bank i)))
  ([this i]
    (-> this (.getElemDouble i))))

(defn set-elem-double
  "Sets the requested data array element in the specified bank to
   the given double.

  bank - The bank number. - `int`
  i - The desired data array element. - `int`
  val - The value to be set. - `double`"
  ([this bank i val]
    (-> this (.setElemDouble bank i val)))
  ([this i val]
    (-> this (.setElemDouble i val))))

