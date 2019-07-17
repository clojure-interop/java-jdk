# Bindings for javax.crypto

These bindings are created to simplify interaction with java classes from clojure.
For each java class was created a separate namespace.
Each method/field has its own function/field binding.
Their names are changed for a more native look in the clojure code. Each function has docstring - information about the parameters, return value and possible exceptions.

## Note

All namespaces starting with **java.** are renamed to **jdk.** (java compiler limitation). 

**java.io.File** renamed to **jdk.io.File** for example. 




## Clojars

```
[clojure-interop/javax.crypto "1.0.0"]
```

## Class Members Naming Conventions

| Class Member | Java | Clojure |
|:--|:--|:--|
| constructor | new File() | (->file) |
| instance method | getAnyValue() | (get-any-value) |
| instance field | instanceField | -instance-field |
| static method | staticMethod() | (*static-method) |
| static field | ANY_STATIC_FIELD | *-any-static-field |
| boolean field/method | isExists(), canUse() | (exists?), (can-use?) |

## Classes

- class **javax.crypto.AEADBadTagException**
- class **javax.crypto.BadPaddingException**
- class **javax.crypto.Cipher**
- class **javax.crypto.CipherInputStream**
- class **javax.crypto.CipherOutputStream**
- class **javax.crypto.CipherSpi**
- class **javax.crypto.EncryptedPrivateKeyInfo**
- class **javax.crypto.ExemptionMechanism**
- class **javax.crypto.ExemptionMechanismException**
- class **javax.crypto.ExemptionMechanismSpi**
- class **javax.crypto.IllegalBlockSizeException**
- class **javax.crypto.KeyAgreement**
- class **javax.crypto.KeyAgreementSpi**
- class **javax.crypto.KeyGenerator**
- class **javax.crypto.KeyGeneratorSpi**
- class **javax.crypto.Mac**
- class **javax.crypto.MacSpi**
- class **javax.crypto.NoSuchPaddingException**
- class **javax.crypto.NullCipher**
- class **javax.crypto.SealedObject**
- interface **javax.crypto.SecretKey**
- class **javax.crypto.SecretKeyFactory**
- class **javax.crypto.SecretKeyFactorySpi**
- class **javax.crypto.ShortBufferException**
- interface **javax.crypto.interfaces.DHKey**
- interface **javax.crypto.interfaces.DHPrivateKey**
- interface **javax.crypto.interfaces.DHPublicKey**
- interface **javax.crypto.interfaces.PBEKey**
- class **javax.crypto.spec.DESKeySpec**
- class **javax.crypto.spec.DESedeKeySpec**
- class **javax.crypto.spec.DHGenParameterSpec**
- class **javax.crypto.spec.DHParameterSpec**
- class **javax.crypto.spec.DHPrivateKeySpec**
- class **javax.crypto.spec.DHPublicKeySpec**
- class **javax.crypto.spec.GCMParameterSpec**
- class **javax.crypto.spec.IvParameterSpec**
- class **javax.crypto.spec.OAEPParameterSpec**
- class **javax.crypto.spec.PBEKeySpec**
- class **javax.crypto.spec.PBEParameterSpec**
- class **javax.crypto.spec.PSource$PSpecified**
- class **javax.crypto.spec.PSource**
- class **javax.crypto.spec.RC2ParameterSpec**
- class **javax.crypto.spec.RC5ParameterSpec**
- class **javax.crypto.spec.SecretKeySpec**

## Contributors

[Eugene Potapenko](https://github.com/potapenko/)

## License

Distributed under the Eclipse Public License, the same as Clojure.
