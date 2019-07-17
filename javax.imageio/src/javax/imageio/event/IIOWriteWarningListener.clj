(ns javax.imageio.event.IIOWriteWarningListener
  "An interface used by ImageWriter implementations to
  notify callers of their image and thumbnail reading methods of
  warnings (non-fatal errors).  Fatal errors cause the relevant
  read method to throw an IIOException.

   Localization is handled by associating a Locale
  with each IIOWriteWarningListener as it is registered
  with an ImageWriter.  It is up to the
  ImageWriter to provide localized messages."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.imageio.event IIOWriteWarningListener]))

(defn warning-occurred
  "Reports the occurrence of a non-fatal error in encoding.  Encoding
   will continue following the call to this method.  The application
   may choose to display a dialog, print the warning to the console,
   ignore the warning, or take any other action it chooses.

  source - the ImageWriter object calling this method. - `javax.imageio.ImageWriter`
  image-index - the index, starting with 0, of the image generating the warning. - `int`
  warning - a String containing the warning. - `java.lang.String`"
  ([this source image-index warning]
    (-> this (.warningOccurred source image-index warning))))

