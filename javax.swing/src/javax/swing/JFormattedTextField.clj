(ns javax.swing.JFormattedTextField
  "JFormattedTextField extends JTextField adding
  support for formatting arbitrary values, as well as retrieving a particular
  object once the user has edited the text. The following illustrates
  configuring a JFormattedTextField to edit dates:


    JFormattedTextField ftf = new JFormattedTextField();
    ftf.setValue(new Date());

  Once a JFormattedTextField has been created, you can
  listen for editing changes by way of adding
  a PropertyChangeListener and listening for
  PropertyChangeEvents with the property name value.

  JFormattedTextField allows
  configuring what action should be taken when focus is lost. The possible
  configurations are:

  ValueDescription
  JFormattedTextField.REVERT
             Revert the display to match that of getValue,
                 possibly losing the current edit.
         JFormattedTextField.COMMIT
             Commits the current value. If the value being edited
                 isn't considered a legal value by the
                 AbstractFormatter that is, a
                 ParseException is thrown, then the value
                 will not change, and then edited value will persist.
         JFormattedTextField.COMMIT_OR_REVERT
             Similar to COMMIT, but if the value isn't
                 legal, behave like REVERT.
         JFormattedTextField.PERSIST
             Do nothing, don't obtain a new
                 AbstractFormatter, and don't update the value.

  The default is JFormattedTextField.COMMIT_OR_REVERT,
  refer to setFocusLostBehavior(int) for more information on this.

  JFormattedTextField allows the focus to leave, even if
  the currently edited value is invalid. To lock the focus down while the
  JFormattedTextField is an invalid edit state
  you can attach an InputVerifier. The following code snippet
  shows a potential implementation of such an InputVerifier:


  public class FormattedTextFieldVerifier extends InputVerifier {
      public boolean verify(JComponent input) {
          if (input instanceof JFormattedTextField) {
              JFormattedTextField ftf = (JFormattedTextField)input;
              AbstractFormatter formatter = ftf.getFormatter();
              if (formatter != null) {
                  String text = ftf.getText();
                  try {
                       formatter.stringToValue(text);
                       return true;
                   } catch (ParseException pe) {
                       return false;
                   }
               }
           }
           return true;
       }
       public boolean shouldYieldFocus(JComponent input) {
           return verify(input);
       }
   }

  Alternatively, you could invoke commitEdit, which would also
  commit the value.

  JFormattedTextField does not do the formatting it self,
  rather formatting is done through an instance of
  JFormattedTextField.AbstractFormatter which is obtained from
  an instance of JFormattedTextField.AbstractFormatterFactory.
  Instances of JFormattedTextField.AbstractFormatter are
  notified when they become active by way of the
  install method, at which point the
  JFormattedTextField.AbstractFormatter can install whatever
  it needs to, typically a DocumentFilter. Similarly when
  JFormattedTextField no longer
  needs the AbstractFormatter, it will invoke
  uninstall.

  JFormattedTextField typically
  queries the AbstractFormatterFactory for an
  AbstractFormat when it gains or loses focus. Although this
  can change based on the focus lost policy. If the focus lost
  policy is JFormattedTextField.PERSIST
  and the JFormattedTextField has been edited, the
  AbstractFormatterFactory will not be queried until the
  value has been committed. Similarly if the focus lost policy is
  JFormattedTextField.COMMIT and an exception
  is thrown from stringToValue, the
  AbstractFormatterFactory will not be queried when focus is
  lost or gained.

  JFormattedTextField.AbstractFormatter
  is also responsible for determining when values are committed to
  the JFormattedTextField. Some
  JFormattedTextField.AbstractFormatters will make new values
  available on every edit, and others will never commit the value. You can
  force the current value to be obtained
  from the current JFormattedTextField.AbstractFormatter
  by way of invoking commitEdit. commitEdit will
  be invoked whenever return is pressed in the
  JFormattedTextField.

  If an AbstractFormatterFactory has not been explicitly
  set, one will be set based on the Class of the value type after
  setValue has been invoked (assuming value is non-null).
  For example, in the following code an appropriate
  AbstractFormatterFactory and AbstractFormatter
  will be created to handle formatting of numbers:


    JFormattedTextField tf = new JFormattedTextField();
    tf.setValue(100);

  Warning: As the AbstractFormatter will
  typically install a DocumentFilter on the
  Document, and a NavigationFilter on the
  JFormattedTextField you should not install your own. If you do,
  you are likely to see odd behavior in that the editing policy of the
  AbstractFormatter will not be enforced.

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
  (:import [javax.swing JFormattedTextField]))

(defn ->j-formatted-text-field
  "Constructor.

  Creates a JFormattedTextField with the specified
   AbstractFormatterFactory and initial value.

  factory - AbstractFormatterFactory used for formatting. - `javax.swing.JFormattedTextField.AbstractFormatterFactory`
  current-value - Initial value to use - `java.lang.Object`"
  ([factory current-value]
    (new JFormattedTextField factory current-value))
  ([value]
    (new JFormattedTextField value))
  ([]
    (new JFormattedTextField )))

