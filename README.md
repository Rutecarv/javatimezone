# javatimezone
Daylight Savings Time Utility
Display java UTC for two days of each month of the year

------

Utilitário para mostrar o dia que vai mudar o UTC para o horário de verão.
Ex: Se no seu local, por exemplo (América/Sao_Paulo) o horário de verão começa dia 4, voce pode executar o comando:
 java -jar timezonejavatester-1.0.jar "America/Sao_Paulo" "3" "4" 
O resultado deve ser dia 3 com UTC -3 e dia 4 com UTC -2

------

If you show the wrong value in UTC, update the java data with Timezone Updater Tool:

Em caso de divergencia, atualize o java com o Timezone Updater Tool: 

http://www.oracle.com/technetwork/java/javase/tzupdater-readme-136440.html

java -jar tzupdater.jar -f
