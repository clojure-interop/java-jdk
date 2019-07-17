(ns jdk.beans.PropertyEditorSupport
  "This is a support class to help build property editors.

  It can be used either as a base class or as a delegate."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.beans PropertyEditorSupport]))

(defn ->property-editor-support
  "Constructor.

  Constructs a PropertyEditorSupport object.

  source - the source used for event firing - `java.lang.Object`"
  ([source]
    (new PropertyEditorSupport source))
  ([]
    (new PropertyEditorSupport )))

(defn paintable?
  "Determines whether the class will honor the paintValue method.

  returns: True if the class will honor the paintValue method. - `boolean`"
  ([this]
    (-> this (.isPaintable))))

(defn paint-value
  "Paint a representation of the value into a given area of screen
   real estate.  Note that the propertyEditor is responsible for doing
   its own clipping so that it fits into the given rectangle.

   If the PropertyEditor doesn't honor paint requests (see isPaintable)
   this method should be a silent noop.

  gfx - Graphics object to paint into. - `java.awt.Graphics`
  box - Rectangle within graphics object into which we should paint. - `java.awt.Rectangle`"
  ([this gfx box]
    (-> this (.paintValue gfx box))))

(defn set-as-text
  "Sets the property value by parsing a given String.  May raise
   java.lang.IllegalArgumentException if either the String is
   badly formatted or if this kind of property can't be expressed
   as text.

  text - The string to be parsed. - `java.lang.String`

  throws: java.lang.IllegalArgumentException"
  ([this text]
    (-> this (.setAsText text))))

(defn fire-property-change
  "Report that we have been modified to any interested listeners."
  ([this]
    (-> this (.firePropertyChange))))

(defn get-as-text
  "Gets the property value as a string suitable for presentation
   to a human to edit.

  returns: The property value as a string suitable for presentation
         to a human to edit.
      Returns null if the value can't be expressed as a string.
      If a non-null value is returned, then the PropertyEditor should
         be prepared to parse that string back in setAsText(). - `java.lang.String`"
  ([this]
    (-> this (.getAsText))))

(defn get-java-initialization-string
  "This method is intended for use when generating Java code to set
   the value of the property.  It should return a fragment of Java code
   that can be used to initialize a variable with the current property
   value.

   Example results are `2`, `new Color(127,127,34)`, `Color.orange`, etc.

  returns: A fragment of Java code representing an initializer for the
            current value. - `java.lang.String`"
  ([this]
    (-> this (.getJavaInitializationString))))

(defn supports-custom-editor
  "Determines whether the propertyEditor can provide a custom editor.

  returns: True if the propertyEditor can provide a custom editor. - `boolean`"
  ([this]
    (-> this (.supportsCustomEditor))))

(defn get-value
  "Gets the value of the property.

  returns: The value of the property. - `java.lang.Object`"
  ([this]
    (-> this (.getValue))))

(defn get-custom-editor
  "A PropertyEditor may chose to make available a full custom Component
   that edits its property value.  It is the responsibility of the
   PropertyEditor to hook itself up to its editor Component itself and
   to report property value changes by firing a PropertyChange event.

   The higher-level code that calls getCustomEditor may either embed
   the Component in some larger property sheet, or it may put it in
   its own individual dialog, or ...

  returns: A java.awt.Component that will allow a human to directly
        edit the current property value.  May be null if this is
        not supported. - `java.awt.Component`"
  ([this]
    (-> this (.getCustomEditor))))

(defn remove-property-change-listener
  "Removes a listener for the value change.

   If the same listener was added more than once,
   it will be notified one less time after being removed.
   If listener is null, or was never added,
   no exception is thrown and no action is taken.

  listener - the PropertyChangeListener to remove - `java.beans.PropertyChangeListener`"
  ([this listener]
    (-> this (.removePropertyChangeListener listener))))

(defn get-source
  "Returns the bean that is used as the
   source of events. If the source has not
   been explicitly set then this instance of
   PropertyEditorSupport is returned.

  returns: the source object or this instance - `java.lang.Object`"
  ([this]
    (-> this (.getSource))))

(defn get-tags
  "If the property value must be one of a set of known tagged values,
   then this method should return an array of the tag values.  This can
   be used to represent (for example) enum values.  If a PropertyEditor
   supports tags, then it should support the use of setAsText with
   a tag value as a way of setting the value.

  returns: The tag values for this property.  May be null if this
     property cannot be represented as a tagged value. - `java.lang.String[]`"
  ([this]
    (-> this (.getTags))))

(defn set-value
  "Set (or change) the object that is to be edited.

  value - The new target object to be edited. Note that this object should not be modified by the PropertyEditor, rather the PropertyEditor should create a new object to hold any modified value. - `java.lang.Object`"
  ([this value]
    (-> this (.setValue value))))

(defn add-property-change-listener
  "Adds a listener for the value change.
   When the property editor changes its value
   it should fire a PropertyChangeEvent
   on all registered PropertyChangeListeners,
   specifying the null value for the property name.
   If the source property is set,
   it should be used as the source of the event.

   The same listener object may be added more than once,
   and will be called as many times as it is added.
   If listener is null,
   no exception is thrown and no action is taken.

  listener - the PropertyChangeListener to add - `java.beans.PropertyChangeListener`"
  ([this listener]
    (-> this (.addPropertyChangeListener listener))))

(defn set-source
  "Sets the source bean.

   The source bean is used as the source of events
   for the property changes. This source should be used for information
   purposes only and should not be modified by the PropertyEditor.

  source - source object to be used for events - `java.lang.Object`"
  ([this source]
    (-> this (.setSource source))))

