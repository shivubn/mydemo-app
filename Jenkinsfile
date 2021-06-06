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
            }
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
                   docker build -t myweb-app . -f mydockerfile
                   '''
				   }
				   
		   }
}
}
}
