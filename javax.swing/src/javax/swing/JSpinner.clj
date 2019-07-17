(ns javax.swing.JSpinner
  "A single line input field that lets the user select a
  number or an object value from an ordered sequence. Spinners typically
  provide a pair of tiny arrow buttons for stepping through the elements
  of the sequence. The keyboard up/down arrow keys also cycle through the
  elements. The user may also be allowed to type a (legal) value directly
  into the spinner. Although combo boxes provide similar functionality,
  spinners are sometimes preferred because they don't require a drop down list
  that can obscure important data.

  A JSpinner's sequence value is defined by its
  SpinnerModel.
  The model can be specified as a constructor argument and
  changed with the model property.  SpinnerModel
  classes for some common types are provided: SpinnerListModel,
  SpinnerNumberModel, and SpinnerDateModel.

  A JSpinner has a single child component that's
  responsible for displaying
  and potentially changing the current element or value of
  the model, which is called the editor.  The editor is created
  by the JSpinner's constructor and can be changed with the
  editor property.  The JSpinner's editor stays
  in sync with the model by listening for ChangeEvents. If the
  user has changed the value displayed by the editor it is
  possible for the model's value to differ from that of
  the editor. To make sure the model has the same
  value as the editor use the commitEdit method, eg:


    try {
        spinner.commitEdit();
    }
    catch (ParseException pe) {
        // Edited value is invalid, spinner.getValue() will return
        // the last valid value, you could revert the spinner to show that:
        JComponent editor = spinner.getEditor();
        if (editor instanceof DefaultEditor) {
            ((DefaultEditor)editor).getTextField().setValue(spinner.getValue());
        }
        // reset the value to some known value:
        spinner.setValue(fallbackValue);
        // or treat the last valid value as the current, in which
        // case you don't need to do anything.
    }
    return spinner.getValue();

  For information and examples of using spinner see
  How to Use Spinners,
  a section in The Java Tutorial.

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
  (:import [javax.swing JSpinner]))

(defn ->j-spinner
  "Constructor.

  Constructs a spinner for the given model. The spinner has
   a set of previous/next buttons, and an editor appropriate
   for the model.

  model - `javax.swing.SpinnerModel`

  throws: java.lang.NullPointerException - if the model is null"
  ([^javax.swing.SpinnerModel model]
    (new JSpinner model))
  ([]
    (new JSpinner )))

(defn add-change-listener
  "Adds a listener to the list that is notified each time a change
   to the model occurs.  The source of ChangeEvents
   delivered to ChangeListeners will be this
   JSpinner.  Note also that replacing the model
   will not affect listeners added directly to JSpinner.
   Applications can add listeners to  the model directly.  In that
   case is that the source of the event would be the
   SpinnerModel.

  listener - the ChangeListener to add - `javax.swing.event.ChangeListener`"
  ([^javax.swing.JSpinner this ^javax.swing.event.ChangeListener listener]
    (-> this (.addChangeListener listener))))

(defn get-previous-value
  "Returns the object in the sequence that comes
   before the object returned by getValue().
   If the end of the sequence has been reached then
   return null. Calling this method does
   not effect value.

   This method simply delegates to the model.
   It is equivalent to:


   getModel().getPreviousValue()

  returns: the previous legal value or null
     if one doesn't exist - `java.lang.Object`"
  (^java.lang.Object [^javax.swing.JSpinner this]
    (-> this (.getPreviousValue))))

(defn get-editor
  "Returns the component that displays and potentially
   changes the model's value.

  returns: the component that displays and potentially
      changes the model's value - `javax.swing.JComponent`"
  (^javax.swing.JComponent [^javax.swing.JSpinner this]
    (-> this (.getEditor))))

(defn commit-edit
  "Commits the currently edited value to the SpinnerModel.

   If the editor is an instance of DefaultEditor, the
   call if forwarded to the editor, otherwise this does nothing.

  throws: java.text.ParseException - if the currently edited value couldn't be committed."
  ([^javax.swing.JSpinner this]
    (-> this (.commitEdit))))

(defn get-ui-class-id
  "Returns the suffix used to construct the name of the look and feel
   (L&F) class used to render this component.

  returns: the string `SpinnerUI` - `java.lang.String`"
  (^java.lang.String [^javax.swing.JSpinner this]
    (-> this (.getUIClassID))))

