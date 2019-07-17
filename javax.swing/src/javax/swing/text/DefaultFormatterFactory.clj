(ns javax.swing.text.DefaultFormatterFactory
  "An implementation of
  JFormattedTextField.AbstractFormatterFactory.
  DefaultFormatterFactory allows specifying a number of
  different JFormattedTextField.AbstractFormatters that are to
  be used.
  The most important one is the default one
  (setDefaultFormatter). The default formatter will be used
  if a more specific formatter could not be found. The following process
  is used to determine the appropriate formatter to use.

    Is the passed in value null? Use the null formatter.
    Does the JFormattedTextField have focus? Use the edit
        formatter.
    Otherwise, use the display formatter.
    If a non-null AbstractFormatter has not been found, use
        the default formatter.


  The following code shows how to configure a
  JFormattedTextField with two
  JFormattedTextField.AbstractFormatters, one for display and
  one for editing.


  JFormattedTextField.AbstractFormatter editFormatter = ...;
  JFormattedTextField.AbstractFormatter displayFormatter = ...;
  DefaultFormatterFactory factory = new DefaultFormatterFactory(
                  displayFormatter, displayFormatter, editFormatter);
  JFormattedTextField tf = new JFormattedTextField(factory);

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text DefaultFormatterFactory]))

(defn ->default-formatter-factory
  "Constructor.

  Creates a DefaultFormatterFactory with the specified
   JFormattedTextField.AbstractFormatters.

  default-format - JFormattedTextField.AbstractFormatter to be used if a more specific JFormattedTextField.AbstractFormatter can not be found. - `javax.swing.JFormattedTextField.AbstractFormatter`
  display-format - JFormattedTextField.AbstractFormatter to be used when the JFormattedTextField does not have focus. - `javax.swing.JFormattedTextField.AbstractFormatter`
  edit-format - JFormattedTextField.AbstractFormatter to be used when the JFormattedTextField has focus. - `javax.swing.JFormattedTextField.AbstractFormatter`
  null-format - JFormattedTextField.AbstractFormatter to be used when the JFormattedTextField has a null value. - `javax.swing.JFormattedTextField.AbstractFormatter`"
  ([^javax.swing.JFormattedTextField.AbstractFormatter default-format ^javax.swing.JFormattedTextField.AbstractFormatter display-format ^javax.swing.JFormattedTextField.AbstractFormatter edit-format ^javax.swing.JFormattedTextField.AbstractFormatter null-format]
    (new DefaultFormatterFactory default-format display-format edit-format null-format))
  ([^javax.swing.JFormattedTextField.AbstractFormatter default-format ^javax.swing.JFormattedTextField.AbstractFormatter display-format ^javax.swing.JFormattedTextField.AbstractFormatter edit-format]
    (new DefaultFormatterFactory default-format display-format edit-format))
  ([^javax.swing.JFormattedTextField.AbstractFormatter default-format ^javax.swing.JFormattedTextField.AbstractFormatter display-format]
    (new DefaultFormatterFactory default-format display-format))
  ([^javax.swing.JFormattedTextField.AbstractFormatter default-format]
    (new DefaultFormatterFactory default-format))
  ([]
    (new DefaultFormatterFactory )))

(defn get-null-formatter
  "Returns the formatter to use if the value is null.

  returns: JFormattedTextField.AbstractFormatter to use when the value is
           null - `javax.swing.JFormattedTextField.AbstractFormatter`"
  (^javax.swing.JFormattedTextField.AbstractFormatter [^javax.swing.text.DefaultFormatterFactory this]
    (-> this (.getNullFormatter))))

(defn get-edit-formatter
  "Returns the JFormattedTextField.AbstractFormatter to use
   if the JFormattedTextField is being edited and either
   the value is not-null, or the value is null and a null formatter has
   has not been specified.

  returns: JFormattedTextField.AbstractFormatter to use when the
           component has focus - `javax.swing.JFormattedTextField.AbstractFormatter`"
  (^javax.swing.JFormattedTextField.AbstractFormatter [^javax.swing.text.DefaultFormatterFactory this]
    (-> this (.getEditFormatter))))

