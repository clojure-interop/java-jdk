(ns javax.swing.colorchooser.AbstractColorChooserPanel
  "This is the abstract superclass for color choosers.  If you want to add
  a new color chooser panel into a JColorChooser, subclass
  this class.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.colorchooser AbstractColorChooserPanel]))

(defn ->abstract-color-chooser-panel
  "Constructor."
  ([]
    (new AbstractColorChooserPanel )))

(defn get-mnemonic
  "Provides a hint to the look and feel as to the
   KeyEvent.VK constant that can be used as a mnemonic to
   access the panel. A return value <= 0 indicates there is no mnemonic.

   The return value here is a hint, it is ultimately up to the look
   and feel to honor the return value in some meaningful way.

   This implementation returns 0, indicating the
   AbstractColorChooserPanel does not support a mnemonic,
   subclasses wishing a mnemonic will need to override this.

  returns: KeyEvent.VK constant identifying the mnemonic; <= 0 for no
           mnemonic - `int`"
  (^Integer [^javax.swing.colorchooser.AbstractColorChooserPanel this]
    (-> this (.getMnemonic))))

(defn get-large-display-icon
  "Returns the large display icon for the panel.

  returns: the large display icon - `javax.swing.Icon`"
  (^javax.swing.Icon [^javax.swing.colorchooser.AbstractColorChooserPanel this]
    (-> this (.getLargeDisplayIcon))))

(defn get-display-name
  "Returns a string containing the display name of the panel.

  returns: the name of the display panel - `java.lang.String`"
  (^java.lang.String [^javax.swing.colorchooser.AbstractColorChooserPanel this]
    (-> this (.getDisplayName))))

(defn uninstall-chooser-panel
  "Invoked when the panel is removed from the chooser.
   If override this, be sure to call super.

  enclosing-chooser - `javax.swing.JColorChooser`"
  ([^javax.swing.colorchooser.AbstractColorChooserPanel this ^javax.swing.JColorChooser enclosing-chooser]
    (-> this (.uninstallChooserPanel enclosing-chooser))))

(defn install-chooser-panel
  "Invoked when the panel is added to the chooser.
   If you override this, be sure to call super.

  enclosing-chooser - the panel to be added - `javax.swing.JColorChooser`

  throws: java.lang.RuntimeException - if the chooser panel has already been installed"
  ([^javax.swing.colorchooser.AbstractColorChooserPanel this ^javax.swing.JColorChooser enclosing-chooser]
    (-> this (.installChooserPanel enclosing-chooser))))

(defn paint
  "Draws the panel.

  g - the Graphics object - `java.awt.Graphics`"
  ([^javax.swing.colorchooser.AbstractColorChooserPanel this ^java.awt.Graphics g]
    (-> this (.paint g))))

(defn update-chooser
  "Invoked automatically when the model's state changes.
   It is also called by installChooserPanel to allow
   you to set up the initial state of your chooser.
   Override this method to update your ChooserPanel."
  ([^javax.swing.colorchooser.AbstractColorChooserPanel this]
    (-> this (.updateChooser))))

(defn get-color-selection-model
  "Returns the model that the chooser panel is editing.

  returns: the ColorSelectionModel model this panel
           is editing - `javax.swing.colorchooser.ColorSelectionModel`"
  (^javax.swing.colorchooser.ColorSelectionModel [^javax.swing.colorchooser.AbstractColorChooserPanel this]
    (-> this (.getColorSelectionModel))))

(defn get-displayed-mnemonic-index
  "Provides a hint to the look and feel as to the index of the character in
   getDisplayName that should be visually identified as the
   mnemonic. The look and feel should only use this if
   getMnemonic returns a value > 0.

   The return value here is a hint, it is ultimately up to the look
   and feel to honor the return value in some meaningful way. For example,
   a look and feel may wish to render each
   AbstractColorChooserPanel in a JTabbedPane,
   and further use this return value to underline a character in
   the getDisplayName.

   This implementation returns -1, indicating the
   AbstractColorChooserPanel does not support a mnemonic,
   subclasses wishing a mnemonic will need to override this.

  returns: Character index to render mnemonic for; -1 to provide no
                     visual identifier for this panel. - `int`"
  (^Integer [^javax.swing.colorchooser.AbstractColorChooserPanel this]
    (-> this (.getDisplayedMnemonicIndex))))

(defn get-small-display-icon
  "Returns the small display icon for the panel.

  returns: the small display icon - `javax.swing.Icon`"
  (^javax.swing.Icon [^javax.swing.colorchooser.AbstractColorChooserPanel this]
    (-> this (.getSmallDisplayIcon))))

