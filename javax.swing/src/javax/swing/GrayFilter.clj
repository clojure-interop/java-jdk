(ns javax.swing.GrayFilter
  "An image filter that `disables` an image by turning
  it into a grayscale image, and brightening the pixels
  in the image. Used by buttons to create an image for
  a disabled button."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing GrayFilter]))

(defn ->gray-filter
  "Constructor.

  Constructs a GrayFilter object that filters a color image to a
   grayscale image. Used by buttons to create disabled (`grayed out`)
   button images.

  b - a boolean -- true if the pixels should be brightened - `boolean`
  p - an int in the range 0..100 that determines the percentage of gray, where 100 is the darkest gray, and 0 is the lightest - `int`"
  ([b p]
    (new GrayFilter b p)))

(defn *create-disabled-image
  "Creates a disabled image

  i - `java.awt.Image`

  returns: `java.awt.Image`"
  ([i]
    (GrayFilter/createDisabledImage i)))

(defn filter-rgb
  "Overrides RGBImageFilter.filterRGB.

  x - the X coordinate of the pixel - `int`
  y - the Y coordinate of the pixel - `int`
  rgb - the integer pixel representation in the default RGB color model - `int`

  returns: a filtered pixel in the default RGB color model. - `int`"
  ([this x y rgb]
    (-> this (.filterRGB x y rgb))))

