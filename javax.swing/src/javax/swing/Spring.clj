(ns javax.swing.Spring
  "An instance of the Spring class holds three properties that
   characterize its behavior: the minimum, preferred, and
   maximum values. Each of these properties may be involved in
   defining its fourth, value, property based on a series of rules.

   An instance of the Spring class can be visualized as a
   mechanical spring that provides a corrective force as the spring is compressed
   or stretched away from its preferred value. This force is modelled
   as linear function of the distance from the preferred value, but with
   two different constants -- one for the compressional force and one for the
   tensional one. Those constants are specified by the minimum and maximum
   values of the spring such that a spring at its minimum value produces an
   equal and opposite force to that which is created when it is at its
   maximum value. The difference between the preferred and
   minimum values, therefore, represents the ease with which the
   spring can be compressed and the difference between its maximum
   and preferred values, indicates the ease with which the
   Spring can be extended.
   See the sum(javax.swing.Spring, javax.swing.Spring) method for details.


   By defining simple arithmetic operations on Springs,
   the behavior of a collection of Springs
   can be reduced to that of an ordinary (non-compound) Spring. We define
   the `+`, `-`, max, and min operators on
   Springs so that, in each case, the result is a Spring
   whose characteristics bear a useful mathematical relationship to its constituent
   springs.


   A Spring can be treated as a pair of intervals
   with a single common point: the preferred value.
   The following rules define some of the
   arithmetic operators that can be applied to intervals
   ([a, b] refers to the interval
   from a
   to b,
   where a <= b).



           [a1, b1]  [a2, b2] = [a1  a2, b1  b2]

                       -[a, b] = [-b, -a]

       max([a1, b1], [a2, b2]) = [max(a1, a2), max(b1, b2)]


   If we denote Springs as [a, b, c],
   where a <= b <= c, we can define the same
   arithmetic operators on Springs:



           [a1, b1, c1]  [a2, b2, c2] = [a1  a2, b1  b2, c1  c2]

                            -[a, b, c] = [-c, -b, -a]

       max([a1, b1, c1], [a2, b2, c2]) = [max(a1, a2), max(b1, b2), max(c1, c2)]

   With both intervals and Springs we can define `-` and min
   in terms of negation:



       X - Y = X  (-Y)

       min(X, Y) = -max(-X, -Y)

   For the static methods in this class that embody the arithmetic
   operators, we do not actually perform the operation in question as
   that would snapshot the values of the properties of the method's arguments
   at the time the static method is called. Instead, the static methods
   create a new Spring instance containing references to
   the method's arguments so that the characteristics of the new spring track the
   potentially changing characteristics of the springs from which it
   was made. This is a little like the idea of a lazy value
   in a functional language.

  If you are implementing a SpringLayout you
  can find further information and examples in
  How to Use SpringLayout,
  a section in The Java Tutorial.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing Spring]))

(def *-unset
  "Static Constant.

  An integer value signifying that a property value has not yet been calculated.

  type: int"
  Spring/UNSET)

(defn *constant
  "Returns a spring whose minimum, preferred, and
   maximum values have the values: min, pref,
   and max respectively.

  min - the minimum value of the new spring - `int`
  pref - the preferred value of the new spring - `int`
  max - the maximum value of the new spring - `int`

  returns: a spring whose minimum, preferred, and
           maximum values have the values: min, pref,
           and max respectively - `javax.swing.Spring`"
  (^javax.swing.Spring [^Integer min ^Integer pref ^Integer max]
    (Spring/constant min pref max))
  (^javax.swing.Spring [^Integer pref]
    (Spring/constant pref)))

(defn *minus
  "Returns -s: a spring running in the opposite direction to s.

  s - `javax.swing.Spring`

  returns: -s: a spring running in the opposite direction to s - `javax.swing.Spring`"
  (^javax.swing.Spring [^javax.swing.Spring s]
    (Spring/minus s)))

