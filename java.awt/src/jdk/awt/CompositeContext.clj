(ns jdk.awt.CompositeContext
  "The CompositeContext interface defines the encapsulated
  and optimized environment for a compositing operation.
  CompositeContext objects maintain state for
  compositing operations.  In a multi-threaded environment, several
  contexts can exist simultaneously for a single Composite
  object."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt CompositeContext]))

(defn dispose
  "Releases resources allocated for a context."
  ([^java.awt.CompositeContext this]
    (-> this (.dispose))))

(defn compose
  "Composes the two source Raster objects and
   places the result in the destination
   WritableRaster.  Note that the destination
   can be the same object as either the first or second
   source. Note that dstIn and
   dstOut must be compatible with the
   dstColorModel passed to the
   createContext
   method of the Composite interface.

  src - the first source for the compositing operation - `java.awt.image.Raster`
  dst-in - the second source for the compositing operation - `java.awt.image.Raster`
  dst-out - the WritableRaster into which the result of the operation is stored - `java.awt.image.WritableRaster`"
  ([^java.awt.CompositeContext this ^java.awt.image.Raster src ^java.awt.image.Raster dst-in ^java.awt.image.WritableRaster dst-out]
    (-> this (.compose src dst-in dst-out))))

