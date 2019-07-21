(ns jdk.awt.GraphicsConfigTemplate
  "The GraphicsConfigTemplate class is used to obtain a valid
  GraphicsConfiguration.  A user instantiates one of these
  objects and then sets all non-default attributes as desired.  The
  GraphicsDevice.getBestConfiguration(java.awt.GraphicsConfigTemplate) method found in the
  GraphicsDevice class is then called with this
  GraphicsConfigTemplate.  A valid
  GraphicsConfiguration is returned that meets or exceeds
  what was requested in the GraphicsConfigTemplate."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt GraphicsConfigTemplate]))

(defn ->graphics-config-template
  "Constructor.

  This class is an abstract class so only subclasses can be
   instantiated."
  (^GraphicsConfigTemplate []
    (new GraphicsConfigTemplate )))

(def *-required
  "Static Constant.

  Value used for \"Enum\" (Integer) type.  States that this
   feature is required for the GraphicsConfiguration
   object.  If this feature is not available, do not select the
   GraphicsConfiguration object.

  type: int"
  GraphicsConfigTemplate/REQUIRED)

(def *-preferred
  "Static Constant.

  Value used for \"Enum\" (Integer) type.  States that this
   feature is desired for the GraphicsConfiguration
   object.  A selection with this feature is preferred over a
   selection that does not include this feature, although both
   selections can be considered valid matches.

  type: int"
  GraphicsConfigTemplate/PREFERRED)

(def *-unnecessary
  "Static Constant.

  Value used for \"Enum\" (Integer) type.  States that this
   feature is not necessary for the selection of the
   GraphicsConfiguration object.  A selection
   without this feature is preferred over a selection that
   includes this feature since it is not used.

  type: int"
  GraphicsConfigTemplate/UNNECESSARY)

(defn get-best-configuration
  "Returns the \"best\" configuration possible that passes the
   criteria defined in the GraphicsConfigTemplate.

  gc - the array of GraphicsConfiguration objects to choose from. - `java.awt.GraphicsConfiguration[]`

  returns: a GraphicsConfiguration object that is
   the best configuration possible. - `java.awt.GraphicsConfiguration`"
  (^java.awt.GraphicsConfiguration [^GraphicsConfigTemplate this gc]
    (-> this (.getBestConfiguration gc))))

(defn graphics-config-supported?
  "Returns a boolean indicating whether or
   not the specified GraphicsConfiguration can be
   used to create a drawing surface that supports the indicated
   features.

  gc - the GraphicsConfiguration object to test - `java.awt.GraphicsConfiguration`

  returns: true if this
   GraphicsConfiguration object can be used to create
   surfaces that support the indicated features;
   false if the GraphicsConfiguration can
   not be used to create a drawing surface usable by this Java(tm)
   API. - `boolean`"
  (^Boolean [^GraphicsConfigTemplate this ^java.awt.GraphicsConfiguration gc]
    (-> this (.isGraphicsConfigSupported gc))))