(defn *sum
  "Returns s1+s2: a spring representing s1 and s2
   in series. In a sum, s3, of two springs, s1 and s2,
   the strains of s1, s2, and s3 are maintained
   at the same level (to within the precision implied by their integer values).
   The strain of a spring in compression is:


           value - pref
           ------------
            pref - min
   and the strain of a spring in tension is:


           value - pref
           ------------
            max - pref
   When setValue is called on the sum spring, s3, the strain
   in s3 is calculated using one of the formulas above. Once the strain of
   the sum is known, the values of s1 and s2 are
   then set so that they are have a strain equal to that of the sum. The formulas are
   evaluated so as to take rounding errors into account and ensure that the sum of
   the values of s1 and s2 is exactly equal to
   the value of s3.

  s-1 - `javax.swing.Spring`
  s-2 - `javax.swing.Spring`

  returns: s1+s2: a spring representing s1 and s2 in series - `javax.swing.Spring`"
  (^javax.swing.Spring [^javax.swing.Spring s-1 ^javax.swing.Spring s-2]
    (Spring/sum s-1 s-2)))

(defn *max
  "Returns max(s1, s2): a spring whose value is always greater than (or equal to)
           the values of both s1 and s2.

  s-1 - `javax.swing.Spring`
  s-2 - `javax.swing.Spring`

  returns: max(s1, s2): a spring whose value is always greater than (or equal to)
           the values of both s1 and s2 - `javax.swing.Spring`"
  (^javax.swing.Spring [^javax.swing.Spring s-1 ^javax.swing.Spring s-2]
    (Spring/max s-1 s-2)))

(defn *scale
  "Returns a spring whose minimum, preferred, maximum
   and value properties are each multiples of the properties of the
   argument spring, s. Minimum and maximum properties are
   swapped when factor is negative (in accordance with the
   rules of interval arithmetic).

   When factor is, for example, 0.5f the result represents 'the mid-point'
   of its input - an operation that is useful for centering components in
   a container.

  s - the spring to scale - `javax.swing.Spring`
  factor - amount to scale by. - `float`

  returns: a spring whose properties are those of the input spring s
   multiplied by factor - `javax.swing.Spring`

  throws: java.lang.NullPointerException - if s is null"
  (^javax.swing.Spring [^javax.swing.Spring s ^Float factor]
    (Spring/scale s factor)))

(defn *width
  "Returns a spring whose minimum, preferred, maximum
   and value properties are defined by the widths of the minimumSize,
   preferredSize, maximumSize and size properties
   of the supplied component. The returned spring is a 'wrapper' implementation
   whose methods call the appropriate size methods of the supplied component.
   The minimum, preferred, maximum and value properties of the returned spring
   therefore report the current state of the appropriate properties in the
   component and track them as they change.

  c - Component used for calculating size - `java.awt.Component`

  returns: a spring whose properties are defined by the horizontal component
   of the component's size methods. - `javax.swing.Spring`

  throws: java.lang.NullPointerException - if c is null"
  (^javax.swing.Spring [^java.awt.Component c]
    (Spring/width c)))

(defn *height
  "Returns a spring whose minimum, preferred, maximum
   and value properties are defined by the heights of the minimumSize,
   preferredSize, maximumSize and size properties
   of the supplied component. The returned spring is a 'wrapper' implementation
   whose methods call the appropriate size methods of the supplied component.
   The minimum, preferred, maximum and value properties of the returned spring
   therefore report the current state of the appropriate properties in the
   component and track them as they change.

  c - Component used for calculating size - `java.awt.Component`

  returns: a spring whose properties are defined by the vertical component
   of the component's size methods. - `javax.swing.Spring`

  throws: java.lang.NullPointerException - if c is null"
  (^javax.swing.Spring [^java.awt.Component c]
    (Spring/height c)))

(defn get-minimum-value
  "Returns the minimum value of this Spring.

  returns: the minimumValue property of this Spring - `int`"
  (^Integer [^Spring this]
    (-> this (.getMinimumValue))))

(defn get-preferred-value
  "Returns the preferred value of this Spring.

  returns: the preferredValue of this Spring - `int`"
  (^Integer [^Spring this]
    (-> this (.getPreferredValue))))

(defn get-maximum-value
  "Returns the maximum value of this Spring.

  returns: the maximumValue property of this Spring - `int`"
  (^Integer [^Spring this]
    (-> this (.getMaximumValue))))

(defn get-value
  "Returns the current value of this Spring.

  returns: the value property of this Spring - `int`"
  (^Integer [^Spring this]
    (-> this (.getValue))))

(defn set-value
  "Sets the current value of this Spring to value.

  value - the new setting of the value property - `int`"
  ([^Spring this ^Integer value]
    (-> this (.setValue value))))

