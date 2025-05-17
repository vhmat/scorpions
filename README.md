# scorpions
Aplicação Web que registra o número de ocorrências de escorpiões na cidade de Hortolândia/SP.

# TECNOLOGIAS A SEREM CONFIGURADAS
Para utilizar a aplicação localmente, algumas tecnologias deverão ser configuradas.

Java 17 (LTS) - Disponível em: https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html (Windows x64 Installer)  
	Após instalar, configurar nas variáveis de ambiente  
Maven 3.9.9 - Disponível em: https://maven.apache.org/download.cgi (Binary zip archive)  
	Após instalar, configurar nas variáveis de ambiente  
MariaDB 11.4.5 - Disponível em:  https://mariadb.org/download/?t=mariadb&p=mariadb&r=11.4.5&os=windows&cpu=x86_64&pkg=zip&mirror=fder  


# CONFIGURAÇÕES NECESSÁRIAS

ACESSO DA APLICAÇÃO AO BANCO DE DADOS:  
Criar o arquivo application-dev.properties em src/main/resources/ com credenciais (usuário e senha) do seu banco de dados local de acordo com os parâmetros informados no momento da instalação do MariaDB.  
Após, mapear o arquivo em .gitignore (pois não deverá ser commitado no repositório remoto) passando o path em que o arquivo se encontra.  
O Spring fará a leitura dos arquivos application.properties e application-dev.properties, respectivamente, sobrescrevendo o application.properties com o que for encontrado em application-dev.properties.  