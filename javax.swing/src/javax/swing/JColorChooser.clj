(ns javax.swing.JColorChooser
  "JColorChooser provides a pane of controls designed to allow
  a user to manipulate and select a color.
  For information about using color choosers, see
  How to Use Color Choosers,
  a section in The Java Tutorial.



  This class provides three levels of API:

  A static convenience method which shows a modal color-chooser
  dialog and returns the color selected by the user.
  A static convenience method for creating a color-chooser dialog
  where ActionListeners can be specified to be invoked when
  the user presses one of the dialog buttons.
  The ability to create instances of JColorChooser panes
  directly (within any container). PropertyChange listeners
  can be added to detect when the current `color` property changes.


  Warning: Swing is not thread safe. For more
  information see Swing's Threading
  Policy.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing JColorChooser]))

(defn ->j-color-chooser
  "Constructor.

  Creates a color chooser pane with the specified initial color.

  initial-color - the initial color set in the chooser - `java.awt.Color`"
  ([^java.awt.Color initial-color]
    (new JColorChooser initial-color))
  ([]
    (new JColorChooser )))

(def *-selection-model-property
  "Static Constant.

  The selection model property name.

  type: java.lang.String"
  JColorChooser/SELECTION_MODEL_PROPERTY)

(def *-preview-panel-property
  "Static Constant.

  The preview panel property name.

  type: java.lang.String"
  JColorChooser/PREVIEW_PANEL_PROPERTY)

(def *-chooser-panels-property
  "Static Constant.

  The chooserPanel array property name.

  type: java.lang.String"
  JColorChooser/CHOOSER_PANELS_PROPERTY)

(defn *show-dialog
  "Shows a modal color-chooser dialog and blocks until the
   dialog is hidden.  If the user presses the `OK` button, then
   this method hides/disposes the dialog and returns the selected color.
   If the user presses the `Cancel` button or closes the dialog without
   pressing `OK`, then this method hides/disposes the dialog and returns
   null.

  component - the parent Component for the dialog - `java.awt.Component`
  title - the String containing the dialog's title - `java.lang.String`
  initial-color - the initial Color set when the color-chooser is shown - `java.awt.Color`

  returns: the selected color or null if the user opted out - `java.awt.Color`

  throws: java.awt.HeadlessException - if GraphicsEnvironment.isHeadless() returns true."
  ([^java.awt.Component component ^java.lang.String title ^java.awt.Color initial-color]
    (JColorChooser/showDialog component title initial-color)))

(defn *create-dialog
  "Creates and returns a new dialog containing the specified
   ColorChooser pane along with `OK`, `Cancel`, and `Reset`
   buttons. If the `OK` or `Cancel` buttons are pressed, the dialog is
   automatically hidden (but not disposed).  If the `Reset`
   button is pressed, the color-chooser's color will be reset to the
   color which was set the last time show was invoked on the
   dialog and the dialog will remain showing.

  c - the parent component for the dialog - `java.awt.Component`
  title - the title for the dialog - `java.lang.String`
  modal - a boolean. When true, the remainder of the program is inactive until the dialog is closed. - `boolean`
  chooser-pane - the color-chooser to be placed inside the dialog - `javax.swing.JColorChooser`
  ok-listener - the ActionListener invoked when `OK` is pressed - `java.awt.event.ActionListener`
  cancel-listener - the ActionListener invoked when `Cancel` is pressed - `java.awt.event.ActionListener`

  returns: a new dialog containing the color-chooser pane - `javax.swing.JDialog`

  throws: java.awt.HeadlessException - if GraphicsEnvironment.isHeadless() returns true."
  ([^java.awt.Component c ^java.lang.String title ^Boolean modal ^javax.swing.JColorChooser chooser-pane ^java.awt.event.ActionListener ok-listener ^java.awt.event.ActionListener cancel-listener]
    (JColorChooser/createDialog c title modal chooser-pane ok-listener cancel-listener)))

(defn set-preview-panel
  "Sets the current preview panel.
   This will fire a PropertyChangeEvent for the property
   named `previewPanel`.

  preview - the JComponent which displays the current color - `javax.swing.JComponent`"
  ([^javax.swing.JColorChooser this ^javax.swing.JComponent preview]
    (-> this (.setPreviewPanel preview))))

(defn add-chooser-panel
  "Adds a color chooser panel to the color chooser.

  panel - the AbstractColorChooserPanel to be added - `javax.swing.colorchooser.AbstractColorChooserPanel`"
  ([^javax.swing.JColorChooser this ^javax.swing.colorchooser.AbstractColorChooserPanel panel]
    (-> this (.addChooserPanel panel))))

(defn get-chooser-panels
  "Returns the specified color panels.

  returns: an array of AbstractColorChooserPanel objects - `javax.swing.colorchooser.AbstractColorChooserPanel[]`"
  ([^javax.swing.JColorChooser this]
    (-> this (.getChooserPanels))))

