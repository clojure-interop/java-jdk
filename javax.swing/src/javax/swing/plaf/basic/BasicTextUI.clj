(ns javax.swing.plaf.basic.BasicTextUI
  " Basis of a text components look-and-feel.  This provides the
  basic editor view and controller services that may be useful
  when creating a look-and-feel for an extension of
  JTextComponent.

  Most state is held in the associated JTextComponent
  as bound properties, and the UI installs default values for the
  various properties.  This default will install something for
  all of the properties.  Typically, a LAF implementation will
  do more however.  At a minimum, a LAF would generally install
  key bindings.

  This class also provides some concurrency support if the
  Document associated with the JTextComponent is a subclass of
  AbstractDocument.  Access to the View (or View hierarchy) is
  serialized between any thread mutating the model and the Swing
  event thread (which is expected to render, do model/view coordinate
  translation, etc).  Any access to the root view should first
  acquire a read-lock on the AbstractDocument and release that lock
  in a finally block.

  An important method to define is the getPropertyPrefix() method
  which is used as the basis of the keys used to fetch defaults
  from the UIManager.  The string should reflect the type of
  TextUI (eg. TextField, TextArea, etc) without the particular
  LAF part of the name (eg Metal, Motif, etc).

  To build a view of the model, one of the following strategies
  can be employed.


  One strategy is to simply redefine the
  ViewFactory interface in the UI.  By default, this UI itself acts
  as the factory for View implementations.  This is useful
  for simple factories.  To do this reimplement the
  create(javax.swing.text.Element) method.

  A common strategy for creating more complex types of documents
  is to have the EditorKit implementation return a factory.  Since
  the EditorKit ties all of the pieces necessary to maintain a type
  of document, the factory is typically an important part of that
  and should be produced by the EditorKit implementation.


  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.basic BasicTextUI]))

(defn ->basic-text-ui
  "Constructor.

  Creates a new UI."
  ([]
    (new BasicTextUI )))

(defn install-ui
  "Installs the UI for a component.  This does the following
   things.


   Sets the associated component to opaque if the opaque property
   has not already been set by the client program. This will cause the
   component's background color to be painted.

   Installs the default caret and highlighter into the
   associated component. These properties are only set if their
   current value is either null or an instance of
   UIResource.

   Attaches to the editor and model.  If there is no
   model, a default one is created.

   Creates the view factory and the view hierarchy used
   to represent the model.

  c - the editor component - `javax.swing.JComponent`"
  ([^javax.swing.plaf.basic.BasicTextUI this ^javax.swing.JComponent c]
    (-> this (.installUI c))))

(defn get-minimum-size
  "Gets the minimum size for the editor component.

  c - the editor component - `javax.swing.JComponent`

  returns: the size - `java.awt.Dimension`"
  ([^javax.swing.plaf.basic.BasicTextUI this ^javax.swing.JComponent c]
    (-> this (.getMinimumSize c))))

(defn get-maximum-size
  "Gets the maximum size for the editor component.

  c - the editor component - `javax.swing.JComponent`

  returns: the size - `java.awt.Dimension`"
  ([^javax.swing.plaf.basic.BasicTextUI this ^javax.swing.JComponent c]
    (-> this (.getMaximumSize c))))

(defn uninstall-ui
  "Deinstalls the UI for a component.  This removes the listeners,
   uninstalls the highlighter, removes views, and nulls out the keymap.

  c - the editor component - `javax.swing.JComponent`"
  ([^javax.swing.plaf.basic.BasicTextUI this ^javax.swing.JComponent c]
    (-> this (.uninstallUI c))))

