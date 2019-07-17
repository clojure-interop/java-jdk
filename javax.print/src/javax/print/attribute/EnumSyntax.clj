(ns javax.print.attribute.EnumSyntax
  "Class EnumSyntax is an abstract base class providing the common
  implementation of all `type safe enumeration` objects. An enumeration class
  (which extends class EnumSyntax) provides a group of enumeration values
  (objects) that are singleton instances of the enumeration class; for example:


      public class Bach extends EnumSyntax {
          public static final Bach JOHANN_SEBASTIAN     = new Bach(0);
          public static final Bach WILHELM_FRIEDEMANN   = new Bach(1);
          public static final Bach CARL_PHILIP_EMMANUEL = new Bach(2);
          public static final Bach JOHANN_CHRISTIAN     = new Bach(3);
          public static final Bach P_D_Q                = new Bach(4);

          private static final String[] stringTable = {
              `Johann Sebastian Bach`,
               `Wilhelm Friedemann Bach`,
               `Carl Philip Emmanuel Bach`,
               `Johann Christian Bach`,
               `P.D.Q. Bach`
          };

          protected String[] getStringTable() {
              return stringTable;
          }

          private static final Bach[] enumValueTable = {
              JOHANN_SEBASTIAN,
               WILHELM_FRIEDEMANN,
               CARL_PHILIP_EMMANUEL,
               JOHANN_CHRISTIAN,
               P_D_Q
          };

          protected EnumSyntax[] getEnumValueTable() {
              return enumValueTable;
          }
      }
  You can then write code that uses the == and !=
  operators to test enumeration values; for example:


      Bach theComposer;
      . . .
      if (theComposer == Bach.JOHANN_SEBASTIAN) {
          System.out.println (`The greatest composer of all time!`);
      }
  The equals() method for an enumeration class just does a test
  for identical objects (==).

  You can convert an enumeration value to a string by calling toString(). The string is obtained from a table
  supplied by the enumeration class.

  Under the hood, an enumeration value is just an integer, a different integer
  for each enumeration value within an enumeration class. You can get an
  enumeration value's integer value by calling getValue(). An enumeration value's integer value is established
  when it is constructed (see EnumSyntax(int)). Since the constructor is protected, the only
  possible enumeration values are the singleton objects declared in the
  enumeration class; additional enumeration values cannot be created at run
  time.

  You can define a subclass of an enumeration class that extends it with
  additional enumeration values. The subclass's enumeration values' integer
  values need not be distinct from the superclass's enumeration values' integer
  values; the ==, !=, equals(), and
  toString() methods will still work properly even if the subclass
  uses some of the same integer values as the superclass. However, the
  application in which the enumeration class and subclass are used may need to
  have distinct integer values in the superclass and subclass."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute EnumSyntax]))

(defn get-value
  "Returns this enumeration value's integer value.

  returns: the value - `int`"
  ([^javax.print.attribute.EnumSyntax this]
    (-> this (.getValue))))

(defn clone
  "Returns a clone of this enumeration value, which to preserve the
   semantics of enumeration values is the same object as this enumeration
   value.

  returns: a clone of this instance. - `java.lang.Object`"
  ([^javax.print.attribute.EnumSyntax this]
    (-> this (.clone))))

(defn hash-code
  "Returns a hash code value for this enumeration value. The hash code is
   just this enumeration value's integer value.

  returns: a hash code value for this object. - `int`"
  ([^javax.print.attribute.EnumSyntax this]
    (-> this (.hashCode))))

(defn to-string
  "Returns a string value corresponding to this enumeration value.

  returns: a string representation of the object. - `java.lang.String`"
  ([^javax.print.attribute.EnumSyntax this]
    (-> this (.toString))))

