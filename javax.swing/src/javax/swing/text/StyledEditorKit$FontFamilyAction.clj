(ns javax.swing.text.StyledEditorKit$FontFamilyAction
  "An action to set the font family in the associated
  JEditorPane.  This will use the family specified as
  the command string on the ActionEvent if there is one,
  otherwise the family that was initialized with will be used.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text StyledEditorKit$FontFamilyAction]))

(defn ->font-family-action
  "Constructor.

  Creates a new FontFamilyAction.

  nm - the action name - `java.lang.String`
  family - the font family - `java.lang.String`"
  (^StyledEditorKit$FontFamilyAction [^java.lang.String nm ^java.lang.String family]
    (new StyledEditorKit$FontFamilyAction nm family)))

(defn action-performed
  "Sets the font family.

  e - the event - `java.awt.event.ActionEvent`"
  ([^StyledEditorKit$FontFamilyAction this ^java.awt.event.ActionEvent e]
    (-> this (.actionPerformed e))))

