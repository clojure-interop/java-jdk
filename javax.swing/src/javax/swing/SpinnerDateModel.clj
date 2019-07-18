(ns javax.swing.SpinnerDateModel
  "A SpinnerModel for sequences of Dates.
  The upper and lower bounds of the sequence are defined by properties called
  start and end and the size
  of the increase or decrease computed by the nextValue
  and previousValue methods is defined by a property
  called calendarField.  The start
  and end properties can be null to
  indicate that the sequence has no lower or upper limit.

  The value of the calendarField property must be one of the
  java.util.Calendar constants that specify a field
  within a Calendar.  The getNextValue
  and getPreviousValue
  methods change the date forward or backwards by this amount.
  For example, if calendarField is Calendar.DAY_OF_WEEK,
  then nextValue produces a Date that's 24
  hours after the current value, and previousValue
  produces a Date that's 24 hours earlier.

  The legal values for calendarField are:

    Calendar.ERA
    Calendar.YEAR
    Calendar.MONTH
    Calendar.WEEK_OF_YEAR
    Calendar.WEEK_OF_MONTH
    Calendar.DAY_OF_MONTH
    Calendar.DAY_OF_YEAR
    Calendar.DAY_OF_WEEK
    Calendar.DAY_OF_WEEK_IN_MONTH
    Calendar.AM_PM
    Calendar.HOUR
    Calendar.HOUR_OF_DAY
    Calendar.MINUTE
    Calendar.SECOND
    Calendar.MILLISECOND

  However some UIs may set the calendarField before committing the edit
  to spin the field under the cursor. If you only want one field to
  spin you can subclass and ignore the setCalendarField calls.

  This model inherits a ChangeListener.  The
  ChangeListeners are notified whenever the models
  value, calendarField,
  start, or end properties changes."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing SpinnerDateModel]))

(defn ->spinner-date-model
  "Constructor.

  Creates a SpinnerDateModel that represents a sequence of dates
   between start and end.  The
   nextValue and previousValue methods
   compute elements of the sequence by advancing or reversing
   the current date value by the
   calendarField time unit.  For a precise description
   of what it means to increment or decrement a Calendar
   field, see the add method in
   java.util.Calendar.

   The start and end parameters can be
   null to indicate that the range doesn't have an
   upper or lower bound.  If value or
   calendarField is null, or if both
   start and end are specified and
   minimum > maximum then an
   IllegalArgumentException is thrown.
   Similarly if (minimum <= value <= maximum) is false,
   an IllegalArgumentException is thrown.

  value - the current (non null) value of the model - `java.util.Date`
  start - the first date in the sequence or null - `java.lang.Comparable`
  end - the last date in the sequence or null - `java.lang.Comparable`
  calendar-field - one of Calendar.ERA Calendar.YEAR Calendar.MONTH Calendar.WEEK_OF_YEAR Calendar.WEEK_OF_MONTH Calendar.DAY_OF_MONTH Calendar.DAY_OF_YEAR Calendar.DAY_OF_WEEK Calendar.DAY_OF_WEEK_IN_MONTH Calendar.AM_PM Calendar.HOUR Calendar.HOUR_OF_DAY Calendar.MINUTE Calendar.SECOND Calendar.MILLISECOND - `int`

  throws: java.lang.IllegalArgumentException - if value or calendarField are null, if calendarField isn't valid, or if the following expression is false: (start <= value <= end)."
  (^SpinnerDateModel [^java.util.Date value ^java.lang.Comparable start ^java.lang.Comparable end ^Integer calendar-field]
    (new SpinnerDateModel value start end calendar-field))
  (^SpinnerDateModel []
    (new SpinnerDateModel )))

(defn get-previous-value
  "Returns the previous Date in the sequence, or null
   if the previous date is before start.

  returns: the previous Date in the sequence, or
       null if the previous date
       is before start - `java.lang.Object`"
  (^java.lang.Object [^SpinnerDateModel this]
    (-> this (.getPreviousValue))))

(defn set-calendar-field
  "Changes the size of the date value change computed
   by the nextValue and previousValue methods.
   The calendarField parameter must be one of the
   Calendar field constants like Calendar.MONTH
   or Calendar.MINUTE.
   The nextValue and previousValue methods
   simply move the specified Calendar field forward or backward
   by one unit with the Calendar.add method.
   You should use this method with care as some UIs may set the
   calendarField before committing the edit to spin the field under
   the cursor. If you only want one field to spin you can subclass
   and ignore the setCalendarField calls.

  calendar-field - one of Calendar.ERA Calendar.YEAR Calendar.MONTH Calendar.WEEK_OF_YEAR Calendar.WEEK_OF_MONTH Calendar.DAY_OF_MONTH Calendar.DAY_OF_YEAR Calendar.DAY_OF_WEEK Calendar.DAY_OF_WEEK_IN_MONTH Calendar.AM_PM Calendar.HOUR Calendar.HOUR_OF_DAY Calendar.MINUTE Calendar.SECOND Calendar.MILLISECOND This method fires a ChangeEvent if the calendarField has changed. - `int`"
  ([^SpinnerDateModel this ^Integer calendar-field]
    (-> this (.setCalendarField calendar-field))))

(defn get-value
  "Returns the current element in this sequence of Dates.

  returns: the value property - `java.lang.Object`"
  (^java.lang.Object [^SpinnerDateModel this]
    (-> this (.getValue))))

(defn get-date
  "Returns the current element in this sequence of Dates.
   This method is equivalent to (Date)getValue.

  returns: the value property - `java.util.Date`"
  (^java.util.Date [^SpinnerDateModel this]
    (-> this (.getDate))))

(defn get-calendar-field
  "Returns the Calendar field that is added to or subtracted from
   by the nextValue and previousValue methods.

  returns: the value of the calendarField property - `int`"
  (^Integer [^SpinnerDateModel this]
    (-> this (.getCalendarField))))

(defn get-end
  "Returns the last Date in the sequence.

  returns: the value of the end property - `java.lang.Comparable`"
  (^java.lang.Comparable [^SpinnerDateModel this]
    (-> this (.getEnd))))

(defn set-end
  "Changes the upper limit for Dates in this sequence.
   If start is null, then there is no upper
   limit.  No bounds checking is done here: the new
   start value may invalidate the (start <= value <= end)
   invariant enforced by the constructors.  This is to simplify updating
   the model.  Naturally, one should ensure that the invariant is true
   before calling the nextValue, previousValue,
   or setValue methods.

   Typically this property is a Date however it's possible to use
   Comparable with a compareTo method for
   Dates.  See setStart for an example.

   This method fires a ChangeEvent if the end
   has changed.

  end - defines the last date in the sequence - `java.lang.Comparable`"
  ([^SpinnerDateModel this ^java.lang.Comparable end]
    (-> this (.setEnd end))))

(defn set-value
  "Sets the current Date for this sequence.
   If value is null,
   an IllegalArgumentException is thrown.  No bounds
   checking is done here:
   the new value may invalidate the (start <= value < end)
   invariant enforced by the constructors.  Naturally, one should ensure
   that the (start <= value <= maximum) invariant is true
   before calling the nextValue, previousValue,
   or setValue methods.

   This method fires a ChangeEvent if the
   value has changed.

  value - the current (non null) Date for this sequence - `java.lang.Object`

  throws: java.lang.IllegalArgumentException - if value is null or not a Date"
  ([^SpinnerDateModel this ^java.lang.Object value]
    (-> this (.setValue value))))

(defn get-start
  "Returns the first Date in the sequence.

  returns: the value of the start property - `java.lang.Comparable`"
  (^java.lang.Comparable [^SpinnerDateModel this]
    (-> this (.getStart))))

(defn set-start
  "Changes the lower limit for Dates in this sequence.
   If start is null,
   then there is no lower limit.  No bounds checking is done here:
   the new start value may invalidate the
   (start <= value <= end)
   invariant enforced by the constructors.  This is to simplify updating
   the model.  Naturally one should ensure that the invariant is true
   before calling the nextValue, previousValue,
   or setValue methods.

   Typically this property is a Date however it's possible to use
   a Comparable with a compareTo method for Dates.
   For example start might be an instance of a class like this:


   MyStartDate implements Comparable {
       long t = 12345;
       public int compareTo(Date d) {
              return (t < d.getTime() ? -1 : (t == d.getTime() ? 0 : 1));
       }
       public int compareTo(Object o) {
              return compareTo((Date)o);
       }
   }
   Note that the above example will throw a ClassCastException
   if the Object passed to compareTo(Object)
   is not a Date.

   This method fires a ChangeEvent if the
   start has changed.

  start - defines the first date in the sequence - `java.lang.Comparable`"
  ([^SpinnerDateModel this ^java.lang.Comparable start]
    (-> this (.setStart start))))

(defn get-next-value
  "Returns the next Date in the sequence, or null if
   the next date is after end.

  returns: the next Date in the sequence, or null if
       the next date is after end. - `java.lang.Object`"
  (^java.lang.Object [^SpinnerDateModel this]
    (-> this (.getNextValue))))