(def *-commit
  "Static Constant.

  Constant identifying that when focus is lost,
   commitEdit should be invoked. If in committing the
   new value a ParseException is thrown, the invalid
   value will remain.

  type: int"
  JFormattedTextField/COMMIT)

(def *-commit-or-revert
  "Static Constant.

  Constant identifying that when focus is lost,
   commitEdit should be invoked. If in committing the new
   value a ParseException is thrown, the value will be
   reverted.

  type: int"
  JFormattedTextField/COMMIT_OR_REVERT)

(def *-revert
  "Static Constant.

  Constant identifying that when focus is lost, editing value should
   be reverted to current value set on the
   JFormattedTextField.

  type: int"
  JFormattedTextField/REVERT)

(def *-persist
  "Static Constant.

  Constant identifying that when focus is lost, the edited value
   should be left.

  type: int"
  JFormattedTextField/PERSIST)

(defn edit-valid?
  "Returns true if the current value being edited is valid. The value of
   this is managed by the current AbstractFormatter, as such
   there is no public setter for it.

  returns: true if the current value being edited is valid. - `boolean`"
  ([this]
    (-> this (.isEditValid))))

(defn get-focus-lost-behavior
  "Returns the behavior when focus is lost. This will be one of
   COMMIT_OR_REVERT,
   COMMIT,
   REVERT or
   PERSIST
   Note that some AbstractFormatters may push changes as
   they occur, so that the value of this will have no effect.

  returns: returns behavior when focus is lost - `int`"
  ([this]
    (-> this (.getFocusLostBehavior))))

(defn set-focus-lost-behavior
  "Sets the behavior when focus is lost. This will be one of
   JFormattedTextField.COMMIT_OR_REVERT,
   JFormattedTextField.REVERT,
   JFormattedTextField.COMMIT or
   JFormattedTextField.PERSIST
   Note that some AbstractFormatters may push changes as
   they occur, so that the value of this will have no effect.

   This will throw an IllegalArgumentException if the object
   passed in is not one of the afore mentioned values.

   The default value of this property is
   JFormattedTextField.COMMIT_OR_REVERT.

  behavior - Identifies behavior when focus is lost - `int`

  throws: java.lang.IllegalArgumentException - if behavior is not one of the known values"
  ([this behavior]
    (-> this (.setFocusLostBehavior behavior))))

(defn set-document
  "Associates the editor with a text document.
   The currently registered factory is used to build a view for
   the document, which gets displayed by the editor after revalidation.
   A PropertyChange event (`document`) is propagated to each listener.

  doc - the document to display/edit - `javax.swing.text.Document`"
  ([this doc]
    (-> this (.setDocument doc))))

(defn commit-edit
  "Forces the current value to be taken from the
   AbstractFormatter and set as the current value.
   This has no effect if there is no current
   AbstractFormatter installed.

  throws: java.text.ParseException - if the AbstractFormatter is not able to format the current value"
  ([this]
    (-> this (.commitEdit))))

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

  returns: the string `FormattedTextFieldUI` - `java.lang.String`"
  ([this]
    (-> this (.getUIClassID))))

(defn get-value
  "Returns the last valid value. Based on the editing policy of
   the AbstractFormatter this may not return the current
   value. The currently edited value can be obtained by invoking
   commitEdit followed by getValue.

  returns: Last valid value - `java.lang.Object`"
  ([this]
    (-> this (.getValue))))

(defn get-formatter
  "Returns the AbstractFormatter that is used to format and
   parse the current value.

  returns: AbstractFormatter used for formatting - `javax.swing.JFormattedTextField.AbstractFormatter`"
  ([this]
    (-> this (.getFormatter))))

(defn get-formatter-factory
  "Returns the current AbstractFormatterFactory.

  returns: AbstractFormatterFactory used to determine
           AbstractFormatters - `javax.swing.JFormattedTextField.AbstractFormatterFactory`"
  ([this]
    (-> this (.getFormatterFactory))))

(defn set-formatter-factory
  "Sets the AbstractFormatterFactory.
   AbstractFormatterFactory is
   able to return an instance of AbstractFormatter that is
   used to format a value for display, as well an enforcing an editing
   policy.

   If you have not explicitly set an AbstractFormatterFactory
   by way of this method (or a constructor) an
   AbstractFormatterFactory and consequently an
   AbstractFormatter will be used based on the
   Class of the value. NumberFormatter will
   be used for Numbers, DateFormatter will
   be used for Dates, otherwise DefaultFormatter
   will be used.

   This is a JavaBeans bound property.

  tf - AbstractFormatterFactory used to lookup instances of AbstractFormatter - `javax.swing.JFormattedTextField.AbstractFormatterFactory`"
  ([this tf]
    (-> this (.setFormatterFactory tf))))

(defn set-value
  "Sets the value that will be formatted by an
   AbstractFormatter obtained from the current
   AbstractFormatterFactory. If no
   AbstractFormatterFactory has been specified, this will
   attempt to create one based on the type of value.

   The default value of this property is null.

   This is a JavaBeans bound property.

  value - Current value to display - `java.lang.Object`"
  ([this value]
    (-> this (.setValue value))))

