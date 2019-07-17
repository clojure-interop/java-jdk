(ns jdk.awt.geom.AffineTransform
  "The AffineTransform class represents a 2D affine transform
  that performs a linear mapping from 2D coordinates to other 2D
  coordinates that preserves the `straightness` and
  `parallelness` of lines.  Affine transformations can be constructed
  using sequences of translations, scales, flips, rotations, and shears.

  Such a coordinate transformation can be represented by a 3 row by
  3 column matrix with an implied last row of [ 0 0 1 ].  This matrix
  transforms source coordinates (x,y) into
  destination coordinates (x',y') by considering
  them to be a column vector and multiplying the coordinate vector
  by the matrix according to the following process:


       [ x']   [  m00  m01  m02  ] [ x ]   [ m00x  m01y  m02 ]
       [ y'] = [  m10  m11  m12  ] [ y ] = [ m10x  m11y  m12 ]
       [ 1 ]   [   0    0    1   ] [ 1 ]   [         1         ]
  Handling 90-Degree Rotations

  In some variations of the rotate methods in the
  AffineTransform class, a double-precision argument
  specifies the angle of rotation in radians.
  These methods have special handling for rotations of approximately
  90 degrees (including multiples such as 180, 270, and 360 degrees),
  so that the common case of quadrant rotation is handled more
  efficiently.
  This special handling can cause angles very close to multiples of
  90 degrees to be treated as if they were exact multiples of
  90 degrees.
  For small multiples of 90 degrees the range of angles treated
  as a quadrant rotation is approximately 0.00000121 degrees wide.
  This section explains why such special care is needed and how
  it is implemented.

  Since 90 degrees is represented as PI/2 in radians,
  and since PI is a transcendental (and therefore irrational) number,
  it is not possible to exactly represent a multiple of 90 degrees as
  an exact double precision value measured in radians.
  As a result it is theoretically impossible to describe quadrant
  rotations (90, 180, 270 or 360 degrees) using these values.
  Double precision floating point values can get very close to
  non-zero multiples of PI/2 but never close enough
  for the sine or cosine to be exactly 0.0, 1.0 or -1.0.
  The implementations of Math.sin() and
  Math.cos() correspondingly never return 0.0
  for any case other than Math.sin(0.0).
  These same implementations do, however, return exactly 1.0 and
  -1.0 for some range of numbers around each multiple of 90
  degrees since the correct answer is so close to 1.0 or -1.0 that
  the double precision significand cannot represent the difference
  as accurately as it can for numbers that are near 0.0.

  The net result of these issues is that if the
  Math.sin() and Math.cos() methods
  are used to directly generate the values for the matrix modifications
  during these radian-based rotation operations then the resulting
  transform is never strictly classifiable as a quadrant rotation
  even for a simple case like rotate(Math.PI/2.0),
  due to minor variations in the matrix caused by the non-0.0 values
  obtained for the sine and cosine.
  If these transforms are not classified as quadrant rotations then
  subsequent code which attempts to optimize further operations based
  upon the type of the transform will be relegated to its most general
  implementation.

  Because quadrant rotations are fairly common,
  this class should handle these cases reasonably quickly, both in
  applying the rotations to the transform and in applying the resulting
  transform to the coordinates.
  To facilitate this optimal handling, the methods which take an angle
  of rotation measured in radians attempt to detect angles that are
  intended to be quadrant rotations and treat them as such.
  These methods therefore treat an angle theta as a quadrant
  rotation if either Math.sin(theta) or
  Math.cos(theta) returns exactly 1.0 or -1.0.
  As a rule of thumb, this property holds true for a range of
  approximately 0.0000000211 radians (or 0.00000121 degrees) around
  small multiples of Math.PI/2.0."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.geom AffineTransform]))

(defn ->affine-transform
  "Constructor.

  Constructs a new AffineTransform from 6 floating point
   values representing the 6 specifiable entries of the 3x3
   transformation matrix.

  m-00 - the X coordinate scaling element of the 3x3 matrix - `float`
  m-10 - the Y coordinate shearing element of the 3x3 matrix - `float`
  m-01 - the X coordinate shearing element of the 3x3 matrix - `float`
  m-11 - the Y coordinate scaling element of the 3x3 matrix - `float`
  m-02 - the X coordinate translation element of the 3x3 matrix - `float`
  m-12 - the Y coordinate translation element of the 3x3 matrix - `float`"
  ([^Float m-00 ^Float m-10 ^Float m-01 ^Float m-11 ^Float m-02 ^Float m-12]
    (new AffineTransform m-00 m-10 m-01 m-11 m-02 m-12))
  ([^java.awt.geom.AffineTransform tx]
    (new AffineTransform tx))
  ([]
    (new AffineTransform )))

(def *-type-identity
  "Static Constant.

  This constant indicates that the transform defined by this object
   is an identity transform.
   An identity transform is one in which the output coordinates are
   always the same as the input coordinates.
   If this transform is anything other than the identity transform,
   the type will either be the constant GENERAL_TRANSFORM or a
   combination of the appropriate flag bits for the various coordinate
   conversions that this transform performs.

  type: int"
  AffineTransform/TYPE_IDENTITY)

(def *-type-translation
  "Static Constant.

  This flag bit indicates that the transform defined by this object
   performs a translation in addition to the conversions indicated
   by other flag bits.
   A translation moves the coordinates by a constant amount in x
   and y without changing the length or angle of vectors.

  type: int"
  AffineTransform/TYPE_TRANSLATION)

(def *-type-uniform-scale
  "Static Constant.

  This flag bit indicates that the transform defined by this object
   performs a uniform scale in addition to the conversions indicated
   by other flag bits.
   A uniform scale multiplies the length of vectors by the same amount
   in both the x and y directions without changing the angle between
   vectors.
   This flag bit is mutually exclusive with the TYPE_GENERAL_SCALE flag.

  type: int"
  AffineTransform/TYPE_UNIFORM_SCALE)

(def *-type-general-scale
  "Static Constant.

  This flag bit indicates that the transform defined by this object
   performs a general scale in addition to the conversions indicated
   by other flag bits.
   A general scale multiplies the length of vectors by different
   amounts in the x and y directions without changing the angle
   between perpendicular vectors.
   This flag bit is mutually exclusive with the TYPE_UNIFORM_SCALE flag.

  type: int"
  AffineTransform/TYPE_GENERAL_SCALE)

(def *-type-mask-scale
  "Static Constant.

  This constant is a bit mask for any of the scale flag bits.

  type: int"
  AffineTransform/TYPE_MASK_SCALE)

(def *-type-flip
  "Static Constant.

  This flag bit indicates that the transform defined by this object
   performs a mirror image flip about some axis which changes the
   normally right handed coordinate system into a left handed
   system in addition to the conversions indicated by other flag bits.
   A right handed coordinate system is one where the positive X
   axis rotates counterclockwise to overlay the positive Y axis
   similar to the direction that the fingers on your right hand
   curl when you stare end on at your thumb.
   A left handed coordinate system is one where the positive X
   axis rotates clockwise to overlay the positive Y axis similar
   to the direction that the fingers on your left hand curl.
   There is no mathematical way to determine the angle of the
   original flipping or mirroring transformation since all angles
   of flip are identical given an appropriate adjusting rotation.

  type: int"
  AffineTransform/TYPE_FLIP)

(def *-type-quadrant-rotation
  "Static Constant.

  This flag bit indicates that the transform defined by this object
   performs a quadrant rotation by some multiple of 90 degrees in
   addition to the conversions indicated by other flag bits.
   A rotation changes the angles of vectors by the same amount
   regardless of the original direction of the vector and without
   changing the length of the vector.
   This flag bit is mutually exclusive with the TYPE_GENERAL_ROTATION flag.

  type: int"
  AffineTransform/TYPE_QUADRANT_ROTATION)

(def *-type-general-rotation
  "Static Constant.

  This flag bit indicates that the transform defined by this object
   performs a rotation by an arbitrary angle in addition to the
   conversions indicated by other flag bits.
   A rotation changes the angles of vectors by the same amount
   regardless of the original direction of the vector and without
   changing the length of the vector.
   This flag bit is mutually exclusive with the
   TYPE_QUADRANT_ROTATION flag.

  type: int"
  AffineTransform/TYPE_GENERAL_ROTATION)

(def *-type-mask-rotation
  "Static Constant.

  This constant is a bit mask for any of the rotation flag bits.

  type: int"
  AffineTransform/TYPE_MASK_ROTATION)

(def *-type-general-transform
  "Static Constant.

  This constant indicates that the transform defined by this object
   performs an arbitrary conversion of the input coordinates.
   If this transform can be classified by any of the above constants,
   the type will either be the constant TYPE_IDENTITY or a
   combination of the appropriate flag bits for the various coordinate
   conversions that this transform performs.

  type: int"
  AffineTransform/TYPE_GENERAL_TRANSFORM)

(defn *get-translate-instance
  "Returns a transform representing a translation transformation.
   The matrix representing the returned transform is:


            [   1    0    tx  ]
            [   0    1    ty  ]
            [   0    0    1   ]

  tx - the distance by which coordinates are translated in the X axis direction - `double`
  ty - the distance by which coordinates are translated in the Y axis direction - `double`

  returns: an AffineTransform object that represents a
    translation transformation, created with the specified vector. - `java.awt.geom.AffineTransform`"
  ([^Double tx ^Double ty]
    (AffineTransform/getTranslateInstance tx ty)))

(defn *get-rotate-instance
  "Returns a transform that rotates coordinates around an anchor
   point according to a rotation vector.
   All coordinates rotate about the specified anchor coordinates
   by the same amount.
   The amount of rotation is such that coordinates along the former
   positive X axis will subsequently align with the vector pointing
   from the origin to the specified vector coordinates.
   If both vecx and vecy are 0.0,
   an identity transform is returned.
   This operation is equivalent to calling:


       AffineTransform.getRotateInstance(Math.atan2(vecy, vecx),
                                         anchorx, anchory);

  vecx - the X coordinate of the rotation vector - `double`
  vecy - the Y coordinate of the rotation vector - `double`
  anchorx - the X coordinate of the rotation anchor point - `double`
  anchory - the Y coordinate of the rotation anchor point - `double`

  returns: an AffineTransform object that rotates
    coordinates around the specified point according to the
    specified rotation vector. - `java.awt.geom.AffineTransform`"
  ([^Double vecx ^Double vecy ^Double anchorx ^Double anchory]
    (AffineTransform/getRotateInstance vecx vecy anchorx anchory))
  ([^Double theta ^Double anchorx ^Double anchory]
    (AffineTransform/getRotateInstance theta anchorx anchory))
  ([^Double vecx ^Double vecy]
    (AffineTransform/getRotateInstance vecx vecy))
  ([^Double theta]
    (AffineTransform/getRotateInstance theta)))

(defn *get-quadrant-rotate-instance
  "Returns a transform that rotates coordinates by the specified
   number of quadrants around the specified anchor point.
   This operation is equivalent to calling:


       AffineTransform.getRotateInstance(numquadrants * Math.PI / 2.0,
                                         anchorx, anchory);
   Rotating by a positive number of quadrants rotates points on
   the positive X axis toward the positive Y axis.

  numquadrants - the number of 90 degree arcs to rotate by - `int`
  anchorx - the X coordinate of the rotation anchor point - `double`
  anchory - the Y coordinate of the rotation anchor point - `double`

  returns: an AffineTransform object that rotates
    coordinates by the specified number of quadrants around the
    specified anchor point. - `java.awt.geom.AffineTransform`"
  ([^Integer numquadrants ^Double anchorx ^Double anchory]
    (AffineTransform/getQuadrantRotateInstance numquadrants anchorx anchory))
  ([^Integer numquadrants]
    (AffineTransform/getQuadrantRotateInstance numquadrants)))

(defn *get-scale-instance
  "Returns a transform representing a scaling transformation.
   The matrix representing the returned transform is:


            [   sx   0    0   ]
            [   0    sy   0   ]
            [   0    0    1   ]

  sx - the factor by which coordinates are scaled along the X axis direction - `double`
  sy - the factor by which coordinates are scaled along the Y axis direction - `double`

  returns: an AffineTransform object that scales
    coordinates by the specified factors. - `java.awt.geom.AffineTransform`"
  ([^Double sx ^Double sy]
    (AffineTransform/getScaleInstance sx sy)))

(defn *get-shear-instance
  "Returns a transform representing a shearing transformation.
   The matrix representing the returned transform is:


            [   1   shx   0   ]
            [  shy   1    0   ]
            [   0    0    1   ]

  shx - the multiplier by which coordinates are shifted in the direction of the positive X axis as a factor of their Y coordinate - `double`
  shy - the multiplier by which coordinates are shifted in the direction of the positive Y axis as a factor of their X coordinate - `double`

  returns: an AffineTransform object that shears
    coordinates by the specified multipliers. - `java.awt.geom.AffineTransform`"
  ([^Double shx ^Double shy]
    (AffineTransform/getShearInstance shx shy)))

(defn invert
  "Sets this transform to the inverse of itself.
   The inverse transform Tx' of this transform Tx
   maps coordinates transformed by Tx back
   to their original coordinates.
   In other words, Tx'(Tx(p)) = p = Tx(Tx'(p)).

   If this transform maps all coordinates onto a point or a line
   then it will not have an inverse, since coordinates that do
   not lie on the destination point or line will not have an inverse
   mapping.
   The getDeterminant method can be used to determine if this
   transform has no inverse, in which case an exception will be
   thrown if the invert method is called.

  throws: java.awt.geom.NoninvertibleTransformException - if the matrix cannot be inverted."
  ([^java.awt.geom.AffineTransform this]
    (-> this (.invert))))

(defn get-type
  "Retrieves the flag bits describing the conversion properties of
   this transform.
   The return value is either one of the constants TYPE_IDENTITY
   or TYPE_GENERAL_TRANSFORM, or a combination of the
   appropriate flag bits.
   A valid combination of flag bits is an exclusive OR operation
   that can combine
   the TYPE_TRANSLATION flag bit
   in addition to either of the
   TYPE_UNIFORM_SCALE or TYPE_GENERAL_SCALE flag bits
   as well as either of the
   TYPE_QUADRANT_ROTATION or TYPE_GENERAL_ROTATION flag bits.

  returns: the OR combination of any of the indicated flags that
   apply to this transform - `int`"
  ([^java.awt.geom.AffineTransform this]
    (-> this (.getType))))

(defn identity?
  "Returns true if this AffineTransform is
   an identity transform.

  returns: true if this AffineTransform is
   an identity transform; false otherwise. - `boolean`"
  ([^java.awt.geom.AffineTransform this]
    (-> this (.isIdentity))))

(defn translate
  "Concatenates this transform with a translation transformation.
   This is equivalent to calling concatenate(T), where T is an
   AffineTransform represented by the following matrix:


            [   1    0    tx  ]
            [   0    1    ty  ]
            [   0    0    1   ]

  tx - the distance by which coordinates are translated in the X axis direction - `double`
  ty - the distance by which coordinates are translated in the Y axis direction - `double`"
  ([^java.awt.geom.AffineTransform this ^Double tx ^Double ty]
    (-> this (.translate tx ty))))

(defn scale
  "Concatenates this transform with a scaling transformation.
   This is equivalent to calling concatenate(S), where S is an
   AffineTransform represented by the following matrix:


            [   sx   0    0   ]
            [   0    sy   0   ]
            [   0    0    1   ]

  sx - the factor by which coordinates are scaled along the X axis direction - `double`
  sy - the factor by which coordinates are scaled along the Y axis direction - `double`"
  ([^java.awt.geom.AffineTransform this ^Double sx ^Double sy]
    (-> this (.scale sx sy))))

(defn get-translate-y
  "Returns the Y coordinate of the translation element (m12) of the
   3x3 affine transformation matrix.

  returns: a double value that is the Y coordinate of the translation
    element of the affine transformation matrix. - `double`"
  ([^java.awt.geom.AffineTransform this]
    (-> this (.getTranslateY))))

(defn delta-transform
  "Transforms an array of relative distance vectors by this
   transform.
   A relative distance vector is transformed without applying the
   translation components of the affine transformation matrix
   using the following equations:


    [  x' ]   [  m00  m01 (m02) ] [  x  ]   [ m00x  m01y ]
    [  y' ] = [  m10  m11 (m12) ] [  y  ] = [ m10x  m11y ]
    [ (1) ]   [  (0)  (0) ( 1 ) ] [ (1) ]   [     (1)     ]
   The two coordinate array sections can be exactly the same or
   can be overlapping sections of the same array without affecting the
   validity of the results.
   This method ensures that no source coordinates are
   overwritten by a previous operation before they can be transformed.
   The coordinates are stored in the arrays starting at the indicated
   offset in the order [x0, y0, x1, y1, ..., xn, yn].

  src-pts - the array containing the source distance vectors. Each vector is stored as a pair of relative x, y coordinates. - `double[]`
  src-off - the offset to the first vector to be transformed in the source array - `int`
  dst-pts - the array into which the transformed distance vectors are returned. Each vector is stored as a pair of relative x, y coordinates. - `double[]`
  dst-off - the offset to the location of the first transformed vector that is stored in the destination array - `int`
  num-pts - the number of vector coordinate pairs to be transformed - `int`"
  ([^java.awt.geom.AffineTransform this src-pts ^Integer src-off dst-pts ^Integer dst-off ^Integer num-pts]
    (-> this (.deltaTransform src-pts src-off dst-pts dst-off num-pts)))
  ([^java.awt.geom.AffineTransform this ^java.awt.geom.Point2D pt-src ^java.awt.geom.Point2D pt-dst]
    (-> this (.deltaTransform pt-src pt-dst))))

(defn transform
  "Transforms an array of point objects by this transform.
   If any element of the ptDst array is
   null, a new Point2D object is allocated
   and stored into that element before storing the results of the
   transformation.

   Note that this method does not take any precautions to
   avoid problems caused by storing results into Point2D
   objects that will be used as the source for calculations
   further down the source array.
   This method does guarantee that if a specified Point2D
   object is both the source and destination for the same single point
   transform operation then the results will not be stored until
   the calculations are complete to avoid storing the results on
   top of the operands.
   If, however, the destination Point2D object for one
   operation is the same object as the source Point2D
   object for another operation further down the source array then
   the original coordinates in that point are overwritten before
   they can be converted.

  pt-src - the array containing the source point objects - `java.awt.geom.Point2D[]`
  src-off - the offset to the first point object to be transformed in the source array - `int`
  pt-dst - the array into which the transform point objects are returned - `java.awt.geom.Point2D[]`
  dst-off - the offset to the location of the first transformed point object that is stored in the destination array - `int`
  num-pts - the number of point objects to be transformed - `int`"
  ([^java.awt.geom.AffineTransform this ^java.awt.geom.Point2D[] pt-src ^Integer src-off ^java.awt.geom.Point2D[] pt-dst ^Integer dst-off ^Integer num-pts]
    (-> this (.transform pt-src src-off pt-dst dst-off num-pts)))
  ([^java.awt.geom.AffineTransform this ^java.awt.geom.Point2D pt-src ^java.awt.geom.Point2D pt-dst]
    (-> this (.transform pt-src pt-dst))))

(defn to-string
  "Returns a String that represents the value of this
   Object.

  returns: a String representing the value of this
   Object. - `java.lang.String`"
  ([^java.awt.geom.AffineTransform this]
    (-> this (.toString))))

(defn get-shear-y
  "Returns the Y coordinate shearing element (m10) of the 3x3
   affine transformation matrix.

  returns: a double value that is the Y coordinate of the shearing
    element of the affine transformation matrix. - `double`"
  ([^java.awt.geom.AffineTransform this]
    (-> this (.getShearY))))

(defn set-to-shear
  "Sets this transform to a shearing transformation.
   The matrix representing this transform becomes:


            [   1   shx   0   ]
            [  shy   1    0   ]
            [   0    0    1   ]

  shx - the multiplier by which coordinates are shifted in the direction of the positive X axis as a factor of their Y coordinate - `double`
  shy - the multiplier by which coordinates are shifted in the direction of the positive Y axis as a factor of their X coordinate - `double`"
  ([^java.awt.geom.AffineTransform this ^Double shx ^Double shy]
    (-> this (.setToShear shx shy))))

(defn create-inverse
  "Returns an AffineTransform object representing the
   inverse transformation.
   The inverse transform Tx' of this transform Tx
   maps coordinates transformed by Tx back
   to their original coordinates.
   In other words, Tx'(Tx(p)) = p = Tx(Tx'(p)).

   If this transform maps all coordinates onto a point or a line
   then it will not have an inverse, since coordinates that do
   not lie on the destination point or line will not have an inverse
   mapping.
   The getDeterminant method can be used to determine if this
   transform has no inverse, in which case an exception will be
   thrown if the createInverse method is called.

  returns: a new AffineTransform object representing the
   inverse transformation. - `java.awt.geom.AffineTransform`

  throws: java.awt.geom.NoninvertibleTransformException - if the matrix cannot be inverted."
  ([^java.awt.geom.AffineTransform this]
    (-> this (.createInverse))))

(defn set-to-identity
  "Resets this transform to the Identity transform."
  ([^java.awt.geom.AffineTransform this]
    (-> this (.setToIdentity))))

(defn set-to-scale
  "Sets this transform to a scaling transformation.
   The matrix representing this transform becomes:


            [   sx   0    0   ]
            [   0    sy   0   ]
            [   0    0    1   ]

  sx - the factor by which coordinates are scaled along the X axis direction - `double`
  sy - the factor by which coordinates are scaled along the Y axis direction - `double`"
  ([^java.awt.geom.AffineTransform this ^Double sx ^Double sy]
    (-> this (.setToScale sx sy))))

(defn get-translate-x
  "Returns the X coordinate of the translation element (m02) of the
   3x3 affine transformation matrix.

  returns: a double value that is the X coordinate of the translation
    element of the affine transformation matrix. - `double`"
  ([^java.awt.geom.AffineTransform this]
    (-> this (.getTranslateX))))

(defn set-to-rotation
  "Sets this transform to a rotation transformation that rotates
   coordinates around an anchor point according to a rotation
   vector.
   All coordinates rotate about the specified anchor coordinates
   by the same amount.
   The amount of rotation is such that coordinates along the former
   positive X axis will subsequently align with the vector pointing
   from the origin to the specified vector coordinates.
   If both vecx and vecy are 0.0,
   the transform is set to an identity transform.
   This operation is equivalent to calling:


       setToTranslation(Math.atan2(vecy, vecx), anchorx, anchory);

  vecx - the X coordinate of the rotation vector - `double`
  vecy - the Y coordinate of the rotation vector - `double`
  anchorx - the X coordinate of the rotation anchor point - `double`
  anchory - the Y coordinate of the rotation anchor point - `double`"
  ([^java.awt.geom.AffineTransform this ^Double vecx ^Double vecy ^Double anchorx ^Double anchory]
    (-> this (.setToRotation vecx vecy anchorx anchory)))
  ([^java.awt.geom.AffineTransform this ^Double theta ^Double anchorx ^Double anchory]
    (-> this (.setToRotation theta anchorx anchory)))
  ([^java.awt.geom.AffineTransform this ^Double vecx ^Double vecy]
    (-> this (.setToRotation vecx vecy)))
  ([^java.awt.geom.AffineTransform this ^Double theta]
    (-> this (.setToRotation theta))))

(defn quadrant-rotate
  "Concatenates this transform with a transform that rotates
   coordinates by the specified number of quadrants around
   the specified anchor point.
   This method is equivalent to calling:


       rotate(numquadrants * Math.PI / 2.0, anchorx, anchory);
   Rotating by a positive number of quadrants rotates points on
   the positive X axis toward the positive Y axis.

  numquadrants - the number of 90 degree arcs to rotate by - `int`
  anchorx - the X coordinate of the rotation anchor point - `double`
  anchory - the Y coordinate of the rotation anchor point - `double`"
  ([^java.awt.geom.AffineTransform this ^Integer numquadrants ^Double anchorx ^Double anchory]
    (-> this (.quadrantRotate numquadrants anchorx anchory)))
  ([^java.awt.geom.AffineTransform this ^Integer numquadrants]
    (-> this (.quadrantRotate numquadrants))))

(defn pre-concatenate
  "Concatenates an AffineTransform Tx to
   this AffineTransform Cx
   in a less commonly used way such that Tx modifies the
   coordinate transformation relative to the absolute pixel
   space rather than relative to the existing user space.
   Cx is updated to perform the combined transformation.
   Transforming a point p by the updated transform Cx' is
   equivalent to first transforming p by the original transform
   Cx and then transforming the result by
   Tx like this:
   Cx'(p) = Tx(Cx(p))
   In matrix notation, if this transform Cx
   is represented by the matrix [this] and Tx is
   represented by the matrix [Tx] then this method does the
   following:


            [this] = [Tx] x [this]

  tx - the AffineTransform object to be concatenated with this AffineTransform object. - `java.awt.geom.AffineTransform`"
  ([^java.awt.geom.AffineTransform this ^java.awt.geom.AffineTransform tx]
    (-> this (.preConcatenate tx))))

(defn get-scale-x
  "Returns the X coordinate scaling element (m00) of the 3x3
   affine transformation matrix.

  returns: a double value that is the X coordinate of the scaling
    element of the affine transformation matrix. - `double`"
  ([^java.awt.geom.AffineTransform this]
    (-> this (.getScaleX))))

(defn get-shear-x
  "Returns the X coordinate shearing element (m01) of the 3x3
   affine transformation matrix.

  returns: a double value that is the X coordinate of the shearing
    element of the affine transformation matrix. - `double`"
  ([^java.awt.geom.AffineTransform this]
    (-> this (.getShearX))))

(defn create-transformed-shape
  "Returns a new Shape object defined by the geometry of the
   specified Shape after it has been transformed by
   this transform.

  p-src - the specified Shape object to be transformed by this transform. - `java.awt.Shape`

  returns: a new Shape object that defines the geometry
   of the transformed Shape, or null if pSrc is null. - `java.awt.Shape`"
  ([^java.awt.geom.AffineTransform this ^java.awt.Shape p-src]
    (-> this (.createTransformedShape p-src))))

(defn clone
  "Returns a copy of this AffineTransform object.

  returns: an Object that is a copy of this
   AffineTransform object. - `java.lang.Object`"
  ([^java.awt.geom.AffineTransform this]
    (-> this (.clone))))

(defn hash-code
  "Returns the hashcode for this transform.

  returns: a hash code for this transform. - `int`"
  ([^java.awt.geom.AffineTransform this]
    (-> this (.hashCode))))

(defn set-to-quadrant-rotation
  "Sets this transform to a translated rotation transformation
   that rotates coordinates by the specified number of quadrants
   around the specified anchor point.
   This operation is equivalent to calling:


       setToRotation(numquadrants * Math.PI / 2.0, anchorx, anchory);
   Rotating by a positive number of quadrants rotates points on
   the positive X axis toward the positive Y axis.

  numquadrants - the number of 90 degree arcs to rotate by - `int`
  anchorx - the X coordinate of the rotation anchor point - `double`
  anchory - the Y coordinate of the rotation anchor point - `double`"
  ([^java.awt.geom.AffineTransform this ^Integer numquadrants ^Double anchorx ^Double anchory]
    (-> this (.setToQuadrantRotation numquadrants anchorx anchory)))
  ([^java.awt.geom.AffineTransform this ^Integer numquadrants]
    (-> this (.setToQuadrantRotation numquadrants))))

(defn inverse-transform
  "Inverse transforms an array of double precision coordinates by
   this transform.
   The two coordinate array sections can be exactly the same or
   can be overlapping sections of the same array without affecting the
   validity of the results.
   This method ensures that no source coordinates are
   overwritten by a previous operation before they can be transformed.
   The coordinates are stored in the arrays starting at the specified
   offset in the order [x0, y0, x1, y1, ..., xn, yn].

  src-pts - the array containing the source point coordinates. Each point is stored as a pair of x, y coordinates. - `double[]`
  src-off - the offset to the first point to be transformed in the source array - `int`
  dst-pts - the array into which the transformed point coordinates are returned. Each point is stored as a pair of x, y coordinates. - `double[]`
  dst-off - the offset to the location of the first transformed point that is stored in the destination array - `int`
  num-pts - the number of point objects to be transformed - `int`

  throws: java.awt.geom.NoninvertibleTransformException - if the matrix cannot be inverted."
  ([^java.awt.geom.AffineTransform this src-pts ^Integer src-off dst-pts ^Integer dst-off ^Integer num-pts]
    (-> this (.inverseTransform src-pts src-off dst-pts dst-off num-pts)))
  ([^java.awt.geom.AffineTransform this ^java.awt.geom.Point2D pt-src ^java.awt.geom.Point2D pt-dst]
    (-> this (.inverseTransform pt-src pt-dst))))

(defn shear
  "Concatenates this transform with a shearing transformation.
   This is equivalent to calling concatenate(SH), where SH is an
   AffineTransform represented by the following matrix:


            [   1   shx   0   ]
            [  shy   1    0   ]
            [   0    0    1   ]

  shx - the multiplier by which coordinates are shifted in the direction of the positive X axis as a factor of their Y coordinate - `double`
  shy - the multiplier by which coordinates are shifted in the direction of the positive Y axis as a factor of their X coordinate - `double`"
  ([^java.awt.geom.AffineTransform this ^Double shx ^Double shy]
    (-> this (.shear shx shy))))

(defn set-transform
  "Sets this transform to the matrix specified by the 6
   double precision values.

  m-00 - the X coordinate scaling element of the 3x3 matrix - `double`
  m-10 - the Y coordinate shearing element of the 3x3 matrix - `double`
  m-01 - the X coordinate shearing element of the 3x3 matrix - `double`
  m-11 - the Y coordinate scaling element of the 3x3 matrix - `double`
  m-02 - the X coordinate translation element of the 3x3 matrix - `double`
  m-12 - the Y coordinate translation element of the 3x3 matrix - `double`"
  ([^java.awt.geom.AffineTransform this ^Double m-00 ^Double m-10 ^Double m-01 ^Double m-11 ^Double m-02 ^Double m-12]
    (-> this (.setTransform m-00 m-10 m-01 m-11 m-02 m-12)))
  ([^java.awt.geom.AffineTransform this ^java.awt.geom.AffineTransform tx]
    (-> this (.setTransform tx))))

(defn get-matrix
  "Retrieves the 6 specifiable values in the 3x3 affine transformation
   matrix and places them into an array of double precisions values.
   The values are stored in the array as
   { m00 m10 m01 m11 m02 m12 }.
   An array of 4 doubles can also be specified, in which case only the
   first four elements representing the non-transform
   parts of the array are retrieved and the values are stored into
   the array as { m00 m10 m01 m11 }

  flatmatrix - the double array used to store the returned values. - `double[]`"
  ([^java.awt.geom.AffineTransform this flatmatrix]
    (-> this (.getMatrix flatmatrix))))

(defn set-to-translation
  "Sets this transform to a translation transformation.
   The matrix representing this transform becomes:


            [   1    0    tx  ]
            [   0    1    ty  ]
            [   0    0    1   ]

  tx - the distance by which coordinates are translated in the X axis direction - `double`
  ty - the distance by which coordinates are translated in the Y axis direction - `double`"
  ([^java.awt.geom.AffineTransform this ^Double tx ^Double ty]
    (-> this (.setToTranslation tx ty))))

(defn rotate
  "Concatenates this transform with a transform that rotates
   coordinates around an anchor point according to a rotation
   vector.
   All coordinates rotate about the specified anchor coordinates
   by the same amount.
   The amount of rotation is such that coordinates along the former
   positive X axis will subsequently align with the vector pointing
   from the origin to the specified vector coordinates.
   If both vecx and vecy are 0.0,
   the transform is not modified in any way.
   This method is equivalent to calling:


       rotate(Math.atan2(vecy, vecx), anchorx, anchory);

  vecx - the X coordinate of the rotation vector - `double`
  vecy - the Y coordinate of the rotation vector - `double`
  anchorx - the X coordinate of the rotation anchor point - `double`
  anchory - the Y coordinate of the rotation anchor point - `double`"
  ([^java.awt.geom.AffineTransform this ^Double vecx ^Double vecy ^Double anchorx ^Double anchory]
    (-> this (.rotate vecx vecy anchorx anchory)))
  ([^java.awt.geom.AffineTransform this ^Double theta ^Double anchorx ^Double anchory]
    (-> this (.rotate theta anchorx anchory)))
  ([^java.awt.geom.AffineTransform this ^Double vecx ^Double vecy]
    (-> this (.rotate vecx vecy)))
  ([^java.awt.geom.AffineTransform this ^Double theta]
    (-> this (.rotate theta))))

(defn equals
  "Returns true if this AffineTransform
   represents the same affine coordinate transform as the specified
   argument.

  obj - the Object to test for equality with this AffineTransform - `java.lang.Object`

  returns: true if obj equals this
   AffineTransform object; false otherwise. - `boolean`"
  ([^java.awt.geom.AffineTransform this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn get-scale-y
  "Returns the Y coordinate scaling element (m11) of the 3x3
   affine transformation matrix.

  returns: a double value that is the Y coordinate of the scaling
    element of the affine transformation matrix. - `double`"
  ([^java.awt.geom.AffineTransform this]
    (-> this (.getScaleY))))

(defn get-determinant
  "Returns the determinant of the matrix representation of the transform.
   The determinant is useful both to determine if the transform can
   be inverted and to get a single value representing the
   combined X and Y scaling of the transform.

   If the determinant is non-zero, then this transform is
   invertible and the various methods that depend on the inverse
   transform do not need to throw a
   NoninvertibleTransformException.
   If the determinant is zero then this transform can not be
   inverted since the transform maps all input coordinates onto
   a line or a point.
   If the determinant is near enough to zero then inverse transform
   operations might not carry enough precision to produce meaningful
   results.

   If this transform represents a uniform scale, as indicated by
   the getType method then the determinant also
   represents the square of the uniform scale factor by which all of
   the points are expanded from or contracted towards the origin.
   If this transform represents a non-uniform scale or more general
   transform then the determinant is not likely to represent a
   value useful for any purpose other than determining if inverse
   transforms are possible.

   Mathematically, the determinant is calculated using the formula:


            |  m00  m01  m02  |
            |  m10  m11  m12  |  =  m00 * m11 - m01 * m10
            |   0    0    1   |

  returns: the determinant of the matrix used to transform the
   coordinates. - `double`"
  ([^java.awt.geom.AffineTransform this]
    (-> this (.getDeterminant))))

(defn concatenate
  "Concatenates an AffineTransform Tx to
   this AffineTransform Cx in the most commonly useful
   way to provide a new user space
   that is mapped to the former user space by Tx.
   Cx is updated to perform the combined transformation.
   Transforming a point p by the updated transform Cx' is
   equivalent to first transforming p by Tx and then
   transforming the result by the original transform Cx like this:
   Cx'(p) = Cx(Tx(p))
   In matrix notation, if this transform Cx is
   represented by the matrix [this] and Tx is represented
   by the matrix [Tx] then this method does the following:


            [this] = [this] x [Tx]

  tx - the AffineTransform object to be concatenated with this AffineTransform object. - `java.awt.geom.AffineTransform`"
  ([^java.awt.geom.AffineTransform this ^java.awt.geom.AffineTransform tx]
    (-> this (.concatenate tx))))

