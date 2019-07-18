(ns javax.swing.text.InternationalFormatter
  "InternationalFormatter extends DefaultFormatter,
  using an instance of java.text.Format to handle the
  conversion to a String, and the conversion from a String.

  If getAllowsInvalid() is false, this will ask the
  Format to format the current text on every edit.

  You can specify a minimum and maximum value by way of the
  setMinimum and setMaximum methods. In order
  for this to work the values returned from stringToValue must be
  comparable to the min/max values by way of the Comparable
  interface.

  Be careful how you configure the Format and the
  InternationalFormatter, as it is possible to create a
  situation where certain values can not be input. Consider the date
  format 'M/d/yy', an InternationalFormatter that is always
  valid (setAllowsInvalid(false)), is in overwrite mode
  (setOverwriteMode(true)) and the date 7/1/99. In this
  case the user will not be able to enter a two digit month or day of
  month. To avoid this, the format should be 'MM/dd/yy'.

  If InternationalFormatter is configured to only allow valid
  values (setAllowsInvalid(false)), every valid edit will result
  in the text of the JFormattedTextField being completely reset
  from the Format.
  The cursor position will also be adjusted as literal characters are
  added/removed from the resulting String.

  InternationalFormatter's behavior of
  stringToValue is  slightly different than that of
  DefaultTextFormatter, it does the following:

    parseObject is invoked on the Format
        specified by setFormat
    If a Class has been set for the values (setValueClass),
        supers implementation is invoked to convert the value returned
        from parseObject to the appropriate class.
    If a ParseException has not been thrown, and the value
        is outside the min/max a ParseException is thrown.
    The value is returned.

  InternationalFormatter implements stringToValue
  in this manner so that you can specify an alternate Class than
  Format may return.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text InternationalFormatter]))

(defn ->international-formatter
  "Constructor.

  Creates an InternationalFormatter with the specified
   Format instance.

  format - Format instance used for converting from/to Strings - `java.text.Format`"
  (^InternationalFormatter [^java.text.Format format]
    (new InternationalFormatter format))
  (^InternationalFormatter []
    (new InternationalFormatter )))

(defn string-to-value
  "Returns the Object representation of the
   String text.

  text - String to convert - `java.lang.String`

  returns: Object representation of text - `java.lang.Object`

  throws: java.text.ParseException - if there is an error in the conversion"
  (^java.lang.Object [^InternationalFormatter this ^java.lang.String text]
    (-> this (.stringToValue text))))

(defn get-minimum
  "Returns the minimum permissible value.

  returns: Minimum legal value that can be input - `java.lang.Comparable`"
  (^java.lang.Comparable [^InternationalFormatter this]
    (-> this (.getMinimum))))

(defn set-format
  "Sets the format that dictates the legal values that can be edited
   and displayed.

  format - Format instance used for converting from/to Strings - `java.text.Format`"
  ([^InternationalFormatter this ^java.text.Format format]
    (-> this (.setFormat format))))

(defn set-maximum
  "Sets the maximum permissible value. If the valueClass has
   not been specified, and max is non null, the
   valueClass will be set to that of the class of
   max.

  max - Maximum legal value that can be input - `java.lang.Comparable`"
  ([^InternationalFormatter this ^java.lang.Comparable max]
    (-> this (.setMaximum max))))

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
  ([^InternationalFormatter this ^javax.swing.JFormattedTextField ftf]
    (-> this (.install ftf))))

(defn get-format
  "Returns the format that dictates the legal values that can be edited
   and displayed.

  returns: Format instance used for converting from/to Strings - `java.text.Format`"
  (^java.text.Format [^InternationalFormatter this]
    (-> this (.getFormat))))

(defn clone
  "Creates a copy of the DefaultFormatter.

  returns: copy of the DefaultFormatter - `java.lang.Object`

  throws: java.lang.CloneNotSupportedException - if the object's class does not support the Cloneable interface. Subclasses that override the clone method can also throw this exception to indicate that an instance cannot be cloned."
  (^java.lang.Object [^InternationalFormatter this]
    (-> this (.clone))))

(defn value-to-string
  "Returns a String representation of the Object value.
   This invokes format on the current Format.

  value - Value to convert - `java.lang.Object`

  returns: String representation of value - `java.lang.String`

  throws: java.text.ParseException - if there is an error in the conversion"
  (^java.lang.String [^InternationalFormatter this ^java.lang.Object value]
    (-> this (.valueToString value))))

(defn get-fields
  "Returns the Format.Field constants associated with
   the text at offset. If offset is not
   a valid location into the current text, this will return an
   empty array.

  offset - offset into text to be examined - `int`

  returns: Format.Field constants associated with the text at the
           given position. - `java.text.Format$Field[]`"
  ([^InternationalFormatter this ^Integer offset]
    (-> this (.getFields offset))))

(defn set-minimum
  "Sets the minimum permissible value. If the valueClass has
   not been specified, and minimum is non null, the
   valueClass will be set to that of the class of
   minimum.

  minimum - Minimum legal value that can be input - `java.lang.Comparable`"
  ([^InternationalFormatter this ^java.lang.Comparable minimum]
    (-> this (.setMinimum minimum))))

(defn get-maximum
  "Returns the maximum permissible value.

  returns: Maximum legal value that can be input - `java.lang.Comparable`"
  (^java.lang.Comparable [^InternationalFormatter this]
    (-> this (.getMaximum))))

