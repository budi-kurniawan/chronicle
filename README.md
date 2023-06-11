# Unique and Fast Timestamp Shared Among Processes

The SharedTimestamp class contains a timestamp method that returns a unique long.


### Support of Java 17 in Chronicle: 
https://chronicle.software/chronicle-support-java-17/


### Running Java class with Maven:
> mvn compile exec:java -Dexec.mainClass="chronicle.Main" -Dexec.arguments="arg1 arg2"

### Running Tests with Maven:
> mvn -Dtest=SharedTimestampTest test


## Known Issues
* Initially, the Map file will have to be created and insert two initial key/value pairs. Running multiple processes at almost the same time may try to insert the key/value pairs twice.
* The last thread calling timestamp() is expected to return the key/value pairs, but if it crashes, the pairs will be missing and subsequent calls to timestamp() will wait forever.

