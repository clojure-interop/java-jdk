(ns javax.swing.text.StyleContext
  "A pool of styles and their associated resources.  This class determines
  the lifetime of a group of resources by being a container that holds
  caches for various resources such as font and color that get reused
  by the various style definitions.  This can be shared by multiple
  documents if desired to maximize the sharing of related resources.

  This class also provides efficient support for small sets of attributes
  and compresses them by sharing across uses and taking advantage of
  their immutable nature.  Since many styles are replicated, the potential
  for sharing is significant, and copies can be extremely cheap.
  Larger sets reduce the possibility of sharing, and therefore revert
  automatically to a less space-efficient implementation.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text StyleContext]))

(defn ->style-context
  "Constructor.

  Creates a new StyleContext object."
  ([]
    (new StyleContext )))

(def *-default-style
  "Static Constant.

  The name given to the default logical style attached
   to paragraphs.

  type: java.lang.String"
  StyleContext/DEFAULT_STYLE)

(defn *get-default-style-context
  "Returns default AttributeContext shared by all documents that
   don't bother to define/supply their own context.

  returns: the context - `javax.swing.text.StyleContext`"
  (^javax.swing.text.StyleContext []
    (StyleContext/getDefaultStyleContext )))

(defn *write-attribute-set
  "Writes a set of attributes to the given object stream
   for the purpose of serialization.  This will take
   special care to deal with static attribute keys that
   have been registered wit the
   registerStaticAttributeKey method.
   Any attribute key not registered as a static key
   will be serialized directly.  All values are expected
   to be serializable.

  out - the output stream - `java.io.ObjectOutputStream`
  a - the attribute set - `javax.swing.text.AttributeSet`

  throws: java.io.IOException - on any I/O error"
  ([^java.io.ObjectOutputStream out ^javax.swing.text.AttributeSet a]
    (StyleContext/writeAttributeSet out a)))

(defn *read-attribute-set
  "Reads a set of attributes from the given object input
   stream that have been previously written out with
   writeAttributeSet.  This will try to restore
   keys that were static objects to the static objects in
   the current virtual machine considering only those keys
   that have been registered with the
   registerStaticAttributeKey method.
   The attributes retrieved from the stream will be placed
   into the given mutable set.

  in - the object stream to read the attribute data from. - `java.io.ObjectInputStream`
  a - the attribute set to place the attribute definitions in. - `javax.swing.text.MutableAttributeSet`

  throws: java.lang.ClassNotFoundException - passed upward if encountered when reading the object stream."
  ([^java.io.ObjectInputStream in ^javax.swing.text.MutableAttributeSet a]
    (StyleContext/readAttributeSet in a)))

(defn *register-static-attribute-key
  "Registers an object as a static object that is being
   used as a key in attribute sets.  This allows the key
   to be treated specially for serialization.

   For operation under a 1.1 virtual machine, this
   uses the value returned by toString
   concatenated to the classname.  The value returned
   by toString should not have the class reference
   in it (ie it should be reimplemented from the
   definition in Object) in order to be the same when
   recomputed later.

  key - the non-null object key - `java.lang.Object`"
  ([^java.lang.Object key]
    (StyleContext/registerStaticAttributeKey key)))

(defn *get-static-attribute
  "Returns the object previously registered with
   registerStaticAttributeKey.

  key - `java.lang.Object`

  returns: `java.lang.Object`"
  (^java.lang.Object [^java.lang.Object key]
    (StyleContext/getStaticAttribute key)))

(defn *get-static-attribute-key
  "Returns the String that key will be registered with

  key - `java.lang.Object`

  returns: `java.lang.Object`"
  (^java.lang.Object [^java.lang.Object key]
    (StyleContext/getStaticAttributeKey key)))

(defn add-change-listener
  "Adds a listener to track when styles are added
   or removed.

  l - the change listener - `javax.swing.event.ChangeListener`"
  ([^javax.swing.text.StyleContext this ^javax.swing.event.ChangeListener l]
    (-> this (.addChangeListener l))))

