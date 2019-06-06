<b>Program to translate a word or phrase from Spanish to the English language.</b>

<b>To run with maven:</b><br>
<i>mvn install -Dexec.args="[language_source] [language_target] ['word/phrase to translate']"</i>

Example:<br>
<i>mvn install -Dexec.args="Spanish English 'hola mundo'</i>

<b>To run the .jar:</b><br>
<i>java -jar [generated-jar-with-dependencies] [language_source] [language_target] ["word/phrase to translate"]</i>

Example:<br>
<i>java -jar translator-1.0-SNAPSHOT-jar-with-dependencies.jar Spanish English "hola mundo"</i>

<b>The program output:</b><br>
Translated to English: ['word/phrase translated']

<p>By default, the program assigns the logging file and the gecko driver that there is in the resources folder.
Besides, We are ignoring the firefox logs. However, you can establish the above properties as follow:</p>

<i>java -Djava.util.logging.config.file="J:\logging.properties" -Dwebdriver.gecko.driver="J:\geckodriver.exe" -Dwebdriver.firefox.logfile="J:\log.txt" -jar translator-1.0-SNAPSHOT-jar-with-dependencies.jar Spanish English "hola mundo"</i>




