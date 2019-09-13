pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh './gradlew clean build'
            }
        }

        stage('Deploy') {
            steps {
                sh 'mkdir /home/thiago/Workspace/Pocs/Poc_jenkins/deploy'
                sh 'cp build/libs/jenkins-poc-0.0.1-SNAPSHOT.jar /home/thiago/Workspace/Pocs/Poc_jenkins/deploy'
                sh 'cd /home/thiago/Workspace/Pocs/Poc_jenkins/deploy'
                sh 'java -jar jenkins-poc-0.0.1-SNAPSHOT.jar'
            }
        }
    }
}
