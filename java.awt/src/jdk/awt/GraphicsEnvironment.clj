(ns jdk.awt.GraphicsEnvironment
  "The GraphicsEnvironment class describes the collection
  of GraphicsDevice objects and Font objects
  available to a Java(tm) application on a particular platform.
  The resources in this GraphicsEnvironment might be local
  or on a remote machine.  GraphicsDevice objects can be
  screens, printers or image buffers and are the destination of
  Graphics2D drawing methods.  Each GraphicsDevice
  has a number of GraphicsConfiguration objects associated with
  it.  These objects specify the different configurations in which the
  GraphicsDevice can be used."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt GraphicsEnvironment]))

(defn *get-local-graphics-environment
  "Returns the local GraphicsEnvironment.

  returns: the local GraphicsEnvironment - `java.awt.GraphicsEnvironment`"
  ([]
    (GraphicsEnvironment/getLocalGraphicsEnvironment )))

(defn *headless?
  "Tests whether or not a display, keyboard, and mouse can be
   supported in this environment.  If this method returns true,
   a HeadlessException is thrown from areas of the Toolkit
   and GraphicsEnvironment that are dependent on a display,
   keyboard, or mouse.

  returns: true if this environment cannot support
   a display, keyboard, and mouse; false
   otherwise - `boolean`"
  ([]
    (GraphicsEnvironment/isHeadless )))

(defn get-maximum-window-bounds
  "Returns the maximum bounds for centered Windows.
   These bounds account for objects in the native windowing system such as
   task bars and menu bars.  The returned bounds will reside on a single
   display with one exception: on multi-screen systems where Windows should
   be centered across all displays, this method returns the bounds of the
   entire display area.

   To get the usable bounds of a single display, use
   GraphicsConfiguration.getBounds() and
   Toolkit.getScreenInsets().

  returns: the maximum bounds for centered Windows - `java.awt.Rectangle`

  throws: java.awt.HeadlessException - if isHeadless() returns true"
  ([^java.awt.GraphicsEnvironment this]
    (-> this (.getMaximumWindowBounds))))

(defn get-default-screen-device
  "Returns the default screen GraphicsDevice.

  returns: the GraphicsDevice that represents the
   default screen device - `java.awt.GraphicsDevice`

  throws: java.awt.HeadlessException - if isHeadless() returns true"
  ([^java.awt.GraphicsEnvironment this]
    (-> this (.getDefaultScreenDevice))))

(defn prefer-proportional-fonts
  "Indicates a preference for proportional over non-proportional (e.g.
   dual-spaced CJK fonts) fonts in the mapping of logical fonts to
   physical fonts. If the default mapping contains fonts for which
   proportional and non-proportional variants exist, then calling
   this method indicates the mapping should use a proportional variant.

   The actual change in font rendering behavior resulting from a call to
   this method is implementation dependent; it may have no effect at all.
   The behavior may differ between font rendering in lightweight and
   peered components. Since calling this method requests a
   different font, clients should expect different metrics, and may need
   to recalculate window sizes and layout. Therefore this method should
   be called before user interface initialisation."
  ([^java.awt.GraphicsEnvironment this]
    (-> this (.preferProportionalFonts))))

(defn headless-instance?
  "Returns whether or not a display, keyboard, and mouse can be
   supported in this graphics environment.  If this returns true,
   HeadlessException will be thrown from areas of the
   graphics environment that are dependent on a display, keyboard, or
   mouse.

  returns: true if a display, keyboard, and mouse
   can be supported in this environment; false
   otherwise - `boolean`"
  ([^java.awt.GraphicsEnvironment this]
    (-> this (.isHeadlessInstance))))

(defn get-available-font-family-names
  "Returns an array containing the names of all font families in this
   GraphicsEnvironment localized for the specified locale.

   Typical usage would be for presentation to a user for selection of
   a particular family name. An application can then specify this name
   when creating a font, in conjunction with a style, such as bold or
   italic, giving the font system flexibility in choosing its own best
   match among multiple fonts in the same font family.

  l - a Locale object that represents a particular geographical, political, or cultural region. Specifying null is equivalent to specifying Locale.getDefault(). - `java.util.Locale`

  returns: an array of String containing font family names
   localized for the specified Locale, or a
   suitable alternative name if no name exists for the specified locale. - `java.lang.String[]`"
  ([^java.awt.GraphicsEnvironment this ^java.util.Locale l]
    (-> this (.getAvailableFontFamilyNames l)))
  ([^java.awt.GraphicsEnvironment this]
    (-> this (.getAvailableFontFamilyNames))))

