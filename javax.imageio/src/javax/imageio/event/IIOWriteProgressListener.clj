(ns javax.imageio.event.IIOWriteProgressListener
  "An interface used by ImageWriter implementations to notify
  callers of their image writing methods of progress."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.imageio.event IIOWriteProgressListener]))

(defn image-started
  "Reports that an image write operation is beginning.  All
   ImageWriter implementations are required to call
   this method exactly once when beginning an image write
   operation.

  source - the ImageWriter object calling this method. - `javax.imageio.ImageWriter`
  image-index - the index of the image being written within its containing input file or stream. - `int`"
  ([this source image-index]
    (-> this (.imageStarted source image-index))))

(defn image-progress
  "Reports the approximate degree of completion of the current
   write call within the associated
   ImageWriter.

    The degree of completion is expressed as an index
   indicating which image is being written, and a percentage
   varying from 0.0F to 100.0F
   indicating how much of the current image has been output.  The
   percentage should ideally be calculated in terms of the
   remaining time to completion, but it is usually more practical
   to use a more well-defined metric such as pixels decoded or
   portion of input stream consumed.  In any case, a sequence of
   calls to this method during a given read operation should
   supply a monotonically increasing sequence of percentage
   values.  It is not necessary to supply the exact values
   0 and 100, as these may be inferred
   by the callee from other methods.

    Each particular ImageWriter implementation may
   call this method at whatever frequency it desires.  A rule of
   thumb is to call it around each 5 percent mark.

  source - the ImageWriter object calling this method. - `javax.imageio.ImageWriter`
  percentage-done - the approximate percentage of decoding that has been completed. - `float`"
  ([this source percentage-done]
    (-> this (.imageProgress source percentage-done))))

(defn image-complete
  "Reports that the image write operation has completed.  All
   ImageWriter implementations are required to call
   this method exactly once upon completion of each image write
   operation.

  source - the ImageWriter object calling this method. - `javax.imageio.ImageWriter`"
  ([this source]
    (-> this (.imageComplete source))))

(defn thumbnail-started
  "Reports that a thumbnail write operation is beginning.  All
   ImageWriter implementations are required to call
   this method exactly once when beginning a thumbnail write
   operation.

  source - the ImageWrite object calling this method. - `javax.imageio.ImageWriter`
  image-index - the index of the image being written within its containing input file or stream. - `int`
  thumbnail-index - the index of the thumbnail being written. - `int`"
  ([this source image-index thumbnail-index]
    (-> this (.thumbnailStarted source image-index thumbnail-index))))

(defn thumbnail-progress
  "Reports the approximate degree of completion of the current
   thumbnail write within the associated ImageWriter.
   The semantics are identical to those of
   imageProgress.

  source - the ImageWriter object calling this method. - `javax.imageio.ImageWriter`
  percentage-done - the approximate percentage of decoding that has been completed. - `float`"
  ([this source percentage-done]
    (-> this (.thumbnailProgress source percentage-done))))

(defn thumbnail-complete
  "Reports that a thumbnail write operation has completed.  All
   ImageWriter implementations are required to call
   this method exactly once upon completion of each thumbnail
   write operation.

  source - the ImageWriter object calling this method. - `javax.imageio.ImageWriter`"
  ([this source]
    (-> this (.thumbnailComplete source))))

(defn write-aborted
  "Reports that a write has been aborted via the writer's
   abort method.  No further notifications will be
   given.

  source - the ImageWriter object calling this method. - `javax.imageio.ImageWriter`"
  ([this source]
    (-> this (.writeAborted source))))

