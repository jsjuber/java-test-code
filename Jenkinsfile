pipeline {
    agent {
        docker { image 'node:7-alpine' }
    }
    stages {
        stage('Test') {
            steps {
                sh '''
                 docker run -dit node:7-alpine /bin/sh
                '''
            }
        }
    }
}
