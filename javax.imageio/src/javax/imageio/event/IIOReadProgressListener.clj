(ns javax.imageio.event.IIOReadProgressListener
  "An interface used by ImageReader implementations to
  notify callers of their image and thumbnail reading methods of
  progress.

   This interface receives general indications of decoding
  progress (via the imageProgress and
  thumbnailProgress methods), and events indicating when
  an entire image has been updated (via the
  imageStarted, imageComplete,
  thumbnailStarted and thumbnailComplete
  methods).  Applications that wish to be informed of pixel updates
  as they happen (for example, during progressive decoding), should
  provide an IIOReadUpdateListener."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.imageio.event IIOReadProgressListener]))

(defn thumbnail-started
  "Reports that a thumbnail read operation is beginning.  All
   ImageReader implementations are required to call
   this method exactly once when beginning a thumbnail read
   operation.

  source - the ImageReader object calling this method. - `javax.imageio.ImageReader`
  image-index - the index of the image being read within its containing input file or stream. - `int`
  thumbnail-index - the index of the thumbnail being read. - `int`"
  ([^IIOReadProgressListener this ^javax.imageio.ImageReader source ^Integer image-index ^Integer thumbnail-index]
    (-> this (.thumbnailStarted source image-index thumbnail-index))))

(defn thumbnail-complete
  "Reports that a thumbnail read operation has completed.  All
   ImageReader implementations are required to call
   this method exactly once upon completion of each thumbnail read
   operation.

  source - the ImageReader object calling this method. - `javax.imageio.ImageReader`"
  ([^IIOReadProgressListener this ^javax.imageio.ImageReader source]
    (-> this (.thumbnailComplete source))))

(defn sequence-started
  "Reports that a sequence of read operations is beginning.
   ImageReader implementations are required to call
   this method exactly once from their
   readAll(Iterator) method.

  source - the ImageReader object calling this method. - `javax.imageio.ImageReader`
  min-index - the index of the first image to be read. - `int`"
  ([^IIOReadProgressListener this ^javax.imageio.ImageReader source ^Integer min-index]
    (-> this (.sequenceStarted source min-index))))

(defn image-progress
  "Reports the approximate degree of completion of the current
   read call of the associated
   ImageReader.

    The degree of completion is expressed as a percentage
   varying from 0.0F to 100.0F.  The
   percentage should ideally be calculated in terms of the
   remaining time to completion, but it is usually more practical
   to use a more well-defined metric such as pixels decoded or
   portion of input stream consumed.  In any case, a sequence of
   calls to this method during a given read operation should
   supply a monotonically increasing sequence of percentage
   values.  It is not necessary to supply the exact values
   0 and 100, as these may be inferred
   by the callee from other methods.

    Each particular ImageReader implementation may
   call this method at whatever frequency it desires.  A rule of
   thumb is to call it around each 5 percent mark.

  source - the ImageReader object calling this method. - `javax.imageio.ImageReader`
  percentage-done - the approximate percentage of decoding that has been completed. - `float`"
  ([^IIOReadProgressListener this ^javax.imageio.ImageReader source ^Float percentage-done]
    (-> this (.imageProgress source percentage-done))))

(defn thumbnail-progress
  "Reports the approximate degree of completion of the current
   getThumbnail call within the associated
   ImageReader.  The semantics are identical to those
   of imageProgress.

  source - the ImageReader object calling this method. - `javax.imageio.ImageReader`
  percentage-done - the approximate percentage of decoding that has been completed. - `float`"
  ([^IIOReadProgressListener this ^javax.imageio.ImageReader source ^Float percentage-done]
    (-> this (.thumbnailProgress source percentage-done))))

(defn image-started
  "Reports that an image read operation is beginning.  All
   ImageReader implementations are required to call
   this method exactly once when beginning an image read
   operation.

  source - the ImageReader object calling this method. - `javax.imageio.ImageReader`
  image-index - the index of the image being read within its containing input file or stream. - `int`"
  ([^IIOReadProgressListener this ^javax.imageio.ImageReader source ^Integer image-index]
    (-> this (.imageStarted source image-index))))

(defn read-aborted
  "Reports that a read has been aborted via the reader's
   abort method.  No further notifications will be
   given.

  source - the ImageReader object calling this method. - `javax.imageio.ImageReader`"
  ([^IIOReadProgressListener this ^javax.imageio.ImageReader source]
    (-> this (.readAborted source))))

(defn sequence-complete
  "Reports that a sequence of read operations has completed.
   ImageReader implementations are required to call
   this method exactly once from their
   readAll(Iterator) method.

  source - the ImageReader object calling this method. - `javax.imageio.ImageReader`"
  ([^IIOReadProgressListener this ^javax.imageio.ImageReader source]
    (-> this (.sequenceComplete source))))

(defn image-complete
  "Reports that the current image read operation has completed.
   All ImageReader implementations are required to
   call this method exactly once upon completion of each image
   read operation.

  source - the ImageReader object calling this method. - `javax.imageio.ImageReader`"
  ([^IIOReadProgressListener this ^javax.imageio.ImageReader source]
    (-> this (.imageComplete source))))

