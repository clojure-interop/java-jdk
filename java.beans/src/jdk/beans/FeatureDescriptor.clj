(ns jdk.beans.FeatureDescriptor
  "The FeatureDescriptor class is the common baseclass for PropertyDescriptor,
  EventSetDescriptor, and MethodDescriptor, etc.

  It supports some common information that can be set and retrieved for
  any of the introspection descriptors.

  In addition it provides an extension mechanism so that arbitrary
  attribute/value pairs can be associated with a design feature."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.beans FeatureDescriptor]))

(defn ->feature-descriptor
  "Constructor.

  Constructs a FeatureDescriptor."
  (^FeatureDescriptor []
    (new FeatureDescriptor )))

(defn expert?
  "The `expert` flag is used to distinguish between those features that are
   intended for expert users from those that are intended for normal users.

  returns: True if this feature is intended for use by experts only. - `boolean`"
  (^Boolean [^FeatureDescriptor this]
    (-> this (.isExpert))))

(defn attribute-names
  "Gets an enumeration of the locale-independent names of this
   feature.

  returns: An enumeration of the locale-independent names of any
      attributes that have been registered with setValue. - `java.util.Enumeration<java.lang.String>`"
  (^java.util.Enumeration [^FeatureDescriptor this]
    (-> this (.attributeNames))))

(defn set-preferred
  "The `preferred` flag is used to identify features that are particularly
   important for presenting to humans.

  preferred - True if this feature should be preferentially shown to human users. - `boolean`"
  ([^FeatureDescriptor this ^Boolean preferred]
    (-> this (.setPreferred preferred))))

(defn set-display-name
  "Sets the localized display name of this feature.

  display-name - The localized display name for the property/method/event. - `java.lang.String`"
  ([^FeatureDescriptor this ^java.lang.String display-name]
    (-> this (.setDisplayName display-name))))

(defn set-name
  "Sets the programmatic name of this feature.

  name - The programmatic name of the property/method/event - `java.lang.String`"
  ([^FeatureDescriptor this ^java.lang.String name]
    (-> this (.setName name))))

(defn to-string
  "Returns a string representation of the object.

  returns: a string representation of the object - `java.lang.String`"
  (^java.lang.String [^FeatureDescriptor this]
    (-> this (.toString))))

(defn get-display-name
  "Gets the localized display name of this feature.

  returns: The localized display name for the property/method/event.
    This defaults to the same as its programmatic name from getName. - `java.lang.String`"
  (^java.lang.String [^FeatureDescriptor this]
    (-> this (.getDisplayName))))

(defn get-value
  "Retrieve a named attribute with this feature.

  attribute-name - The locale-independent name of the attribute - `java.lang.String`

  returns: The value of the attribute.  May be null if
       the attribute is unknown. - `java.lang.Object`"
  (^java.lang.Object [^FeatureDescriptor this ^java.lang.String attribute-name]
    (-> this (.getValue attribute-name))))

(defn set-expert
  "The `expert` flag is used to distinguish between features that are
   intended for expert users from those that are intended for normal users.

  expert - True if this feature is intended for use by experts only. - `boolean`"
  ([^FeatureDescriptor this ^Boolean expert]
    (-> this (.setExpert expert))))

(defn get-short-description
  "Gets the short description of this feature.

  returns: A localized short description associated with this
     property/method/event.  This defaults to be the display name. - `java.lang.String`"
  (^java.lang.String [^FeatureDescriptor this]
    (-> this (.getShortDescription))))

(defn get-name
  "Gets the programmatic name of this feature.

  returns: The programmatic name of the property/method/event - `java.lang.String`"
  (^java.lang.String [^FeatureDescriptor this]
    (-> this (.getName))))

(defn set-hidden
  "The `hidden` flag is used to identify features that are intended only
   for tool use, and which should not be exposed to humans.

  hidden - True if this feature should be hidden from human users. - `boolean`"
  ([^FeatureDescriptor this ^Boolean hidden]
    (-> this (.setHidden hidden))))

(defn hidden?
  "The `hidden` flag is used to identify features that are intended only
   for tool use, and which should not be exposed to humans.

  returns: True if this feature should be hidden from human users. - `boolean`"
  (^Boolean [^FeatureDescriptor this]
    (-> this (.isHidden))))

(defn set-value
  "Associate a named attribute with this feature.

  attribute-name - The locale-independent name of the attribute - `java.lang.String`
  value - The value. - `java.lang.Object`"
  ([^FeatureDescriptor this ^java.lang.String attribute-name ^java.lang.Object value]
    (-> this (.setValue attribute-name value))))

(defn preferred?
  "The `preferred` flag is used to identify features that are particularly
   important for presenting to humans.

  returns: True if this feature should be preferentially shown to human users. - `boolean`"
  (^Boolean [^FeatureDescriptor this]
    (-> this (.isPreferred))))

(defn set-short-description
  "You can associate a short descriptive string with a feature.  Normally
   these descriptive strings should be less than about 40 characters.

  text - A (localized) short description to be associated with this property/method/event. - `java.lang.String`"
  ([^FeatureDescriptor this ^java.lang.String text]
    (-> this (.setShortDescription text))))

