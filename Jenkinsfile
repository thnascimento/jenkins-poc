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
               script {
                def serviceImage = docker.build("jenkins-poc:0.0.1","--build-arg JAR_FILE=/build/libs/jenkins-poc-0.0.1-SNAPSHOT.jar -f Dockerfile .")
                serviceImage.run()
              }
//               sh 'docker run jenkins-poc:0.0.1'
            }
        }
    }
}
