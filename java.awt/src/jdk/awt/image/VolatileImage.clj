(ns jdk.awt.image.VolatileImage
  "VolatileImage is an image which can lose its
  contents at any time due to circumstances beyond the control of the
  application (e.g., situations caused by the operating system or by
  other applications). Because of the potential for hardware acceleration,
  a VolatileImage object can have significant performance benefits on
  some platforms.

  The drawing surface of an image (the memory where the image contents
  actually reside) can be lost or invalidated, causing the contents of that
  memory to go away.  The drawing surface thus needs to be restored
  or recreated and the contents of that surface need to be
  re-rendered.  VolatileImage provides an interface for
  allowing the user to detect these problems and fix them
  when they occur.

  When a VolatileImage object is created, limited system resources
  such as video memory (VRAM) may be allocated in order to support
  the image.
  When a VolatileImage object is no longer used, it may be
  garbage-collected and those system resources will be returned,
  but this process does not happen at guaranteed times.
  Applications that create many VolatileImage objects (for example,
  a resizing window may force recreation of its back buffer as the
  size changes) may run out of optimal system resources for new
  VolatileImage objects simply because the old objects have not
  yet been removed from the system.
  (New VolatileImage objects may still be created, but they
  may not perform as well as those created in accelerated
  memory).
  The flush method may be called at any time to proactively release
  the resources used by a VolatileImage so that it does not prevent
  subsequent VolatileImage objects from being accelerated.
  In this way, applications can have more control over the state
  of the resources taken up by obsolete VolatileImage objects.

  This image should not be subclassed directly but should be created
  by using the Component.createVolatileImage or
  GraphicsConfiguration.createCompatibleVolatileImage(int, int) methods.

  An example of using a VolatileImage object follows:


  // image creation
  VolatileImage vImg = createVolatileImage(w, h);


  // rendering to the image
  void renderOffscreen() {
       do {
           if (vImg.validate(getGraphicsConfiguration()) ==
               VolatileImage.IMAGE_INCOMPATIBLE)
           {
               // old vImg doesn't work with new GraphicsConfig; re-create it
               vImg = createVolatileImage(w, h);
           }
           Graphics2D g = vImg.createGraphics();
           //
           // miscellaneous rendering commands...
           //
           g.dispose();
       } while (vImg.contentsLost());
  }


  // copying from the image (here, gScreen is the Graphics
  // object for the onscreen window)
  do {
       int returnCode = vImg.validate(getGraphicsConfiguration());
       if (returnCode == VolatileImage.IMAGE_RESTORED) {
           // Contents need to be restored
           renderOffscreen();      // restore contents
       } else if (returnCode == VolatileImage.IMAGE_INCOMPATIBLE) {
           // old vImg doesn't work with new GraphicsConfig; re-create it
           vImg = createVolatileImage(w, h);
           renderOffscreen();
       }
       gScreen.drawImage(vImg, 0, 0, this);
  } while (vImg.contentsLost());

  Note that this class subclasses from the Image class, which
  includes methods that take an ImageObserver parameter for
  asynchronous notifications as information is received from
  a potential ImageProducer.  Since this VolatileImage
  is not loaded from an asynchronous source, the various methods that take
  an ImageObserver parameter will behave as if the data has
  already been obtained from the ImageProducer.
  Specifically, this means that the return values from such methods
  will never indicate that the information is not yet available and
  the ImageObserver used in such methods will never
  need to be recorded for an asynchronous callback notification."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.image VolatileImage]))

(defn ->volatile-image
  "Constructor."
  (^VolatileImage []
    (new VolatileImage )))

(def *-image-ok
  "Static Constant.

  Validated image is ready to use as-is.

  type: int"
  VolatileImage/IMAGE_OK)

(def *-image-restored
  "Static Constant.

  Validated image has been restored and is now ready to use.
   Note that restoration causes contents of the image to be lost.

  type: int"
  VolatileImage/IMAGE_RESTORED)

(def *-image-incompatible
  "Static Constant.

  Validated image is incompatible with supplied
   GraphicsConfiguration object and should be
   re-created as appropriate.  Usage of the image as-is
   after receiving this return code from validate
   is undefined.

  type: int"
  VolatileImage/IMAGE_INCOMPATIBLE)

(defn get-transparency
  "Returns the transparency.  Returns either OPAQUE, BITMASK,
   or TRANSLUCENT.

  returns: the transparency of this VolatileImage. - `int`"
  (^Integer [^VolatileImage this]
    (-> this (.getTransparency))))

(defn get-width
  "Returns the width of the VolatileImage.

  returns: the width of this VolatileImage. - `int`"
  (^Integer [^VolatileImage this]
    (-> this (.getWidth))))

(defn get-snapshot
  "Returns a static snapshot image of this object.  The
   BufferedImage returned is only current with
   the VolatileImage at the time of the request
   and will not be updated with any future changes to the
   VolatileImage.

  returns: a BufferedImage representation of this
            VolatileImage - `java.awt.image.BufferedImage`"
  (^java.awt.image.BufferedImage [^VolatileImage this]
    (-> this (.getSnapshot))))

(defn validate
  "Attempts to restore the drawing surface of the image if the surface
   had been lost since the last validate call.  Also
   validates this image against the given GraphicsConfiguration
   parameter to see whether operations from this image to the
   GraphicsConfiguration are compatible.  An example of an
   incompatible combination might be a situation where a VolatileImage
   object was created on one graphics device and then was used
   to render to a different graphics device.  Since VolatileImage
   objects tend to be very device-specific, this operation might
   not work as intended, so the return code from this validate
   call would note that incompatibility.  A null or incorrect
   value for gc may cause incorrect values to be returned from
   validate and may cause later problems with rendering.

  gc - a GraphicsConfiguration object for this image to be validated against. A null gc implies that the validate method should skip the compatibility test. - `java.awt.GraphicsConfiguration`

  returns: IMAGE_OK if the image did not need validation
            IMAGE_RESTORED if the image needed restoration.
            Restoration implies that the contents of the image may have
            been affected and the image may need to be re-rendered.
            IMAGE_INCOMPATIBLE if the image is incompatible
            with the GraphicsConfiguration object passed
            into the validate method.  Incompatibility
            implies that the image may need to be recreated with a
            new Component or
            GraphicsConfiguration in order to get an image
            that can be used successfully with this
            GraphicsConfiguration.
            An incompatible image is not checked for whether restoration
            was necessary, so the state of the image is unchanged
            after a return value of IMAGE_INCOMPATIBLE
            and this return value implies nothing about whether the
            image needs to be restored. - `int`"
  (^Integer [^VolatileImage this ^java.awt.GraphicsConfiguration gc]
    (-> this (.validate gc))))

(defn get-graphics
  "This method returns a Graphics2D, but is here
   for backwards compatibility.  createGraphics is more
   convenient, since it is declared to return a
   Graphics2D.

  returns: a Graphics2D, which can be used to draw into
            this image. - `java.awt.Graphics`"
  (^java.awt.Graphics [^VolatileImage this]
    (-> this (.getGraphics))))

(defn contents-lost
  "Returns true if rendering data was lost since last
   validate call.  This method should be called by the
   application at the end of any series of rendering operations to
   or from the image to see whether
   the image needs to be validated and the rendering redone.

  returns: true if the drawing surface needs to be restored;
   false otherwise. - `boolean`"
  (^Boolean [^VolatileImage this]
    (-> this (.contentsLost))))

(defn get-source
  "This returns an ImageProducer for this VolatileImage.
   Note that the VolatileImage object is optimized for
   rendering operations and blitting to the screen or other
   VolatileImage objects, as opposed to reading back the
   pixels of the image.  Therefore, operations such as
   getSource may not perform as fast as
   operations that do not rely on reading the pixels.
   Note also that the pixel values read from the image are current
   with those in the image only at the time that they are
   retrieved. This method takes a snapshot
   of the image at the time the request is made and the
   ImageProducer object returned works with
   that static snapshot image, not the original VolatileImage.
   Calling getSource()
   is equivalent to calling getSnapshot().getSource().

  returns: an ImageProducer that can be used to produce the
   pixels for a BufferedImage representation of
   this Image. - `java.awt.image.ImageProducer`"
  (^java.awt.image.ImageProducer [^VolatileImage this]
    (-> this (.getSource))))

(defn get-height
  "Returns the height of the VolatileImage.

  returns: the height of this VolatileImage. - `int`"
  (^Integer [^VolatileImage this]
    (-> this (.getHeight))))

(defn create-graphics
  "Creates a Graphics2D, which can be used to draw into
   this VolatileImage.

  returns: a Graphics2D, used for drawing into this
            image. - `java.awt.Graphics2D`"
  (^java.awt.Graphics2D [^VolatileImage this]
    (-> this (.createGraphics))))

(defn get-capabilities
  "Returns an ImageCapabilities object which can be
   inquired as to the specific capabilities of this
   VolatileImage.  This would allow programmers to find
   out more runtime information on the specific VolatileImage
   object that they have created.  For example, the user
   might create a VolatileImage but the system may have
   no video memory left for creating an image of that
   size, so although the object is a VolatileImage, it is
   not as accelerated as other VolatileImage objects on
   this platform might be.  The user might want that
   information to find other solutions to their problem.

  returns: an ImageCapabilities object that contains
           the capabilities of this VolatileImage. - `java.awt.ImageCapabilities`"
  (^java.awt.ImageCapabilities [^VolatileImage this]
    (-> this (.getCapabilities))))

