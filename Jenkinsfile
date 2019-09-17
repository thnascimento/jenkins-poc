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
              sh 'docker build . --tag jenkins-poc:0.0.1 --build-arg JAR_FILE=/build/libs/jenkins-poc-0.0.1-SNAPSHOT.jar'
              sh 'docker run jenkins-poc:0.0.1'
            }
        }
    }
}
