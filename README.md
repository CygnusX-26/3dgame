# Poll-Digital
![alt text](https://github.com/CygnusX-26/Poll-Digital/blob/master/logo.png?raw=true)
## Why Use Poll-Digital? 
---
> `Votes can be cast virtually`
> `Tamper-proof way of counting votes`
> `Better ballot security`
> `Lower cost`
---
## Block 
---
Each block has the following properties

> `hash` 
  - Sha256 encoded hash of "previousHash + data + timeStamp + nonce"
> `previousHash` 
  - Hash of the previous block
> `data`
 - SHA256 Encrypted SSN of a voter
> `timeStamp`
 - current epoch time of day
> `nonce`
- random string used to ensure block uniqueness
---
## BlockChain
---
 - ArrayList of blocks 

> isChainValid 
- > `Checks every hash of every block and makes sure it corresponds to the block's SHA256(previousHash + data + timestamp + nonce)`
- > `Ensures that no blocks are tampered before votes are counted` 
