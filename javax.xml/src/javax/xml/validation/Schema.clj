(ns javax.xml.validation.Schema
  "Immutable in-memory representation of grammar.


  This object represents a set of constraints that can be checked/
  enforced against an XML document.


  A Schema object is thread safe and applications are
  encouraged to share it across many parsers in many threads.


  A Schema object is immutable in the sense that it shouldn't
  change the set of constraints once it is created. In other words,
  if an application validates the same document twice against the same
  Schema, it must always produce the same result.


  A Schema object is usually created from SchemaFactory.


  Two kinds of validators can be created from a Schema object.
  One is Validator, which provides highly-level validation
  operations that cover typical use cases. The other is
  ValidatorHandler, which works on top of SAX for better
  modularity.


  This specification does not refine
  the Object.equals(java.lang.Object) method.
  In other words, if you parse the same schema twice, you may
  still get !schemaA.equals(schemaB)."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.validation Schema]))

(defn new-validator
  "Creates a new Validator for this Schema.

   A validator enforces/checks the set of constraints this object
   represents.

   Implementors should assure that the properties set on the
   SchemaFactory that created this Schema are also
   set on the Validator constructed.

  returns: Always return a non-null valid object. - `javax.xml.validation.Validator`"
  ([^javax.xml.validation.Schema this]
    (-> this (.newValidator))))

(defn new-validator-handler
  "Creates a new ValidatorHandler for this Schema.

   Implementors should assure that the properties set on the
   SchemaFactory that created this Schema are also
   set on the ValidatorHandler constructed.

  returns: Always return a non-null valid object. - `javax.xml.validation.ValidatorHandler`"
  ([^javax.xml.validation.Schema this]
    (-> this (.newValidatorHandler))))