(defn update
  "Superclass paints background in an uncontrollable way
   (i.e. one might want an image tiled into the background).
   To prevent this from happening twice, this method is
   reimplemented to simply paint.

   NOTE: NOTE: Superclass is also not thread-safe in its
   rendering of the background, although that is not an issue with the
   default rendering.

  g - the Graphics context in which to paint - `java.awt.Graphics`
  c - the component being painted; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`"
  ([^javax.swing.plaf.basic.BasicTextUI this ^java.awt.Graphics g ^javax.swing.JComponent c]
    (-> this (.update g c))))

(defn get-tool-tip-text
  "Returns the string to be used as the tooltip at the passed in location.
   This forwards the method onto the root View.

  t - `javax.swing.text.JTextComponent`
  pt - `java.awt.Point`

  returns: `java.lang.String`"
  ([^javax.swing.plaf.basic.BasicTextUI this ^javax.swing.text.JTextComponent t ^java.awt.Point pt]
    (-> this (.getToolTipText t pt))))

(defn paint
  "Paints the interface.  This is routed to the
   paintSafely method under the guarantee that
   the model won't change from the view of this thread
   while it's rendering (if the associated model is
   derived from AbstractDocument).  This enables the
   model to potentially be updated asynchronously.

  g - the graphics context - `java.awt.Graphics`
  c - the editor component - `javax.swing.JComponent`"
  ([^javax.swing.plaf.basic.BasicTextUI this ^java.awt.Graphics g ^javax.swing.JComponent c]
    (-> this (.paint g c))))

(defn damage-range
  "Causes the portion of the view responsible for the
   given part of the model to be repainted.

  t - `javax.swing.text.JTextComponent`
  p-0 - the beginning of the range >= 0 - `int`
  p-1 - the end of the range >= p0 - `int`
  p-0-bias - `javax.swing.text.Position.Bias`
  p-1-bias - `javax.swing.text.Position.Bias`"
  ([^javax.swing.plaf.basic.BasicTextUI this ^javax.swing.text.JTextComponent t ^Integer p-0 ^Integer p-1 ^javax.swing.text.Position.Bias p-0-bias ^javax.swing.text.Position.Bias p-1-bias]
    (-> this (.damageRange t p-0 p-1 p-0-bias p-1-bias)))
  ([^javax.swing.plaf.basic.BasicTextUI this ^javax.swing.text.JTextComponent tc ^Integer p-0 ^Integer p-1]
    (-> this (.damageRange tc p-0 p-1))))

(defn view-to-model
  "Converts the given place in the view coordinate system
   to the nearest representative location in the model.
   The component must have a non-zero positive size for
   this translation to be computed.

  tc - the text component for which this UI is installed - `javax.swing.text.JTextComponent`
  pt - the location in the view to translate. This should be in the same coordinate system as the mouse events. - `java.awt.Point`
  bias-return - filled in by this method to indicate whether the point given is closer to the previous or the next character in the model - `javax.swing.text.Position.Bias[]`

  returns: the offset from the start of the document >= 0,
     -1 if the component doesn't yet have a positive size. - `int`"
  ([^javax.swing.plaf.basic.BasicTextUI this ^javax.swing.text.JTextComponent tc ^java.awt.Point pt ^javax.swing.text.Position.Bias[] bias-return]
    (-> this (.viewToModel tc pt bias-return)))
  ([^javax.swing.plaf.basic.BasicTextUI this ^javax.swing.text.JTextComponent tc ^java.awt.Point pt]
    (-> this (.viewToModel tc pt))))

(defn create
  "Creates a view for an element.
   If a subclass wishes to directly implement the factory
   producing the view(s), it should reimplement this
   method.  By default it simply returns null indicating
   it is unable to represent the part of the element.

  elem - the element - `javax.swing.text.Element`
  p-0 - the starting offset >= 0 - `int`
  p-1 - the ending offset >= p0 - `int`

  returns: the view - `javax.swing.text.View`"
  ([^javax.swing.plaf.basic.BasicTextUI this ^javax.swing.text.Element elem ^Integer p-0 ^Integer p-1]
    (-> this (.create elem p-0 p-1)))
  ([^javax.swing.plaf.basic.BasicTextUI this ^javax.swing.text.Element elem]
    (-> this (.create elem))))

(defn get-editor-kit
  "Fetches the EditorKit for the UI.

  tc - the text component for which this UI is installed - `javax.swing.text.JTextComponent`

  returns: the editor capabilities - `javax.swing.text.EditorKit`"
  ([^javax.swing.plaf.basic.BasicTextUI this ^javax.swing.text.JTextComponent tc]
    (-> this (.getEditorKit tc))))

(defn model-to-view
  "Converts the given location in the model to a place in
   the view coordinate system.
   The component must have a non-zero positive size for
   this translation to be computed.

  tc - the text component for which this UI is installed - `javax.swing.text.JTextComponent`
  pos - the local location in the model to translate >= 0 - `int`
  bias - `javax.swing.text.Position.Bias`

  returns: the coordinates as a rectangle, null if the model is not painted - `java.awt.Rectangle`

  throws: javax.swing.text.BadLocationException - if the given position does not represent a valid location in the associated document"
  ([^javax.swing.plaf.basic.BasicTextUI this ^javax.swing.text.JTextComponent tc ^Integer pos ^javax.swing.text.Position.Bias bias]
    (-> this (.modelToView tc pos bias)))
  ([^javax.swing.plaf.basic.BasicTextUI this ^javax.swing.text.JTextComponent tc ^Integer pos]
    (-> this (.modelToView tc pos))))

(defn get-preferred-size
  "Gets the preferred size for the editor component.  If the component
   has been given a size prior to receiving this request, it will
   set the size of the view hierarchy to reflect the size of the component
   before requesting the preferred size of the view hierarchy.  This
   allows formatted views to format to the current component size before
   answering the request.  Other views don't care about currently formatted
   size and give the same answer either way.

  c - the editor component - `javax.swing.JComponent`

  returns: the size - `java.awt.Dimension`"
  ([^javax.swing.plaf.basic.BasicTextUI this ^javax.swing.JComponent c]
    (-> this (.getPreferredSize c))))

(defn get-root-view
  "Fetches a View with the allocation of the associated
   text component (i.e. the root of the hierarchy) that
   can be traversed to determine how the model is being
   represented spatially.

   NOTE:The View hierarchy can
   be traversed from the root view, and other things
   can be done as well.  Things done in this way cannot
   be protected like simple method calls through the TextUI.
   Therefore, proper operation in the presence of concurrency
   must be arranged by any logic that calls this method!

  tc - the text component for which this UI is installed - `javax.swing.text.JTextComponent`

  returns: the view - `javax.swing.text.View`"
  ([^javax.swing.plaf.basic.BasicTextUI this ^javax.swing.text.JTextComponent tc]
    (-> this (.getRootView tc))))

(defn get-next-visual-position-from
  "Provides a way to determine the next visually represented model
   location that one might place a caret.  Some views may not be visible,
   they might not be in the same order found in the model, or they just
   might not allow access to some of the locations in the model.

  t - the text component for which this UI is installed - `javax.swing.text.JTextComponent`
  pos - the position to convert >= 0 - `int`
  b - the bias for the position - `javax.swing.text.Position.Bias`
  direction - the direction from the current position that can be thought of as the arrow keys typically found on a keyboard. This may be SwingConstants.WEST, SwingConstants.EAST, SwingConstants.NORTH, or SwingConstants.SOUTH - `int`
  bias-ret - an array to contain the bias for the returned position - `javax.swing.text.Position.Bias[]`

  returns: the location within the model that best represents the next
    location visual position - `int`

  throws: javax.swing.text.BadLocationException"
  ([^javax.swing.plaf.basic.BasicTextUI this ^javax.swing.text.JTextComponent t ^Integer pos ^javax.swing.text.Position.Bias b ^Integer direction ^javax.swing.text.Position.Bias[] bias-ret]
    (-> this (.getNextVisualPositionFrom t pos b direction bias-ret))))