(defn remove-chooser-panel
  "Removes the Color Panel specified.

  panel - a string that specifies the panel to be removed - `javax.swing.colorchooser.AbstractColorChooserPanel`

  returns: the color panel - `javax.swing.colorchooser.AbstractColorChooserPanel`

  throws: java.lang.IllegalArgumentException - if panel is not in list of known chooser panels"
  ([^javax.swing.JColorChooser this ^javax.swing.colorchooser.AbstractColorChooserPanel panel]
    (-> this (.removeChooserPanel panel))))

(defn get-ui-class-id
  "Returns the name of the L&F class that renders this component.

  returns: the string `ColorChooserUI` - `java.lang.String`"
  ([^javax.swing.JColorChooser this]
    (-> this (.getUIClassID))))

(defn set-selection-model
  "Sets the model containing the selected color.

  new-model - the new ColorSelectionModel object - `javax.swing.colorchooser.ColorSelectionModel`"
  ([^javax.swing.JColorChooser this ^javax.swing.colorchooser.ColorSelectionModel new-model]
    (-> this (.setSelectionModel new-model))))

(defn get-preview-panel
  "Returns the preview panel that shows a chosen color.

  returns: a JComponent object -- the preview panel - `javax.swing.JComponent`"
  ([^javax.swing.JColorChooser this]
    (-> this (.getPreviewPanel))))

(defn get-selection-model
  "Returns the data model that handles color selections.

  returns: a ColorSelectionModel object - `javax.swing.colorchooser.ColorSelectionModel`"
  ([^javax.swing.JColorChooser this]
    (-> this (.getSelectionModel))))

(defn set-ui
  "Sets the L&F object that renders this component.

  ui - the ColorChooserUI L&F object - `javax.swing.plaf.ColorChooserUI`"
  ([^javax.swing.JColorChooser this ^javax.swing.plaf.ColorChooserUI ui]
    (-> this (.setUI ui))))

(defn set-drag-enabled
  "Sets the dragEnabled property,
   which must be true to enable
   automatic drag handling (the first part of drag and drop)
   on this component.
   The transferHandler property needs to be set
   to a non-null value for the drag to do
   anything.  The default value of the dragEnabled
   property
   is false.



   When automatic drag handling is enabled,
   most look and feels begin a drag-and-drop operation
   when the user presses the mouse button over the preview panel.
   Some look and feels might not support automatic drag and drop;
   they will ignore this property.  You can work around such
   look and feels by modifying the component
   to directly call the exportAsDrag method of a
   TransferHandler.

  b - the value to set the dragEnabled property to - `boolean`

  throws: java.awt.HeadlessException - if b is true and GraphicsEnvironment.isHeadless() returns true"
  ([^javax.swing.JColorChooser this ^Boolean b]
    (-> this (.setDragEnabled b))))

(defn get-ui
  "Returns the L&F object that renders this component.

  returns: the ColorChooserUI object that renders
            this component - `javax.swing.plaf.ColorChooserUI`"
  ([^javax.swing.JColorChooser this]
    (-> this (.getUI))))

(defn set-color
  "Sets the current color of the color chooser to the
   specified RGB color.  Note that the values of red, green,
   and blue should be between the numbers 0 and 255, inclusive.

  r - an int specifying the amount of Red - `int`
  g - an int specifying the amount of Green - `int`
  b - an int specifying the amount of Blue - `int`

  throws: java.lang.IllegalArgumentException - if r,g,b values are out of range"
  ([^javax.swing.JColorChooser this ^Integer r ^Integer g ^Integer b]
    (-> this (.setColor r g b)))
  ([^javax.swing.JColorChooser this ^java.awt.Color color]
    (-> this (.setColor color))))

(defn set-chooser-panels
  "Specifies the Color Panels used to choose a color value.

  panels - an array of AbstractColorChooserPanel objects - `javax.swing.colorchooser.AbstractColorChooserPanel[]`"
  ([^javax.swing.JColorChooser this ^javax.swing.colorchooser.AbstractColorChooserPanel[] panels]
    (-> this (.setChooserPanels panels))))

(defn get-accessible-context
  "Gets the AccessibleContext associated with this JColorChooser.
   For color choosers, the AccessibleContext takes the form of an
   AccessibleJColorChooser.
   A new AccessibleJColorChooser instance is created if necessary.

  returns: an AccessibleJColorChooser that serves as the
           AccessibleContext of this JColorChooser - `javax.accessibility.AccessibleContext`"
  ([^javax.swing.JColorChooser this]
    (-> this (.getAccessibleContext))))

(defn get-drag-enabled?
  "Gets the value of the dragEnabled property.

  returns: the value of the dragEnabled property - `boolean`"
  ([^javax.swing.JColorChooser this]
    (-> this (.getDragEnabled))))

(defn get-color
  "Gets the current color value from the color chooser.
   By default, this delegates to the model.

  returns: the current color value of the color chooser - `java.awt.Color`"
  ([^javax.swing.JColorChooser this]
    (-> this (.getColor))))

(defn update-ui
  "Notification from the UIManager that the L&F has changed.
   Replaces the current UI object with the latest version from the
   UIManager."
  ([^javax.swing.JColorChooser this]
    (-> this (.updateUI))))

