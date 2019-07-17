(ns javax.accessibility.AccessibleRelation
  "Class AccessibleRelation describes a relation between the
  object that implements the AccessibleRelation and one or more other
  objects.  The actual relations that an object has with other
  objects are defined as an AccessibleRelationSet, which is a composed
  set of AccessibleRelations.
  The toDisplayString method allows you to obtain the localized string
  for a locale independent key from a predefined ResourceBundle for the
  keys defined in this class.
  The constants in this class present a strongly typed enumeration
  of common object roles. If the constants in this class are not sufficient
  to describe the role of an object, a subclass should be generated
  from this class and it should provide constants in a similar manner."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.accessibility AccessibleRelation]))

(defn ->accessible-relation
  "Constructor.

  Creates a new AccessibleRelation using the given locale independent key.
   The key String should be a locale independent key for the relation.
   It is not intended to be used as the actual String to display
   to the user.  To get the localized string, use toDisplayString.

  key - the locale independent name of the relation. - `java.lang.String`
  target - the target object for this relation - `java.lang.Object`"
  ([^java.lang.String key ^java.lang.Object target]
    (new AccessibleRelation key target))
  ([^java.lang.String key]
    (new AccessibleRelation key)))

(def *-label-for
  "Static Constant.

  Indicates an object is a label for one or more target objects.

  type: java.lang.String"
  AccessibleRelation/LABEL_FOR)

(def *-labeled-by
  "Static Constant.

  Indicates an object is labeled by one or more target objects.

  type: java.lang.String"
  AccessibleRelation/LABELED_BY)

(def *-member-of
  "Static Constant.

  Indicates an object is a member of a group of one or more
   target objects.

  type: java.lang.String"
  AccessibleRelation/MEMBER_OF)

(def *-controller-for
  "Static Constant.

  Indicates an object is a controller for one or more target
   objects.

  type: java.lang.String"
  AccessibleRelation/CONTROLLER_FOR)

(def *-controlled-by
  "Static Constant.

  Indicates an object is controlled by one or more target
   objects.

  type: java.lang.String"
  AccessibleRelation/CONTROLLED_BY)

(def *-flows-to
  "Static Constant.

  Indicates an object is logically contiguous with a second
   object where the second object occurs after the object.
   An example is a paragraph of text that runs to the end of
   a page and continues on the next page with an intervening
   text footer and/or text header.  The two parts of
   the paragraph are separate text elements but are related
   in that the second element is a continuation
   of the first
   element.  In other words, the first element `flows to`
   the second element.

  type: java.lang.String"
  AccessibleRelation/FLOWS_TO)

(def *-flows-from
  "Static Constant.

  Indicates an object is logically contiguous with a second
   object where the second object occurs before the object.
   An example is a paragraph of text that runs to the end of
   a page and continues on the next page with an intervening
   text footer and/or text header.  The two parts of
   the paragraph are separate text elements but are related
   in that the second element is a continuation of the first
   element.  In other words, the second element `flows from`
   the second element.

  type: java.lang.String"
  AccessibleRelation/FLOWS_FROM)

(def *-subwindow-of
  "Static Constant.

  Indicates that an object is a subwindow of one or more
   objects.

  type: java.lang.String"
  AccessibleRelation/SUBWINDOW_OF)

(def *-parent-window-of
  "Static Constant.

  Indicates that an object is a parent window of one or more
   objects.

  type: java.lang.String"
  AccessibleRelation/PARENT_WINDOW_OF)

(def *-embeds
  "Static Constant.

  Indicates that an object has one or more objects
   embedded in it.

  type: java.lang.String"
  AccessibleRelation/EMBEDS)

(def *-embedded-by
  "Static Constant.

  Indicates that an object is embedded in one or more
   objects.

  type: java.lang.String"
  AccessibleRelation/EMBEDDED_BY)

(def *-child-node-of
  "Static Constant.

  Indicates that an object is a child node of one
   or more objects.

  type: java.lang.String"
  AccessibleRelation/CHILD_NODE_OF)

(def *-label-for-property
  "Static Constant.

  Identifies that the target group for a label has changed

  type: java.lang.String"
  AccessibleRelation/LABEL_FOR_PROPERTY)

(def *-labeled-by-property
  "Static Constant.

  Identifies that the objects that are doing the labeling have changed

  type: java.lang.String"
  AccessibleRelation/LABELED_BY_PROPERTY)

(def *-member-of-property
  "Static Constant.

  Identifies that group membership has changed.

  type: java.lang.String"
  AccessibleRelation/MEMBER_OF_PROPERTY)

(def *-controller-for-property
  "Static Constant.

  Identifies that the controller for the target object has changed

  type: java.lang.String"
  AccessibleRelation/CONTROLLER_FOR_PROPERTY)

(def *-controlled-by-property
  "Static Constant.

  Identifies that the target object that is doing the controlling has
   changed

  type: java.lang.String"
  AccessibleRelation/CONTROLLED_BY_PROPERTY)

(def *-flows-to-property
  "Static Constant.

  Indicates the FLOWS_TO relation between two objects
   has changed.

  type: java.lang.String"
  AccessibleRelation/FLOWS_TO_PROPERTY)

(def *-flows-from-property
  "Static Constant.

  Indicates the FLOWS_FROM relation between two objects
   has changed.

  type: java.lang.String"
  AccessibleRelation/FLOWS_FROM_PROPERTY)

(def *-subwindow-of-property
  "Static Constant.

  Indicates the SUBWINDOW_OF relation between two or more objects
   has changed.

  type: java.lang.String"
  AccessibleRelation/SUBWINDOW_OF_PROPERTY)

(def *-parent-window-of-property
  "Static Constant.

  Indicates the PARENT_WINDOW_OF relation between two or more objects
   has changed.

  type: java.lang.String"
  AccessibleRelation/PARENT_WINDOW_OF_PROPERTY)

(def *-embeds-property
  "Static Constant.

  Indicates the EMBEDS relation between two or more objects
   has changed.

  type: java.lang.String"
  AccessibleRelation/EMBEDS_PROPERTY)

(def *-embedded-by-property
  "Static Constant.

  Indicates the EMBEDDED_BY relation between two or more objects
   has changed.

  type: java.lang.String"
  AccessibleRelation/EMBEDDED_BY_PROPERTY)

(def *-child-node-of-property
  "Static Constant.

  Indicates the CHILD_NODE_OF relation between two or more objects
   has changed.

  type: java.lang.String"
  AccessibleRelation/CHILD_NODE_OF_PROPERTY)

(defn get-key
  "Returns the key for this relation

  returns: the key for this relation - `java.lang.String`"
  ([^javax.accessibility.AccessibleRelation this]
    (-> this (.getKey))))

(defn get-target
  "Returns the target objects for this relation

  returns: an array containing the target objects for this relation - `java.lang.Object[]`"
  ([^javax.accessibility.AccessibleRelation this]
    (-> this (.getTarget))))

(defn set-target
  "Sets the target object for this relation

  target - the target object for this relation - `java.lang.Object`"
  ([^javax.accessibility.AccessibleRelation this ^java.lang.Object target]
    (-> this (.setTarget target))))

