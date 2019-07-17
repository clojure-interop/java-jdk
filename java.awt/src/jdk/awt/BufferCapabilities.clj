(ns jdk.awt.BufferCapabilities
  "Capabilities and properties of buffers."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt BufferCapabilities]))

(defn ->buffer-capabilities
  "Constructor.

  Creates a new object for specifying buffering capabilities

  front-caps - the capabilities of the front buffer; cannot be null - `java.awt.ImageCapabilities`
  back-caps - the capabilities of the back and intermediate buffers; cannot be null - `java.awt.ImageCapabilities`
  flip-contents - the contents of the back buffer after page-flipping, null if page flipping is not used (implies blitting) - `java.awt.BufferCapabilities.FlipContents`

  throws: java.lang.IllegalArgumentException - if frontCaps or backCaps are null"
  ([front-caps back-caps flip-contents]
    (new BufferCapabilities front-caps back-caps flip-contents)))

(defn get-front-buffer-capabilities
  "returns: the image capabilities of the front (displayed) buffer - `java.awt.ImageCapabilities`"
  ([this]
    (-> this (.getFrontBufferCapabilities))))

(defn get-back-buffer-capabilities
  "returns: the image capabilities of all back buffers (intermediate buffers
   are considered back buffers) - `java.awt.ImageCapabilities`"
  ([this]
    (-> this (.getBackBufferCapabilities))))

(defn page-flipping?
  "returns: whether or not the buffer strategy uses page flipping; a set of
   buffers that uses page flipping
   can swap the contents internally between the front buffer and one or
   more back buffers by switching the video pointer (or by copying memory
   internally).  A non-flipping set of
   buffers uses blitting to copy the contents from one buffer to
   another; when this is the case, getFlipContents returns
   null - `boolean`"
  ([this]
    (-> this (.isPageFlipping))))

(defn get-flip-contents
  "returns: the resulting contents of the back buffer after page-flipping.
   This value is null when the isPageFlipping
   returns false, implying blitting.  It can be one of
   FlipContents.UNDEFINED
   (the assumed default), FlipContents.BACKGROUND,
   FlipContents.PRIOR, or
   FlipContents.COPIED. - `java.awt.BufferCapabilities.FlipContents`"
  ([this]
    (-> this (.getFlipContents))))

(defn full-screen-required?
  "returns: whether page flipping is only available in full-screen mode.  If this
   is true, full-screen exclusive mode is required for
   page-flipping. - `boolean`"
  ([this]
    (-> this (.isFullScreenRequired))))

(defn multi-buffer-available?
  "returns: whether or not
   page flipping can be performed using more than two buffers (one or more
   intermediate buffers as well as the front and back buffer). - `boolean`"
  ([this]
    (-> this (.isMultiBufferAvailable))))

(defn clone
  "Description copied from class: Object

  returns: a copy of this BufferCapabilities object. - `java.lang.Object`"
  ([this]
    (-> this (.clone))))

