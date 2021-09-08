shiva :wq
pipeline{
    agent {
        label "master"
    }
    tools{
        maven 'maven3.8.1'
        jdk 'java8'        
    }  
stages{
        stage('clone'){
            steps{
                git credentialsId: 'github', url: 'https://github.com/Prakashja/web-app.git'
            }}
        }
        stage('build'){
            steps{
                script{
                    sh '''
                    mvn clean package -Dmaven.test.skip=true
                    ls -ltr target/
                    '''
                }
            }
        }
    stage('docker build'){
        steps{
            script{
                sh '''
                   sudo docker build -t sana03/mywebapp:1.0.0 . -f mydockerfile
                   '''
				   }
				   
		   }
}
    stage('docker push'){
        steps{
            script{
                sh '''
                   sudo docker push sana03/mywebapp:1.0.0
                   '''
				   }
				   
		   }
}
}
}
