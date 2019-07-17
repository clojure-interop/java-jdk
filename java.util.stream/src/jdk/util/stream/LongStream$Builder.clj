(ns jdk.util.stream.LongStream$Builder
  "A mutable builder for a LongStream.

  A stream builder has a lifecycle, which starts in a building
  phase, during which elements can be added, and then transitions to a built
  phase, after which elements may not be added.  The built phase begins
  begins when the build() method is called, which creates an
  ordered stream whose elements are the elements that were added to the
  stream builder, in the order they were added."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.stream LongStream$Builder]))

(defn accept
  "Adds an element to the stream being built.

  t - the input argument - `long`

  throws: java.lang.IllegalStateException - if the builder has already transitioned to the built state"
  ([^java.util.stream.LongStream$Builder this ^Long t]
    (-> this (.accept t))))

(defn add
  "Adds an element to the stream being built.

  t - the element to add - `long`

  returns: this builder - `default java.util.stream.LongStream.Builder`

  throws: java.lang.IllegalStateException - if the builder has already transitioned to the built state"
  ([^java.util.stream.LongStream$Builder this ^Long t]
    (-> this (.add t))))

(defn build
  "Builds the stream, transitioning this builder to the built state.
   An IllegalStateException is thrown if there are further
   attempts to operate on the builder after it has entered the built
   state.

  returns: the built stream - `java.util.stream.LongStream`

  throws: java.lang.IllegalStateException - if the builder has already transitioned to the built state"
  ([^java.util.stream.LongStream$Builder this]
    (-> this (.build))))

