(ns javax.swing.text.DefaultFormatter
  "DefaultFormatter formats arbitrary objects. Formatting is done
  by invoking the toString method. In order to convert the
  value back to a String, your class must provide a constructor that
  takes a String argument. If no single argument constructor that takes a
  String is found, the returned value will be the String passed into
  stringToValue.

  Instances of DefaultFormatter can not be used in multiple
  instances of JFormattedTextField. To obtain a copy of
  an already configured DefaultFormatter, use the
  clone method.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text DefaultFormatter]))

(defn ->default-formatter
  "Constructor.

  Creates a DefaultFormatter."
  (^DefaultFormatter []
    (new DefaultFormatter )))

(defn set-allows-invalid
  "Sets whether or not the value being edited is allowed to be invalid
   for a length of time (that is, stringToValue throws
   a ParseException).
   It is often convenient to allow the user to temporarily input an
   invalid value.

  allows-invalid - Used to indicate if the edited value must always be valid - `boolean`"
  ([^DefaultFormatter this ^Boolean allows-invalid]
    (-> this (.setAllowsInvalid allows-invalid))))

(defn string-to-value
  "Converts the passed in String into an instance of
   getValueClass by way of the constructor that
   takes a String argument. If getValueClass
   returns null, the Class of the current value in the
   JFormattedTextField will be used. If this is null, a
   String will be returned. If the constructor throws an exception, a
   ParseException will be thrown. If there is no single
   argument String constructor, string will be returned.

  string - String to convert - `java.lang.String`

  returns: Object representation of text - `java.lang.Object`

  throws: java.text.ParseException - if there is an error in the conversion"
  (^java.lang.Object [^DefaultFormatter this ^java.lang.String string]
    (-> this (.stringToValue string))))

(defn get-allows-invalid?
  "Returns whether or not the value being edited is allowed to be invalid
   for a length of time.

  returns: false if the edited value must always be valid - `boolean`"
  (^Boolean [^DefaultFormatter this]
    (-> this (.getAllowsInvalid))))

(defn get-value-class
  "Returns that class that is used to create new Objects.

  returns: Class used to construct return value from stringToValue - `java.lang.Class<?>`"
  (^java.lang.Class [^DefaultFormatter this]
    (-> this (.getValueClass))))

(defn set-overwrite-mode
  "Configures the behavior when inserting characters. If
   overwriteMode is true (the default), new characters
   overwrite existing characters in the model.

  overwrite-mode - Indicates if overwrite or overstrike mode is used - `boolean`"
  ([^DefaultFormatter this ^Boolean overwrite-mode]
    (-> this (.setOverwriteMode overwrite-mode))))

(defn set-value-class
  "Sets that class that is used to create new Objects. If the
   passed in class does not have a single argument constructor that
   takes a String, String values will be used.

  value-class - Class used to construct return value from stringToValue - `java.lang.Class`"
  ([^DefaultFormatter this ^java.lang.Class value-class]
    (-> this (.setValueClass value-class))))

(defn install
  "Installs the DefaultFormatter onto a particular
   JFormattedTextField.
   This will invoke valueToString to convert the
   current value from the JFormattedTextField to
   a String. This will then install the Actions from
   getActions, the DocumentFilter
   returned from getDocumentFilter and the
   NavigationFilter returned from
   getNavigationFilter onto the
   JFormattedTextField.

   Subclasses will typically only need to override this if they
   wish to install additional listeners on the
   JFormattedTextField.

   If there is a ParseException in converting the
   current value to a String, this will set the text to an empty
   String, and mark the JFormattedTextField as being
   in an invalid state.

   While this is a public method, this is typically only useful
   for subclassers of JFormattedTextField.
   JFormattedTextField will invoke this method at
   the appropriate times when the value changes, or its internal
   state changes.

  ftf - JFormattedTextField to format for, may be null indicating uninstall from current JFormattedTextField. - `javax.swing.JFormattedTextField`"
  ([^DefaultFormatter this ^javax.swing.JFormattedTextField ftf]
    (-> this (.install ftf))))

(defn set-commits-on-valid-edit
  "Sets when edits are published back to the
   JFormattedTextField. If true, commitEdit
   is invoked after every valid edit (any time the text is edited). On
   the other hand, if this is false than the DefaultFormatter
   does not publish edits back to the JFormattedTextField.
   As such, the only time the value of the JFormattedTextField
   will change is when commitEdit is invoked on
   JFormattedTextField, typically when enter is pressed
   or focus leaves the JFormattedTextField.

  commit - Used to indicate when edits are committed back to the JTextComponent - `boolean`"
  ([^DefaultFormatter this ^Boolean commit]
    (-> this (.setCommitsOnValidEdit commit))))

(defn clone
  "Creates a copy of the DefaultFormatter.

  returns: copy of the DefaultFormatter - `java.lang.Object`

  throws: java.lang.CloneNotSupportedException - if the object's class does not support the Cloneable interface. Subclasses that override the clone method can also throw this exception to indicate that an instance cannot be cloned."
  (^java.lang.Object [^DefaultFormatter this]
    (-> this (.clone))))

(defn value-to-string
  "Converts the passed in Object into a String by way of the
   toString method.

  value - Value to convert - `java.lang.Object`

  returns: String representation of value - `java.lang.String`

  throws: java.text.ParseException - if there is an error in the conversion"
  (^java.lang.String [^DefaultFormatter this ^java.lang.Object value]
    (-> this (.valueToString value))))

(defn get-commits-on-valid-edit?
  "Returns when edits are published back to the
   JFormattedTextField.

  returns: true if edits are committed after every valid edit - `boolean`"
  (^Boolean [^DefaultFormatter this]
    (-> this (.getCommitsOnValidEdit))))

(defn get-overwrite-mode?
  "Returns the behavior when inserting characters.

  returns: true if newly inserted characters overwrite existing characters - `boolean`"
  (^Boolean [^DefaultFormatter this]
    (-> this (.getOverwriteMode))))

