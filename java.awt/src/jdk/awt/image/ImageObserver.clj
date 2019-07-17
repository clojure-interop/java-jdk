(ns jdk.awt.image.ImageObserver
  "An asynchronous update interface for receiving notifications about
  Image information as the Image is constructed."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.image ImageObserver]))

(defn image-update
  "This method is called when information about an image which was
   previously requested using an asynchronous interface becomes
   available.  Asynchronous interfaces are method calls such as
   getWidth(ImageObserver) and drawImage(img, x, y, ImageObserver)
   which take an ImageObserver object as an argument.  Those methods
   register the caller as interested either in information about
   the overall image itself (in the case of getWidth(ImageObserver))
   or about an output version of an image (in the case of the
   drawImage(img, x, y, [w, h,] ImageObserver) call).

   This method
   should return true if further updates are needed or false if the
   required information has been acquired.  The image which was being
   tracked is passed in using the img argument.  Various constants
   are combined to form the infoflags argument which indicates what
   information about the image is now available.  The interpretation
   of the x, y, width, and height arguments depends on the contents
   of the infoflags argument.

   The infoflags argument should be the bitwise inclusive
   OR of the following flags: WIDTH,
   HEIGHT, PROPERTIES, SOMEBITS,
   FRAMEBITS, ALLBITS, ERROR,
   ABORT.

  img - the image being observed. - `java.awt.Image`
  infoflags - the bitwise inclusive OR of the following flags: WIDTH, HEIGHT, PROPERTIES, SOMEBITS, FRAMEBITS, ALLBITS, ERROR, ABORT. - `int`
  x - the x coordinate. - `int`
  y - the y coordinate. - `int`
  width - the width. - `int`
  height - the height. - `int`

  returns: false if the infoflags indicate that the
              image is completely loaded; true otherwise. - `boolean`"
  (^Boolean [^java.awt.image.ImageObserver this ^java.awt.Image img ^Integer infoflags ^Integer x ^Integer y ^Integer width ^Integer height]
    (-> this (.imageUpdate img infoflags x y width height))))

