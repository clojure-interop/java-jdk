(ns jdk.awt.image.ByteLookupTable
  "This class defines a lookup table object.  The output of a
  lookup operation using an object of this class is interpreted
  as an unsigned byte quantity.  The lookup table contains byte
  data arrays for one or more bands (or components) of an image,
  and it contains an offset which will be subtracted from the
  input values before indexing the arrays.  This allows an array
  smaller than the native data size to be provided for a
  constrained input.  If there is only one array in the lookup
  table, it will be applied to all bands."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.image ByteLookupTable]))

(defn ->byte-lookup-table
  "Constructor.

  Constructs a ByteLookupTable object from an array of byte
   arrays representing a lookup table for each
   band.  The offset will be subtracted from input
   values before indexing into the arrays.  The number of
   bands is the length of the data argument.  The
   data array for each band is stored as a reference.

  offset - the value subtracted from the input values before indexing into the arrays - `int`
  data - an array of byte arrays representing a lookup table for each band - `byte[][]`

  throws: java.lang.IllegalArgumentException - if offset is is less than 0 or if the length of data is less than 1"
  ([^Integer offset data]
    (new ByteLookupTable offset data)))

(defn get-table
  "Returns the lookup table data by reference.  If this ByteLookupTable
   was constructed using a single byte array, the length of the returned
   array is one.

  returns: the data array of this ByteLookupTable. - `byte[][]`"
  ([^java.awt.image.ByteLookupTable this]
    (-> this (.getTable))))

(defn lookup-pixel
  "Returns an array of samples of a pixel, translated with the lookup
   table. The source and destination array can be the same array.
   Array dst is returned.

  src - the source array. - `int[]`
  dst - the destination array. This array must be at least as long as src. If dst is null, a new array will be allocated having the same length as src. - `int[]`

  returns: the array dst, an int array of
           samples. - `int[]`

  throws: java.lang.ArrayIndexOutOfBoundsException - if src is longer than dst or if for any element i of src, src[i]-offset is either less than zero or greater than or equal to the length of the lookup table for any band."
  ([^java.awt.image.ByteLookupTable this src dst]
    (-> this (.lookupPixel src dst))))

