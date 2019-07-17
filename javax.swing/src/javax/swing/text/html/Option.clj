(ns javax.swing.text.html.Option
  "Value for the ListModel used to represent
  <option> elements.  This is the object
  installed as items of the DefaultComboBoxModel
  used to represent the <select> element.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text.html Option]))

(defn ->option
  "Constructor.

  Creates a new Option object.

  attr - the attributes associated with the option element. The attributes are copied to ensure they won't change. - `javax.swing.text.AttributeSet`"
  ([attr]
    (new Option attr)))

(defn set-label
  "Sets the label to be used for the option.

  label - `java.lang.String`"
  ([this label]
    (-> this (.setLabel label))))

(defn get-label
  "Fetch the label associated with the option.

  returns: `java.lang.String`"
  ([this]
    (-> this (.getLabel))))

(defn get-attributes
  "Fetch the attributes associated with this option.

  returns: `javax.swing.text.AttributeSet`"
  ([this]
    (-> this (.getAttributes))))

(defn to-string
  "String representation is the label.

  returns: a string representation of the object. - `java.lang.String`"
  ([this]
    (-> this (.toString))))

(defn selected?
  "Fetches the selection state associated with this option.

  returns: `boolean`"
  ([this]
    (-> this (.isSelected))))

(defn get-value
  "Convenience method to return the string associated
   with the value attribute.  If the
   value has not been specified, the label will be
   returned.

  returns: `java.lang.String`"
  ([this]
    (-> this (.getValue))))

