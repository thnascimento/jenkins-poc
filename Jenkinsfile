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
              sh 'docker build . --tag ${env.service}:${env.BUILD_ID} --build-arg JAR_FILE=/build/libs/jenkins-poc-0.0.1-SNAPSHOT.jar'
              sh 'docker run -d -p 9000:9000 ${env.service}:${env.BUILD_ID}'
            }
        }
    }
}
