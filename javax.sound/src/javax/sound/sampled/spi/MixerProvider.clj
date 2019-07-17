(ns javax.sound.sampled.spi.MixerProvider
  "A provider or factory for a particular mixer type.
  This mechanism allows the implementation to determine
  how resources are managed in creation / management of
  a mixer."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sound.sampled.spi MixerProvider]))

(defn ->mixer-provider
  "Constructor."
  ([]
    (new MixerProvider )))

(defn mixer-supported?
  "Indicates whether the mixer provider supports the mixer represented by
   the specified mixer info object.

   The full set of mixer info objects that represent the mixers supported
   by this MixerProvider may be obtained
   through the getMixerInfo method.

  info - an info object that describes the mixer for which support is queried - `javax.sound.sampled.Mixer.Info`

  returns: true if the specified mixer is supported,
       otherwise false - `boolean`"
  ([^javax.sound.sampled.spi.MixerProvider this ^javax.sound.sampled.Mixer.Info info]
    (-> this (.isMixerSupported info))))

(defn get-mixer-info
  "Obtains the set of info objects representing the mixer
   or mixers provided by this MixerProvider.

   The isMixerSupported method returns true
   for all the info objects returned by this method.
   The corresponding mixer instances for the info objects
   are returned by the getMixer method.

  returns: a set of mixer info objects - `javax.sound.sampled.Mixer.Info[]`"
  ([^javax.sound.sampled.spi.MixerProvider this]
    (-> this (.getMixerInfo))))

(defn get-mixer
  "Obtains an instance of the mixer represented by the info object.

   The full set of the mixer info objects that represent the mixers
   supported by this MixerProvider may be obtained
   through the getMixerInfo method.
   Use the isMixerSupported method to test whether
   this MixerProvider supports a particular mixer.

  info - an info object that describes the desired mixer - `javax.sound.sampled.Mixer.Info`

  returns: mixer instance - `javax.sound.sampled.Mixer`

  throws: java.lang.IllegalArgumentException - if the info object specified does not match the info object for a mixer supported by this MixerProvider."
  ([^javax.sound.sampled.spi.MixerProvider this ^javax.sound.sampled.Mixer.Info info]
    (-> this (.getMixer info))))

