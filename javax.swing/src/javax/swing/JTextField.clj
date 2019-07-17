(ns javax.swing.JTextField
  "JTextField is a lightweight component that allows the editing
  of a single line of text.
  For information on and examples of using text fields,
  see
  How to Use Text Fields
  in The Java Tutorial.


  JTextField is intended to be source-compatible
  with java.awt.TextField where it is reasonable to do so.  This
  component has capabilities not found in the java.awt.TextField
  class.  The superclass should be consulted for additional capabilities.

  JTextField has a method to establish the string used as the
  command string for the action event that gets fired.  The
  java.awt.TextField used the text of the field as the command
  string for the ActionEvent.
  JTextField will use the command
  string set with the setActionCommand method if not null,
  otherwise it will use the text of the field as a compatibility with
  java.awt.TextField.

  The method setEchoChar and getEchoChar
  are not provided directly to avoid a new implementation of a
  pluggable look-and-feel inadvertently exposing password characters.
  To provide password-like services a separate class JPasswordField
  extends JTextField to provide this service with an independently
  pluggable look-and-feel.

  The java.awt.TextField could be monitored for changes by adding
  a TextListener for TextEvent's.
  In the JTextComponent based
  components, changes are broadcasted from the model via a
  DocumentEvent to DocumentListeners.
  The DocumentEvent gives
  the location of the change and the kind of change if desired.
  The code fragment might look something like:


      DocumentListener myListener = ??;
      JTextField myArea = ??;
      myArea.getDocument().addDocumentListener(myListener);

  The horizontal alignment of JTextField can be set to be left
  justified, leading justified, centered, right justified or trailing justified.
  Right/trailing justification is useful if the required size
  of the field text is smaller than the size allocated to it.
  This is determined by the setHorizontalAlignment
  and getHorizontalAlignment methods.  The default
  is to be leading justified.

  How the text field consumes VK_ENTER events depends
  on whether the text field has any action listeners.
  If so, then VK_ENTER results in the listeners
  getting an ActionEvent,
  and the VK_ENTER event is consumed.
  This is compatible with how AWT text fields handle VK_ENTER events.
  If the text field has no action listeners, then as of v 1.3 the VK_ENTER
  event is not consumed.  Instead, the bindings of ancestor components
  are processed, which enables the default button feature of
  JFC/Swing to work.

  Customized fields can easily be created by extending the model and
  changing the default model provided.  For example, the following piece
  of code will create a field that holds only upper case characters.  It
  will work even if text is pasted into from the clipboard or it is altered via
  programmatic changes.


  public class UpperCaseField extends JTextField {

      public UpperCaseField(int cols) {
          super(cols);
      }

      protected Document createDefaultModel() {
          return new UpperCaseDocument();
      }

      static class UpperCaseDocument extends PlainDocument {

          public void insertString(int offs, String str, AttributeSet a)
              throws BadLocationException {

              if (str == null) {
                  return;
              }
              char[] upper = str.toCharArray();
              for (int i = 0; i < upper.length; i++) {
                  upper[i] = Character.toUpperCase(upper[i]);
              }
              super.insertString(offs, new String(upper), a);
          }
      }
  }

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
  (:import [javax.swing JTextField]))

(defn ->j-text-field
  "Constructor.

  Constructs a new JTextField that uses the given text
   storage model and the given number of columns.
   This is the constructor through which the other constructors feed.
   If the document is null, a default model is created.

  doc - the text storage to use; if this is null, a default will be provided by calling the createDefaultModel method - `javax.swing.text.Document`
  text - the initial string to display, or null - `java.lang.String`
  columns - the number of columns to use to calculate the preferred width >= 0; if columns is set to zero, the preferred width will be whatever naturally results from the component implementation - `int`

  throws: java.lang.IllegalArgumentException - if columns < 0"
  ([doc text columns]
    (new JTextField doc text columns))
  ([text columns]
    (new JTextField text columns))
  ([text]
    (new JTextField text))
  ([]
    (new JTextField )))

(def *-notify-action
  "Static Constant.

  Name of the action to send notification that the
   contents of the field have been accepted.  Typically
   this is bound to a carriage-return.

  type: java.lang.String"
  JTextField/notifyAction)

(defn get-scroll-offset
  "Gets the scroll offset, in pixels.

  returns: the offset >= 0 - `int`"
  ([this]
    (-> this (.getScrollOffset))))

(defn set-columns
  "Sets the number of columns in this TextField,
   and then invalidate the layout.

  columns - the number of columns >= 0 - `int`

  throws: java.lang.IllegalArgumentException - if columns is less than 0"
  ([this columns]
    (-> this (.setColumns columns))))

(defn post-action-event
  "Processes action events occurring on this textfield by
   dispatching them to any registered ActionListener objects.
   This is normally called by the controller registered with
   textfield."
  ([this]
    (-> this (.postActionEvent))))

(defn set-document
  "Associates the editor with a text document.
   The currently registered factory is used to build a view for
   the document, which gets displayed by the editor after revalidation.
   A PropertyChange event (`document`) is propagated to each listener.

  doc - the document to display/edit - `javax.swing.text.Document`"
  ([this doc]
    (-> this (.setDocument doc))))

(defn scroll-rect-to-visible
  "Scrolls the field left or right.

  r - the region to scroll - `java.awt.Rectangle`"
  ([this r]
    (-> this (.scrollRectToVisible r))))

(defn get-columns
  "Returns the number of columns in this TextField.

  returns: the number of columns >= 0 - `int`"
  ([this]
    (-> this (.getColumns))))

