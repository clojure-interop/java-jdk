(ns javax.swing.JFormattedTextField$AbstractFormatter
  "Instances of AbstractFormatter are used by
  JFormattedTextField to handle the conversion both
  from an Object to a String, and back from a String to an Object.
  AbstractFormatters can also enforce editing policies,
  or navigation policies, or manipulate the
  JFormattedTextField in any way it sees fit to
  enforce the desired policy.

  An AbstractFormatter can only be active in
  one JFormattedTextField at a time.
  JFormattedTextField invokes
  install when it is ready to use it followed
  by uninstall when done. Subclasses
  that wish to install additional state should override
  install and message super appropriately.

  Subclasses must override the conversion methods
  stringToValue and valueToString. Optionally
  they can override getActions,
  getNavigationFilter and getDocumentFilter
  to restrict the JFormattedTextField in a particular
  way.

  Subclasses that allow the JFormattedTextField to be in
  a temporarily invalid state should invoke setEditValid
  at the appropriate times."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing JFormattedTextField$AbstractFormatter]))

(defn ->abstract-formatter
  "Constructor."
  ([]
    (new JFormattedTextField$AbstractFormatter )))

(defn install
  "Installs the AbstractFormatter onto a particular
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
   state changes.  You will only need to invoke this yourself if
   you are subclassing JFormattedTextField and
   installing/uninstalling AbstractFormatter at a
   different time than JFormattedTextField does.

  ftf - JFormattedTextField to format for, may be null indicating uninstall from current JFormattedTextField. - `javax.swing.JFormattedTextField`"
  ([^javax.swing.JFormattedTextField$AbstractFormatter this ^javax.swing.JFormattedTextField ftf]
    (-> this (.install ftf))))

(defn uninstall
  "Uninstalls any state the AbstractFormatter may have
   installed on the JFormattedTextField. This resets the
   DocumentFilter, NavigationFilter
   and additional Actions installed on the
   JFormattedTextField."
  ([^javax.swing.JFormattedTextField$AbstractFormatter this]
    (-> this (.uninstall))))

(defn string-to-value
  "Parses text returning an arbitrary Object. Some
   formatters may return null.

  text - String to convert - `java.lang.String`

  returns: Object representation of text - `java.lang.Object`

  throws: java.text.ParseException - if there is an error in the conversion"
  ([^javax.swing.JFormattedTextField$AbstractFormatter this ^java.lang.String text]
    (-> this (.stringToValue text))))

(defn value-to-string
  "Returns the string value to display for value.

  value - Value to convert - `java.lang.Object`

  returns: String representation of value - `java.lang.String`

  throws: java.text.ParseException - if there is an error in the conversion"
  ([^javax.swing.JFormattedTextField$AbstractFormatter this ^java.lang.Object value]
    (-> this (.valueToString value))))

