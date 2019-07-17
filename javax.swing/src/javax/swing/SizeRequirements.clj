(ns javax.swing.SizeRequirements
  "For the convenience of layout managers,
  calculates information about the size and position of components.
  All size and position calculation methods are class methods
  that take arrays of SizeRequirements as arguments.
  The SizeRequirements class supports two types of layout:



   tiled
   The components are placed end-to-end,
       starting either at coordinate 0 (the leftmost or topmost position)
       or at the coordinate representing the end of the allocated span
       (the rightmost or bottommost position).

   aligned
   The components are aligned as specified
       by each component's X or Y alignment value.





  Each SizeRequirements object contains information
  about either the width (and X alignment)
  or height (and Y alignment)
  of a single component or a group of components:



   minimum
   The smallest reasonable width/height of the component
       or component group, in pixels.

   preferred
   The natural width/height of the component
       or component group, in pixels.

   maximum
   The largest reasonable width/height of the component
       or component group, in pixels.

   alignment
   The X/Y alignment of the component
       or component group.



  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing SizeRequirements]))

(defn ->size-requirements
  "Constructor.

  Creates a SizeRequirements object with the specified minimum, preferred,
   and maximum sizes and the specified alignment.

  min - the minimum size >= 0 - `int`
  pref - the preferred size >= 0 - `int`
  max - the maximum size >= 0 - `int`
  a - the alignment >= 0.0f && <= 1.0f - `float`"
  ([^Integer min ^Integer pref ^Integer max ^Float a]
    (new SizeRequirements min pref max a))
  ([]
    (new SizeRequirements )))

(defn -minimum
  "Instance Field.

  The minimum size required.
   For a component comp, this should be equal to either
   comp.getMinimumSize().width or
   comp.getMinimumSize().height.

  type: int"
  [this]
  (-> this .-minimum))

(defn -preferred
  "Instance Field.

  The preferred (natural) size.
   For a component comp, this should be equal to either
   comp.getPreferredSize().width or
   comp.getPreferredSize().height.

  type: int"
  [this]
  (-> this .-preferred))

(defn -maximum
  "Instance Field.

  The maximum size allowed.
   For a component comp, this should be equal to either
   comp.getMaximumSize().width or
   comp.getMaximumSize().height.

  type: int"
  [this]
  (-> this .-maximum))

(defn -alignment
  "Instance Field.

  The alignment, specified as a value between 0.0 and 1.0,
   inclusive.
   To specify centering, the alignment should be 0.5.

  type: float"
  [this]
  (-> this .-alignment))

(defn *get-tiled-size-requirements
  "Determines the total space necessary to
   place a set of components end-to-end.  The needs
   of each component in the set are represented by an entry in the
   passed-in SizeRequirements array.
   The returned SizeRequirements object has an alignment of 0.5
   (centered).  The space requirement is never more than
   Integer.MAX_VALUE.

  children - the space requirements for a set of components. The vector may be of zero length, which will result in a default SizeRequirements object instance being passed back. - `javax.swing.SizeRequirements[]`

  returns: the total space requirements. - `javax.swing.SizeRequirements`"
  ([^javax.swing.SizeRequirements[] children]
    (SizeRequirements/getTiledSizeRequirements children)))

(defn *get-aligned-size-requirements
  "Determines the total space necessary to
   align a set of components.  The needs
   of each component in the set are represented by an entry in the
   passed-in SizeRequirements array.  The total space required will
   never be more than Integer.MAX_VALUE.

  children - the set of child requirements. If of zero length, the returns result will be a default instance of SizeRequirements. - `javax.swing.SizeRequirements[]`

  returns: the total space requirements. - `javax.swing.SizeRequirements`"
  ([^javax.swing.SizeRequirements[] children]
    (SizeRequirements/getAlignedSizeRequirements children)))

