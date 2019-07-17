(ns javax.swing.JPasswordField
  "JPasswordField is a lightweight component that allows
  the editing of a single line of text where the view indicates
  something was typed, but does not show the original characters.
  You can find further information and examples in
  How to Use Text Fields,
  a section in The Java Tutorial.

  JPasswordField is intended
  to be source-compatible with java.awt.TextField
  used with echoChar set.  It is provided separately
  to make it easier to safely change the UI for the
  JTextField without affecting password entries.

  NOTE:
  By default, JPasswordField disables input methods; otherwise, input
  characters could be visible while they were composed using input methods.
  If an application needs the input methods support, please use the
  inherited method, enableInputMethods(true).

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
  (:import [javax.swing JPasswordField]))

(defn ->j-password-field
  "Constructor.

  Constructs a new JPasswordField that uses the
   given text storage model and the given number of columns.
   This is the constructor through which the other constructors feed.
   The echo character is set to '*', but may be changed by the current
   Look and Feel.  If the document model is
   null, a default one will be created.

  doc - the text storage to use - `javax.swing.text.Document`
  txt - the text to be displayed, null if none - `java.lang.String`
  columns - the number of columns to use to calculate the preferred width >= 0; if columns is set to zero, the preferred width will be whatever naturally results from the component implementation - `int`"
  ([^javax.swing.text.Document doc ^java.lang.String txt ^Integer columns]
    (new JPasswordField doc txt columns))
  ([^java.lang.String text ^Integer columns]
    (new JPasswordField text columns))
  ([^java.lang.String text]
    (new JPasswordField text))
  ([]
    (new JPasswordField )))

(defn get-echo-char
  "Returns the character to be used for echoing.  The default is '*'.
   The default may be different depending on the currently running Look
   and Feel. For example, Metal/Ocean's default is a bullet character.

  returns: the echo character, 0 if unset - `char`"
  (^Character [^javax.swing.JPasswordField this]
    (-> this (.getEchoChar))))

(defn copy
  "Invokes provideErrorFeedback on the current
   look and feel, which typically initiates an error beep.
   The normal behavior of transferring the
   currently selected range in the associated text model
   to the system clipboard, and leaving the contents from
   the model, is not acceptable for a password field."
  ([^javax.swing.JPasswordField this]
    (-> this (.copy))))

(defn get-text
  "Deprecated. As of Java 2 platform v1.2,
   replaced by getPassword.

  returns: the text - `java.lang.  java.lang.String`"
  ([^javax.swing.JPasswordField this]
    (-> this (.getText)))
  ([^javax.swing.JPasswordField this ^Integer offs ^Integer len]
    (-> this (.getText offs len))))

(defn get-ui-class-id
  "Returns the name of the L&F class that renders this component.

  returns: the string `PasswordFieldUI` - `java.lang.String`"
  (^java.lang.String [^javax.swing.JPasswordField this]
    (-> this (.getUIClassID))))

(defn set-echo-char
  "Sets the echo character for this JPasswordField.
   Note that this is largely a suggestion, since the
   view that gets installed can use whatever graphic techniques
   it desires to represent the field.  Setting a value of 0 indicates
   that you wish to see the text as it is typed, similar to
   the behavior of a standard JTextField.

  c - the echo character to display - `char`"
  ([^javax.swing.JPasswordField this ^Character c]
    (-> this (.setEchoChar c))))

(defn get-accessible-context
  "Returns the AccessibleContext associated with this
   JPasswordField. For password fields, the
   AccessibleContext takes the form of an
   AccessibleJPasswordField.
   A new AccessibleJPasswordField instance is created
   if necessary.

  returns: an AccessibleJPasswordField that serves as the
           AccessibleContext of this
           JPasswordField - `javax.accessibility.AccessibleContext`"
  (^javax.accessibility.AccessibleContext [^javax.swing.JPasswordField this]
    (-> this (.getAccessibleContext))))

(defn echo-char-is-set
  "Returns true if this JPasswordField has a character
   set for echoing.  A character is considered to be set if the echo
   character is not 0.

  returns: true if a character is set for echoing - `boolean`"
  (^Boolean [^javax.swing.JPasswordField this]
    (-> this (.echoCharIsSet))))

(defn cut
  "Invokes provideErrorFeedback on the current
   look and feel, which typically initiates an error beep.
   The normal behavior of transferring the
   currently selected range in the associated text model
   to the system clipboard, and removing the contents from
   the model, is not acceptable for a password field."
  ([^javax.swing.JPasswordField this]
    (-> this (.cut))))

(defn update-ui
  "Reloads the pluggable UI.  The key used to fetch the
   new interface is getUIClassID().  The type of
   the UI is TextUI.  invalidate
   is called after setting the UI."
  ([^javax.swing.JPasswordField this]
    (-> this (.updateUI))))

(defn get-password
  "Returns the text contained in this TextComponent.
   If the underlying document is null, will give a
   NullPointerException.  For stronger
   security, it is recommended that the returned character array be
   cleared after use by setting each character to zero.

  returns: the text - `char[]`"
  ([^javax.swing.JPasswordField this]
    (-> this (.getPassword))))

