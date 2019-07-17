(ns jdk.awt.Desktop
  "The Desktop class allows a Java application to launch
  associated applications registered on the native desktop to handle
  a URI or a file.

   Supported operations include:

    launching the user-default browser to show a specified
        URI;
    launching the user-default mail client with an optional
        mailto URI;
    launching a registered application to open, edit or print a
        specified file.


   This class provides methods corresponding to these
  operations. The methods look for the associated application
  registered on the current platform, and launch it to handle a URI
  or file. If there is no associated application or the associated
  application fails to be launched, an exception is thrown.

   An application is registered to a URI or file type; for
  example, the `sxi` file extension is typically registered
  to StarOffice.  The mechanism of registering, accessing, and
  launching the associated application is platform-dependent.

   Each operation is an action type represented by the Desktop.Action class.

   Note: when some action is invoked and the associated
  application is executed, it will be executed on the same system as
  the one on which the Java application was launched."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt Desktop]))

(defn *get-desktop
  "Returns the Desktop instance of the current
   browser context.  On some platforms the Desktop API may not be
   supported; use the isDesktopSupported() method to
   determine if the current desktop is supported.

  returns: the Desktop instance of the current browser context - `java.awt.Desktop`

  throws: java.awt.HeadlessException - if GraphicsEnvironment.isHeadless() returns true"
  (^java.awt.Desktop []
    (Desktop/getDesktop )))

(defn *desktop-supported?
  "Tests whether this class is supported on the current platform.
   If it's supported, use getDesktop() to retrieve an
   instance.

  returns: true if this class is supported on the
           current platform; false otherwise - `boolean`"
  (^Boolean []
    (Desktop/isDesktopSupported )))

(defn supported?
  "Tests whether an action is supported on the current platform.

   Even when the platform supports an action, a file or URI may
   not have a registered application for the action.  For example,
   most of the platforms support the Desktop.Action.OPEN
   action.  But for a specific file, there may not be an
   application registered to open it.  In this case, isSupported(java.awt.Desktop.Action) may return true, but the corresponding
   action method will throw an IOException.

  action - the specified Desktop.Action - `java.awt.Desktop.Action`

  returns: true if the specified action is supported on
           the current platform; false otherwise - `boolean`"
  (^Boolean [^java.awt.Desktop this ^java.awt.Desktop.Action action]
    (-> this (.isSupported action))))

(defn open
  "Launches the associated application to open the file.

    If the specified file is a directory, the file manager of
   the current platform is launched to open it.

  file - the file to be opened with the associated application - `java.io.File`

  throws: java.lang.NullPointerException - if file is null"
  ([^java.awt.Desktop this ^java.io.File file]
    (-> this (.open file))))

(defn edit
  "Launches the associated editor application and opens a file for
   editing.

  file - the file to be opened for editing - `java.io.File`

  throws: java.lang.NullPointerException - if the specified file is null"
  ([^java.awt.Desktop this ^java.io.File file]
    (-> this (.edit file))))

(defn print
  "Prints a file with the native desktop printing facility, using
   the associated application's print command.

  file - the file to be printed - `java.io.File`

  throws: java.lang.NullPointerException - if the specified file is null"
  ([^java.awt.Desktop this ^java.io.File file]
    (-> this (.print file))))

(defn browse
  "Launches the default browser to display a URI.
   If the default browser is not able to handle the specified
   URI, the application registered for handling
   URIs of the specified type is invoked. The application
   is determined from the protocol and path of the URI, as
   defined by the URI class.

   If the calling thread does not have the necessary permissions,
   and this is invoked from within an applet,
   AppletContext.showDocument() is used. Similarly, if the calling
   does not have the necessary permissions, and this is invoked from within
   a Java Web Started application, BasicService.showDocument()
   is used.

  uri - the URI to be displayed in the user default browser - `java.net.URI`

  throws: java.lang.NullPointerException - if uri is null"
  ([^java.awt.Desktop this ^java.net.URI uri]
    (-> this (.browse uri))))

(defn mail
  "Launches the mail composing window of the user default mail
   client, filling the message fields specified by a mailto: URI.

    A mailto: URI can specify message fields
   including `to`, `cc`, `subject`,
   `body`, etc.  See The mailto URL
   scheme (RFC 2368) for the mailto: URI specification
   details.

  mailto-uri - the specified mailto: URI - `java.net.URI`

  throws: java.lang.NullPointerException - if the specified URI is null"
  ([^java.awt.Desktop this ^java.net.URI mailto-uri]
    (-> this (.mail mailto-uri)))
  ([^java.awt.Desktop this]
    (-> this (.mail))))

