(ns javax.management.Query
  "Constructs query object constraints.

  The MBean Server can be queried for MBeans that meet a particular
  condition, using its queryNames or
  queryMBeans method.  The QueryExp
  parameter to the method can be any implementation of the interface
  QueryExp, but it is usually best to obtain the QueryExp
  value by calling the static methods in this class.  This is particularly
  true when querying a remote MBean Server: a custom implementation of the
  QueryExp interface might not be present in the remote MBean Server,
  but the methods in this class return only standard classes that are
  part of the JMX implementation.

  As an example, suppose you wanted to find all MBeans where the Enabled attribute is true and the Owner attribute is \"Duke\". Here is how you could construct the appropriate QueryExp by
  chaining together method calls:



  QueryExp query =
      Query.and(Query.eq(Query.attr(\"Enabled\"), Query.value(true)),
                Query.eq(Query.attr(\"Owner\"), Query.value(\"Duke\")));"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management Query]))

(defn ->query
  "Constructor.

  Basic constructor."
  (^Query []
    (new Query )))

(def *-gt
  "Static Constant.

  A code representing the gt(javax.management.ValueExp, javax.management.ValueExp) query.  This is chiefly
   of interest for the serialized form of queries.

  type: int"
  Query/GT)

(def *-lt
  "Static Constant.

  A code representing the lt(javax.management.ValueExp, javax.management.ValueExp) query.  This is chiefly
   of interest for the serialized form of queries.

  type: int"
  Query/LT)

(def *-ge
  "Static Constant.

  A code representing the geq(javax.management.ValueExp, javax.management.ValueExp) query.  This is chiefly
   of interest for the serialized form of queries.

  type: int"
  Query/GE)

(def *-le
  "Static Constant.

  A code representing the leq(javax.management.ValueExp, javax.management.ValueExp) query.  This is chiefly
   of interest for the serialized form of queries.

  type: int"
  Query/LE)

(def *-eq
  "Static Constant.

  A code representing the eq(javax.management.ValueExp, javax.management.ValueExp) query.  This is chiefly
   of interest for the serialized form of queries.

  type: int"
  Query/EQ)

(def *-plus
  "Static Constant.

  A code representing the plus(javax.management.ValueExp, javax.management.ValueExp) expression.  This
   is chiefly of interest for the serialized form of queries.

  type: int"
  Query/PLUS)

(def *-minus
  "Static Constant.

  A code representing the minus(javax.management.ValueExp, javax.management.ValueExp) expression.  This
   is chiefly of interest for the serialized form of queries.

  type: int"
  Query/MINUS)

(def *-times
  "Static Constant.

  A code representing the times(javax.management.ValueExp, javax.management.ValueExp) expression.  This
   is chiefly of interest for the serialized form of queries.

  type: int"
  Query/TIMES)

(def *-div
  "Static Constant.

  A code representing the div(javax.management.ValueExp, javax.management.ValueExp) expression.  This is
   chiefly of interest for the serialized form of queries.

  type: int"
  Query/DIV)

(defn *lt
  "Returns a query expression that represents a \"less than\" constraint on
   two values.

  v-1 - A value expression. - `javax.management.ValueExp`
  v-2 - Another value expression. - `javax.management.ValueExp`

  returns: A \"less than\" constraint on the arguments.  The
   returned object will be serialized as an instance of the
   non-public class

   javax.management.BinaryRelQueryExp with a relOp equal
   to LT. - `javax.management.QueryExp`"
  (^javax.management.QueryExp [^javax.management.ValueExp v-1 ^javax.management.ValueExp v-2]
    (Query/lt v-1 v-2)))

(defn *final-sub-string
  "Returns a query expression that represents a matching constraint on
   a string argument. The value must end with the given literal string
   value.

  a - An attribute expression. - `javax.management.AttributeValueExp`
  s - A string value expression representing the end of the string value. - `javax.management.StringValueExp`

  returns: The constraint that a matches s.  The returned object
   will be serialized as an instance of the non-public class


   javax.management.MatchQueryExp. - `javax.management.QueryExp`"
  (^javax.management.QueryExp [^javax.management.AttributeValueExp a ^javax.management.StringValueExp s]
    (Query/finalSubString a s)))

(defn *not
  "Returns a constraint that is the negation of its argument.

  query-exp - The constraint to negate. - `javax.management.QueryExp`

  returns: A negated constraint.  The returned object will be
   serialized as an instance of the non-public class

   javax.management.NotQueryExp. - `javax.management.QueryExp`"
  (^javax.management.QueryExp [^javax.management.QueryExp query-exp]
    (Query/not query-exp)))

(defn *eq
  "Returns a query expression that represents an equality constraint on
   two values.

  v-1 - A value expression. - `javax.management.ValueExp`
  v-2 - Another value expression. - `javax.management.ValueExp`

  returns: A \"equal to\" constraint on the arguments.  The
   returned object will be serialized as an instance of the
   non-public class

   javax.management.BinaryRelQueryExp with a relOp equal
   to EQ. - `javax.management.QueryExp`"
  (^javax.management.QueryExp [^javax.management.ValueExp v-1 ^javax.management.ValueExp v-2]
    (Query/eq v-1 v-2)))

(defn *plus
  "Returns a binary expression representing the sum of two numeric values,
   or the concatenation of two string values.

  value-1 - The first '+' operand. - `javax.management.ValueExp`
  value-2 - The second '+' operand. - `javax.management.ValueExp`

  returns: A ValueExp representing the sum or concatenation of
   the two arguments.  The returned object will be serialized as
   an instance of the non-public class

   javax.management.BinaryOpValueExp with an op equal to
   PLUS. - `javax.management.ValueExp`"
  (^javax.management.ValueExp [^javax.management.ValueExp value-1 ^javax.management.ValueExp value-2]
    (Query/plus value-1 value-2)))

(defn *leq
  "Returns a query expression that represents a \"less than or equal to\"
   constraint on two values.

  v-1 - A value expression. - `javax.management.ValueExp`
  v-2 - Another value expression. - `javax.management.ValueExp`

  returns: A \"less than or equal to\" constraint on the arguments.
   The returned object will be serialized as an instance of the
   non-public class

   javax.management.BinaryRelQueryExp with a relOp equal
   to LE. - `javax.management.QueryExp`"
  (^javax.management.QueryExp [^javax.management.ValueExp v-1 ^javax.management.ValueExp v-2]
    (Query/leq v-1 v-2)))

(defn *attr
  "Returns a new qualified attribute expression.

   Evaluating this expression for a given
   objectName includes performing MBeanServer.getObjectInstance(objectName) and MBeanServer.getAttribute(objectName,
   name).

  class-name - The name of the class possessing the attribute. - `java.lang.String`
  name - The name of the attribute. - `java.lang.String`

  returns: An attribute expression for the attribute named name.
   The returned object will be serialized as an instance of the
   non-public class

   javax.management.QualifiedAttributeValueExp. - `javax.management.AttributeValueExp`"
  (^javax.management.AttributeValueExp [^java.lang.String class-name ^java.lang.String name]
    (Query/attr class-name name))
  (^javax.management.AttributeValueExp [^java.lang.String name]
    (Query/attr name)))

(defn *classattr
  "Returns a new class attribute expression which can be used in any
   Query call that expects a ValueExp.

   Evaluating this expression for a given
   objectName includes performing MBeanServer.getObjectInstance(objectName).

  returns: A class attribute expression.  The returned object
   will be serialized as an instance of the non-public class

   javax.management.ClassAttributeValueExp. - `javax.management.AttributeValueExp`"
  (^javax.management.AttributeValueExp []
    (Query/classattr )))

(defn *minus
  "Returns a binary expression representing the difference between two numeric
   values.

  value-1 - The first '-' operand. - `javax.management.ValueExp`
  value-2 - The second '-' operand. - `javax.management.ValueExp`

  returns: A ValueExp representing the difference between two
   arguments.  The returned object will be serialized as an
   instance of the non-public class

   javax.management.BinaryOpValueExp with an op equal to
   MINUS. - `javax.management.ValueExp`"
  (^javax.management.ValueExp [^javax.management.ValueExp value-1 ^javax.management.ValueExp value-2]
    (Query/minus value-1 value-2)))

(defn *initial-sub-string
  "Returns a query expression that represents a matching constraint on
   a string argument. The value must start with the given literal string
   value.

  a - An attribute expression. - `javax.management.AttributeValueExp`
  s - A string value expression representing the beginning of the string value. - `javax.management.StringValueExp`

  returns: The constraint that a matches s.  The returned object
   will be serialized as an instance of the non-public class


   javax.management.MatchQueryExp. - `javax.management.QueryExp`"
  (^javax.management.QueryExp [^javax.management.AttributeValueExp a ^javax.management.StringValueExp s]
    (Query/initialSubString a s)))

(defn *gt
  "Returns a query expression that represents a \"greater than\" constraint on
   two values.

  v-1 - A value expression. - `javax.management.ValueExp`
  v-2 - Another value expression. - `javax.management.ValueExp`

  returns: A \"greater than\" constraint on the arguments.  The
   returned object will be serialized as an instance of the
   non-public class

   javax.management.BinaryRelQueryExp with a relOp equal
   to GT. - `javax.management.QueryExp`"
  (^javax.management.QueryExp [^javax.management.ValueExp v-1 ^javax.management.ValueExp v-2]
    (Query/gt v-1 v-2)))

(defn *times
  "Returns a binary expression representing the product of two numeric values.

  value-1 - The first '*' operand. - `javax.management.ValueExp`
  value-2 - The second '*' operand. - `javax.management.ValueExp`

  returns: A ValueExp representing the product.  The returned
   object will be serialized as an instance of the non-public
   class

   javax.management.BinaryOpValueExp with an op equal to
   TIMES. - `javax.management.ValueExp`"
  (^javax.management.ValueExp [^javax.management.ValueExp value-1 ^javax.management.ValueExp value-2]
    (Query/times value-1 value-2)))

(defn *value
  "Returns a new string expression.

  val - The string value. - `java.lang.String`

  returns: A ValueExp object containing the string argument. - `javax.management.StringValueExp`"
  (^javax.management.StringValueExp [^java.lang.String val]
    (Query/value val)))

(defn *or
  "Returns a query expression that is the disjunction of two other query
   expressions.

  q-1 - A query expression. - `javax.management.QueryExp`
  q-2 - Another query expression. - `javax.management.QueryExp`

  returns: The disjunction of the two arguments.  The returned object
   will be serialized as an instance of the non-public class

   javax.management.OrQueryExp. - `javax.management.QueryExp`"
  (^javax.management.QueryExp [^javax.management.QueryExp q-1 ^javax.management.QueryExp q-2]
    (Query/or q-1 q-2)))

(defn *and
  "Returns a query expression that is the conjunction of two other query
   expressions.

  q-1 - A query expression. - `javax.management.QueryExp`
  q-2 - Another query expression. - `javax.management.QueryExp`

  returns: The conjunction of the two arguments.  The returned object
   will be serialized as an instance of the non-public class

   javax.management.AndQueryExp. - `javax.management.QueryExp`"
  (^javax.management.QueryExp [^javax.management.QueryExp q-1 ^javax.management.QueryExp q-2]
    (Query/and q-1 q-2)))

(defn *any-sub-string
  "Returns a query expression that represents a matching constraint on
   a string argument. The value must contain the given literal string
   value.

  a - An attribute expression. - `javax.management.AttributeValueExp`
  s - A string value expression representing the substring. - `javax.management.StringValueExp`

  returns: The constraint that a matches s.  The returned object
   will be serialized as an instance of the non-public class


   javax.management.MatchQueryExp. - `javax.management.QueryExp`"
  (^javax.management.QueryExp [^javax.management.AttributeValueExp a ^javax.management.StringValueExp s]
    (Query/anySubString a s)))

(defn *div
  "Returns a binary expression representing the quotient of two numeric
   values.

  value-1 - The first '/' operand. - `javax.management.ValueExp`
  value-2 - The second '/' operand. - `javax.management.ValueExp`

  returns: A ValueExp representing the quotient of two arguments.
   The returned object will be serialized as an instance of the
   non-public class

   javax.management.BinaryOpValueExp with an op equal to
   DIV. - `javax.management.ValueExp`"
  (^javax.management.ValueExp [^javax.management.ValueExp value-1 ^javax.management.ValueExp value-2]
    (Query/div value-1 value-2)))

(defn *between
  "Returns a query expression that represents the constraint that one
   value is between two other values.

  v-1 - A value expression that is \"between\" v2 and v3. - `javax.management.ValueExp`
  v-2 - Value expression that represents a boundary of the constraint. - `javax.management.ValueExp`
  v-3 - Value expression that represents a boundary of the constraint. - `javax.management.ValueExp`

  returns: The constraint that v1 lies between v2 and v3.  The
   returned object will be serialized as an instance of the
   non-public class

   javax.management.BetweenQueryExp. - `javax.management.QueryExp`"
  (^javax.management.QueryExp [^javax.management.ValueExp v-1 ^javax.management.ValueExp v-2 ^javax.management.ValueExp v-3]
    (Query/between v-1 v-2 v-3)))

(defn *match
  "Returns a query expression that represents a matching constraint on
   a string argument. The matching syntax is consistent with file globbing:
   supports \"?\", \"*\", \"[\",
   each of which may be escaped with \"\\\";
   character classes may use \"!\" for negation and
   \"-\" for range.
   (* for any character sequence,
   ? for a single arbitrary character,
   [...] for a character sequence).
   For example: a*b?c would match a string starting
   with the character a, followed
   by any number of characters, followed by a b,
   any single character, and a c.

  a - An attribute expression - `javax.management.AttributeValueExp`
  s - A string value expression representing a matching constraint - `javax.management.StringValueExp`

  returns: A query expression that represents the matching
   constraint on the string argument.  The returned object will
   be serialized as an instance of the non-public class

   javax.management.MatchQueryExp. - `javax.management.QueryExp`"
  (^javax.management.QueryExp [^javax.management.AttributeValueExp a ^javax.management.StringValueExp s]
    (Query/match a s)))

(defn *is-instance-of
  "Returns a query expression that represents an inheritance constraint
   on an MBean class.
   Example: to find MBeans that are instances of
   NotificationBroadcaster, use
   Query.isInstanceOf(Query.value(NotificationBroadcaster.class.getName())).

   Evaluating this expression for a given
   objectName includes performing MBeanServer.isInstanceOf(objectName,
   ((StringValueExp)classNameValue.apply(objectName)).getValue().

  class-name-value - The StringValueExp returning the name of the class of which selected MBeans should be instances. - `javax.management.StringValueExp`

  returns: a query expression that represents an inheritance
   constraint on an MBean class.  The returned object will be
   serialized as an instance of the non-public class

   javax.management.InstanceOfQueryExp. - `javax.management.QueryExp`"
  (^javax.management.QueryExp [^javax.management.StringValueExp class-name-value]
    (Query/isInstanceOf class-name-value)))

(defn *in
  "Returns an expression constraining a value to be one of an explicit list.

  val - A value to be constrained. - `javax.management.ValueExp`
  value-list - An array of ValueExps. - `javax.management.ValueExp[]`

  returns: A QueryExp that represents the constraint.  The
   returned object will be serialized as an instance of the
   non-public class

   javax.management.InQueryExp. - `javax.management.QueryExp`"
  (^javax.management.QueryExp [^javax.management.ValueExp val value-list]
    (Query/in val value-list)))

(defn *geq
  "Returns a query expression that represents a \"greater than or equal
   to\" constraint on two values.

  v-1 - A value expression. - `javax.management.ValueExp`
  v-2 - Another value expression. - `javax.management.ValueExp`

  returns: A \"greater than or equal to\" constraint on the
   arguments.  The returned object will be serialized as an
   instance of the non-public class

   javax.management.BinaryRelQueryExp with a relOp equal
   to GE. - `javax.management.QueryExp`"
  (^javax.management.QueryExp [^javax.management.ValueExp v-1 ^javax.management.ValueExp v-2]
    (Query/geq v-1 v-2)))

