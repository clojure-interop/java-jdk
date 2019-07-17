(ns jdk.awt.image.TileObserver
  "An interface for objects that wish to be informed when tiles
  of a WritableRenderedImage become modifiable by some writer via
  a call to getWritableTile, and when they become unmodifiable via
  the last call to releaseWritableTile."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.image TileObserver]))

(defn tile-update
  "A tile is about to be updated (it is either about to be grabbed
   for writing, or it is being released from writing).

  source - the image that owns the tile. - `java.awt.image.WritableRenderedImage`
  tile-x - the X index of the tile that is being updated. - `int`
  tile-y - the Y index of the tile that is being updated. - `int`
  will-be-writable - If true, the tile will be grabbed for writing; otherwise it is being released. - `boolean`"
  ([^java.awt.image.TileObserver this ^java.awt.image.WritableRenderedImage source ^Integer tile-x ^Integer tile-y ^Boolean will-be-writable]
    (-> this (.tileUpdate source tile-x tile-y will-be-writable))))

