(ns javax.print.attribute.DocAttributeSet
  "Interface DocAttributeSet specifies the interface for a set of doc
  attributes, i.e. printing attributes that implement interface DocAttribute. In the Print Service API, the client uses a
  DocAttributeSet to specify the characteristics of an individual doc and
  the print job settings to be applied to an individual doc.

  A DocAttributeSet is just an AttributeSet whose
  constructors and mutating operations guarantee an additional invariant,
  namely that all attribute values in the DocAttributeSet must be instances
  of interface DocAttribute.
  The add(Attribute), and
  addAll(AttributeSet) operations
  are respecified below to guarantee this additional invariant."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute DocAttributeSet]))

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
  ([this attribute]
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
  ([this attributes]
    (-> this (.addAll attributes))))

