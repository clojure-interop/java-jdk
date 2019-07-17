(ns jdk.security.SecureRandom
  "This class provides a cryptographically strong random number
  generator (RNG).

  A cryptographically strong random number
  minimally complies with the statistical random number generator tests
  specified in
  FIPS 140-2, Security Requirements for Cryptographic Modules,
  section 4.9.1.
  Additionally, SecureRandom must produce non-deterministic output.
  Therefore any seed material passed to a SecureRandom object must be
  unpredictable, and all SecureRandom output sequences must be
  cryptographically strong, as described in

  RFC 1750: Randomness Recommendations for Security.

  A caller obtains a SecureRandom instance via the
  no-argument constructor or one of the getInstance methods:



       SecureRandom random = new SecureRandom();

   Many SecureRandom implementations are in the form of a pseudo-random
  number generator (PRNG), which means they use a deterministic algorithm
  to produce a pseudo-random sequence from a true random seed.
  Other implementations may produce true random numbers,
  and yet others may use a combination of both techniques.

   Typical callers of SecureRandom invoke the following methods
  to retrieve random bytes:



       SecureRandom random = new SecureRandom();
       byte bytes[] = new byte[20];
       random.nextBytes(bytes);

   Callers may also invoke the generateSeed method
  to generate a given number of seed bytes (to seed other random number
  generators, for example):


       byte seed[] = random.generateSeed(20);

  Note: Depending on the implementation, the generateSeed and
  nextBytes methods may block as entropy is being gathered,
  for example, if they need to read from /dev/random on various Unix-like
  operating systems."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security SecureRandom]))

(defn ->secure-random
  "Constructor.

  Constructs a secure random number generator (RNG) implementing the
   default random number algorithm.
   The SecureRandom instance is seeded with the specified seed bytes.

    This constructor traverses the list of registered security Providers,
   starting with the most preferred Provider.
   A new SecureRandom object encapsulating the
   SecureRandomSpi implementation from the first
   Provider that supports a SecureRandom (RNG) algorithm is returned.
   If none of the Providers support a RNG algorithm,
   then an implementation-specific default is returned.

    Note that the list of registered providers may be retrieved via
   the Security.getProviders() method.

    See the SecureRandom section in the
   Java Cryptography Architecture Standard Algorithm Name Documentation
   for information about standard RNG algorithm names.

  seed - the seed. - `byte[]`"
  ([seed]
    (new SecureRandom seed))
  ([]
    (new SecureRandom )))

(defn *get-instance
  "Returns a SecureRandom object that implements the specified
   Random Number Generator (RNG) algorithm.

    A new SecureRandom object encapsulating the
   SecureRandomSpi implementation from the specified provider
   is returned.  The specified provider must be registered
   in the security provider list.

    Note that the list of registered providers may be retrieved via
   the Security.getProviders() method.

    The returned SecureRandom object has not been seeded.  To seed the
   returned object, call the setSeed method.
   If setSeed is not called, the first call to
   nextBytes will force the SecureRandom object to seed itself.
   This self-seeding will not occur if setSeed was
   previously called.

  algorithm - the name of the RNG algorithm. See the SecureRandom section in the Java Cryptography Architecture Standard Algorithm Name Documentation for information about standard RNG algorithm names. - `java.lang.String`
  provider - the name of the provider. - `java.lang.String`

  returns: the new SecureRandom object. - `java.security.SecureRandom`

  throws: java.security.NoSuchAlgorithmException - if a SecureRandomSpi implementation for the specified algorithm is not available from the specified provider."
  (^java.security.SecureRandom [^java.lang.String algorithm ^java.lang.String provider]
    (SecureRandom/getInstance algorithm provider))
  (^java.security.SecureRandom [^java.lang.String algorithm]
    (SecureRandom/getInstance algorithm)))

(defn *get-seed
  "Returns the given number of seed bytes, computed using the seed
   generation algorithm that this class uses to seed itself.  This
   call may be used to seed other random number generators.

   This method is only included for backwards compatibility.
   The caller is encouraged to use one of the alternative
   getInstance methods to obtain a SecureRandom object, and
   then call the generateSeed method to obtain seed bytes
   from that object.

  num-bytes - the number of seed bytes to generate. - `int`

  returns: the seed bytes. - `byte[]`"
  ([^Integer num-bytes]
    (SecureRandom/getSeed num-bytes)))

(defn *get-instance-strong
  "Returns a SecureRandom object that was selected by using
   the algorithms/providers specified in the securerandom.strongAlgorithms Security property.

   Some situations require strong random values, such as when
   creating high-value/long-lived secrets like RSA public/private
   keys.  To help guide applications in selecting a suitable strong
   SecureRandom implementation, Java distributions
   include a list of known strong SecureRandom
   implementations in the securerandom.strongAlgorithms
   Security property.

   Every implementation of the Java platform is required to
   support at least one strong SecureRandom implementation.

  returns: a strong SecureRandom implementation as indicated
   by the securerandom.strongAlgorithms Security property - `java.security.SecureRandom`

  throws: java.security.NoSuchAlgorithmException - if no algorithm is available"
  (^java.security.SecureRandom []
    (SecureRandom/getInstanceStrong )))

(defn get-provider
  "Returns the provider of this SecureRandom object.

  returns: the provider of this SecureRandom object. - `java.security.Provider`"
  (^java.security.Provider [^java.security.SecureRandom this]
    (-> this (.getProvider))))

(defn get-algorithm
  "Returns the name of the algorithm implemented by this SecureRandom
   object.

  returns: the name of the algorithm or unknown
            if the algorithm name cannot be determined. - `java.lang.String`"
  (^java.lang.String [^java.security.SecureRandom this]
    (-> this (.getAlgorithm))))

(defn set-seed
  "Reseeds this random object. The given seed supplements, rather than
   replaces, the existing seed. Thus, repeated calls are guaranteed
   never to reduce randomness.

  seed - the seed. - `byte[]`"
  ([^java.security.SecureRandom this seed]
    (-> this (.setSeed seed))))

(defn next-bytes
  "Generates a user-specified number of random bytes.

    If a call to setSeed had not occurred previously,
   the first call to this method forces this SecureRandom object
   to seed itself.  This self-seeding will not occur if
   setSeed was previously called.

  bytes - the array to be filled in with random bytes. - `byte[]`"
  ([^java.security.SecureRandom this bytes]
    (-> this (.nextBytes bytes))))

(defn generate-seed
  "Returns the given number of seed bytes, computed using the seed
   generation algorithm that this class uses to seed itself.  This
   call may be used to seed other random number generators.

  num-bytes - the number of seed bytes to generate. - `int`

  returns: the seed bytes. - `byte[]`"
  ([^java.security.SecureRandom this ^Integer num-bytes]
    (-> this (.generateSeed num-bytes))))

