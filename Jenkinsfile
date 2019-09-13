pipeline {
    agent any
    stages {

        stage('Build') {
            steps {
                sh './gradlew clean build'
            }
        }

        stage('Deploy') {
            image 'ruby:2.3'
            HEROKU_API_KEY '$HEROKU_API_KEY'

            steps {
                sh 'apt update -qq'
                sh 'apt install -qq -y ruby'
                sh 'gem install -q dpl'
                sh 'dpl --provider=heroku --app=jenkins-poc --api-key=$HEROKU_API_KEY'
            }
        }
    }
}