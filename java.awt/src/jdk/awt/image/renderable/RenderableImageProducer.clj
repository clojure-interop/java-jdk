(ns jdk.awt.image.renderable.RenderableImageProducer
  "An adapter class that implements ImageProducer to allow the
  asynchronous production of a RenderableImage.  The size of the
  ImageConsumer is determined by the scale factor of the usr2dev
  transform in the RenderContext.  If the RenderContext is null, the
  default rendering of the RenderableImage is used.  This class
  implements an asynchronous production that produces the image in
  one thread at one resolution.  This class may be subclassed to
  implement versions that will render the image using several
  threads.  These threads could render either the same image at
  progressively better quality, or different sections of the image at
  a single resolution."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.image.renderable RenderableImageProducer]))

(defn ->renderable-image-producer
  "Constructor.

  Constructs a new RenderableImageProducer from a RenderableImage
   and a RenderContext.

  rdbl-image - the RenderableImage to be rendered. - `java.awt.image.renderable.RenderableImage`
  rc - the RenderContext to use for producing the pixels. - `java.awt.image.renderable.RenderContext`"
  ([rdbl-image rc]
    (new RenderableImageProducer rdbl-image rc)))

(defn set-render-context
  "Sets a new RenderContext to use for the next startProduction() call.

  rc - the new RenderContext. - `java.awt.image.renderable.RenderContext`"
  ([this rc]
    (-> this (.setRenderContext rc))))

(defn add-consumer
  "Adds an ImageConsumer to the list of consumers interested in
   data for this image.

  ic - an ImageConsumer to be added to the interest list. - `java.awt.image.ImageConsumer`"
  ([this ic]
    (-> this (.addConsumer ic))))

(defn consumer?
  "Determine if an ImageConsumer is on the list of consumers
   currently interested in data for this image.

  ic - the ImageConsumer to be checked. - `java.awt.image.ImageConsumer`

  returns: true if the ImageConsumer is on the list; false otherwise. - `boolean`"
  ([this ic]
    (-> this (.isConsumer ic))))

(defn remove-consumer
  "Remove an ImageConsumer from the list of consumers interested in
   data for this image.

  ic - the ImageConsumer to be removed. - `java.awt.image.ImageConsumer`"
  ([this ic]
    (-> this (.removeConsumer ic))))

(defn start-production
  "Adds an ImageConsumer to the list of consumers interested in
   data for this image, and immediately starts delivery of the
   image data through the ImageConsumer interface.

  ic - the ImageConsumer to be added to the list of consumers. - `java.awt.image.ImageConsumer`"
  ([this ic]
    (-> this (.startProduction ic))))

(defn request-top-down-left-right-resend
  "Requests that a given ImageConsumer have the image data delivered
   one more time in top-down, left-right order.

  ic - the ImageConsumer requesting the resend. - `java.awt.image.ImageConsumer`"
  ([this ic]
    (-> this (.requestTopDownLeftRightResend ic))))

(defn run
  "The runnable method for this class. This will produce an image using
   the current RenderableImage and RenderContext and send it to all the
   ImageConsumer currently registered with this class."
  ([this]
    (-> this (.run))))

