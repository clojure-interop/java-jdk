(ns javax.imageio.stream.IIOByteBuffer
  "A class representing a mutable reference to an array of bytes and
  an offset and length within that array.  IIOByteBuffer
  is used by ImageInputStream to supply a sequence of bytes
  to the caller, possibly with fewer copies than using the conventional
  read methods that take a user-supplied byte array.

   The byte array referenced by an IIOByteBuffer will
  generally be part of an internal data structure belonging to an
  ImageReader implementation; its contents should be
  considered read-only and must not be modified."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.imageio.stream IIOByteBuffer]))

(defn ->iio-byte-buffer
  "Constructor.

  Constructs an IIOByteBuffer that references a
   given byte array, offset, and length.

  data - a byte array. - `byte[]`
  offset - an int offset within the array. - `int`
  length - an int specifying the length of the data of interest within byte array, in bytes. - `int`"
  ([data offset length]
    (new IIOByteBuffer data offset length)))

(defn get-data
  "Returns a reference to the byte array.  The returned value should
   be treated as read-only, and only the portion specified by the
   values of getOffset and getLength should
   be used.

  returns: a byte array reference. - `byte[]`"
  ([this]
    (-> this (.getData))))

(defn set-data
  "Updates the array reference that will be returned by subsequent calls
   to the getData method.

  data - a byte array reference containing the new data value. - `byte[]`"
  ([this data]
    (-> this (.setData data))))

(defn get-offset
  "Returns the offset within the byte array returned by
   getData at which the data of interest start.

  returns: an int offset. - `int`"
  ([this]
    (-> this (.getOffset))))

(defn set-offset
  "Updates the value that will be returned by subsequent calls
   to the getOffset method.

  offset - an int containing the new offset value. - `int`"
  ([this offset]
    (-> this (.setOffset offset))))

(defn get-length
  "Returns the length of the data of interest within the byte
   array returned by getData.

  returns: an int length. - `int`"
  ([this]
    (-> this (.getLength))))

(defn set-length
  "Updates the value that will be returned by subsequent calls
   to the getLength method.

  length - an int containing the new length value. - `int`"
  ([this length]
    (-> this (.setLength length))))

