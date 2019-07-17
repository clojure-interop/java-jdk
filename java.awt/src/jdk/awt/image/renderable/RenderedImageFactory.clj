(ns jdk.awt.image.renderable.RenderedImageFactory
  "The RenderedImageFactory interface (often abbreviated RIF) is
  intended to be implemented by classes that wish to act as factories
  to produce different renderings, for example by executing a series
  of BufferedImageOps on a set of sources, depending on a specific
  set of parameters, properties, and rendering hints."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.image.renderable RenderedImageFactory]))

(defn create
  "Creates a RenderedImage representing the results of an imaging
   operation (or chain of operations) for a given ParameterBlock and
   RenderingHints.  The RIF may also query any source images
   referenced by the ParameterBlock for their dimensions,
   SampleModels, properties, etc., as necessary.

    The create() method can return null if the
   RenderedImageFactory is not capable of producing output for the
   given set of source images and parameters.  For example, if a
   RenderedImageFactory is only capable of performing a 3x3
   convolution on single-banded image data, and the source image has
   multiple bands or the convolution Kernel is 5x5, null should be
   returned.

    Hints should be taken into account, but can be ignored.
   The created RenderedImage may have a property identified
   by the String HINTS_OBSERVED to indicate which RenderingHints
   were used to create the image.  In addition any RenderedImages
   that are obtained via the getSources() method on the created
   RenderedImage may have such a property.

  param-block - a ParameterBlock containing sources and parameters for the RenderedImage to be created. - `java.awt.image.renderable.ParameterBlock`
  hints - a RenderingHints object containing hints. - `java.awt.RenderingHints`

  returns: A RenderedImage containing the desired output. - `java.awt.image.RenderedImage`"
  (^java.awt.image.RenderedImage [^java.awt.image.renderable.RenderedImageFactory this ^java.awt.image.renderable.ParameterBlock param-block ^java.awt.RenderingHints hints]
    (-> this (.create param-block hints))))

