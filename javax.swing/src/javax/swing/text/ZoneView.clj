(ns javax.swing.text.ZoneView
  "ZoneView is a View implementation that creates zones for which
  the child views are not created or stored until they are needed
  for display or model/view translations.  This enables a substantial
  reduction in memory consumption for situations where the model
  being represented is very large, by building view objects only for
  the region being actively viewed/edited.  The size of the children
  can be estimated in some way, or calculated asynchronously with
  only the result being saved.

  ZoneView extends BoxView to provide a box that implements
  zones for its children.  The zones are special View implementations
  (the children of an instance of this class) that represent only a
  portion of the model that an instance of ZoneView is responsible
  for.  The zones don't create child views until an attempt is made
  to display them. A box shaped view is well suited to this because:


    Boxes are a heavily used view, and having a box that
    provides this behavior gives substantial opportunity
    to plug the behavior into a view hierarchy from the
    view factory.

    Boxes are tiled in one direction, so it is easy to
    divide them into zones in a reliable way.

    Boxes typically have a simple relationship to the model (i.e. they
    create child views that directly represent the child elements).

    Boxes are easier to estimate the size of than some other shapes.


  The default behavior is controlled by two properties, maxZoneSize
  and maxZonesLoaded.  Setting maxZoneSize to Integer.MAX_VALUE would
  have the effect of causing only one zone to be created.  This would
  effectively turn the view into an implementation of the decorator
  pattern.  Setting maxZonesLoaded to a value of Integer.MAX_VALUE would
  cause zones to never be unloaded.  For simplicity, zones are created on
  boundaries represented by the child elements of the element the view is
  responsible for.  The zones can be any View implementation, but the
  default implementation is based upon AsyncBoxView which supports fairly
  large zones efficiently."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text ZoneView]))

(defn ->zone-view
  "Constructor.

  Constructs a ZoneView.

  elem - the element this view is responsible for - `javax.swing.text.Element`
  axis - either View.X_AXIS or View.Y_AXIS - `int`"
  ([^javax.swing.text.Element elem ^Integer axis]
    (new ZoneView elem axis)))

(defn get-maximum-zone-size
  "Get the current maximum zone size.

  returns: `int`"
  (^Integer [^javax.swing.text.ZoneView this]
    (-> this (.getMaximumZoneSize))))

(defn set-maximum-zone-size
  "Set the desired maximum zone size.  A
   zone may get larger than this size if
   a single child view is larger than this
   size since zones are formed on child view
   boundaries.

  size - the number of characters the zone may represent before attempting to break the zone into a smaller size. - `int`"
  ([^javax.swing.text.ZoneView this ^Integer size]
    (-> this (.setMaximumZoneSize size))))

(defn get-max-zones-loaded
  "Get the current setting of the number of zones
   allowed to be loaded at the same time.

  returns: `int`"
  (^Integer [^javax.swing.text.ZoneView this]
    (-> this (.getMaxZonesLoaded))))

(defn set-max-zones-loaded
  "Sets the current setting of the number of zones
   allowed to be loaded at the same time. This will throw an
   IllegalArgumentException if mzl is less
   than 1.

  mzl - the desired maximum number of zones to be actively loaded, must be greater than 0 - `int`

  throws: java.lang.IllegalArgumentException - if mzl is < 1"
  ([^javax.swing.text.ZoneView this ^Integer mzl]
    (-> this (.setMaxZonesLoaded mzl))))

(defn insert-update
  "Gives notification that something was inserted into the document
   in a location that this view is responsible for.  This is largely
   delegated to the superclass, but is reimplemented to update the
   relevant zone (i.e. determine if a zone needs to be split into a
   set of 2 or more zones).

  changes - the change information from the associated document - `javax.swing.event.DocumentEvent`
  a - the current allocation of the view - `java.awt.Shape`
  f - the factory to use to rebuild if the view has children - `javax.swing.text.ViewFactory`"
  ([^javax.swing.text.ZoneView this ^javax.swing.event.DocumentEvent changes ^java.awt.Shape a ^javax.swing.text.ViewFactory f]
    (-> this (.insertUpdate changes a f))))

(defn remove-update
  "Gives notification that something was removed from the document
   in a location that this view is responsible for.  This is largely
   delegated to the superclass, but is reimplemented to update the
   relevant zones (i.e. determine if zones need to be removed or
   joined with another zone).

  changes - the change information from the associated document - `javax.swing.event.DocumentEvent`
  a - the current allocation of the view - `java.awt.Shape`
  f - the factory to use to rebuild if the view has children - `javax.swing.text.ViewFactory`"
  ([^javax.swing.text.ZoneView this ^javax.swing.event.DocumentEvent changes ^java.awt.Shape a ^javax.swing.text.ViewFactory f]
    (-> this (.removeUpdate changes a f))))