(defn *calculate-tiled-positions
  "Creates a set of offset/span pairs representing how to
   lay out a set of components end-to-end.
   This method requires that you specify
   the total amount of space to be allocated,
   the size requirements for each component to be placed
   (specified as an array of SizeRequirements), and
   the total size requirement of the set of components.
   You can get the total size requirement
   by invoking the getTiledSizeRequirements method.

   This method also requires a flag indicating whether components
   should be tiled in the forward direction (offsets increasing
   from 0) or reverse direction (offsets decreasing from the end
   of the allocated space).  The forward direction represents
   components tiled from left to right or top to bottom.  The
   reverse direction represents components tiled from right to left
   or bottom to top.

  allocated - the total span to be allocated >= 0. - `int`
  total - the total of the children requests. This argument is optional and may be null. - `javax.swing.SizeRequirements`
  children - the size requirements for each component. - `javax.swing.SizeRequirements[]`
  offsets - the offset from 0 for each child where the spans were allocated (determines placement of the span). - `int[]`
  spans - the span allocated for each child to make the total target span. - `int[]`
  forward - tile with offsets increasing from 0 if true and with offsets decreasing from the end of the allocated space if false. - `boolean`"
  ([^Integer allocated ^javax.swing.SizeRequirements total ^javax.swing.SizeRequirements[] children offsets spans ^Boolean forward]
    (SizeRequirements/calculateTiledPositions allocated total children offsets spans forward))
  ([^Integer allocated ^javax.swing.SizeRequirements total ^javax.swing.SizeRequirements[] children offsets spans]
    (SizeRequirements/calculateTiledPositions allocated total children offsets spans)))

(defn *calculate-aligned-positions
  "Creates a set of offset/span pairs specifying how to
   lay out a set of components with the specified alignments.
   The resulting span allocations will overlap, with each one
   fitting as well as possible into the given total allocation.
   This method requires that you specify
   the total amount of space to be allocated,
   the size requirements for each component to be placed
   (specified as an array of SizeRequirements), and
   the total size requirements of the set of components
   (only the alignment field of which is actually used)
   You can get the total size requirement by invoking
   getAlignedSizeRequirements.

   This method also requires a flag indicating whether normal or
   reverse alignment should be performed.  With normal alignment
   the value 0.0f represents the left/top edge of the component
   to be aligned.  With reverse alignment, 0.0f represents the
   right/bottom edge.

  allocated - the total span to be allocated >= 0. - `int`
  total - the total of the children requests. - `javax.swing.SizeRequirements`
  children - the size requirements for each component. - `javax.swing.SizeRequirements[]`
  offsets - the offset from 0 for each child where the spans were allocated (determines placement of the span). - `int[]`
  spans - the span allocated for each child to make the total target span. - `int[]`
  normal - when true, the alignment value 0.0f means left/top; when false, it means right/bottom. - `boolean`"
  ([^Integer allocated ^javax.swing.SizeRequirements total ^javax.swing.SizeRequirements[] children offsets spans ^Boolean normal]
    (SizeRequirements/calculateAlignedPositions allocated total children offsets spans normal))
  ([^Integer allocated ^javax.swing.SizeRequirements total ^javax.swing.SizeRequirements[] children offsets spans]
    (SizeRequirements/calculateAlignedPositions allocated total children offsets spans)))

(defn *adjust-sizes
  "Adjust a specified array of sizes by a given amount.

  delta - an int specifying the size difference - `int`
  children - an array of SizeRequirements objects - `javax.swing.SizeRequirements[]`

  returns: an array of ints containing the final size for each item - `int[]`"
  ([^Integer delta ^javax.swing.SizeRequirements[] children]
    (SizeRequirements/adjustSizes delta children)))

(defn to-string
  "Returns a string describing the minimum, preferred, and maximum
   size requirements, along with the alignment.

  returns: the string - `java.lang.String`"
  ([^javax.swing.SizeRequirements this]
    (-> this (.toString))))

