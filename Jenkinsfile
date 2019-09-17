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
                  env.artifact = sh(returnStdout: true, script: 'ls *.jar |  tr -d \'[:space:]\' ')
                }
                stash includes: "${env.artifact}", name: 'artefato'
                archiveArtifacts artifacts: "${env.artifact}", fingerprint: true
              }
            }
        }

        stage('Deploy') {
            steps {
              unstash 'artefato'
              script {
                  def serviceImage = docker.build("${env.service}:${env.BUILD_ID}","--build-arg JAR_FILE=${env.artifact} -f Dockerfile .")
                  sh 'docker run ${env.service}:${env.BUILD_ID}'
              }
            }
        }
    }
}
