(ns javax.swing.SpinnerListModel
  "A simple implementation of SpinnerModel whose
  values are defined by an array or a List.
  For example to create a model defined by
  an array of the names of the days of the week:


  String[] days = new DateFormatSymbols().getWeekdays();
  SpinnerModel model = new SpinnerListModel(Arrays.asList(days).subList(1, 8));
  This class only stores a reference to the array or List
  so if an element of the underlying sequence changes, it's up
  to the application to notify the ChangeListeners by calling
  fireStateChanged.

  This model inherits a ChangeListener.
  The ChangeListeners are notified whenever the
  model's value or list properties changes."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing SpinnerListModel]))

(defn ->spinner-list-model
  "Constructor.

  Constructs a SpinnerModel whose sequence of
   values is defined by the specified List.
   The initial value (current element)
   of the model will be values.get(0).
   If values is null or has zero
   size, an IllegalArugmentException is thrown.

  values - the sequence this model represents - `java.util.List`

  throws: java.lang.IllegalArgumentException - if values is null or zero size"
  (^SpinnerListModel [^java.util.List values]
    (new SpinnerListModel values))
  (^SpinnerListModel []
    (new SpinnerListModel )))

(defn get-list
  "Returns the List that defines the sequence for this model.

  returns: the value of the list property - `java.util.List<?>`"
  (^java.util.List [^SpinnerListModel this]
    (-> this (.getList))))

(defn set-list
  "Changes the list that defines this sequence and resets the index
   of the models value to zero.  Note that list
   is not copied, the model just stores a reference to it.

   This method fires a ChangeEvent if list is
   not equal to the current list.

  list - the sequence that this model represents - `java.util.List`

  throws: java.lang.IllegalArgumentException - if list is null or zero length"
  ([^SpinnerListModel this ^java.util.List list]
    (-> this (.setList list))))

(defn get-value
  "Returns the current element of the sequence.

  returns: the value property - `java.lang.Object`"
  (^java.lang.Object [^SpinnerListModel this]
    (-> this (.getValue))))

(defn set-value
  "Changes the current element of the sequence and notifies
   ChangeListeners.  If the specified
   value is not equal to an element of the underlying sequence
   then an IllegalArgumentException is thrown.
   In the following example the setValue call
   would cause an exception to be thrown:


   String[] values = {\"one\", \"two\", \"free\", \"four\"};
   SpinnerModel model = new SpinnerListModel(values);
   model.setValue(\"TWO\");

  elt - the sequence element that will be model's current value - `java.lang.Object`

  throws: java.lang.IllegalArgumentException - if the specified value isn't allowed"
  ([^SpinnerListModel this ^java.lang.Object elt]
    (-> this (.setValue elt))))

(defn get-next-value
  "Returns the next legal value of the underlying sequence or
   null if value is already the last element.

  returns: the next legal value of the underlying sequence or
       null if value is already the last element - `java.lang.Object`"
  (^java.lang.Object [^SpinnerListModel this]
    (-> this (.getNextValue))))

(defn get-previous-value
  "Returns the previous element of the underlying sequence or
   null if value is already the first element.

  returns: the previous element of the underlying sequence or
       null if value is already the first element - `java.lang.Object`"
  (^java.lang.Object [^SpinnerListModel this]
    (-> this (.getPreviousValue))))

