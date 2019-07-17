(ns jdk.awt.image.ImageProducer
  "The interface for objects which can produce the image data for Images.
  Each image contains an ImageProducer which is used to reconstruct
  the image whenever it is needed, for example, when a new size of the
  Image is scaled, or when the width or height of the Image is being
  requested."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.image ImageProducer]))

(defn add-consumer
  "Registers an ImageConsumer with the
   ImageProducer for access to the image data
   during a later reconstruction of the Image.
   The ImageProducer may, at its discretion,
   start delivering the image data to the consumer
   using the ImageConsumer interface immediately,
   or when the next available image reconstruction is triggered
   by a call to the startProduction method.

  ic - the specified ImageConsumer - `java.awt.image.ImageConsumer`"
  ([this ic]
    (-> this (.addConsumer ic))))

(defn consumer?
  "Determines if a specified ImageConsumer
   object is currently registered with this
   ImageProducer as one of its consumers.

  ic - the specified ImageConsumer - `java.awt.image.ImageConsumer`

  returns: true if the specified
           ImageConsumer is registered with
           this ImageProducer;
           false otherwise. - `boolean`"
  ([this ic]
    (-> this (.isConsumer ic))))

(defn remove-consumer
  "Removes the specified ImageConsumer object
   from the list of consumers currently registered to
   receive image data.  It is not considered an error
   to remove a consumer that is not currently registered.
   The ImageProducer should stop sending data
   to this consumer as soon as is feasible.

  ic - the specified ImageConsumer - `java.awt.image.ImageConsumer`"
  ([this ic]
    (-> this (.removeConsumer ic))))

(defn start-production
  "Registers the specified ImageConsumer object
   as a consumer and starts an immediate reconstruction of
   the image data which will then be delivered to this
   consumer and any other consumer which might have already
   been registered with the producer.  This method differs
   from the addConsumer method in that a reproduction of
   the image data should be triggered as soon as possible.

  ic - the specified ImageConsumer - `java.awt.image.ImageConsumer`"
  ([this ic]
    (-> this (.startProduction ic))))

(defn request-top-down-left-right-resend
  "Requests, on behalf of the ImageConsumer,
   that the ImageProducer attempt to resend
   the image data one more time in TOPDOWNLEFTRIGHT order
   so that higher quality conversion algorithms which
   depend on receiving pixels in order can be used to
   produce a better output version of the image.  The
   ImageProducer is free to
   ignore this call if it cannot resend the data in that
   order.  If the data can be resent, the
   ImageProducer should respond by executing
   the following minimum set of ImageConsumer
   method calls:


    ic.setHints(TOPDOWNLEFTRIGHT | < otherhints >);
    ic.setPixels(...);      // As many times as needed
    ic.imageComplete();

  ic - the specified ImageConsumer - `java.awt.image.ImageConsumer`"
  ([this ic]
    (-> this (.requestTopDownLeftRightResend ic))))

