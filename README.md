# Simple SOAP server-client application

Application is based on Gradle build tool, Kotlin as programming language.

Application is divided into two submodules: soap-server and soap-client.

## Generating classes from XSD/WSDL

There're different plugins to generate Java classes from xsd/wsdl files(some are official and some are opensource), 
but in this example, I tried to use JAXB.

### Gradle

I've created a new task "jaxb" to generate Java classes based on a lot of tutorials using JAXB XJC.

But, we use Kotlin, therefore, we need that our generated classes to be compiled for our source code.
In Gradle compilation, the sequence is the following: compileKotlin -> compileJava.
If we change this to "compileKotlin.dependsOn compileJava", we'll get a circular dependency exception.

After several attempts to change the compilation flow, I've decided to create a new compilation task for our generated sources.
This is "compileGenerated", which depends on the task "jaxb" mentioned above.
And compileKotlin depends on the newly created task.
With dependencies everything is ok.

To use generated Java classes in Kotlin code, it was necessary to add the built generated sources to java sourceSets.
And now we can use them.

### Application

XSD scheme I've taken from popular spring tutorials(it's information about some countries)

#### SoapClient

It's a simple web application that goes to another server to get information about some country by name.

#### SoapServer

That's application listens to soap messages with a single request (country by name) and returns a country response.
Countries are stored in memory(Map) because the main idea to get worked application versions communicated by SOAP.


P.S. If you accidentally bumped into this repository and found some inaccuracies, bugs, mistakes, 
it would be great to hear from you about the needed fixes or improvements =)