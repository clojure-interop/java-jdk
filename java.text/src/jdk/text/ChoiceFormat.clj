(ns jdk.text.ChoiceFormat
  "A ChoiceFormat allows you to attach a format to a range of numbers.
  It is generally used in a MessageFormat for handling plurals.
  The choice is specified with an ascending list of doubles, where each item
  specifies a half-open interval up to the next item:



  X matches j if and only if limit[j] ≤ X < limit[j+1]

  If there is no match, then either the first or last index is used, depending
  on whether the number (X) is too low or too high.  If the limit array is not
  in ascending order, the results of formatting will be incorrect.  ChoiceFormat
  also accepts \u221E as equivalent to infinity(INF).


  Note:
  ChoiceFormat differs from the other Format
  classes in that you create a ChoiceFormat object with a
  constructor (not with a getInstance style factory
  method). The factory methods aren't necessary because ChoiceFormat
  doesn't require any complex setup for a given locale. In fact,
  ChoiceFormat doesn't implement any locale specific behavior.


  When creating a ChoiceFormat, you must specify an array of formats
  and an array of limits. The length of these arrays must be the same.
  For example,


      limits = {1,2,3,4,5,6,7}
      formats = {`Sun`,`Mon`,`Tue`,`Wed`,`Thur`,`Fri`,`Sat`}

      limits = {0, 1, ChoiceFormat.nextDouble(1)}
      formats = {`no files`, `one file`, `many files`}
      (nextDouble can be used to get the next higher double, to
      make the half-open interval.)



  Here is a simple example that shows formatting and parsing:



  double[] limits = {1,2,3,4,5,6,7};
  String[] dayOfWeekNames = {`Sun`,`Mon`,`Tue`,`Wed`,`Thur`,`Fri`,`Sat`};
  ChoiceFormat form = new ChoiceFormat(limits, dayOfWeekNames);
  ParsePosition status = new ParsePosition(0);
  for (double i = 0.0; i <= 8.0; +i) {
      status.setIndex(0);
      System.out.println(i  ` -> `  form.format(i)  ` -> `
                                form.parse(form.format(i),status));
  }

  Here is a more complex example, with a pattern format:



  double[] filelimits = {0,1,2};
  String[] filepart = {`are no files`,`is one file`,`are {2} files`};
  ChoiceFormat fileform = new ChoiceFormat(filelimits, filepart);
  Format[] testFormats = {fileform, null, NumberFormat.getInstance()};
  MessageFormat pattform = new MessageFormat(`There {0} on {1}`);
  pattform.setFormats(testFormats);
  Object[] testArgs = {null, `ADisk`, null};
  for (int i = 0; i < 4; +i) {
      testArgs[0] = new Integer(i);
      testArgs[2] = testArgs[0];
      System.out.println(pattform.format(testArgs));
  }


  Specifying a pattern for ChoiceFormat objects is fairly straightforward.
  For example:



  ChoiceFormat fmt = new ChoiceFormat(
       `-1#is negative| 0#is zero or fraction | 1#is one |1.0<is 1+ |2#is two |2<is more than 2.`);
  System.out.println(`Formatter Pattern : `  fmt.toPattern());

  System.out.println(`Format with -INF : `  fmt.format(Double.NEGATIVE_INFINITY));
  System.out.println(`Format with -1.0 : `  fmt.format(-1.0));
  System.out.println(`Format with 0 : `  fmt.format(0));
  System.out.println(`Format with 0.9 : `  fmt.format(0.9));
  System.out.println(`Format with 1.0 : `  fmt.format(1));
  System.out.println(`Format with 1.5 : `  fmt.format(1.5));
  System.out.println(`Format with 2 : `  fmt.format(2));
  System.out.println(`Format with 2.1 : `  fmt.format(2.1));
  System.out.println(`Format with NaN : `  fmt.format(Double.NaN));
  System.out.println(`Format with INF : `  fmt.format(Double.POSITIVE_INFINITY));

  And the output result would be like the following:



  Format with -INF : is negative
  Format with -1.0 : is negative
  Format with 0 : is zero or fraction
  Format with 0.9 : is zero or fraction
  Format with 1.0 : is one
  Format with 1.5 : is 1+
  Format with 2 : is two
  Format with 2.1 : is more than 2.
  Format with NaN : is negative
  Format with INF : is more than 2.


  Synchronization


  Choice formats are not synchronized.
  It is recommended to create separate format instances for each thread.
  If multiple threads access a format concurrently, it must be synchronized
  externally."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.text ChoiceFormat]))

(defn ->choice-format
  "Constructor.

  Constructs with the limits and the corresponding formats.

  limits - limits in ascending order - `double[]`
  formats - corresponding format strings - `java.lang.String[]`"
  ([limits ^java.lang.String[] formats]
    (new ChoiceFormat limits formats))
  ([^java.lang.String new-pattern]
    (new ChoiceFormat new-pattern)))

(defn *next-double
  "Finds the least double greater than d (if positive is
   true), or the greatest double less than d (if
   positive is false).
   If NaN, returns same value.

   Does not affect floating-point flags,
   provided these member functions do not:
            Double.longBitsToDouble(long)
            Double.doubleToLongBits(double)
            Double.isNaN(double)

  d - the reference value - `double`
  positive - true if the least double is desired; false otherwise - `boolean`

  returns: the least or greater double value - `double`"
  ([^Double d ^Boolean positive]
    (ChoiceFormat/nextDouble d positive))
  ([^Double d]
    (ChoiceFormat/nextDouble d)))