(defn register-font
  "Registers a created Fontin this
   GraphicsEnvironment.
   A created font is one that was returned from calling
   Font.createFont(int, java.io.InputStream), or derived from a created font by
   calling Font.deriveFont(int, float).
   After calling this method for such a font, it is available to
   be used in constructing new Fonts by name or family name,
   and is enumerated by getAvailableFontFamilyNames() and
   getAllFonts() within the execution context of this
   application or applet. This means applets cannot register fonts in
   a way that they are visible to other applets.

   Reasons that this method might not register the font and therefore
   return false are:

   The font is not a created Font.
   The font conflicts with a non-created Font already
   in this GraphicsEnvironment. For example if the name
   is that of a system font, or a logical font as described in the
   documentation of the Font class. It is implementation dependent
   whether a font may also conflict if it has the same family name
   as a system font.
   Notice that an application can supersede the registration
   of an earlier created font with a new one.

  font - `java.awt.Font`

  returns: true if the font is successfully
   registered in this GraphicsEnvironment. - `boolean`

  throws: java.lang.NullPointerException - if font is null"
  ([^java.awt.GraphicsEnvironment this ^java.awt.Font font]
    (-> this (.registerFont font))))

(defn get-all-fonts
  "Returns an array containing a one-point size instance of all fonts
   available in this GraphicsEnvironment.  Typical usage
   would be to allow a user to select a particular font.  Then, the
   application can size the font and set various font attributes by
   calling the deriveFont method on the chosen instance.

   This method provides for the application the most precise control
   over which Font instance is used to render text.
   If a font in this GraphicsEnvironment has multiple
   programmable variations, only one
   instance of that Font is returned in the array, and
   other variations must be derived by the application.

   If a font in this environment has multiple programmable variations,
   such as Multiple-Master fonts, only one instance of that font is
   returned in the Font array.  The other variations
   must be derived by the application.

  returns: an array of Font objects - `java.awt.Font[]`"
  ([^java.awt.GraphicsEnvironment this]
    (-> this (.getAllFonts))))

(defn prefer-locale-fonts
  "Indicates a preference for locale-specific fonts in the mapping of
   logical fonts to physical fonts. Calling this method indicates that font
   rendering should primarily use fonts specific to the primary writing
   system (the one indicated by the default encoding and the initial
   default locale). For example, if the primary writing system is
   Japanese, then characters should be rendered using a Japanese font
   if possible, and other fonts should only be used for characters for
   which the Japanese font doesn't have glyphs.

   The actual change in font rendering behavior resulting from a call
   to this method is implementation dependent; it may have no effect at
   all, or the requested behavior may already match the default behavior.
   The behavior may differ between font rendering in lightweight
   and peered components.  Since calling this method requests a
   different font, clients should expect different metrics, and may need
   to recalculate window sizes and layout. Therefore this method should
   be called before user interface initialisation."
  ([^java.awt.GraphicsEnvironment this]
    (-> this (.preferLocaleFonts))))

(defn get-screen-devices
  "Returns an array of all of the screen GraphicsDevice
   objects.

  returns: an array containing all the GraphicsDevice
   objects that represent screen devices - `java.awt.GraphicsDevice[]`

  throws: java.awt.HeadlessException - if isHeadless() returns true"
  ([^java.awt.GraphicsEnvironment this]
    (-> this (.getScreenDevices))))

(defn create-graphics
  "Returns a Graphics2D object for rendering into the
   specified BufferedImage.

  img - the specified BufferedImage - `java.awt.image.BufferedImage`

  returns: a Graphics2D to be used for rendering into
   the specified BufferedImage - `java.awt.Graphics2D`

  throws: java.lang.NullPointerException - if img is null"
  ([^java.awt.GraphicsEnvironment this ^java.awt.image.BufferedImage img]
    (-> this (.createGraphics img))))

(defn get-center-point
  "Returns the Point where Windows should be centered.
   It is recommended that centered Windows be checked to ensure they fit
   within the available display area using getMaximumWindowBounds().

  returns: the point where Windows should be centered - `java.awt.Point`

  throws: java.awt.HeadlessException - if isHeadless() returns true"
  ([^java.awt.GraphicsEnvironment this]
    (-> this (.getCenterPoint))))

