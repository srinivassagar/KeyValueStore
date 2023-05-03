KeyValue Store based on FileSystem

**Highlights**

* Supports very large files as well as its handled in buffer.
* Supports CRUD operation.
* LRU cache is added as cache layer for faster access. If system fails, filesystem data will be used.
* Bucketing applied for better performance.
* Unit test cases Added for corner cases.
* Files will be generated at the project root level.

To Check the scenarios: refer this unit test case
**kvStore.KeyValueStoreTest**

Client class
**kvStore.TestDriver**

