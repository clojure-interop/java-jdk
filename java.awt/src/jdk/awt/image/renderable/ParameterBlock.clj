(ns jdk.awt.image.renderable.ParameterBlock
  "A ParameterBlock encapsulates all the information about sources and
  parameters (Objects) required by a RenderableImageOp, or other
  classes that process images.

   Although it is possible to place arbitrary objects in the
  source Vector, users of this class may impose semantic constraints
  such as requiring all sources to be RenderedImages or
  RenderableImage.  ParameterBlock itself is merely a container and
  performs no checking on source or parameter types.

   All parameters in a ParameterBlock are objects; convenience
  add and set methods are available that take arguments of base type and
  construct the appropriate subclass of Number (such as
  Integer or Float).  Corresponding get methods perform a
  downward cast and have return values of base type; an exception
  will be thrown if the stored values do not have the correct type.
  There is no way to distinguish between the results of
  `short s; add(s)` and `add(new Short(s))`.

   Note that the get and set methods operate on references.
  Therefore, one must be careful not to share references between
  ParameterBlocks when this is inappropriate.  For example, to create
  a new ParameterBlock that is equal to an old one except for an
  added source, one might be tempted to write:



  ParameterBlock addSource(ParameterBlock pb, RenderableImage im) {
      ParameterBlock pb1 = new ParameterBlock(pb.getSources());
      pb1.addSource(im);
      return pb1;
  }

   This code will have the side effect of altering the original
  ParameterBlock, since the getSources operation returned a reference
  to its source Vector.  Both pb and pb1 share their source Vector,
  and a change in either is visible to both.

   A correct way to write the addSource function is to clone
  the source Vector:



  ParameterBlock addSource (ParameterBlock pb, RenderableImage im) {
      ParameterBlock pb1 = new ParameterBlock(pb.getSources().clone());
      pb1.addSource(im);
      return pb1;
  }

   The clone method of ParameterBlock has been defined to
  perform a clone of both the source and parameter Vectors for
  this reason.  A standard, shallow clone is available as
  shallowClone.

   The addSource, setSource, add, and set methods are
  defined to return 'this' after adding their argument.  This allows
  use of syntax like:



  ParameterBlock pb = new ParameterBlock();
  op = new RenderableImageOp(`operation`, pb.add(arg1).add(arg2));"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.image.renderable ParameterBlock]))

(defn ->parameter-block
  "Constructor.

  Constructs a ParameterBlock with a given Vector of sources and
   Vector of parameters.

  sources - a Vector of source images - `java.util.Vector<java.lang.Object>`
  parameters - a Vector of parameters to be used in the rendering operation - `java.util.Vector<java.lang.Object>`"
  ([sources parameters]
    (new ParameterBlock sources parameters))
  ([sources]
    (new ParameterBlock sources))
  ([]
    (new ParameterBlock )))

(defn get-object-parameter
  "Gets a parameter as an object.

  index - the index of the parameter to get - `int`

  returns: an Object representing the
           the parameter at the specified index
           into the parameters
           Vector. - `java.lang.Object`"
  ([this index]
    (-> this (.getObjectParameter index))))

(defn set-parameters
  "Sets the entire Vector of parameters to a given Vector.

  parameters - the specified Vector of parameters - `java.util.Vector<java.lang.Object>`"
  ([this parameters]
    (-> this (.setParameters parameters))))

(defn get-num-sources
  "Returns the number of source images.

  returns: the number of source images in the sources
           Vector. - `int`"
  ([this]
    (-> this (.getNumSources))))

(defn get-param-classes
  "Returns an array of Class objects describing the types
   of the parameters.

  returns: an array of Class objects. - `java.lang.Class[]`"
  ([this]
    (-> this (.getParamClasses))))

(defn add-source
  "Adds an image to end of the list of sources.  The image is
   stored as an object in order to allow new node types in the
   future.

  source - an image object to be stored in the source list. - `java.lang.Object`

  returns: a new ParameterBlock containing the specified
           source. - `java.awt.image.renderable.ParameterBlock`"
  ([this source]
    (-> this (.addSource source))))

(defn remove-parameters
  "Clears the list of parameters."
  ([this]
    (-> this (.removeParameters))))

(defn set-sources
  "Sets the entire Vector of sources to a given Vector.

  sources - the Vector of source images - `java.util.Vector<java.lang.Object>`"
  ([this sources]
    (-> this (.setSources sources))))

(defn get-parameters
  "Returns the entire Vector of parameters.

  returns: the parameters Vector. - `java.util.Vector<java.lang.Object>`"
  ([this]
    (-> this (.getParameters))))

(defn get-int-parameter
  "A convenience method to return a parameter as an int.  An
   exception is thrown if the parameter is
   null or not an Integer.

  index - the index of the parameter to be returned. - `int`

  returns: the parameter at the specified index
           as a int value. - `int`

  throws: java.lang.ClassCastException - if the parameter at the specified index is not a Integer"
  ([this index]
    (-> this (.getIntParameter index))))

(defn get-byte-parameter
  "A convenience method to return a parameter as a byte.  An
   exception is thrown if the parameter is
   null or not a Byte.

  index - the index of the parameter to be returned. - `int`

  returns: the parameter at the specified index
           as a byte value. - `byte`

  throws: java.lang.ClassCastException - if the parameter at the specified index is not a Byte"
  ([this index]
    (-> this (.getByteParameter index))))

(defn get-source
  "Returns a source as a general Object.  The caller must cast it into
   an appropriate type.

  index - the index of the source to be returned. - `int`

  returns: an Object that represents the source located
           at the specified index in the sources
           Vector. - `java.lang.Object`"
  ([this index]
    (-> this (.getSource index))))

(defn get-long-parameter
  "A convenience method to return a parameter as a long.  An
   exception is thrown if the parameter is
   null or not a Long.

  index - the index of the parameter to be returned. - `int`

  returns: the parameter at the specified index
           as a long value. - `long`

  throws: java.lang.ClassCastException - if the parameter at the specified index is not a Long"
  ([this index]
    (-> this (.getLongParameter index))))

(defn get-double-parameter
  "A convenience method to return a parameter as a double.  An
   exception is thrown if the parameter is
   null or not a Double.

  index - the index of the parameter to be returned. - `int`

  returns: the parameter at the specified index
           as a double value. - `double`

  throws: java.lang.ClassCastException - if the parameter at the specified index is not a Double"
  ([this index]
    (-> this (.getDoubleParameter index))))

(defn get-rendered-source
  "Returns a source as a RenderedImage.  This method is
   a convenience method.
   An exception will be thrown if the source is not a RenderedImage.

  index - the index of the source to be returned - `int`

  returns: a RenderedImage that represents the source
           image that is at the specified index in the
           sources Vector. - `java.awt.image.RenderedImage`"
  ([this index]
    (-> this (.getRenderedSource index))))

(defn clone
  "Creates a copy of a ParameterBlock.  The source and parameter
   Vectors are cloned, but the actual sources and parameters are
   copied by reference.  This allows modifications to the order
   and number of sources and parameters in the clone to be invisible
   to the original ParameterBlock.  Changes to the shared sources or
   parameters themselves will still be visible.

  returns: an Object clone of the ParameterBlock. - `java.lang.Object`"
  ([this]
    (-> this (.clone))))

(defn remove-sources
  "Clears the list of source images."
  ([this]
    (-> this (.removeSources))))

(defn add
  "Adds an object to the list of parameters.

  obj - the Object to add to the parameters Vector - `java.lang.Object`

  returns: a new ParameterBlock containing
           the specified parameter. - `java.awt.image.renderable.ParameterBlock`"
  ([this obj]
    (-> this (.add obj))))

(defn get-num-parameters
  "Returns the number of parameters (not including source images).

  returns: the number of parameters in the parameters
           Vector. - `int`"
  ([this]
    (-> this (.getNumParameters))))

(defn set
  "Replaces an Object in the list of parameters.
   If the index lies beyond the current source list,
   the list is extended with nulls as needed.

  obj - the parameter that replaces the parameter at the specified index in the parameters Vector - `java.lang.Object`
  index - the index of the parameter to be replaced with the specified parameter - `int`

  returns: a new ParameterBlock containing
          the specified parameter. - `java.awt.image.renderable.ParameterBlock`"
  ([this obj index]
    (-> this (.set obj index))))

(defn get-renderable-source
  "Returns a source as a RenderableImage.  This method is a
   convenience method.
   An exception will be thrown if the sources is not a RenderableImage.

  index - the index of the source to be returned - `int`

  returns: a RenderableImage that represents the source
           image that is at the specified index in the
           sources Vector. - `java.awt.image.renderable.RenderableImage`"
  ([this index]
    (-> this (.getRenderableSource index))))

(defn shallow-clone
  "Creates a shallow copy of a ParameterBlock.  The source and
   parameter Vectors are copied by reference -- additions or
   changes will be visible to both versions.

  returns: an Object clone of the ParameterBlock. - `java.lang.Object`"
  ([this]
    (-> this (.shallowClone))))

(defn get-sources
  "Returns the entire Vector of sources.

  returns: the sources Vector. - `java.util.Vector<java.lang.Object>`"
  ([this]
    (-> this (.getSources))))

(defn get-char-parameter
  "A convenience method to return a parameter as a char.  An
   exception is thrown if the parameter is
   null or not a Character.

  index - the index of the parameter to be returned. - `int`

  returns: the parameter at the specified index
           as a char value. - `char`

  throws: java.lang.ClassCastException - if the parameter at the specified index is not a Character"
  ([this index]
    (-> this (.getCharParameter index))))

(defn get-short-parameter
  "A convenience method to return a parameter as a short.  An
   exception is thrown if the parameter is
   null or not a Short.

  index - the index of the parameter to be returned. - `int`

  returns: the parameter at the specified index
           as a short value. - `short`

  throws: java.lang.ClassCastException - if the parameter at the specified index is not a Short"
  ([this index]
    (-> this (.getShortParameter index))))

(defn set-source
  "Replaces an entry in the list of source with a new source.
   If the index lies beyond the current source list,
   the list is extended with nulls as needed.

  source - the specified source image - `java.lang.Object`
  index - the index into the sources Vector at which to insert the specified source - `int`

  returns: a new ParameterBlock that contains the
           specified source at the specified
           index. - `java.awt.image.renderable.ParameterBlock`"
  ([this source index]
    (-> this (.setSource source index))))

(defn get-float-parameter
  "A convenience method to return a parameter as a float.  An
   exception is thrown if the parameter is
   null or not a Float.

  index - the index of the parameter to be returned. - `int`

  returns: the parameter at the specified index
           as a float value. - `float`

  throws: java.lang.ClassCastException - if the parameter at the specified index is not a Float"
  ([this index]
    (-> this (.getFloatParameter index))))

