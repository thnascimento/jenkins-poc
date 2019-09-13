pipeline {
    agent any

    environment {
      HEROKU_API_KEY = '$HEROKU_API_KEY'
    }
    stages {

        stage('Build') {
            steps {
                sh './gradlew clean build'
            }
        }

        stage('Deploy') {
            steps {
                image 'ruby:2.3'
                sh 'apt update -qq'
                sh 'apt install -qq -y ruby'
                sh 'gem install -q dpl'
                sh 'dpl --provider=heroku --app=jenkins-poc --api-key=$HEROKU_API_KEY'
            }
        }
    }
}