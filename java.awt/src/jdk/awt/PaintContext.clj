(ns jdk.awt.PaintContext
  "The PaintContext interface defines the encapsulated
  and optimized environment to generate color patterns in device
  space for fill or stroke operations on a
  Graphics2D.  The PaintContext provides
  the necessary colors for Graphics2D operations in the
  form of a Raster associated with a ColorModel.
  The PaintContext maintains state for a particular paint
  operation.  In a multi-threaded environment, several
  contexts can exist simultaneously for a single Paint object."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt PaintContext]))

(defn dispose
  "Releases the resources allocated for the operation."
  ([^. this]
    (-> this (.dispose))))

(defn get-color-model
  "Returns the ColorModel of the output.  Note that
   this ColorModel might be different from the hint
   specified in the
   createContext method of
   Paint.  Not all PaintContext objects are
   capable of generating color patterns in an arbitrary
   ColorModel.

  returns: the ColorModel of the output. - `java.awt.image.ColorModel`"
  ([^. this]
    (-> this (.getColorModel))))

(defn get-raster
  "Returns a Raster containing the colors generated for
   the graphics operation.

  x - the x coordinate of the area in device space for which colors are generated. - `int`
  y - the y coordinate of the area in device space for which colors are generated. - `int`
  w - the width of the area in device space - `int`
  h - the height of the area in device space - `int`

  returns: a Raster representing the specified
   rectangular area and containing the colors generated for
   the graphics operation. - `java.awt.image.Raster`"
  ([^. this ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.getRaster x y w h))))