(defn get-value
  "Returns the current value of the model, typically
   this value is displayed by the editor. If the
   user has changed the value displayed by the editor it is
   possible for the model's value to differ from that of
   the editor, refer to the class level javadoc for examples
   of how to deal with this.

   This method simply delegates to the model.
   It is equivalent to:


   getModel().getValue()

  returns: `java.lang.Object`"
  (^java.lang.Object [^javax.swing.JSpinner this]
    (-> this (.getValue))))

(defn remove-change-listener
  "Removes a ChangeListener from this spinner.

  listener - the ChangeListener to remove - `javax.swing.event.ChangeListener`"
  ([^javax.swing.JSpinner this ^javax.swing.event.ChangeListener listener]
    (-> this (.removeChangeListener listener))))

(defn get-change-listeners
  "Returns an array of all the ChangeListeners added
   to this JSpinner with addChangeListener().

  returns: all of the ChangeListeners added or an empty
           array if no listeners have been added - `javax.swing.event.ChangeListener[]`"
  ([^javax.swing.JSpinner this]
    (-> this (.getChangeListeners))))

(defn set-ui
  "Sets the look and feel (L&F) object that renders this component.

  ui - the SpinnerUI L&F object - `javax.swing.plaf.SpinnerUI`"
  ([^javax.swing.JSpinner this ^javax.swing.plaf.SpinnerUI ui]
    (-> this (.setUI ui))))

(defn get-ui
  "Returns the look and feel (L&F) object that renders this component.

  returns: the SpinnerUI object that renders this component - `javax.swing.plaf.SpinnerUI`"
  (^javax.swing.plaf.SpinnerUI [^javax.swing.JSpinner this]
    (-> this (.getUI))))

(defn get-accessible-context
  "Gets the AccessibleContext for the JSpinner

  returns: the AccessibleContext for the JSpinner - `javax.accessibility.AccessibleContext`"
  (^javax.accessibility.AccessibleContext [^javax.swing.JSpinner this]
    (-> this (.getAccessibleContext))))

(defn set-value
  "Changes current value of the model, typically
   this value is displayed by the editor.
   If the SpinnerModel implementation
   doesn't support the specified value then an
   IllegalArgumentException is thrown.

   This method simply delegates to the model.
   It is equivalent to:


   getModel().setValue(value)

  value - `java.lang.Object`

  throws: java.lang.IllegalArgumentException - if value isn't allowed"
  ([^javax.swing.JSpinner this ^java.lang.Object value]
    (-> this (.setValue value))))

(defn get-model
  "Returns the SpinnerModel that defines
   this spinners sequence of values.

  returns: the value of the model property - `javax.swing.SpinnerModel`"
  (^javax.swing.SpinnerModel [^javax.swing.JSpinner this]
    (-> this (.getModel))))

(defn get-next-value
  "Returns the object in the sequence that comes after the object returned
   by getValue(). If the end of the sequence has been reached
   then return null.
   Calling this method does not effect value.

   This method simply delegates to the model.
   It is equivalent to:


   getModel().getNextValue()

  returns: the next legal value or null if one doesn't exist - `java.lang.Object`"
  (^java.lang.Object [^javax.swing.JSpinner this]
    (-> this (.getNextValue))))

(defn set-model
  "Changes the model that represents the value of this spinner.
   If the editor property has not been explicitly set,
   the editor property is (implicitly) set after the `model`
   PropertyChangeEvent has been fired.  The editor
   property is set to the value returned by createEditor,
   as in:


   setEditor(createEditor(model));

  model - the new SpinnerModel - `javax.swing.SpinnerModel`

  throws: java.lang.IllegalArgumentException - if model is null"
  ([^javax.swing.JSpinner this ^javax.swing.SpinnerModel model]
    (-> this (.setModel model))))

(defn update-ui
  "Resets the UI property with the value from the current look and feel."
  ([^javax.swing.JSpinner this]
    (-> this (.updateUI))))

(defn set-editor
  "Changes the JComponent that displays the current value
   of the SpinnerModel.  It is the responsibility of this
   method to disconnect the old editor from the model and to
   connect the new editor.  This may mean removing the
   old editors ChangeListener from the model or the
   spinner itself and adding one for the new editor.

  editor - the new editor - `javax.swing.JComponent`

  throws: java.lang.IllegalArgumentException - if editor is null"
  ([^javax.swing.JSpinner this ^javax.swing.JComponent editor]
    (-> this (.setEditor editor))))

