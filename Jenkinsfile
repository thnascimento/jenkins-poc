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
              sh 'docker build . --tag ${env.service}:${env.BUILD_ID} --build-arg JAR_FILE=/build/libs/jenkins-poc-0.0.1-SNAPSHOT'
              sh 'docker run ${env.service}:${env.BUILD_ID}'
            }
        }
    }
}
