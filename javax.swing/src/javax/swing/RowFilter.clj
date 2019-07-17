(ns javax.swing.RowFilter
  "RowFilter is used to filter out entries from the
  model so that they are not shown in the view.  For example, a
  RowFilter associated with a JTable might
  only allow rows that contain a column with a specific string. The
  meaning of entry depends on the component type.
  For example, when a filter is
  associated with a JTable, an entry corresponds to a
  row; when associated with a JTree, an entry corresponds
  to a node.

  Subclasses must override the include method to
  indicate whether the entry should be shown in the
  view.  The Entry argument can be used to obtain the values in
  each of the columns in that entry.  The following example shows an
  include method that allows only entries containing one or
  more values starting with the string `a`:


  RowFilter<Object,Object> startsWithAFilter = new RowFilter<Object,Object>() {
    public boolean include(Entry<? extends Object, ? extends Object> entry) {
      for (int i = entry.getValueCount() - 1; i >= 0; i--) {
        if (entry.getStringValue(i).startsWith(`a`)) {
          // The value starts with `a`, include it
          return true;
        }
      }
      // None of the columns start with `a`; return false so that this
      // entry is not shown
      return false;
    }
  };
  RowFilter has two formal type parameters that allow
  you to create a RowFilter for a specific model. For
  example, the following assumes a specific model that is wrapping
  objects of type Person.  Only Persons
  with an age over 20 will be shown:


  RowFilter<PersonModel,Integer> ageFilter = new RowFilter<PersonModel,Integer>() {
    public boolean include(Entry<? extends PersonModel, ? extends Integer> entry) {
      PersonModel personModel = entry.getModel();
      Person person = personModel.getPerson(entry.getIdentifier());
      if (person.getAge() > 20) {
        // Returning true indicates this row should be shown.
        return true;
      }
      // Age is <= 20, don't show it.
      return false;
    }
  };
  PersonModel model = createPersonModel();
  TableRowSorter<PersonModel> sorter = new TableRowSorter<PersonModel>(model);
  sorter.setRowFilter(ageFilter);"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing RowFilter]))

(defn ->row-filter
  "Constructor."
  ([]
    (new RowFilter )))

(defn *regex-filter
  "Returns a RowFilter that uses a regular
   expression to determine which entries to include.  Only entries
   with at least one matching value are included.  For
   example, the following creates a RowFilter that
   includes entries with at least one value starting with
   `a`:


     RowFilter.regexFilter(`^a`);

   The returned filter uses Matcher.find()
   to test for inclusion.  To test for exact matches use the
   characters '^' and '$' to match the beginning and end of the
   string respectively.  For example, `^foo$` includes only rows whose
   string is exactly `foo` and not, for example, `food`.  See
   Pattern for a complete description of
   the supported regular-expression constructs.

  regex - the regular expression to filter on - `java.lang.String`
  indices - the indices of the values to check. If not supplied all values are evaluated - `int`

  returns: a RowFilter implementing the specified criteria - `<M,I> javax.swing.RowFilter<M,I>`

  throws: java.lang.NullPointerException - if regex is null"
  ([regex indices]
    (RowFilter/regexFilter regex indices)))

(defn *date-filter
  "Returns a RowFilter that includes entries that
   have at least one Date value meeting the specified
   criteria.  For example, the following RowFilter includes
   only entries with at least one date value after the current date:


     RowFilter.dateFilter(ComparisonType.AFTER, new Date());

  type - the type of comparison to perform - `javax.swing.RowFilter.ComparisonType`
  date - the date to compare against - `java.util.Date`
  indices - the indices of the values to check. If not supplied all values are evaluated - `int`

  returns: a RowFilter implementing the specified criteria - `<M,I> javax.swing.RowFilter<M,I>`

  throws: java.lang.NullPointerException - if date is null"
  ([type date indices]
    (RowFilter/dateFilter type date indices)))

(defn *number-filter
  "Returns a RowFilter that includes entries that
   have at least one Number value meeting the
   specified criteria.  For example, the following
   filter will only include entries with at
   least one number value equal to 10:


     RowFilter.numberFilter(ComparisonType.EQUAL, 10);

  type - the type of comparison to perform - `javax.swing.RowFilter.ComparisonType`
  number - `java.lang.Number`
  indices - the indices of the values to check. If not supplied all values are evaluated - `int`

  returns: a RowFilter implementing the specified criteria - `<M,I> javax.swing.RowFilter<M,I>`

  throws: java.lang.IllegalArgumentException - if any of the indices are < 0, type is null or number is null"
  ([type number indices]
    (RowFilter/numberFilter type number indices)))

(defn *or-filter
  "Returns a RowFilter that includes entries if any
   of the supplied filters includes the entry.

   The following example creates a RowFilter that will
   include any entries containing the string `foo` or the string
   `bar`:


     List<RowFilter<Object,Object>> filters = new ArrayList<RowFilter<Object,Object>>(2);
     filters.add(RowFilter.regexFilter(`foo`));
     filters.add(RowFilter.regexFilter(`bar`));
     RowFilter<Object,Object> fooBarFilter = RowFilter.orFilter(filters);

  filters - the RowFilters to test - `I>>`

  returns: a RowFilter implementing the specified criteria - `<M,I> javax.swing.RowFilter<M,I>`

  throws: java.lang.IllegalArgumentException - if any of the filters are null"
  ([filters]
    (RowFilter/orFilter filters)))

(defn *and-filter
  "Returns a RowFilter that includes entries if all
   of the supplied filters include the entry.

   The following example creates a RowFilter that will
   include any entries containing the string `foo` and the string
   `bar`:


     List<RowFilter<Object,Object>> filters = new ArrayList<RowFilter<Object,Object>>(2);
     filters.add(RowFilter.regexFilter(`foo`));
     filters.add(RowFilter.regexFilter(`bar`));
     RowFilter<Object,Object> fooBarFilter = RowFilter.andFilter(filters);

  filters - the RowFilters to test - `I>>`

  returns: a RowFilter implementing the specified criteria - `<M,I> javax.swing.RowFilter<M,I>`

  throws: java.lang.IllegalArgumentException - if any of the filters are null"
  ([filters]
    (RowFilter/andFilter filters)))

(defn *not-filter
  "Returns a RowFilter that includes entries if the
   supplied filter does not include the entry.

  filter - the RowFilter to negate - `javax.swing.RowFilter<M,I>`

  returns: a RowFilter implementing the specified criteria - `<M,I> javax.swing.RowFilter<M,I>`

  throws: java.lang.IllegalArgumentException - if filter is null"
  ([filter]
    (RowFilter/notFilter filter)))

(defn include
  "Returns true if the specified entry should be shown;
   returns false if the entry should be hidden.

   The entry argument is valid only for the duration of
   the invocation.  Using entry after the call returns
   results in undefined behavior.

  entry - a non-null object that wraps the underlying object from the model - `RowFilter.I>`

  returns: true if the entry should be shown - `boolean`"
  ([this entry]
    (-> this (.include entry))))

