(ns javax.swing.text.StyledEditorKit$StyledTextAction
  "An action that assumes it's being fired on a JEditorPane
  with a StyledEditorKit (or subclass) installed.  This has
  some convenience methods for causing character or paragraph
  level attribute changes.  The convenience methods will
  throw an IllegalArgumentException if the assumption of
  a StyledDocument, a JEditorPane, or a StyledEditorKit
  fail to be true.

  The component that gets acted upon by the action
  will be the source of the ActionEvent if the source
  can be narrowed to a JEditorPane type.  If the source
  can't be narrowed, the most recently focused text
  component is changed.  If neither of these are the
  case, the action cannot be performed.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text StyledEditorKit$StyledTextAction]))

(defn ->styled-text-action
  "Constructor.

  Creates a new StyledTextAction from a string action name.

  nm - the name of the action - `java.lang.String`"
  ([^java.lang.String nm]
    (new StyledEditorKit$StyledTextAction nm)))

