(ns jdk.awt.GraphicsConfiguration
  "The GraphicsConfiguration class describes the
  characteristics of a graphics destination such as a printer or monitor.
  There can be many GraphicsConfiguration objects associated
  with a single graphics device, representing different drawing modes or
  capabilities.  The corresponding native structure will vary from platform
  to platform.  For example, on X11 windowing systems,
  each visual is a different GraphicsConfiguration.
  On Microsoft Windows, GraphicsConfigurations represent
  PixelFormats available in the current resolution and color depth.

  In a virtual device multi-screen environment in which the desktop
  area could span multiple physical screen devices, the bounds of the
  GraphicsConfiguration objects are relative to the
  virtual coordinate system.  When setting the location of a
  component, use getBounds to get the bounds of
  the desired GraphicsConfiguration and offset the location
  with the coordinates of the GraphicsConfiguration,
  as the following code sample illustrates:




       Frame f = new Frame(gc);  // where gc is a GraphicsConfiguration
       Rectangle bounds = gc.getBounds();
       f.setLocation(10  bounds.x, 10  bounds.y);


  To determine if your environment is a virtual device
  environment, call getBounds on all of the
  GraphicsConfiguration objects in your system.  If
  any of the origins of the returned bounds is not (0, 0),
  your environment is a virtual device environment.


  You can also use getBounds to determine the bounds
  of the virtual device.  To do this, first call getBounds on all
  of the GraphicsConfiguration objects in your
  system.  Then calculate the union of all of the bounds returned
  from the calls to getBounds.  The union is the
  bounds of the virtual device.  The following code sample
  calculates the bounds of the virtual device.



       Rectangle virtualBounds = new Rectangle();
       GraphicsEnvironment ge = GraphicsEnvironment.
               getLocalGraphicsEnvironment();
       GraphicsDevice[] gs =
               ge.getScreenDevices();
       for (int j = 0; j < gs.length; j++) {
           GraphicsDevice gd = gs[j];
           GraphicsConfiguration[] gc =
               gd.getConfigurations();
           for (int i=0; i < gc.length; i++) {
               virtualBounds =
                   virtualBounds.union(gc[i].getBounds());
           }
       }"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt GraphicsConfiguration]))

(defn get-image-capabilities
  "Returns the image capabilities of this
   GraphicsConfiguration.

  returns: the image capabilities of this graphics
   configuration object - `java.awt.ImageCapabilities`"
  (^java.awt.ImageCapabilities [^java.awt.GraphicsConfiguration this]
    (-> this (.getImageCapabilities))))

(defn get-default-transform
  "Returns the default AffineTransform for this
   GraphicsConfiguration. This
   AffineTransform is typically the Identity transform
   for most normal screens.  The default AffineTransform
   maps coordinates onto the device such that 72 user space
   coordinate units measure approximately 1 inch in device
   space.  The normalizing transform can be used to make
   this mapping more exact.  Coordinates in the coordinate space
   defined by the default AffineTransform for screen and
   printer devices have the origin in the upper left-hand corner of
   the target region of the device, with X coordinates
   increasing to the right and Y coordinates increasing downwards.
   For image buffers not associated with a device, such as those not
   created by createCompatibleImage,
   this AffineTransform is the Identity transform.

  returns: the default AffineTransform for this
   GraphicsConfiguration. - `java.awt.geom.AffineTransform`"
  (^java.awt.geom.AffineTransform [^java.awt.GraphicsConfiguration this]
    (-> this (.getDefaultTransform))))

(defn create-compatible-volatile-image
  "Returns a VolatileImage with a data layout and color model
   compatible with this GraphicsConfiguration, using
   the specified image capabilities and transparency value.
   If the caps parameter is null, it is effectively ignored
   and this method will create a VolatileImage without regard to
   ImageCapabilities constraints.

   The returned VolatileImage has
   a layout and color model that is closest to this native device
   configuration and can therefore be optimally blitted to this
   device.

  width - the width of the returned VolatileImage - `int`
  height - the height of the returned VolatileImage - `int`
  caps - the image capabilities - `java.awt.ImageCapabilities`
  transparency - the specified transparency mode - `int`

  returns: a VolatileImage whose data layout and color
   model is compatible with this GraphicsConfiguration. - `java.awt.image.VolatileImage`

  throws: java.lang.IllegalArgumentException - if the transparency is not a valid value"
  (^java.awt.image.VolatileImage [^java.awt.GraphicsConfiguration this ^Integer width ^Integer height ^java.awt.ImageCapabilities caps ^Integer transparency]
    (-> this (.createCompatibleVolatileImage width height caps transparency)))
  (^java.awt.image.VolatileImage [^java.awt.GraphicsConfiguration this ^Integer width ^Integer height ^Integer transparency]
    (-> this (.createCompatibleVolatileImage width height transparency)))
  (^java.awt.image.VolatileImage [^java.awt.GraphicsConfiguration this ^Integer width ^Integer height]
    (-> this (.createCompatibleVolatileImage width height))))

(defn create-compatible-image
  "Returns a BufferedImage that supports the specified
   transparency and has a data layout and color model
   compatible with this GraphicsConfiguration.  This
   method has nothing to do with memory-mapping
   a device. The returned BufferedImage has a layout and
   color model that can be optimally blitted to a device
   with this GraphicsConfiguration.

  width - the width of the returned BufferedImage - `int`
  height - the height of the returned BufferedImage - `int`
  transparency - the specified transparency mode - `int`

  returns: a BufferedImage whose data layout and color
   model is compatible with this GraphicsConfiguration
   and also supports the specified transparency. - `java.awt.image.BufferedImage`

  throws: java.lang.IllegalArgumentException - if the transparency is not a valid value"
  (^java.awt.image.BufferedImage [^java.awt.GraphicsConfiguration this ^Integer width ^Integer height ^Integer transparency]
    (-> this (.createCompatibleImage width height transparency)))
  (^java.awt.image.BufferedImage [^java.awt.GraphicsConfiguration this ^Integer width ^Integer height]
    (-> this (.createCompatibleImage width height))))

(defn get-device
  "Returns the GraphicsDevice associated with this
   GraphicsConfiguration.

  returns: a GraphicsDevice object that is
   associated with this GraphicsConfiguration. - `java.awt.GraphicsDevice`"
  (^java.awt.GraphicsDevice [^java.awt.GraphicsConfiguration this]
    (-> this (.getDevice))))

(defn get-normalizing-transform
  "Returns a AffineTransform that can be concatenated
   with the default AffineTransform
   of a GraphicsConfiguration so that 72 units in user
   space equals 1 inch in device space.

   For a particular Graphics2D, g, one
   can reset the transformation to create
   such a mapping by using the following pseudocode:


        GraphicsConfiguration gc = g.getDeviceConfiguration();

        g.setTransform(gc.getDefaultTransform());
        g.transform(gc.getNormalizingTransform());
   Note that sometimes this AffineTransform is identity,
   such as for printers or metafile output, and that this
   AffineTransform is only as accurate as the information
   supplied by the underlying system.  For image buffers not
   associated with a device, such as those not created by
   createCompatibleImage, this
   AffineTransform is the Identity transform
   since there is no valid distance measurement.

  returns: an AffineTransform to concatenate to the
   default AffineTransform so that 72 units in user
   space is mapped to 1 inch in device space. - `java.awt.geom.AffineTransform`"
  (^java.awt.geom.AffineTransform [^java.awt.GraphicsConfiguration this]
    (-> this (.getNormalizingTransform))))

(defn translucency-capable?
  "Returns whether this GraphicsConfiguration supports
   the PERPIXEL_TRANSLUCENT kind of translucency.

  returns: whether the given GraphicsConfiguration supports
           the translucency effects. - `boolean`"
  (^Boolean [^java.awt.GraphicsConfiguration this]
    (-> this (.isTranslucencyCapable))))

(defn get-bounds
  "Returns the bounds of the GraphicsConfiguration
   in the device coordinates. In a multi-screen environment
   with a virtual device, the bounds can have negative X
   or Y origins.

  returns: the bounds of the area covered by this
   GraphicsConfiguration. - `java.awt.Rectangle`"
  (^java.awt.Rectangle [^java.awt.GraphicsConfiguration this]
    (-> this (.getBounds))))

(defn get-buffer-capabilities
  "Returns the buffering capabilities of this
   GraphicsConfiguration.

  returns: the buffering capabilities of this graphics
   configuration object - `java.awt.BufferCapabilities`"
  (^java.awt.BufferCapabilities [^java.awt.GraphicsConfiguration this]
    (-> this (.getBufferCapabilities))))

(defn get-color-model
  "Returns the ColorModel associated with this
   GraphicsConfiguration that supports the specified
   transparency.

  transparency - the specified transparency mode - `int`

  returns: a ColorModel object that is associated with
   this GraphicsConfiguration and supports the
   specified transparency or null if the transparency is not a valid
   value. - `java.awt.image.ColorModel`"
  (^java.awt.image.ColorModel [^java.awt.GraphicsConfiguration this ^Integer transparency]
    (-> this (.getColorModel transparency)))
  (^java.awt.image.ColorModel [^java.awt.GraphicsConfiguration this]
    (-> this (.getColorModel))))

