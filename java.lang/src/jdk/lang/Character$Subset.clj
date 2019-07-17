(ns jdk.lang.Character$Subset
  "Instances of this class represent particular subsets of the Unicode
  character set.  The only family of subsets defined in the
  Character class is Character.UnicodeBlock.
  Other portions of the Java API may define other subsets for their
  own purposes."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang Character$Subset]))

(defn equals
  "Compares two Subset objects for equality.
   This method returns true if and only if
   this and the argument refer to the same
   object; since this method is final, this
   guarantee holds for all subclasses.

  obj - the reference object with which to compare. - `java.lang.Object`

  returns: true if this object is the same as the obj
            argument; false otherwise. - `boolean`"
  ([^java.lang.Character$Subset this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn hash-code
  "Returns the standard hash code as defined by the
   Object.hashCode() method.  This method
   is final in order to ensure that the
   equals and hashCode methods will
   be consistent in all subclasses.

  returns: a hash code value for this object. - `int`"
  ([^java.lang.Character$Subset this]
    (-> this (.hashCode))))

(defn to-string
  "Returns the name of this subset.

  returns: a string representation of the object. - `java.lang.String`"
  ([^java.lang.Character$Subset this]
    (-> this (.toString))))

