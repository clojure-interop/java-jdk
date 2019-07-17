(ns jdk.awt.MediaTracker
  "The MediaTracker class is a utility class to track
  the status of a number of media objects. Media objects could
  include audio clips as well as images, though currently only
  images are supported.

  To use a media tracker, create an instance of
  MediaTracker and call its addImage
  method for each image to be tracked. In addition, each image can
  be assigned a unique identifier. This identifier controls the
  priority order in which the images are fetched. It can also be used
  to identify unique subsets of the images that can be waited on
  independently. Images with a lower ID are loaded in preference to
  those with a higher ID number.



  Tracking an animated image
  might not always be useful
  due to the multi-part nature of animated image
  loading and painting,
  but it is supported.
  MediaTracker treats an animated image
  as completely loaded
  when the first frame is completely loaded.
  At that point, the MediaTracker
  signals any waiters
  that the image is completely loaded.
  If no ImageObservers are observing the image
  when the first frame has finished loading,
  the image might flush itself
  to conserve resources
  (see Image.flush()).


  Here is an example of using MediaTracker:



  import java.applet.Applet;
  import java.awt.Color;
  import java.awt.Image;
  import java.awt.Graphics;
  import java.awt.MediaTracker;

  public class ImageBlaster extends Applet implements Runnable {
       MediaTracker tracker;
       Image bg;
       Image anim[] = new Image[5];
       int index;
       Thread animator;

       // Get the images for the background (id == 0)
       // and the animation frames (id == 1)
       // and add them to the MediaTracker
       public void init() {
           tracker = new MediaTracker(this);
           bg = getImage(getDocumentBase(),
                   `images/background.gif`);
           tracker.addImage(bg, 0);
           for (int i = 0; i < 5; i++) {
               anim[i] = getImage(getDocumentBase(),
                       `images/anim`+i+`.gif`);
               tracker.addImage(anim[i], 1);
           }
       }

       // Start the animation thread.
       public void start() {
           animator = new Thread(this);
           animator.start();
       }

       // Stop the animation thread.
       public void stop() {
           animator = null;
       }

       // Run the animation thread.
       // First wait for the background image to fully load
       // and paint.  Then wait for all of the animation
       // frames to finish loading. Finally, loop and
       // increment the animation frame index.
       public void run() {
           try {
               tracker.waitForID(0);
               tracker.waitForID(1);
           } catch (InterruptedException e) {
               return;
           }
           Thread me = Thread.currentThread();
           while (animator == me) {
               try {
                   Thread.sleep(100);
               } catch (InterruptedException e) {
                   break;
               }
               synchronized (this) {
                   index++;
                   if (index >= anim.length) {
                       index = 0;
                   }
               }
               repaint();
           }
       }

       // The background image fills the frame so we
       // don't need to clear the applet on repaints.
       // Just call the paint method.
       public void update(Graphics g) {
           paint(g);
       }

       // Paint a large red rectangle if there are any errors
       // loading the images.  Otherwise always paint the
       // background so that it appears incrementally as it
       // is loading.  Finally, only paint the current animation
       // frame if all of the frames (id == 1) are done loading,
       // so that we don't get partial animations.
       public void paint(Graphics g) {
           if ((tracker.statusAll(false) & MediaTracker.ERRORED) != 0) {
               g.setColor(Color.red);
               g.fillRect(0, 0, size().width, size().height);
               return;
           }
           g.drawImage(bg, 0, 0, this);
           if (tracker.statusID(1, false) == MediaTracker.COMPLETE) {
               g.drawImage(anim[index], 10, 10, this);
           }
       }
  }"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt MediaTracker]))

(defn ->media-tracker
  "Constructor.

  Creates a media tracker to track images for a given component.

  comp - the component on which the images will eventually be drawn - `java.awt.Component`"
  ([^java.awt.Component comp]
    (new MediaTracker comp)))

(def *-loading
  "Static Constant.

  Flag indicating that media is currently being loaded.

  type: int"
  MediaTracker/LOADING)

(def *-aborted
  "Static Constant.

  Flag indicating that the downloading of media was aborted.

  type: int"
  MediaTracker/ABORTED)

(def *-errored
  "Static Constant.

  Flag indicating that the downloading of media encountered
   an error.

  type: int"
  MediaTracker/ERRORED)

(def *-complete
  "Static Constant.

  Flag indicating that the downloading of media was completed
   successfully.

  type: int"
  MediaTracker/COMPLETE)

(defn status-all
  "Calculates and returns the bitwise inclusive OR of the
   status of all media that are tracked by this media tracker.

   Possible flags defined by the
   MediaTracker class are LOADING,
   ABORTED, ERRORED, and
   COMPLETE. An image that hasn't started
   loading has zero as its status.

   If the value of load is true, then
   this method starts loading any images that are not yet being loaded.

  load - if true, start loading any images that are not yet being loaded - `boolean`

  returns: the bitwise inclusive OR of the status of
                              all of the media being tracked - `int`"
  (^Integer [^java.awt.MediaTracker this ^Boolean load]
    (-> this (.statusAll load))))

(defn wait-for-id
  "Starts loading all images tracked by this media tracker with the
   specified identifier. This method waits until all the images with
   the specified identifier have finished loading, or until the
   length of time specified in milliseconds by the ms
   argument has passed.

   If there is an error while loading or scaling an image, then that
   image is considered to have finished loading. Use the
   statusID, isErrorID, and
   isErrorAny methods to check for errors.

  id - the identifier of the images to check - `int`
  ms - the length of time, in milliseconds, to wait for the loading to complete - `long`

  returns: `boolean`

  throws: java.lang.InterruptedException - if any thread has interrupted this thread."
  (^Boolean [^java.awt.MediaTracker this ^Integer id ^Long ms]
    (-> this (.waitForID id ms)))
  ([^java.awt.MediaTracker this ^Integer id]
    (-> this (.waitForID id))))

(defn status-id
  "Calculates and returns the bitwise inclusive OR of the
   status of all media with the specified identifier that are
   tracked by this media tracker.

   Possible flags defined by the
   MediaTracker class are LOADING,
   ABORTED, ERRORED, and
   COMPLETE. An image that hasn't started
   loading has zero as its status.

   If the value of load is true, then
   this method starts loading any images that are not yet being loaded.

  id - the identifier of the images to check - `int`
  load - if true, start loading any images that are not yet being loaded - `boolean`

  returns: the bitwise inclusive OR of the status of
                              all of the media with the specified
                              identifier that are being tracked - `int`"
  (^Integer [^java.awt.MediaTracker this ^Integer id ^Boolean load]
    (-> this (.statusID id load))))

(defn check-id
  "Checks to see if all images tracked by this media tracker that
   are tagged with the specified identifier have finished loading.

   If the value of the load flag is true,
   then this method starts loading any images that are not yet
   being loaded.

   If there is an error while loading or scaling an image, then that
   image is considered to have finished loading. Use the
   isErrorAny or isErrorID methods to
   check for errors.

  id - the identifier of the images to check - `int`
  load - if true, start loading any images that are not yet being loaded - `boolean`

  returns: true if all images have finished loading,
                         have been aborted, or have encountered
                         an error; false otherwise - `boolean`"
  (^Boolean [^java.awt.MediaTracker this ^Integer id ^Boolean load]
    (-> this (.checkID id load)))
  (^Boolean [^java.awt.MediaTracker this ^Integer id]
    (-> this (.checkID id))))

(defn get-errors-id
  "Returns a list of media with the specified ID that
   have encountered an error.

  id - the identifier of the images to check - `int`

  returns: an array of media objects tracked by this media
                         tracker with the specified identifier
                         that have encountered an error, or
                         null if there are none with errors - `java.lang.Object[]`"
  ([^java.awt.MediaTracker this ^Integer id]
    (-> this (.getErrorsID id))))

(defn error-id?
  "Checks the error status of all of the images tracked by this
   media tracker with the specified identifier.

  id - the identifier of the images to check - `int`

  returns: true if any of the images with the
                            specified identifier had an error during
                            loading; false otherwise - `boolean`"
  (^Boolean [^java.awt.MediaTracker this ^Integer id]
    (-> this (.isErrorID id))))

(defn add-image
  "Adds a scaled image to the list of images being tracked
   by this media tracker. The image will eventually be
   rendered at the indicated width and height.

  image - the image to be tracked - `java.awt.Image`
  id - an identifier that can be used to track this image - `int`
  w - the width at which the image is rendered - `int`
  h - the height at which the image is rendered - `int`"
  ([^java.awt.MediaTracker this ^java.awt.Image image ^Integer id ^Integer w ^Integer h]
    (-> this (.addImage image id w h)))
  ([^java.awt.MediaTracker this ^java.awt.Image image ^Integer id]
    (-> this (.addImage image id))))

(defn remove-image
  "Removes the specified image with the specified
   width, height, and ID from this media tracker.
   Only the specified instance (with any duplicates) is removed.

  image - the image to be removed - `java.awt.Image`
  id - the tracking ID from which to remove the image - `int`
  width - the width to remove (-1 for unscaled) - `int`
  height - the height to remove (-1 for unscaled) - `int`"
  ([^java.awt.MediaTracker this ^java.awt.Image image ^Integer id ^Integer width ^Integer height]
    (-> this (.removeImage image id width height)))
  ([^java.awt.MediaTracker this ^java.awt.Image image ^Integer id]
    (-> this (.removeImage image id)))
  ([^java.awt.MediaTracker this ^java.awt.Image image]
    (-> this (.removeImage image))))

(defn check-all
  "Checks to see if all images being tracked by this media tracker
   have finished loading.

   If the value of the load flag is true,
   then this method starts loading any images that are not yet
   being loaded.

   If there is an error while loading or scaling an image, that
   image is considered to have finished loading. Use the
   isErrorAny and isErrorID methods to
   check for errors.

  load - if true, start loading any images that are not yet being loaded - `boolean`

  returns: true if all images have finished loading,
                         have been aborted, or have encountered
                         an error; false otherwise - `boolean`"
  (^Boolean [^java.awt.MediaTracker this ^Boolean load]
    (-> this (.checkAll load)))
  (^Boolean [^java.awt.MediaTracker this]
    (-> this (.checkAll))))

(defn get-errors-any
  "Returns a list of all media that have encountered an error.

  returns: an array of media objects tracked by this
                          media tracker that have encountered
                          an error, or null if
                          there are none with errors - `java.lang.Object[]`"
  ([^java.awt.MediaTracker this]
    (-> this (.getErrorsAny))))

(defn error-any?
  "Checks the error status of all of the images.

  returns: true if any of the images tracked
                    by this media tracker had an error during
                    loading; false otherwise - `boolean`"
  (^Boolean [^java.awt.MediaTracker this]
    (-> this (.isErrorAny))))

(defn wait-for-all
  "Starts loading all images tracked by this media tracker. This
   method waits until all the images being tracked have finished
   loading, or until the length of time specified in milliseconds
   by the ms argument has passed.

   If there is an error while loading or scaling an image, then
   that image is considered to have finished loading. Use the
   isErrorAny or isErrorID methods to
   check for errors.

  ms - the number of milliseconds to wait for the loading to complete - `long`

  returns: true if all images were successfully
                         loaded; false otherwise - `boolean`

  throws: java.lang.InterruptedException - if any thread has interrupted this thread."
  (^Boolean [^java.awt.MediaTracker this ^Long ms]
    (-> this (.waitForAll ms)))
  ([^java.awt.MediaTracker this]
    (-> this (.waitForAll))))

