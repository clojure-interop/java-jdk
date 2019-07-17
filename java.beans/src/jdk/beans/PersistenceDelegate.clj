(ns jdk.beans.PersistenceDelegate
  "The PersistenceDelegate class takes the responsibility
  for expressing the state of an instance of a given class
  in terms of the methods in the class's public API. Instead
  of associating the responsibility of persistence with
  the class itself as is done, for example, by the
  readObject and writeObject
  methods used by the ObjectOutputStream, streams like
  the XMLEncoder which
  use this delegation model can have their behavior controlled
  independently of the classes themselves. Normally, the class
  is the best place to put such information and conventions
  can easily be expressed in this delegation scheme to do just that.
  Sometimes however, it is the case that a minor problem
  in a single class prevents an entire object graph from
  being written and this can leave the application
  developer with no recourse but to attempt to shadow
  the problematic classes locally or use alternative
  persistence techniques. In situations like these, the
  delegation model gives a relatively clean mechanism for
  the application developer to intervene in all parts of the
  serialization process without requiring that modifications
  be made to the implementation of classes which are not part
  of the application itself.

  In addition to using a delegation model, this persistence
  scheme differs from traditional serialization schemes
  in requiring an analog of the writeObject
  method without a corresponding readObject
  method. The writeObject analog encodes each
  instance in terms of its public API and there is no need to
  define a readObject analog
  since the procedure for reading the serialized form
  is defined by the semantics of method invocation as laid
  out in the Java Language Specification.
  Breaking the dependency between writeObject
  and readObject implementations, which may
  change from version to version, is the key factor
  in making the archives produced by this technique immune
  to changes in the private implementations of the classes
  to which they refer.

  A persistence delegate, may take control of all
  aspects of the persistence of an object including:


  Deciding whether or not an instance can be mutated
  into another instance of the same class.

  Instantiating the object, either by calling a
  public constructor or a public factory method.

  Performing the initialization of the object."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.beans PersistenceDelegate]))

(defn ->persistence-delegate
  "Constructor."
  ([]
    (new PersistenceDelegate )))

(defn write-object
  "The writeObject is a single entry point to the persistence
   and is used by a Encoder in the traditional
   mode of delegation. Although this method is not final,
   it should not need to be subclassed under normal circumstances.

   This implementation first checks to see if the stream
   has already encountered this object. Next the
   mutatesTo method is called to see if
   that candidate returned from the stream can
   be mutated into an accurate copy of oldInstance.
   If it can, the initialize method is called to
   perform the initialization. If not, the candidate is removed
   from the stream, and the instantiate method
   is called to create a new candidate for this object.

  old-instance - The instance that will be created by this expression. - `java.lang.Object`
  out - The stream to which this expression will be written. - `java.beans.Encoder`

  throws: java.lang.NullPointerException - if out is null"
  ([this old-instance out]
    (-> this (.writeObject old-instance out))))

