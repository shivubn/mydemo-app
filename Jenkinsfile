pipeline{
    agent any
    tools{
        maven 'maven3.6'
        jdk 'java8'
        dockerTool 'docker'
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
                    mvn clean package
                    ls -ltr target/
                    '''
                }
            }
        }
        stage('docker build'){
            steps{
                script{
                  sh '''
                  docker build -t mywebimage -f dockerfile
                  '''
               }
          }
       }
    }
}

