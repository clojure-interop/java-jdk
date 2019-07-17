(ns javax.swing.text.html.FormView
  "Component decorator that implements the view interface
  for form elements, <input>, <textarea>,
  and <select>.  The model for the component is stored
  as an attribute of the the element (using StyleConstants.ModelAttribute),
  and is used to build the component of the view.  The type
  of the model is assumed to of the type that would be set by
  HTMLDocument.HTMLReader.FormAction.  If there are
  multiple views mapped over the document, they will share the
  embedded component models.

  The following table shows what components get built
  by this view.


    Element Type
    Component built


    input, type button
    JButton


    input, type checkbox
    JCheckBox


    input, type image
    JButton


    input, type password
    JPasswordField


    input, type radio
    JRadioButton


    input, type reset
    JButton


    input, type submit
    JButton


    input, type text
    JTextField


    select, size > 1 or multiple attribute defined
    JList in a JScrollPane


    select, size unspecified or 1
    JComboBox


    textarea
    JTextArea in a JScrollPane


    input, type file
    JTextField"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text.html FormView]))

(defn ->form-view
  "Constructor.

  Creates a new FormView object.

  elem - the element to decorate - `javax.swing.text.Element`"
  ([elem]
    (new FormView elem)))

(def *-submit
  "Static Constant.

  Deprecated. As of 1.3, value now comes from UIManager property
               FormView.submitButtonText

  type: java.lang.    java.lang.String"
  FormView/SUBMIT)

(def *-reset
  "Static Constant.

  Deprecated. As of 1.3, value comes from UIManager UIManager property
               FormView.resetButtonText

  type: java.lang.    java.lang.String"
  FormView/RESET)

(defn get-maximum-span
  "Determines the maximum span for this view along an
   axis. For certain components, the maximum and preferred span are the
   same. For others this will return the value
   returned by Component.getMaximumSize along the
   axis of interest.

  axis - may be either View.X_AXIS or View.Y_AXIS - `int`

  returns: the span the view would like to be rendered into >= 0.
             Typically the view is told to render into the span
             that is returned, although there is no guarantee.
             The parent may choose to resize or break the view. - `float`

  throws: java.lang.IllegalArgumentException - for an invalid axis"
  ([this axis]
    (-> this (.getMaximumSpan axis))))

(defn action-performed
  "Responsible for processing the ActionEvent.
   If the element associated with the FormView,
   has a type of `submit`, `reset`, `text` or `password`
   then the action is processed.  In the case of a `submit`
   the form is submitted.  In the case of a `reset`
   the form is reset to its original state.
   In the case of `text` or `password`, if the
   element is the last one of type `text` or `password`,
   the form is submitted.  Otherwise, focus is transferred
   to the next component in the form.

  evt - the ActionEvent. - `java.awt.event.ActionEvent`"
  ([this evt]
    (-> this (.actionPerformed evt))))