(defn get-action
  "Returns the currently set Action for this
   ActionEvent source, or null
   if no Action is set.

  returns: the Action for this ActionEvent source,
            or null - `javax.swing.Action`"
  ([this]
    (-> this (.getAction))))

(defn add-action-listener
  "Adds the specified action listener to receive
   action events from this textfield.

  l - the action listener to be added - `java.awt.event.ActionListener`"
  ([this l]
    (-> this (.addActionListener l))))

(defn get-actions
  "Fetches the command list for the editor.  This is
   the list of commands supported by the plugged-in UI
   augmented by the collection of commands that the
   editor itself supports.  These are useful for binding
   to events, such as in a keymap.

  returns: the command list - `javax.swing.Action[]`"
  ([this]
    (-> this (.getActions))))

(defn get-ui-class-id
  "Gets the class ID for a UI.

  returns: the string `TextFieldUI` - `java.lang.String`"
  ([this]
    (-> this (.getUIClassID))))

(defn get-horizontal-visibility
  "Gets the visibility of the text field.  This can
   be adjusted to change the location of the visible
   area if the size of the field is greater than
   the area that was allocated to the field.


   The fields look-and-feel implementation manages
   the values of the minimum, maximum, and extent
   properties on the BoundedRangeModel.

  returns: the visibility - `javax.swing.BoundedRangeModel`"
  ([this]
    (-> this (.getHorizontalVisibility))))

(defn validate-root?
  "Calls to revalidate that come from within the
   textfield itself will
   be handled by validating the textfield, unless the textfield
   is contained within a JViewport,
   in which case this returns false.

  returns: if the parent of this textfield is a JViewPort
            return false, otherwise return true - `boolean`"
  ([this]
    (-> this (.isValidateRoot))))

(defn set-scroll-offset
  "Sets the scroll offset, in pixels.

  scroll-offset - the offset >= 0 - `int`"
  ([this scroll-offset]
    (-> this (.setScrollOffset scroll-offset))))

(defn get-action-listeners
  "Returns an array of all the ActionListeners added
   to this JTextField with addActionListener().

  returns: all of the ActionListeners added or an empty
           array if no listeners have been added - `java.awt.event.ActionListener[]`"
  ([this]
    (-> this (.getActionListeners))))

(defn set-font
  "Sets the current font.  This removes cached row height and column
   width so the new font will be reflected.
   revalidate is called after setting the font.

  f - the new font - `java.awt.Font`"
  ([this f]
    (-> this (.setFont f))))

(defn get-accessible-context
  "Gets the AccessibleContext associated with this
   JTextField. For JTextFields,
   the AccessibleContext takes the form of an
   AccessibleJTextField.
   A new AccessibleJTextField instance is created
   if necessary.

  returns: an AccessibleJTextField that serves as the
           AccessibleContext of this JTextField - `javax.accessibility.AccessibleContext`"
  ([this]
    (-> this (.getAccessibleContext))))

(defn get-horizontal-alignment
  "Returns the horizontal alignment of the text.
   Valid keys are:

   JTextField.LEFT
   JTextField.CENTER
   JTextField.RIGHT
   JTextField.LEADING
   JTextField.TRAILING

  returns: the horizontal alignment - `int`"
  ([this]
    (-> this (.getHorizontalAlignment))))

(defn remove-action-listener
  "Removes the specified action listener so that it no longer
   receives action events from this textfield.

  l - the action listener to be removed - `java.awt.event.ActionListener`"
  ([this l]
    (-> this (.removeActionListener l))))

(defn set-action
  "Sets the Action for the ActionEvent source.
   The new Action replaces
   any previously set Action but does not affect
   ActionListeners independently
   added with addActionListener.
   If the Action is already a registered
   ActionListener
   for the ActionEvent source, it is not re-registered.

   Setting the Action results in immediately changing
   all the properties described in
   Swing Components Supporting Action.
   Subsequently, the textfield's properties are automatically updated
   as the Action's properties change.

   This method uses three other methods to set
   and help track the Action's property values.
   It uses the configurePropertiesFromAction method
   to immediately change the textfield's properties.
   To track changes in the Action's property values,
   this method registers the PropertyChangeListener
   returned by createActionPropertyChangeListener. The
   default PropertyChangeListener invokes the
   actionPropertyChanged method when a property in the
   Action changes.

  a - the Action for the JTextField, or null - `javax.swing.Action`"
  ([this a]
    (-> this (.setAction a))))

(defn set-horizontal-alignment
  "Sets the horizontal alignment of the text.
   Valid keys are:

   JTextField.LEFT
   JTextField.CENTER
   JTextField.RIGHT
   JTextField.LEADING
   JTextField.TRAILING

   invalidate and repaint are called when the
   alignment is set,
   and a PropertyChange event (`horizontalAlignment`) is fired.

  alignment - the alignment - `int`

  throws: java.lang.IllegalArgumentException - if alignment is not a valid key"
  ([this alignment]
    (-> this (.setHorizontalAlignment alignment))))

(defn set-action-command
  "Sets the command string used for action events.

  command - the command string - `java.lang.String`"
  ([this command]
    (-> this (.setActionCommand command))))

(defn get-preferred-size
  "Returns the preferred size Dimensions needed for this
   TextField.  If a non-zero number of columns has been
   set, the width is set to the columns multiplied by
   the column width.

  returns: the dimension of this textfield - `java.awt.Dimension`"
  ([this]
    (-> this (.getPreferredSize))))

