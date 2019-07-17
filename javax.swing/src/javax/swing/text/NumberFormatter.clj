(ns javax.swing.text.NumberFormatter
  "NumberFormatter subclasses InternationalFormatter
  adding special behavior for numbers. Among the specializations are
  (these are only used if the NumberFormatter does not display
  invalid numbers, for example, setAllowsInvalid(false)):

    Pressing /- (- is determined from the
        DecimalFormatSymbols associated with the
        DecimalFormat) in any field but the exponent
        field will attempt to change the sign of the number to
        positive/negative.
    Pressing /- (- is determined from the
        DecimalFormatSymbols associated with the
        DecimalFormat) in the exponent field will
        attempt to change the sign of the exponent to positive/negative.


  If you are displaying scientific numbers, you may wish to turn on
  overwrite mode, setOverwriteMode(true). For example:


  DecimalFormat decimalFormat = new DecimalFormat(`0.000E0`);
  NumberFormatter textFormatter = new NumberFormatter(decimalFormat);
  textFormatter.setOverwriteMode(true);
  textFormatter.setAllowsInvalid(false);

  If you are going to allow the user to enter decimal
  values, you should either force the DecimalFormat to contain at least
  one decimal (#.0###), or allow the value to be invalid
  setAllowsInvalid(true). Otherwise users may not be able to
  input decimal values.

  NumberFormatter provides slightly different behavior to
  stringToValue than that of its superclass. If you have
  specified a Class for values, DefaultFormatter.setValueClass(java.lang.Class<?>), that is one of
  of Integer, Long, Float,
  Double, Byte or Short and
  the Format's parseObject returns an instance of
  Number, the corresponding instance of the value class
  will be created using the constructor appropriate for the primitive
  type the value class represents. For example:
  setValueClass(Integer.class) will cause the resulting
  value to be created via
  new Integer(((Number)formatter.parseObject(string)).intValue()).
  This is typically useful if you
  wish to set a min/max value as the various Number
  implementations are generally not comparable to each other. This is also
  useful if for some reason you need a specific Number
  implementation for your values.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text NumberFormatter]))

(defn ->number-formatter
  "Constructor.

  Creates a NumberFormatter with the specified Format instance.

  format - Format used to dictate legal values - `java.text.NumberFormat`"
  ([format]
    (new NumberFormatter format))
  ([]
    (new NumberFormatter )))

(defn set-format
  "Sets the format that dictates the legal values that can be edited
   and displayed.

   If you have used the nullary constructor the value of this property
   will be determined for the current locale by way of the
   NumberFormat.getNumberInstance() method.

  format - NumberFormat instance used to dictate legal values - `java.text.Format`"
  ([this format]
    (-> this (.setFormat format))))

