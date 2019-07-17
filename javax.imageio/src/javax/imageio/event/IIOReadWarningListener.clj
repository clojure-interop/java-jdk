(ns javax.imageio.event.IIOReadWarningListener
  "An interface used by ImageReader implementations to
  notify callers of their image and thumbnail reading methods of
  warnings (non-fatal errors).  Fatal errors cause the relevant
  read method to throw an IIOException.

   Localization is handled by associating a Locale
  with each IIOReadWarningListener as it is registered
  with an ImageReader.  It is up to the
  ImageReader to provide localized messages."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.imageio.event IIOReadWarningListener]))

(defn warning-occurred
  "Reports the occurrence of a non-fatal error in decoding.  Decoding
   will continue following the call to this method.  The application
   may choose to display a dialog, print the warning to the console,
   ignore the warning, or take any other action it chooses.

  source - the ImageReader object calling this method. - `javax.imageio.ImageReader`
  warning - a String containing the warning. - `java.lang.String`"
  ([^. this ^javax.imageio.ImageReader source ^java.lang.String warning]
    (-> this (.warningOccurred source warning))))

