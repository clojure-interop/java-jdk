(ns javax.swing.JSpinner$DefaultEditor
  "A simple base class for more specialized editors
  that displays a read-only view of the model's current
  value with a JFormattedTextField.  Subclasses
  can configure the JFormattedTextField to create
  an editor that's appropriate for the type of model they
  support and they may want to override
  the stateChanged and propertyChanged
  methods, which keep the model and the text field in sync.

  This class defines a dismiss method that removes the
  editors ChangeListener from the JSpinner
  that it's part of.   The setEditor method knows about
  DefaultEditor.dismiss, so if the developer
  replaces an editor that's derived from JSpinner.DefaultEditor
  its ChangeListener connection back to the
  JSpinner will be removed.  However after that,
  it's up to the developer to manage their editor listeners.
  Similarly, if a subclass overrides createEditor,
  it's up to the subclasser to deal with their editor
  subsequently being replaced (with setEditor).
  We expect that in most cases, and in editor installed
  with setEditor or created by a createEditor
  override, will not be replaced anyway.

  This class is the LayoutManager for it's single
  JFormattedTextField child.   By default the
  child is just centered with the parents insets."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing JSpinner$DefaultEditor]))

(defn ->default-editor
  "Constructor.

  Constructs an editor component for the specified JSpinner.
   This DefaultEditor is it's own layout manager and
   it is added to the spinner's ChangeListener list.
   The constructor creates a single JFormattedTextField child,
   initializes it's value to be the spinner model's current value
   and adds it to this DefaultEditor.

  spinner - the spinner whose model this editor will monitor - `javax.swing.JSpinner`"
  ([spinner]
    (new JSpinner$DefaultEditor spinner)))

(defn state-changed
  "This method is called when the spinner's model's state changes.
   It sets the value of the text field to the current
   value of the spinners model.

  e - the ChangeEvent whose source is the JSpinner whose model has changed. - `javax.swing.event.ChangeEvent`"
  ([this e]
    (-> this (.stateChanged e))))

(defn commit-edit
  "Pushes the currently edited value to the SpinnerModel.

   The default implementation invokes commitEdit on the
   JFormattedTextField.

  throws: java.text.ParseException - if the edited value is not legal"
  ([this]
    (-> this (.commitEdit))))

(defn dismiss
  "Disconnect this editor from the specified
   JSpinner.  By default, this method removes
   itself from the spinners ChangeListener list.

  spinner - the JSpinner to disconnect this editor from; the same spinner as was passed to the constructor. - `javax.swing.JSpinner`"
  ([this spinner]
    (-> this (.dismiss spinner))))

(defn preferred-layout-size
  "Returns the preferred size of first (and only) child plus the
   size of the parents insets.

  parent - the Container that's managing the layout - `java.awt.Container`

  returns: the preferred dimensions to lay out the subcomponents
            of the specified container. - `java.awt.Dimension`"
  ([this parent]
    (-> this (.preferredLayoutSize parent))))

(defn get-text-field
  "Returns the JFormattedTextField child of this
   editor.  By default the text field is the first and only
   child of editor.

  returns: the JFormattedTextField that gives the user
       access to the SpinnerDateModel's value. - `javax.swing.JFormattedTextField`"
  ([this]
    (-> this (.getTextField))))

(defn get-spinner
  "Returns the JSpinner ancestor of this editor or
   null if none of the ancestors are a
   JSpinner.
   Typically the editor's parent is a JSpinner however
   subclasses of JSpinner may override the
   the createEditor method and insert one or more containers
   between the JSpinner and it's editor.

  returns: JSpinner ancestor; null
           if none of the ancestors are a JSpinner - `javax.swing.JSpinner`"
  ([this]
    (-> this (.getSpinner))))

(defn get-baseline-resize-behavior
  "Returns an enum indicating how the baseline of the component
   changes as the size changes.

  returns: an enum indicating how the baseline changes as the component
           size changes - `java.awt.Component.BaselineResizeBehavior`

  throws: java.lang.NullPointerException"
  ([this]
    (-> this (.getBaselineResizeBehavior))))

(defn property-change
  "Called by the JFormattedTextField
   PropertyChangeListener.  When the `value`
   property changes, which implies that the user has typed a new
   number, we set the value of the spinners model.

   This class ignores PropertyChangeEvents whose
   source is not the JFormattedTextField, so subclasses
   may safely make this DefaultEditor a
   PropertyChangeListener on other objects.

  e - the PropertyChangeEvent whose source is the JFormattedTextField created by this class. - `java.beans.PropertyChangeEvent`"
  ([this e]
    (-> this (.propertyChange e))))

(defn minimum-layout-size
  "Returns the minimum size of first (and only) child plus the
   size of the parents insets.

  parent - the Container that's managing the layout - `java.awt.Container`

  returns: the minimum dimensions needed to lay out the subcomponents
            of the specified container. - `java.awt.Dimension`"
  ([this parent]
    (-> this (.minimumLayoutSize parent))))

(defn add-layout-component
  "This LayoutManager method does nothing.  We're
   only managing a single child and there's no support
   for layout constraints.

  name - ignored - `java.lang.String`
  child - ignored - `java.awt.Component`"
  ([this name child]
    (-> this (.addLayoutComponent name child))))

(defn get-baseline
  "Returns the baseline.

  width - the width to get the baseline for - `int`
  height - the height to get the baseline for - `int`

  returns: the baseline or < 0 indicating there is no reasonable
           baseline - `int`

  throws: java.lang.IllegalArgumentException - if width or height is < 0"
  ([this width height]
    (-> this (.getBaseline width height))))

(defn remove-layout-component
  "This LayoutManager method does nothing.  There
   isn't any per-child state.

  child - ignored - `java.awt.Component`"
  ([this child]
    (-> this (.removeLayoutComponent child))))

(defn layout-container
  "Resize the one (and only) child to completely fill the area
   within the parents insets.

  parent - the container to be laid out - `java.awt.Container`"
  ([this parent]
    (-> this (.layoutContainer parent))))

