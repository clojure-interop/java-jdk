(ns jdk.text.CollationElementIterator
  "The CollationElementIterator class is used as an iterator
  to walk through each character of an international string. Use the iterator
  to return the ordering priority of the positioned character. The ordering
  priority of a character, which we refer to as a key, defines how a character
  is collated in the given collation object.


  For example, consider the following in Spanish:



  `ca` → the first key is key('c') and second key is key('a').
  `cha` → the first key is key('ch') and second key is key('a').

  And in German,



  `�b` → the first key is key('a'), the second key is key('e'), and
  the third key is key('b').

  The key of a character is an integer composed of primary order(short),
  secondary order(byte), and tertiary order(byte). Java strictly defines
  the size and signedness of its primitive data types. Therefore, the static
  functions primaryOrder, secondaryOrder, and
  tertiaryOrder return int, short,
  and short respectively to ensure the correctness of the key
  value.


  Example of the iterator usage,



   String testString = `This is a test`;
   Collator col = Collator.getInstance();
   if (col instanceof RuleBasedCollator) {
       RuleBasedCollator ruleBasedCollator = (RuleBasedCollator)col;
       CollationElementIterator collationElementIterator = ruleBasedCollator.getCollationElementIterator(testString);
       int primaryOrder = CollationElementIterator.primaryOrder(collationElementIterator.next());
           :
   }



  CollationElementIterator.next returns the collation order
  of the next character. A collation order consists of primary order,
  secondary order and tertiary order. The data type of the collation
  order is int. The first 16 bits of a collation order
  is its primary order; the next 8 bits is the secondary order and the
  last 8 bits is the tertiary order.

  Note: CollationElementIterator is a part of
  RuleBasedCollator implementation. It is only usable
  with RuleBasedCollator instances."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.text CollationElementIterator]))

(def *-nullorder
  "Static Constant.

  Null order which indicates the end of string is reached by the
   cursor.

  type: int"
  CollationElementIterator/NULLORDER)

(defn *primary-order
  "Return the primary component of a collation element.

  order - the collation element - `int`

  returns: the element's primary component - `int`"
  (^Integer [^Integer order]
    (CollationElementIterator/primaryOrder order)))

(defn *secondary-order
  "Return the secondary component of a collation element.

  order - the collation element - `int`

  returns: the element's secondary component - `short`"
  (^Short [^Integer order]
    (CollationElementIterator/secondaryOrder order)))

(defn *tertiary-order
  "Return the tertiary component of a collation element.

  order - the collation element - `int`

  returns: the element's tertiary component - `short`"
  (^Short [^Integer order]
    (CollationElementIterator/tertiaryOrder order)))

(defn reset
  "Resets the cursor to the beginning of the string.  The next call
   to next() will return the first collation element in the string."
  ([^CollationElementIterator this]
    (-> this (.reset))))

(defn next
  "Get the next collation element in the string.  This iterator iterates
   over a sequence of collation elements that were built from the string.
   Because there isn't necessarily a one-to-one mapping from characters to
   collation elements, this doesn't mean the same thing as `return the
   collation element [or ordering priority] of the next character in the
   string`.
   This function returns the collation element that the iterator is currently
   pointing to and then updates the internal pointer to point to the next element.
   previous() updates the pointer first and then returns the element.  This
   means that when you change direction while iterating (i.e., call next() and
   then call previous(), or call previous() and then call next()), you'll get
   back the same element twice.

  returns: the next collation element - `int`"
  (^Integer [^CollationElementIterator this]
    (-> this (.next))))

(defn previous
  "Get the previous collation element in the string.  This iterator iterates
   over a sequence of collation elements that were built from the string.
   Because there isn't necessarily a one-to-one mapping from characters to
   collation elements, this doesn't mean the same thing as `return the
   collation element [or ordering priority] of the previous character in the
   string`.
   This function updates the iterator's internal pointer to point to the
   collation element preceding the one it's currently pointing to and then
   returns that element, while next() returns the current element and then
   updates the pointer.  This means that when you change direction while
   iterating (i.e., call next() and then call previous(), or call previous()
   and then call next()), you'll get back the same element twice.

  returns: the previous collation element - `int`"
  (^Integer [^CollationElementIterator this]
    (-> this (.previous))))

(defn set-offset
  "Sets the iterator to point to the collation element corresponding to
   the specified character (the parameter is a CHARACTER offset in the
   original string, not an offset into its corresponding sequence of
   collation elements).  The value returned by the next call to next()
   will be the collation element corresponding to the specified position
   in the text.  If that position is in the middle of a contracting
   character sequence, the result of the next call to next() is the
   collation element for that sequence.  This means that getOffset()
   is not guaranteed to return the same value as was passed to a preceding
   call to setOffset().

  new-offset - The new character offset into the original text. - `int`"
  ([^CollationElementIterator this ^Integer new-offset]
    (-> this (.setOffset new-offset))))

(defn get-offset
  "Returns the character offset in the original text corresponding to the next
   collation element.  (That is, getOffset() returns the position in the text
   corresponding to the collation element that will be returned by the next
   call to next().)  This value will always be the index of the FIRST character
   corresponding to the collation element (a contracting character sequence is
   when two or more characters all correspond to the same collation element).
   This means if you do setOffset(x) followed immediately by getOffset(), getOffset()
   won't necessarily return x.

  returns: The character offset in the original text corresponding to the collation
   element that will be returned by the next call to next(). - `int`"
  (^Integer [^CollationElementIterator this]
    (-> this (.getOffset))))

(defn get-max-expansion
  "Return the maximum length of any expansion sequences that end
   with the specified comparison order.

  order - a collation order returned by previous or next. - `int`

  returns: the maximum length of any expansion sequences ending
           with the specified order. - `int`"
  (^Integer [^CollationElementIterator this ^Integer order]
    (-> this (.getMaxExpansion order))))

(defn set-text
  "Set a new string over which to iterate.

  source - the new source text - `java.lang.String`"
  ([^CollationElementIterator this ^java.lang.String source]
    (-> this (.setText source))))

