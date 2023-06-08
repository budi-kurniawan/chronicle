Build a class to provide a 'unique' (long) microsecond timestamp:

1. every time the timestamp() method is called, the value it returns is different to, and higher than, 
the last value returned
2. an instance of the class is safe to be called from multiple threads in the same process and 
invariant #1 should still hold
3. multiple instances of the class can be called from multiple threads and processes on the same machine 
and invariant #1 should still hold (we would suggest you store state in a memory mapped file)
4. the timestamp does not have to be at microsecond resolution - we are happy if System.currentTimeMillis() is 
the underlying time source
5. the timestamp() method should be *fast*!

To implement, you could use just pure Java classes, or you could use Chronicle's MappedFile etc. classes.


Support of Java 17 in Chronicle: https://chronicle.software/chronicle-support-java-17/


problem running with MVN:
https://github.com/OpenHFT/Chronicle-Values/issues/5



Running Java class with Maven:
> mvn compile exec:java -Dexec.mainClass="chronicle.Main" -Dexec.arguments="arg1 arg2"