pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh './gradlew clean build'
            }
        }

        stage('Artifact') {
            steps {
              dir("build/libs/") {
                sh "pwd"
                script {
                  env.artifact = 'jenkins-poc-0.0.1-SNAPSHOT.jar'
                }
              }
            }
        }

        stage('Docker image') {
            steps {
                sh 'docker.build . jenkins-poc-app:0.0.1-SNAPSHOT","--build-arg JAR_FILE=${env.artifact} -f Dockerfile .'
            }
        }

        stage('Deploy') {
            steps {
                sh 'docker run --name jenkins-poc-app jenkins-poc-app:0.0.1-SNAPSHOT'
            }
        }
    }
}