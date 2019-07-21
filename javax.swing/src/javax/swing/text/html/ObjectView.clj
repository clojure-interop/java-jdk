(ns javax.swing.text.html.ObjectView
  "Component decorator that implements the view interface
  for <object> elements.

  This view will try to load the class specified by the
  classid attribute.  If possible, the Classloader
  used to load the associated Document is used.
  This would typically be the same as the ClassLoader
  used to load the EditorKit.  If the document's
  ClassLoader is null, Class.forName is used.

  If the class can successfully be loaded, an attempt will
  be made to create an instance of it by calling
  Class.newInstance.  An attempt will be made
  to narrow the instance to type java.awt.Component
  to display the object.

  This view can also manage a set of parameters with limitations.
  The parameters to the <object> element are expected to
  be present on the associated elements attribute set as simple
  strings.  Each bean property will be queried as a key on
  the AttributeSet, with the expectation that a non-null value
  (of type String) will be present if there was a parameter
  specification for the property.  Reflection is used to
  set the parameter.  Currently, this is limited to a very
  simple single parameter of type String.

  A simple example HTML invocation is:


       <object classid=\"javax.swing.JLabel\">
       <param name=\"text\" value=\"sample text\">
       </object>"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text.html ObjectView]))

(defn ->object-view
  "Constructor.

  Creates a new ObjectView object.

  elem - the element to decorate - `javax.swing.text.Element`"
  (^ObjectView [^javax.swing.text.Element elem]
    (new ObjectView elem)))

