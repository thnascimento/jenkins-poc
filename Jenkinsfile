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
                def image = docker.build("poc-jenkins:${env.BUILD_ID}")
                sh 'docker run poc-jenkins:{$env.BUILD_ID}'
            }
        }
    }
}
