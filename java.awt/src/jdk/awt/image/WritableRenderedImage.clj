(ns jdk.awt.image.WritableRenderedImage
  "WriteableRenderedImage is a common interface for objects which
  contain or can produce image data in the form of Rasters and
  which can be modified and/or written over.  The image
  data may be stored/produced as a single tile or a regular array
  of tiles.

  WritableRenderedImage provides notification to other interested
  objects when a tile is checked out for writing (via the
  getWritableTile method) and when the last writer of a particular
  tile relinquishes its access (via a call to releaseWritableTile).
  Additionally, it allows any caller to determine whether any tiles
  are currently checked out (via hasTileWriters), and to obtain a
  list of such tiles (via getWritableTileIndices, in the form of a Vector
  of Point objects).

  Objects wishing to be notified of changes in tile writability must
  implement the TileObserver interface, and are added by a
  call to addTileObserver.  Multiple calls to
  addTileObserver for the same object will result in multiple
  notifications.  An existing observer may reduce its notifications
  by calling removeTileObserver; if the observer had no
  notifications the operation is a no-op.

  It is necessary for a WritableRenderedImage to ensure that
  notifications occur only when the first writer acquires a tile and
  the last writer releases it."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.image WritableRenderedImage]))

(defn add-tile-observer
  "Adds an observer.  If the observer is already present,
   it will receive multiple notifications.

  to - the specified TileObserver - `java.awt.image.TileObserver`"
  ([this to]
    (-> this (.addTileObserver to))))

(defn remove-tile-observer
  "Removes an observer.  If the observer was not registered,
   nothing happens.  If the observer was registered for multiple
   notifications, it will now be registered for one fewer.

  to - the specified TileObserver - `java.awt.image.TileObserver`"
  ([this to]
    (-> this (.removeTileObserver to))))

(defn get-writable-tile
  "Checks out a tile for writing.

   The WritableRenderedImage is responsible for notifying all
   of its TileObservers when a tile goes from having
   no writers to having one writer.

  tile-x - the X index of the tile. - `int`
  tile-y - the Y index of the tile. - `int`

  returns: a writable tile. - `java.awt.image.WritableRaster`"
  ([this tile-x tile-y]
    (-> this (.getWritableTile tile-x tile-y))))

(defn release-writable-tile
  "Relinquishes the right to write to a tile.  If the caller
   continues to write to the tile, the results are undefined.
   Calls to this method should only appear in matching pairs
   with calls to getWritableTile; any other use will lead
   to undefined results.

   The WritableRenderedImage is responsible for notifying all of
   its TileObservers when a tile goes from having one writer
   to having no writers.

  tile-x - the X index of the tile. - `int`
  tile-y - the Y index of the tile. - `int`"
  ([this tile-x tile-y]
    (-> this (.releaseWritableTile tile-x tile-y))))

(defn tile-writable?
  "Returns whether a tile is currently checked out for writing.

  tile-x - the X index of the tile. - `int`
  tile-y - the Y index of the tile. - `int`

  returns: true if specified tile is checked out
           for writing; false otherwise. - `boolean`"
  ([this tile-x tile-y]
    (-> this (.isTileWritable tile-x tile-y))))

(defn get-writable-tile-indices
  "Returns an array of Point objects indicating which tiles
   are checked out for writing.  Returns null if none are
   checked out.

  returns: an array containing the locations of tiles that are
           checked out for writing. - `java.awt.Point[]`"
  ([this]
    (-> this (.getWritableTileIndices))))

(defn has-tile-writers?
  "Returns whether any tile is checked out for writing.
   Semantically equivalent to (getWritableTileIndices() != null).

  returns: true if any tiles are checked out for
           writing; false otherwise. - `boolean`"
  ([this]
    (-> this (.hasTileWriters))))

(defn set-data
  "Sets a rect of the image to the contents of the Raster r, which is
   assumed to be in the same coordinate space as the WritableRenderedImage.
   The operation is clipped to the bounds of the WritableRenderedImage.

  r - the specified Raster - `java.awt.image.Raster`"
  ([this r]
    (-> this (.setData r))))

