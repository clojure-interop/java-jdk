(ns jdk.awt.Image
  "The abstract class Image is the superclass of all
  classes that represent graphical images. The image must be
  obtained in a platform-specific manner."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt Image]))

(defn ->image
  "Constructor."
  ([]
    (new Image )))

(def *-undefined-property
  "Static Constant.

  The UndefinedProperty object should be returned whenever a
   property which was not defined for a particular image is fetched.

  type: java.lang.Object"
  Image/UndefinedProperty)

(def *-scale-default
  "Static Constant.

  Use the default image-scaling algorithm.

  type: int"
  Image/SCALE_DEFAULT)

(def *-scale-fast
  "Static Constant.

  Choose an image-scaling algorithm that gives higher priority
   to scaling speed than smoothness of the scaled image.

  type: int"
  Image/SCALE_FAST)

(def *-scale-smooth
  "Static Constant.

  Choose an image-scaling algorithm that gives higher priority
   to image smoothness than scaling speed.

  type: int"
  Image/SCALE_SMOOTH)

(def *-scale-replicate
  "Static Constant.

  Use the image scaling algorithm embodied in the
   ReplicateScaleFilter class.
   The Image object is free to substitute a different filter
   that performs the same algorithm yet integrates more efficiently
   into the imaging infrastructure supplied by the toolkit.

  type: int"
  Image/SCALE_REPLICATE)

(def *-scale-area-averaging
  "Static Constant.

  Use the Area Averaging image scaling algorithm.  The
   image object is free to substitute a different filter that
   performs the same algorithm yet integrates more efficiently
   into the image infrastructure supplied by the toolkit.

  type: int"
  Image/SCALE_AREA_AVERAGING)

(defn get-width
  "Determines the width of the image. If the width is not yet known,
   this method returns -1 and the specified
   ImageObserver object is notified later.

  observer - an object waiting for the image to be loaded. - `java.awt.image.ImageObserver`

  returns: the width of this image, or -1
                     if the width is not yet known. - `int`"
  (^Integer [^java.awt.Image this ^java.awt.image.ImageObserver observer]
    (-> this (.getWidth observer))))

(defn get-scaled-instance
  "Creates a scaled version of this image.
   A new Image object is returned which will render
   the image at the specified width and
   height by default.  The new Image object
   may be loaded asynchronously even if the original source image
   has already been loaded completely.



   If either width
   or height is a negative number then a value is
   substituted to maintain the aspect ratio of the original image
   dimensions. If both width and height
   are negative, then the original image dimensions are used.

  width - the width to which to scale the image. - `int`
  height - the height to which to scale the image. - `int`
  hints - flags to indicate the type of algorithm to use for image resampling. - `int`

  returns: a scaled version of the image. - `java.awt.Image`

  throws: java.lang.IllegalArgumentException - if width or height is zero."
  (^java.awt.Image [^java.awt.Image this ^Integer width ^Integer height ^Integer hints]
    (-> this (.getScaledInstance width height hints))))

(defn get-graphics
  "Creates a graphics context for drawing to an off-screen image.
   This method can only be called for off-screen images.

  returns: a graphics context to draw to the off-screen image. - `java.awt.Graphics`

  throws: java.lang.UnsupportedOperationException - if called for a non-off-screen image."
  (^java.awt.Graphics [^java.awt.Image this]
    (-> this (.getGraphics))))

(defn flush
  "Flushes all reconstructable resources being used by this Image object.
   This includes any pixel data that is being cached for rendering to
   the screen as well as any system resources that are being used
   to store data or pixels for the image if they can be recreated.
   The image is reset to a state similar to when it was first created
   so that if it is again rendered, the image data will have to be
   recreated or fetched again from its source.

   Examples of how this method affects specific types of Image object:


   BufferedImage objects leave the primary Raster which stores their
   pixels untouched, but flush any information cached about those
   pixels such as copies uploaded to the display hardware for
   accelerated blits.

   Image objects created by the Component methods which take a
   width and height leave their primary buffer of pixels untouched,
   but have all cached information released much like is done for
   BufferedImage objects.

   VolatileImage objects release all of their pixel resources
   including their primary copy which is typically stored on
   the display hardware where resources are scarce.
   These objects can later be restored using their
   validate
   method.

   Image objects created by the Toolkit and Component classes which are
   loaded from files, URLs or produced by an ImageProducer
   are unloaded and all local resources are released.
   These objects can later be reloaded from their original source
   as needed when they are rendered, just as when they were first
   created."
  ([^java.awt.Image this]
    (-> this (.flush))))

(defn get-acceleration-priority
  "Returns the current value of the acceleration priority hint.

  returns: value between 0 and 1, inclusive, which represents the current
   priority value - `float`"
  (^Float [^java.awt.Image this]
    (-> this (.getAccelerationPriority))))

(defn get-source
  "Gets the object that produces the pixels for the image.
   This method is called by the image filtering classes and by
   methods that perform image conversion and scaling.

  returns: the image producer that produces the pixels
                                    for this image. - `java.awt.image.ImageProducer`"
  (^java.awt.image.ImageProducer [^java.awt.Image this]
    (-> this (.getSource))))

(defn get-height
  "Determines the height of the image. If the height is not yet known,
   this method returns -1 and the specified
   ImageObserver object is notified later.

  observer - an object waiting for the image to be loaded. - `java.awt.image.ImageObserver`

  returns: the height of this image, or -1
                     if the height is not yet known. - `int`"
  (^Integer [^java.awt.Image this ^java.awt.image.ImageObserver observer]
    (-> this (.getHeight observer))))

(defn get-property
  "Gets a property of this image by name.

   Individual property names are defined by the various image
   formats. If a property is not defined for a particular image, this
   method returns the UndefinedProperty object.

   If the properties for this image are not yet known, this method
   returns null, and the ImageObserver
   object is notified later.

   The property name `comment` should be used to store
   an optional comment which can be presented to the application as a
   description of the image, its source, or its author.

  name - a property name. - `java.lang.String`
  observer - an object waiting for this image to be loaded. - `java.awt.image.ImageObserver`

  returns: the value of the named property. - `java.lang.Object`

  throws: java.lang.NullPointerException - if the property name is null."
  (^java.lang.Object [^java.awt.Image this ^java.lang.String name ^java.awt.image.ImageObserver observer]
    (-> this (.getProperty name observer))))

(defn get-capabilities
  "Returns an ImageCapabilities object which can be
   inquired as to the capabilities of this
   Image on the specified GraphicsConfiguration.
   This allows programmers to find
   out more runtime information on the specific Image
   object that they have created.  For example, the user
   might create a BufferedImage but the system may have
   no video memory left for creating an image of that
   size on the given GraphicsConfiguration, so although the object
   may be acceleratable in general, it
   does not have that capability on this GraphicsConfiguration.

  gc - a GraphicsConfiguration object. A value of null for this parameter will result in getting the image capabilities for the default GraphicsConfiguration. - `java.awt.GraphicsConfiguration`

  returns: an ImageCapabilities object that contains
   the capabilities of this Image on the specified
   GraphicsConfiguration. - `java.awt.ImageCapabilities`"
  (^java.awt.ImageCapabilities [^java.awt.Image this ^java.awt.GraphicsConfiguration gc]
    (-> this (.getCapabilities gc))))

(defn set-acceleration-priority
  "Sets a hint for this image about how important acceleration is.
   This priority hint is used to compare to the priorities of other
   Image objects when determining how to use scarce acceleration
   resources such as video memory.  When and if it is possible to
   accelerate this Image, if there are not enough resources available
   to provide that acceleration but enough can be freed up by
   de-accelerating some other image of lower priority, then that other
   Image may be de-accelerated in deference to this one.  Images
   that have the same priority take up resources on a first-come,
   first-served basis.

  priority - a value between 0 and 1, inclusive, where higher values indicate more importance for acceleration. A value of 0 means that this Image should never be accelerated. Other values are used simply to determine acceleration priority relative to other Images. - `float`

  throws: java.lang.IllegalArgumentException - if priority is less than zero or greater than 1."
  ([^java.awt.Image this ^Float priority]
    (-> this (.setAccelerationPriority priority))))

