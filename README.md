Program to translate a word or phrase from Spanish to the English language.

To run with maven:
mvn install -Dexec.args="[language_source] [language_target] ['word/phrase to translate']"

Example:
mvn install -Dexec.args="Spanish English 'hola mundo'

To run the .jar:
java -jar [generated-jar-with-dependencies] [language_source] [language_target] ["word/phrase to translate"]

Example:
java -jar translator-1.0-SNAPSHOT-jar-with-dependencies.jar Spanish English "hola mundo"

The program output:
Translated to English: ['word/phrase translated']

By default, the program assigns the logging file and the gecko driver that there is in the resources folder.
Besides, We are ignoring the firefox logs. However, you can establish the above properties as follow:

java -Djava.util.logging.config.file="J:\logging.properties" -Dwebdriver.gecko.driver="J:\geckodriver.exe" -Dwebdriver.firefox.logfile="J:\log.txt" -jar translator-1.0-SNAPSHOT-jar-with-dependencies.jar Spanish English "hola mundo"




