(ns javax.swing.text.StyledEditorKit$AlignmentAction
  "An action to set paragraph alignment.  This sets the
  StyleConstants.Alignment attribute for the
  currently selected range of the target JEditorPane.
  This is done by calling
  StyledDocument.setParagraphAttributes
  on the styled document associated with the target
  JEditorPane.

  If the target text component is specified as the
  source of the ActionEvent and there is a command string,
  the command string will be interpreted as an integer
  that should be one of the legal values for the
  StyleConstants.Alignment attribute.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text StyledEditorKit$AlignmentAction]))

(defn ->alignment-action
  "Constructor.

  Creates a new AlignmentAction.

  nm - the action name - `java.lang.String`
  a - the alignment >= 0 - `int`"
  (^StyledEditorKit$AlignmentAction [^java.lang.String nm ^Integer a]
    (new StyledEditorKit$AlignmentAction nm a)))

(defn action-performed
  "Sets the alignment.

  e - the action event - `java.awt.event.ActionEvent`"
  ([^StyledEditorKit$AlignmentAction this ^java.awt.event.ActionEvent e]
    (-> this (.actionPerformed e))))

