(ns javax.swing.JOptionPane
  "JOptionPane makes it easy to pop up a standard dialog box that
  prompts users for a value or informs them of something.
  For information about using JOptionPane, see
  How to Make Dialogs,
  a section in The Java Tutorial.



  While the JOptionPane
  class may appear complex because of the large number of methods, almost
  all uses of this class are one-line calls to one of the static
  showXxxDialog methods shown below:





     Method Name
     Description


     showConfirmDialog
     Asks a confirming question, like yes/no/cancel.


     showInputDialog
     Prompt for some input.


    showMessageDialog
    Tell the user about something that has happened.


    showOptionDialog
    The Grand Unification of the above three.




  Each of these methods also comes in a showInternalXXX
  flavor, which uses an internal frame to hold the dialog box (see
  JInternalFrame).
  Multiple convenience methods have also been defined -- overloaded
  versions of the basic methods that use different parameter lists.

  All dialogs are modal. Each showXxxDialog method blocks
  the caller until the user's interaction is complete.



   icon
   message


   input value


    option buttons



  The basic appearance of one of these dialog boxes is generally
  similar to the picture at the right, although the various
  look-and-feels are
  ultimately responsible for the final result.  In particular, the
  look-and-feels will adjust the layout to accommodate the option pane's
  ComponentOrientation property.


  Parameters:
  The parameters to these methods follow consistent patterns:


  parentComponent
  Defines the Component that is to be the parent of this
  dialog box.
  It is used in two ways: the Frame that contains
  it is used as the Frame
  parent for the dialog box, and its screen coordinates are used in
  the placement of the dialog box. In general, the dialog box is placed
  just below the component. This parameter may be null,
  in which case a default Frame is used as the parent,
  and the dialog will be
  centered on the screen (depending on the L&F).
  message
  A descriptive message to be placed in the dialog box.
  In the most common usage, message is just a String or
  String constant.
  However, the type of this parameter is actually Object. Its
  interpretation depends on its type:

  Object[]An array of objects is interpreted as a series of
                  messages (one per object) arranged in a vertical stack.
                  The interpretation is recursive -- each object in the
                  array is interpreted according to its type.
  ComponentThe Component is displayed in the dialog.
  IconThe Icon is wrapped in a JLabel
                and displayed in the dialog.
  othersThe object is converted to a String by calling
                its toString method. The result is wrapped in a
                JLabel and displayed.

  messageTypeDefines the style of the message. The Look and Feel
  manager may lay out the dialog differently depending on this value, and
  will often provide a default icon. The possible values are:

  ERROR_MESSAGE
  INFORMATION_MESSAGE
  WARNING_MESSAGE
  QUESTION_MESSAGE
  PLAIN_MESSAGE

  optionTypeDefines the set of option buttons that appear at
  the bottom of the dialog box:

  DEFAULT_OPTION
  YES_NO_OPTION
  YES_NO_CANCEL_OPTION
  OK_CANCEL_OPTION

  You aren't limited to this set of option buttons.  You can provide any
  buttons you want using the options parameter.
  optionsA more detailed description of the set of option buttons
  that will appear at the bottom of the dialog box.
  The usual value for the options parameter is an array of
  Strings. But
  the parameter type is an array of Objects.
  A button is created for each object depending on its type:

  ComponentThe component is added to the button row directly.
  IconA JButton is created with this as its label.
  otherThe Object is converted to a string using its
               toString method and the result is used to
               label a JButton.

  iconA decorative icon to be placed in the dialog box. A default
  value for this is determined by the messageType parameter.
  titleThe title for the dialog box.
  initialValueThe default selection (input value).



  When the selection is changed, setValue is invoked,
  which generates a PropertyChangeEvent.

  If a JOptionPane has configured to all input
  setWantsInput
  the bound property JOptionPane.INPUT_VALUE_PROPERTY
   can also be listened
  to, to determine when the user has input or selected a value.

  When one of the showXxxDialog methods returns an integer,
  the possible values are:

  YES_OPTION
  NO_OPTION
  CANCEL_OPTION
  OK_OPTION
  CLOSED_OPTION

  Examples:

  Show an error dialog that displays the message, 'alert':

  JOptionPane.showMessageDialog(null, `alert`, `alert`, JOptionPane.ERROR_MESSAGE);

  Show an internal information dialog with the message, 'information':


  JOptionPane.showInternalMessageDialog(frame, `information`,
              `information`, JOptionPane.INFORMATION_MESSAGE);
  Show an information panel with the options yes/no and message 'choose one':


 JOptionPane.showConfirmDialog(null,
              `choose one`, `choose one`, JOptionPane.YES_NO_OPTION);
  Show an internal information dialog with the options yes/no/cancel and
  message 'please choose one' and title information:


 JOptionPane.showInternalConfirmDialog(frame,
              `please choose one`, `information`,
              JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
  Show a warning dialog with the options OK, CANCEL, title 'Warning', and
  message 'Click OK to continue':


  Object[] options = { `OK`, `CANCEL` };
  JOptionPane.showOptionDialog(null, `Click OK to continue`, `Warning`,
              JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
              null, options, options[0]);
  Show a dialog asking the user to type in a String:

  String inputValue = JOptionPane.showInputDialog(`Please input a value`);

  Show a dialog asking the user to select a String:


  Object[] possibleValues = { `First`, `Second`, `Third` };
  Object selectedValue = JOptionPane.showInputDialog(null,
              `Choose one`, `Input`,
              JOptionPane.INFORMATION_MESSAGE, null,
              possibleValues, possibleValues[0]);

  Direct Use:
  To create and use an JOptionPane directly, the
  standard pattern is roughly as follows:


      JOptionPane pane = new JOptionPane(arguments);
      pane.set.Xxxx(...); // Configure
      JDialog dialog = pane.createDialog(parentComponent, title);
      dialog.show();
      Object selectedValue = pane.getValue();
      if(selectedValue == null)
        return CLOSED_OPTION;
      //If there is not an array of option buttons:
      if(options == null) {
        if(selectedValue instanceof Integer)
           return ((Integer)selectedValue).intValue();
        return CLOSED_OPTION;
      }
      //If there is an array of option buttons:
      for(int counter = 0, maxCounter = options.length;
         counter < maxCounter; counter++) {
         if(options[counter].equals(selectedValue))
         return counter;
      }
      return CLOSED_OPTION;

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
  (:import [javax.swing JOptionPane]))

(defn ->j-option-pane
  "Constructor.

  Creates an instance of JOptionPane to display a message
   with the specified message type, icon, and options, with the
   initially-selected option specified.

  message - the Object to display - `java.lang.Object`
  message-type - the type of message to be displayed: ERROR_MESSAGE, INFORMATION_MESSAGE, WARNING_MESSAGE, QUESTION_MESSAGE, or PLAIN_MESSAGE - `int`
  option-type - the options to display in the pane: DEFAULT_OPTION, YES_NO_OPTION, YES_NO_CANCEL_OPTION, OK_CANCEL_OPTION - `int`
  icon - the Icon image to display - `javax.swing.Icon`
  options - the choices the user can select - `java.lang.Object[]`
  initial-value - the choice that is initially selected; if null, then nothing will be initially selected; only meaningful if options is used - `java.lang.Object`"
  ([message message-type option-type icon options initial-value]
    (new JOptionPane message message-type option-type icon options initial-value))
  ([message message-type option-type icon options]
    (new JOptionPane message message-type option-type icon options))
  ([message message-type option-type icon]
    (new JOptionPane message message-type option-type icon))
  ([message message-type option-type]
    (new JOptionPane message message-type option-type))
  ([message message-type]
    (new JOptionPane message message-type))
  ([message]
    (new JOptionPane message))
  ([]
    (new JOptionPane )))

(def *-uninitialized-value
  "Static Constant.

  Indicates that the user has not yet selected a value.

  type: java.lang.Object"
  JOptionPane/UNINITIALIZED_VALUE)

(def *-default-option
  "Static Constant.

  Type meaning Look and Feel should not supply any options -- only
   use the options from the JOptionPane.

  type: int"
  JOptionPane/DEFAULT_OPTION)

(def *-yes-no-option
  "Static Constant.

  Type used for showConfirmDialog.

  type: int"
  JOptionPane/YES_NO_OPTION)

(def *-yes-no-cancel-option
  "Static Constant.

  Type used for showConfirmDialog.

  type: int"
  JOptionPane/YES_NO_CANCEL_OPTION)

(def *-ok-cancel-option
  "Static Constant.

  Type used for showConfirmDialog.

  type: int"
  JOptionPane/OK_CANCEL_OPTION)

(def *-yes-option
  "Static Constant.

  Return value from class method if YES is chosen.

  type: int"
  JOptionPane/YES_OPTION)

(def *-no-option
  "Static Constant.

  Return value from class method if NO is chosen.

  type: int"
  JOptionPane/NO_OPTION)

(def *-cancel-option
  "Static Constant.

  Return value from class method if CANCEL is chosen.

  type: int"
  JOptionPane/CANCEL_OPTION)

(def *-ok-option
  "Static Constant.

  Return value form class method if OK is chosen.

  type: int"
  JOptionPane/OK_OPTION)

(def *-closed-option
  "Static Constant.

  Return value from class method if user closes window without selecting
   anything, more than likely this should be treated as either a
   CANCEL_OPTION or NO_OPTION.

  type: int"
  JOptionPane/CLOSED_OPTION)

(def *-error-message
  "Static Constant.

  Used for error messages.

  type: int"
  JOptionPane/ERROR_MESSAGE)

(def *-information-message
  "Static Constant.

  Used for information messages.

  type: int"
  JOptionPane/INFORMATION_MESSAGE)

(def *-warning-message
  "Static Constant.

  Used for warning messages.

  type: int"
  JOptionPane/WARNING_MESSAGE)

(def *-question-message
  "Static Constant.

  Used for questions.

  type: int"
  JOptionPane/QUESTION_MESSAGE)

(def *-plain-message
  "Static Constant.

  No icon is used.

  type: int"
  JOptionPane/PLAIN_MESSAGE)

(def *-icon-property
  "Static Constant.

  Bound property name for icon.

  type: java.lang.String"
  JOptionPane/ICON_PROPERTY)

(def *-message-property
  "Static Constant.

  Bound property name for message.

  type: java.lang.String"
  JOptionPane/MESSAGE_PROPERTY)

(def *-value-property
  "Static Constant.

  Bound property name for value.

  type: java.lang.String"
  JOptionPane/VALUE_PROPERTY)

(def *-options-property
  "Static Constant.

  Bound property name for option.

  type: java.lang.String"
  JOptionPane/OPTIONS_PROPERTY)

(def *-initial-value-property
  "Static Constant.

  Bound property name for initialValue.

  type: java.lang.String"
  JOptionPane/INITIAL_VALUE_PROPERTY)

(def *-message-type-property
  "Static Constant.

  Bound property name for type.

  type: java.lang.String"
  JOptionPane/MESSAGE_TYPE_PROPERTY)

(def *-option-type-property
  "Static Constant.

  Bound property name for optionType.

  type: java.lang.String"
  JOptionPane/OPTION_TYPE_PROPERTY)

(def *-selection-values-property
  "Static Constant.

  Bound property name for selectionValues.

  type: java.lang.String"
  JOptionPane/SELECTION_VALUES_PROPERTY)

(def *-initial-selection-value-property
  "Static Constant.

  Bound property name for initialSelectionValue.

  type: java.lang.String"
  JOptionPane/INITIAL_SELECTION_VALUE_PROPERTY)

(def *-input-value-property
  "Static Constant.

  Bound property name for inputValue.

  type: java.lang.String"
  JOptionPane/INPUT_VALUE_PROPERTY)

(def *-wants-input-property
  "Static Constant.

  Bound property name for wantsInput.

  type: java.lang.String"
  JOptionPane/WANTS_INPUT_PROPERTY)

(defn *show-internal-option-dialog
  "Brings up an internal dialog panel with a specified icon, where
   the initial choice is determined by the initialValue
   parameter and the number of choices is determined by the
   optionType parameter.

   If optionType is YES_NO_OPTION, or
   YES_NO_CANCEL_OPTION
   and the options parameter is null,
   then the options are supplied by the Look and Feel.

   The messageType parameter is primarily used to supply
   a default icon from the look and feel.

  parent-component - determines the Frame in which the dialog is displayed; if null, or if the parentComponent has no Frame, a default Frame is used - `java.awt.Component`
  message - the object to display in the dialog; a Component object is rendered as a Component; a String object is rendered as a string. Other objects are converted to a String using the toString method - `java.lang.Object`
  title - the title string for the dialog - `java.lang.String`
  option-type - an integer designating the options available on the dialog: YES_NO_OPTION, or YES_NO_CANCEL_OPTION - `int`
  message-type - an integer designating the kind of message this is; primarily used to determine the icon from the pluggable Look and Feel: ERROR_MESSAGE, INFORMATION_MESSAGE, WARNING_MESSAGE, QUESTION_MESSAGE, or PLAIN_MESSAGE - `int`
  icon - the icon to display in the dialog - `javax.swing.Icon`
  options - an array of objects indicating the possible choices the user can make; if the objects are components, they are rendered properly; non-String objects are rendered using their toString methods; if this parameter is null, the options are determined by the Look and Feel - `java.lang.Object[]`
  initial-value - the object that represents the default selection for the dialog; only meaningful if options is used; can be null - `java.lang.Object`

  returns: an integer indicating the option chosen by the user,
            or CLOSED_OPTION if the user closed the Dialog - `int`"
  ([parent-component message title option-type message-type icon options initial-value]
    (JOptionPane/showInternalOptionDialog parent-component message title option-type message-type icon options initial-value)))

(defn *get-desktop-pane-for-component
  "Returns the specified component's desktop pane.

  parent-component - the Component to check for a desktop - `java.awt.Component`

  returns: the JDesktopPane that contains the component,
            or null if the component is null
            or does not have an ancestor that is a
            JInternalFrame - `javax.swing.JDesktopPane`"
  ([parent-component]
    (JOptionPane/getDesktopPaneForComponent parent-component)))

(defn *get-root-frame
  "Returns the Frame to use for the class methods in
   which a frame is not provided.

  returns: the default Frame to use - `java.awt.Frame`

  throws: java.awt.HeadlessException - if GraphicsEnvironment.isHeadless returns true"
  ([]
    (JOptionPane/getRootFrame )))

(defn *show-input-dialog
  "Prompts the user for input in a blocking dialog where the
   initial selection, possible selections, and all other options can
   be specified. The user will able to choose from
   selectionValues, where null implies the
   user can input
   whatever they wish, usually by means of a JTextField.
   initialSelectionValue is the initial value to prompt
   the user with. It is up to the UI to decide how best to represent
   the selectionValues, but usually a
   JComboBox, JList, or
   JTextField will be used.

  parent-component - the parent Component for the dialog - `java.awt.Component`
  message - the Object to display - `java.lang.Object`
  title - the String to display in the dialog title bar - `java.lang.String`
  message-type - the type of message to be displayed: ERROR_MESSAGE, INFORMATION_MESSAGE, WARNING_MESSAGE, QUESTION_MESSAGE, or PLAIN_MESSAGE - `int`
  icon - the Icon image to display - `javax.swing.Icon`
  selection-values - an array of Objects that gives the possible selections - `java.lang.Object[]`
  initial-selection-value - the value used to initialize the input field - `java.lang.Object`

  returns: user's input, or null meaning the user
                    canceled the input - `java.lang.Object`

  throws: java.awt.HeadlessException - if GraphicsEnvironment.isHeadless returns true"
  ([parent-component message title message-type icon selection-values initial-selection-value]
    (JOptionPane/showInputDialog parent-component message title message-type icon selection-values initial-selection-value))
  ([parent-component message title message-type]
    (JOptionPane/showInputDialog parent-component message title message-type))
  ([parent-component message initial-selection-value]
    (JOptionPane/showInputDialog parent-component message initial-selection-value))
  ([message initial-selection-value]
    (JOptionPane/showInputDialog message initial-selection-value))
  ([message]
    (JOptionPane/showInputDialog message)))

(defn *show-option-dialog
  "Brings up a dialog with a specified icon, where the initial
   choice is determined by the initialValue parameter and
   the number of choices is determined by the optionType
   parameter.

   If optionType is YES_NO_OPTION,
   or YES_NO_CANCEL_OPTION
   and the options parameter is null,
   then the options are
   supplied by the look and feel.

   The messageType parameter is primarily used to supply
   a default icon from the look and feel.

  parent-component - determines the Frame in which the dialog is displayed; if null, or if the parentComponent has no Frame, a default Frame is used - `java.awt.Component`
  message - the Object to display - `java.lang.Object`
  title - the title string for the dialog - `java.lang.String`
  option-type - an integer designating the options available on the dialog: DEFAULT_OPTION, YES_NO_OPTION, YES_NO_CANCEL_OPTION, or OK_CANCEL_OPTION - `int`
  message-type - an integer designating the kind of message this is, primarily used to determine the icon from the pluggable Look and Feel: ERROR_MESSAGE, INFORMATION_MESSAGE, WARNING_MESSAGE, QUESTION_MESSAGE, or PLAIN_MESSAGE - `int`
  icon - the icon to display in the dialog - `javax.swing.Icon`
  options - an array of objects indicating the possible choices the user can make; if the objects are components, they are rendered properly; non-String objects are rendered using their toString methods; if this parameter is null, the options are determined by the Look and Feel - `java.lang.Object[]`
  initial-value - the object that represents the default selection for the dialog; only meaningful if options is used; can be null - `java.lang.Object`

  returns: an integer indicating the option chosen by the user,
                    or CLOSED_OPTION if the user closed
                    the dialog - `int`

  throws: java.awt.HeadlessException - if GraphicsEnvironment.isHeadless returns true"
  ([parent-component message title option-type message-type icon options initial-value]
    (JOptionPane/showOptionDialog parent-component message title option-type message-type icon options initial-value)))

(defn *show-confirm-dialog
  "Brings up a dialog with a specified icon, where the number of
   choices is determined by the optionType parameter.
   The messageType parameter is primarily used to supply
   a default icon from the look and feel.

  parent-component - determines the Frame in which the dialog is displayed; if null, or if the parentComponent has no Frame, a default Frame is used - `java.awt.Component`
  message - the Object to display - `java.lang.Object`
  title - the title string for the dialog - `java.lang.String`
  option-type - an int designating the options available on the dialog: YES_NO_OPTION, YES_NO_CANCEL_OPTION, or OK_CANCEL_OPTION - `int`
  message-type - an int designating the kind of message this is, primarily used to determine the icon from the pluggable Look and Feel: ERROR_MESSAGE, INFORMATION_MESSAGE, WARNING_MESSAGE, QUESTION_MESSAGE, or PLAIN_MESSAGE - `int`
  icon - the icon to display in the dialog - `javax.swing.Icon`

  returns: an int indicating the option selected by the user - `int`

  throws: java.awt.HeadlessException - if GraphicsEnvironment.isHeadless returns true"
  ([parent-component message title option-type message-type icon]
    (JOptionPane/showConfirmDialog parent-component message title option-type message-type icon))
  ([parent-component message title option-type message-type]
    (JOptionPane/showConfirmDialog parent-component message title option-type message-type))
  ([parent-component message title option-type]
    (JOptionPane/showConfirmDialog parent-component message title option-type))
  ([parent-component message]
    (JOptionPane/showConfirmDialog parent-component message)))

(defn *show-internal-input-dialog
  "Prompts the user for input in a blocking internal dialog where
   the initial selection, possible selections, and all other
   options can be specified. The user will able to choose from
   selectionValues, where null
   implies the user can input
   whatever they wish, usually by means of a JTextField.
   initialSelectionValue is the initial value to prompt
   the user with. It is up to the UI to decide how best to represent
   the selectionValues, but usually a
   JComboBox, JList, or
   JTextField will be used.

  parent-component - the parent Component for the dialog - `java.awt.Component`
  message - the Object to display - `java.lang.Object`
  title - the String to display in the dialog title bar - `java.lang.String`
  message-type - the type of message to be displayed: ERROR_MESSAGE, INFORMATION_MESSAGE, WARNING_MESSAGE, QUESTION_MESSAGE, or PLAIN_MESSAGE - `int`
  icon - the Icon image to display - `javax.swing.Icon`
  selection-values - an array of Objects that gives the possible selections - `java.lang.Object[]`
  initial-selection-value - the value used to initialize the input field - `java.lang.Object`

  returns: user's input, or null meaning the user
            canceled the input - `java.lang.Object`"
  ([parent-component message title message-type icon selection-values initial-selection-value]
    (JOptionPane/showInternalInputDialog parent-component message title message-type icon selection-values initial-selection-value))
  ([parent-component message title message-type]
    (JOptionPane/showInternalInputDialog parent-component message title message-type))
  ([parent-component message]
    (JOptionPane/showInternalInputDialog parent-component message)))

(defn *show-message-dialog
  "Brings up a dialog displaying a message, specifying all parameters.

  parent-component - determines the Frame in which the dialog is displayed; if null, or if the parentComponent has no Frame, a default Frame is used - `java.awt.Component`
  message - the Object to display - `java.lang.Object`
  title - the title string for the dialog - `java.lang.String`
  message-type - the type of message to be displayed: ERROR_MESSAGE, INFORMATION_MESSAGE, WARNING_MESSAGE, QUESTION_MESSAGE, or PLAIN_MESSAGE - `int`
  icon - an icon to display in the dialog that helps the user identify the kind of message that is being displayed - `javax.swing.Icon`

  throws: java.awt.HeadlessException - if GraphicsEnvironment.isHeadless returns true"
  ([parent-component message title message-type icon]
    (JOptionPane/showMessageDialog parent-component message title message-type icon))
  ([parent-component message title message-type]
    (JOptionPane/showMessageDialog parent-component message title message-type))
  ([parent-component message]
    (JOptionPane/showMessageDialog parent-component message)))

(defn *set-root-frame
  "Sets the frame to use for class methods in which a frame is
   not provided.

   Note:
   It is recommended that rather than using this method you supply a valid parent.

  new-root-frame - the default Frame to use - `java.awt.Frame`"
  ([new-root-frame]
    (JOptionPane/setRootFrame new-root-frame)))

(defn *show-internal-confirm-dialog
  "Brings up an internal dialog panel with a specified icon, where
   the number of choices is determined by the optionType
   parameter.
   The messageType parameter is primarily used to supply
   a default icon from the look and feel.

  parent-component - determines the Frame in which the dialog is displayed; if null, or if the parentComponent has no Frame, a default Frame is used - `java.awt.Component`
  message - the object to display in the dialog; a Component object is rendered as a Component; a String object is rendered as a string; other objects are converted to a String using the toString method - `java.lang.Object`
  title - the title string for the dialog - `java.lang.String`
  option-type - an integer designating the options available on the dialog: YES_NO_OPTION, or YES_NO_CANCEL_OPTION. - `int`
  message-type - an integer designating the kind of message this is, primarily used to determine the icon from the pluggable Look and Feel: ERROR_MESSAGE, INFORMATION_MESSAGE, WARNING_MESSAGE, QUESTION_MESSAGE, or PLAIN_MESSAGE - `int`
  icon - the icon to display in the dialog - `javax.swing.Icon`

  returns: an integer indicating the option selected by the user - `int`"
  ([parent-component message title option-type message-type icon]
    (JOptionPane/showInternalConfirmDialog parent-component message title option-type message-type icon))
  ([parent-component message title option-type message-type]
    (JOptionPane/showInternalConfirmDialog parent-component message title option-type message-type))
  ([parent-component message title option-type]
    (JOptionPane/showInternalConfirmDialog parent-component message title option-type))
  ([parent-component message]
    (JOptionPane/showInternalConfirmDialog parent-component message)))

(defn *get-frame-for-component
  "Returns the specified component's Frame.

  parent-component - the Component to check for a Frame - `java.awt.Component`

  returns: the Frame that contains the component,
            or getRootFrame
            if the component is null,
            or does not have a valid Frame parent - `java.awt.Frame`

  throws: java.awt.HeadlessException - if GraphicsEnvironment.isHeadless returns true"
  ([parent-component]
    (JOptionPane/getFrameForComponent parent-component)))

(defn *show-internal-message-dialog
  "Brings up an internal dialog panel displaying a message,
   specifying all parameters.

  parent-component - determines the Frame in which the dialog is displayed; if null, or if the parentComponent has no Frame, a default Frame is used - `java.awt.Component`
  message - the Object to display - `java.lang.Object`
  title - the title string for the dialog - `java.lang.String`
  message-type - the type of message to be displayed: ERROR_MESSAGE, INFORMATION_MESSAGE, WARNING_MESSAGE, QUESTION_MESSAGE, or PLAIN_MESSAGE - `int`
  icon - an icon to display in the dialog that helps the user identify the kind of message that is being displayed - `javax.swing.Icon`"
  ([parent-component message title message-type icon]
    (JOptionPane/showInternalMessageDialog parent-component message title message-type icon))
  ([parent-component message title message-type]
    (JOptionPane/showInternalMessageDialog parent-component message title message-type))
  ([parent-component message]
    (JOptionPane/showInternalMessageDialog parent-component message)))

(defn get-initial-selection-value
  "Returns the input value that is displayed as initially selected to the user.

  returns: the initially selected value - `java.lang.Object`"
  ([this]
    (-> this (.getInitialSelectionValue))))

(defn set-options
  "Sets the options this pane displays. If an element in
   newOptions is a Component
   it is added directly to the pane,
   otherwise a button is created for the element.

  new-options - an array of Objects that create the buttons the user can click on, or arbitrary Components to add to the pane - `java.lang.Object[]`"
  ([this new-options]
    (-> this (.setOptions new-options))))

(defn create-dialog
  "Creates and returns a new JDialog wrapping
   this centered on the parentComponent
   in the parentComponent's frame.
   title is the title of the returned dialog.
   The returned JDialog will not be resizable by the
   user, however programs can invoke setResizable on
   the JDialog instance to change this property.
   The returned JDialog will be set up such that
   once it is closed, or the user clicks on one of the buttons,
   the optionpane's value property will be set accordingly and
   the dialog will be closed.  Each time the dialog is made visible,
   it will reset the option pane's value property to
   JOptionPane.UNINITIALIZED_VALUE to ensure the
   user's subsequent action closes the dialog properly.

  parent-component - determines the frame in which the dialog is displayed; if the parentComponent has no Frame, a default Frame is used - `java.awt.Component`
  title - the title string for the dialog - `java.lang.String`

  returns: a new JDialog containing this instance - `javax.swing.JDialog`

  throws: java.awt.HeadlessException - if GraphicsEnvironment.isHeadless returns true"
  ([this parent-component title]
    (-> this (.createDialog parent-component title)))
  ([this title]
    (-> this (.createDialog title))))

(defn get-input-value
  "Returns the value the user has input, if wantsInput
   is true.

  returns: the Object the user specified,
            if it was one of the objects, or a
            String if it was a value typed into a
            field - `java.lang.Object`"
  ([this]
    (-> this (.getInputValue))))

(defn set-icon
  "Sets the icon to display. If non-null, the look and feel
   does not provide an icon.

  new-icon - the Icon to display - `javax.swing.Icon`"
  ([this new-icon]
    (-> this (.setIcon new-icon))))

(defn set-option-type
  "Sets the options to display.
   The option type is used by the Look and Feel to
   determine what buttons to show (unless options are supplied).

  new-type - an integer specifying the options the L&F is to display: DEFAULT_OPTION, YES_NO_OPTION, YES_NO_CANCEL_OPTION, or OK_CANCEL_OPTION - `int`

  throws: java.lang.RuntimeException - if newType is not one of the legal values listed above"
  ([this new-type]
    (-> this (.setOptionType new-type))))

(defn select-initial-value
  "Requests that the initial value be selected, which will set
   focus to the initial value. This method
   should be invoked after the window containing the option pane
   is made visible."
  ([this]
    (-> this (.selectInitialValue))))

(defn get-icon
  "Returns the icon this pane displays.

  returns: the Icon that is displayed - `javax.swing.Icon`"
  ([this]
    (-> this (.getIcon))))

(defn get-ui-class-id
  "Returns the name of the UI class that implements the
   L&F for this component.

  returns: the string `OptionPaneUI` - `java.lang.String`"
  ([this]
    (-> this (.getUIClassID))))

(defn get-message-type
  "Returns the message type.

  returns: an integer specifying the message type - `int`"
  ([this]
    (-> this (.getMessageType))))

(defn get-value
  "Returns the value the user has selected. UNINITIALIZED_VALUE
   implies the user has not yet made a choice, null means the
   user closed the window with out choosing anything. Otherwise
   the returned value will be one of the options defined in this
   object.

  returns: the Object chosen by the user,
           UNINITIALIZED_VALUE
           if the user has not yet made a choice, or null if
           the user closed the window without making a choice - `java.lang.Object`"
  ([this]
    (-> this (.getValue))))

(defn get-wants-input?
  "Returns the value of the wantsInput property.

  returns: true if an input component will be provided - `boolean`"
  ([this]
    (-> this (.getWantsInput))))

(defn get-option-type
  "Returns the type of options that are displayed.

  returns: an integer specifying the user-selectable options - `int`"
  ([this]
    (-> this (.getOptionType))))

(defn set-ui
  "Sets the UI object which implements the L&F for this component.

  ui - the OptionPaneUI L&F object - `javax.swing.plaf.OptionPaneUI`"
  ([this ui]
    (-> this (.setUI ui))))

(defn get-selection-values
  "Returns the input selection values.

  returns: the array of Objects the user can select - `java.lang.Object[]`"
  ([this]
    (-> this (.getSelectionValues))))

(defn set-initial-value
  "Sets the initial value that is to be enabled -- the
   Component
   that has the focus when the pane is initially displayed.

  new-initial-value - the Object that gets the initial keyboard focus - `java.lang.Object`"
  ([this new-initial-value]
    (-> this (.setInitialValue new-initial-value))))

(defn get-ui
  "Returns the UI object which implements the L&F for this component.

  returns: the OptionPaneUI object - `javax.swing.plaf.OptionPaneUI`"
  ([this]
    (-> this (.getUI))))

(defn get-options
  "Returns the choices the user can make.

  returns: the array of Objects that give the user's choices - `java.lang.Object[]`"
  ([this]
    (-> this (.getOptions))))

(defn get-accessible-context
  "Returns the AccessibleContext associated with this JOptionPane.
   For option panes, the AccessibleContext takes the form of an
   AccessibleJOptionPane.
   A new AccessibleJOptionPane instance is created if necessary.

  returns: an AccessibleJOptionPane that serves as the
           AccessibleContext of this AccessibleJOptionPane - `javax.accessibility.AccessibleContext`"
  ([this]
    (-> this (.getAccessibleContext))))

(defn set-message-type
  "Sets the option pane's message type.
   The message type is used by the Look and Feel to determine the
   icon to display (if not supplied) as well as potentially how to
   lay out the parentComponent.

  new-type - an integer specifying the kind of message to display: ERROR_MESSAGE, INFORMATION_MESSAGE, WARNING_MESSAGE, QUESTION_MESSAGE, or PLAIN_MESSAGE - `int`

  throws: java.lang.RuntimeException - if newType is not one of the legal values listed above"
  ([this new-type]
    (-> this (.setMessageType new-type))))

(defn set-value
  "Sets the value the user has chosen.

  new-value - the chosen value - `java.lang.Object`"
  ([this new-value]
    (-> this (.setValue new-value))))

(defn get-max-characters-per-line-count
  "Returns the maximum number of characters to place on a line in a
   message. Default is to return Integer.MAX_VALUE.
   The value can be
   changed by overriding this method in a subclass.

  returns: an integer giving the maximum number of characters on a line - `int`"
  ([this]
    (-> this (.getMaxCharactersPerLineCount))))

(defn get-initial-value
  "Returns the initial value.

  returns: the Object that gets the initial keyboard focus - `java.lang.Object`"
  ([this]
    (-> this (.getInitialValue))))

(defn set-initial-selection-value
  "Sets the input value that is initially displayed as selected to the user.
   Only used if wantsInput is true.

  new-value - the initially selected value - `java.lang.Object`"
  ([this new-value]
    (-> this (.setInitialSelectionValue new-value))))

(defn get-message
  "Returns the message-object this pane displays.

  returns: the Object that is displayed - `java.lang.Object`"
  ([this]
    (-> this (.getMessage))))

(defn set-wants-input
  "Sets the wantsInput property.
   If newValue is true, an input component
   (such as a text field or combo box) whose parent is
   parentComponent is provided to
   allow the user to input a value. If getSelectionValues
   returns a non-null array, the input value is one of the
   objects in that array. Otherwise the input value is whatever
   the user inputs.

   This is a bound property.

  new-value - `boolean`"
  ([this new-value]
    (-> this (.setWantsInput new-value))))

(defn create-internal-frame
  "Creates and returns an instance of JInternalFrame.
   The internal frame is created with the specified title,
   and wrapping the JOptionPane.
   The returned JInternalFrame is
   added to the JDesktopPane ancestor of
   parentComponent, or components
   parent if one its ancestors isn't a JDesktopPane,
   or if parentComponent
   doesn't have a parent then a RuntimeException is thrown.

  parent-component - the parent Component for the internal frame - `java.awt.Component`
  title - the String to display in the frame's title bar - `java.lang.String`

  returns: a JInternalFrame containing a
            JOptionPane - `javax.swing.JInternalFrame`

  throws: java.lang.RuntimeException - if parentComponent does not have a valid parent"
  ([this parent-component title]
    (-> this (.createInternalFrame parent-component title))))

(defn set-selection-values
  "Sets the input selection values for a pane that provides the user
   with a list of items to choose from. (The UI provides a widget
   for choosing one of the values.)  A null value
   implies the user can input whatever they wish, usually by means
   of a JTextField.

   Sets wantsInput to true. Use
   setInitialSelectionValue to specify the initially-chosen
   value. After the pane as been enabled, inputValue is
   set to the value the user has selected.

  new-values - an array of Objects the user to be displayed (usually in a list or combo-box) from which the user can make a selection - `java.lang.Object[]`"
  ([this new-values]
    (-> this (.setSelectionValues new-values))))

(defn update-ui
  "Notification from the UIManager that the L&F has changed.
   Replaces the current UI object with the latest version from the
   UIManager."
  ([this]
    (-> this (.updateUI))))

(defn set-input-value
  "Sets the input value that was selected or input by the user.
   Only used if wantsInput is true.  Note that this method
   is invoked internally by the option pane (in response to user action)
   and should generally not be called by client programs.  To set the
   input value initially displayed as selected to the user, use
   setInitialSelectionValue.

  new-value - the Object used to set the value that the user specified (usually in a text field) - `java.lang.Object`"
  ([this new-value]
    (-> this (.setInputValue new-value))))

(defn set-message
  "Sets the option pane's message-object.

  new-message - the Object to display - `java.lang.Object`"
  ([this new-message]
    (-> this (.setMessage new-message))))

