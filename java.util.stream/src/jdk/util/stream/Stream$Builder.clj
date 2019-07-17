(ns jdk.util.stream.Stream$Builder
  "A mutable builder for a Stream.  This allows the creation of a
  Stream by generating elements individually and adding them to the
  Builder (without the copying overhead that comes from using
  an ArrayList as a temporary buffer.)

  A stream builder has a lifecycle, which starts in a building
  phase, during which elements can be added, and then transitions to a built
  phase, after which elements may not be added.  The built phase begins
  when the build() method is called, which creates an ordered
  Stream whose elements are the elements that were added to the stream
  builder, in the order they were added."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.stream Stream$Builder]))

(defn accept
  "Adds an element to the stream being built.

  t - the input argument - `Stream.Builder.T`

  throws: java.lang.IllegalStateException - if the builder has already transitioned to the built state"
  ([^java.util.stream.Stream$Builder this ^Stream.Builder.T t]
    (-> this (.accept t))))

(defn add
  "Adds an element to the stream being built.

  t - the element to add - `Stream.Builder.T`

  returns: this builder - `default java.util.stream.Stream.Builder<Stream.Builder.T>`

  throws: java.lang.IllegalStateException - if the builder has already transitioned to the built state"
  ([^java.util.stream.Stream$Builder this ^Stream.Builder.T t]
    (-> this (.add t))))

(defn build
  "Builds the stream, transitioning this builder to the built state.
   An IllegalStateException is thrown if there are further attempts
   to operate on the builder after it has entered the built state.

  returns: the built stream - `java.util.stream.Stream<Stream.Builder.T>`

  throws: java.lang.IllegalStateException - if the builder has already transitioned to the built state"
  (^java.util.stream.Stream [^java.util.stream.Stream$Builder this]
    (-> this (.build))))

