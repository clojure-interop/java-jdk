(ns jdk.awt.image.LookupTable
  "This abstract class defines a lookup table object.  ByteLookupTable
  and ShortLookupTable are subclasses, which
  contain byte and short data, respectively.  A lookup table
  contains data arrays for one or more bands (or components) of an image
  (for example, separate arrays for R, G, and B),
  and it contains an offset which will be subtracted from the
  input values before indexing into the arrays.  This allows an array
  smaller than the native data size to be provided for a
  constrained input.  If there is only one array in the lookup
  table, it will be applied to all bands.  All arrays must be the
  same size."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.image LookupTable]))

(defn get-num-components
  "Returns the number of components in the lookup table.

  returns: the number of components in this LookupTable. - `int`"
  (^Integer [^LookupTable this]
    (-> this (.getNumComponents))))

(defn get-offset
  "Returns the offset.

  returns: the offset of this LookupTable. - `int`"
  (^Integer [^LookupTable this]
    (-> this (.getOffset))))

(defn lookup-pixel
  "Returns an int array of components for
   one pixel.  The dest array contains the
   result of the lookup and is returned.  If dest is
   null, a new array is allocated.  The
   source and destination can be equal.

  src - the source array of components of one pixel - `int[]`
  dest - the destination array of components for one pixel, translated with this LookupTable - `int[]`

  returns: an int array of components for one
           pixel. - `int[]`"
  ([^LookupTable this src dest]
    (-> this (.lookupPixel src dest))))