(defn get-foreground
  "Takes a set of attributes and turn it into a foreground color
   specification.  This might be used to specify things
   like brighter, more hue, etc.  By default it simply returns
   the value specified by the StyleConstants.Foreground attribute.

  attr - the set of attributes - `javax.swing.text.AttributeSet`

  returns: the color - `java.awt.Color`"
  (^java.awt.Color [^javax.swing.text.StyleContext this ^javax.swing.text.AttributeSet attr]
    (-> this (.getForeground attr))))

(defn read-attributes
  "Context-specific handling of reading in attributes

  in - `java.io.ObjectInputStream`
  a - `javax.swing.text.MutableAttributeSet`

  throws: java.lang.ClassNotFoundException"
  ([^javax.swing.text.StyleContext this ^java.io.ObjectInputStream in ^javax.swing.text.MutableAttributeSet a]
    (-> this (.readAttributes in a))))

(defn to-string
  "Converts a StyleContext to a String.

  returns: the string - `java.lang.String`"
  (^java.lang.String [^javax.swing.text.StyleContext this]
    (-> this (.toString))))

(defn get-empty-set
  "Fetches an empty AttributeSet.

  returns: the set - `javax.swing.text.AttributeSet`"
  (^javax.swing.text.AttributeSet [^javax.swing.text.StyleContext this]
    (-> this (.getEmptySet))))

(defn remove-change-listener
  "Removes a listener that was tracking styles being
   added or removed.

  l - the change listener - `javax.swing.event.ChangeListener`"
  ([^javax.swing.text.StyleContext this ^javax.swing.event.ChangeListener l]
    (-> this (.removeChangeListener l))))

(defn get-font-metrics
  "Returns font metrics for a font.

  f - the font - `java.awt.Font`

  returns: the metrics - `java.awt.FontMetrics`"
  (^java.awt.FontMetrics [^javax.swing.text.StyleContext this ^java.awt.Font f]
    (-> this (.getFontMetrics f))))

(defn get-change-listeners
  "Returns an array of all the ChangeListeners added
   to this StyleContext with addChangeListener().

  returns: all of the ChangeListeners added or an empty
           array if no listeners have been added - `javax.swing.event.ChangeListener[]`"
  ([^javax.swing.text.StyleContext this]
    (-> this (.getChangeListeners))))

(defn add-style
  "Adds a new style into the style hierarchy.  Style attributes
   resolve from bottom up so an attribute specified in a child
   will override an attribute specified in the parent.

  nm - the name of the style (must be unique within the collection of named styles in the document). The name may be null if the style is unnamed, but the caller is responsible for managing the reference returned as an unnamed style can't be fetched by name. An unnamed style may be useful for things like character attribute overrides such as found in a style run. - `java.lang.String`
  parent - the parent style. This may be null if unspecified attributes need not be resolved in some other style. - `javax.swing.text.Style`

  returns: the created style - `javax.swing.text.Style`"
  (^javax.swing.text.Style [^javax.swing.text.StyleContext this ^java.lang.String nm ^javax.swing.text.Style parent]
    (-> this (.addStyle nm parent))))

(defn remove-attribute
  "Removes an attribute from the set.

   This method is thread safe, although most Swing methods
   are not. Please see
   Concurrency
   in Swing for more information.

  old - the old set of attributes - `javax.swing.text.AttributeSet`
  name - the non-null attribute name - `java.lang.Object`

  returns: the updated attribute set - `javax.swing.text.AttributeSet`"
  (^javax.swing.text.AttributeSet [^javax.swing.text.StyleContext this ^javax.swing.text.AttributeSet old ^java.lang.Object name]
    (-> this (.removeAttribute old name))))

(defn write-attributes
  "Context-specific handling of writing out attributes

  out - `java.io.ObjectOutputStream`
  a - `javax.swing.text.AttributeSet`

  throws: java.io.IOException"
  ([^javax.swing.text.StyleContext this ^java.io.ObjectOutputStream out ^javax.swing.text.AttributeSet a]
    (-> this (.writeAttributes out a))))

(defn get-style-names
  "Fetches the names of the styles defined.

  returns: the list of names as an enumeration - `java.util.Enumeration<?>`"
  (^java.util.Enumeration [^javax.swing.text.StyleContext this]
    (-> this (.getStyleNames))))

