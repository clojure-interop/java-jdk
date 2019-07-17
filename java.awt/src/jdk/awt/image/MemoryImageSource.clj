(ns jdk.awt.image.MemoryImageSource
  "This class is an implementation of the ImageProducer interface which
  uses an array to produce pixel values for an Image.  Here is an example
  which calculates a 100x100 image representing a fade from black to blue
  along the X axis and a fade from black to red along the Y axis:


       int w = 100;
       int h = 100;
       int pix[] = new int[w * h];
       int index = 0;
       for (int y = 0; y < h; y++) {
           int red = (y * 255) / (h - 1);
           for (int x = 0; x < w; x++) {
               int blue = (x * 255) / (w - 1);
               pix[index++] = (255 << 24) | (red << 16) | blue;
           }
       }
       Image img = createImage(new MemoryImageSource(w, h, pix, 0, w));
  The MemoryImageSource is also capable of managing a memory image which
  varies over time to allow animation or custom rendering.  Here is an
  example showing how to set up the animation source and signal changes
  in the data (adapted from the MemoryAnimationSourceDemo by Garth Dickie):


       int pixels[];
       MemoryImageSource source;

       public void init() {
           int width = 50;
           int height = 50;
           int size = width * height;
           pixels = new int[size];

           int value = getBackground().getRGB();
           for (int i = 0; i < size; i++) {
               pixels[i] = value;
           }

           source = new MemoryImageSource(width, height, pixels, 0, width);
           source.setAnimated(true);
           image = createImage(source);
       }

       public void run() {
           Thread me = Thread.currentThread( );
           me.setPriority(Thread.MIN_PRIORITY);

           while (true) {
               try {
                   Thread.sleep(10);
               } catch( InterruptedException e ) {
                   return;
               }

               // Modify the values in the pixels array at (x, y, w, h)

               // Send the new data to the interested ImageConsumers
               source.newPixels(x, y, w, h);
           }
       }"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.image MemoryImageSource]))

(defn ->memory-image-source
  "Constructor.

  Constructs an ImageProducer object which uses an array of bytes
   to produce data for an Image object.

  w - the width of the rectangle of pixels - `int`
  h - the height of the rectangle of pixels - `int`
  cm - the specified ColorModel - `java.awt.image.ColorModel`
  pix - an array of pixels - `byte[]`
  off - the offset into the array of where to store the first pixel - `int`
  scan - the distance from one row of pixels to the next in the array - `int`
  props - a list of properties that the ImageProducer uses to process an image - `java.util.Hashtable<?,?>`"
  ([^Integer w ^Integer h ^java.awt.image.ColorModel cm pix ^Integer off ^Integer scan ^java.util.Hashtable props]
    (new MemoryImageSource w h cm pix off scan props))
  ([^Integer w ^Integer h ^java.awt.image.ColorModel cm pix ^Integer off ^Integer scan]
    (new MemoryImageSource w h cm pix off scan))
  ([^Integer w ^Integer h pix ^Integer off ^Integer scan]
    (new MemoryImageSource w h pix off scan)))

(defn add-consumer
  "Adds an ImageConsumer to the list of consumers interested in
   data for this image.

  ic - the specified ImageConsumer - `java.awt.image.ImageConsumer`

  throws: java.lang.NullPointerException - if the specified ImageConsumer is null"
  ([^java.awt.image.MemoryImageSource this ^java.awt.image.ImageConsumer ic]
    (-> this (.addConsumer ic))))

(defn consumer?
  "Determines if an ImageConsumer is on the list of consumers currently
   interested in data for this image.

  ic - the specified ImageConsumer - `java.awt.image.ImageConsumer`

  returns: true if the ImageConsumer
   is on the list; false otherwise. - `boolean`"
  ([^java.awt.image.MemoryImageSource this ^java.awt.image.ImageConsumer ic]
    (-> this (.isConsumer ic))))

(defn remove-consumer
  "Removes an ImageConsumer from the list of consumers interested in
   data for this image.

  ic - the specified ImageConsumer - `java.awt.image.ImageConsumer`"
  ([^java.awt.image.MemoryImageSource this ^java.awt.image.ImageConsumer ic]
    (-> this (.removeConsumer ic))))

(defn start-production
  "Adds an ImageConsumer to the list of consumers interested in
   data for this image and immediately starts delivery of the
   image data through the ImageConsumer interface.

  ic - the specified ImageConsumer image data through the ImageConsumer interface. - `java.awt.image.ImageConsumer`"
  ([^java.awt.image.MemoryImageSource this ^java.awt.image.ImageConsumer ic]
    (-> this (.startProduction ic))))

(defn request-top-down-left-right-resend
  "Requests that a given ImageConsumer have the image data delivered
   one more time in top-down, left-right order.

  ic - the specified ImageConsumer - `java.awt.image.ImageConsumer`"
  ([^java.awt.image.MemoryImageSource this ^java.awt.image.ImageConsumer ic]
    (-> this (.requestTopDownLeftRightResend ic))))

(defn set-animated
  "Changes this memory image into a multi-frame animation or a
   single-frame static image depending on the animated parameter.
   This method should be called immediately after the
   MemoryImageSource is constructed and before an image is
   created with it to ensure that all ImageConsumers will
   receive the correct multi-frame data.  If an ImageConsumer
   is added to this ImageProducer before this flag is set then
   that ImageConsumer will see only a snapshot of the pixel
   data that was available when it connected.

  animated - true if the image is a multi-frame animation - `boolean`"
  ([^java.awt.image.MemoryImageSource this ^Boolean animated]
    (-> this (.setAnimated animated))))

(defn set-full-buffer-updates
  "Specifies whether this animated memory image should always be
   updated by sending the complete buffer of pixels whenever
   there is a change.
   This flag is ignored if the animation flag is not turned on
   through the setAnimated() method.
   This method should be called immediately after the
   MemoryImageSource is constructed and before an image is
   created with it to ensure that all ImageConsumers will
   receive the correct pixel delivery hints.

  fullbuffers - true if the complete pixel buffer should always be sent - `boolean`"
  ([^java.awt.image.MemoryImageSource this ^Boolean fullbuffers]
    (-> this (.setFullBufferUpdates fullbuffers))))

(defn new-pixels
  "Sends a rectangular region of the buffer of pixels to any
   ImageConsumers that are currently interested in the data for
   this image.
   If the framenotify parameter is true then the consumers are
   also notified that an animation frame is complete.
   This method only has effect if the animation flag has been
   turned on through the setAnimated() method.
   If the full buffer update flag was turned on with the
   setFullBufferUpdates() method then the rectangle parameters
   will be ignored and the entire buffer will always be sent.

  x - the x coordinate of the upper left corner of the rectangle of pixels to be sent - `int`
  y - the y coordinate of the upper left corner of the rectangle of pixels to be sent - `int`
  w - the width of the rectangle of pixels to be sent - `int`
  h - the height of the rectangle of pixels to be sent - `int`
  framenotify - true if the consumers should be sent a SINGLEFRAMEDONE notification - `boolean`"
  ([^java.awt.image.MemoryImageSource this ^Integer x ^Integer y ^Integer w ^Integer h ^Boolean framenotify]
    (-> this (.newPixels x y w h framenotify)))
  ([^java.awt.image.MemoryImageSource this ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.newPixels x y w h)))
  ([^java.awt.image.MemoryImageSource this]
    (-> this (.newPixels))))

