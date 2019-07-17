(ns jdk.awt.image.ShortLookupTable
  "This class defines a lookup table object.  The output of a
  lookup operation using an object of this class is interpreted
  as an unsigned short quantity.  The lookup table contains short
  data arrays for one or more bands (or components) of an image,
  and it contains an offset which will be subtracted from the
  input values before indexing the arrays.  This allows an array
  smaller than the native data size to be provided for a
  constrained input.  If there is only one array in the lookup
  table, it will be applied to all bands."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.image ShortLookupTable]))

(defn ->short-lookup-table
  "Constructor.

  Constructs a ShortLookupTable object from an array of short
   arrays representing a lookup table for each
   band.  The offset will be subtracted from the input
   values before indexing into the arrays.  The number of
   bands is the length of the data argument.  The
   data array for each band is stored as a reference.

  offset - the value subtracted from the input values before indexing into the arrays - `int`
  data - an array of short arrays representing a lookup table for each band - `short[][]`"
  ([offset data]
    (new ShortLookupTable offset data)))

(defn get-table
  "Returns the lookup table data by reference.  If this ShortLookupTable
   was constructed using a single short array, the length of the returned
   array is one.

  returns: ShortLookupTable data array. - `short[][]`"
  ([this]
    (-> this (.getTable))))

(defn lookup-pixel
  "Returns an array of samples of a pixel, translated with the lookup
   table. The source and destination array can be the same array.
   Array dst is returned.

  src - the source array. - `int[]`
  dst - the destination array. This array must be at least as long as src. If dst is null, a new array will be allocated having the same length as src. - `int[]`

  returns: the array dst, an int array of
           samples. - `int[]`

  throws: java.lang.ArrayIndexOutOfBoundsException - if src is longer than dst or if for any element i of src, (src[i]&0xffff)-offset is either less than zero or greater than or equal to the length of the lookup table for any band."
  ([this src dst]
    (-> this (.lookupPixel src dst))))

