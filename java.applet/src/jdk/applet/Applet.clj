(ns jdk.applet.Applet
  "An applet is a small program that is intended not to be run on
  its own, but rather to be embedded inside another application.

  The Applet class must be the superclass of any
  applet that is to be embedded in a Web page or viewed by the Java
  Applet Viewer. The Applet class provides a standard
  interface between applets and their environment."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.applet Applet]))

(defn ->applet
  "Constructor.

  Constructs a new Applet.

   Note: Many methods in java.applet.Applet
   may be invoked by the applet only after the applet is
   fully constructed; applet should avoid calling methods
   in java.applet.Applet in the constructor.

  throws: java.awt.HeadlessException - if GraphicsEnvironment.isHeadless() returns true."
  ([]
    (new Applet )))

(defn *new-audio-clip
  "Get an audio clip from the given URL.

  url - points to the audio clip - `java.net.URL`

  returns: the audio clip at the specified URL. - `java.applet.AudioClip`"
  (^java.applet.AudioClip [^java.net.URL url]
    (Applet/newAudioClip url)))

(defn get-image
  "Returns an Image object that can then be painted on
   the screen. The url argument must specify an absolute
   URL. The name argument is a specifier that is
   relative to the url argument.

   This method always returns immediately, whether or not the image
   exists. When this applet attempts to draw the image on the screen,
   the data will be loaded. The graphics primitives that draw the
   image will incrementally paint on the screen.

  url - an absolute URL giving the base location of the image. - `java.net.URL`
  name - the location of the image, relative to the url argument. - `java.lang.String`

  returns: the image at the specified URL. - `java.awt.Image`"
  (^java.awt.Image [^java.applet.Applet this ^java.net.URL url ^java.lang.String name]
    (-> this (.getImage url name)))
  (^java.awt.Image [^java.applet.Applet this ^java.net.URL url]
    (-> this (.getImage url))))

(defn get-code-base
  "Gets the base URL. This is the URL of the directory which contains this applet.

  returns: the base URL of
            the directory which contains this applet. - `java.net.URL`"
  (^java.net.URL [^java.applet.Applet this]
    (-> this (.getCodeBase))))

(defn stop
  "Called by the browser or applet viewer to inform
   this applet that it should stop its execution. It is called when
   the Web page that contains this applet has been replaced by
   another page, and also just before the applet is to be destroyed.

   A subclass of Applet should override this method if
   it has any operation that it wants to perform each time the Web
   page containing it is no longer visible. For example, an applet
   with animation might want to use the start method to
   resume animation, and the stop method to suspend the
   animation.

   The implementation of this method provided by the
   Applet class does nothing."
  ([^java.applet.Applet this]
    (-> this (.stop))))

(defn active?
  "Determines if this applet is active. An applet is marked active
   just before its start method is called. It becomes
   inactive just before its stop method is called.

  returns: true if the applet is active;
            false otherwise. - `boolean`"
  (^Boolean [^java.applet.Applet this]
    (-> this (.isActive))))

(defn play
  "Plays the audio clip given the URL and a specifier that is
   relative to it. Nothing happens if the audio clip cannot be found.

  url - an absolute URL giving the base location of the audio clip. - `java.net.URL`
  name - the location of the audio clip, relative to the url argument. - `java.lang.String`"
  ([^java.applet.Applet this ^java.net.URL url ^java.lang.String name]
    (-> this (.play url name)))
  ([^java.applet.Applet this ^java.net.URL url]
    (-> this (.play url))))

(defn set-stub
  "Sets this applet's stub. This is done automatically by the system.
   If there is a security manager, its  checkPermission
   method is called with the
   AWTPermission(`setAppletStub`)
   permission if a stub has already been set.

  stub - the new stub. - `java.applet.AppletStub`

  throws: java.lang.SecurityException - if the caller cannot set the stub"
  ([^java.applet.Applet this ^java.applet.AppletStub stub]
    (-> this (.setStub stub))))

(defn get-locale
  "Gets the locale of the applet. It allows the applet
   to maintain its own locale separated from the locale
   of the browser or appletviewer.

  returns: the locale of the applet; if no locale has
            been set, the default locale is returned. - `java.util.Locale`"
  (^java.util.Locale [^java.applet.Applet this]
    (-> this (.getLocale))))

(defn validate-root?
  "Indicates if this container is a validate root.

   Applet objects are the validate roots, and, therefore, they
   override this method to return true.

  returns: true - `boolean`"
  (^Boolean [^java.applet.Applet this]
    (-> this (.isValidateRoot))))

(defn destroy
  "Called by the browser or applet viewer to inform
   this applet that it is being reclaimed and that it should destroy
   any resources that it has allocated. The stop method
   will always be called before destroy.

   A subclass of Applet should override this method if
   it has any operation that it wants to perform before it is
   destroyed. For example, an applet with threads would use the
   init method to create the threads and the
   destroy method to kill them.

   The implementation of this method provided by the
   Applet class does nothing."
  ([^java.applet.Applet this]
    (-> this (.destroy))))

(defn start
  "Called by the browser or applet viewer to inform
   this applet that it should start its execution. It is called after
   the init method and each time the applet is revisited
   in a Web page.

   A subclass of Applet should override this method if
   it has any operation that it wants to perform each time the Web
   page containing it is visited. For example, an applet with
   animation might want to use the start method to
   resume animation, and the stop method to suspend the
   animation.

   Note: some methods, such as getLocationOnScreen, can only
   provide meaningful results if the applet is showing.  Because
   isShowing returns false when the applet's
   start is first called, methods requiring
   isShowing to return true should be called from
   a ComponentListener.

   The implementation of this method provided by the
   Applet class does nothing."
  ([^java.applet.Applet this]
    (-> this (.start))))

(defn get-parameter
  "Returns the value of the named parameter in the HTML tag. For
   example, if this applet is specified as


   <applet code=`Clock` width=50 height=50>
   <param name=Color value=`blue`>
   </applet>

   then a call to getParameter(`Color`) returns the
   value `blue`.

   The name argument is case insensitive.

  name - a parameter name. - `java.lang.String`

  returns: the value of the named parameter,
            or null if not set. - `java.lang.String`"
  (^java.lang.String [^java.applet.Applet this ^java.lang.String name]
    (-> this (.getParameter name))))

(defn get-accessible-context
  "Gets the AccessibleContext associated with this Applet.
   For applets, the AccessibleContext takes the form of an
   AccessibleApplet.
   A new AccessibleApplet instance is created if necessary.

  returns: an AccessibleApplet that serves as the
           AccessibleContext of this Applet - `javax.accessibility.AccessibleContext`"
  (^javax.accessibility.AccessibleContext [^java.applet.Applet this]
    (-> this (.getAccessibleContext))))

(defn get-document-base
  "Gets the URL of the document in which this applet is embedded.
   For example, suppose an applet is contained
   within the document:


      http://www.oracle.com/technetwork/java/index.html
   The document base is:


      http://www.oracle.com/technetwork/java/index.html

  returns: the URL of the document that contains this
            applet. - `java.net.URL`"
  (^java.net.URL [^java.applet.Applet this]
    (-> this (.getDocumentBase))))

(defn init
  "Called by the browser or applet viewer to inform
   this applet that it has been loaded into the system. It is always
   called before the first time that the start method is
   called.

   A subclass of Applet should override this method if
   it has initialization to perform. For example, an applet with
   threads would use the init method to create the
   threads and the destroy method to kill them.

   The implementation of this method provided by the
   Applet class does nothing."
  ([^java.applet.Applet this]
    (-> this (.init))))

(defn show-status
  "Requests that the argument string be displayed in the
   `status window`. Many browsers and applet viewers
   provide such a window, where the application can inform users of
   its current state.

  msg - a string to display in the status window. - `java.lang.String`"
  ([^java.applet.Applet this ^java.lang.String msg]
    (-> this (.showStatus msg))))

(defn get-applet-context
  "Determines this applet's context, which allows the applet to
   query and affect the environment in which it runs.

   This environment of an applet represents the document that
   contains the applet.

  returns: the applet's context. - `java.applet.AppletContext`"
  (^java.applet.AppletContext [^java.applet.Applet this]
    (-> this (.getAppletContext))))

(defn resize
  "Requests that this applet be resized.

  width - the new requested width for the applet. - `int`
  height - the new requested height for the applet. - `int`"
  ([^java.applet.Applet this ^Integer width ^Integer height]
    (-> this (.resize width height)))
  ([^java.applet.Applet this ^java.awt.Dimension d]
    (-> this (.resize d))))

(defn get-applet-info
  "Returns information about this applet. An applet should override
   this method to return a String containing information
   about the author, version, and copyright of the applet.

   The implementation of this method provided by the
   Applet class returns null.

  returns: a string containing information about the author, version, and
            copyright of the applet. - `java.lang.String`"
  (^java.lang.String [^java.applet.Applet this]
    (-> this (.getAppletInfo))))

(defn get-audio-clip
  "Returns the AudioClip object specified by the
   URL and name arguments.

   This method always returns immediately, whether or not the audio
   clip exists. When this applet attempts to play the audio clip, the
   data will be loaded.

  url - an absolute URL giving the base location of the audio clip. - `java.net.URL`
  name - the location of the audio clip, relative to the url argument. - `java.lang.String`

  returns: the audio clip at the specified URL. - `java.applet.AudioClip`"
  (^java.applet.AudioClip [^java.applet.Applet this ^java.net.URL url ^java.lang.String name]
    (-> this (.getAudioClip url name)))
  (^java.applet.AudioClip [^java.applet.Applet this ^java.net.URL url]
    (-> this (.getAudioClip url))))

(defn get-parameter-info
  "Returns information about the parameters that are understood by
   this applet. An applet should override this method to return an
   array of Strings describing these parameters.

   Each element of the array should be a set of three
   Strings containing the name, the type, and a
   description. For example:


   String pinfo[][] = {
     {`fps`,    `1-10`,    `frames per second`},
     {`repeat`, `boolean`, `repeat image loop`},
     {`imgs`,   `url`,     `images directory`}
   };

   The implementation of this method provided by the
   Applet class returns null.

  returns: an array describing the parameters this applet looks for. - `java.lang.String[][]`"
  ([^java.applet.Applet this]
    (-> this (.getParameterInfo))))

