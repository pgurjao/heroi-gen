pipeline {
    agent any 
    stages {
        stage('Build') { 
            steps {
                sh 'mvn -f pom.xml -DoutputDirectory=~/heroi-gen -B -DskipTests clean package'
                
            }
        }
        stage('Deploy') { 
            steps {
				// sh 'PM2_HOME=\'/home/ubuntu/.pm2\' pm2 delete heroi'
            	dir('/home/ubuntu/') {
            		echo 'Destruindo instancia atual'
            		sh './destroyHeroiInstance.sh'
            		echo 'Instancia destruida com sucesso'
            		
            		echo 'Deletando .jar antigo'
            		sh './removeHeroiJar.sh'
            		echo 'Jar deletado com sucesso'
            		
            		echo 'Copiando .jar novo para pasta definitiva'
            		sh 'cp /var/lib/jenkins/workspace/heroi-gen/target/heroi*.jar /home/ubuntu/heroi-gen/heroi.jar'
            		echo 'Jar copiado com sucesso'
            		
            		echo 'Subindo instancia nova'
					sh './runHeroi.sh'
					echo 'Instancia nova executada com sucesso'
				}
            }
        }
    }
    // post {
	//	success {
	//		echo 'Esteira finalizada com sucesso!'
     //   }
	//	failure {
	//		echo 'Esteira falhou...'
     //   }
    // }
}