(defn add-attributes
  "Adds a set of attributes to the element.

   This method is thread safe, although most Swing methods
   are not. Please see
   Concurrency
   in Swing for more information.

  old - the old attribute set - `javax.swing.text.AttributeSet`
  attr - the attributes to add - `javax.swing.text.AttributeSet`

  returns: the updated attribute set - `javax.swing.text.AttributeSet`"
  (^javax.swing.text.AttributeSet [^javax.swing.text.StyleContext this ^javax.swing.text.AttributeSet old ^javax.swing.text.AttributeSet attr]
    (-> this (.addAttributes old attr))))

(defn reclaim
  "Returns a set no longer needed by the MutableAttributeSet implementation.
   This is useful for operation under 1.1 where there are no weak
   references.  This would typically be called by the finalize method
   of the MutableAttributeSet implementation.

   This method is thread safe, although most Swing methods
   are not. Please see
   Concurrency
   in Swing for more information.

  a - the set to reclaim - `javax.swing.text.AttributeSet`"
  ([^javax.swing.text.StyleContext this ^javax.swing.text.AttributeSet a]
    (-> this (.reclaim a))))

(defn remove-attributes
  "Removes a set of attributes for the element.

   This method is thread safe, although most Swing methods
   are not. Please see
   Concurrency
   in Swing for more information.

  old - the old attribute set - `javax.swing.text.AttributeSet`
  names - the attribute names - `java.util.Enumeration<?>`

  returns: the updated attribute set - `javax.swing.text.AttributeSet`"
  (^javax.swing.text.AttributeSet [^javax.swing.text.StyleContext this ^javax.swing.text.AttributeSet old ^java.util.Enumeration names]
    (-> this (.removeAttributes old names))))

(defn get-font
  "Gets a new font.  This returns a Font from a cache
   if a cached font exists.  If not, a Font is added to
   the cache.  This is basically a low-level cache for
   1.1 font features.

  family - the font family (such as `Monospaced`) - `java.lang.String`
  style - the style of the font (such as Font.PLAIN) - `int`
  size - the point size >= 1 - `int`

  returns: the new font - `java.awt.Font`"
  (^java.awt.Font [^javax.swing.text.StyleContext this ^java.lang.String family ^Integer style ^Integer size]
    (-> this (.getFont family style size)))
  (^java.awt.Font [^javax.swing.text.StyleContext this ^javax.swing.text.AttributeSet attr]
    (-> this (.getFont attr))))

(defn add-attribute
  "Adds an attribute to the given set, and returns
   the new representative set.

   This method is thread safe, although most Swing methods
   are not. Please see
   Concurrency
   in Swing for more information.

  old - the old attribute set - `javax.swing.text.AttributeSet`
  name - the non-null attribute name - `java.lang.Object`
  value - the attribute value - `java.lang.Object`

  returns: the updated attribute set - `javax.swing.text.AttributeSet`"
  (^javax.swing.text.AttributeSet [^javax.swing.text.StyleContext this ^javax.swing.text.AttributeSet old ^java.lang.Object name ^java.lang.Object value]
    (-> this (.addAttribute old name value))))

(defn get-background
  "Takes a set of attributes and turn it into a background color
   specification.  This might be used to specify things
   like brighter, more hue, etc.  By default it simply returns
   the value specified by the StyleConstants.Background attribute.

  attr - the set of attributes - `javax.swing.text.AttributeSet`

  returns: the color - `java.awt.Color`"
  (^java.awt.Color [^javax.swing.text.StyleContext this ^javax.swing.text.AttributeSet attr]
    (-> this (.getBackground attr))))

(defn remove-style
  "Removes a named style previously added to the document.

  nm - the name of the style to remove - `java.lang.String`"
  ([^javax.swing.text.StyleContext this ^java.lang.String nm]
    (-> this (.removeStyle nm))))

(defn get-style
  "Fetches a named style previously added to the document

  nm - the name of the style - `java.lang.String`

  returns: the style - `javax.swing.text.Style`"
  (^javax.swing.text.Style [^javax.swing.text.StyleContext this ^java.lang.String nm]
    (-> this (.getStyle nm))))

