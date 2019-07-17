(ns javax.print.attribute.PrintJobAttributeSet
  "Interface PrintJobAttributeSet specifies the interface for a set of print
  job attributes, i.e. printing attributes that implement interface PrintJobAttribute. In the Print Service API, a
  service uses a PrintJobAttributeSet to report the status of a print job.

  A PrintJobAttributeSet is just an AttributeSet whose
  constructors and mutating operations guarantee an additional invariant,
  namely that all attribute values in the PrintJobAttributeSet must be
  instances of interface PrintJobAttribute.
  The add(Attribute), and
  >addAll(AttributeSet) operations
  are respecified below to guarantee this additional invariant."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute PrintJobAttributeSet]))

(defn add
  "Adds the specified attribute value to this attribute set if it is not
   already present, first removing any existing value in the same
   attribute category as the specified attribute value (optional
   operation).

  attribute - Attribute value to be added to this attribute set. - `javax.print.attribute.Attribute`

  returns: true if this attribute set changed as a result of
            the call, i.e., the given attribute value was not already a
            member of this attribute set. - `boolean`

  throws: javax.print.attribute.UnmodifiableSetException - (unchecked exception) Thrown if this attribute set does not support the add() operation."
  (^Boolean [^javax.print.attribute.PrintJobAttributeSet this ^javax.print.attribute.Attribute attribute]
    (-> this (.add attribute))))

(defn add-all
  "Adds all of the elements in the specified set to this attribute.
   The outcome is  the same as if the
   add(Attribute)
   operation had been applied to this attribute set successively with
   each element from the specified set. If none of the categories in the
   specified set  are the same as any categories in this attribute set,
   the addAll() operation effectively modifies this attribute
   set so that its value is the union of the two sets.

   The behavior of the addAll() operation is unspecified if
   the specified set is modified while the operation is in progress.

   If the addAll() operation throws an exception, the effect
   on this attribute set's state is implementation dependent; elements
   from the specified set before the point of the exception may or
   may not have been added to this attribute set.

  attributes - whose elements are to be added to this attribute set. - `javax.print.attribute.AttributeSet`

  returns: true if this attribute set changed as a result of
            the call. - `boolean`

  throws: javax.print.attribute.UnmodifiableSetException - (Unchecked exception) Thrown if this attribute set does not support the addAll() method."
  (^Boolean [^javax.print.attribute.PrintJobAttributeSet this ^javax.print.attribute.AttributeSet attributes]
    (-> this (.addAll attributes))))

