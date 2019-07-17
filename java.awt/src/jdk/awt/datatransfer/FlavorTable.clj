(ns jdk.awt.datatransfer.FlavorTable
  "A FlavorMap which relaxes the traditional 1-to-1 restriction of a Map. A
  flavor is permitted to map to any number of natives, and likewise a native
  is permitted to map to any number of flavors. FlavorTables need not be
  symmetric, but typically are."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.datatransfer FlavorTable]))

(defn get-natives-for-flavor
  "Returns a List of String natives to which the
   specified DataFlavor corresponds. The List
   will be sorted from best native to worst. That is, the first native will
   best reflect data in the specified flavor to the underlying native
   platform. The returned List is a modifiable copy of this
   FlavorTable's internal data. Client code is free to modify
   the List without affecting this object.

  flav - the DataFlavor whose corresponding natives should be returned. If null is specified, all natives currently known to this FlavorTable are returned in a non-deterministic order. - `java.awt.datatransfer.DataFlavor`

  returns: a java.util.List of java.lang.String
           objects which are platform-specific representations of platform-
           specific data formats - `java.util.List<java.lang.String>`"
  ([^. this ^java.awt.datatransfer.DataFlavor flav]
    (-> this (.getNativesForFlavor flav))))

(defn get-flavors-for-native
  "Returns a List of DataFlavors to which the
   specified String corresponds. The List will be
   sorted from best DataFlavor to worst. That is, the first
   DataFlavor will best reflect data in the specified
   native to a Java application. The returned List is a
   modifiable copy of this FlavorTable's internal data.
   Client code is free to modify the List without affecting
   this object.

  nat - the native whose corresponding DataFlavors should be returned. If null is specified, all DataFlavors currently known to this FlavorTable are returned in a non-deterministic order. - `java.lang.String`

  returns: a java.util.List of DataFlavor
           objects into which platform-specific data in the specified,
           platform-specific native can be translated - `java.util.List<java.awt.datatransfer.DataFlavor>`"
  ([^. this ^java.lang.String nat]
    (-> this (.getFlavorsForNative nat))))