(defn set-display-formatter
  "Sets the JFormattedTextField.AbstractFormatter to use if
   the JFormattedTextField is not being edited and either
   the value is not-null, or the value is null and a null formatter has
   has not been specified.

  atf - JFormattedTextField.AbstractFormatter to use when the JFormattedTextField does not have focus - `javax.swing.JFormattedTextField.AbstractFormatter`"
  ([^javax.swing.text.DefaultFormatterFactory this ^javax.swing.JFormattedTextField.AbstractFormatter atf]
    (-> this (.setDisplayFormatter atf))))

(defn set-null-formatter
  "Sets the formatter to use if the value of the JFormattedTextField is
   null.

  atf - JFormattedTextField.AbstractFormatter to use when the value of the JFormattedTextField is null. - `javax.swing.JFormattedTextField.AbstractFormatter`"
  ([^javax.swing.text.DefaultFormatterFactory this ^javax.swing.JFormattedTextField.AbstractFormatter atf]
    (-> this (.setNullFormatter atf))))

(defn set-default-formatter
  "Sets the JFormattedTextField.AbstractFormatter to use as
   a last resort, eg in case a display, edit or null
   JFormattedTextField.AbstractFormatter has not been
   specified.

  atf - JFormattedTextField.AbstractFormatter used if a more specific is not specified - `javax.swing.JFormattedTextField.AbstractFormatter`"
  ([^javax.swing.text.DefaultFormatterFactory this ^javax.swing.JFormattedTextField.AbstractFormatter atf]
    (-> this (.setDefaultFormatter atf))))

(defn get-formatter
  "Returns either the default formatter, display formatter, editor
   formatter or null formatter based on the state of the
   JFormattedTextField.

  source - JFormattedTextField requesting JFormattedTextField.AbstractFormatter - `javax.swing.JFormattedTextField`

  returns: JFormattedTextField.AbstractFormatter to handle
           formatting duties. - `javax.swing.JFormattedTextField.AbstractFormatter`"
  (^javax.swing.JFormattedTextField.AbstractFormatter [^javax.swing.text.DefaultFormatterFactory this ^javax.swing.JFormattedTextField source]
    (-> this (.getFormatter source))))

(defn set-edit-formatter
  "Sets the JFormattedTextField.AbstractFormatter to use if
   the JFormattedTextField is being edited and either
   the value is not-null, or the value is null and a null formatter has
   has not been specified.

  atf - JFormattedTextField.AbstractFormatter to use when the component has focus - `javax.swing.JFormattedTextField.AbstractFormatter`"
  ([^javax.swing.text.DefaultFormatterFactory this ^javax.swing.JFormattedTextField.AbstractFormatter atf]
    (-> this (.setEditFormatter atf))))

(defn get-default-formatter
  "Returns the JFormattedTextField.AbstractFormatter to use
   as a last resort, eg in case a display, edit or null
   JFormattedTextField.AbstractFormatter
   has not been specified.

  returns: JFormattedTextField.AbstractFormatter used if a more specific
           one is not specified. - `javax.swing.JFormattedTextField.AbstractFormatter`"
  (^javax.swing.JFormattedTextField.AbstractFormatter [^javax.swing.text.DefaultFormatterFactory this]
    (-> this (.getDefaultFormatter))))

(defn get-display-formatter
  "Returns the JFormattedTextField.AbstractFormatter to use
   if the JFormattedTextField is not being edited and either
   the value is not-null, or the value is null and a null formatter has
   has not been specified.

  returns: JFormattedTextField.AbstractFormatter to use when the
           JFormattedTextField does not have focus - `javax.swing.JFormattedTextField.AbstractFormatter`"
  (^javax.swing.JFormattedTextField.AbstractFormatter [^javax.swing.text.DefaultFormatterFactory this]
    (-> this (.getDisplayFormatter))))

