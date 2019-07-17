(ns jdk.applet.AppletContext
  "This interface corresponds to an applet's environment: the
  document containing the applet and the other applets in the same
  document.

  The methods in this interface can be used by an applet to obtain
  information about its environment."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.applet AppletContext]))

(defn get-image
  "Returns an Image object that can then be painted on
   the screen. The url argument that is
   passed as an argument must specify an absolute URL.

   This method always returns immediately, whether or not the image
   exists. When the applet attempts to draw the image on the screen,
   the data will be loaded. The graphics primitives that draw the
   image will incrementally paint on the screen.

  url - an absolute URL giving the location of the image. - `java.net.URL`

  returns: the image at the specified URL. - `java.awt.Image`"
  (^java.awt.Image [^java.applet.AppletContext this ^java.net.URL url]
    (-> this (.getImage url))))

(defn get-applets
  "Finds all the applets in the document represented by this applet
   context.

  returns: an enumeration of all applets in the document represented by
            this applet context. - `java.util.Enumeration<java.applet.Applet>`"
  (^java.util.Enumeration [^java.applet.AppletContext this]
    (-> this (.getApplets))))

(defn get-applet
  "Finds and returns the applet in the document represented by this
   applet context with the given name. The name can be set in the
   HTML tag by setting the name attribute.

  name - an applet name. - `java.lang.String`

  returns: the applet with the given name, or null if
            not found. - `java.applet.Applet`"
  (^java.applet.Applet [^java.applet.AppletContext this ^java.lang.String name]
    (-> this (.getApplet name))))

(defn get-stream-keys
  "Finds all the keys of the streams in this applet context.

   For security reasons, mapping of streams and keys exists for each
   codebase. In other words, applet from one codebase cannot access
   the streams created by an applet from a different codebase

  returns: an Iterator of all the names of the streams in this applet
            context. - `java.util.Iterator<java.lang.String>`"
  (^java.util.Iterator [^java.applet.AppletContext this]
    (-> this (.getStreamKeys))))

(defn get-stream
  "Returns the stream to which specified key is associated within this
   applet context. Returns null if the applet context contains
   no stream for this key.

   For security reasons, mapping of streams and keys exists for each
   codebase. In other words, applet from one codebase cannot access
   the streams created by an applet from a different codebase

  key - key whose associated stream is to be returned. - `java.lang.String`

  returns: the stream to which this applet context maps the key - `java.io.InputStream`"
  (^java.io.InputStream [^java.applet.AppletContext this ^java.lang.String key]
    (-> this (.getStream key))))

(defn set-stream
  "Associates the specified stream with the specified key in this
   applet context. If the applet context previously contained a mapping
   for this key, the old value is replaced.

   For security reasons, mapping of streams and keys exists for each
   codebase. In other words, applet from one codebase cannot access
   the streams created by an applet from a different codebase

  key - key with which the specified value is to be associated. - `java.lang.String`
  stream - stream to be associated with the specified key. If this parameter is null, the specified key is removed in this applet context. - `java.io.InputStream`

  throws: java.io.IOException - if the stream size exceeds a certain size limit. Size limit is decided by the implementor of this interface."
  ([^java.applet.AppletContext this ^java.lang.String key ^java.io.InputStream stream]
    (-> this (.setStream key stream))))

(defn show-status
  "Requests that the argument string be displayed in the
   `status window`. Many browsers and applet viewers
   provide such a window, where the application can inform users of
   its current state.

  status - a string to display in the status window. - `java.lang.String`"
  ([^java.applet.AppletContext this ^java.lang.String status]
    (-> this (.showStatus status))))

(defn show-document
  "Requests that the browser or applet viewer show the Web page
   indicated by the url argument. The
   target argument indicates in which HTML frame the
   document is to be displayed.
   The target argument is interpreted as follows:


   Target ArgumentDescription
   `_self`  Show in the window and frame that
                                     contain the applet.
   `_parent`Show in the applet's parent frame. If
                                     the applet's frame has no parent frame,
                                     acts the same as `_self`.
   `_top`   Show in the top-level frame of the applet's
                                     window. If the applet's frame is the
                                     top-level frame, acts the same as `_self`.
   `_blank` Show in a new, unnamed
                                     top-level window.
   nameShow in the frame or window named name. If
                          a target named name does not already exist, a
                          new top-level window with the specified name is created,
                          and the document is shown there.


   An applet viewer or browser is free to ignore showDocument.

  url - an absolute URL giving the location of the document. - `java.net.URL`
  target - a String indicating where to display the page. - `java.lang.String`"
  ([^java.applet.AppletContext this ^java.net.URL url ^java.lang.String target]
    (-> this (.showDocument url target)))
  ([^java.applet.AppletContext this ^java.net.URL url]
    (-> this (.showDocument url))))

(defn get-audio-clip
  "Creates an audio clip.

  url - an absolute URL giving the location of the audio clip. - `java.net.URL`

  returns: the audio clip at the specified URL. - `java.applet.AudioClip`"
  (^java.applet.AudioClip [^java.applet.AppletContext this ^java.net.URL url]
    (-> this (.getAudioClip url))))