(defn *previous-double
  "Finds the greatest double less than d.
   If NaN, returns same value.

  d - the reference value - `double`

  returns: the greatest double value less than d - `double`"
  ([^Double d]
    (ChoiceFormat/previousDouble d)))

(defn get-formats
  "Get the formats passed in the constructor.

  returns: the formats. - `java.lang.Object[]`"
  ([^java.text.ChoiceFormat this]
    (-> this (.getFormats))))

(defn get-limits
  "Get the limits passed in the constructor.

  returns: the limits. - `double[]`"
  ([^java.text.ChoiceFormat this]
    (-> this (.getLimits))))

(defn to-pattern
  "Gets the pattern.

  returns: the pattern string - `java.lang.String`"
  ([^java.text.ChoiceFormat this]
    (-> this (.toPattern))))

(defn set-choices
  "Set the choices to be used in formatting.

  limits - contains the top value that you want parsed with that format, and should be in ascending sorted order. When formatting X, the choice will be the i, where limit[i] ≤ X < limit[i+1]. If the limit array is not in ascending order, the results of formatting will be incorrect. - `double[]`
  formats - are the formats you want to use for each limit. They can be either Format objects or Strings. When formatting with object Y, if the object is a NumberFormat, then ((NumberFormat) Y).format(X) is called. Otherwise Y.toString() is called. - `java.lang.String[]`"
  ([^java.text.ChoiceFormat this limits ^java.lang.String[] formats]
    (-> this (.setChoices limits formats))))

(defn clone
  "Overrides Cloneable

  returns: a clone of this instance. - `java.lang.Object`"
  ([^java.text.ChoiceFormat this]
    (-> this (.clone))))

(defn parse
  "Parses a Number from the input text.

  text - the source text. - `java.lang.String`
  status - an input-output parameter. On input, the status.index field indicates the first character of the source text that should be parsed. On exit, if no error occurred, status.index is set to the first unparsed character in the source text. On exit, if an error did occur, status.index is unchanged and status.errorIndex is set to the first index of the character that caused the parse to fail. - `java.text.ParsePosition`

  returns: A Number representing the value of the number parsed. - `java.lang.Number`"
  ([^java.text.ChoiceFormat this ^java.lang.String text ^java.text.ParsePosition status]
    (-> this (.parse text status))))

(defn hash-code
  "Generates a hash code for the message format object.

  returns: a hash code value for this object. - `int`"
  ([^java.text.ChoiceFormat this]
    (-> this (.hashCode))))

(defn apply-pattern
  "Sets the pattern.

  new-pattern - See the class description. - `java.lang.String`"
  ([^java.text.ChoiceFormat this ^java.lang.String new-pattern]
    (-> this (.applyPattern new-pattern))))

(defn equals
  "Equality comparision between two

  obj - the reference object with which to compare. - `java.lang.Object`

  returns: true if this object is the same as the obj
            argument; false otherwise. - `boolean`"
  ([^java.text.ChoiceFormat this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn format
  "Specialization of format. This method really calls
   format(double, StringBuffer, FieldPosition)
   thus the range of longs that are supported is only equal to
   the range that can be stored by double. This will never be
   a practical limitation.

  number - the long number to format - `long`
  to-append-to - the StringBuffer to which the formatted text is to be appended - `java.lang.StringBuffer`
  status - the field position - `java.text.FieldPosition`

  returns: the formatted StringBuffer - `java.lang.StringBuffer`"
  ([^java.text.ChoiceFormat this ^Long number ^java.lang.StringBuffer to-append-to ^java.text.FieldPosition status]
    (-> this (.format number to-append-to status))))

