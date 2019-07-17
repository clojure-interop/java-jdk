(ns jdk.applet.AppletStub
  "When an applet is first created, an applet stub is attached to it
  using the applet's setStub method. This stub
  serves as the interface between the applet and the browser
  environment or applet viewer environment in which the application
  is running."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.applet AppletStub]))

(defn active?
  "Determines if the applet is active. An applet is active just
   before its start method is called. It becomes
   inactive just before its stop method is called.

  returns: true if the applet is active;
            false otherwise. - `boolean`"
  ([^. this]
    (-> this (.isActive))))

(defn get-document-base
  "Gets the URL of the document in which the applet is embedded.
   For example, suppose an applet is contained
   within the document:


      http://www.oracle.com/technetwork/java/index.html
   The document base is:


      http://www.oracle.com/technetwork/java/index.html

  returns: the URL of the document that contains the
            applet. - `java.net.URL`"
  ([^. this]
    (-> this (.getDocumentBase))))

(defn get-code-base
  "Gets the base URL. This is the URL of the directory which contains the applet.

  returns: the base URL of
            the directory which contains the applet. - `java.net.URL`"
  ([^. this]
    (-> this (.getCodeBase))))

(defn get-parameter
  "Returns the value of the named parameter in the HTML tag. For
   example, if an applet is specified as


   <applet code=`Clock` width=50 height=50>
   <param name=Color value=`blue`>
   </applet>

   then a call to getParameter(`Color`) returns the
   value `blue`.

  name - a parameter name. - `java.lang.String`

  returns: the value of the named parameter,
   or null if not set. - `java.lang.String`"
  ([^. this ^java.lang.String name]
    (-> this (.getParameter name))))

(defn get-applet-context
  "Returns the applet's context.

  returns: the applet's context. - `java.applet.AppletContext`"
  ([^. this]
    (-> this (.getAppletContext))))

(defn applet-resize
  "Called when the applet wants to be resized.

  width - the new requested width for the applet. - `int`
  height - the new requested height for the applet. - `int`"
  ([^. this ^Integer width ^Integer height]
    (-> this (.appletResize width height))))

