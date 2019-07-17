(ns jdk.beans.PropertyEditor
  "A PropertyEditor class provides support for GUIs that want to
  allow users to edit a property value of a given type.

  PropertyEditor supports a variety of different kinds of ways of
  displaying and updating property values.  Most PropertyEditors will
  only need to support a subset of the different options available in
  this API.

  Simple PropertyEditors may only support the getAsText and setAsText
  methods and need not support (say) paintValue or getCustomEditor.  More
  complex types may be unable to support getAsText and setAsText but will
  instead support paintValue and getCustomEditor.

  Every propertyEditor must support one or more of the three simple
  display styles.  Thus it can either (1) support isPaintable or (2)
  both return a non-null String[] from getTags() and return a non-null
  value from getAsText or (3) simply return a non-null String from
  getAsText().

  Every property editor must support a call on setValue when the argument
  object is of the type for which this is the corresponding propertyEditor.
  In addition, each property editor must either support a custom editor,
  or support setAsText.

  Each PropertyEditor should have a null constructor."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.beans PropertyEditor]))

(defn paintable?
  "Determines whether this property editor is paintable.

  returns: True if the class will honor the paintValue method. - `boolean`"
  ([^java.beans.PropertyEditor this]
    (-> this (.isPaintable))))

(defn paint-value
  "Paint a representation of the value into a given area of screen
   real estate.  Note that the propertyEditor is responsible for doing
   its own clipping so that it fits into the given rectangle.

   If the PropertyEditor doesn't honor paint requests (see isPaintable)
   this method should be a silent noop.

   The given Graphics object will have the default font, color, etc of
   the parent container.  The PropertyEditor may change graphics attributes
   such as font and color and doesn't need to restore the old values.

  gfx - Graphics object to paint into. - `java.awt.Graphics`
  box - Rectangle within graphics object into which we should paint. - `java.awt.Rectangle`"
  ([^java.beans.PropertyEditor this ^java.awt.Graphics gfx ^java.awt.Rectangle box]
    (-> this (.paintValue gfx box))))

(defn set-as-text
  "Set the property value by parsing a given String.  May raise
   java.lang.IllegalArgumentException if either the String is
   badly formatted or if this kind of property can't be expressed
   as text.

  text - The string to be parsed. - `java.lang.String`

  throws: java.lang.IllegalArgumentException"
  ([^java.beans.PropertyEditor this ^java.lang.String text]
    (-> this (.setAsText text))))

(defn get-as-text
  "Gets the property value as text.

  returns: The property value as a human editable string.
      Returns null if the value can't be expressed as an editable string.
      If a non-null value is returned, then the PropertyEditor should
         be prepared to parse that string back in setAsText(). - `java.lang.String`"
  ([^java.beans.PropertyEditor this]
    (-> this (.getAsText))))

(defn get-java-initialization-string
  "Returns a fragment of Java code that can be used to set a property
   to match the editors current state. This method is intended
   for use when generating Java code to reflect changes made through the
   property editor.

   The code fragment should be context free and must be a legal Java
   expression as specified by the JLS.

   Specifically, if the expression represents a computation then all
   classes and static members should be fully qualified. This rule
   applies to constructors, static methods and non primitive arguments.

   Caution should be used when evaluating the expression as it may throw
   exceptions. In particular, code generators must ensure that generated
   code will compile in the presence of an expression that can throw
   checked exceptions.

   Example results are:

   Primitive expresssion: 2
   Class constructor: new java.awt.Color(127,127,34)
   Static field: java.awt.Color.orange
   Static method: javax.swing.Box.createRigidArea(new
                                     java.awt.Dimension(0, 5))

  returns: a fragment of Java code representing an initializer for the
           current value. It should not contain a semi-colon
           (';') to end the expression. - `java.lang.String`"
  ([^java.beans.PropertyEditor this]
    (-> this (.getJavaInitializationString))))

(defn supports-custom-editor
  "Determines whether this property editor supports a custom editor.

  returns: True if the propertyEditor can provide a custom editor. - `boolean`"
  ([^java.beans.PropertyEditor this]
    (-> this (.supportsCustomEditor))))

(defn get-value
  "Gets the property value.

  returns: The value of the property.  Primitive types such as `int` will
   be wrapped as the corresponding object type such as `java.lang.Integer`. - `java.lang.Object`"
  ([^java.beans.PropertyEditor this]
    (-> this (.getValue))))

(defn get-custom-editor
  "A PropertyEditor may choose to make available a full custom Component
   that edits its property value.  It is the responsibility of the
   PropertyEditor to hook itself up to its editor Component itself and
   to report property value changes by firing a PropertyChange event.

   The higher-level code that calls getCustomEditor may either embed
   the Component in some larger property sheet, or it may put it in
   its own individual dialog, or ...

  returns: A java.awt.Component that will allow a human to directly
        edit the current property value.  May be null if this is
        not supported. - `java.awt.Component`"
  ([^java.beans.PropertyEditor this]
    (-> this (.getCustomEditor))))

(defn remove-property-change-listener
  "Removes a listener for the value change.

  listener - the PropertyChangeListener to remove - `java.beans.PropertyChangeListener`"
  ([^java.beans.PropertyEditor this ^java.beans.PropertyChangeListener listener]
    (-> this (.removePropertyChangeListener listener))))

(defn get-tags
  "If the property value must be one of a set of known tagged values,
   then this method should return an array of the tags.  This can
   be used to represent (for example) enum values.  If a PropertyEditor
   supports tags, then it should support the use of setAsText with
   a tag value as a way of setting the value and the use of getAsText
   to identify the current value.

  returns: The tag values for this property.  May be null if this
     property cannot be represented as a tagged value. - `java.lang.String[]`"
  ([^java.beans.PropertyEditor this]
    (-> this (.getTags))))

(defn set-value
  "Set (or change) the object that is to be edited.  Primitive types such
   as `int` must be wrapped as the corresponding object type such as
   `java.lang.Integer`.

  value - The new target object to be edited. Note that this object should not be modified by the PropertyEditor, rather the PropertyEditor should create a new object to hold any modified value. - `java.lang.Object`"
  ([^java.beans.PropertyEditor this ^java.lang.Object value]
    (-> this (.setValue value))))

(defn add-property-change-listener
  "Adds a listener for the value change.
   When the property editor changes its value
   it should fire a PropertyChangeEvent
   on all registered PropertyChangeListeners,
   specifying the null value for the property name
   and itself as the source.

  listener - the PropertyChangeListener to add - `java.beans.PropertyChangeListener`"
  ([^java.beans.PropertyEditor this ^java.beans.PropertyChangeListener listener]
    (-> this (.addPropertyChangeListener listener))))

